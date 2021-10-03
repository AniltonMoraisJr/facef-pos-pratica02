package br.edu.unifacef.atividade.dao;

import br.edu.unifacef.atividade.model.Deposito;

import java.util.Date;

public class DepositoDAO {

    public Deposito salvar(final Deposito deposito){

        deposito.setId(1000L);

        return deposito;

    }

    public Deposito findById (final Long id){

        if (id == 1L){
            Date data = new Date(System.currentTimeMillis());

            Deposito deposito = new Deposito();
            deposito.setId(1L);
            deposito.setContaId(1L);
            deposito.setData(data);
            deposito.setValor(15.99);

            return deposito;
        } else {
            return null;
        }

    }

}
