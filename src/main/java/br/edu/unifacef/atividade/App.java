package br.edu.unifacef.atividade;

import br.edu.unifacef.atividade.business.ClienteBusiness;
import br.edu.unifacef.atividade.dao.ClienteDAO;
import br.edu.unifacef.atividade.model.Cliente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "########### ATIVIDADE 02 ###############" );
        
        System.out.println(">>>>>>>>> CRIANDO CLIENTE <<<<<<<<<<<<<<<<<<");
        
        Cliente novoCliente = new Cliente();
        novoCliente.setNome("José");
        novoCliente.setCidade("Franca");
        novoCliente.setEstado("SP");        
        
        ClienteBusiness clienteBusiness = new ClienteBusiness(new ClienteDAO());
        
        Cliente clienteSalvo = clienteBusiness.salvarCliente(novoCliente);
        
        System.out.println(String.format("Cliente salvo: %s", clienteSalvo.toString()));
        
        System.out.println(">>>>>>>>> CRIANDO CONTA <<<<<<<<<<<<<<<<<<");
        
        
    }
}
