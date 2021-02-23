function validarCadastro(){
	let nome = frmCadastro.nome.value
	let email = frmCadastro.email.value
	let senha = frmCadastro.senha.value
	
	if(nome === ""){
		alert("Preencha o campo Nome")
		frmCadastro.nome.focus()
		return false
	}else if(email === ""){
		alert("Preencha o campo Email")
		frmCadastro.email.focus()
		return false
	}else if(senha === ""){
		alert("Preencha o campo Senha")
		frmCadastro.senha.focus()
		return false
	}else{
		document.forms["frmCadastro"].submit()
	}
}

function validarEntre(){
	let email = frmEntre.email.value
	let senha = frmEntre.senha.value
	
	if(email === ""){
		alert("Preencha o campo Email")
		frmEntre.email.focus()
		return false
	}else if(senha === ""){
		alert("Preencha o campo Senha")
		frmEntre.senha.focus()
		return false
	}else{
		document.forms["frmEntre"].submit()
	}
}

function validarAbrirConta(){
	let numero = frmAbrirConta.numeroconta.value
	let email = frmAbrirConta.emailcliente.value
	
	if(numero === ""){
		alert("Preencha o campo Numero da Conta")
		frmAbrirConta.numeroconta.focus()
		return false
	}else if(email === ""){
		alert("Preencha o campo Email")
		frmAbrirConta.email.focus()
		return false
	}else{
		document.forms["frmAbrirConta"].submit()
	}
}

function valorValidar(){
	let valor = formCreditar.valor.value
	
	if(valor === ""){
		alert("Preencha o campo Valor")
		formCreditar.valor.focus()
		return false
	}else{
		document.forms["formCreditar"].submit()
	}
}

function falhaLogin(){
	alert("Conta nao cadastrada")
	}
	
function alterar(){
	alert("Alteracao realizada com sucesso!")
	}

function deletarconta(){
	alert("Conta excluida com sucesso!")
}

function deletarcliente(){
	alert("Cliente excluido com sucesso!")
}

function contaaberta(){
	alert("Conta aberta com sucesso!")
}

function clientecadastrado(){
	alert("Cliente cadastrado com sucesso!")
}
