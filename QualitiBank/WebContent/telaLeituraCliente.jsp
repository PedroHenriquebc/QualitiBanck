<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Cliente"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<%
Cliente cliente = (Cliente) request.getAttribute("clienteEmail");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dados Cliente</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/porco.png">
</head>
<body>
<center>
<h1>Dados do Cliente</h1>
<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Senha</th>
			</tr>
		</thead>
		<tbody>
			<tr>	
				<td><%=cliente.getId()%></td>
				<td><%=cliente.getNome()%></td>
				<td><%=cliente.getEmail()%></td>
				<td><%=cliente.getSenha()%></td>
			</tr>
		</tbody>
	</table>
	<input type="button" onclick="window.location.href = 'telaADMIN.jsp';" value="Voltar" class="Botao4"/>
</center>
</body>
</html>