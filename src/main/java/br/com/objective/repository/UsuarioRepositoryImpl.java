package br.com.objective.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import br.com.objective.model.Ponto;
import br.com.objective.model.Usuario;

public class UsuarioRepositoryImpl implements CustomUsuarioRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void updateHorario(Usuario usuario, Ponto ponto) {
		Query query = query(where("_id").is(usuario.get_id()).and("horarios._id").is(ponto.getId()));

		Update update = new Update().set("horarios.$", ponto);

		mongoTemplate.updateFirst(query, update, Usuario.class);
	}

	@Override
	public List<Ponto> buscarPorMesAno(String idUsuario, Integer mes, Integer ano) {
		Aggregation agg = Aggregation.newAggregation(Aggregation.unwind("horarios"),
				Aggregation.match(
						Criteria.where("_id").is(idUsuario).and("horarios.mes").is(mes).and("horarios.ano").is(ano)),
				Aggregation.group("horarios"));

		AggregationResults<Ponto> results = mongoTemplate.aggregate(agg, Usuario.class, Ponto.class);
		return results.getMappedResults();
	}

	@Override
	public void upsert(Usuario usuario) {
		Query query = query(where("_id").is(usuario.get_id()));

		Update update = new Update().addToSet("horarios").each(usuario.getHorarios());

		mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().upsert(true), Usuario.class);

		return;
	}

}
