package br.com.objective.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import br.com.objective.model.Ponto;
import br.com.objective.model.Usuario;

public interface CustomUsuarioRepository {
	Usuario updateHorario(Usuario usuario, Ponto ponto);

}
