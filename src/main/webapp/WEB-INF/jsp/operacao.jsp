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
	
	<title>Gerenciamento de Operações</title>
	
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
					<li><a href="/operacoes/">Operações</a></li>
					<li><a href="/operacoes/cadastrar">Cadastrar Operação</a></li>
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
		<c:when test="${mode == 'OPERACOES'}">
			<div class="container text-center" id="operacoesDiv">
				<h3>Extrato</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Cliente</th>
								<th>Conta</th>
								<th>Data</th>
								<th>Tipo da Operação</th>
								<th>Valor</th>
								<th>Atualizar</th>					
								<th>Deletar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="operacao" items="${operacoes}">
								<tr>
									<td>${operacao.id}</td>	
									<td>${operacao.conta.cliente.nome}</td>
									<td>${operacao.conta.numero}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${operacao.data}" /></td>
									<td>${operacao.tipo}</td>
									<td>${operacao.valor}</td>									
									<td><a href="atualizar?id=${operacao.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="deletar?id=${operacao.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'CRIAR_OPERACAO' || mode == 'ATUALIZAR_OPERACAO'}">
			<div class="container text-center">
				<h3>Realizar Operação</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="salvar">
					<input type="hidden" name="id" value="${operacao.id}" />
					<div class="form-group">
						<label class="control-label col-md-3">Tipo de Operação</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="tipo" value="${operacao.tipo}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Valor</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="valor" value="${operacao.valor}" />
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