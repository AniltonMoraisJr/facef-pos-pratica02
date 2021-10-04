package br.edu.unifacef.atividade.business;

import br.edu.unifacef.atividade.dao.ClienteDAO;
import br.edu.unifacef.atividade.model.Cliente;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ClientBusinessTest {

    @Mock
    private ClienteDAO clienteDAO;

    private Cliente clientMock;

    @Before
    public void setup(){
        this.clientMock = new Cliente();
        this.clientMock.setId(1L);
        this.clientMock.setNome("Maria");
        this.clientMock.setCidade("Passos");
        this.clientMock.setEstado("MG");
    }


    @Test
    public void deveSalvarClienteComSucesso(){
        Cliente clientNovo = new Cliente();
        clientNovo.setId(1L);
        clientNovo.setNome("Maria");
        clientNovo.setCidade("Passos");
        clientNovo.setEstado("MG");

        Mockito.when(this.clienteDAO.salvar(clientNovo)).thenReturn(this.clientMock);

        ClienteBusiness business = new ClienteBusiness(clienteDAO);

        Cliente clienteSalvo = business.salvarCliente(clientNovo);

        assertEquals(new Long(1L), clienteSalvo.getId());
    }

    @Test
    public void deveRetornarClienteComSucesso(){
        Mockito.when(this.clienteDAO.findById(1L)).thenReturn(this.clientMock);

        ClienteBusiness business = new ClienteBusiness(clienteDAO);

        Cliente clienteRetornado = business.findCliente(1l);

        assertEquals(new Long(1L), clienteRetornado.getId());
        assertEquals("Maria", clienteRetornado.getNome());
    }

    @Test
    public void naoDeveRetornarClienteComSucesso(){
        ClienteBusiness business = new ClienteBusiness(clienteDAO);
        try {
            Cliente clienteRetornado = business.findCliente(2l);
        } catch (Exception e) {
            assertEquals("Cliente não encontrado", e.getMessage());
        }

    }
}
