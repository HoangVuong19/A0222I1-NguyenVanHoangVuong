create database contract_management;

use contract_management;

create table book
(
	book_id int primary key auto_increment,
    book_name varchar(255),
    amount int
);

create table customer 
(
	customer_id int primary key auto_increment,
	customer_name varchar(255),
    phone varchar(255),
    email varchar(255),
    address varchar(255)
);

create table contract
(
	id int primary key auto_increment,
    rent_time date,
    `status` varchar(255),
    rent_amount int,
    book_id int,
    customer_id int,
    foreign key(book_id) references book(book_id),
    foreign key(customer_id) references customer(customer_id)
);

insert into book(book_name, amount) 
value ("Đắc nhân tâm", 12),
("Người giàu tiêu tiền", 10),
("Hạnh phúc", 22),
("Chí giả", 12),
("Bộ sưu tập của quỷ", 14);

insert into customer(customer_name, phone, email, address) 
value ("Hoàng Long", "0945678234", "longhoang@gmail.com", "Đà Nẵng"),
("Vĩnh Phúc", "0942376943", "phucvinh@gmail.com", "Đà Nẵng"),
("Trần Chí Đạt", "0941349345", "dattran@gmail.com", "Đà Nẵng"),
("Huỳnh Minh", "0947845670", "minhhuynh@gmail.com", "HCM"),
("Thiên An", "0944354535", "anthien@gmail.com", "Hà Nội");

-- Khi Tạo mới contract, với status là "Đang thuê" tính lại amount trong bảng Book
delimiter //
create trigger update_book
after insert on contract for each row
begin
	UPDATE book 
	SET amount = amount - new.rent_amount
	WHERE book_id = new.book_id;
end //
delimiter ;

-- Khi sửa contract, nếu old.status là "Đang thuê" và new.status là "Đang thuê" tính lại amount trong bảng Book
delimiter //
create trigger edit_book_continue
after update on contract for each row
begin
	UPDATE book 
	SET amount = amount + old.rent_amount - new.rent_amount
	WHERE book_id = old.book_id and new.`status` = "Đang thuê" and old.`status` = "Đang thuê";
end //
delimiter ;

-- Khi sửa contract, nếu old.status là "Đã trả" và new.status là "Đang thuê" tính lại amount trong bảng Book
delimiter //
create trigger edit_book_begin
after update on contract for each row
begin
	UPDATE book 
	SET amount = amount - new.rent_amount
	WHERE book_id = old.book_id and new.`status` = "Đang thuê" and old.`status` = "Đã trả";
end //
delimiter ;

-- Khi sửa contract, nếu status là "Đã trả" tính lại amount trong bảng Book
delimiter //
create trigger edit_book_return
after update on contract for each row
begin
	UPDATE book 
	SET amount = amount + old.rent_amount
	WHERE book_id = old.book_id and new.`status` = "Đã trả";
end //
delimiter ;

-- Khi xóa contract, tính lại amount trong bảng Book
delimiter //
create trigger delete_book
after delete on contract for each row
begin
	UPDATE book 
	SET amount = amount + old.rent_amount
	WHERE book_id = old.book_id;
end //
delimiter ;

insert into contract(rent_time, `status`, rent_amount, book_id, customer_id) value ("2021-09-22", "Đang thuê", 1, 1, 4);
insert into contract(rent_time, `status`, rent_amount, book_id, customer_id) value ("2021-09-11", "Đang thuê", 2, 2, 2);
insert into contract(rent_time, `status`, rent_amount, book_id, customer_id) value ("2021-10-25", "Đang thuê", 1, 5, 2);
insert into contract(rent_time, `status`, rent_amount, book_id, customer_id) value ("2021-10-26", "Đang thuê", 3, 4, 1);

update contract set rent_time = "2020-06-12", `status` = "Đang thuê", rent_amount = 3, customer_id = 5 where id = 2;

delete from contract where id = 5;

select * from contract;

select * from contract where id = 1;

delimiter //
create procedure search_by_book(in book_name varchar(255))
begin
select * from contract c join book b on c.book_id = b.book_id where b.book_name like concat('%',book_name,'%');
end //
delimiter ;

call search_by_book('c');

insert into customer(customer_name, phone, email, address) value ("Hoàng Anh", "0947856768", "anhhoang@gmail.com", "Đà Nẵng");