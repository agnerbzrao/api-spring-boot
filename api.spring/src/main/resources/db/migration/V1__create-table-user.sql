create table user(

    id bigint not null auto_increment,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(100) not null,
    age bigint(3) not null,
    primary key(id)
);