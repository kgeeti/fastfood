/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Repositório: Pedido
 */
package br.eti.kge.fastfood.domain.repository;

import br.eti.kge.fastfood.domain.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório Pedido
 * 
 * @author KGe
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
    List<Pedido> findByStatus(String status);

}