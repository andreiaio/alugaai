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
				
				<c:if test="${not empty message}">
			<ul class="nav navbar-nav navbar-right">
        		<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Olá,${message}<span class="caret"></span></a>
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
	
	
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class=""></li>
        <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="${images}/banner1.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Alugue o que precisar quando precisar</h1>
            </div>
          </div>
        </div>
        <div class="item ">
              <img class="first-slide" src="${images}/banner2.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Alugue o que precisar quando precisar</h1>
            </div>
          </div>
        </div>
        <div class="item">
        <img class="first-slide" src="${images}/banner3.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Alugue o que precisar quando precisar</h1>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
	
	
<!-- 
    <div class="jumbotron">
      <div class="container">
        <h2>Seja bem-vindo, ${message}!</h2>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
      </div>
    </div>
    -->

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; 2016 Company, Inc.</p>
      </footer>
    </div> <!-- /container -->
	
	

	<spring:url value="/resources/js/jquery-1.12.1.min.js" var="jquery" />
	<spring:url value="/resources/js/bootstrap.js" var="bootstrapJS" />
	<script src="${jquery}"></script>
	<script src="${bootstrapJS}"></script>

</body>
</html>
