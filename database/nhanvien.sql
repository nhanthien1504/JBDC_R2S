-- 3 .Tìm các nhân viên có lương nhỏ hơn 10,000.
select * from nhanvien;
select * from nhanvien where Luong <= 10000;

-- 8.	Cho biết tổng số lương phải trả cho các nhân viên.
select sum(Luong) as tongluong from nhanvien;

-- 9.	Cho biết mã số của các phi công lái máy báy Boeing

select cn.MaNV
from chungnhan as cn
	inner join maybay as mb on cn.MaMB = mb.MaMB
where mb.Loai like 'Boeing%';


-- 10.	Cho biết các nhân viên có thể lái máy bay có mã số 747.

select cn.MaNV, nv.Ten
from chungnhan as cn
	inner join nhanvien as nv on nv.MaNV = cn.MaNV
	inner join maybay as mb on cn.MaMB = mb.MaMB
where mb.MaMB = 747;

-- 11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.

select mb.MaMB, nv.Ten
from chungnhan as cn
	inner join nhanvien as nv on nv.MaNV = cn.MaNV
	inner join maybay as mb on cn.MaMB = mb.MaMB
where nv.Ten like 'Nguyễn%';

-- 12.	Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
select distinct nv.Ten
from chungnhan as cn
	inner join nhanvien as nv on nv.MaNV = cn.MaNV
	inner join maybay as mb on cn.MaMB = mb.MaMB
where mb.Loai like 'Boeing%'
and nv.Ten in 
(
select nv.Ten
from chungnhan as cn
	inner join nhanvien as nv on nv.MaNV = cn.MaNV
	inner join maybay as mb on cn.MaMB = mb.MaMB
where mb.Loai like 'Airbus%');

-- 26.	Cho biết mã số của các nhân viên có lương cao nhất.
select Ten, max(Luong) from nhanvien where Luong;

-- 25.	Tìm các nhân viên không phải là phi công.
-- phi cong
select nv.Ten from nhanvien as nv
inner join chungnhan as cn on nv.MaNV = cn.MaNV;


select * from nhanvien as nv where nv.Ten not in (select nv.Ten from nhanvien as nv
inner join chungnhan as cn on nv.MaNV = cn.MaNV);


-- 24. Với mỗi phi công cho biết mã số phi công và tổng số loại máy bay mà phi công đó có thể lái.
-- phi cong
select nv.MaNV ,nv.Ten from nhanvien as nv
inner join chungnhan as cn on nv.MaNV = cn.MaNV;

select nv.MaNV ,nv.Ten, count(nv.Ten) as soluongmaybay from nhanvien as nv
inner join chungnhan as cn on nv.MaNV = cn.MaNV
group by nv.Ten;

-- 23.	Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay, cho biết mã số phi công 
-- và tầm bay lớn nhất của các loại máy bay mà phi công đó có thể lái.
-- --------------------------------------------------------------------

select nv.MaNV, nv.Ten, count(nv.Ten), max(mb.TamBay) from nhanvien as nv
inner join chungnhan as cn on nv.MaNV = cn.MaNV
inner join maybay as mb on mb.MaMB = cn.MaMB
group by nv.Ten
having count(nv.Ten) > 3;


-- 22.	Cho biết mã số của các phi công chỉ lái được 3 loại máy bay

select nv.MaNV, nv.Ten, count(nv.Ten) from nhanvien as nv
inner join chungnhan as cn on nv.MaNV = cn.MaNV
inner join maybay as mb on mb.MaMB = cn.MaMB
group by nv.Ten
having count(nv.Ten) = 3;

-- 15.	Cho biết tên của các phi công lái máy bay Boeing.

select nv.Ten from maybay as mb
inner join chungnhan as cn on cn.MaMB = mb.MaMB
inner join nhanvien as nv on nv.MaNV = cn.MaNV
where mb.Loai like 'Boeing%';





