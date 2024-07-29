-- 제약조건 확인용
DESC MY_DEPT; 
DESC MY_EMP; 

-- 데이터 입력 확인용
SELECT*FROM MY_DEPT;
SELECT*FROM MY_EMP;

-- 테이블 삭제용(PK 잘못입력)
DROP TABLE MY_EMP;
-- ===============================================================================================
-- 1. MY_DEPT의 구조와 같은 테이블을 생성
-- TINYINT(M) : 부호 있는 수는 -128 ~ 127 | 부호 없는 수는 0 ~ 225 까지 표현 (1바이트)

CREATE TABLE MY_DEPT(
	DEPT_NO TINYINT,
    DEPT_NAME VARCHAR(20),
    DEPT_LOC VARCHAR(15),
    DEPT_TELNO VARCHAR(15)
    );

-- 2. MY_DEPT 테이블의 PK를 설정하는 구문을 추가하여 작성하세요. 
ALTER TABLE MY_DEPT ADD CONSTRAINT MY_DEPT_DEPT_NO_PK PRIMARY KEY(DEPT_NO); 

-- 3. MY_DEPT 테이블에 위 표의 제공된 데이터를 입력하는 SQL 구문을 작성하세요.
INSERT INTO MY_DEPT VALUES(10, 'SALES','SEOUL','02-671-1111');
INSERT INTO MY_DEPT VALUES(20, 'FINANCE','SEOUL','02-862-2222');
INSERT INTO MY_DEPT VALUES(30, 'HR','BUSAN','051-111-1111');
INSERT INTO MY_DEPT VALUES(40, 'PURCHASE','BUSAN','051-222-2222');
INSERT INTO MY_DEPT VALUES(50, 'MANAGEMENT','SEOUL','02-383-3333');

-- 4. 위 MY_EMP 테이블을 생성하는 SQL 구문을 작성하세요.
-- SMALLINT : 부호 있는 수는 -32768 ~ 32767 | 부호 없는 수는 0 ~ 65535 까지 표현 (2바이트)

CREATE TABLE MY_EMP(
	EMP_NO SMALLINT,
    EMP_NAME VARCHAR(10),
    EMP_MGR SMALLINT,
    HIREDATE DATE,
    SAL SMALLINT,
    DEPT_NO TINYINT
    );
    
-- 5. 	MY_EMP 의 constraint PK, FK 를 추가하는 SQL 구문을 작성하세요.
ALTER TABLE MY_EMP ADD CONSTRAINT MY_EMP_EMP_NO_PK PRIMARY KEY(EMP_NO); 
ALTER TABLE MY_EMP ADD CONSTRAINT MY_EMP_DEPT_NO_FK FOREIGN KEY(DEPT_NO) 
REFERENCES MY_DEPT(DEPT_NO)
ON DELETE CASCADE;

-- 6. MY_EMP 테이블에 제공된 데이터를 입력하는 SQL 구문을 작성하세요.
INSERT INTO MY_EMP VALUES(1001,'KIM',1003,'2019-01-15',4750,20);
INSERT INTO MY_EMP VALUES(1002,'LEE',1003,'2021-06-05',3000,30);
INSERT INTO MY_EMP VALUES(1003,'PARK',1001,'2023-11-28',3500,10);

-- 7. 위 MY_EMP 테이블에 ‘HR’ 부서 직원의  소속 부서를 ‘MANAGEMENT’ 부서로 변경하는 SQL 구문을 작성하세요.
UPDATE MY_EMP e
JOIN (SELECT EMP_NO FROM MY_EMP WHERE DEPT_NO=30) n
ON e.EMP_NO = n.emp_NO
SET DEPT_NO=50;

-- =========================================(꼭 확인하기)==========================================
-- UPDATE MY_EMP SET DEPT_NO=50 WHERE EMP_NO IN(SELECT EMP_NO FROM MY_EMP WHERE DEPT_NO=30);
-- Error Code: 1093. You can't specify target table 'MY_EMP' for update in FROM clause
-- 동일한 테이블을 업데이트하고 서브쿼리에서 참조하는 경우 JOIN을 사용해야 함.
-- ==============================================================================================

-- 8. 위 MY_DEPT 테이블에 ‘HR’ 부서를 삭제하는 SQL 구문을 작성하세요.
DELETE FROM MY_DEPT WHERE DEPT_NAME='HR';

-- 9. 아래의 데이터를 MY_EMP 테이블에 추가하세요. 추가 시에 입사일은 시스템의 현재일자를 자동으로 가져와서 부여하도록 SQL 구문을 작성하세요.
INSERT INTO MY_EMP VALUES(2001,'CHUNG',1001, current_date(), 3000, 50);

-- 10. MY_EMP , MY_DEPT  테이블을 부서코드로 JOIN해서 view 생성하는 SQL 구문을 작성하세요.(emp_no, emp_name, emp_mgr, hiredate, sal, dept_no, dept_name, dept_loc 를 보여주는 view 생성)
CREATE VIEW DEPT_NOVIEW
AS
(SELECT e.emp_no, e.emp_name, e.emp_mgr, e.hiredate, e.sal, d.dept_no, d.dept_name, d.dept_loc
FROM MY_EMP e
JOIN MY_DEPT d
ON e.dept_no = d.dept_no);

-- 11. 생성된 view를 실행하여 보자.
SELECT * FROM DEPT_NOVIEW;

-- 12. MY_EMP 테이블 EMP_NAME에 인덱스를 걸자. 동일한 이름의 사원이 존재할 수 있기 때문에 중복을 허용하는 인덱스를 건다.
CREATE INDEX MY_EMP_EMP_NAME_IDX ON MY_EMP(EMP_NAME);
SHOW INDEX FROM MY_EMP;