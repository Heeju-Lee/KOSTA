-- ##################  ���� �ð� ���� ######################
/*
1) �޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���. 
   �̸� �̸�, �޿�, ȸ��(�Ҽ��� �� �ڸ� �Ʒ����� �ݿø�)�� ����϶�.
   -->
   �� ������ �ش��ϴ� SQL���� 
   select ename, sal, round(sal*0.15, 2) ȸ��
   from emp
   where sal between 1500 and 3000;
   �̴�. �ش� SQL ���� MySQL���� �����ϴ� if���� �̿��ؼ� �ٽ� �����غ���.
*/

SELECT ename,sal,if(1500<=sal and sal<=3000,round(sal*0.15,1),0) ȸ��
from emp
order by 3 desc;

-- 2) �޿��� $2,000 �̻��� ��� ����� �޿��� 5%�� ������� ����� �Ͽ���. 
-- �̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�. (if���� �̿��ؼ� sql���� �ۼ��Ѵ�)

select ename, sal, FLOOR(sal*0.05) �������
from emp
where sal>=2000;

select ename,sal,if(sal>=2000,floor(sal*0.05),0) �������
from emp
ORDER BY 3 DESC;

 -- 3) ������ ����ϱ� ���� comm�� 150%�� ���ʽ��� �����Ϸ� �Ѵ�. comm�� �ִ� �������� ������� 
 -- ������ȣ, ������, �޿�, comm�� 150%�� �Ҽ������� �ø��Ͽ� ����϶�. (comm�� 0�̰ų�, null�̸� ����)

select empno,ename,sal,if(ifnull(comm,0)>0,ceil(comm*1.5),0) bonus
from emp;

select empno,ename,sal,ceil((comm * 1.5) * 100)/100 ���ʽ� bonus
from emp
where comm is not null and comm !=0;


-- ##################  ��¥ �Լ� �ǽ� ######################

-- 1)�Ի��Ϸκ��� 100���� ���� �ĸ� ���غ���. 
-- �̸�, �Ի���, �Ի��Ϸκ��� 100�� ��, �޿並 ����Ѵ�.
-- ��Ī�� ����̸�, �Ի���, 100�� ���� ��, ����޿��� �Ѵ�.
select ename ����̸�,hiredate �Ի���,date_add(hiredate,interval 100 DAY) "100�� ���� ��",sal ����޿�
from emp;


-- 2) �Ի��Ϸκ��� 6������ ���� ���� ��¥�� ���Ϸ��� �Ѵ�.  �Ի���, 6���� ���� ��¥, �޿��� ����϶�
SELECT hiredate �Ի���, DATE_ADD(hiredate, INTERVAL 6 MONTH) "6���� ���� ��¥", sal �޿� from emp;


-- 3) �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ, �̸�, �ٹ��ϼ��� ����϶�.
select deptno, ename, last_day(hiredate)-hiredate �ٹ��ϼ� from emp;

-- 4) ��� ����� �Ի��� �������� 100���� ���� ���� �������� ��¥�� ���ؼ� �̸�, �Ի���,��MONDAY���� ����϶�.
SELECT ename �̸�, 
hiredate �Ի���, 
ADDDATE(
	ADDDATE(hiredate, interval 100 DAY),
    INTERVAL (7-weekday(ADDDATE(hiredate, interval 100 DAY)))%7 DAY) AS MONDAY
FROM EMP; 


SELECT ename �̸�, hiredate �Ի���, adddate(hiredate, INTERVAL 100 DAY) '100�� �� ��¥', 
dayofweek(adddate(hiredate, INTERVAL 100 DAY)) '100�� �� ����', 
DATE_ADD(adddate(hiredate, INTERVAL 100 DAY), INTERVAL (7 - WEEKDAY(adddate(hiredate, INTERVAL 100 DAY))) DAY) '����� �������� ��¥'
FROM emp;


-- 5) �Ի��Ϸκ��� ���ñ����� �ϼ��� ���Ͽ� �̸�, �Ի���, �ٹ��ϼ��� ����϶�.

SELECT ename, hiredate, DATEDIFF(CURDATE(), hiredate) + 1 AS '�ٹ��ϼ�'
FROM emp;

-- 6) ������ �̸�, �ټӳ���� ���Ͽ� ����϶�.

SELECT ename, TRUNCATE(DATEDIFF(CURDATE(), hiredate)/365, 0)+1 AS '�ټӳ��'
FROM emp;

SELECT ename �̸�, (year(curdate())-year(hiredate))+1 �ټӳ��
FROM emp; -- ������� �ٸ���� ����