<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
        <title>Index</title>
    </head>
    <body>
        <div class="container">
            <form class="form-signin">
                <h2 class="form-signin-heading">Administracion</h2>
                <div class="form-group">
                    <a href="cargarProducto.jsp"><button class="btn btn-lg btn-primary btn-block" type="button">Cargar Productos</button></a>
                </div>
                <div class="form-group">
                    <a href="cargarIngrediente.jsp"><button class="btn btn-lg btn-primary btn-block" type="button">Cargar Ingredientes</button></a>
                </div>
            </form>
        </div>
    </body>
</html>
