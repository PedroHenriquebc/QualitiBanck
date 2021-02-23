<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela Administração</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/porco.png">
</head>
	<body>
<center>
		<h1>Operações disponíveis para CLIENTE</h1>
		<a href="telaLerCliente" class="Botao">Ler Cliente</a>
		<a href="telaAlterarCliente" class="Botao">Alterar Cliente</a>
		<a href="telaDeletarCliente" class="Botao4">Deletar Cliente</a>
		
		<h1>Operações disponíveis para CONTA</h1>
		<a href="telaLerConta" class="Botao">Ler Conta</a>
		<a href="telaAlterarConta" class="Botao">Alterar Conta</a>
		<a href="telaDeletarConta" class="Botao4">Deletar Conta</a>
		
		<h1> </h1>
		<input type="button"
				onclick="window.location.href = 'telaLogin.jsp';" value="Sair"
				class="Botao4" />
</center>

	</body>
</html>