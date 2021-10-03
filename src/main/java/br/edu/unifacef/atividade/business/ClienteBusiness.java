package br.edu.unifacef.atividade.business;

import br.edu.unifacef.atividade.dao.ClienteDAO;
import br.edu.unifacef.atividade.model.Cliente;

public class ClienteBusiness {
	private ClienteDAO clienteDAO;
	
	public ClienteBusiness(ClienteDAO dao) {
		this.clienteDAO = dao;
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		
		if(cliente == null) {
			throw new RuntimeException("Nenhum dado informado.");
		}
		if(cliente.getNome().isBlank()) {
			throw new RuntimeException("Nome requerido");
		}
		
		return this.clienteDAO.salvar(cliente);
	}

	public Cliente findCliente(long id) {

		Cliente cliente = this.clienteDAO.findById(id);

		if(cliente == null) {
			throw new RuntimeException("Cliente não encontrado");
		}

		return cliente;
	}
}
