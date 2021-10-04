package br.edu.unifacef.atividade.dao;

import br.edu.unifacef.atividade.model.Conta;
import br.edu.unifacef.atividade.model.Saldo;

public class SaldoDAO {
    public Saldo findById (final Long id) {

        if (id == 1L) {
            Saldo saldo = new Saldo();
            saldo.setId(1L);
            saldo.setContaId(1L);
            saldo.setValor(10000D);
            return saldo;
        } else {
            return null;
        }
    }


    public Saldo findByContaId (final Long contaId) {

        if (contaId == 1L) {
            Saldo saldo = new Saldo();
            saldo.setId(1L);
            saldo.setContaId(1L);
            saldo.setValor(10000D);
            return saldo;
        } else {
            return null;
        }
    }
}
