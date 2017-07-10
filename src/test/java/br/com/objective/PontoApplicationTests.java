package br.com.objective;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.objective.model.Ponto;
import br.com.objective.model.Usuario;
import br.com.objective.repository.UsuarioRepository;
import br.com.objective.service.PontoService;
import br.com.objective.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PontoApplicationTests {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PontoService pontoService;
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void contextLoads() {
		
		Usuario usu = criarUsuario();
		
		Ponto ponto = criarPonto();
		
		Ponto ponto2 = criarPonto();
		
		List<Ponto> listaPontos = new ArrayList<>();
		listaPontos.add(ponto);
		listaPontos.add(ponto2);
		
		usu.setHorarios(listaPontos);
		
		usuarioService.inserir(usu);
		
		Usuario usuarioRetorno = usuarioService.buscarUsuarios().get(0);
		
		Ponto pontoRetornado = usuarioRetorno.getHorarios().get(0);

		
//		usuarioRetorno.getHorarios().clear();
		pontoRetornado.setAno(2017);
		pontoRetornado.setDia(25);
		
		usuarioService.alterarHorario(usuarioRetorno, pontoRetornado);
//		usuarioRetorno.getHorarios().add(pontoRetornado);
//		usuarioService.alterar(usuarioRetorno);
//		System.out.println();
		
		repository.findBy_IdAndHorarios_Id(usuarioRetorno.getId(), pontoRetornado.getId().toString());
		
	}

	private Usuario criarUsuario() {
		Usuario usu = new Usuario();
		usu.setNome("Oi");
		usu.setSobreNome("Alo");
		return usu;
	}

	private Ponto criarPonto() {
		Ponto ponto = new Ponto();
		ponto.setDia(1);
		ponto.setMes(1);
		ponto.setAno(1);
		ponto.setHoraEntrada("08:00");
		ponto.setHoraSaidaAlmoco("12:00");
		ponto.setHoraVoltaAlmoco("13:00");
		ponto.setHoraSaida("18:00");
		return ponto;
	}

}
