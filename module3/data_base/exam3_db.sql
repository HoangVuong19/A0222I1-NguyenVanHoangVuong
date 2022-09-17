create database hire_management;

use hire_management;

create table contract 
(
	id int primary key auto_increment,
    plant_id varchar(255),
    `area` int,
    `status` varchar(255),
	floor int,
	plant_type varchar(255), 
    price double,
    start_date date,
    end_date date
);

insert into contract(plant_id, `area`, `status`, floor, plant_type, price, start_date, end_date) 
value ("MBA0001", 50, "Trống", 1, "Cho thuê", 2000000.0, "2021-01-01", "2021-08-01"),
("MBA0002", 100, "Hạ tầng", 2, "Trọn gói", 3000000.0, "2021-02-01", "2021-09-01"),
("MBA0003", 150, "Đầy đủ", 3, "Cho thuê", 4000000.0, "2021-03-01", "2021-10-01");

select * from contract order by `area`;

insert into contract(plant_id, `area`, `status`, floor, plant_type, price, start_date, end_date) value ("MBA0004", 50, "Đầy đủ", 3, "Trọn gói", 3000000, "2021-02-01", "2021-09-01");

select * from contract c where c.plant_type like concat('%',"t",'%');

select * from contract c where c.floor = 1;

select * from contract c where c.price = 1.0;

delimiter //
create procedure search_contract(in plant_type varchar(255), in floor_i int, in price_i double)
begin
select * from contract c where c.plant_type like concat('%',plant_type,'%') and c.floor = floor_i and c.price = price_i;
end //
delimiter ;

call search_contract('',2,null);