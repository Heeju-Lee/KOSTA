DROP TABLE book;

CREATE TABLE BOOK(
isbn char(8) PRIMARY KEY,
title varchar(50) not null,
author varchar(10) not null,
publisher varchar(15) not null,
price int not null,
description varchar(200));

SELECT * FROM book;

SELECT isbn, title, author, publisher, price, description FROM book WHERE title like '%java%';

SELECT isbn, title, author, publisher, price, description FROM book WHERE title like '%java%';

SELECT isbn, title, author, publisher, price, description FROM book WHERE title like '% %' OR publisher like '% %' OR author like '%자앤%';

DESC book;SELECT isbn, title, author, publisher, price*0.8, description FROM book WHERE publisher like "%자앤%";

ALTER TABLE BOOK ADD CONSTRAINT BOOK_isbn_PK PRIMARY KEY(isbn);
