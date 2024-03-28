use doanjava
select sum(SODIEN) as 'tong dien',
       sum(SONUOC) AS 'TONG NUOC',
 count(*) 
 FROM dbo.CanHo
 where TRANGTHAI = 'Có'

 USE doanjava
 create table DIENNUOC(
 THANG CHAR(10),
 TONGDIEN CHAR(10),
 TONGNUOC CHAR(10),
 SOPHONGSUDUNG CHAR(10))

