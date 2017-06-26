package br.com.objective.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.objective.model.Usuario;
import br.com.objective.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario inserir(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario alterar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public List<Usuario> buscarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarUsuarioPorId(String id) {
		return usuarioRepository.findOne(id);
	}

	public void removerUsuario(String id) {
		Usuario usuarioRetorno = buscarUsuarioPorId(id);
		if (usuarioRetorno != null) {
			usuarioRepository.delete(usuarioRetorno);
		}
	}
}
