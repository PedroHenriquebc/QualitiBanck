<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ler Cliente</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/porco.png">
</head>

<body>
<center>
<h1>Digite o Email do cliente</h1>
	<form name="frmLerCliente" action="lercliente">
	
		<table>
			<tr>
				<td><input type="text" name="emailcliente"
					placeholder="Email do cliente" class="Caixa"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enviar" class="Botao3"> <input type="button" onclick="window.location.href = 'telaADMIN.jsp';" value="Voltar" class="Botao4"/></td>
			</tr>
		</table>
	</form>
</body>
</center>
</html>