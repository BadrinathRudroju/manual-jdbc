create table if not exists users(id identity primary key, name varchar(100) not null );
truncate table users;
insert into users (name) values ('badri');
insert into users (name) values ('bablu');