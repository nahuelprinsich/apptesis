<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
        <script src="resources/js/index.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.4.1/css/buttons.dataTables.min.css">
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/dataTables.buttons.min.js"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.flash.min.js"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.html5.min.js"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.1/js/buttons.print.min.js"></script>
        <title>Index</title>
    </head>
    <body>
        <div class="container">
            <div class="col-md-6 col-md-offset-3">
                <s:form name="adminForm" action="#" method="post" class="form-signin">
                    <fieldset><legend align="center">Administracion</legend>
                        <div class="col-md-8 col-md-offset-2">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <a href="cargarProducto.jsp"><button class="btn btn-default inputLogin inputIndex" type="button">Cargar Producto</button></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8 col-md-offset-2">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <table id="tablaProductos" class="table table-striped table-bordered">
                                        <thead>
                                        <tr>
                                            <th class="th">Id</th>
                                            <th>Producto</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </s:form>
            </div>
        </div>
    </body>
</html>
