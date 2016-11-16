<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Alunos</title>
</head>
<body>

	<form action="AlunoServlet" method="post">
		<c:choose>
			<c:when test="${aluno.id != null}">
				<h1>Alterar Aluno</h1>
				<input type="hidden" name="opcao" value="alterar"/>
				<input type="hidden" name="id" value="${aluno.id}"/>
			</c:when>
			<c:otherwise>
				<h1> Adicionar Aluno</h1>
				<input type="hidden" name="opcao" value="inserir"/>
			</c:otherwise>
		</c:choose>

		<label for="nome">Nome</label>
		<input name="nome" type="text" value="${aluno.nome}"/>
		<label for="matricula">Matricula</label>
		<input name="matricula" type="text" value="${aluno.matricula}"/>
		<label for="data">Data de Nascimento</label>
		<input name="data" type="date"/>
		<label for="dataNasc">Usuario</label>
		
		<input name="usuario" type="text" />
		<label for="senha">Senha</label>
		<input name="senha" type="password" />
		
		<button type="submit">INSERIR</button>
	</form>
	<br>
	<a href="principalServlet?opcao=principal">VOLTAR</a>
	<br>
	
	<h2>Alunos Cadastrados</h2>
	<table style="width:100%">
		<thead >
			<tr>
				<th style="text-align:center">Nome</th>
				<th style="text-align:center">Matricula</th>
				<th style="text-align:center">Data de Nascimento</th>
				<th style="text-align:center">Ações</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Nome</th>
				<th>Matricula</th>
				<th>Data de Nascimento</th>
				<th>Ações</th>
			</tr>
		</tfoot>
		<c:forEach var="aluno" items="${alunos}" >
			<tr>
				<td style="text-align:center">${aluno.nome} </td>
				<td style="text-align:center">${aluno.matricula} </td>
				<!--<td>${aluno.data} </td>-->
				<td style="text-align:center">data... é complicado</td>
				<td style="text-align:center">
					<a href="http://localhost:8080/SistemaVotacao/AlunoServlet?opcao=buscar&&id=${aluno.id}">Alterar</a>-
					<a href="http://localhost:8080/SistemaVotacao/AlunoServlet?opcao=excluir&&id=${aluno.id}">Excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>