package br.edu.unifacef.atividade.business;

import br.edu.unifacef.atividade.dao.ClienteDAO;
import br.edu.unifacef.atividade.dao.ContaDAO;
import br.edu.unifacef.atividade.model.Cliente;
import br.edu.unifacef.atividade.model.Conta;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ContaBusinessTest {

    @Mock
    private ClienteDAO clienteDAO;

    @Mock
    private ContaDAO contaDAO;

    private Cliente clientMock;

    private Conta contaMock;

    @Before
    public void setup(){
        this.clientMock = new Cliente();
        this.clientMock.setId(1L);
        this.clientMock.setNome("Maria");
        this.clientMock.setCidade("Passos");
        this.clientMock.setEstado("MG");

        this.contaMock = new Conta();
        this.contaMock.setId(1L);
        this.contaMock.setClienteId(this.clientMock.getId());
        this.contaMock.setNomeBanco("NuBank");
        this.contaMock.setNumeroConta(10001L);
        this.contaMock.setNumeroAgencia(1001L);

    }

    @Test
    public void deveSalvarContaComSucesso(){
        Conta novaConta = new Conta();
        novaConta.setId(1L);
        novaConta.setClienteId(1L);
        novaConta.setNomeBanco("NuBank");
        novaConta.setNumeroConta(10001L);
        novaConta.setNumeroAgencia(1001L);

        Mockito.when(this.clienteDAO.findById(novaConta.getClienteId())).thenReturn(this.clientMock);
        Mockito.when(this.contaDAO.salvar(novaConta)).thenReturn(this.contaMock);

        ContaBusiness business = new ContaBusiness(this.clienteDAO, this.contaDAO);

        Conta contaSalva = business.salvarConta(novaConta);


    }
}
