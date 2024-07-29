-- 2024.07.26
/*
1. 제약조건 추가하기
 - column에 부여 = not null, unique(null 허용), PK(not nuull+ unique)
 
 [자식]emp(직원....deptno(fk))  --- RDBMS (多:1) ---  [부모]dept(부서....deptno(PK)) 
 다른 테이블의 기본키를 가져옴으로서 제약조건이 생성된다. (FK) relational 
 자식이 부모에 들어간다. 

 : FK 부여하지 않아도 관계설정했었음.
*/

DESC emp;
DESC dept;

-- 대용량 샘플 데이타 생성할 때 CTAS 
-- employee, department 테이블 생성
DROP TABLE employee;
DROP TABLE department;

CREATE TABLE employee
AS
(SELECT * FROM emp);

CREATE TABLE department
AS
(SELECT * FROM dept);

-- CTAS로 테이블의 데이타는 그대로 사용할 수 있지만 제약조건은 적용되어 있지 않다!
-- 기본키 제약조건부터 다시 설정해야한다.
DESC employee;
DESC department;

-- 1. 제약조건 추가(기본키 제약조건_PK)
ALTER TABLE employee ADD CONSTRAINT employee_empno_PK PRIMARY KEY(EMPNO);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);

SELECT * FROM department;
DELETE FROM department WHERE deptno=20;
SELECT * FROM employee; -- 20번 부서의 직원이 여전히 남아있다. (두테이블의 관계를 지정하지 않아서, FK 설정이 안되어 있어 있다.)

-- 2. 제약조건 추가(외래키 제약조건_FK) 자식 테이블에만 지정
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk FOREIGN KEY(deptno) REFERENCES department(deptno);

-- 2-1. 제약조건 추가(외래키 제약조건_FK) + CASECADE 옵션 지정
-- 1) 자식을 먼저 삭제하고 부모 삭제 (기본사용법)
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk FOREIGN KEY(deptno) 
REFERENCES department(deptno) 
ON DELETE CASCADE;

-- 2) 자식의 모든 값에 NULL로 채우고 부모가 삭제
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk FOREIGN KEY(deptno) 
REFERENCES department(deptno) 
ON DELETE SET NULL;

-- 3. 데이타 삭제하기
DELETE FROM employee WHERE deptno=10;

DELETE FROM department WHERE deptno=20; -- on delete cascade  옵션을 지정하면 employee 테이블의 20번 사원도 함께 삭제

SELECT * FROM employee;
SELECT * FROM department;