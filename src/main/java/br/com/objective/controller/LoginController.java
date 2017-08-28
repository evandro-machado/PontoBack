package br.com.objective.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.util.JSON;

import br.com.objective.model.Usuario;
import br.com.objective.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController

public class LoginController {
	
	@Autowired
	private UsuarioService userService;
	
	@CrossOrigin
	@RequestMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public LoginResponse login(@RequestBody LoginVO loginVO) throws ServletException, JsonProcessingException{
		
		
		if (loginVO.getUsuario() == null || loginVO.getSenha() == null){
			throw new ServletException("Name and password are required.");
		}
		
		//Query database
		Usuario usuarioAutenticado = userService.buscarUsuarioPorUsuario(loginVO.getUsuario());
		
		if(usuarioAutenticado == null){
			throw new ServletException("Usuario não encontrado.");
		}
		
		if(!usuarioAutenticado.getSenha().equals(loginVO.getSenha())){
			throw new ServletException("Usuario ou senha incorretos.");
		}
		
		//{token: generatedcode}
		Usuario usuario = new Usuario();
		usuario.set_id(usuarioAutenticado.get_id());
		usuario.setNome(usuarioAutenticado.getNome());
		usuario.setSobreNome(usuarioAutenticado.getSobreNome());
		
		ObjectMapper mapper = new ObjectMapper();
		String usuarioStringJson = mapper.writeValueAsString(usuario);
		
		String token = Jwts.builder()
				.setSubject(usuarioStringJson)
				.signWith(SignatureAlgorithm.HS512, "secret")
				.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();

		return new LoginResponse(token);
	}
	
	private class LoginResponse{
		String token;
		
		public LoginResponse(String token){
			this.token = token;
		}
		
		public String getToken(){
			return token;
		}
	}

	
	
	
}
