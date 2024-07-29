-- ##################  지난 시간 리뷰 ######################
/*
1) 급여가 $1,500부터 $3,000 사이의 사람은 급여의 15%를 회비로 지불하기로 하였다. 
   이를 이름, 급여, 회비(소수점 두 자리 아래에서 반올림)를 출력하라.
   -->
   위 문제에 해당하는 SQL문은 
   select ename, sal, round(sal*0.15, 2) 회비
   from emp
   where sal between 1500 and 3000;
   이다. 해당 SQL 문을 MySQL에서 제공하는 if문을 이용해서 다시 수정해본다.
*/
SELECT ename 이름, sal 급여, round(SAL*0.15,2) AS 회비
from emp
where if(sal<=3000 and sal>=1500, round(SAL*0.15,2),'');

-- 2) 급여가 $2,000 이상인 모든 사람은 급여의 5%를 경조비로 내기로 하였다. 
-- 이름, 급여, 경조비(소수점 이하 절삭)를 출력하라. (if문을 이용해서 sql문을 작성한다)
SELECT ename 이름, sal 급여, floor(sal*0.05) AS 경조비 FROM emp
WHERE if(sal>=2000,floor(sal*0.05),'');

 -- 3) 이익을 배분하기 위해 comm의 150%를 보너스로 지급하려 한다. comm이 있는 직원들을 대상으로 
 -- 직원번호, 직원명, 급여, comm의 150%를 소숫점이하 올림하여 출력하라. (comm이 0이거나, null이면 제외)
SELECT empno 직원번호, ename 직원명, sal 급여, ceil((comm*1.5)*100)/100 AS 보너스
FROM emp
WHERE if(comm is not null or comm!=0, comm*1.5, '');

-- ##################  날짜 함수 실습 ######################

-- 1)입사일로부터 100일이 지난 후를 구해보자. 
-- 이름, 입사일, 입사일로부터 100일 후, 급요를 출력한다.
-- 별칭은 사원이름, 입사일, 100일 후의 날, 사원급여로 한다.
SELECT ename 이름, hiredate 입사일, adddate(hiredate,interval 100 DAY) AS '입사 100일 후', sal 사원급여
From emp;

-- 2) 입사일로부터 6개월이 지난 후의 날짜를 구하려고 한다.  입사일, 6개월 후의 날짜, 급여를 출력하라
SELECT ename 이름, hiredate 입사일, adddate(hiredate,interval 6 month) AS '입사 6개월 후', sal 사원급여
From emp;

-- 3) 입사한 달의 근무일수를 계산하여 부서번호, 이름, 근무일수를 출력하라.
SELECT empno 부서번호, ename 이름, hiredate 입사일, abs(datediff(hiredate,last_day(hiredate)))+1 '입사한 달의 근무일수'
From emp;

-- 4) 모든 사원의 입사일 기준으로 100일이 지난 후의 월요일의 날짜를 구해서 이름, 입사일,’MONDAY’를 출력하라.
SELECT ename 이름, 
hiredate 입사일, 
ADDDATE(
	ADDDATE(hiredate, interval 100 DAY),
    INTERVAL (7-weekday(ADDDATE(hiredate, interval 100 DAY)))%7 DAY) AS MONDAY
FROM EMP;

-- 5) 입사일로부터 오늘까지의 일수를 구하여 이름, 입사일, 근무일수를 출력하라. //초일산입 
SELECT ename 이름, HIREDATE 입사일, datediff(curdate(),hiredate)+1 AS 근무일수
FROM emp;

-- 6) 직원의 이름, 근속년수를 구하여 출력하라.
SELECT ename 이름, year(curdate())-year(HIREDATE)+1 근속년수
FROM emp;

-- 사원들의 직원 평균 급여 
SELECT ceil(avg(sal)*100)/100 '직원의 평균 급여' FROM emp;

