-- ###############  ���� �ð� ���� �ǽ�    ###############

-- 1) �޿��� $1500 ~ $2000 �� �ƴ� ����� ename �� SAL�� �˻�
--  ���� ��Ī�� NAME, SALARY�� �մϴ�.
SELECT ename NAME, sal SALARY
FROM emp
WHERE NOT sal BETWEEN 1500 AND 2000;

-- 2)  30�� �μ��� ������ ����Ͽ� �̸�, �μ���ȣ, �޿�, ������ ����϶�. ��, ������ �޿��� 150%�� ���ʽ��� �����Ѵ�.
SELECT ename, deptno, sal, (sal*12 + ifnull(comm,0))*1.5 AnnualSalary
FROM emp
WHERE deptno=30;


-- 3) �������� �Ի����� �������� 81�⵵�� �Ի��� ����߿��� ���� �ֱٿ� �Ի��� ��� 2���� �߸��� �ش� ����� ������ ����Ѵ�. �̶� ��������� 3������ �ϰ� ���� �÷��� ���� ��Ī�� �ο��Ѵ�.
SELECT ename �̸�, sal �޿�, hiredate �Ի���
FROM emp
WHERE hiredate LIKE '%81%'
ORDER BY hiredate DESC LIMIT 2;


-- ##############  ���ڿ� �Լ� �ǽ�   #################
-- 1) ������ �̸��� ��ҹ��� ������� s�� �� ������ ��� ������ ����϶�.
select * from emp where lower(ename) like '%s%';


-- 2) ���� ���� �� �����ȣ, �̸�, �޿��� ����Ѵ�.  ��, �̸��� �տ��� 3���ھ��� ����϶�.
select empno, substr(ename,1,3), sal  from emp;

-- 3) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.
select ename,  lower(substr(ename, 1,3)) 
from emp
where  length(ename) >=6;


-- 4) ������ �̸��� �޿��� ����϶�, ��, �ݾ��� ��Ȯ���� ���� �޿��� 6�ڸ��� ����ϰ�, �� ������ ��� * �� ä�� ����϶�.
select  ename, lpad(sal, 6,'*')
from emp;


-- 5) ���������� �Է��ϴ��� �Ʒ��� ���� �Է� �Ǿ���.
insert into emp values(7777,'   JAMES   ', 'SLALESMAN' ,  7566 , '1981-1-1', 3100,700,10);
select * from emp;

-- �̸��� 'JAMES'�� ������ ������ ����Ͽ� ����.
  select * from emp  where  ename='JAMES';

-- �̸� �¿쿡 ������ �ִ��� ������ �����ϰ� �̸��� 'JAMES'�� ������ ������ ����Ͽ� ����.
 select * from emp  where  trim(ename)='JAMES';
