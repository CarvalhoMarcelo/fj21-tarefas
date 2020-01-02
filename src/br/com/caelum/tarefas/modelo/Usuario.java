package br.com.caelum.tarefas.modelo;

import javax.validation.constraints.NotNull;

public class Usuario {

	@NotNull(message="Usuario nao pode estar vazio")
	private String usuario;

	private String senha;
	
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
