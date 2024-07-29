/*
뷰 VIEW
사용자에게 접근이 허용된 자료만을 제한적으로 보여주기 위해서 하나 이상의 기본 테이블로부터
유도된 이름을 가지는 가상의 테이블
읽기전용

실질적으로 데이타베이스 내에 물리적인 저장장치를 가지고 있지 않는다.


뷰는 기본적으로 읽기전용이다.
하지만
데이타를 삭제, 수정할 수는 있다.
*/

-- 뷰생성
CREATE VIEW empView
AS
SELECT empno, name, job FROM emp;

-- 뷰확인
SELECT * FROM empView;

-- 뷰 삭제
DELETE FROM empView WHERE empno=7369;
