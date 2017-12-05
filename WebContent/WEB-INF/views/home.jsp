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

<title>Alugai</title>

<spring:url value="/resources/images/" var="images" />
<spring:url value="/resources/css/bootstrap.min.css" var="boostrapCSS" />
<spring:url value="/resources/css/bootstrap-theme.min.css" var="boostrapThemeCSS" />
<spring:url value="/resources/css/style.css" var="styleCSS" />

<link href="${boostrapCSS}" rel="stylesheet" />
<link href="${boostrapThemeCSS}" rel="stylesheet" />
<link href="${styleCSS}" rel="stylesheet" />
</head>

<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img src="${images}/logo.png"/></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="#about">Quem somos</a></li>
					<li><a href="#contact">Serviços</a></li>
					<li><a href="#contact">Contato</a></li>
				</ul>
				
				<c:if test="${not empty sessionScope.user.getName()}">
			<ul class="nav navbar-nav navbar-right">
        		<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Olá, ${sessionScope.user.getName()}<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="login">Sair</a></li>
                        </ul>
                      </li>
     		 </ul>
     		 </c:if>	
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	
    <div class="container">
    <div class="well" style="margin-top:30px;">
     <h1>Itens disponíveis para locação</h1> 
      <c:if test="${not empty sessionScope.user.getItens()}">
    	<div class="row">
	   		<c:forEach items="${sessionScope.user.getItens()}" var="item">
				<div class="col-md-4">
		          <h3>${item.nome}</h3>
		          <h4>De: <b>${item.nomeDono}</b></h4>
		          <p>${item.descricao}</p>
		      		    <form id="formAlugarItem" name="alugaritem" action="alugaritem" method="POST" >
								<input type="hidden" name="codigo" value="${item.codigo}">
								<input type="hidden" name="nome" value="${item.nome}">
								<input type="hidden" name="descricao" value="${item.descricao}">
								<input type="hidden" name="nomeDono" value="${item.nomeDono}">
								<input type="hidden" name="codigoDono" value="${item.codigoDono}">
							<button type="submit" class="btn btn-success">Alugar</button>	
						</form>
		          <p>
		          
        		</div>
			</c:forEach>
		</div>
   	 </c:if>
   
   	 </div>
        
         <div class="well">
     <h1>Itens que aloquei</h1> 
     
     
      <c:if test="${not empty sessionScope.user.getItensQueAloquei()}">
    	<div class="row">
	   		<c:forEach items="${sessionScope.user.getItensQueAloquei()}" var="item">
				<div class="col-md-4">
		          <h3>${item.nome}</h3>
		          <h4>De: <b>${item.nomeDono}</b></h4>
		          <p>${item.descricao}</p>
		          
		           <form id="formDevolverItem" name="devolveritem" action="devolveritem" method="POST" >
								<input type="hidden" name="codigo" value="${item.codigo}">
								<input type="hidden" name="nome" value="${item.nome}">
								<input type="hidden" name="descricao" value="${item.descricao}">
								<input type="hidden" name="nomeDono" value="${item.nomeDono}">
								<input type="hidden" name="codigoDono" value="${item.codigoDono}">
							<button type="submit" class="btn btn-success">Devolver</button>	
						</form>
        		</div>
			</c:forEach>
		</div>
   	 </c:if>
   	
   	 </div>	
        
        
        
        
         <div class="well">
    <h1>Meus itens  <a class="btn btn-success" id="btnNovoItem" href="#"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a></h1>
    
    <form id="formNovoItem" style="display:none;" name="createitem" action="createitem" method="POST" >
		<div class="form-group">
			<label for="nome">Nome</label>
			<input type="text" class="form-control" name="nome">
		</div>
		<div class="form-group">
			<label for="descricao">Descrição</label>
			<input type="text" class="form-control" name="descricao">
		</div>
		<button type="submit" class="btn btn-success">Adicionar Item</button>	
		<a id="btnNovoItemCancelar" href="#" class="btn btn-danger">Cancelar</a>
	</form>
    
    <c:if test="${not empty sessionScope.user.getMeusItens()}">
    	<div class="row">
	   		<c:forEach items="${sessionScope.user.getMeusItens()}" var="item">
				<div class="col-md-4">
		          <h3>${item.nome}</h3>
		          <h4>
		              <c:choose>
			           		<c:when test="${empty item.nomeEmprestadoPara}">Disponível</c:when>
	   						<c:otherwise>Alugado para: <b>${item.nomeEmprestadoPara}</b></c:otherwise> 
		          	  </c:choose>
		          </h4>
		          <p>${item.descricao}</p>	          
        		</div>
			</c:forEach>
		</div>
    </c:if>
   	
    
</div>

      <footer>
        <p>&copy; 2017 Alugaí, Todos os direitos reservados.</p>
      </footer>
    </div> <!-- /container -->
	
	

	<spring:url value="/resources/js/jquery-1.12.1.min.js" var="jquery" />
	<spring:url value="/resources/js/bootstrap.js" var="bootstrapJS" />
	<script src="${jquery}"></script>
	<script src="${bootstrapJS}"></script>
	
	<script>
		$(document).ready(function(){
			$("#btnNovoItem").click(function(e){
				e.preventDefault();
				$("#formNovoItem").slideToggle();
			});
			
			$("#btnNovoItemCancelar").click(function(e){
				e.preventDefault();
				$("#formNovoItem").slideToggle();
			});
		});
	</script>

</body>
</html>
