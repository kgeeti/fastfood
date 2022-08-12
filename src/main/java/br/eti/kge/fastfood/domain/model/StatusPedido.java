/**
 * FastFood API
 * API básica para melhoria e implementação.
 * 
 * Enum StatusPedido
 */
package br.eti.kge.fastfood.domain.model;

/**
 * Implementa os status de pedido do sistema.
 * ABERTO: Pedido incluido no sistema
 * EM_PREPARACAO: Pedido é aceito pela cozinha
 * FINALIZADO: Pedido pronto para entrega
 * ENTREGUE: Pedido entregue pelo atendimento
 * CANCELADO: Pedido cancelado.
 * 
 * @author KGe
 */
public enum StatusPedido {
    ABERTO, EM_PREPARACAO, FINALIZADO, ENTREGUE, CANCELADO
}
