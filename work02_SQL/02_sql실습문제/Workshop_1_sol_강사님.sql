-- 1) emp 테이블 정보를 확인하세요.
desc emp;

-- 2) 부서번호가 20번인 부서의 사람 중 사원번호, 이름, 월급을 출력하라
select empno, ename, sal
from emp
where  deptno=20;


-- 3) 사원번호가 7521인 사람 중 이름, 입사일, 부서번호를 출력하라.

select empno, ename, hiredate, deptno
from emp
where empno=7521;

-- 4) 이름이 JONES인 사람의 모든 정보를 출력하라.
select *
from emp
where ename='JONES';

-- 5) 직업이 MANAGER인 사람의 모든 정보를 출력하라.
select *
from emp
where job='MANAGER';

-- 6)직업이 MANAGER가 아닌 사람의 모든 정보를 출력하라.
select *
from emp
where job !='MANAGER';

-- 7) 급여가 $1000 이상인 사람의 이름, 급여, 부서번호를 출력하라.
select ename, sal, deptno
from emp
where sal>=1000;

-- 8) 급여가 $1,600보다 크고 $3,000보다 작은 사람의 이름, 직업, 급여를 출력하라.
select ename, job, sal
from emp
where sal>=1600 and sal<=3000;

select ename, job, sal
from emp
where sal between 1600 and 3000;

-- 9) 입사일이 80년도인 사람의 모든 정보를 출력하라

select *
from emp
where hiredate like '80%';

-- 10) 입사일이 81/12/09 보다 먼저 입사한 사람들의 모든 정보를 출력하라.
select *
from emp
where hiredate < '81/12/09';


-- 11) 이름이 S로 시작하는 사원의 사원번호, 이름, 입사일, 급여을 출력하라.

select  empno, ename, hiredate, sal
from emp
where ename like 'S%';


-- 12) 이름 중 S자가 들어가 있는 사람만 모든 정보를 출력하라.
select  empno, ename, hiredate, sal
from emp
where ename like '%S%';


-- 13) 커미션이 NULL인 사람의 정보를 출력하라.
Select *
from emp
where comm is null;


-- 14) 커미션이 NULL이 아닌 사람의 모든 정보를 출력하라.

Select *
from emp
where comm is not null;

--15) 부서가 30번 부서이고 급여가 $1,500 이상인 사람의 이름, 부서 ,월급을 출력하라.

select ename, deptno, sal
from emp
where deptno=30 and sal>=1500;

-- 16) 부서번호가 30인 사람 중 사원번호 SORT하라.

select *
from emp
where deptno=30
order by empno;

-- 17) 급여가 많은 순으로 SORT하라.
select * from emp  order by sal desc;

-- 18) 부서번호로 ASCENDING SORT한 후 급여가 많은 사람 순으로  출력하라.
select * from emp order by deptno, sal desc;

-- 19) emp Table에서 이름, 급여, 커미션 금액, 총액(sal + comm)을  구하여 총액이 많은 순서로 출력하라. 
-- 단, 커미션이 NULL인 사람은 제외한다.(커미션금액: sal*comm/100)
select  ename, sal, sal*comm/100 커미션금액 , sal+comm as 총액
from emp
where comm is not null
order by 총액 desc;

-- 20)  10번 부서의 모든 사람들에게 급여의 13%를 보너스로 지불하기로 하였다. 이름, 급여, 보너스 금액, 부서번호를 출력하라.
select ename, sal, sal*0.13 보너스, deptno
from emp
where  deptno=10;

