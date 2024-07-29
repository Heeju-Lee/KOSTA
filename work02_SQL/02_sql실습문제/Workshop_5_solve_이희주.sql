-- ### SubQuery 리뷰 ###
-- 1.  ‘SMITH'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를  출력하라.
SELECT ename 이름, deptno 부서명, sal 급여, job 직무
FROM emp
WHERE job= (SELECT job FROM emp WHERE ename = 'smith');

SELECT job FROM emp WHERE ename = 'smith';

-- 2. 10번 부서와 같은 일을 하는 사원의 사원번호, 이름, 부서명,지역, 급여를 급여가 많은 순으로 출력하라.
SELECT  e.empno 사원번호, e.ename 이름, e.deptno 부서명, d.loc 지역, e.sal 급여
FROM emp e 
JOIN dept d
ON e.deptno = d.deptno
AND job IN (SELECT job FROM emp WHERE deptno = 10)
ORDER BY 5 DESC;


-- ### equi join ###

-- 1.  emp와 dept Table을 JOIN하여 부서번호, 부서명, 이름, 급여를  출력하라.
SELECT deptno, d.dname, e.ename, e.sal
FROM emp e
JOIN dept d
USING (deptno);

-- 2.  이름이 ‘SMITH’인 사원의 부서명을 출력하라.
SELECT d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.ename = 'smith';
 
-- ### outer join ###

-- 1.  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 
-- 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
SELECT e.ename, d.deptno, d.dname, e.sal
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- ###self join###
-- 2.  emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라. ‘SMTH의 매니저는 FORD이다’
SELECT concat(e.ename, '의 매니저는 ', m.ename, '이다.') Info
FROM emp e, emp m
WHERE e.mgr=m.empno;

-- ### join 실습 ###

-- 1. 관리자가 7698인 사원의 이름, 사원번호, 관리자번호, 관리자명을 출력하라.
SELECT e.ename 사원이름, e.deptno 사원번호, m.deptno 관리자번호, m.ename 관리자명
FROM emp e, emp m
WHERE e.ename in(SELECT ename FROM emp WHERE mgr = 7698)
AND e.mgr = m.empno;

-- 2. 업무가 MANAGER이거나 CLERK인 사원의 사원번호, 이름, 급여, 업무, 부서명
SELECT e.ename 사원이름, e.deptno 사원번호, e.job 업무, d.dname 부서명
FROM emp e 
JOIN dept d
ON e.deptno = d.deptno
AND e.ename IN(SELECT ename FROM emp WHERE job IN('Manager','clerk'));

-- ### set 연산자 ### --
-- 1. dept와 동일한 테이블(단 dept테이블의 10, 20부서의 데이터를 입력)을 하나 생성한다.
-- 테이블명은 newdept로 하자  
CREATE TABLE newdept
AS
(SELECT * FROM dept);

-- 2. 추가 데이터를 입력한다. 2행입력
INSERT INTO newdept VALUES(50, 'DEVELOPMENT', 'LA');
INSERT INTO newdept VALUES(60, 'M&A', 'LASVEGAS');

-- 3. dept테이블과 newdept 테이블의 모든 행을 출력하라.(단, 중복되는 행은 한번만 출력한다)
SELECT * FROM dept
UNION
SELECT * FROM newdept;

-- 4. dept테이블과 newdept 테이블의 모든 행을 출력하라.
SELECT * FROM dept
UNION ALL
SELECT * FROM newdept;

