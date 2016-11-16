<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/bootstrap.css">
	<title>Home</title>
</head>
<body>
	<h1>Pagina Principal</h1>
	<ul>
		<li>
			<a href="principalServlet?opcao=aluno">Aluno</a>
		</li>
		<li>
			<a href="principalServlet?opcao=avaliacao">Avaliacao</a>
		</li>
		<li>
			<a href="alunosAvaliados.jsp">VER AVALIAÇÕES</a>
		</li>
	</ul>
</body>
</html>