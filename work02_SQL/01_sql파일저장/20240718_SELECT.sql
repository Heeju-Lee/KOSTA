/*
------------------------ 2024. 07. 18 ------------------------
-- 1. 기본 SELECT 구문
	1) Projection 과 Selection
	 - Projcetion : 원하는 컬럼을 지정해서 데이타를 가져오는 쿼리문
     - Selection : 전체 혹은 원하는 행만 가져오는 쿼리문 
				"*(모든 컬럼)" 쓰지마라: 보안과 용량 때문임.
*/

SELECT * FROM emp;
SELECT ename, job, sal, deptno FROM emp; -- O Projection
SELECT ename, job, sal, deptno FROM emp WHERE deptno=10; -- Projection + selection

SELECT empno, ename, sal, hiredate 
FROM emp
WHERE job='SALESMAN'
ORDER BY sal;

SELECT empno, ename, sal, hiredate 
FROM emp
WHERE job='SALESMAN'
ORDER BY sal ASC;

SELECT empno, ename, sal, hiredate 
FROM emp
WHERE job='SALESMAN'
ORDER BY sal DESC;

-- emp테이블에서 이름, 업무, 급여, 부서번호.. 출력/ 부서번호가 20번 인 사원만 출력하기. 급여순으로 정렬
-- 1
SELECT ename, job, sal, deptno
FROM emp
WHERE deptno='20'
ORDER BY sal;

-- 2. 4는 디스플레이 되어있는 네번째 컬럼을 뜻함.
SELECT ename, job, sal, deptno
FROM emp
WHERE deptno='20'
ORDER BY 4;

-- 사원중에서 입사일이 가장 빠른 사원순으로 출력, 프로젝션은 알아서
SELECT empno, ename, hiredate, deptno
FROM emp
ORDER BY 3;

/*
DISTINCT
1) 중복을 벗겨내는 키워드
2) SELECT절 바로 다음에 사용한다.
3) 정렬이 되지 않는다.별도로 해줘야한다.
4) 중복을 제거하는 연산은 많은 시간이 소요됨.
	만약 불가피하게 사용해야 된다면, DISTINCT 연산을 대체하는 방법이나 혹은
	연산의 대상이 되는 테이블의 크기를 최소화 하는 방법을 반드시 고민해야 한다.
    가장 대표적인 방법으로는 EXISTS를 활용하는 방법이 있다. 
    EXISTS는 서브쿼리와 함께 주로 사용된다. 
*/
-- emp테이블에서 직원들이 속한 부서의 번호를 알고싶다. 사원들이 속해있는 부서번호만을 출력
-- 1
SELECT deptno FROM emp;

-- 2 
SELECT DISTINCT(deptno)
FROM emp;

-- 3
SELECT DISTINCT(deptno)
FROM emp ORDER BY 1;

/*
Alias
컬럼에 별칭을 부여하는 기술
주로 컬럼에 산술연산이 적용되면 Alias를 무조건 해준다.
1) 컬럼명 AS 별칭 | 컬럼명 별칭 | 컬럼명 '공백 별칭'
2) 별칭에 공백이 있거나 특수문자가 있는 경우에는 'xxx'  로 감싸준다.
3) 2)번과 같은 경우에 정렬할 때 'xxx' 이 부분은 정렬이 되지 않는다.(오라클은 가넝한)
*/
-- 모든 사원의 급여를 기존급여에서 100$를 더한값의 1.5배로 증가한 급여를 계산하고 결과를 출력한다.
-- 1
SELECT ename, sal, (sal+100)*1.5
FROM emp;

-- 2
SELECT ename, sal, (sal+100)*1.5 AS 인상급여
FROM emp;

-- 3
SELECT ename, sal, (sal+100)*1.5 인상급여
FROM emp;

-- 4
SELECT ename, sal, (sal+100)*1.5 '인상 급여'
FROM emp;

-- 5 인상된 급여준으로 정렬(가장 많은 인상급여가 맨 위에 오도록 정렬
SELECT ename, sal, (sal+100)*1.5 '인상 급여'
FROM emp
ORDER BY (sal+100)*1.5 DESC;

SELECT ename, sal, (sal+100)*1.5 '인상 급여'
FROM emp
ORDER BY '인상 급여' DESC; -- semantic error 정렬불가

SELECT ename, sal, (sal+100)*1.5 '인상 급여'
FROM emp
ORDER BY 3 DESC; -- 정렬 가능함

-- 사원의 급여에서 세금을 제외한 실수령 급여를 출력.. 
-- 이때 세금은 급여분의 10%라고 간주한다.
-- 정렬은 실수령액으로 한다.
SELECT ename '직원', sal '급여', (sal*0.9) '실수령액'
FROM emp
ORDER BY 3;

/*
null값에 대한 정리
1) 0도아니고 공백도 아니다.
2) '자격없음'이나 '미확정'을 뜻하는 값일 때 주로 사용된다.
3) null값은 연산적용이 되지 않는다.(+, -, *, /) --> null값을 다른 값(0)으로 치환해서 사용(ifnull 함수 사용)
4) 비교도 되지 않는다.(=, !=, <=, >=, <, >)--> comm = null (x), IS, A IS NOT B (O)
5) MySQL에서는 null값이 가장 작은 값으로 사용(Oracle에서는 반대임. 가장 큰 값으로 취급된다.)

*/
-- emp테이블에서 모든 사원들의 각각 연봉을 출력
SELECT ename, deptno, job, sal '직원', sal*12 + comm 'Annual salary'
FROM emp
ORDER BY 5 DESC; -- comm이 null인 사원의 연봉은 구할 수가 없다.

-- 1
SELECT ename, deptno, job, sal '직원', sal*12 + ifnull(comm, 0) 'Annual salary'
FROM emp
ORDER BY 5 DESC; 

-- 2
-- comm을 가장 많이 받는 사원순으로 정렬하기
SELECT ename, job, ifnull(comm, 0)
FROM emp
ORDER BY 3 DESC;

-- 3
-- comm을 가장 많이 받는 사원순으로 정렬하기
-- 단, comm이 null인 사원은 제외하고 (!=를 사용할 수없다.)
SELECT ename, job, comm
FROM emp
WHERE comm is not null 
ORDER BY 3 DESC;

-- 사원 중에서 급여를 가장 많이 받는 사원이 먼저 출력되도록 
SELECT ename, sal
FROM emp
ORDER BY 2 DESC;
/*
LIMIT
디스플레이 되는 행의 갯수를 최종적으로 제한하는 기능을 한다.
ex) limit 0,5; 0: 처음시작을 의미 5:5개만 출력해라 
limit 5; : 처음부터 상위 5개

실행순서
from절 --> where 절 --> select 절(C지정) --> order by --> limit
*/
-- 사원 중에서 급여를 가장 많이 TOP3가 출력되도록 
SELECT ename, sal
FROM emp
ORDER BY 2 DESC
LIMIT 0,3;-- 상위 top3

SELECT ename, sal
FROM emp
ORDER BY 2 DESC
LIMIT 12,2;

-- offset절 큰 경우 성능에 지대한 영향을 미친다. 
-- 두 쿼리 모두 10건 밖에 반환하지만 offset의 크기에 따라서 실행시간은 10배 이상차이가 발생한다.
SELECT * FROM aaa ORDER BY salary LIMIT 0,10; -- (0.00sec)

SELECT * FROM aaa ORDER BY salary LIMIT 2000000,10; -- (1.57sec)
-- 위 쿼리의 대비책은 where로 조건을 달아 준다.
SELECT * FROM aaa
WHERE salary <2300000 AND salary> 1990000
ORDER BY salary LIMIT 10; -- (1.57sec)

-- Full Scan으로 동작한다. !!!.. 나중에 index 설명
-- offset을 작게 가져가자.
SELECT * FROM emp LIMIT 0,10;

-- PK는 Unique하기 때문에 full scan을 하지 않는다. indexing가능
SELECT * FROM emp;
SELECT * FROM emp WHERE empno=7902;-- full scan x
SELECT * FROM emp WHERE ename='ford';-- full scan o - why? 중복 가능성 o 

/*
비교연산자 =, !=, >, <, >=, <=

LIKE 연산자
특정 단어가 포함되어져 있느 데이타를 검색할 때 많이 사용된다.
:
LIKE 연산자 2개의 와일드카드( % , _ )와 함께 사용
*/
-- 1. sal가 2500에서 3500 사이에 들어있는 sal를 받는 사원을 검색
SELECT ename, sal
FROM emp
where sal>=2500 AND sal<=3500;

-- 2. 
SELECT ename, sal
FROM emp
WHERE sal BETWEEN 2500 AND 3500; -- A이상 B이하

-- 3. 
SELECT ename, sal
FROM emp
WHERE sal BETWEEN 3500 AND 2500; -- no records ( 작은값 -> 큰값) 

-- 사원중에서 s로 시작하는 이름을 가진 사원을 검색
SELECT ename FROM emp WHERE ename LIKE 's%'; -- %가 가지는 의미 아무것도 없어도 되고 없어도 됨.

-- 사원중에서 s를 포함하는 이름을 가진 사원을 검색
SELECT ename FROM emp WHERE ename LIKE '%s%'; -- 

-- 이름의 2번째 문자에 A가 포함된 사원을 검색
SELECT ename FROM emp WHERE ename LIKE '_A%'; 

-- 81년도에 입사한 사원을 검색 이름과 입사일이 함께 검색되도록 한다.
SELECT ename, hiredate FROM emp WHERE HIREDATE LIKE '__81%';
SELECT ename, hiredate FROM emp WHERE HIREDATE LIKE '%81%';












