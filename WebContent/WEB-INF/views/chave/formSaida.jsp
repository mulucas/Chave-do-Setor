<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Registrando Saída:</h1>
	<form action="/PPI/chaves" method="post">
		<div>
			<label>Nome: </label> <input type="text" name="nome" />
		</div>
		<div>
			<label>Matricula: </label> <input type="text" name="matricula" />
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>
</body>
</html>