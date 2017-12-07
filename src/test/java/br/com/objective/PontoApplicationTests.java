package br.com.objective;

import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.objective.controller.BuscarPontosVO;
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
		
//		Usuario usu = criarUsuario();
		
//		Ponto ponto = criarPonto();
		
//		Ponto ponto2 = criarPonto();
		
//		List<Ponto> listaPontos = new ArrayList<>();
//		listaPontos.add(ponto);
//		listaPontos.add(ponto2);
		
//		usu.setHorarios(listaPontos);
		
//		usuarioService.inserir(usu);
		
		Usuario usuarioRetorno = usuarioService.buscarUsuarios().get(0);
		
//		Ponto pontoRetornado = usuarioRetorno.getHorarios().get(1);

		
//		usuarioRetorno.getHorarios().clear();
//		pontoRetornado.setAno(2017);
//		pontoRetornado.setDia(25);
		
		BuscarPontosVO buscarPontosVo = new BuscarPontosVO();
		
		Ponto pt = new Ponto();
		pt.setId(new ObjectId("599d9b0f798b612b18e7b3e1"));
		pt.setAno(2017);
		pt.setMes(9);
		pt.setDia(30);
		pt.setHoraEntrada("9:55");
		pt.setHoraSaidaAlmoco("12:55");
		pt.setHoraVoltaAlmoco("13:36");
		pt.setHoraSaida("19:23");
		List<Ponto> hrs = Arrays.asList(pt);
		usuarioRetorno.setHorarios(hrs);
		
//		repository.upsert(usuarioRetorno);
		repository.updateHorario(usuarioRetorno, pt);
		
//		buscarPontosVo.setAno(2017);
//		buscarPontosVo.setIdUsuario(usuarioRetorno.get_id());
//		buscarPontosVo.setMes(3);
		
//		usuarioService.buscarPontosMesAno(buscarPontosVo);
		
//		List<Ponto> pontosRetorno = repository.findByIdAndHorariosMesAndHorariosAnos(buscarPontosVo.getIdUsuario());
//		List<Ponto> pontosRetorno = repository.buscarPorMesAno(buscarPontosVo.getIdUsuario());
//		List<Ponto> pontosRetorno = repository.buscarPorMesAno(usuarioRetorno.get_id(), 3, 2017);
//		List<Ponto> pontosRetorno = usuarioService.buscarPontosMesAno(buscarPontosVo);
		
//		System.out.println();
//		usuarioService.alterarHorario(usuarioRetorno, pontoRetornado);
//		usuarioRetorno.getHorarios().add(pontoRetornado);
//		usuarioService.alterar(usuarioRetorno);
//		System.out.println();
		
//		repository.findByIdAndHorariosId(usuarioRetorno.getId(), pontoRetornado.getId().toString());
//		repository.findByIdAndHorariosMesAndHorariosAnos(usuarioRetorno.getId(), 1, 2018);
		
		
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
