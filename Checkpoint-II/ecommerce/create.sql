create table address (id integer not null auto_increment, cep varchar(255), city varchar(255), country varchar(255), district varchar(255), state varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table category (id integer not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table category_product (id_category integer not null, id_product integer not null, primary key (id_category, id_product)) engine=InnoDB;
create table product (id integer not null auto_increment, description TEXT, image TEXT, price double precision, title varchar(255), primary key (id)) engine=InnoDB;
alter table category_product add constraint FKe237utwkkgbrtq2wag1loclw5 foreign key (id_product) references product (id);
alter table category_product add constraint FKq6aunj8k00n0osel6ijgu9hki foreign key (id_category) references category (id);
