use quanlysinhvien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject
where Credit = (select max(Credit) from subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select * from subject inner join mark on subject.SubId = mark.SubId
where Mark = (select max(Mark) from subject inner join mark on subject.SubId = mark.SubId);


-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select StudentName, Phone, Address, avg(mark) from student s
join mark m on m.StudentId= s.StudentId
group by s.StudentId
ORDER BY avg(mark) DESC;

