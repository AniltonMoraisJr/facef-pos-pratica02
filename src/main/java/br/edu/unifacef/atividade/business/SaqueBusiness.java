package br.edu.unifacef.atividade.business;

import br.edu.unifacef.atividade.dao.SaqueDAO;
import br.edu.unifacef.atividade.model.Saque;

public class SaqueBusiness {

    private SaqueDAO saqueDAO;

    public SaqueBusiness(SaqueDAO dao) {
        this.saqueDAO = dao;
    }

    public Saque salvarSaque(Saque saque) {

        if(saque == null) {
            throw new RuntimeException("Nenhum dado informado.");
        }
        if(saque.getValor() == null) {
            throw new RuntimeException("Valor requerido");
        }

        return this.saqueDAO.salvar(saque);
    }

    public Saque findSaque(long id) {

        Saque saque = this.saqueDAO.findById(id);

        if (saque == null) {
            throw new RuntimeException("Saque não encontrado");
        }

        return saque;
    }

}
