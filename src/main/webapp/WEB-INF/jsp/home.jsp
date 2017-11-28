<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
	
	<title>Gerenciamento de Bancos</title>
	
	<link rel="stylesheet" href=<c:url value="/static/css/bootstrap.min.css"/> type="text/css" />
	<link rel="stylesheet" href=<c:url value="/static/css/style.css"/> type="text/css" />
	
<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">INFOWAY</a>
			<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Bancos <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="/bancos/">Listar bancos</a></li>
		          <li><a href="/bancos/cadastrar/">Cadastrar banco</a></li>		         
		        </ul>
		      </li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Agências <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="/agencias/">Listar agências</a></li>
		          <li><a href="/agencias/cadastrar/">Cadastrar agência</a></li>
		        </ul>
		      </li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Clientes <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="/clientes/">Listar clientes</a></li>
		          <li><a href="/clientes/cadastrar/">Cadastrar cliente</a></li>
		        </ul>
		      </li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Contas <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="/contas/">Listar contas</a></li>
		          <li><a href="/contas/cadastrar/">Cadastrar conta</a></li>
		        </ul>
		      </li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Operações <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="/operacoes/">Listar operações</a></li>
		          <li><a href="/operacoes/cadastrar/">Cadastrar operação</a></li>
		        </ul>
		      </li>
		    </ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>INFOWAY Instituições Financeiras</h1>
				</div>
			</div>
		</c:when>
	</c:choose>
	<script src = <c:url value="/static/js/jquery-1.11.1.min.js" />></script>
    <script src = <c:url value="/static/js/bootstrap.min.js" />></script>
</body>
</html>