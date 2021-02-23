package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.conexao.Conexao;
import com.model.Conta;
import com.model.Cliente;

public class ContaDAO {
	private Conexao conexao = new Conexao();
	
	public void inserirConta(Conta conta, Cliente cliente) {
		String inserir = "insert into contas(numero,saldo,idcliente) values (?, ?, ?)";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(inserir);
			pst.setString(1, conta.getNumero());
			pst.setDouble(2, conta.getSaldo());
			pst.setInt(3, cliente.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Conta lerContaByNumero(String numero) {
		Conta conta = new Conta();
		String lerConta = "select * from contas where numero = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(lerConta);
			pst.setString(1, numero);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int idconta = rs.getInt("id");
				String numeroconta = rs.getString("numero");
				double saldo = rs.getDouble("saldo");
				int idcliente= rs.getInt("idcliente");
				conta.setId(idconta);
				conta.setNumero(numeroconta);
				conta.setSaldo(saldo);	
				conta.setIdcliente(idcliente);
			}
			con.close();
			return conta;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public Conta lerContaByCliente(Cliente cliente) {
		Conta conta = new Conta();
		String lerConta = "select * from contas where idcliente = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(lerConta);
			pst.setInt(1, cliente.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int idconta = rs.getInt("id");
				String numeroconta = rs.getString("numero");
				double saldo = rs.getDouble("saldo");
				int idcliente= rs.getInt("idcliente");
				conta.setId(idconta);
				conta.setNumero(numeroconta);
				conta.setSaldo(saldo);	
				conta.setIdcliente(idcliente);
			}
			con.close();
			return conta;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void atualizarSaldo(Conta conta, double novosaldo) {
		String atualizar = "update contas set saldo = ? where numero = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(atualizar);
			pst.setDouble(1, novosaldo);
			pst.setString(2, conta.getNumero());
			pst.executeUpdate();
			con.close();		
		} catch (Exception e) {		
		}
	}
	
	public void atualizarNumero(int id, String novonumero) {
		String atualizar = "update contas set numero = ? where id = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(atualizar);
			pst.setString(1, novonumero);
			pst.setInt(2, id);
			pst.executeUpdate();
			con.close();		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletarConta(int id) {
		String deletar = "delete from contas where id = ?";
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
	
	public ArrayList<Conta> listarContas() {
		ArrayList<Conta> listacontas = new ArrayList<>();
		String clientes = "select * from contas order by id";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(clientes);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String numero = rs.getString("numero");
				double saldo = rs.getDouble("saldo");
				int idcliente = rs.getInt("idcliente");
				listacontas.add(new Conta(id, numero, saldo, idcliente));
			}
			con.close();
			return listacontas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
