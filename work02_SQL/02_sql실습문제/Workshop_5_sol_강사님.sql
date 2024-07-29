-- ### SubQuery 리뷰 ###
-- 1.  ‘SMITH'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를  출력하라.

select e.ename, d.dname, e.sal, e.job
from emp e join dept d on  d.deptno= e.deptno
where e.job = (select job from emp where ename='SMITH');




-- 2. 10번 부서와 같은 일을 하는 사원의 사원번호, 이름, 부서명,지역, 급여를 급여가 많은 순으로 출력하라.

select e.empno, e.ename, d.dname, d.loc, e.sal
from emp e, dept d
where e.deptno = d.deptno and job in  ( select job from emp where deptno=10)
order by sal desc;

-- ===========================================
select e.empno, e.ename, d.dname, d.loc, sal
from emp e join dept d on e.deptno=d.deptno
where e.job  in (select job from emp where deptno=10)
Order by sal  desc;


-- ### equi join ###

-- 1.  emp와 dept Table을 JOIN하여 부서번호, 부서명, 이름, 급여를  출력하라.

select  dept.deptno, dname, ename, sal
from emp , dept 
where emp.deptno = dept.deptno 
order by dept.deptno;

-- =====================================
select d.deptno, d.dname, e.ename, e.sal 
from emp e  join dept d on e.deptno=d.deptno
order by d.deptno;
-- =====================================
select deptno, d.dname, e.ename, e.sal 
from emp e  join dept d using (deptno);

-- 2.  이름이 ‘SMITH’인 사원의 부서명을 출력하라.

select  dname
from emp, dept
where emp.deptno  = dept.deptno  and emp.ename='SMITH';
-- ========================================
select d.dname, e.ename
from emp e  join  dept d using (deptno)
where  e.ename='SMITH';

select d.dname, e.ename
from emp e  join  dept d on e.deptno=d.deptno
where  e.ename='SMITH';

 
-- ### outer join ###
-- 1.  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 
-- 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
SELECT e.ename 이름, d.deptno 부서번호, d.dname 부서명, e.sal 급여 
FROM emp e RIGHT OUTER JOIN dept d 
ON e.deptno = d.deptno;



-- ###self join###
-- 2.  emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라. ‘SMTH의 매니저는 FORD이다’
-- 1)
SELECT concat(e.ename, '의 매니저는 ', m.ename, '이다.') Info 
FROM (SELECT ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m 
WHERE e.mgr = m.empno;

-- 2)

SELECT concat(e.ename, '의 매니저는 ', m.ename, '이다') Info
FROM emp e, emp m
WHERE e.mgr = m.empno;



-- ### join 실습 ###

-- 1. 관리자가 7698인 사원의 이름, 사원번호, 관리자번호, 관리자명을 출력하라.

select  e.ename, e.empno, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno and m.empno = 7698;

select  e.ename, e.empno, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno and e.mgr = 7698;
-- ========================================
select e1.ename ename, e1.empno empno, e1.mgr, e2.ename
from  emp e1 JOIN  emp e2 ON  e1.mgr= e2.empno
WHERE e1.mgr='7698';

-- 2. 업무가 MANAGER이거나 CLERK인 사원의 사원번호, 이름, 급여, 업무, 부서명
select empno, ename, job, dname
from emp, dept
where emp.deptno =  dept.deptno and (  job='MANAGER' or job='CLERK');

select empno, ename, job, dname
from emp, dept
where emp.deptno =  dept.deptno and  job in ('MANAGER' ,'CLERK');

-- ========================================
  select empno, ename, job, deptno, dname
  FROM   emp   JOIN dept   USING (deptno)
  WHERE  job ='MANAGER' or job='CLERK'  ;

-- ### set 연산자 ### --
-- dept와 비슷한 테이블(dept테이블의 10, 20부서데이터를 입력)을 하나 생성한다.
create table newdept 
as 
select * from dept where deptno in (10, 20);
-- 추가 데이터를 입력한다.
insert into newdept values(50, 'MARKETING', 'SEOUL');
select * from newdept;
select * from dept;

-- 2. dept테이블과 newdept 테이블의 모든 행을 출력하라.(단, 중복되는 행은 한번만 출력한다)
select * from dept
union
select * from newdept;


-- 3. dept테이블과 newdept 테이블의 모든 행을 출력하라.
select * from dept
union all
select * from newdept;







