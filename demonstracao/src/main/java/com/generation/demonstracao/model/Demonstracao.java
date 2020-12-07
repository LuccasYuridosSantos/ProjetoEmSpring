package com.generation.demonstracao.model;

public class Demonstracao {
	
	private String tipo;
	private String descricao;
	public Demonstracao(String tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return  tipo + ", " + descricao;
	}
	
	

}
