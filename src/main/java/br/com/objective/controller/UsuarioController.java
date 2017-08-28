package br.com.objective.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.objective.model.Usuario;
import br.com.objective.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.GET, value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Usuario>> buscarUsuarios() {
		Collection<Usuario> usuariosEncontrados = usuarioService.buscarUsuarios();
		return new ResponseEntity<>(usuariosEncontrados, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable String id) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(id);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/usuarios/registro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioRegistrado = usuarioService.inserir(usuario);
		return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioAtualizado = usuarioService.alterar(usuario);
		return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/usuarios/{id}")
	public ResponseEntity<Usuario> deletarEvento(@PathVariable String id) {
		Usuario usuarioEncontrado = usuarioService.buscarUsuarioPorId(id);
		if (usuarioEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		usuarioService.removerUsuario(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}