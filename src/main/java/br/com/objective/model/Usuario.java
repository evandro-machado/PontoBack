package br.com.objective.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Usuario {
	@Id
	public String id;
	public String nome;
	public String sobreNome;
	public List<Ponto> horarios;

	public Usuario() {
	}

	public Usuario(String nome, String sobreNome) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<Ponto> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Ponto> horarios) {
		this.horarios = horarios;
	}
	
}
