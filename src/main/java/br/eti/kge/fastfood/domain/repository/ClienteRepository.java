/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Repository: Cliente
 */
package br.eti.kge.fastfood.domain.repository;

import br.eti.kge.fastfood.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório Cliente
 * @author KGe
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    Cliente findById(long id);
    

}
