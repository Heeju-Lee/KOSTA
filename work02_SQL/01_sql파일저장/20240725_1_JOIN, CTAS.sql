-- 2024. 07. 25 JOIN

/*
JOIN
여러개의 테이블로부터 데이터를 가져오는 경우에 사용되는 기법
"하나 이상의 테이블에서 질의를 던지는 경우에 필요하다."

2개의 테이블을 연결시키는 즉, 관계형 데이터베이스를 가능하게 하는 핵심 키워드는 PK, FK의 관계이다.
하지만 PK, FK 관계 없이도 논리적인 값들의 연결만으로도 JOIN작업이 가능하다.

JOIN의 종류는 여러 가지가 있다.
EQui Join, Self Join, Outer Join
가장 대표적인 조인은 EQui JOIN 이다.
*/

DESC emp;
DESC dept;
-- -----------------------------------------------
SELECT * FROM DEPT;
SELECT DISTINCT DEPTNO FROM EMP;

-- 모든 사원이 어떤 부서에서 일하는지를 검색(사원이름, 업무, 부서번호, 부서이름, 부서위치)
/*
Cartesian Product
emp와 dept 테이블이 단순하게 수평적으로 결합
14  * 4 = 56

- JOIN 조건을 생략했을 경우 : 논리적인 결합을 지정
- JOIN조건을 잘못줬을 경우
*/
-- 1 STEP
SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM EMP, DEPT; -- 56행 관계가 없어서 

-- 2 STEP. 논리적인 결합
-- 논리적인 결합은 두 테이블간의 공통적인 컬럼으로 결합
SELECT * FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

/*
Equi Join
where 절 뒤에 = 연산자를 사용하는 조인이다.
두 테이블에 공통적인 컬럼을 연결하는 방식이다.
*/
-- step1
SELECT * FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO; -- Projection 미기입으로 DEPTNO 두번 출력됨.

-- step2
SELECT empno, ename, deptno, dname, loc 
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO; -- error, deptno가 두 테이블에 다 들어있어서 ambiguous

-- step3
SELECT emp.empno, emp.ename, emp.deptno, dept.dname, dept.loc 
FROM EMP, DEPT
WHERE emp.DEPTNO = dept.DEPTNO; -- table prefix를 줘야함. 쿼리는 수행되지만 일일이 테이블명을 지정하는 것이 비효율적이다.

-- step4. 테이블 Alias 지정
SELECT e.empno, e.ename, e.deptno, d.dname, d.loc 
FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO;

-- 사원의 이름, 급여, 부서번호, 부서위치를 검색
-- 단 급여가 2000 이상이고 30번 부서에 한해서만 조회
SELECT e.empno, e.sal, e.deptno, d.loc 
FROM EMP e, DEPT d
WHERE e.sal>=2000 
AND e.deptno=30
AND e.DEPTNO = d.DEPTNO;

-- NY에서 근무하는 사원의 이름과 급여를 검색
SELECT e.ename, e.sal, e.deptno
FROM EMP e, DEPT d
WHERE d.loc = 'NEW YORK' -- 비조인 조건
AND e.DEPTNO = d.DEPTNO; -- 조인 조건

/*
JOIN 시 가장 많이 사용되는 키워드
JOIN ~ ON
- 조인할 컬럼명이 다른경우에도 사용할 수 있다. ON
- AND절 이 올 수 있다. 이곳에 비조인 조건을 넣는다.
JOIN ~ USING
- 조인할 두 컬럼명이 같은 경우에만 사용할 수 있다.
- 컬럼의 이름이 같은 경우 using()안에 명시한다.
- using을 사용한다면 조인시 양쪽 테이블의 컬럼값을 모두 조회할 필요가 없어서 성능이 좋아진다.
- 두테이블에 있는 deptno값을 두번 부르지 않는다.
*/

-- JOIN ~ ON

SELECT e.empno, e.ename, e.sal, e.deptno, d.dname
FROM emp e 
JOIN dept d 
ON e.deptno = d.deptno;

SELECT e.empno, e.ename, e.sal, e.deptno, d.dname
FROM emp e 
JOIN dept d 
ON e.deptno = d.deptno -- 조인 조건
AND e.sal>=3000; -- 비조인 조건

-- JOIN ~ USING
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname
FROM emp e JOIN dept d
USING(deptno); 

SELECT e.empno, e.ename, e.sal, deptno, d.dname -- prefix 필요없음.
FROM emp e JOIN dept d
USING(deptno); 

SELECT e.empno, e.ename, e.sal, deptno, d.dname -- prefix 필요없음.
FROM emp e JOIN dept d
USING(deptno);
-- AND e.sal>=3000; AND 조건절 사용불가

-- self JOIN
-- 특정 사원의 상사 이름을 검색
/*
1. 특정 사원의 ename을 조회... blake를 찾는다.
2. blake의 상사번호 mgr을 찾는다 --- 7839
------------------------------------------
3. 다시 emp 테이블의 empno가 7839번인 사람의 이름을 검색
*/

-- STEP 1  
SELECT empno, ename, mgr FROM emp e; -- 'Blake'의 상사번호 7839
SELECT empno, ename FROM emp m; 
SELECT * FROM (SELECT empno, ename, mgr FROM emp) e,
 (SELECT empno, ename FROM emp) m; -- Cartesian Product

-- STEP 2 조인조건 추가
SELECT * FROM (SELECT empno, ename, mgr FROM emp) e,
 (SELECT empno, ename FROM emp) m
 WHERE e.mgr - m.empno;
 
 -- STEP 3 self join
SELECT e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m 
WHERE e.mgr = m.empno;

 -- STEP 4 비조인 조건
SELECT e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m 
WHERE e.mgr = m.empno
AND e.ename = 'BLAKE';

/*
4. OUTER 조인
A, B 두 테이블을 조인할 경우, 
조건의 맞지 않는 데이터도 표시하고 싶을 때 사용하는 조인

[ 유형 ]
LEFT OUTER JOIN | RIGHT OUTER JOIN | FULL OUTER JOIN
(데이터가 있는 쪽을 기준으로 한다.)
*/
-- 지금까지의 조인 기법은 inner 조인으로 두 테이블에서 공통적인 부분만 검색 
-- dept 테이블에 들어있는 40번 부서의 정보는 나타나지 않는다. 이것을 보기 위해서는 outer join을 해야한다.
SELECT e.empno, e.ename, e.deptno, d.dname, d.loc 
FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO;

-- 1) RIGHT OUTER JOIN
-- 조인 수행 시 우측 테이블이 기준이 되어서 결과를 생산 (데이터가 있는 쪽의 의미)
SELECT e.ename, d.deptno, d.dname, d.loc 
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;

SELECT e.ename, d.deptno, d.dname, d.loc 
FROM emp e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- 2) LEFT OUTER JOIN
-- 특정사원의 상사의 이름을 검색 
SELECT concat(e.ename,'의 매니저는 ',m.ename,'입니다.') Info
FROM emp e, emp m
WHERE e.mgr = m.empno;

SELECT concat(e.ename,'의 매니저는 ',m.ename,'입니다.') Info
FROM emp e LEFT OUTER JOIN emp m
ON e.mgr = m.empno;

-- FULL OUTER JOIN // MYSQL에서 지원안함.
-- 양쪽 테이블 모두 공통적이지 않은 데이터가 있는 경우 모두 보여줌 
-- UNION : DISTINCT 가 포함돼있음 -> 성능이 좋지 않음.
-- UNION ALL : 다 가져온다.

CREATE TABLE outera(sawonid int);
CREATE TABLE outerb(sawonid int);

INSERT INTO outera VALUES(10);
INSERT INTO outera VALUES(20);
INSERT INTO outera VALUES(30);
SELECT * FROM outera;

INSERT INTO outerb VALUES(10);
INSERT INTO outerb VALUES(20);
INSERT INTO outerb VALUES(40);
SELECT * FROM outera;

SELECT sawonid FROM outera
UNION
SELECT sawonid FROM outerb;

/*
SET(집합) 연산자

CTAS "CREATE TABLE AS SELECT"
: 다른 테이블의 데이터만 복사해와서 새로운 테이블을 생성한다.
- 제약조건을 가져오지 않기 때문에 직접 추가해야만 한다.
*/


SELECT * FROM emp1;
DESC emp1;

CREATE TABLE emp1
AS
(SELECT * FROM emp);

CREATE TABLE emp2
AS
(SELECT ename, job, sal, deptno FROM emp WHERE deptno =20);
SELECT * FROM emp2;

CREATE TABLE newemp
AS
(SELECT * FROM emp);


-- 데이터 추가하기 (INSERT INTO)
INSERT INTO newemp values (111, '전현무', 'manager', '7566', '2000-01-01', 5000.0, null, 20);
INSERT INTO newemp values (222, '박나래', 'manager', 111 , '2003-11-21', 4000.0, null, 20);

-- 데이터 조회하기
SELECT * FROM newemp;

-- UNION
SELECT * FROM emp 
UNION
SELECT * FROM newemp; -- 16명, 중복제거함.

SELECT * FROM emp 
UNION ALL
SELECT * FROM newemp; -- 30명, 모든것을 추가함.
