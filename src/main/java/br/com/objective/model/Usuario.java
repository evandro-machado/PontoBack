package br.com.objective.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Usuario {
	@Id
	public String _id;
	public String nome;
	public String sobreNome;
	public String senha;
	public String usuario;
	public List<Ponto> horarios;

	public Usuario() {
	}

	public Usuario(String nome, String sobreNome) {
		this.nome = nome;
		this.sobreNome = sobreNome;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Ponto> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Ponto> horarios) {
		this.horarios = horarios;
	}

}
