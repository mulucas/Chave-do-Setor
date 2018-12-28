<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Lista de Controle</h1>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Matricula</th>
			<th>Data de Saída</th>
			<th>Nome Entregue</th>
			<th>Matricula Entregue</th>
			<th>Data Entregue</th>
		</tr>
		<c:forEach var="chave" items="${chaves}">
			<tr>
				<td>${chave.id}</td>
				<td>${chave.nome }</td>
				<td>${chave.matricula }</td>
				<td>${chave.dataSaida }</td>
				<td>${chave.nomeEntregue }</td>
				<td>${chave.matriculaEntregue }</td>
				<td>${chave.dataEntregue }</td>
				<td><a href="/PPI/chaves/devolver?id=${chave.id}">Devolver</a></td>
				<td><a href="/PPI/chaves/remover?id=${chave.id}">Excluir Registro</a></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>