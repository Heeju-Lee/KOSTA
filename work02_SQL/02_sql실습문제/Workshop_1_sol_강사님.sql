-- 1) emp ���̺� ������ Ȯ���ϼ���.
desc emp;

-- 2) �μ���ȣ�� 20���� �μ��� ��� �� �����ȣ, �̸�, ������ ����϶�
select empno, ename, sal
from emp
where  deptno=20;


-- 3) �����ȣ�� 7521�� ��� �� �̸�, �Ի���, �μ���ȣ�� ����϶�.

select empno, ename, hiredate, deptno
from emp
where empno=7521;

-- 4) �̸��� JONES�� ����� ��� ������ ����϶�.
select *
from emp
where ename='JONES';

-- 5) ������ MANAGER�� ����� ��� ������ ����϶�.
select *
from emp
where job='MANAGER';

-- 6)������ MANAGER�� �ƴ� ����� ��� ������ ����϶�.
select *
from emp
where job !='MANAGER';

-- 7) �޿��� $1000 �̻��� ����� �̸�, �޿�, �μ���ȣ�� ����϶�.
select ename, sal, deptno
from emp
where sal>=1000;

-- 8) �޿��� $1,600���� ũ�� $3,000���� ���� ����� �̸�, ����, �޿��� ����϶�.
select ename, job, sal
from emp
where sal>=1600 and sal<=3000;

select ename, job, sal
from emp
where sal between 1600 and 3000;

-- 9) �Ի����� 80�⵵�� ����� ��� ������ ����϶�

select *
from emp
where hiredate like '80%';

-- 10) �Ի����� 81/12/09 ���� ���� �Ի��� ������� ��� ������ ����϶�.
select *
from emp
where hiredate < '81/12/09';


-- 11) �̸��� S�� �����ϴ� ����� �����ȣ, �̸�, �Ի���, �޿��� ����϶�.

select  empno, ename, hiredate, sal
from emp
where ename like 'S%';


-- 12) �̸� �� S�ڰ� �� �ִ� ����� ��� ������ ����϶�.
select  empno, ename, hiredate, sal
from emp
where ename like '%S%';


-- 13) Ŀ�̼��� NULL�� ����� ������ ����϶�.
Select *
from emp
where comm is null;


-- 14) Ŀ�̼��� NULL�� �ƴ� ����� ��� ������ ����϶�.

Select *
from emp
where comm is not null;

--15) �μ��� 30�� �μ��̰� �޿��� $1,500 �̻��� ����� �̸�, �μ� ,������ ����϶�.

select ename, deptno, sal
from emp
where deptno=30 and sal>=1500;

-- 16) �μ���ȣ�� 30�� ��� �� �����ȣ SORT�϶�.

select *
from emp
where deptno=30
order by empno;

-- 17) �޿��� ���� ������ SORT�϶�.
select * from emp  order by sal desc;

-- 18) �μ���ȣ�� ASCENDING SORT�� �� �޿��� ���� ��� ������  ����϶�.
select * from emp order by deptno, sal desc;

-- 19) emp Table���� �̸�, �޿�, Ŀ�̼� �ݾ�, �Ѿ�(sal + comm)��  ���Ͽ� �Ѿ��� ���� ������ ����϶�. 
-- ��, Ŀ�̼��� NULL�� ����� �����Ѵ�.(Ŀ�̼Ǳݾ�: sal*comm/100)
select  ename, sal, sal*comm/100 Ŀ�̼Ǳݾ� , sal+comm as �Ѿ�
from emp
where comm is not null
order by �Ѿ� desc;

-- 20)  10�� �μ��� ��� ����鿡�� �޿��� 13%�� ���ʽ��� �����ϱ�� �Ͽ���. �̸�, �޿�, ���ʽ� �ݾ�, �μ���ȣ�� ����϶�.
select ename, sal, sal*0.13 ���ʽ�, deptno
from emp
where  deptno=10;

