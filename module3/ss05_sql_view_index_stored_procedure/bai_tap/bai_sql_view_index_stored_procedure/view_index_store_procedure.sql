create database demo;
use demo;

create table product(
id int primary key not null auto_increment,
code varchar(50),
name varchar(50),
price double,
amount int,
`description` varchar(100),
`status` int
);

insert into product (code,name,price,amount,description,status) values
('code1','name1',1,1,'description1',0),
('code2','name2',2,2,'description1',0),
('code3','name3',3,3,'description1',0),
('code4','name4',4,4,'description1',0),
('code5','name5',5,5,'description1',0),
('code6','name6',6,6,'description1',0),
('code7','name7',7,7,'description1',0),
('code8','name8',8,8,'description1',0);

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
ALTER TABLE product add INDEX idx_code(`code`);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
ALTER TABLE product add INDEX composite_idx_name_price(`name`, price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * from product WHERE code = 'code1';

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE view check_view 
as
SELECT `code`, `name`, price, status FROM product;
SELECT * from check_view;

-- Tiến hành sửa đổi view
update check_view set `name`= 'asss' WHERE `code`= 'code1';

-- Tiến hành xoá view
drop view check_view;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
CREATE PROCEDURE getAll()
BEGIN
	SELECT * from product;
END 
// DELIMITER ;
call getAll();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
CREATE PROCEDURE add_product(pcode VARCHAR(50), pname VARCHAR(50), pprice DOUBLE)
BEGIN
INSERT INTO product (`code`, `name`, price) VALUE(pcode, pname, pprice);
END 
// DELIMITER ;
CALL add_product('AP', 'apple', 123);

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
create procedure update_product_by_id(pid int,pcode varchar(50),pname varchar(50),pprice double, pamount int, pdescription varchar(100), pstatus tinyint)
begin
update product
set name=pname,code=pcode,price=pprice,amount=pamount,description=pdescription,status=pstatus
where id=pid;
end
// DELIMITER ;
call update_product_by_id(1,'editcode','editname',9,9,'editdescription',1);

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER //
CREATE PROCEDURE delete_product_id(pid int)
BEGIN
DELETE FROM product WHERE id= pid;
END
// DELIMITER ;
CALL delete_product_id(1);



