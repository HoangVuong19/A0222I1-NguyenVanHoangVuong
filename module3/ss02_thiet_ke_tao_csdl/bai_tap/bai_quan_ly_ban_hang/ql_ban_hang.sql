CREATE DATABASE IF NOT EXISTS quan_ly_ban_hang;

use quan_ly_ban_hang;

CREATE TABLE customer (
	c_id int PRIMARY KEY AUTO_INCREMENT,
	c_name VARCHAR(50),
	c_age int
);

CREATE TABLE `order` (
	o_id int PRIMARY KEY AUTO_INCREMENT,
	customer_id int,
	o_date datetime,
	o_total_price double,
	FOREIGN KEY (customer_id) REFERENCES customer (c_id)
);

CREATE TABLE product (
	p_id int PRIMARY KEY AUTO_INCREMENT,
	p_name VARCHAR(50),
	p_price double
);

CREATE TABLE order_detail (
	order_id int,
	product_id int,
	quantity SMALLINT,
	PRIMARY KEY (order_id, product_id),
	FOREIGN KEY (order_id) REFERENCES `order` (o_id),
	FOREIGN KEY (product_id) REFERENCES product (p_id)
);