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
	
	<title>Gerenciamento de Contas</title>
	
	<link rel = "stylesheet" href = "http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
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
					<li><a href="/contas/">Contas</a></li>
					<li><a href="/contas/cadastrar">Cadastrar Conta</a></li>
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
		<c:when test="${mode == 'CONTAS'}">
			<div class="container text-center" id="contasDiv">
				<h3>Minhas Contas</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Número</th>
								<th>Saldo</th>					
								<th>Cliente</th>
								<th>Atualizar</th>					
								<th>Deletar</th>
								<th>Sacar</th>
								<th>Depositar</th>
								<th>Transferir</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="conta" items="${contas}">
								<tr>
									<td>${conta.id}</td>
									<td>${conta.numero}</td>
									<td>${conta.saldo}</td>
									<td>${conta.cliente.nome}</td>					
									<td><a href="atualizar?id=${conta.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="deletar?id=${conta.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="paginaSacar?id=${conta.id}"><span class="glyphicon glyphicon-usd"></span></a></td>
									<td><a href="paginaDepositar?id=${conta.id}"><span class="glyphicon glyphicon-piggy-bank"></span></a></td>
									<td><a href="paginaTransferir?id=${conta.id}"><span class="glyphicon glyphicon-transfer"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'CRIAR_CONTA' || mode == 'ATUALIZAR_CONTA'}">
			<div class="container text-center">
				<h3>Criar Conta</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="salvar">
					<input type="hidden" name="id" value="${conta.id}" />
					<div class="form-group">
						<label class="control-label col-md-3">Número</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="numero" value="${conta.numero}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Saldo</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="saldo" value="${conta.saldo}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Código do cliente</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="cliente" value="${conta.cliente.id}" />
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Salvar"/>
					</div>
				</form>																			
			</div>
		</c:when>
		<c:when test="${mode == 'SACAR'}">
			<div class="container text-center">
				<h3>Efetuar Saque</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="sacar">
						<input type="hidden" name="id" value="${conta.id}" />					
						<input type="hidden" name="numero" value="${conta.numero}" />	
						<div class="form-group">
						<label class="control-label col-md-3">Valor do saque</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="valor" id="valor"/>
						</div>
					</div>														
						<input type="hidden" name="cliente" value="${conta.cliente.id}" />
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Sacar" />
					</div>
				</form>																			
			</div>
		</c:when>
		<c:when test="${mode == 'DEPOSITAR'}">
			<div class="container text-center">
				<h3>Efetuar Depósito</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="depositar">
						<input type="hidden" name="id" value="${conta.id}" />					
						<input type="hidden" name="numero" value="${conta.numero}" />	
						<div class="form-group">
						<label class="control-label col-md-3">Valor do depósito</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="valor" id="valor"/>
						</div>
					</div>														
						<input type="hidden" name="cliente" value="${conta.cliente.id}" />
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Depositar" />
					</div>
				</form>																			
			</div>
		</c:when>	
		<c:when test="${mode == 'TRANSFERIR'}">
			<div class="container text-center">
				<h3>Efetuar Transferência</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="transferir">
						<input type="hidden" name="id" value="${conta.id}" />					
						<input type="hidden" name="numero" value="${conta.numero}" />	
						<div class="form-group">
						<label class="control-label col-md-3">Número da conta destino</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="numeroDestino" id="numeroDestino"/>
						</div>
						<label class="control-label col-md-3">Valor da transferência</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="valor" id="valor"/>
						</div>
					</div>														
						<input type="hidden" name="cliente" value="${conta.cliente.id}" />
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Transferir" />
					</div>
				</form>																			
			</div>
		</c:when>
	</c:choose>

	<script src = <c:url value="/static/js/jquery-1.11.1.min.js" />></script>
    <script src = <c:url value="/static/js/bootstrap.min.js" />></script>
</body>
</html>