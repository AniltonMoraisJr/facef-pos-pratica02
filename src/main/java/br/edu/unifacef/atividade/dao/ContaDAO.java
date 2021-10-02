package br.edu.unifacef.atividade.dao;

import br.edu.unifacef.atividade.model.Conta;

public class ContaDAO {
	
	public Conta salvar(final Conta conta) {
		
		conta.setId(1L);
		
		return conta;		
	}
	
	public Conta findById (final Long id) {
		
		if (id == 1L) {			
			Conta conta = new Conta();
			conta.setId(1L);
			conta.setClienteId(1L);
			conta.setNomeBanco("NuBank");
			conta.setNumeroConta(10001L);
			conta.setNumeroAgencia(1001L);
			return conta;
		} else {
			return null;
		}
	}
}
