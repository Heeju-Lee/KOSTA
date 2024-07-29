/*
테이블 생성하기 -- CREATE TABLE
테이블 삭제하기 -- DROP TABLE
테이블 컬럼, 데이타 타입변경하기 -- ALTER TABLE 

데이타 추가하기 -- INSERT INTO
데이타 수정하기 -- UPDATE 
데이타 삭제하기 -- DELETE WHERE
*/

DROP TABLE custom;
-- 1. 테이블 생성하기 
CREATE TABLE custom(
num int AUTO_INCREMENT,
name varchar(10) not null,
addr varchar(100),
birthday date,
primary key(num)); -- 테이블 레벨에서 제약조건 추가하기 (not null + unique)

desc custom;
-- 2. 데이타 추가하기 
INSERT INTO custom (name, addr, birthday) VALUES('전현무', '창신동', '1980-02-12'); -- AUTO_INCREMENT 같은 것이 있으니 projection 주고 insert

INSERT INTO custom (name, addr, birthday) VALUES('박나래', '여의도', '1983-01-11'); 
INSERT INTO custom (name, addr, birthday) VALUES('이장우', '방배동', '1985-03-12'); 

SELECT num, name, addr FROM  CUSTOM;

-- 3. 데이타 수정하기
-- UPDATE 테이블명 SET 수정컬럼=’수정값’,수정컬럼=’수정값’ WHERE NUM=1
-- 박나래 고객의 주소를 신사동, 생년월일 1982 생으로 변경
UPDATE CUSTOM SET addr='신사동', birthday='1982-01-11' WHERE num=2;

SELECT * FROM  CUSTOM;

-- 4. 삭제하기
/*
DROP : 테이블 전체삭제
TRUNCATE : DROP + CREATE -> 테이블 삭제 후 구조를 넣어줌
DELETE : WHERE 절과 함께 사용한다. 조건에 해당하는 것을 삭제하겠다.
*/
-- CTAS를 이용해서 Custom과 동일한 테이블 생성
CREATE TABLE mycustom
AS
SELECT * FROM custom;

desc mycustom;
SELECT * FROM MYCUSTOM;

DELETE FROM MYCUSTOM; -- 전부삭제, 구조는 남아있음. 

SELECT * FROM custom;
TRUNCATE TABLE CUSTOM; -- 전부삭제 
desc custom; -- 구조는 남아있음.

DROP TABLE mycustom; -- 테이블 자체를 drop
desc mycustom; -- 없어졌으니 구조도 없고 모든게 사라짐 