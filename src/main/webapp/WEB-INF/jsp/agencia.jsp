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
	
	<title>Gerenciamento de Ag�ncias</title>
	
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
					<li><a href="/agencias/">Ag�ncias</a></li>
					<li><a href="/agencias/cadastrar">Cadastrar Ag�ncia</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>INFOWAY Institui��es Financeiras</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'AGENCIAS'}">
			<div class="container text-center" id="agenciasDiv">
				<h3>Minhas Ag�ncias</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Numero</th>
								<th>Banco</th>
								<th>Date de cria��o</th>
								<th>Atualizar</th>					
								<th>Deletar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="agencia" items="${agencias}">
								<tr>
									<td>${agencia.id}</td>
									<td>${agencia.numero}</td>
									<td>${agencia.banco.nome}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${agencia.data_criacao}" /></td>
									<td><a href="atualizar?id=${agencia.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="deletar?id=${agencia.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'CRIAR_AGENCIA' || mode == 'ATUALIZAR_AGENCIA'}">
			<div class="container text-center">
				<h3>Criar Ag�ncia</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="salvar">
					<input type="hidden" name="id" value="${agencia.id}" />
					<div class="form-group">
						<label class="control-label col-md-3">N�mero</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="numero" value="${agencia.numero}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">C�digo do banco</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="banco" value="${agencia.banco.id}" />
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Salvar"/>
					</div>
				</form>																			
			</div>
		</c:when>		
	</c:choose>

	<script src = <c:url value="/static/js/jquery-1.11.1.min.js" />></script>
    <script src = <c:url value="/static/js/bootstrap.min.js" />></script>
</body>
</html>