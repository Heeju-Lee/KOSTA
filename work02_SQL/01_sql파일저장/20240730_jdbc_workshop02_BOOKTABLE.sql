DROP TABLE book;

CREATE TABLE BOOK(
isbn char(8) PRIMARY KEY,
title varchar(50) not null,
author varchar(10) not null,
publisher varchar(15) not null,
price int not null,
description varchar(200));

DESC book;

ALTER TABLE BOOK ADD CONSTRAINT BOOK_isbn_PK PRIMARY KEY(isbn);
