-- 2024.07.23 그룹함수
/*
- 그룹함수 : 그룹 전체를 다 집계한 결과로 값이 도출되는 함수

COUNT() NULL 값을 포함한 행의 수를 반환
COUNT(컬럼명) 컬럼에 해당하는 행의 수를 반환 NULL값은 제외 
SUM(컬럼명) 컬럼값의 총합 
AVG(컬럼명) 평균
MAX(컬럼명) 최대값 
MIN(컬럼명) 최소값
*/ 

-- COUNT 
-- 전체 사원 수를 조회
SELECT count(*) FROM emp; -- * 모든 컬럼
SELECT count(-1) FROM emp; -- -1 마지막 행을 가져옴
SELECT count(empno) FROM emp; -- empno PK Null 허용x
-- 특정한 컬럼의 갯수
SELECT count(mgr) FROM emp; -- mgr 컬럼값의 null값은 건너뛰고 갯수를 반환

SELECT round(avg(sal)), sum(sal), min(sal), max(sal), count(sal) from emp;
SELECT format(round(avg(sal)),'#,###'), sum(sal), min(sal), max(sal), count(sal) from emp;

DELETE FROM emp WHERE Empno ='8001'; -- workshop에서 추가했던 행 삭제

-- emp 테이블에서 입사한지 가장 오래된 사원가 가장 최근에 입사한 사원의 입사일을 검색
-- avg(), sum() 그룹함수는 숫자데이터, 나머지는 모든 데이터 타입에 적용된다. 
SELECT min(hiredate), max(hiredate) from emp;

-- 부서번호가 10번이거나 20번인 사원의 수를 검색
SELECT count(empno) from emp
WHERE deptno in(10, 20);

-- 모든 사원의 보너스의 평균을 검색...AVG() 소수점 2번째 자리까지 출력
SELECT round(avg(comm),2) AS 보너스평균 from emp ; -- 잘못된 연산임. 
-- 그룹함수는 null을 건너뛰고 계산함. 14로 나누어야 하는데 잘못나눴다. 

SELECT round(avg(ifnull(comm,0)),2) AS 보너스평균 from emp ;

SELECT deptno From emp;
-- emp 테이블에서 존재하는 부서의 갯수를 검색
-- 1..잘못된 결과 중복을 제거하지 않음.
SELECT count(deptno) FROM emp;
-- 2..중복을 벗겨내고 count를 적용.
SELECT count(DISTINCT(deptno)) FROM emp;

SELECT * from emp;

/*
GROUP BY절
*/
-- 평균급여를 검색..
-- 그룹함수의 적용되지 않는 컬럼이 select절에 나열되어서는 안된다.
-- 만약 select 절에 나열되려면 group by 절에 명시되어야 한다. 
-- 1
SELECT deptno, round(avg(sal)) FROM emp; -- deptno 는 여러행, avg 는 한행 
-- 2 
SELECT deptno, round(avg(sal)) FROM emp group by deptno; -- 부서별 avg salary
-- 3 
/*
FROM -> WHERE -> GROUP BY -> SELECT 순으로 실행
SELECT절 컬럼명에 대한 Alias는 GROUP BY 절에서는 인식이 불가능하다. 
그런데 MYSQL에서는 GROUP BY절 뒤에 Alias 사용 가능. 
오라클은 절대 불가
*/
SELECT deptno DNumber, round(avg(sal)) AvgSalary -- 3
FROM emp -- 1 
GROUP BY DNumber
ORDER BY DNumber; -- 2 부서별 avg salary

-- where절이 실행되고 grouping이 된다.
SELECT deptno DNumber, round(avg(sal)) AvgSalary
FROM emp 
WHERE deptno !=10
GROUP BY DNumber
ORDER BY DNumber; 

-- where절에서 Alias 사용 불가
SELECT deptno DNumber, round(avg(sal)) AvgSalary
FROM emp 
WHERE DNumber !=10
GROUP BY DNumber
ORDER BY DNumber; 

-- 입사년도별 사원의 인원 수를 출력 Alias는 사원수
SELECT year(hiredate) 입사년도, count(empno) AS 사원수
FROM emp
GROUP BY 입사년도
ORDER BY 입사년도;

SELECT date_format(hiredate,'%Y') 입사년도, count(*) 사원수
FROM emp
GROUP BY 1
ORDER BY 1;

-- 부서별 평균급여가 2000달러 이상인 부서번호와 평균급여를 검색
-- WHERE절에서는 GROUP 함수를 사용할 수 없다.. HAVING절이 필요하다.
SELECT deptno 부서번호, AVG(sal) AS 평균급여
FROM emp
WHERE avg(sal)>=2000
GROUP BY deptno;

-- 1. 그룹별 평균급여를 구한 후 거기서 다시 추릴때 HAVING 절을 사용한다. 
SELECT deptno 부서번호, AVG(sal) AS 평균급여
FROM emp
GROUP BY deptno;

-- 순서 유의 !!! GROUP BY 절 이후에 HAVING절 사용
/*
FROM(테이블) -> WHERE(행을제한) ->  GROUP BY -> HAVING -> SELECT(컬럼추출) -> ORDER BY

where절에 올 수 없는 것
1) 그룹함수
2) 알리야스

*/
SELECT deptno 부서번호, AVG(sal) AS 평균급여
FROM emp 
WHERE deptno <> 10
GROUP BY deptno
HAVING avg(sal)>=2000
ORDER BY 2;


-- 최대급여가 2900 달러가 넘는 부서들의 최대급여를 검색
-- 1)
SELECT deptno 부서번호, max(sal) AS 최대급여
FROM emp
GROUP BY deptno; -- 5000, 3000, 2850
-- 2)

SELECT deptno 부서번호, max(sal) AS 최대급여
FROM emp
GROUP BY deptno
HAVING max(sal)>2900
ORDER BY 1;

/*
ROLLUP
- GROUP BY 절의 확장이다.
- 그룹항목중 총합이나 각 그룹별 중간 합계가 필요한 경우에 사용된다.

ROLLUP의 인수는 계층구조이므로 인수의 순서가 바뀌면 수행결과도 바뀌게 되므로
인수의 순서에 주의를 해야한다.
*/

-- 1. 부서별 인원수, 급여의 합
SELECT deptno 부서명, count(empno) 사원수, sum(sal) '급여의 합'
FROM emp
GROUP BY deptno
ORDER BY 3;

-- 1-1. total 값
SELECT deptno 부서명, count(empno) 사원수, sum(sal) '급여의 합'
FROM emp
GROUP BY deptno WITH ROLLUP;

-- 1-2. sub-Total값
SELECT deptno 부서명, count(empno) 사원수, sum(sal) '급여의 합'
FROM emp
GROUP BY deptno WITH ROLLUP;

-- 2. 부서별, 업무별, 급여의 합
SELECT deptno 부서명, job 업무, sum(sal) '급여총합'
FROM emp
GROUP BY deptno, job 
ORDER BY 1;

-- 2-1. 부서별, 업무별, 급여의 합 and sub-total, grand-total
SELECT deptno 부서명, job 업무, sum(sal) '급여총합'
FROM emp
GROUP BY deptno, job WITH ROLLUP
ORDER BY 1;

-- 2-2. 부서별, 업무별, 급여의 합 , 인수의 순서를 유의
SELECT job 업무, deptno 부서명, sum(sal) '급여총합'
FROM emp
GROUP BY job, deptno WITH ROLLUP
ORDER BY 1;

/*
[실행순서]
FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY -> LIMIT
[문법순서]
SELECT -> DISTINCT -> FROM -> WHERE -> GROUP BY -> HAVING -> ORDER BY -> LIMIT
*/



