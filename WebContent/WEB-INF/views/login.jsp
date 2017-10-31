<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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

<title>Aluga Aí</title>

<spring:url value="/resources/css/bootstrap.min.css" var="boostrapCSS" />
<spring:url value="/resources/css/bootstrap-theme.min.css"	var="boostrapThemeCSS" />
<spring:url value="/resources/css/style.css" var="styleCSS" />
<spring:url value="/resources/images/" var="images" />

<link href="${boostrapCSS}" rel="stylesheet" />
<link href="${boostrapThemeCSS}" rel="stylesheet" />
<link href="${styleCSS}" rel="stylesheet" />

<script type="text/javascript">
	function Redirecionar() {
		window.location.href = "cadastro";
	}

</script>

</head>
<body>

	<div class="row">
		<div class="well col-md-4 col-md-offset-4">
			<div class="text-center">
				<img class="logologin" src="${images}/logologin.png">
			</div>
			<form name="performLogin" action="performLogin" method="POST" >
				<div class="form-group">
					<label for="email">Email</label>
					<input type="email" class="form-control" name="email" placeholder="Email">
				</div>
				<div class="form-group">
					<label for="password">Senha</label> 
					<input type="password" class="form-control" name="password" placeholder="Password">
				</div>
				<c:if test="${not empty message}">
					<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			 		 ${message}
					</div>
				</c:if>	
				
				<button type="submit" class="btn btn-success btn-block">Entrar</button>
				<!-- <button type="button" class="btn btn-link btn-block">Esqueci Minha Senha</button> -->
				<button type="button" class="btn btn-default btn-block" onclick="Redirecionar();">Criar Conta</button>

			</form>
		</div>
	</div>


	<spring:url value="/resources/js/jquery-1.12.1.min.js" var="jquery" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
	<script src="${jquery}"></script>
	<script src="${bootstrapJS}"></script>

</body>
</html>