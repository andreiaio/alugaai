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

<title>Cadastro</title>

<spring:url value="/resources/css/bootstrap.min.css" var="boostrapCSS" />
<spring:url value="/resources/css/bootstrap-theme.min.css" var="boostrapThemeCSS" />
<spring:url value="/resources/css/style.css" var="styleCSS" />

<link href="${boostrapCSS}" rel="stylesheet" />
<link href="${boostrapThemeCSS}" rel="stylesheet" />
<link href="${styleCSS}" rel="stylesheet" />

<script type="text/javascript">
	function Redirecionar() {
		window.location.href = "home";
	}
</script>

</head>
<body>

	<div class="row">
		<div class="well col-md-4 col-md-offset-4">
		<h1 class="text-center">Nova Conta</h1>
		<c:if test="${not empty message}">
			<div class="alert alert-danger" role="alert">
			  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			  Atenção, corrija os erros abaixo e tente novamente:
			  </br>
			  ${message}
			</div>
		</c:if>	
		
			<form name="createaccount" action="createaccount" method="POST" >
				<div class="form-group">
					<label for="exampleInputEmail1">Email</label>
					<input type="email" class="form-control" name="email">
				</div>
				<div class="form-group">
					<label for="password">Senha</label>
					<input type="password" class="form-control" name="password">
				</div>

				<div class="form-group">
					<label for="name">Nome Completo</label> 
					<input type="text" class="form-control" name="name">
				</div>

				<div class="form-group">
					<label for="cpf">CPF</label> 
					<input type="text" class="form-control" name="cpf">
				</div>
				<div class="form-group">
					<label for="celular">Celular</label>
					<input type="text" class="form-control" name="celular">
				</div>
				<div class="form-group">
					<label for="cep">CEP</label>
					<input type="text" class="form-control" name="cep">
				</div>
				<div class="form-group">
					<label for="endereco">Endereço</label>
					<input type="text" class="form-control" name="endereco">
				</div>
				<div class="form-group">
					<label for="cidade">Cidade</label>
					<input type="text" class="form-control" name="cidade">
				</div>
				<div class="form-group">
					<label for="bairro">Bairro</label>
					<input type="text" class="form-control" name="bairro">
				</div>
				<div class="form-group">
					<label for="estado">Estado</label>
					<input type="text" class="form-control" name="estado">
				</div>
				<button type="submit" class="btn btn-primary btn-block">Criar Conta</button>
			</form>
		</div>
	</div>


	<spring:url value="/resources/js/jquery-1.12.1.min.js" var="jquery" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
	<script src="${jquery}"></script>
	<script src="${bootstrapJS}"></script>

</body>
</html>