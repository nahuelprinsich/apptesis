$(document).ready(function() {
    cargarTablaProductos();
} );

function cargarTablaProductos() {
    var resultProductos;
    $.ajax({
        type: "GET",
        //url: "http://localhost:8080/proyecto-tesis/getAllProductos.json",
        url: "http://apptesis-apptesis.7e14.starter-us-west-2.openshiftapps.com/proyecto-tesis/getAllProductos.json",
        dataType: "json",
        async: false,
        success : function(data) {
            resultProductos = data;
        }
    });

    $('#tablaProductos').DataTable( {
        dom: 'Bfrtip',
        "bLengthChange": false,
        "pageLength": 15,
        "data": resultProductos,
        "columnDefs": [{
            "defaultContent": "-",
            "targets": "_all"
        }],
        "columns": [
            { "data": "idProducto" },
            { "data": "nombreProducto" },
            { "data": "usuario.nombre" },
            { "data": "usuario.apellido" }
        ],
        "buttons": []
    } );
}