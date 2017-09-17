<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>asasdasdsd</title>

<spring:url value="/resources/css/bootstrap.min.css" var="boostrapCSS" />
<spring:url value="/resources/css/bootstrap-theme.min.css" var="boostrapThemeCSS" />
<spring:url value="/resources/css/style.css" var="styleCSS" />

<link href="${boostrapCSS}" rel="stylesheet" />
<link href="${boostrapThemeCSS}" rel="stylesheet" />
<link href="${styleCSS}" rel="stylesheet" />

<script type="text/javascript">
	function Redirecionar() {
		var nomeInformado = prompt("Favor informar um nome: ", "");
		window.location.href = "welcome/home?nome=" + nomeInformado;
	}
</script>

</head>
<body>

	<center>
		<h2>TROCA TROCA</h2>
		<a class="btn btn-default" href="#" onclick="Redirecionar();">LOGAR</a>
	</center>
	
	<spring:url value="/resources/js/jquery-1.12.1.min.js" var="jquery" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
	<script src="${jquery}"></script>
	<script src="${bootstrapJS}"></script>

</body>
</html>