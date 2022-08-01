use quan_ly_furama;
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT * FROM nhan_vien 
WHERE SUBSTRING_INDEX(ho_ten, ' ', - 1) REGEXP '^[HTK]' AND LENGTH(ho_ten) <= 15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT * FROM khach_hang
WHERE YEAR(now()) - YEAR(ngay_sinh) BETWEEN 18 AND 50 AND(dia_chi LIKE '%Quảng Trị' OR dia_chi LIKE '%Đà Nẵng');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT k.ho_ten, count(h.ma_khach_hang) as solandat
FROM khach_hang k
	JOIN loai_khach lk ON k.ma_khach_hang = lk.ma_loai_khach
	JOIN hop_dong h ON k.ma_khach_hang = h.ma_khach_hang
WHERE lk.ten_loai_khach = 'Diamond'
GROUP BY h.ma_khach_hang
ORDER BY solandat;

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
SELECT kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hct.so_luong * dvk.gia + dv.chi_phi_thue as tong_tien
FROM khach_hang kh
	LEFT JOIN loai_khach lk on lk.ma_loai_khach= kh.ma_loai_khach
	LEFT JOIN hop_dong hd on hd.ma_khach_hang= kh.ma_khach_hang
	LEFT JOIN dich_vu dv on hd.ma_dich_vu= dv.ma_dich_vu
	LEFT JOIN hop_dong_chi_tiet hct on hd.ma_hop_dong = hct.ma_hop_dong
    LEFT JOIN dich_vu_di_kem dvk on hct.ma_dich_vu_di_kem = dvk.ma_dich_vu_di_kem
    LEFT JOIN (SELECT kh.ma_khach_hang as id, kh.ho_ten, sum(dv.chi_phi_thue) as price
			   FROM khach_hang kh
				JOIN hop_dong hd on kh.ma_khach_hang= hd.ma_khach_hang
				JOIN dich_vu dv on hd.ma_dich_vu= dv.ma_dich_vu
			   GROUP BY kh.ma_khach_hang) tmp on tmp.id = kh.ma_Khach_hang;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện
-- đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
SELECT *
FROM dich_vu dv JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
WHERE NOT EXISTS (SELECT * 
				  FROM hop_dong hd 
                  WHERE hd.ma_dich_vu = dv.ma_dich_vu AND ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-03-31');

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
-- đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
SELECT *
FROM dich_vu dv JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
WHERE EXISTS (SELECT *
			  FROM hop_dong
			  WHERE ma_dich_vu = dv.ma_dich_vu AND YEAR(ngay_lam_hop_dong) = '2020') AND NOT EXISTS (SELECT *
																					  FROM hop_dong
																					  WHERE ma_dich_vu = dv.ma_dich_vu AND YEAR(ngay_lam_hop_dong) = '2021');
                                                                                  
-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
SELECT DISTINCT kh.ho_ten
FROM khach_hang kh;

-- 9. 	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
SELECT month(ngay_lam_hop_dong) AS `month`, count(ma_khach_hang) AS so_khach
FROM hop_dong hd 
WHERE YEAR(ngay_lam_hop_dong) = '2021'
GROUP BY `month`
order by `month`;

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
SELECT
	hd.ma_hop_dong,
	hd.ngay_lam_hop_dong,
	hd.ngay_ket_thuc,
	hd.tien_dat_coc,
	COUNT(dvk.ma_dich_vu_di_kem) so_luong
FROM hop_dong hd LEFT JOIN hop_dong_chi_tiet hct ON hd.ma_hop_dong = hct.ma_hop_dong
				 LEFT JOIN dich_vu_di_kem dvk on hct.ma_dich_vu_di_kem = dvk.ma_dich_vu_di_kem
GROUP BY hd.ma_hop_dong;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” 
-- hoặc “Quảng Ngãi”.
SELECT kh.ho_ten, dvk.ten_dich_vu_di_kem, dvk.gia
FROM dich_vu dv
	JOIN hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu
	JOIN hop_dong_chi_tiet hct ON hd.ma_hop_dong = hct.ma_hop_dong
	JOIN dich_vu_di_kem dvk ON hct.ma_dich_vu_di_kem = dvk.ma_dich_vu_di_kem
	JOIN khach_hang kh ON kh.ma_khach_hang = hd.ma_khach_hang
	JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE lk.ten_loai_khach = 'Diamond' AND kh.dia_chi in('Vinh', 'Quảng Ngãi');

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, 
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được 
-- khách hàng đặt vào 6 tháng đầu năm 2021.
SELECT hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dvk.ten_dich_vu_di_kem, sum(dvk.ma_dich_vu_di_kem) as so_luong, hd.tien_dat_coc
FROM dich_vu dv
	JOIN hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu
	JOIN nhan_vien nv ON nv.ma_nhan_vien = hd.ma_nhan_vien
	JOIN khach_hang kh ON kh.ma_khach_hang = hd.ma_khach_hang
	JOIN hop_dong_chi_tiet hct ON hd.ma_hop_dong = hct.ma_hop_dong
	JOIN dich_vu_di_kem dvk ON hct.ma_dich_vu_di_kem = dvk.ma_dich_vu_di_kem
WHERE (hd.ngay_lam_hop_dong BETWEEN '2020-10-01' AND '2020-12-30') and(hd.ngay_lam_hop_dong NOT BETWEEN '2021-01-01' AND '2021-06-30')
GROUP BY hd.ma_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
SELECT dvk.ten_dich_vu_di_kem, count(*) AS amount
FROM dich_vu_di_kem dvk JOIN hop_dong_chi_tiet hct ON dvk.ma_dich_vu_di_kem = hct.ma_dich_vu_di_kem
GROUP BY dvk.ten_dich_vu_di_kem
order by amount desc;

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
SELECT dvk.ten_dich_vu_di_kem, count(*) AS amount
FROM dich_vu_di_kem dvk JOIN hop_dong_chi_tiet hct ON dvk.ma_dich_vu_di_kem = hct.ma_dich_vu_di_kem
GROUP BY dvk.ten_dich_vu_di_kem
having amount = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
SELECT nv.ho_ten, td.ten_trinh_do, tr.ten_vi_tri, nv.so_dien_thoai, nv.dia_chi, count(nv.ma_nhan_vien) amount
FROM nhan_vien nv
	JOIN trinh_do td ON nv.ma_trinh_do = td.ma_trinh_do
	JOIN vi_tri tr ON nv.ma_vi_tri = tr.ma_vi_tri
	JOIN hop_dong hd ON hd.ma_nhan_vien = nv.ma_nhan_vien
WHERE YEAR(hd.ngay_lam_hop_dong) BETWEEN '2020' AND '2021'
GROUP BY nv.ma_nhan_vien
HAVING amount <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
DELETE FROM nhan_vien nv
WHERE NOT EXISTS (SELECT *
				  FROM hop_dong hd
				  WHERE ma_nhan_vien = nv.ma_nhan_vien AND YEAR(hd.ngay_lam_hop_dong) BETWEEN 2019 AND 2021);
                  
-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ. 
UPDATE khach_hang
SET ma_loai_khach = 1
WHERE ma_khach_hang in (SELECT tmp.ma_khach_hang 
					    FROM (SELECT DISTINCT kh.ma_khach_hang, sum(dv.chi_phi_thue + dvk.gia * hct.so_luong) AS tong_tien 
								FROM khach_hang kh
									JOIN hop_dong hd ON hd.ma_khach_hang = kh.ma_khach_hang
									JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
									JOIN hop_dong_chi_tiet hct ON hct.ma_hop_dong = hd.ma_hop_dong
									JOIN dich_vu_di_kem dvk ON dvk.ma_dich_vu_di_kem = hct.ma_dich_vu_di_kem
								WHERE kh.ma_loai_khach = 2 AND YEAR(hd.ngay_lam_hop_dong) = 2021
								GROUP BY hd.ma_hop_dong
								HAVING tong_tien > 1000000) AS tmp);   
                                
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
DELETE
FROM khach_hang kh WHERE NOT EXISTS (SELECT * 
									 FROM hop_dong hd
                                     WHERE YEAR(ngay_lam_hop_dong) >= 2021 AND hd.ma_khach_hang = kh.ma_khach_hang);
                                     
-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
UPDATE dich_vu_di_kem
SET gia = gia * 2
WHERE ma_dich_vu_di_kem in(SELECT tmp.ma_dich_vu_di_kem 
			               FROM (SELECT DISTINCT dvk.ma_dich_vu_di_kem 
								 FROM dich_vu_di_kem dvk
									JOIN hop_dong_chi_tiet hct ON hct.ma_dich_vu_di_kem = dvk.ma_dich_vu_di_kem
									JOIN hop_dong hd ON hd.ma_hop_dong = hct.ma_hop_dong
								 WHERE YEAR(hd.ngay_lam_hop_dong) = 2020
								 GROUP BY hct.ma_dich_vu_di_kem
								 HAVING COUNT(hct.ma_dich_vu_di_kem) >= 1) AS tmp);                                     

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.  
SELECT ma_nhan_vien, ho_ten, so_dien_thoai, ngay_sinh, dia_chi FROM nhan_vien
UNION ALL
SELECT ma_khach_hang, ho_ten, so_dien_thoai, ngay_sinh, dia_chi FROM khach_hang;

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và 
-- đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
Create VIEW v_nhan_vien 
AS
SELECT nv.ma_nhan_vien, nv.ho_ten, nv.dia_chi
FROM nhan_vien nv JOIN hop_dong hd ON hd.ma_nhan_vien = nv.ma_nhan_vien
WHERE year(hd.ngay_lam_hop_dong) = "2019/12/12" AND nv.dia_chi = "Hải Châu"
GROUP BY hd.ma_nhan_vien
HAVING count(hd.ma_nhan_vien) >= 1; 

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này. 
UPDATE v_nhan_vien vnv set vnv.dia_chi = 'Liên Chiểu';  

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó 
-- với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
DELIMITER //
CREATE PROCEDURE sp_xoa_khach_hang(id_khach_hang int)
BEGIN
DELETE FROM khach_hang WHERE ma_khach_hang = id_khach_hang;
END
// DELIMITER ;    

-- 24.  Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện
--  kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.                     

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản 
-- ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.
