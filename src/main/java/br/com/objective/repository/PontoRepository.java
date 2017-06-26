package br.com.objective.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.objective.model.Ponto;

public interface PontoRepository extends MongoRepository<Ponto, String>{

}
