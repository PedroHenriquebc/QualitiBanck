package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClienteDAO;
import com.dao.ContaDAO;
import com.model.Cliente;
import com.model.Conta;


@WebServlet(urlPatterns = { "/Controller", 
							"/cadastro", "/cadastrar",
							"/entre", "/entrar",
							"/telaLerCliente","/lercliente", 
							"/telaAlterarCliente", "/alterarEmail", "/alterarSenha", 
							"/telaDeletarCliente","/deletarCliente"})

public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDao = new ClienteDAO();
	Cliente cliente = new Cliente();
	ContaDAO contaDao = new ContaDAO();
	Conta conta = new Conta();
	
	
	public ClienteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		switch (action) {
		case "/entre":
			response.sendRedirect("telaLogin.jsp");
			break;
		case "/entrar":
			conta = validarLogin(request, response);
			break;

		case "/cadastro":
			response.sendRedirect("clienteCadastrar.jsp");
			break;
		case "/cadastrar":
			doPost(request, response);
			break;

		case "/telaLerCliente":
			ListaClientesLER(request, response);
			break;
		case "/lercliente":
			ListarClienteByEmail(request, response);
			break;

		case "/telaAlterarCliente":
			ListaClientesALTERAR(request, response);
			break;
		case "/alterarEmail":
			doPutEmail(request, response);
			break;
		case "/alterarSenha":
			doPutSenha(request, response);
			break;

		case "/telaDeletarCliente":
			ListaClientesDELETAR(request, response);
			break;
		case "/deletarCliente":
			doDelete(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
		}
	}

	protected void ListarClienteByEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cliente = clienteDao.lerClienteByEmail(request.getParameter("emailcliente"));
		request.setAttribute("clienteEmail", cliente);
		RequestDispatcher rd = request.getRequestDispatcher("telaLeituraCliente.jsp");
		rd.forward(request, response);
	}

	protected void ListaClientesLER(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Cliente> lista = clienteDao.listarClientes();
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("clienteLer.jsp");
		rd.forward(request, response);
	}
	
	protected void ListaClientesALTERAR(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Cliente> lista = clienteDao.listarClientes();
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("clienteAlterar.jsp");
		rd.forward(request, response);
	}
	
	protected void ListaClientesDELETAR(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Cliente> lista = clienteDao.listarClientes();
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("clienteDeletar.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		clienteDao.inserirCliente(cliente);
		response.sendRedirect("contaAbrir.jsp");

	}

	protected void doPutEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		clienteDao.alterarEmail(id, email);
		response.sendRedirect("telaADMIN.jsp");
	}

	protected void doPutSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String senha = request.getParameter("senha");
		clienteDao.alterarSenha(id, senha);
		response.sendRedirect("telaADMIN.jsp");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		clienteDao.deletarCliente(id);
		response.sendRedirect("telaADMIN.jsp");
	}

	protected Conta validarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		if (request.getParameter("email").equals("admin") && request.getParameter("senha").equals("admin")) {
			response.sendRedirect("telaADMIN.jsp");
			return null;
		} else if (clienteDao.existeCliente(cliente.getEmail(), cliente.getSenha())) {
			Cliente dadoscliente = clienteDao.lerClienteByEmail(cliente.getEmail());
			Conta dadosconta = contaDao.lerContaByCliente(dadoscliente);
			request.setAttribute("dadoscliente", dadoscliente);
			request.setAttribute("dadosconta", dadosconta);
			RequestDispatcher rd = request.getRequestDispatcher("telaDadosConta.jsp");
			rd.forward(request, response);
			System.out.println(dadoscliente);
			return dadosconta;
		} else {
			response.sendRedirect("telaFalhaLogin.jsp");
		}
		return null;
		
	}

}
