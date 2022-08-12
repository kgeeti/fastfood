/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Classe Item
 */
package br.eti.kge.fastfood.domain.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Representa o Item do pedido.
 * @author KGe
 */
@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
    private Double qtd;
    private Double valorUnitario;
    private String obs;
    
//    @ManyToOne
//    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
//    Pedido pedido;

    public Item() {
    }

    public Item(long id, Produto produto, Double qtd, Double valorUnitario, String obs) {
        this.id = id;
        this.produto = produto;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.obs = obs;
    }

//    public Item(long id, Produto produto, Double qtd, Double valorUnitario, String obs, Pedido pedido) {
//        this.id = id;
//        this.produto = produto;
//        this.qtd = qtd;
//        this.valorUnitario = valorUnitario;
//        this.obs = obs;
//        this.pedido = pedido;
//    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

//    public Pedido getPedido() {
//        return pedido;
//    }
//
//    public void setPedido(Pedido pedido) {
//        this.pedido = pedido;
//    }
//    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", produto=" + produto + ", qtd=" + qtd + ", valorUnitario=" + valorUnitario + ", obs=" + obs + '}';
    }
 
    
    
    
}