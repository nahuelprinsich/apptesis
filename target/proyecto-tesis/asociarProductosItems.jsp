<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Nahuel
  Date: 11/2/2018
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Asociar</title>
</head>
<body>
<div class="container">
    <form action="<s:url action="AsociarProductoItems"/>" class="form-horizontal">
        <fieldset><legend>Asociar Productos e Items</legend>
            <div class="form-group">
                <label class="control-label col-md-2">Productos:</label>
                <div class="col-md-4">
                    <s:select list="listaProductos" name="productoSeleccionado"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2">Items:</label>
                <div class="col-md-4">
                    <s:checkboxlist list="listaItems" name="itemSeleccionado"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-md-10">
                    <button id="botonCargar" type="submit" class="btn btn-default">Cargar</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
