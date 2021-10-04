package br.edu.unifacef.atividade.business;

import br.edu.unifacef.atividade.dao.ContaDAO;
import br.edu.unifacef.atividade.dao.SaldoDAO;
import br.edu.unifacef.atividade.model.Conta;
import br.edu.unifacef.atividade.model.Saldo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SaldoBusinessTest {
    @Mock
    private SaldoDAO saldoDAO;

    @Mock
    private ContaDAO contaDAO;

    private Saldo saldoMock;

    private Conta contaMock;

    @Before
    public void setup(){
        this.saldoMock = new Saldo();
        this.saldoMock.setId(1L);
        this.saldoMock.setContaId(1L);
        this.saldoMock.setValor(10000D);

        this.contaMock = new Conta();
        this.contaMock.setId(1L);
        this.contaMock.setClienteId(1L);
        this.contaMock.setNomeBanco("NuBank");
        this.contaMock.setNumeroConta(10001L);
        this.contaMock.setNumeroAgencia(1001L);
    }

    @Test
    public void deveRetornarSaldoPorId(){
        Mockito.when(this.saldoDAO.findById(1L)).thenReturn(this.saldoMock);

        SaldoBusiness business = new SaldoBusiness(this.saldoDAO, this.contaDAO);

        Saldo saldoRetornado = business.findById(1L);

        Assert.assertEquals(new Long(1L), saldoRetornado.getId());
        Assert.assertEquals(new Double(10000D), saldoRetornado.getValor());
    }

    @Test
    public void naoDeveRetornarSaldoErroSaldoNaoEncontrado(){
        SaldoBusiness business = new SaldoBusiness(this.saldoDAO, this.contaDAO);
        try{
            Saldo saldoRetornado = business.findById(2L);
        } catch (Exception e){
            Assert.assertEquals(RuntimeException.class, e.getClass());
            Assert.assertEquals("Saldo não encontrado.", e.getMessage());
        }
    }

    @Test
    public void deveRetornarSaldoPorContaId(){
        Mockito.when(this.contaDAO.findById(1L)).thenReturn(this.contaMock);
        Mockito.when(this.saldoDAO.findByContaId(1L)).thenReturn(this.saldoMock);

        SaldoBusiness business = new SaldoBusiness(this.saldoDAO, this.contaDAO);

        Saldo saldoRetornado = business.findByContaId(1L);

        Assert.assertEquals(new Long(1L), saldoRetornado.getId());
        Assert.assertEquals(this.contaMock.getId(), saldoRetornado.getContaId());
        Assert.assertEquals(new Double(10000D), saldoRetornado.getValor());
    }

    @Test
    public void naoDeveRetornarSaldoErroContaNaoEncontrado(){

        SaldoBusiness business = new SaldoBusiness(this.saldoDAO, this.contaDAO);

        try{
            Saldo saldoRetornado = business.findByContaId(2L);
        } catch (Exception e){
            Assert.assertEquals(RuntimeException.class, e.getClass());
            Assert.assertEquals("Conta não encontrado.", e.getMessage());
        }
    }

    @Test
    public void deveAtualizarSaldoPorContIdComSucesso(){
        Mockito.when(this.contaDAO.findById(1L)).thenReturn(this.contaMock);
        Mockito.when(this.saldoDAO.findByContaId(1L)).thenReturn(this.saldoMock);

        SaldoBusiness business = new SaldoBusiness(this.saldoDAO, this.contaDAO);

        Saldo saldoRetornado = business.atualizarValorDoSaldo(1L, this.saldoMock.getValor() - 1000D);

        Assert.assertEquals(new Long(1L), saldoRetornado.getId());
        Assert.assertEquals(new Double(9000D), saldoRetornado.getValor());
    }
}
