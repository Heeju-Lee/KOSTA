springboardCREATE table  member (
id VARCHAR(20) PRIMARY KEY,
password VARCHAR(30) not null,
name VARCHAR(20),
address VARCHAR(100));

DESC member;

INSERT INTO member VALUES('kosta','1234','홍종각','종각');

select @@autocommit;

SELECT * from member;

delete from member;

delete from book;

select *from item;
desc item;

commit;

select *from book;
desc book;

use kosta;

-- 하지마
drop table board;
drop table member;
-- 하지마



desc board;
desc member;


select * from member;
SELECT * from board;

INSERT into member(address, id, name, pwd) 
values ('종각','kosta',  '홍종각', '1234');

INSERT into member(address, id, name, pwd) 
values ('종각','spring',  '김종각', '4321');

INSERT into board(title, content, regdate, member_no) 
values ('안전','중요합니다.',  curdate(), 1);

INSERT into board(title, content, regdate, member_no) 
values ('보안','중요합니다.',  curdate(), 2);

-- 하지마
delete from board;
delete from member where 1= memberNo;

UPDATE member set memberno=1 WHERE memberno=4;
UPDATE member set memberno=2 WHERE memberno=5;

UPDATE board set regDATE = curdate() 


