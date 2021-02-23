<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Cliente"%>
<%@ page import="java.util.*"%>
<%
ArrayList<Cliente> lista = (ArrayList<Cliente>) request.getAttribute("clientes");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deletar Cliente</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/porco.png">
</head>
<body>
<center>
	<h1>Digite o id do Cliente a ser deletado</h1>
	<form name="frmDeletarUsuario" action="deletarCliente">
		<table>
			<tr>
				<td><input type="text" name="id" placeholder="Id do usuario"
					class="Caixa"></td>
			</tr>
		</table>
		<input type="submit" value="DELETAR" class="Botao3" onclick="deletarcliente()" /> <input type="button" onclick="window.location.href = 'telaADMIN.jsp';" value="Voltar" class="Botao4"/>
	</form>

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
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=lista.get(i).getSenha()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
<script src="scripts/validador.js"></script>
</center>
</html>