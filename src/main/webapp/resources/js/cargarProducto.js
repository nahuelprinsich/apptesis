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
        valoresEnergeticos = valoresEnergeticos + tablaValores[i].idValorEnergetico + "-";
        if($.isNumeric(tablaValores[i].valor)){
            valoresEnergeticos = valoresEnergeticos + tablaValores[i].valor + "&";
        } else {
            valoresEnergeticos = valoresEnergeticos + "0" + "&";
        }

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
            nombreProducto: $("#nombreProducto").val().toLowerCase(),
            rubroProducto: $("#rubroProducto").val().toLowerCase(),
            codigoBarraProducto: $("#codigoBarraProducto").val(),
            porcionProducto: $("#porcionProducto").val(),
            tipoPorcionProducto: $("#tipoPorcionProducto").val(),
            marcaProducto: $("#marcaProducto").val().toLowerCase(),
            contenidoNetoProducto: $("#contenidoNetoProducto").val().toLowerCase(),
            esAlimentoProducto: $("#esAlimentoProducto").is(":checked"),
            descripcionProducto: $("#descripcionProducto").val().toLowerCase(),
            tipoRubroProducto: $("#tipoRubroProducto").val(),
            urlImagenProducto: $("#urlImagenProducto").val(),

            descripcionEnvase: $("#descripcionEnvase").val().toLowerCase(),
            caracteristicaRetornable: $("#caracteristicaRetornable").val(),
            caracteristicaReutilizable: $("#caracteristicaReutilizable").val(),
            caracteristicaReciclable: $("#caracteristicaReciclable").val(),
            caracteristicaCompostable: $("#caracteristicaCompostable").val(),
            caracteristicaMP: $("#caracteristicaMP").val(),
            caracteristicaCO: $("#caracteristicaCO").val(),

            razonSocialFabricante: $("#razonSocialFabricante").val().toLowerCase(),

            nombreUsuario: $("#nombreUsuario").val().toLowerCase(),
            apellidoUsuario: $("#apellidoUsuario").val().toLowerCase()
        },
        success: function () {
            location.reload();
        }
    })

    return false;

}

function cargarTablas() {
    cargarTablaIngredientes();
    cargarTablaValores();
    cargarTablaExtras();
}

function cargarTablaIngredientes() {
    var resultIngredientes;
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
        dom: 'Bfrtip',
        "bLengthChange": false,
        "pageLength": 10,
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
            { "data": "tipoRubro" }
        ],
        buttons: [
            {
                text: "Agregar",
                action: function () {
                    $('#modalIngrediente').modal('show');
                }
            }
        ]
    } );
}

function cargarTablaValores() {
    var resultValores;
    var tablaValoresE;
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
        dom: 'Bfrtip',
        "bLengthChange": false,
        "pageLength": 10,
        "data": resultValores,
        "columnDefs": [{
            "defaultContent": "Ingrese un valor",
            "targets": "_all"
        }],
        "columns": [
            { "data": "idValorEnergetico" },
            { "data": "nombre" },
            { "data": "descripcion" },
            { "data": "recomendableDiario" },
            { "data": "tipoPorcion" },
            { "data": "valor" }
        ],
        buttons: [
            {
                text: "Agregar",
                action: function () {
                    $('#modalValorEnergetico').modal('show');
                }
            }
        ]
    } );
    tablaValoresE.MakeCellsEditable({
        "onUpdate": myCallbackFunction,
        "columns": [5],
        "inputTypes": [
            {
                "column": 5,
                "type": "text",
                "options": null
            }
        ]
    });
}

function cargarTablaExtras() {
    var resultExtras;
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
        dom: 'Bfrtip',
        "bLengthChange": false,
        "pageLength": 10,
        "data": resultExtras,
        "columnDefs": [{
            "defaultContent": "-",
            "targets": "_all"
        }],
        "columns": [
            { "data": "idExtra" },
            { "data": "descripcion" },
            { "data": "tipoRubro"}
        ],
        buttons: [
            {
                text: "Agregar",
                action: function () {
                    $('#modalExtra').modal('show');
                }
            }
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
            nombreIngrediente: $("#nombreIngrediente").val().toLowerCase(),
            descripcionIngrediente: $("#descripcionIngrediente").val().toLowerCase(),
            linkIngrediente: $("#linkIngrediente").val(),
            tipoRubroIngrediente: $("#tipoRubroIngrediente option:selected").text(),
            conAdvertenciaIngrediente: $("#conAdvertenciaIngrediente").val()
        },
        success: function () {

        }
    });

    location.reload();
}

function cargarValorEnergetico() {
    $.ajax({
        type: "POST",
        url: "CargarValorEnergetico",
        data: {
            nombreValorEnergetico: $("#nombreValorEnergetico").val().toLowerCase(),
            descripcionValorEnergetico: $("#descripcionValorEnergetico").val().toLowerCase(),
            recomendableValorEnergetico: $("#recomendableValorEnergetico").val(),
            tipoPorcionValorEnergetico: $("#tipoPorcionValorEnergetico option:selected").text(),
            linkValorEnergetico: $("#linkValorEnergetico").val()
        },
        success: function () {

        }
    });

    location.reload();
}

function cargarExtra() {
    $.ajax({
        type: "POST",
        url: "CargarExtra",
        data: {
            descripcionExtra: $("#descripcionExtra").val().toLowerCase(),
            urlLogo: $("#urlLogo").val(),
            tipoRubroExtra: $("#tipoRubroExtra option:selected").text()
        },
        success: function () {

        }
    });

    location.reload();
}