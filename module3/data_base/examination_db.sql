create database products_management;

use products_management;

create table category
(
	id int primary key auto_increment,
    category_name varchar(255)
);

create table product 
(
	product_id int primary key auto_increment,
	product_name varchar(255),
    price double,
    quantity int,
    color varchar(255),
    `description` varchar(255),
    category_id int,
    foreign key(category_id) references category(id)
);

insert into category(category_name) value ("Phone"),("Television"),("Laptop"),("Headphone");

insert into product(product_name, price, quantity, color, `description`, category_id) 
value ("iPhone 11", 799.0, 12, "Purple, Yellow", "real", 1),
("iPhone 11 Pro", 1100.0, 12, "Black, White", "real", 1),
("iPhone X", 749.0, 13, "Black, Blue", "real", 1),
("Smart TV 4K", 100000.0, 12, "Black", "real", 2),
("Galaxy s10", 420.0, 12, "Black, Blue", "real", 1);

select * from product;

select * from category;

insert into product(product_name, price, quantity, color, `description`, category_id) value ("Zfold 3", 1200.0, 10, "White, Black", "real", 1);

select * from product where product_id = 1;

SET SQL_SAFE_UPDATES = 0;

update product set product_name = "Mac air 2020", price = 1000.0, quantity = 20, color = "Black, White", `description` = "real", category_id = 3 where product_id = 7;

delete from product where product_id = 6;

delimiter //
create procedure search_by_name(in product_name varchar(255))
begin
select * from product p where p.product_name like concat('%',product_name,'%');
end //
delimiter ;

call search_by_name('');