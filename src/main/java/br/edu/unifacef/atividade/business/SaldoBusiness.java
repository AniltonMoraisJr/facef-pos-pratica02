package br.edu.unifacef.atividade.business;

import br.edu.unifacef.atividade.dao.ContaDAO;
import br.edu.unifacef.atividade.dao.SaldoDAO;
import br.edu.unifacef.atividade.model.Conta;
import br.edu.unifacef.atividade.model.Saldo;

public class SaldoBusiness {

    private SaldoDAO saldoDAO;

    private ContaDAO contaDAO;

    public SaldoBusiness(SaldoDAO saldoDAO, ContaDAO contaDAO){
        this.saldoDAO = saldoDAO;
        this.contaDAO = contaDAO;
    }

    public Saldo findById(Long id){
        Saldo saldo = this.saldoDAO.findById(id);

        if(saldo == null){
            throw new RuntimeException("Saldo não encontrado.");
        }

        return saldo;
    }

    public Saldo findByContaId(Long contaId){
        Conta conta = this.contaDAO.findById(contaId);

        if(conta == null) {
            throw new RuntimeException("Conta não encontrado.");
        }

        Saldo saldo = this.saldoDAO.findByContaId(contaId);

        if(saldo == null){
            throw new RuntimeException("Saldo não encontrado.");
        }

        return saldo;
    }

    public Saldo atualizarValorDoSaldo(Long contaId, Double valor) {
        Conta conta = this.contaDAO.findById(contaId);

        if(conta == null) {
            throw new RuntimeException("Conta não encontrado.");
        }

        Saldo saldo = this.saldoDAO.findByContaId(contaId);

        saldo.setValor(valor);

        if(saldo == null){
            throw new RuntimeException("Saldo não encontrado.");
        }

        return saldo;
    }

}
