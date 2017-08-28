package br.com.objective.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.objective.controller.AlterarPontoVO;
import br.com.objective.controller.BuscarPontosVO;
import br.com.objective.model.Ponto;
import br.com.objective.repository.PontoRepository;

@Service
public class PontoService {
	@Autowired
	PontoRepository pontoRepository;
	
	@Autowired
	UsuarioService usuarioService;

	public Ponto inserir(Ponto ponto) {
		return pontoRepository.save(ponto);
	}

	public Ponto alterar(Ponto ponto) {
		return pontoRepository.save(ponto);
	}
	
	public void alterar(AlterarPontoVO alterarPontoVo){
		usuarioService.alterarHorario(alterarPontoVo.getUsuario(), alterarPontoVo.getPonto());
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

	public List<Ponto> buscarPontosMesAno(BuscarPontosVO buscarPontosVO) {
		List<Ponto> pontosRetorno = usuarioService.buscarPontosMesAno(buscarPontosVO);
		
		return pontosRetorno;
	}
}
