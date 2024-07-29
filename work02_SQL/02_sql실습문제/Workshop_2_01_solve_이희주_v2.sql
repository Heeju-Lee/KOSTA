-- ###############  지난 시간 리뷰 실습    ###############

-- 1) 급여가 $1500 ~ $2000 이 아닌 사원의 ename 과 SAL를 검색
--  각각 별칭을 NAME, SALARY로 합니다.
SELECT ename NAME, sal SALARY
FROM emp
WHERE sal BETWEEN 1500 AND 2000;

-- 2)  30번 부서의 연봉을 계산하여 이름, 부서번호, 급여, 연봉을 출력하라. 단, 연말에 급여의 150%를 보너스로 지급한다.
SELECT ename 이름, deptno 부서번호, sal 급여, sal*12+ifnull(comm,0)+sal*1.5 연봉
FROM emp
WHERE deptno = 30;

-- 3) 직원들의 입사일을 기준으로 81년도에 입사한 사원중에서 가장 최근에 입사한 사원 2명을 추리고 해당 사원의 정보를 출력한다. 이때 정보출력은 3가지로 하고 각각 컬럼에 대한 별칭을 부여한다.
SELECT * FROM emp
WHERE left(hiredate,4)=1981
ORDER BY hiredate DESC
limit 2;

-- ##############  문자열 함수 실습   #################
-- 1) 직원의 이름에 대소문자 상관없이 s가 들어간 직원의 모든 정보를 출력하라.
SELECT * FROM emp
WHERE ename LIKE '%s%';

-- 2) 직원 정보 중 사원번호, 이름, 급여를 출력한다.  단, 이름은 앞에서 3글자씩만 출력하라.
SELECT empno, substr(ename,1,3) '이름의 앞 3글자', sal
FROM emp;

-- 3) 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자만 구하여 소문자로 이름만을 출력하라.
SELECT LOWER(substr(ename,1,3)) '이름의 앞 3글자 소문자' FROM emp;

-- 4) 직원의 이름과 급여를 출력하라, 단, 금액의 정확도를 위해 급여를 6자리로 출력하고, 앞 여백을 모두 * 로 채워 출력하라.
SELECT ename 이름, lpad(sal,6,'*') '월 급여'
from emp;

-- 5) 직원정보를 입력하던중 아래와 같이 입력 되었다.
insert into emp values(8001,'   PARK   ', 'IT' ,  7900 , '21/11/10', 20000,1000,10);
select * from emp;

-- 이름이 'PARK'인 직원의 정보를 출력하여 보자.
 SELECT * FROM emp
 WHERE ename LIKE 'PARK'; -- 다시보기

-- 이름 좌우에 공백이 있더라도 공백을 제거하고 이름이 'PARK'인 직원의 정보를 출력하여 보자.
SELECT * FROM emp
WHERE  trim(ename) LIKE 'PARK'; -- 다시보기