-- 정규화 전 테이블
create table companysawon (
company varchar(20),
address varchar(50),
phone varchar(35),
sawon_name varchar(30),
position varchar(30),
email varchar(50),
hp varchar(20));

insert into companysawon values ('LG','서울강남구','02-123-1234', '홍길동','사원','aaa@naver.com','010-222-1111');
insert into companysawon values ('KT','분당','02-222-2323','이영자','과장','bbb@naver.com','010-2222-3434');
insert into companysawon values ('SK','부산','02-555-1234', '강호동','부장','ccc@naver.com','010-7777-8888');

SELECT * FROM companysawon;

-- 정규화 진행 후 테이블
create table company (
company_id int primary key,
company varchar(20),
address varchar(50),
phone varchar(35));

INSERT INTO company(company_id, company, address,phone) VALUES(10,'LG','서울강남','02-111-2323');
INSERT INTO company(company_id, company, address,phone) VALUES(20,'KT','분당','031-455-6666');
INSERT INTO company(company_id, company, address,phone) VALUES(30,'SK','정자','031-323-2342');

create table sawon (company_id int ,
 sawon_name varchar(20),
 position varchar(20),
 email varchar(40),
 hp varchar(40), foreign key(company_id) references company(company_id) on delete cascade);
 
 
INSERT INTO sawon VALUES (10, '피준범','과장','junbumpi@kosta.com','010-2345-1122');
INSERT INTO sawon VALUES (10, '이새봄','대리','bom@daum.net','010-4329-3355');
INSERT INTO sawon VALUES (30, '김아름','대리','beauty@google.com','010-9901-8232');
INSERT INTO sawon VALUES (20, '이새별','대리','byeol@daum.net','010-5789-3579');

SELECT * FROM company;
SELECT * FROM sawon;

-- KT 회사의 주소를 나주시로 변경, 전화번호도 변경
-- KT에 소속된 사원의 이름과 직급과 회사명, 회사번호를 검색(이때 변경된 회사 주소가 출력)

DELETE FROM company;
UPDATE company SET address='나주시', phone ='061-332-8280' WHERE company='kt';

SELECT s.sawon_name, s.position, c.company, s.company_id, c.address
FROM sawon s, company c
WHERE s.company_id = c.company_id
AND company = 'kt';