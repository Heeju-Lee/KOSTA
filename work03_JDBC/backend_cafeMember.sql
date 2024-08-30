CREATE table  member (
id VARCHAR(20) PRIMARY KEY,
password VARCHAR(30) not null,
name VARCHAR(20),
address VARCHAR(100));

DESC member;

INSERT INTO member VALUES('kosta','1234','홍종각','종각');

select @@autocommit;

SELECT * from member;

delete from member;