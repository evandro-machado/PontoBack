package br.com.objective.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.objective.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>, CustomUsuarioRepository {
	@Query(value = "{ '_id' : ?0, 'horarios._id' : ?1 }")
	List<Usuario> findByIdAndHorariosId(String userId, String questionID);

	@Query(value = "{ '_id' : ?0, 'horarios.mes' : ?1, 'horarios.ano' : ?2 }}")
	Usuario findByIdAndHorariosMesAndHorariosAnos(String userId, Integer mes, Integer ano);

	@Query(value = "{ 'usuario' : ?0 }}")
	Usuario findByUsuario(String usuario);

}
