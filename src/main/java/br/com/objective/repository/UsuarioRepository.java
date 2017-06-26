package br.com.objective.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.objective.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	

}
