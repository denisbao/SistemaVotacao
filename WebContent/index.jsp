<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Sistema de Votação</title>
	</head>
	<body>
		<header><h1>Sistema de Votação</h1></header>
		<section>
			<form action="LoginServlet" method="post">
				<label for="ususario">Usuário</label>
				<input type="text" name="usuario"><br>
				<label for="senha">Senha</label>
				<input type="password" name="senha"><br>
				<button type="submit">Autenticar</button>
			</form>
			<c:if test="${not empty msgDoServidor}">
				<h2>Usuário ou Senha não cadastrados</h2>
			</c:if>
		</section><br>
		<footer>@Projeto - Exemplo em aula</footer>
	</body>
</html>