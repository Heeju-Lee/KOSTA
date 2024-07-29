-- 1. emp 테이블에서 ename 'R'로 끝나는 사원을 검색 
  SELECT ename From emp WHERE ename like '%R';
  
-- 2. emp 테이블에서 ename 에서 두번째 글자가 'L' 인 사원을 검색
    SELECT ename From emp WHERE ename like '_L%';
   
-- 3. emp 테이블과 dept 테이블을 조인해서 ename,job,dname,loc 출력
	SELECT e.ename 이름, e.job 업무, d.dname, d.loc
    FROM emp e
    JOIN dept d
    USING (deptno);  
    

-- 4. emp 테이블에서 입사일이  1981 인 사람중에 mgr 이 7698 인사람을 검색
SELECT e.ename '상사번호가 7698 인사람'
FROM emp e, emp m
WHERE e.deptno = m.deptno
AND e.ename in (SELECT ename FROM emp WHERE year(hiredate)=1981)
AND m.empno in (SELECT mgr FROM emp WHERE mgr = 7698);

-- 5. emp 테이블에서 empno 사원번호가 7566, 7698, 7782 인 사원의 업무를 'MARKETING' 으로 변경하시오
  UPDATE emp SET job='MARKETING' WHERE empno=7566;
  UPDATE emp SET job='MARKETING' WHERE empno=7698;
  UPDATE emp SET job='MARKETING' WHERE empno=7782;
  
-- 6. emp 테이블에서 업무(job) 별로 각각의 인원수를 구하라
  SELECT job, count(empno)
  FROM emp
  GROUP BY job;
  
-- 7. emp 테이블에서 부서(deptno)별로 급여(sal) 의 평균을 구하시오
--   (평균은 소숫점이하 한자릿수로)
  SELECT deptno, round(avg(sal),1)
  FROM emp
  GROUP BY deptno;

-- 8. emp 테이블에서 ename 이 'TURNER' 인 사람의 sal 을 1900 으로 comm 을 400으로 수정하시오
UPDATE emp SET sal=1900 WHERE ename = 'TURNER';
UPDATE emp SET comm=400 WHERE ename = 'TURNER';

-- 9. emp 테이블에서 입사년도가 81년도인 사원중 급여가 1400 미만인 사원의 인원수를 검색 
SELECT count(empno)
FROM emp
WHERE empno in(SELECT empno FROM emp WHERE year(hiredate)=1981)
AND sal<1400; 

-- 10. 9번에서 조회된 사원들을 삭제합니다.
DELETE FROM emp 
WHERE YEAR(hiredate)=1981
AND sal<1400;


-- 11. emp 테이블에서 업무가 clerk(점원) 인 사원의 급여를 전체적으로 15% 인상합니다. 
 SELECT ename, sal*1.15 'raiseSal'
 FROM emp
 WHERE empno in(SELECT empno FROM emp WHERE job='clerk');

-- 12.  emp 테이블에서 comm이 null 이 아닌 모든 사원을 삭제합니다.
--     단 comm이 0인 사원은 제외합니다.

DELETE FROM emp WHERE comm is not null;


--  ----------------- 구글 검색으로 나머지 쿼리를 완성합니다. ---------------

-- 13. emp 테이블에서 ename--> name, sal--> salary로 컬럼명을 변경합니다.
ALTER TABLE emp
CHANGE COLUMN ename name
VARCHAR(10);

ALTER TABLE emp
CHANGE COLUMN sal salary
double;

-- 14. emp 테이블에서  job의 데이타 타입을 varchar(30)으로 수정합니다.

ALTER TABLE emp
MODIFY job VARCHAR(30);




