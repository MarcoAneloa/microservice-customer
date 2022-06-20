-- Create database
create database if not exists inventory;
use inventory;

drop table if  exists customer;
drop table if  exists product;
drop table if  exists store;

-- Table Customer
create table customer (
	id int not null auto_increment,
    name varchar(150) not null,
    document varchar(50) not null,
    image varchar(50) not null,
    primary key (id)
);

-- Table Customer
create table product (
	id int not null auto_increment,
    cod varchar(150) not null,
    name varchar(50) not null,
    price double not null,
	stock int not null,
    primary key (id)
);

create table store (
	id int not null auto_increment,
    code varchar(50) not null,
    name varchar(150) not null,
    primary key (id)
);

insert into customer (name,document,image) values('Marco','11111111','logo.png');
insert into customer (name,document,image) values('Antonio','22222222','logo.png');

insert into store (name,code) values('El Veci','S1');
insert into store (name,code) values('El Tendero','S2');
insert into store (name,code) values('Chocolate','S3');
insert into store (name,code) values('Todo','S4');

-- select * from customer;
-- select * from product;
-- select * from store;
-- delete from product;