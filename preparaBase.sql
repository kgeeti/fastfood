# ---------------------------------
# Limpa database antigo
# ---------------------------------

drop database kge_fastfood;
create database kge_fastfood;
use kge_fastfood;

# ---------------------------------
# Cria e popula tabela Cliente
# ---------------------------------

create table cliente (
	id bigint auto_increment,
    nome varchar(60) not null,
    endereco varchar(200),
    cidade varchar(60),
    uf varchar(2),
    cep varchar(8),
    primary key (id)
);

insert into cliente(nome) values
("Retira Balcao"),
("Cliente A"),
("Cliente B"),
("Cliente C"),
("Cliente D");

# ---------------------------------
# Cria e popula tabela Produto
# ---------------------------------

create table produto(
	id bigint auto_increment,
    descricao varchar(100),
    qtd decimal(10,2),
    valor_unitario decimal(10,2),
    primary key(id)
);

insert into produto(descricao, qtd, valor_unitario) values
("X-Salada", 100, 20),
("X-Tudo", 100, 28.90),
("X-Baicon", 100, 27.90),
("Refrigerante Coca Cola", 80, 6.50),
("Refrigerante Guarana", 80, 6.50),
("Batata Frita", 100, 8);


# ---------------------------------
# Cria e tabela Pedido
# ---------------------------------

create table pedido(
	id bigint auto_increment,
    id_cliente bigint not null,
    aberto_em datetime,
    fechado_em datetime,
    status varchar(20),
    obs varchar(200),
    primary key(id),
    foreign key fk_cliente(id_cliente) references cliente(id)
);

# ---------------------------------
# Cria e tabela Item de Pedido
# ---------------------------------
    
create table item(
	id bigint auto_increment,
    id_pedido bigint,
    id_produto bigint,
    qtd decimal(10,2),
    valor_unitario decimal(10,2),
    obs varchar(60),
    primary key(id),
    foreign key fk_pedido(id_pedido) references pedido(id),
    foreign key fk_produto(id_produto) references produto(id)
);


# ---------------------------------
# Popula Pedido e Item
# ---------------------------------
insert into pedido(id_cliente, aberto_em, status, obs) values
(1, current_timestamp() - interval 2 hour, "ABERTO", "Retira"),
(2, current_timestamp() - interval 1 hour, "ABERTO", "Sem cebola"),
(3, current_timestamp() - interval 30 minute , "ABERTO", ""),
(4, current_timestamp(), "ABERTO", "");

insert into item(id_pedido, id_produto, qtd, valor_unitario, obs) values
(1, 1, 2, 20, "Sem Maionese"),
(1, 2, 1, 28.90, ""),
(1, 6, 2, 8, ""),
(1, 4, 2, 6.50, ""),

(2, 1, 1, 20, ""),
(2, 6, 1, 8, ""),
(2, 4, 1, 6.50, ""),

(3, 2, 2, 28.9, ""),
(3, 6, 2, 8, ""),
(3, 4, 2, 6.50, "");



# ---------------------------------
# Select para analisar cadastro de pedidos
# ---------------------------------
select 
	pedido.id, 
    pedido.aberto_em,
    pedido.fechado_em,
    pedido.status,
    pedido.id_cliente, 
    cliente.nome, 
    item.id, 
    item.id_pedido, 
    item.id_produto, 
    produto.descricao, 
    item.qtd, 
    item.valor_unitario, 
    item.qtd * item.valor_unitario as valor_total
from pedido, cliente, item, produto
where 
	cliente.id = pedido.id_cliente AND
	item.id_pedido = pedido.id AND
    produto.id = item.id_produto

order by
	pedido.aberto_em;
    
