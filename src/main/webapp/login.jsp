<!-- Template login -->

<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body onload="ocultarLogout()">
		<div class="container">
			<div class="col-md-6 col-md-offset-3">
				<s:form name="loginForm" action="j_spring_security_check" method="post" class="form-signin">
	    			<fieldset><legend align="center">Login</legend>
	    			<div class="col-md-4 col-md-offset-4">
	    			<div class="form-group">
	    				<div class="col-md-12">
	    					<s:if test="%{#parameters.error != null}">
	    						<label class="control-label" style="color: red">Usuario incorrecto</label>
	    					</s:if>
	    				</div>
	    			</div>
	    			</div>
	    			<div class="col-md-10 col-md-offset-1">
	    				<div class="form-group">
	    					<div class="col-md-12">
	    						<input type="text" class="form-control inputLogin" name="username" placeholder="Usuario">
	    					</div>
	    				</div>
	    			</div>
	    			<div class="col-md-10 col-md-offset-1">
	    				<div class="form-group">
	    					<div class="col-md-12">
	    						<input type="password" class="form-control inputLogin" name="password" placeholder="Contraseña">
	    					</div>
	    				</div>
	    			</div>
	    			<div class="col-md-10 col-md-offset-1">
	    				<div class="form-group">   
            				<div class="col-md-12">
								<button type="submit" class="btn btn-default" id="botonLogin">Ingresar</button>
							</div>
						</div>
					</div>
					</fieldset>
				</s:form>
			</div>
		</div>
	</body>
</html>