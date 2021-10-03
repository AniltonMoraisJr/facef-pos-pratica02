package br.edu.unifacef.atividade.dao;

import br.edu.unifacef.atividade.model.Saque;

import java.util.Date;

public class SaqueDAO {

    public Saque salvar(final Saque saque){

        saque.setId(1000L);

        return saque;
    }

    public Saque findById (final Long id){

        if (id == 1L){
            Date data = new Date(System.currentTimeMillis());

            Saque saque = new Saque();
            saque.setId(1L);
            saque.setContaId(1L);
            saque.setData(data);
            saque.setValor(15.99);

            return saque;
        } else {
            return null;
        }

    }

}
