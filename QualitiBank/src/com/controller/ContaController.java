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

@WebServlet(urlPatterns={"/ContaController", "/abrirconta", 
						"/telaLerConta", "/lerconta",
						"/telaAlterarConta", "/alterarnumero",
						"/telaDeletarConta", "/deletarconta"})
public class ContaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ContaDAO contaDao = new ContaDAO();
    Conta conta = new Conta();
    ClienteDAO clienteDao = new ClienteDAO();
    Cliente cliente = new Cliente();
    
    public ContaController() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/telaLerConta":
			response.sendRedirect("contaLer.jsp");	
		case "/lerconta":
			ListarContaByNumero(request, response);
			break;
			
		case "/abrirconta":
			doPostConta(request, response);
			
		case "/telaAlterarConta":
			ListaContasALTERAR(request, response);
			break;
		case "/alterarnumero":
			doPutNumero(request, response);
		
		case "/telaDeletarConta":
			ListaContasDELETAR(request, response);
			break;
		case "/deletarconta":
			doDelete(request, response);
			
		default:
			response.sendRedirect("index.jsp");
		}		
	}
	
	protected void ListarContaByNumero(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		conta = contaDao.lerContaByNumero(request.getParameter("numero"));
		request.setAttribute("conta", conta);
		RequestDispatcher rd = request.getRequestDispatcher("telaLeituraConta.jsp");
		rd.forward(request, response);
	}
	
	protected void ListaContasALTERAR(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Conta> lista2 = contaDao.listarContas();
		request.setAttribute("contas", lista2);
		RequestDispatcher rd2 = request.getRequestDispatcher("contaAlterar.jsp");
		rd2.forward(request, response);
	}
	protected void ListaContasDELETAR(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Conta> lista = contaDao.listarContas();
		request.setAttribute("contas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("contaDeletar.jsp");
		rd.forward(request, response);
	}
	
	protected void doPostConta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cliente = clienteDao.lerClienteByEmail(request.getParameter("emailcliente"));
		conta.setNumero(request.getParameter("numeroconta"));
		conta.setSaldo(0);
		conta.setIdcliente(cliente.getId());
		contaDao.inserirConta(conta, cliente);
		response.sendRedirect("telaLogin.jsp");
	}
	
	protected void doPutNumero(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			String novonumero = request.getParameter("numero");
			contaDao.atualizarNumero(id, novonumero);
			response.sendRedirect("telaADMIN.jsp");
		}


	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		contaDao.deletarConta(id);
		response.sendRedirect("telaADMIN.jsp");
	}

}