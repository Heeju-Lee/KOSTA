-- ##################  숫자 함수 실습 ######################

/* 
  1) 급여가 $1,500부터 $3,000 사이의 사람은 급여의 15%를 회비로 지불하기로 하였다. 
  이를 이름, 급여, 회비(소수점 두 자리 아래에서 반올림)를 출력하라.
*/
SELECT ename 이름, sal 급여, round(sal*0.15,2) 회비 FROM emp
WHERE sal BETWEEN 1500 AND 3000;

-- 2) 급여가 $2,000 이상인 모든 사람은 급여의 5%를 경조비로 내기 로 하였다. 
-- 이름, 급여, 경조비(소수점 이하 절삭)를 출력하라.
SELECT ename 이름, sal 급여, floor(sal*0.05) 경조비 FROM emp WHERE sal>=2000;

 -- 3) 이익을 배분하기 위해 comm의 150%를 보너스로 지급하려 한다. comm이 있는 직원들을 대상으로 
 -- 직원번호, 직원명, 급여, comm의 150%를 소숫점이하 올림하여 출력하라. (comm이 0이거나, null이면 제외)
SELECT empno 직원번호, ename 직원명, sal 급여, ceiling(ifnull(comm,0)*1.5) 보너스
FROM emp
WHERE comm=null OR comm!=0;

/*
 4) 부서번호가 20인 부서의 시간당 임금을 계산하여 출력하라. 단, 1달의 근무일수는 12일이고, 1일 근무시간은 5시간이다.   
 출력양식은 이름, 급여, 시간당 임금(소수이하 첫 번째 자리에서 반올림)을 출력하라
 */
SELECT ename 이름, sal 급여, round(sal/12/5,0) 시간당임금
FROM emp
WHERE deptno=20;

-- 5)  30번 부서의 연봉을 계산하여 이름, 부서번호, 급여, 연봉을 출력하라. 단, 연말에 급여의 170%를 보너스로 지급한다.
SELECT ename 이름, deptno 부서번호, sal 급여, sal*12+ifnull(comm,0)+sal*1.7 연봉
FROM emp
WHERE deptno =30;

--  6) emp Table에서 이름, 급여, 커미션 금액, 총액(sal + comm)을  구하여 총액이 많은 순서로 출력하라. 
--  단, 커미션이 NULL인 사람은 제외한다.(커미션금액: sal*comm/100)
SELECT ename 이름, sal 급여, sal*comm/100 커미션금액, sal+sal*ifnull(comm,0)/100 총액
FROM emp
WHERE comm is not null
ORDER BY sal+sal*comm/100 DESC;


