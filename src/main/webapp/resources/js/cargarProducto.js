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

    $("#selectIngrediente option").each(function()
    {
        ingredientes = ingredientes + $(this).text() + "&";
    });

    $("#selectValor option").each(function()
    {
        valoresEnergeticos = valoresEnergeticos + $(this).text() + "&";
    });

    $("#selectInformacion option").each(function()
    {
        informaciones = informaciones + $(this).text() + "&";
    });

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

            tipoEnvase: $("#tipoEnvase").val(),
            descripcionEnvase: $("#descripcionEnvase").val(),
            ftalatosEnvase: $("#ftalatosEnvase").is(":checked"),
            retornableEnvase: $("#retornableEnvase").is(":checked"),
            reutilizableEnvase: $("#reutilizableEnvase").is(":checked"),
            marcadoEnvase: $("#marcadoEnvase").is(":checked"),
            reciclableEnvase: $("#reciclableEnvase").is(":checked"),
            aptoConsumoEnvase: $("#aptoConsumoEnvase").is(":checked"),

            razonSocialFabricante: $("#razonSocialFabricante").val(),
            domicilioFabricante: $("#domicilioFabricante").val(),
            localidadFabricante: $("#localidadFabricante").val(),
            paisFabricante: $("#paisFabricante").val()
        },
        success: function () {

        }
    })

    return false;

}

function agregarIngrediente(){
    var ingrediente = $("#nombreIngrediente").val() + "-" + $("#descripcionIngrediente").val() + "-";
    if($("#conAdvertenciaIngredientetrue").is(':checked')){
        ingrediente = ingrediente + "true"
    } else {
        ingrediente = ingrediente + "false"
    }
    var value = Math.floor((Math.random() * 100) + 1);
    $("#selectIngrediente").append($("<option></option>").attr("value", value).text(ingrediente));
}

function agregarValorEnergetico(){
    var valor = $("#nombreValorEnergetico").val() + "-" + $("#descripcionValorEnergetico").val() + "-" + $("#recomendableValorEnergetico").val() + "-" + $("#valorValorEnergetico").val() + "-" + $("#tipoPorcionValorEnergetico").val();
    var value = Math.floor((Math.random() * 100) + 1);
    $("#selectValor").append($("<option></option>").attr("value", value).text(valor));
}

function agregarInformacionExtra(){
    var informacion = $("#descripcionExtra").val();
    var value = Math.floor((Math.random() * 100) + 1);
    $("#selectInformacion").append($("<option></option>").attr("value", value).text(informacion));
}

function quitarIngrediente() {
    $("#selectIngrediente").find(":selected").remove();
}

function quitarValorEnergetico() {
    $("#selectValor").find(":selected").remove();
}

function quitarInformacionExtra() {
    $("#selectInformacion").find(":selected").remove();
}

function buscarIngredientes() {
    $.ajax({
        type: "POST",
        url: "BuscarIngrediente",
        data: {
            nombreIngrediente: $("#buscarIngrediente").val()
        },
        success: function (ingrediente) {
            for(var i=0; i < ingrediente.listaBusqueda.length; i++){
                console.log(ingrediente.listaBusqueda[i].nombre);
            }
        }
    })
}


function cargarTablas() {
    var resultIngredientes;
    var resultValores;
    var resultExtras;

    $.ajax({
        type: "GET",
        url: "http://apptesis-apptesis.7e14.starter-us-west-2.openshiftapps.com/proyecto-tesis/getAllIngredientes.json",
        dataType: "json",
        async: false,
        success : function(data) {
            resultIngredientes = data;
        }
    });

    $('#tablaIngredientes').DataTable( {
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
        ]
    } );

    $.ajax({
        type: "GET",
        url: "http://apptesis-apptesis.7e14.starter-us-west-2.openshiftapps.com/proyecto-tesis/getAllValoresEnergeticos.json",
        dataType: "json",
        async: false,
        success : function(data) {
            resultValores = data;
        }
    });

    $('#tablaValores').DataTable( {
        "data": resultValores,
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
        ]
    } );

    $.ajax({
        type: "GET",
        url: "http://apptesis-apptesis.7e14.starter-us-west-2.openshiftapps.com/proyecto-tesis/getAllExtras.json",
        dataType: "json",
        async: false,
        success : function(data) {
            resultExtras = data;
        }
    });

    $('#tablaExtras').DataTable( {
        "data": resultExtras,
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
        ]
    } );
}