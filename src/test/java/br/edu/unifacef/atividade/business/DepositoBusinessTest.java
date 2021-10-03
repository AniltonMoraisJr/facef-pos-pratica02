package br.edu.unifacef.atividade.business;

import br.edu.unifacef.atividade.dao.DepositoDAO;
import br.edu.unifacef.atividade.model.Deposito;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DepositoBusinessTest {

    @Mock
    private DepositoDAO depositoDAO;

    private Deposito depositoMock;

    @Before
    public void setup(){
        Date data = new Date(System.currentTimeMillis());

        this.depositoMock = new Deposito();
        this.depositoMock.setId(1L);
        this.depositoMock.setContaId(1L);
        this.depositoMock.setData(data);
        this.depositoMock.setValor(20.00);
    }

    @Test
    public void deveSalarDepositoComSucesso(){
        Date data = new Date(System.currentTimeMillis());

        Deposito depositoNovo = new Deposito();
        depositoNovo.setId(1L);
        depositoNovo.setContaId(1L);
        depositoNovo.setData(data);
        depositoNovo.setValor(20.00);

        Mockito.when(this.depositoDAO.salvar(depositoNovo)).thenReturn(this.depositoMock);

        DepositoBusiness business = new DepositoBusiness(depositoDAO);

        Deposito depositoSalvo = business.salvarDeposito(depositoNovo);

        assertEquals(new Long(1L), depositoSalvo.getId());
    }

    @Test
    public void deveRetonarDepositoComSucesso(){
        Mockito.when(this.depositoDAO.findById(1L)).thenReturn(this.depositoMock);

        DepositoBusiness business = new DepositoBusiness(depositoDAO);

        try {
            Deposito depositoRetornado = business.findDesposito(1L);
        } catch (Exception e){
            assertEquals("Deposito não encontrado", e.getMessage());
        }

    }

    @Test
    public void naoDeveRetornarDepositoComSucesso(){
        Mockito.when(this.depositoDAO.findById(1L)).thenReturn(this.depositoMock);

        DepositoBusiness business = new DepositoBusiness(depositoDAO);

        try {
            Deposito depositoRetornado = business.findDesposito(2L);
        } catch (Exception e){
            assertEquals("Deposito não encontrado", e.getMessage());
        }
    }

}
