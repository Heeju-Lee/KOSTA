CREATE table product (
productnum INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) not null,
price INT,
pdesc VARCHAR(50));

DROP table product;

DESC product;

SELECT * from product;

INSERT INTO product (name,price,pdesc) VALUES('AAA',54000,'전구');

SELECT productNum, name, price, pdesc FROM product;

select @@autocommit;



