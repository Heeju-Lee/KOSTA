/*
[데이터베이스 객체]
1. TABLE
2. INDEX
3. VIEW
*/
SELECT * FROM EMP;

SELECT * FROM emp WHERE name = 'SCOTT';
/*INDEX
데이타 베이스에서 인덱스를 사용하는 이유는 
검색 조건을 만족하는 레코드를 빠르게 조회하기 위해서이다.
대용량 데이타에서 인덱스 지정은 필수조건이다.

1. 클러스터드 인덱스(Clustered Index), Primary Key Index
    - 기본키 지정하는 순간 클러스터드 인덱스가 만들어짐.
    - 기본키 지정 == 인덱스 설정
2. 논클러스터드 인덱스(Non Clustered Index), 세컨더리, 보조인덱스
*/

-- emp테이블의 데이타가 100만개로 가정. 이런 상황에서 ename='SCOTT'인 사원을 검색
-- 100만 ROW를 일일이 다 검색하는 FULL SCAN 방식으로 작업진행 -- 성능이 아주 안좋다.
-- ename에 인덱스가 걸려져 있다면 동일한 쿼리지만 성능이 엄청 올라간다..
-- 인덱스는 컬럼레벨에 지정한다.

-- 1. tb1 테이블 생성 시 pk제약조건을 지정
-- pk제약조건을 지정하면 인덱스가 자동으로 생성된다. 
CREATE TABLE tb1(
	a int PRIMARY KEY,
	b int, 
	c int);
    
SHOW INDEX FROM tb1;
-- KEY_NAME : 인덱스 이름, 클러스터드 인덱스
-- NON_UNIQUE : 0=UNIQUE 1=NON-UNIQUE
-- Cardinality : TUPLE 수
-- Index_type : BTREE(자동으로 생성되는 인덱스 기본적인 인덱스 구조) 

-- 2. 테이블 생성시 pk와 함께 unique 제약조건으로 인덱스 생성
CREATE TABLE tb2(
a int PRIMARY KEY,
b int UNIQUE,
c int UNIQUE,
d int);
-- =======================================
SHOW INDEX FROM tb2;
-- =======================================
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;
CREATE TABLE employee
AS
SELECT * FROM emp;
CREATE TABLE department
AS
SELECT * FROM dept;
ALTER TABLE employee ADD CONSTRAINT employee_empno_PK PRIMARY KEY(EMPNO);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk FOREIGN KEY(deptno) REFERENCES department(deptno);

-- 3.
/*
1, 2번은 테이블 생성시 인덱스 문제...
1, 2번은 테이블 생성시 컬럼에 제약조건을 부여 ---> 자동으로 인덱스가 만들어지도록

3. 테이블이 이미만들어져 있고 데이터까지 다 들어가 있다.
이 상황에서 인덱스를 걸어보겠다.
*/
DESC EMPLOYEE;
DESC DEPARTMENT;

SELECT * FROM employee WHERE name = 'Scott';
-- name은 인덱스가 안걸린 컬럼....데이터가 대용량일때는 성능에 문제 발생
-- name은 이름이 동일한 사원이 존재할 수 있다. (중복허용) nonunique =1 

CREATE INDEX employee_name_idx on employee(name);
SHOW INDEX FROM employee;

/*
두개의 컬럼을 합쳐서 인덱스를 걸어줄 수 있다.!!
  JOB    |   JNUMBER --->  Result        
SALESMANS -    123 --->  ex)'james'
CLERK    -     123 --->  ex)'juliet'
*/

CREATE UNIQUE INDEX employee_job_jnumber_idx ON employee(job,jnumber); -- 이렇게 해야 중복이 안되는 인덱스가 만들어짐

-- 4. 테이블을 생성하면서 인덱스를 걸어주는 방법
-- 2개의 컬럼을 결합해서 unique한 인덱스를 생성
CREATE TABLE player(
id int PRIMARY KEY,
name varchar(10) not null,
team_id int,
backnumber int,
INDEX (name),
UNIQUE INDEX(team_id, backnumber)
);

SHOW INDEX FROM player;