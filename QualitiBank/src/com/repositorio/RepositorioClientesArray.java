package com.repositorio;

import java.util.Arrays;

import com.model.Cliente;

public class RepositorioClientesArray {
	private Cliente[] clientes;
	private int indice;
	private final static int tamanhoCache = 100;
	
	//CONSTRUTOR
	public RepositorioClientesArray(){
		indice = 0;
		clientes = new Cliente[tamanhoCache];
	}
		
	//METODOS
	public void inserir(Cliente c){
		clientes[indice] = c;
		indice += 1;
	}
	

	public int procurarIndice(String email){
		int ind = -1;
		int cont = 0;
		for(Cliente c : clientes){
			if(c != null && c.getEmail().equals(email)){ 
				ind = cont;
				break;
			}
			cont++;
		}
		return ind;
	}
	
	public boolean existe(String email) {
		if(procurarIndice(email) != -1) {
			return true;
		}else {
			return false;
		}
	}
	
	public Cliente procurar(String email) {
		Cliente c = null;
		if(existe(email)) {
			int indiceCliente = procurarIndice(email);
			c = clientes[indiceCliente];
		}else {
			System.out.println("Cliente não encontrado.");
		}
		return c;
	}
	
	public void atualizar(Cliente cliente) {
		if(existe(cliente.getEmail())) {
			int indiceCliente = procurarIndice(cliente.getEmail());
			clientes[indiceCliente] = cliente;
			System.out.println("Atualização feita.");
		}else {
			System.out.println("Cliente não existe.");
		}	
	}
	
	public void remover(String email) {
		if(existe(email)) {
			int indiceCliente = procurarIndice(email);
			clientes[indiceCliente] = clientes[indice - 1];
			clientes[indice - 1] = null;
			indice = indice - 1;
			
		}
	}
	

	@Override
	public String toString() {
		return "RepositorioClientesArray [clientes=" + Arrays.toString(clientes) + ", indice=" + indice + "]";
	}
	
	
}
