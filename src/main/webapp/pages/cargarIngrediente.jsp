<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Nahuel
  Date: 11/2/2018
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
        <title>Cargar Ingrediente</title>
    </head>
    <body>
        <div class="container">
            <form action="<s:url action="CargarIngrediente"/>" class="form-signin">
                <h2 class="form-signin-heading">Carga de Ingrediente</h2>
                    <div class="form-group">
                        <label>Nombre:</label>
                        <s:textfield name="ingrediente.nombre" id="nombreText" class="form-control"></s:textfield>
                    </div>
                    <div class="form-group">
                        <label>Descripcion:</label>
                        <s:textfield name="ingrediente.descripcion" id="descripcionText" class="form-comtrol"></s:textfield>
                    </div>
                    <div class="form-group">
                        <label>Advertencia:</label>
                        <s:radio name="ingrediente.conAdvertencia" list="#{'true':'Si','false':'No'}" value="false" />
                    </div>
                    <div class="form-group">
                        <button id="botonCargar" type="submit" class="btn btn-default">Cargar</button>
                    </div>
            </form>
        </div>
    </body>
</html>
