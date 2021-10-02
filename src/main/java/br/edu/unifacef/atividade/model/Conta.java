package br.edu.unifacef.atividade.model;

public class Conta {
	private Long id;
	
	private Long clienteId;
	
	private Long numeroAgencia;
	
	private Long numeroConta;
	
	private String nomeBanco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clientId) {
		this.clienteId = clientId;
	}

	public Long getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(Long numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public Long getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", clienteId=" + clienteId + ", numeroAgencia=" + numeroAgencia + ", numeroConta="
				+ numeroConta + ", nomeBanco=" + nomeBanco + "]";
	}

	
	
}
