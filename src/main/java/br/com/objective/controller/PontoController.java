package br.com.objective.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.objective.model.Ponto;
import br.com.objective.service.PontoService;

@RestController
public class PontoController {
	@Autowired
	PontoService pontoService;

	@RequestMapping(method = RequestMethod.GET, value = "/pontos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Ponto>> buscarPontos() {
		Collection<Ponto> pontosEncontrados = pontoService.buscarPontos();
		return new ResponseEntity<>(pontosEncontrados, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pontos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ponto> buscarPontoPorId(@PathVariable String id) {
		Ponto ponto = pontoService.buscarPontoPorId(id);
		return new ResponseEntity<>(ponto, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/pontos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ponto> alterarUsuario(@RequestBody Ponto ponto) {
		Ponto pontoAtualizado = pontoService.alterar(ponto);
		return new ResponseEntity<>(pontoAtualizado, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/pontos/{id}")
	public ResponseEntity<Ponto> deletarEvento(@PathVariable String id) {
		Ponto pontoEncontrado = pontoService.buscarPontoPorId(id);
		if (pontoEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		pontoService.removerPonto(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
