<!-- Layout base para el armado de las diferentes paginas -->

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>
   <tiles:insertAttribute name="header" /><br/>
   <tiles:insertAttribute name="body" /><br/>
   <tiles:insertAttribute name="footer" /><br/>
</body>
</html>