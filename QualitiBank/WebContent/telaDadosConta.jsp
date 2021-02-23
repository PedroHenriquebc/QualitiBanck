<%@page import="com.dao.ContaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Cliente"%>
<%@ page import="com.model.Conta"%>
<%@ page import="com.dao.ContaDAO"%>

<%
Cliente cliente = (Cliente) request.getAttribute("dadoscliente");
Conta conta = (Conta) request.getAttribute("dadosconta");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dados Conta</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/porco.png">
</head>
<body>
	<center>
		<h1>Seus dados</h1>
		<table id="tabela">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Senha</th>
					<th>Numero</th>
					<th>Saldo</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=cliente.getNome()%></td>
					<td><%=cliente.getEmail()%></td>
					<td><%=cliente.getSenha()%></td>
					<td><%=conta.getNumero()%></td>
					<td><%=conta.getSaldo()%></td>
				</tr>
			</tbody>
		</table>
		<input type="button"
				onclick="window.location.href = 'telaLogin.jsp';" value="Sair"
				class="Botao4" />
	</center>

</body>
</html>