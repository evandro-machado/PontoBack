package br.com.objective.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ponto {

	@Id
	private ObjectId _id;
	private int dia;
	private int mes;
	private int ano;
	private String horaEntrada;
	private String horaSaidaAlmoco;
	private String horaVoltaAlmoco;
	private String horaSaida;

	public Ponto() {
		this._id = ObjectId.get();
	}

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaidaAlmoco() {
		return horaSaidaAlmoco;
	}

	public void setHoraSaidaAlmoco(String horaSaidaAlmoco) {
		this.horaSaidaAlmoco = horaSaidaAlmoco;
	}

	public String getHoraVoltaAlmoco() {
		return horaVoltaAlmoco;
	}

	public void setHoraVoltaAlmoco(String horaVoltaAlmoco) {
		this.horaVoltaAlmoco = horaVoltaAlmoco;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

}
