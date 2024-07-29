-- 2024.07.22 날짜함수
SELECT * FROM emp;
/*
DATE_FORMAT(hiredate, '%Y-%m-%d') 날짜의 형식을 포맷하는 기능
DAYOFWEEK(date) - 주어진 date의 일자가 해당 주에서 몇 번째 날인지 반환(일요일=1, 토요일=7)
YEAR(date) - 년도 반환
MONTH(date) - 월 반환
DAY(date) - 일 반환
LAST_DAY(date) - 주어진 date에서 해당 월의 마지막 날짜 정보 반환.

NOW(), CURRENT_TIMESTAMP() - 년 월 일 시 분 초
CURDATE() - 년 월 일
CURTIME() - 시 분 초

@@@ 중요 @@@
ADDDATE(date, INTERVAL value addunit) - date에 value addunit 만큼 시간/날짜를 추가한 date를 반환(INTERVAL value addunit 대신 days도 가능)
DATEDIFF(date1, date2) - 두 날짜 사이의 일수를 숫자로 반환(date1 - date2)
*/

/*
* Oracle 
	날짜 + 숫자 = 날짜
    날짜 - 숫자 = 날짜
    날짜 - 날짜 = 숫자(기간)
*/

SELECT curdate()-1 어제;
SELECT curdate()+1 내일;
SELECT curdate()+100 백일;-- 틀렸음.

-- 오늘로부터 100일 이후의 날짜
SELECT adddate(curdate(),interval 100 DAY) '100일 기념일';
SELECT adddate(curdate(),interval 1 YEAR) '1년 뒤';
SELECT adddate(curdate(),interval 1 WEEK) '1주일 뒤';

SELECT adddate(now(),interval 1 HOUR) '1시간 후'; -- now를 사용해야함.
SELECT adddate(current_timestamp(),interval 1 HOUR) '1시간 후'; -- current_timestamp 사용해야함.

-- 날짜에서 날짜를 빼는 경우
-- 1
-- 오늘 날짜에서 어제 날짜를 빼면 1이 나와야 한다.
SELECT (curdate()-'2024-07-21') DIFFERENCE; -- 문자를 날짜로 변환

-- 2. str_to_date() 변환함수를 사용
SELECT (curdate()-str_to_date('2024-07-21','%Y-%m-%d')) DIFFERENCE;

-- 3. datediff 함수 사용 (변환이 필요 없음)
SELECT datediff(curdate(),'2024-07-21') DIFFERENCE;

-- 여러분들이 태어난 날로부터 오늘까지 살아온 일생의 기간을 몇일일까요?
SELECT datediff(curdate(),'1996-11-26') '오늘-태어난날';

-- emp 테이블에서 MANAGER 업무 관련 직원에 대해서 입사한 날로부터 오늘까지의 근무일수를 출력/알리야스...
SELECT ENAME, JOB, HIREDATE, datediff(curdate(),hiredate) AS 근무일수
FROM EMP
WHERE JOB='MANAGER';

SELECT ENAME, JOB, HIREDATE, ABS(datediff(hiredate,curdate())) AS 근무일수
FROM EMP
WHERE JOB='MANAGER'; -- ABS(DATEDIFF()) 메소드 중첩

-- emp 테이블에서 MANAGER 업무 관련 직원에 대해서 입사한 날로부터 오늘까지의 근무주수를 출력/알리야스...
SELECT ENAME, JOB, HIREDATE, ceiling(datediff(curdate(),hiredate)/7) AS 근무주수
FROM EMP
WHERE JOB='MANAGER';

-- emp 테이블에서 사원들이 입사한 월만 검색, 알리야스, projection은 알아서
-- 날짜함수
SELECT ename, hiredate, month(hiredate) as Month FROM emp;
-- 내 쿼리문
SELECT ename, hiredate, month(hiredate) as Month From emp
where substr(hiredate,6,2)=5;

-- 강사님 쿼리문
SELECT ename, hiredate, substr(hiredate,6,2) as Month From emp
where Month(HIREDATE)=5;





