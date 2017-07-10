package br.com.objective.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.objective.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>, CustomUsuarioRepository{
	//https://stackoverflow.com/questions/12730370/spring-data-mongodb-findby-method-for-nested-objects
	@Query(value = "{ '_id' : ?0, 'horarios._id' : ?1 }}")
	List<Usuario> findBy_IdAndHorarios_Id(String userId, String questionID);

}
