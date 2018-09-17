$(document).ready(function() {
    cargarTablaProductos();

    $('.botonEditar').click(function() {
        var $row = $(this).closest("tr"),
            $tds = $row.find("td:nth-child(1)");

        $.each($tds, function() {
            window.location="cargarProducto.jsp?id=" + $(this).text();
        });
    });

    $('.botonEliminar').click(function() {
        var $row = $(this).closest("tr"),
            $tds = $row.find("td:nth-child(1)");

        $.each($tds, function() {
            $.ajax({
                type: "POST",
                url: "EliminarProducto",
                data: {
                    idProducto: $(this).text()
                },
                success: function () {
                    location.reload();
                }
            })
        });
    });
} );

function cargarTablaProductos() {
    var resultProductos;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/proyecto-tesis/getAllProductos.json",
        //url: "http://apptesis-apptesis.7e14.starter-us-west-2.openshiftapps.com/proyecto-tesis/getAllProductos.json",
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
            { "data": "usuario.apellido" },
            { "data": null }
        ],
        columnDefs: [
            {
                targets: -1, //-1 es la ultima columna y 0 la primera
                data: null,
                defaultContent: '<div class="container-fluid"><div class="row"><div class="col"> <button type="button" class="btn btn-primary btn-xs dt-edit botonEditar" style="margin-right:16px;"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></div><div class="col"><button type="button" class="btn btn-danger btn-xs dt-delete botonEliminar"><span class="glyphicon glyphicon-remove glyphicon-trash" aria-hidden="true"></span></button></div></div></div>'
            }
        ],
        "buttons": []
    } );
}