select * from maybay;
delete from maybay where MaMB = 200;
-- 2.	Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
select * from maybay where TamBay > 10000;

-- 7.	Có bao nhiêu loại máy báy Boeing.
 select count(*) from maybay where Loai like 'Boeing%';
 
 
 -- 16.	Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó.


select distinct cn.MaMB, count(cn.MaMB) as phicong from nhanvien as nv
inner join chungnhan as cn on nv.MaNV = cn.MaNV
group by cn.MaMB;

-- 13.	Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
 select * from maybay as mb where TamBay > (select DoDai from chuyenbay as cb where cb.MaCB like 'VN280');
 
 -- update
 insert into maybay (MaMB, Loai, TamBay) values (999,'Airbus_A',10000);
 
 
 
 UPDATE maybay SET Loai = '' where MaMB = '100'
 
 