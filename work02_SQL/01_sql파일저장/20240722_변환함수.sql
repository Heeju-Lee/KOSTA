/*
변환함수
1) CAST
2) CONVERT(값, 변환할 데이타 타입)
	CONVERT(값, DATE) -> 날짜로 변환
    CONVERT(값, SIGNED) -> 숫자로 변환
    CONVERT(값, CHAR) -> 문자로 변환
이 둘은 형식만 조금 다를뿐 거의 동일한 기능
둘 중에 하나만 사용할 수 있으면 된다.


CONVERT를 사용하면
str_to_date 같은 기능을 변도로 사용할 필요가 없다.
*/

-- 살아온 일생, 날짜- 날짜 (CURDATE()-'2024-07-21')에러...날짜에서 문자가 안빠지기 때문에 변환함수 사용해본다.
-- STR_TO_DATE() 함수를 사용했지만 CONVERT()를 사용하면 편하다.

SELECT curdate()-'2024-07-21' 어제;
SELECT (curdate()-str_to_date('2024-07-21','%Y-%m-%d')) 어제;
SELECT (curdate()-convert('2024-07-21',date)) 어제;

-- emp 테이블에서 사원이름과 상사번호를 검색
SELECT ename, mgr FROM emp;

-- mgr이 null이면 '없음'이 출력되도록 한다.
SELECT ename, ifnull(mgr,'없음') from emp;
SELECT ename, ifnull(convert(mgr,char),'없음') 상사번호 from emp; -- 오라클에서는 같은 형식끼리 치환을 해야하기 때문에 변환을 해줘야한다.

/*
일반함수
CASE
	WHEN 조건1	THEN '반환값1'
    WHEN 조건2	THEN '반환값2'
	ELSE '위 WHEN 조건에 해당 안되는 모든 경우의 반환값'
    

END
- WHEN과 THEN은 반드시 한 쌍이다.
- WHEN과 THEN은 여러개 나올 수 있다.
- ELSE문에는 위 조건에 들어맞지 않는 모든 경우가 이 곳으로 반환된다.
- ELSE가 만약에 존재하지 않고, 위 WHEN 조건에 부합하는 경우가 아닐 때는 NULL이 반환된다.

*/

-- 이름, 업무, 급여, 커미션을 검색
-- MANAGER 라면 커미션이 SAL*150%, 그 외 직원이라면 SAL*130%입니다.
SELECT ename 이름, job 업무, sal 급여, comm 커미션,
	case job 
    when 'MANAGER' THEN sal*1.5
    else sal*1.3   
    end 보너스
from emp;

-- 이름, 업무, 상사번호를 검색
-- 만약에 상사번호가 null이라면, 최고위 상사 / null이 아니라면 일반직원 출력
SELECT ename 이름, job 업무, mgr 상사번호,
	case 
		when mgr is null THEN '최고위 상사'
		ELSE '일반직원'
		END 직급
FROM emp;














