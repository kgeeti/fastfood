/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Controller ProdutoController
 */
package br.eti.kge.fastfood.api.controller;

import br.eti.kge.fastfood.domain.model.Produto;
import br.eti.kge.fastfood.domain.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa RestController de Produto
 * @author KGe
 */
@RestController
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @GetMapping("/produto")
    public List<Produto> showAllProduto() {
        return produtoRepository.findAll();
    }
    
    // TODO Implementar metodo showById
    // TODO Implementar métodos POST PUT DELETE
    
    
}
