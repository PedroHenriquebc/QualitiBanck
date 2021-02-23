package com.model;

public class Conta {
		private int id;
		private String numero;
		private double saldo;
		private int idcliente;

		//METODOS
		public void creditar(double valor) {
			this.saldo += valor;
		}
		
		public void debitar(double valor) {
			if(valor <= this.saldo) {
				this.saldo -= valor;
			}else {
				System.out.println("Não foi possível realizar o débito, Saldo insuficiente.");
			}
		}
		
		public void transferir(Conta contaDestino, double valor) {
			if(valor <= this.saldo ) {
				this.saldo -= valor;
				contaDestino.setSaldo(contaDestino.getSaldo() + valor);
			}else {
				System.out.println("Não foi possível realizar a transferência, Saldo insuficiente.");
			}
		}
		
		//CONSTRUTORES
		public Conta() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		

		public Conta(int id, String numero, double saldo, int idcliente) {
			super();
			this.id = id;
			this.numero = numero;
			this.saldo = saldo;
			this.idcliente = idcliente;
		}
		

		public Conta(int id, String numero, int idcliente) {
			super();
			this.id = id;
			this.numero = numero;
			this.idcliente = idcliente;
		}

		//GETTERS AND SETTERS
		public String getNumero() {
			return numero;
		}

		

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public int getIdcliente() {
			return idcliente;
		}

		public void setIdcliente(int idcliente) {
			this.idcliente = idcliente;
		}
		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		//TO STRING
		@Override
		public String toString() {
			return "ID:"+ id + "Conta [N°" + numero + ", SALDO: " +"R$"+ saldo + "] ID cliente: "+ idcliente;
		}
	}
