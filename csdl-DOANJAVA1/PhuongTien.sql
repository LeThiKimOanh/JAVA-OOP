USE doanjava
CREATE TABLE PhuongTien(
MAPT CHAR(20) NOT NULL PRIMARY KEY,
MACUDAN CHAR(10) NOT NULL,
LOAIPT NVARCHAR(30) NOT NULL,
PHIGUI NVARCHAR(20) NOT NULL,
CONSTRAINT FK_PhuongTien_TRUONGPHONG_MACUDAN FOREIGN KEY (MACUDAN) REFERENCES TRUONGPHONG
)