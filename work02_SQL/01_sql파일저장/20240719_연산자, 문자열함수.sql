/*
2024. 07.19
2. 단일행 함수

[연산자]
- LIKE 연산자(와일드카드 %, _)
	:특정 패턴에 속하는 값을 조회할 때 사용하는 연산자
	% : 0개 혹은 1개 이상의 문자와 대응 
	_ : 반드시 한개의 문자와 대응

- 비교연산자 (=, !=(<>), >, <)



- 논리연산자 (AND, OR, NOT) 
	> 우선순위가 존재한다. (NOT >>>>AND>>>OR)
	> (   )는 모든 우선순위 규칙보다 우선된다.

- IN 연산자
	여러값 중에서 어느 하나와 일치하는지를 비교하는 연산자

*/

-- 사원번호가 7369이거나 7521이거나 7782번인 사원을 검색
-- 1 : 아주 최악의 조건 
SELECT * FROM emp WHERE EMPNO =7369; -- SMITH
SELECT * FROM emp WHERE EMPNO =7521; -- WARD
SELECT * FROM emp WHERE EMPNO =7782; -- CLARK

-- 2 : 논리 연산자 OR 사용
SELECT * FROM emp WHERE EMPNO =7369 OR EMPNO =7521 OR EMPNO =7782;

-- 3 : IN연산자 사용 
SELECT * FROM emp WHERE empno IN(7369, 7521, 7782);
SELECT * FROM emp WHERE empno IN(7369, 7521, null); 

-- 사원번호가 7369가 아니고 7521도 아니고 7782도 아닌 사람을 검색(AND)
-- 1
SELECT * FROM emp WHERE empno<>7369 AND empno<>7521 AND empno<>7782;

-- 2
SELECT * FROM emp WHERE empno NOT IN(7369, 7521, 7782);
SELECT * FROM emp WHERE mgr NOT IN(7369, 7521, null);
SELECT * FROM emp WHERE mgr NOT IN(7369, 7521, 0);
SELECT DISTINCT mgr FROM emp; -- mgr에는 7369, 7521 사번이 없다. no record.

SELECT * FROM emp;

-- 부하직원을 거느리고 있는 사원을 검색(empno에 해당하는 사람이 mgr 번호에 있는 사람이다.)
SELECT empno, ename, mgr FROM emp
WHERE empno IN(SELECT DISTINCT mgr FROM emp); -- No record

-- 부하직원을 거느리지 않는 사원을 검색(empno에 해당하는 사람이 mgr 번호에 없는 사람이다.)
SELECT empno, ename, mgr FROM emp
WHERE empno NOT IN(SELECT DISTINCT mgr FROM emp);-- no record
SELECT empno, ename, mgr FROM emp
WHERE empno NOT IN(SELECT DISTINCT ifnull(mgr,0) FROM emp);

-- 논리연산자 우선순위 관련한 문제
-- 사원들 중에서 업무가 영업사원이거나 혹은 사장인 경우에 의 사원 중에서 급여가 1500달러 이상인 사원 정보 출력
-- 사원이름, 업무, 급여가 출력되도록 한다.
SELECT ename, job, sal FROM emp
WHERE job In('salesman','president')
AND sal>=1500;

SELECT ename, job, sal FROM emp
WHERE (job = 'salesman'
OR job ='president')
AND sal>=1500;
-- ===========================================================
/*
[단일행 연산자]
문자함수 | 숫자함수 | 날짜함수 | 변환함수

>>>> 문자함수
CONCAT('문자열','문자열') 
:문자열 혹은 컬럼을 연결함.

UPPER(), LOWER()
: 대소문자 변환

SUBSTRING(문자열, 시작위치, 길이)
: 특정한 문자열을 추출함.

SUBSTR()

PAD/LPAD/RPAD 
: 문자열을 채우는 기능 

LENGTH 
: 문자열의 길이를 추출

LEFT/RIGHT/MID
: 문자열 중에서 왼쪽/오른쪽/시작위치에서 갯수만큼 추출 

LTRIM/ RTRIM / TRIM (((중요!)))
: 문자열 중에서 왼쪽/오른쪽/양쪽 공백 제거
*/

-- 1) 문자열
-- concat() : 문자열과 문자열을 연결
SELECT concat('Good', 'Morning') FROM dual;
SELECT concat('Good', 'Morning') 'MESSAGE' FROM dual;
SELECT concat('Good', 'Morning') 'MESSAGE';-- Dummy Table이 필요없다.(오라클 불가능)

-- concat() 문자열과 컬럼 연결
SELECT concat(ename, ' Good Morning') Message FROM emp;

-- Smith, CLERK, Smith is a CLERK(14행이 나오도록, 사원이름, 업무, 메세지)
SELECT ename '사원이름', job '업무', concat(ename,' is a ', job) '메세지' from emp;

-- SUBSTR() 문자 추출
SELECT substr('HelloWorld', 6);

SELECT substr('HelloWorld', 6, 3); -- Wor
SELECT substr('HelloWorld', -4, 2); -- or

-- 사원의 업무중에서 SALESMAN인 업무를 하는 사원중에서 사원이름이 R로 끝나는 사원의 정보를 출력하라
SELECT * FROM emp
WHERE job = 'salesman' AND substr(ename,-1)='R';

-- 업무에서 SALESMAN인 업무부서의 이름이 SALES로만 검색되도록 
SELECT empno, ename, substr(job,1,5) '축약형 job' FROM emp
WHERE job='salesman';

-- 입사일중에서 연도만 검색되도록 조회 별칭을 입사년도로 지정
SELECT empno, ename, substr(hiredate,1,4) 입사년도 FROM emp; -- 1981 
SELECT empno, ename, substr(hiredate,3,2) 입사년도 FROM emp; -- 81
SELECT empno, ename, substr(hiredate,-8,2) 입사년도 FROM emp; -- 81

-- 2.  1981 .....substr 말고 다른 기능.
SELECT empno, ename, left(hiredate, 4) 입사년도 FROM emp; -- 1981 

-- PAD 채운다.(LPAD, RPAD)
SELECT lpad('ABC',6,'*');-- ***ABC
SELECT rpad('ABC',6,'*');-- ABC***
SELECT rpad('ABC',6, ' '); -- 공백으로 채움..(채움문자를 지정하지 않으면 에러발생, 오라클은 공백으로 채워짐)

SELECT rpad(ename,10,' ') ename, lpad(deptno,8,' ') deptno FROM emp;

-- 사원중에서 이름이 N으로 끝나는 사원에 대한 이름과 JOB, 부서번호를 출력해라.(3가지)
SELECT ename, job, deptno
FROM emp
WHERE ename LIKE '%N';

SELECT ename, job, deptno
FROM emp
WHERE substr(ename,-1)='N';

SELECT ename, job, deptno
FROM emp
WHERE right(ename,1)='N';

SELECT ename, job, deptno
FROM emp
WHERE instr(ename, 'n') = length(ename);-- instr = index string

-- 공백을 제거하는 함수 trim()
SELECT rtrim('James Cosling is Gooooooood                  ') message;
SELECT ltrim('               James Cosling is Gooooooood                  ')message;

-- 가운데 공백은 어떻게 제거할까?
SELECT trim('               James Cosling is Gooooooood                  ')message;

/*
REPLACE(문자열, 기존문자열, 대체문자열)
*/
SELECT REPLACE('James Cosling        is Gooooooood','    ','') message;







