package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.conexao.Conexao;
import com.model.Cliente;

public class ClienteDAO {
	private Conexao conexao = new Conexao();
	
	// GET CLIENTE BY EMAIL
	public Cliente lerClienteByEmail(String email) {
		Cliente cliente = new Cliente();
		String lerCliente = "select * from clientes where email = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(lerCliente);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int idcliente = rs.getInt("id");
				String nomecliente = rs.getString("nome");
				String emailcliente = rs.getString("email");
				String senhacliente = rs.getString("senha");
				cliente.setId(idcliente);
				cliente.setNome(nomecliente);
				cliente.setEmail(emailcliente);
				cliente.setSenha(senhacliente);
				System.out.println("Id: "+idcliente+"Nome: "+nomecliente+ ", Email: "+emailcliente+",Senha: "+senhacliente);
			}
			con.close();
			return cliente;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	

	
	// GET LISTA DE CLIENTES
	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> listaclientes = new ArrayList<>();
		String clientes = "select * from clientes order by id";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(clientes);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int idcliente = rs.getInt("id");
				String nomecliente = rs.getString("nome");
				String emailcliente = rs.getString("email");
				String senhacliente = rs.getString("senha");
				listaclientes.add(new Cliente(idcliente, nomecliente, emailcliente, senhacliente));
			}
			con.close();
			return listaclientes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	// POST
	public void inserirCliente(Cliente cliente) {
		String inserir = "insert into clientes(nome,email,senha) values (?,?,?)";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(inserir);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getSenha());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// UPDATE EMAIL
	public void alterarEmail(int id, String novoemail) {
		String alterar = "update clientes set email= ? where id = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(alterar);
			pst.setString(1, novoemail);
			pst.setInt(2, id);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// UPDATE SENHA
	public void alterarSenha(int id, String novasenha) {
		String alterar = "update clientes set senha= ? where id = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(alterar);
			pst.setString(1, novasenha);
			pst.setInt(2, id);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// DELETE BY ID
	public void deletarCliente(int id) {
		String deletar = "delete from clientes where id = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(deletar);
			pst.setInt(1, id);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public boolean existeCliente(String email, String senha) {
		boolean existe = false;
		String query = "select * from clientes where email = ? and senha = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				existe = true;
			}
		} catch (Exception e) {
			System.out.println(e);
			
		}
		return existe;
	}
}
