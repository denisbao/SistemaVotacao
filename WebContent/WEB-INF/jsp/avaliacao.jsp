<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html !>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FAZER AVALIAÇÃO</title>
</head>
<body>

	<form action="AvaliacaoServlet" method="post">
		<label for="idAlunoAvaliado">Avaliar o aluno: </label> <select
			id="idAlunoAvaliado" name="idAlunoAvaliado">
			<c:forEach var="aluno" items="${alunos}">
				<option value="${aluno.id}">${aluno.nome}</option>
			</c:forEach>
		</select> <label for="comentario">Comentário</label>
		<textarea rows="4" cols="50" name="comentario"></textarea>

		<label for="nota">Nota</label> <input name="nota" type="number"
			min="1" max="100" required="required" /> <label for="nota">Código
			Avaliador</label> <input name="idAlunoAvaliador" type="number"
			required="required" />

		<button type="submit">AVALIAR</button>

	</form>

	<c:if test="${not empty msgDoServidor}">
		<h2>Não é permitido se auto-avaliar</h2>
	</c:if>

</body>
</html>
</html>