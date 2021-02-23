<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Conta"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<%
Conta conta = (Conta) request.getAttribute("conta");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ler Conta</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/porco.png">
</head>
<body>
<center>
<h1>Dados da Conta</h1>
<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Numero</th>
				<th>Saldo</th>
				<th>IdCliente</th>
			</tr>
		</thead>
		<tbody>
			<tr>	
				<td><%=conta.getId()%></td>
				<td><%=conta.getNumero()%></td>
				<td><%=conta.getSaldo()%></td>
				<td><%=conta.getIdcliente()%></td>
			</tr>
		</tbody>
	</table>
	<input type="button" onclick="window.location.href = 'telaADMIN.jsp';" value="Voltar" class="Botao4"/>
</center>
</body>
</html>