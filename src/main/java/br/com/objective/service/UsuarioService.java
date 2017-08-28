package br.com.objective.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.objective.controller.BuscarPontosVO;
import br.com.objective.model.Ponto;
import br.com.objective.model.Usuario;
import br.com.objective.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Ponto> buscarPontosMesAno(BuscarPontosVO buscarPontosVo){
		String idUsuario = buscarPontosVo.getIdUsuario();
		Integer mes = buscarPontosVo.getMes();
		Integer ano = buscarPontosVo.getAno();
		
		Usuario usuarioRetorno = usuarioRepository.findOne(idUsuario);
		if(usuarioRetorno == null){
			return null;
		}
		
		List<Ponto> pontosMesAno = usuarioRepository.buscarPorMesAno(idUsuario, mes, ano);
		
		if(pontosMesAno == null || pontosMesAno.isEmpty()){
			pontosMesAno = criarPontosDoMesAno(mes, ano);
			adicionarPontosUsuario(usuarioRetorno, pontosMesAno);
			usuarioRepository.upsert(usuarioRetorno);
		}
		
		return pontosMesAno;
	}


	private void adicionarPontosUsuario(Usuario usuario, List<Ponto> pontosMesAno) {
		if(usuario.getHorarios() == null){
			usuario.setHorarios(new ArrayList<>());
		}
		usuario.getHorarios().addAll(pontosMesAno);
	}


	private List<Ponto> criarPontosDoMesAno(Integer mes, Integer ano) {
		List<Ponto> listaPontos = new ArrayList<>();
		
		LocalDate initial = LocalDate.of(ano, mes, 1);
		LocalDate start = initial.withDayOfMonth(1);
		LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());
		
		for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
			Ponto ponto = criarPonto(date);
			listaPontos.add(ponto);
		}

		return listaPontos;
	}


	private Ponto criarPonto(LocalDate date) {
		Ponto ponto = new Ponto();
		ponto.setHoraEntrada("08:00");
		ponto.setHoraSaidaAlmoco("12:00");
		ponto.setHoraVoltaAlmoco("13:00");
		ponto.setHoraSaida("18:00");
		ponto.setDia(date.getDayOfMonth());
		ponto.setMes(date.getMonthValue());
		ponto.setAno(date.getYear());
		return ponto;
	}
	

	public Usuario inserir(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario alterar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void alterarHorario(Usuario usuario, Ponto ponto){
		usuarioRepository.updateHorario(usuario, ponto);
	}

	public List<Usuario> buscarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarUsuarioPorId(String id) {
		return usuarioRepository.findOne(id);
	}

	public Usuario buscarUsuarioPorUsuario(String usuario) {
		return usuarioRepository.findByUsuario(usuario);
	}

	public void removerUsuario(String id) {
		Usuario usuarioRetorno = buscarUsuarioPorId(id);
		if (usuarioRetorno != null) {
			usuarioRepository.delete(usuarioRetorno);
		}
	}
}
