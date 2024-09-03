DROP TABLE USERINFO;

CREATE TABLE USERINFO ( 
	userId varchar(12) primary key, 
	password varchar(12) NOT NULL,
	name varchar(20) NOT NULL,
	email varchar(50));

INSERT INTO USERINFO VALUES('admin', 'admin', '관리자', 'admin@google.com');
INSERT INTO USERINFO VALUES('java', 'java', '자바지기', 'java@jaen.com');
INSERT INTO USERINFO VALUES('kosta', '1234', '연수생', 'hsh@kosta.com');
commit;

SELECT * FROM USERINFO;
DESC USERINFO;

SELECT userId, PASSWORD, NAME, EMAIL FROM USERINFO WHERE userId='kosta' AND PASSWORD='1234';

-- ====================================================================================
DROP TABLE book;

create table book(
isbn char(12) primary key,
title varchar(50) not null,
catalogue varchar(30) not null,
nation varchar(30),
publish_date date,
publisher varchar(50),
author varchar(50) not null,
price decimal(6,0) not null,
currency char(6),
description varchar(2000));

INSERT INTO book VALUES('1233-111-111','Java 완성','프로그래밍','국내도서',
         '2019.01.01','사무국','사무국',3000,'원','java를 마시자');
INSERT INTO book VALUES('1233-111-222','금융권의 대용량 데이타분석','프로그래밍','국외도서',
         '2023.01.02','사무국','사무국',4000,'원','대용량 데이타');
INSERT INTO book VALUES('1233-111-333','AI정복','프로그래밍','국내도서',
         '2024.08.22','사무국','사무국',6000,'원','AI와 동행');
		 
commit;

SELECT * FROM book;
DESC book;

DELETE FROM book where author='이희주';

-- isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description