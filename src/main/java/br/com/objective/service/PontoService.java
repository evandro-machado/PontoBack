package br.com.objective.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.objective.model.Ponto;
import br.com.objective.repository.PontoRepository;

@Service
public class PontoService {
	@Autowired
	PontoRepository pontoRepository;

	public Ponto inserir(Ponto ponto) {
		return pontoRepository.save(ponto);
	}

	public Ponto alterar(Ponto ponto) {
		return pontoRepository.save(ponto);
	}

	public List<Ponto> buscarPontos() {
		return pontoRepository.findAll();
	}

	public Ponto buscarPontoPorId(String id) {
		return pontoRepository.findOne(id);
	}

	public void removerPonto(String id) {
		Ponto pontoRetorno = buscarPontoPorId(id);
		if (pontoRetorno != null) {
			pontoRepository.delete(pontoRetorno);
		}
	}
}
