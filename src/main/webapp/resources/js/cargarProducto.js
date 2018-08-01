/**
 * Created by Nahuel on 30/4/2018.
 */

$(document).ready(function() {
    cargarTablas();

    $('#tablaIngredientes tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
    } );

    $('#tablaValores tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
    } );

    $('#tablaExtras tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
    } );
} );

function cargaProducto(){
    var ingredientes = "";
    var valoresEnergeticos = "";
    var informaciones = "";
    var tablaIngredientes = $('#tablaIngredientes').DataTable().rows('.selected').data();
    var tablaValores = $('#tablaValores').DataTable().rows('.selected').data();
    var tablaExtras = $('#tablaExtras').DataTable().rows('.selected').data();

    for (var i = 0; i < tablaIngredientes.length; i++) {
        ingredientes = ingredientes + tablaIngredientes[i].idIngrediente + "&";
    }

    for (var i = 0; i < tablaValores.length; i++) {
        valoresEnergeticos = valoresEnergeticos + tablaValores[i].idValorEnergetico + "-" + tablaValores[i].valor + "&";
    }

    for (var i = 0; i < tablaExtras.length; i++) {
        informaciones = informaciones + tablaExtras[i].idExtra + "&";
    }

    $.ajax({
        type: "POST",
        url: "CargarProducto",
        data: {
            ingredientes: ingredientes,
            valoresEnergeticos: valoresEnergeticos,
            informaciones: informaciones,
            nombreProducto: $("#nombreProducto").val(),
            rubroProducto: $("#rubroProducto").val(),
            codigoBarraProducto: $("#codigoBarraProducto").val(),
            porcionProducto: $("#porcionProducto").val(),
            tipoPorcionProducto: $("#tipoPorcionProducto").val(),
            marcaProducto: $("#marcaProducto").val(),
            contenidoNetoProducto: $("#contenidoNetoProducto").val(),
            esAlimentoProducto: $("#esAlimentoProducto").is(":checked"),
            descripcionProducto: $("#descripcionProducto").val(),
            tipoRubroProducto: $("#tipoRubroProducto").val(),
            urlImagenProducto: $("#urlImagenProducto").val(),

            descripcionEnvase: $("#descripcionEnvase").val(),
            urlImagen: $("#urlImagen").val(),
            caracteristicaRetornable: $("#caracteristicaRetornable").val(),
            caracteristicaReutilizable: $("#caracteristicaReutilizable").val(),
            caracteristicaReciclable: $("#caracteristicaReciclable").val(),
            caracteristicaCompostable: $("#caracteristicaCompostable").val(),
            caracteristicaMP: $("#caracteristicaMP").val(),
            caracteristicaCO: $("#caracteristicaCO").val(),

            razonSocialFabricante: $("#razonSocialFabricante").val()
        },
        success: function () {

        }
    })

    return false;

}

function cargarTablas() {
    var resultIngredientes;
    var resultValores;
    var resultExtras;
    var tablaValoresE;

    $.ajax({
        type: "GET",
        //url: "http://localhost:8080/proyecto-tesis/getAllIngredientes.json",
        url: "http://apptesis-apptesis.7e14.starter-us-west-2.openshiftapps.com/proyecto-tesis/getAllIngredientes.json",
        dataType: "json",
        async: false,
        success : function(data) {
            resultIngredientes = data;
        }
    });

    $('#tablaIngredientes').DataTable( {
        "bLengthChange": false,
        "data": resultIngredientes,
        "columnDefs": [{
            "defaultContent": "-",
            "targets": "_all"
        }],
        "columns": [
            { "data": "idIngrediente" },
            { "data": "nombre" },
            { "data": "descripcion" },
            { "data": "conAdvertencia" },
            { "data": "linkInformacionExtra" },
            { "data": "tipoRubro" }
        ],
            "buttons": [
                {
                    text: 'Nuevo',
                    action: function ( e, dt, node, config ) {
                        $('#modalIngrediente').modal('show');
                    }
                }
            ]
    } );

    $.ajax({
        type: "GET",
        //url: "http://localhost:8080/proyecto-tesis/getAllValoresEnergeticos.json",
        url: "http://apptesis-apptesis.7e14.starter-us-west-2.openshiftapps.com/proyecto-tesis/getAllValoresEnergeticos.json",
        dataType: "json",
        async: false,
        success : function(data) {
            resultValores = data;
        }
    });

    tablaValoresE = $('#tablaValores').DataTable( {
        "bLengthChange": false,
        "data": resultValores,
        "columnDefs": [{
            "defaultContent": "-",
            "targets": "_all"
        }],
        "columns": [
            { "data": "idValorEnergetico" },
            { "data": "nombre" },
            { "data": "descripcion" },
            { "data": "recomendableDiario" },
            { "data": "tipoPorcion" },
            { "data": "linkInformacionExtra" },
            { "data": "valor" }
        ]
    } );
    tablaValoresE.MakeCellsEditable({
        "onUpdate": myCallbackFunction,
        "columns": [6],
        "inputTypes": [
            {
                "column": 6,
                "type": "text",
                "options": null
            }
        ]
    });

    $.ajax({
        type: "GET",
        //url: "http://localhost:8080/proyecto-tesis/getAllExtras.json",
        url: "http://apptesis-apptesis.7e14.starter-us-west-2.openshiftapps.com/proyecto-tesis/getAllExtras.json",
        dataType: "json",
        async: false,
        success : function(data) {
            resultExtras = data;
        }
    });

    $('#tablaExtras').DataTable( {
        "bLengthChange": false,
        "data": resultExtras,
        "columnDefs": [{
            "defaultContent": "-",
            "targets": "_all"
        }],
        "columns": [
            { "data": "idExtra" },
            { "data": "descripcion" },
            { "data": "urlLogo" }
        ]
    } );
}

function myCallbackFunction (updatedCell, updatedRow, oldValue) {
    console.log("The new value for the cell is: " + updatedCell.data());
    console.log("The old value for that cell was: " + oldValue);
    console.log("The values for each cell in that row are: " + updatedRow.data());
}

function cargarIngrediente() {

    $.ajax({
        type: "POST",
        url: "CargarIngrediente",
        data: {
            nombreIngredientes: $("#nombreIngredientes").val(),
            descripcionIngrediente: $("#descripcionIngrediente").val(),
            linkIngrediente: $("#linkIngrediente").val(),
            tipoRubroIngrediente: $("#tipoRubroIngrediente").val(),
            conAdvertenciaIngrediente: $("#conAdvertenciaIngrediente").val()
        },
        success: function () {

        }
    });

    $('#tablaIngredientes').DataTable().destroy();
    cargarTablas();

    return false;
}

function cargarValorEnergetico() {
    $.ajax({
        type: "POST",
        url: "CargarValorEnergetico",
        data: {
            nombreValorEnergetico: $("#nombreValorEnergetico").val(),
            descripcionValorEnergetico: $("#descripcionValorEnergetico").val(),
            recomendableValorEnergetico: $("#recomendableValorEnergetico").val(),
            tipoPorcionValorEnergetico: $("#tipoPorcionValorEnergetico").val(),
            linkValorEnergetico: $("#linkValorEnergetico").val()
        },
        success: function () {

        }
    });

    $('#tablaValores').DataTable().destroy();
    cargarTablas()

    return false;
}

function cargarExtra() {
    $.ajax({
        type: "POST",
        url: "CargarExtra",
        data: {
            descripcionExtra: $("#descripcionExtra").val(),
            urlLogo: $("#urlLogo").val(),
            tipoRubroExtra: $("#tipoRubroExtra").val()
        },
        success: function () {

        }
    });

    $('#tablaExtras').DataTable().destroy();
    cargarTablas();

    return false;
}