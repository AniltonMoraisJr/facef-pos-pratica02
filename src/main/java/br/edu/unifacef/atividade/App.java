package br.edu.unifacef.atividade;

import br.edu.unifacef.atividade.business.*;
import br.edu.unifacef.atividade.dao.*;
import br.edu.unifacef.atividade.model.*;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Date hoje = new Date(System.currentTimeMillis());

        System.out.println( "########### ATIVIDADE 02 ###############" );
        
        System.out.println(">>>>>>>>> CRIANDO CLIENTE <<<<<<<<<<<<<<<<<<");
        
        Cliente novoCliente = new Cliente();
        novoCliente.setNome("José");
        novoCliente.setCidade("Franca");
        novoCliente.setEstado("SP");        
        
        ClienteBusiness clienteBusiness = new ClienteBusiness(new ClienteDAO());
        
        Cliente clienteSalvo = clienteBusiness.salvarCliente(novoCliente);
        
        System.out.printf("Cliente salvo: %s", clienteSalvo.toString());
        
        System.out.println("\n>>>>>>>>> CRIANDO CONTA <<<<<<<<<<<<<<<<<<");

        Conta novaConta = new Conta();
        novaConta.setClienteId(clienteSalvo.getId());
        novaConta.setNomeBanco("NuBank");
        novaConta.setNumeroConta(10001L);
        novaConta.setNumeroAgencia(1001L);

        ContaBusiness contaBusiness = new ContaBusiness(new ClienteDAO(), new ContaDAO());

        Conta contaSalvo = contaBusiness.salvarConta(novaConta);

        System.out.printf("Conta salvo: %s", contaSalvo.toString());


        System.out.println("\n>>>>>>>>> SALDO <<<<<<<<<<<<<<<<<<");

        SaldoBusiness saldoBusiness = new SaldoBusiness(new SaldoDAO(), new ContaDAO());

        Saldo saldo = saldoBusiness.findByContaId(contaSalvo.getId());

        System.out.printf("Saldo: %s", saldo.toString());

        System.out.println("\n>>>>>>>>> CRIANDO DEPOSITO <<<<<<<<<<<<<<<<<<");

        Deposito depositoNovo = new Deposito();
        depositoNovo.setContaId(1L);
        depositoNovo.setData(hoje);
        depositoNovo.setValor(200.00);

        DepositoBusiness depositoBusiness = new DepositoBusiness(new DepositoDAO());

        Deposito deposito = depositoBusiness.salvarDeposito(depositoNovo);

        System.out.printf("Deposito: %s", deposito.toString());

        Saldo novoSaldoDepoisDoDeposito = saldoBusiness.atualizarValorDoSaldo(1L, saldo.getValor() + deposito.getValor());

        System.out.printf("\nSaldo Atualizado: %s", novoSaldoDepoisDoDeposito.toString());

        System.out.println("\n>>>>>>>>> CRIANDO SAQUE <<<<<<<<<<<<<<<<<<");

        Saque saqueNovo = new Saque();
        saqueNovo.setContaId(1L);
        saqueNovo.setData(hoje);
        saqueNovo.setValor(2000.00);

        SaqueBusiness saqueBusiness = new SaqueBusiness(new SaqueDAO());

        Saque saque = saqueBusiness.salvarSaque(saqueNovo);

        System.out.printf("Saque: %s", saque.toString());

        Saldo novoSaldoDepoisDoSaque= saldoBusiness.atualizarValorDoSaldo(1L, saldo.getValor() + deposito.getValor() - saque.getValor());

        System.out.printf("\nSaldo Atualizado: %s", novoSaldoDepoisDoSaque.toString());
    }
}
