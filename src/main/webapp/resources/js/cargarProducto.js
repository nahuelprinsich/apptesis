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

    if(obtenerParametro() != null){
        $.ajax({
            type: "GET",
            //url: "ModificarProducto",
            //url: "http://localhost:8080/proyecto-tesis/getProductoById.json?id=" + obtenerParametro(),
            url: "http://apptesis-apptesis.7e14.starter-us-west-2.openshiftapps.com/proyecto-tesis/getProductoById.json?id=" + obtenerParametro(),
            dataType: "json",
            async: false,
            /*data: {
                idProducto: obtenerParametro()
            },*/
            success: function (data) {
                $("#nombreProducto").val(data["nombreProducto"]);
                $("#rubroProducto").val(data["rubro"]);
                $("#tipoRubroProducto option:contains(" + data["tipoRubro"] + ")").attr('selected', 'selected');
                $("#codigoBarraProducto").val(data["codigoBarra"]);
                $("#porcionProducto").val(data["porcion"]);
                $("#tipoPorcionProducto option:contains(" + data["tipoPorcion"] + ")").attr('selected', 'selected');
                $("#marcaProducto").val(data["marca"]);
                $("#contenidoNetoProducto").val(data["contenidoNeto"]);
                $("#urlImagenProducto").val(data["urlImagen"]);
                $("#esAlimentoProducto").val(data["esAlimento"]);
                $("#descripcionEnvase").val(data["envase"].descripcion);
                $("#caracteristicaRetornable option:contains(" + data["envase"].caracteristicasEnvase[2].descripcion + ")").attr('selected', 'selected');
                $("#caracteristicaReutilizable option:contains(" + data["envase"].caracteristicasEnvase[1].descripcion + ")").attr('selected', 'selected');
                $("#caracteristicaReciclable option:contains(" + data["envase"].caracteristicasEnvase[3].descripcion + ")").attr('selected', 'selected');
                $("#caracteristicaCompostable option:contains(" + data["envase"].caracteristicasEnvase[0].descripcion + ")").attr('selected', 'selected');
                $("#caracteristicaMP option:contains(" + data["envase"].caracteristicasEnvase[5].descripcion + ")").attr('selected', 'selected');
                $("#caracteristicaCO option:contains(" + data["envase"].caracteristicasEnvase[4].descripcion + ")").attr('selected', 'selected');
                $("#razonSocialFabricante").val(data["fabricante"].nombre);
                $("#nombreUsuario").val(data["usuario"].nombre);
                $("#apellidoUsuario").val(data["usuario"].apellido);

                var tablaValores = $('#tablaValores').DataTable();
                var tablaIngredientes = $('#tablaIngredientes').DataTable();
                var tablaExtras = $('#tablaExtras').DataTable();

                tablaValores.column( 0 ).data()
                    .each( function ( value, index ) {
                        $.each(data["productoValorEnergetico"],function (index2,valor) {
                            if(valor.idProductoValorEnergetico == value ){
                                $('#tablaValores').DataTable().row(index).nodes().to$().addClass( 'selected' );
                                $('#tablaValores').DataTable().data()[index].valor = valor.valor;
                            }
                         });
                    } );

                tablaIngredientes.column( 0 ).data()
                    .each( function ( value, index ) {
                        $.each(data["ingredientes"],function (index2,valor) {
                            if(valor.idIngrediente == value ){
                                $('#tablaIngredientes').DataTable().row(index).nodes().to$().addClass( 'selected' );
                            }
                        });
                    } );

                tablaExtras.column( 0 ).data().reverse()
                    .each( function ( value, index ) {
                        $.each(data["extras"],function (index2,valor) {
                            if(valor.idExtra == value ){
                                $('#tablaExtras').DataTable().row(index).nodes().to$().addClass( 'selected' );
                            }
                        });
                    } );

            }
        })
    }

} );

function obtenerParametro(){
    urlp=[];u=location.search.replace("?","").split("&").forEach(function(d){e=d.split("=");urlp[e[0]]=e[1];});
    return urlp["id"];
}

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
            tipoPorcionProducto: $("#tipoPorcionProducto option:selected").text(),
            marcaProducto: $("#marcaProducto").val().toLowerCase(),
            contenidoNetoProducto: $("#contenidoNetoProducto").val().toLowerCase(),
            esAlimentoProducto: $("#esAlimentoProducto").is(":checked"),
            descripcionProducto: $("#descripcionProducto").val().toLowerCase(),
            tipoRubroProducto: $("#tipoRubroProducto option:selected").text(),
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
        //url: "http://localhost:8080/proyecto-tesis/getAllExtrasTabla.json",
        url: "http://apptesis-apptesis.7e14.starter-us-west-2.openshiftapps.com/proyecto-tesis/getAllExtrasTabla.json",
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