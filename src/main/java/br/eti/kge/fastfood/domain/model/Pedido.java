/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Classe Pedido
 */
package br.eti.kge.fastfood.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * Representa o Pedido
 * 
 * @author KGe
 */
@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private LocalDateTime abertoEm;
    private LocalDateTime fechadoEm;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    private String obs;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    private List<Item> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(long id, Cliente cliente, LocalDateTime abertoEm, LocalDateTime fechadoEm, StatusPedido status, String obs, List<Item> itens) {
        this.id = id;
        this.cliente = cliente;
        this.abertoEm = abertoEm;
        this.fechadoEm = fechadoEm;
        this.status = status;
        this.obs = obs;
        this.itens = itens;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getAbertoEm() {
        return abertoEm;
    }

    public void setAbertoEm(LocalDateTime abertoEm) {
        this.abertoEm = abertoEm;
    }

    public LocalDateTime getFechadoEm() {
        return fechadoEm;
    }

    public void setFechadoEm(LocalDateTime fechadoEm) {
        this.fechadoEm = fechadoEm;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Pedido other = (Pedido) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        String aux = "Pedido{" + "id=" + id + ", cliente=" + cliente + ", abertoEm=" + abertoEm + ", fechadoEm=" + fechadoEm + ", status=" + status + ", obs=" + obs;
        aux += "\n\nItens {";
        
        for(Item item : this.itens) {
            aux += "\t" + item.toString() + "\n";
        }
                
                
        return aux;
    }
    
    
    
}
