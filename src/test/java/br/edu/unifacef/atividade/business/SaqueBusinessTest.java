package br.edu.unifacef.atividade.business;

import br.edu.unifacef.atividade.dao.SaqueDAO;
import br.edu.unifacef.atividade.model.Saque;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SaqueBusinessTest {
    @Mock
    private SaqueDAO saqueDAO;

    private Saque saqueMock;

    @Before
    public void setup(){
        Date data = new Date(System.currentTimeMillis());

        this.saqueMock = new Saque();
        this.saqueMock.setId(1L);
        this.saqueMock.setContaId(1L);
        this.saqueMock.setData(data);
        this.saqueMock.setValor(20.00);

    }

    @Test
    public void deveSalvarSaqueComSucesso(){
        Date data = new Date(System.currentTimeMillis());

        Saque saqueNovo = new Saque();
        saqueNovo.setId(1L);
        saqueNovo.setContaId(1L);
        saqueNovo.setData(data);
        saqueNovo.setValor(20.00);

        Mockito.when(this.saqueDAO.salvar(saqueNovo)).thenReturn(this.saqueMock);

        SaqueBusiness business = new SaqueBusiness(saqueDAO);

        Saque saqueSalvo = business.salvarSaque(saqueNovo);

        assertEquals(new Long(1L), saqueSalvo.getId());

    }

    @Test
    public void deveRetonarSaqueComSucesso(){
        Mockito.when(this.saqueDAO.findById(1L)).thenReturn(this.saqueMock);

        SaqueBusiness business = new SaqueBusiness(saqueDAO);

        try {
            Saque saqueRetornado = business.findSaque(1L);
        } catch (Exception e){
            assertEquals("Saque não encontrado", e.getMessage());
        }

    }

    @Test
    public void naoDeveRetornarSaqueComSucesso(){
        Mockito.when(this.saqueDAO.findById(1L)).thenReturn(this.saqueMock);

        SaqueBusiness business = new SaqueBusiness(saqueDAO);

        try {
            Saque saqueRetornado = business.findSaque(2L);
        } catch (Exception e){
            assertEquals("Saque não encontrado", e.getMessage());
        }
    }
}
