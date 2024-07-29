-- 2024.07.24 서브쿼리
/*
서브쿼리
: ()괄호 안에서 실행되는 쿼리로 먼저 실행한 후 나오는 결과값이 main 쿼리가 실행될 때 

- 서브쿼리는 ?에 해당하는 부분을 먼저 검색하는데 사용된다.
- 서브쿼리가 먼저 실행되고 그 결과를 메인쿼리에서 사용해서 전체 쿼리가 완성된다.
- 서브쿼리는 하나의 SQL문 안에 포함되어져 있는 또 다른 SQL문을 말한다. 
(성능을 높히기 위해서 db서버에 2번의 질의를 안하는 방법으로)
- 서브쿼리에서 Order by절을 사용할 수 있을까? 사용하는건 의미가 없다. 

- 서브쿼리의 유형
WHERE절 | HAVING절 | FROM절

*/

/*
WHERE 절 뒤의 서브쿼리

*/

-- [CLARK 의 급여]보다 더 많은 급여를 받는 사원을 검색 []=?
-- 1. 2번의 질의를 서버에 던지는 쿼리가 생성된다.....효율성 & 성능측면에서 bad
SELECT ename 이름, sal 급여 FROM emp WHERE ename = 'CLARK'; -- 2450
SELECT ename 이름, sal 급여 FROM emp WHERE sal> 2450; -- 5명 나옴

-- 2. 하나의 쿼리문을 만들기 위해서는 ? 에 해당하는 부분을 먼저 수행하고 전체 쿼리에 넣는다. 
SELECT ename, sal 
FROM emp 
WHERE sal> (SELECT sal FROM emp WHERE ename = 'CLARK');-- (1) ()=sub query, inner query , 2450(One Row, One Column)..스칼라값, 스칼라서브쿼리, 단일행 서브쿼리
-- (2) 서브쿼리를 돌고 전체를 돈다. main query / outter query

-- ename이 king인 사원과 같은 부서에서 근무하는 사원
SELECT * FROM emp WHERE deptno = (SELECT deptno FROM emp WHERE ename= 'king');

-- 10번 부서에서 근무하는 사원중에서 (사원 전체의 평균급여)보다 더 많은 급여를 받는 사원을 검색
SELECT ename, sal, deptno
FROM emp
WHERE deptno=10 AND sal>(SELECT round(avg(sal)) FROM emp);

-- job별 가장 적은 평균급여를 검색
-- 1. 그룹함수 중첩이 안된다.
SELECT job, avg(sal) 
FROM emp 
GROUP BY job
HAVING avg(sal) = (SELECT min(avg(sal)) FROM emp GROUP BY job); -- Error!! 

SELECT job, avg(sal) FROM emp GROUP BY job;

-- 2. LIMIT 사용
SELECT job 직무, avg(sal) '최저 평균급여'
FROM emp 
GROUP BY job
ORDER BY 2
LIMIT 1;

-- 3 테이블 알리야스를 지정한다.
-- 테이블을 리턴하는 서브쿼리에는 반드시 테이블 알리야스를 지정한다.
SELECT round(min(sal))
FROM (SELECT avg(sal) sal FROM emp GROUP BY job) t;

SELECT t.job, round(t.sal)
FROM (SELECT job, avg(sal) sal FROM emp GROUP BY job) t;

/*
FROM 절 이후에 나오는 SUB QUERY
테이블 Alias 지정하기
*/

-- SCOTT의 급여보다 더 많은 급여를 받는 사원을 검색
-- 1
SELECT ename, sal 
FROM emp
WHERE sal > 
(SELECT sal FROM emp WHERE ename = 'SCOTT');

-- 2. 테이블 Alias로 지정하는 방법
-- 전체 테이블을 a, 서브쿼리 테이블을 b :: a와 b를 비교하는 방식
-- 1
SELECT a.ename, a.sal
FROM (SELECT ename, sal FROM emp WHERE ename = 'SCOTT') b, emp a
WHERE a.sal> b.sal;

SELECT ename, sal
FROM (SELECT ename, sal FROM emp WHERE ename = 'SCOTT') b, emp a
WHERE a.sal> b.sal; -- error _ ambiguous Column 명 앞에 반드시 테이블 alias를 prefix 해줘야 한다.

-- 2 
SELECT * FROM emp a, (SELECT ename, sal FROM emp WHERE ename = 'SCOTT') b
WHERE a.sal>b.sal;

SELECT * FROM emp;

-- 직속상관이 KING인 사원의 사원번호와 이름을 검색
-- (자신의 mgr 번호가 king의 사원번호와 같은)
SELECT empno, ename
FROM emp
WHERE mgr = (SELECT empno From emp WHERE ename = 'king');

-- job이 사원번호 7369번의 업무와 같고, 급여가 사원번호 7876번호의 사원보다 많은 사원을 검색
-- 2개의 서브쿼리 사용
-- 1. 내꺼
SELECT a.empno, a.ename, a.job, a.sal FROM emp a, (SELECT job FROM emp WHERE empno = 7369) b, (SELECT sal FROM emp WHERE empno = 7876) c
WHERE a.job= b.job and a.sal>c.sal;

-- 2. 강사님
SELECT empno, ename, job, sal
FROM emp
WHERE job = (SELECT job FROM emp WHERE empno = 7369)
AND sal > (SELECT sal FROM emp WHERE empno = 7876);

-- HAVING 절 뒤에 나오는 서브쿼리
-- 단일행 서브쿼리다

-- 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색

SELECT deptno 부서, min(sal) 최소급여 FROM emp GROUP BY deptno; -- (1300, 800, 950)

SELECT deptno 부서번호, min(sal) 최소급여
FROM emp
GROUP BY deptno
HAVING  min(sal) > (SELECT min(sal) 최소급여 FROM emp WHERE deptno =20)
ORDER BY 1;

/*
다중행 서브쿼리는 단일행 연산자를 사용할 수 없다.
단일행 비교 연산자 : >, <, =, !=, < >

다중행 서브쿼리는 다중행 연산자를 사용해야 한다.
다중행 연산자 : IN, ANY, ALL
			IN(여러값 중에서 하나라도 참이면 수행됨)
*/
-- 부서별 최소급여보다 더 큰 급여를 받는 사원을 검색
-- (SELECT min(sal) FROM emp GROUP BY deptno) 다중행 서브쿼리

-- 다중행 연산자 사용 (다중행 서브쿼리 반환)
SELECT ename, sal, deptno
FROM emp
WHERE sal IN(SELECT min(sal) FROM emp GROUP BY deptno); -- 다중행을 반환하기 때문에 Error!

-- 급여를 3000 달러 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원을 검색
SELECT DISTINCT deptno FROM emp WHERE sal>=3000;

SELECT deptno, ename, sal
FROM emp
WHERE deptno IN(SELECT DISTINCT deptno FROM emp WHERE sal>=3000)
ORDER BY 1;

/*
다중행 연산자
Sal < ANY : CLERK의 급여중에서 최대값보다 작은 sal
Sal > ANY : CLERK의 급여중에서 최소값 큰 sal
-----------------------------------------------------
Sal < ALL : ClERK의 급여중에서 최소값보다 작은 sal
Sal > ALL : ClERK의 급여중에서 최대값보다 큰 sal
*/
-- 급여가 어떤 ClERK 의 급여보다도 작으면서 CLERK 이 아닌 사원을 검색
SELECT sal FROM emp WHERE job ='clerk'; -- 800, 1100,950,1300

SELECT empno, ename, sal, job
FROM emp
WHERE sal < ANY(SELECT sal FROM emp WHERE job ='clerk') AND job<>'clerk';

SELECT empno, ename, sal, job
FROM emp
WHERE sal < (SELECT max(sal) FROM emp WHERE job ='clerk') AND job<>'clerk';

-- 급여가 모든 부서의 평균급여보다 더 많은 사원을 검색
SELECT empno, ename, sal, deptno
FROM emp
WHERE sal > ALL(SELECT avg(sal) FROM emp GROUP BY deptno);

-- from 절에 단일행 서브쿼리
SELECT empno, ename, sal, deptno
FROM emp
WHERE sal > (SELECT max(sal) 
from (SELECT avg(sal) sal FROM emp GROUP BY deptno)a);

-- where 절에 단일행 서브쿼리
SELECT empno, ename, sal, deptno
FROM emp
WHERE sal > (SELECT avg(sal) FROM emp GROUP BY deptno ORDER BY 1 DESC limit 1);

-- 급여가 30번 부서에 속한 그 어떤(모든) 사원의 급여보다도 많은 급여를 받는 사원을 검색
-- 이때 30번 부서에 속한 사원은 일단 제외;
-- 정렬은 사원번호 순으로 한다.

SELECT empno, ename, sal, deptno
FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE DEPTNO = 30 ORDER BY 1) 
	AND deptno<>30
ORDER BY 1;

SELECT empno, ename, sal, deptno
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE DEPTNO = 30 ORDER BY 1 DESC limit 1)
	AND deptno<>30
ORDER BY 1;
    
SELECT empno, ename, sal, deptno
FROM emp
WHERE sal > (SELECT max(sal) FROM(SELECT sal FROM emp WHERE DEPTNO = 30) t)
	AND deptno<>30
ORDER BY 1;

-- 20번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원을 검색해라
-- 1. 다중행 연산자
SELECT empno, ename, sal, deptno
FROM emp 
WHERE sal> ALL(SELECT sal FROM emp WHERE deptno=20) 
ORDER BY 1;

-- 2. 단일행 연산자
SELECT empno, ename, sal, deptno
FROM emp
WHERE sal > (SELECT max(sal) from(SELECT sal FROM emp WHERE deptno=20) t) 
ORDER BY 1;

SELECT sal FROM emp WHERE deptno=20; -- 800, 2975, 3000, 1100, 3000

-- 부서번호가 30번인 사원들의 급여 중 가장 낮은 급여보다 높은 급여를 받는 사원을 검색

-- 1. 다중행 연산자
SELECT empno, ename, sal, deptno
FROM emp 
WHERE sal > ANY (SELECT sal FROM emp WHERE deptno=30)
ORDER BY 1;

-- 2. 단일행 연산자
SELECT empno, ename, sal, deptno
FROM emp 
WHERE sal > (SELECT min(sal) FROM emp WHERE deptno=30)
ORDER BY 1;

SELECT sal FROM emp WHERE deptno = 30; -- 950 보다 높은 급여를 받는 사원을 검색


