package br.edu.unifacef.atividade.model;

import java.util.Date;

public class Deposito {
	
	private Long id;
	
	private Long contaId;
	
	private Date data;
	
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContaId() {
		return contaId;
	}

	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Saque [id=" + id + ", contaId=" + contaId + ", data=" + data + ", valor=" + valor + "]";
	}
	
	
}
