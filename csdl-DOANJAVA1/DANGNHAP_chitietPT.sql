use doanjava
create table chitietPT(
LOAIPT nvarchar(30) not null,
PHIGUI int not null,
)

create table DANGNHAP(
TENDANGNHAP NVARCHAR(50) NOT NULL PRIMARY KEY,
MATKHAU NVARCHAR(30) NOT NULL,
CHUCVU NVARCHAR(50) NOT NULL,
)