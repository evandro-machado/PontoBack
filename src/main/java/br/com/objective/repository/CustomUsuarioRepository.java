package br.com.objective.repository;

import java.util.List;

import br.com.objective.model.Ponto;
import br.com.objective.model.Usuario;

public interface CustomUsuarioRepository {
	void updateHorario(Usuario usuario, Ponto ponto);

	void upsert(Usuario usuario);

	public List<Ponto> buscarPorMesAno(String idUsuario, Integer mes, Integer ano);

}
