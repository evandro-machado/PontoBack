package br.com.objective.controller;

import br.com.objective.model.Ponto;
import br.com.objective.model.Usuario;

public class AlterarPontoVO {

	private Ponto ponto;
	private Usuario usuario;

	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
