create database if not exists qlsv;
use qlsv;

create table Class
(
	id int,
    `name` varchar(50)
);

create table Teacher
(
	id int,
    `name` varchar(50),
    age int,
    country varchar(50)
);
