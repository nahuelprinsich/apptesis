<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Nahuel
  Date: 13/1/2018
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
    <div class="container">
        <form action="<s:url action="CargarProducto"/>" class="form-horizontal">
            <fieldset><legend>Carga de Producto</legend>
                <div class="form-group">
                    <label class="control-label col-md-2">Codigo:</label>
                    <div class="col-md-4">
                        <s:textfield type="number" name="codigo" id="codigoText"></s:textfield>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-2">Fabricante:</label>
                    <div class="col-md-4">
                        <s:textfield name="fabricante" id="fabricanteText"></s:textfield>
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
