drop database kge_fastfood;
create database kge_fastfood;
use kge_fastfood;


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
("Cliente 1"),
("Cliente 2"),
("Cliente 3");

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
    
create table item(
	id bigint auto_increment,
    id_pedido bigint not null,
    id_produto bigint not null,
    qtd decimal(10,2),
    valor_unitario decimal(10,2),
    obs varchar(60),
    primary key(id),
    foreign key fk_pedido(id_pedido) references pedido(id),
    foreign key fk_produto(id_produto) references produto(id)
);
