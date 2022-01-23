select * from chuyenbay;
-- 1.	Cho biết các chuyến bay đi Đà Lạt (DAD).
select * from chuyenbay where GaDen = 'DAD';

-- 4.	Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
select * from chuyenbay where  DoDai between 8000 and 10000;

-- 5.	Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
select * from chuyenbay where GaDi = 'SGN' and GaDen = 'BMV'; 

-- 6.	Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).

select count(*) from chuyenbay where GaDi = 'SGN';

-- 28.	Tìm các chuyến bay có thể được thực hiện bởi tất cả các loại máy bay Boeing.


-- 21. Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00.
select GaDi,GioDi, count(GaDi) as soLuong
from chuyenbay 
where GioDi < '12:00'
group by GaDi;

-- 20 Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00
select * from chuyenbay where GioDi < '12:00';

-- 19.	Với mỗi ga có chuyến  bay xuất phát từ đó cho biết tổng chi phí phải trả cho phi công lái các chuyến bay khởi hành từ ga đó.

select GaDi, sum(ChiPhi) from chuyenbay group by GaDi; 

-- 18. Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga đó.

select GaDi, count(GaDi) from chuyenbay group by GaDi; 

-- 17.	Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A. Cho biết các đường bay nào có thể đáp ứng yêu cầu này.

select t1.GaDi, t1.GaDen
from chuyenbay t1
join chuyenbay t2
    on  t1.GaDi = t2.GaDen
    and t1.GaDen = t2.GaDi
where t1.GaDi < t1.GaDen;


-- 14.	Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.


select * from chuyenbay where DoDai < (select TamBay from maybay where Loai = 'Airbus A320');


