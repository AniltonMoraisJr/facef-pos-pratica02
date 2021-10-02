package br.edu.unifacef.atividade.dao;

import br.edu.unifacef.atividade.model.Cliente;

public class ClienteDAO {
	
	public Cliente salvar(final Cliente cliente) {
		
		cliente.setId(1000L);
		
		return cliente;		
	}
	
	public Cliente findById (final Long id) {
		
		if (id == 1L) {			
			Cliente cliente = new Cliente();
			cliente.setId(1L);
			cliente.setNome("Maria");
			cliente.setCidade("Passos");
			cliente.setEstado("MG");
			
			return cliente;
		} else {
			return null;
		}
	}
}
