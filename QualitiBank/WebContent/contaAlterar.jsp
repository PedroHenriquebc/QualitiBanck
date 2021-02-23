<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.model.Conta"%>
<%@ page import="java.util.*"%>
<%
ArrayList<Conta> lista = (ArrayList<Conta>) request.getAttribute("contas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Conta</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/porco.png">
</head>
<body>
<body style=margin-top:100px >
<center>
<h1>Digite o novo numero:</h1>
	<form name="frmAlterarNumero" action="alterarnumero">
		<table>
			<tr>
				<td><input type="text" name="id" placeholder="Id da Conta"
					class="Caixa"></td>
			</tr>
			<tr>
				<td><input type="text" name="numero" placeholder="Novo Numero"
					class="Caixa"></td>
			</tr>
		</table>
		<input type="submit" value="Alterar Numero" class="Botao3" onclick="alterar()" /> <input type="button" onclick="window.location.href = 'telaADMIN.jsp';" value="Voltar" class="Botao4"/>
	</form>

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
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getNumero()%></td>
				<td><%=lista.get(i).getSaldo()%></td>
				<td><%=lista.get(i).getIdcliente()%></td>
				
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/validador.js"></script>
</center>
</body>
</html>