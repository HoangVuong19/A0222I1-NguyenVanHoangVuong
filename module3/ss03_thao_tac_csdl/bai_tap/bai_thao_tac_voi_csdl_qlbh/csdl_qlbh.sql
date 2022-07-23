USE product;

-- 1 Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT * from `order`;

-- 2 Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.name, p.name from customer c 
join `order` o on c.id = o.customer_id 
join order_detail od on c.id = od.order_id
join product p on od.product_id = p.id;

-- 3 Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào 
SELECT * from customer WHERE id not in (SELECT customer_id FROM `order`);

-- 4 Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT o.id as `code`, o.date as `date`, sum(p.price * d.quantity) as total from `order` o
INNER JOIN order_detail d on d.order_id= o.id
INNER JOIN product p on p.id= d.product_id
GROUP BY o.id