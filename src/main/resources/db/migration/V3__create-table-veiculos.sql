create table veiculos(

    id bigint not null auto_increment,
    modelo varchar(100) not null,
    marca varchar(100) not null,
    placa varchar(7) not null,

    primary key(id)

);