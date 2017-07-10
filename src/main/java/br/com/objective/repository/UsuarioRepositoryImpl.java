package br.com.objective.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import br.com.objective.model.Ponto;
import br.com.objective.model.Usuario;

//https://stackoverflow.com/questions/17008947/whats-the-difference-between-spring-datas-mongotemplate-and-mongorepository
//https://stackoverflow.com/questions/35611449/mongodb-how-update-element-in-array-using-spring-query-update

public class UsuarioRepositoryImpl implements CustomUsuarioRepository {

	private final MongoOperations operations;

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	public UsuarioRepositoryImpl(MongoOperations operations) {
		this.operations = operations;
	}

	@Override
	public Usuario updateHorario(Usuario usuario, Ponto ponto) {
		// TODO Auto-generated method stub
		Query query = query(
		  where("_id").is(usuario.getId()).
		  and("horarios._id").is(ponto.getId()));

		Update update = new Update().set("horarios.$.dia", ponto.getDia());

		mongoTemplate.updateFirst(query, update, Usuario.class);
		
		return null;
	}
	

}
