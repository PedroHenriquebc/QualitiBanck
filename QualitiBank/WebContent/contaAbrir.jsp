<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Cliente"%>
<%@ page import="java.util.*"%>
<%
Cliente cliente = (Cliente) request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cliente</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/porco.png">
</head>
<body>
<center>
<h1>Selecione o tipo de conta</h1>
<form name="frmAbrirConta" action="abrirconta">
		<table>
			<tr>
				<td><input type="radio" name="conta" value="Nome" class=Radio>Conta Corrente</td>
			</tr>
			<tr>
				<td><input type="radio" name="poupanca" value="Email" class=Radio>Poupança</td>
			</tr>
			<tr>
				<td><input type="radio" name="bonificada" value="Senha" class=Radio>Bonificada</td>
			</tr>
			<tr>
				<td><input type="text" name="numeroconta" Placeholder="Crie o Numero da Conta **" class=Caixa></td>
			</tr>	
			<tr>
				<td><input type="email" name="emailcliente" Placeholder="Confirme seu email" class=Caixa></td>
			</tr>		
		</table>
		<input type="button" value="Finalizar" onclick="validarAbrirConta(); contaaberta()" class="Botao3"> <input type="button" onclick="window.location.href = 'clienteCadastrar.jsp';" value="Voltar" class=Botao4 />
	</form>
<script src="scripts/validador.js"></script>
</center>

</body>
</html>