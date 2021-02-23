<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entrar</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/porco.png">
</head>

<body>
	<center>
		<h1>Login</h1>
		<form name="frmEntre" action="entrar">
			<table>
				<tr>
					<td><input type="text" name="email" placeholder="Email"
						class="Caixa"></td>
				</tr>
				<tr>
					<td><input type="password" name="senha" placeholder="Senha"
						class="Caixa"></td>
				</tr>
			</table>
			<input type="button" value="Entrar" onclick="validarEntre()"
				class="Botao3"> <input type="button"
				onclick="window.location.href = 'index.jsp';" value="Voltar"
				class="Botao4" />
		</form>
		<script src="scripts/validador.js"></script>
	</center>
</body>
</html>