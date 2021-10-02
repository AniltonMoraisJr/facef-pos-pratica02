package br.edu.unifacef.atividade.business;

import br.edu.unifacef.atividade.dao.ClienteDAO;
import br.edu.unifacef.atividade.dao.ContaDAO;
import br.edu.unifacef.atividade.model.Conta;

public class ContaBusiness {
	
	private ClienteDAO clienteDAO;
	private ContaDAO contaDAO;
	
	public ContaBusiness(ClienteDAO dao, ContaDAO contaDAO) {
		this.clienteDAO = dao;
		this.contaDAO = contaDAO;
	}
	
	
	public Conta salvarConta(Conta conta) {
		
		if (conta == null) {
			throw new RuntimeException("Nenhum dado informado.");
		}
		
		if (conta.getClienteId() == null) {
			throw new RuntimeException("Nenhum cliente informado.");
		}
		
		if (this.clienteDAO.findById(conta.getClienteId()) == null) {
			throw new RuntimeException("Cliente não encontrado.");
		}
		
		return this.contaDAO.salvar(conta);
	}
}
