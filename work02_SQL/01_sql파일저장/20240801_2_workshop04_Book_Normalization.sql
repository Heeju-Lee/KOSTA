DESC book;
DESC Author;
SELECT * FROM book;
SELECT * FROM Author;

-- (SQL) Book 테이블을 수정하고 Author 컬럼 삭제
ALTER TABLE book DROP COLUMN author;

-- (SQL)Author 테이블을 생성하고, Author 테이블에  데이터를 추가한다. 
CREATE TABLE Author(
authorno int PRIMARY KEY, -- sql에서 int는 길이설정 x
name VARCHAR(50),
phone VARCHAR(30));

delete FROM AUTHOR;

INSERT INTO Author (authorno, name, phone) VALUES
(100, '연하늘', '010-1234-5678'),
(200, '서정아', '010-2345-6789'),
(300, '민지혜', '010-3456-7890'),
(400, '아라송', '010-4567-8901'),
(500, '지은별', '010-5678-9012');
(600, '김은수', '010-5678-9012');
 
-- (SQL) 2.  Book 테이블을 수정하자.  
ALTER TABLE book ADD COLUMN(
authorno int);
ALTER TABLE book ADD CONSTRAINT authorno_FK FOREIGN KEY(authorno) REFERENCES Author(authorno);

-- ===============================================================================================
 
-- 3.  Book과 Author 테이블을 JOIN하여 도서명, 가격, 저자명을 검색하는 기능을 구현한다.  
 
-- 4. 이름이 ‘ 김XX ’인  저자의 도서명, isbn, 출판사를 출력하는 기능을 작성한다. (return -> void) 
 
-- 5.  Author  테이블에 있는 저자명 별로 출간된 도서들을  도서명, 출판사, 가격, 저자명을 출력하는 기능을 구현한다. 
 
 -- 6.  Book 테이블에 있는 title와 publisher를 이용하여 서로의 관계를 다음과 같이 출력되도록 기능을 구현한다. ( ‘IoT세상은 미래닷컴에서 출판했다’) void