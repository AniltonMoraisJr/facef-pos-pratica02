package br.edu.unifacef.atividade.business;

import br.edu.unifacef.atividade.dao.DepositoDAO;
import br.edu.unifacef.atividade.model.Deposito;

public class DepositoBusiness {

    private DepositoDAO depositoDAO;

    public DepositoBusiness(DepositoDAO dao) { this.depositoDAO = dao;}

    public Deposito salvarDeposito(Deposito deposito){

        if(deposito == null) {
            throw new RuntimeException("Nenhum dado informado.");
        }
        if(deposito.getValor() == null) {
            throw new RuntimeException("Deposito requerido");
        }

        return this.depositoDAO.salvar(deposito);

    }

    public Deposito findDesposito(long id){

        Deposito deposito = this.depositoDAO.findById(id);

        if (deposito == null) {
            throw new RuntimeException("Deposito não encontrado");
        }

        return deposito;

    }

}
