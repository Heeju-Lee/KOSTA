-- ### SubQuery ###
-- 1.  ��SMITH'�� ������ ���� ����� �̸�, �μ���, �޿�, ������  ����϶�.

select e.ename, d.dname, e.sal, e.job
from emp e join dept d on  d.deptno= e.deptno
where e.job = (select job from emp where ename='SMITH');


-- 2.  ��JONES���� �����ִ� �μ��� ��� ����� �����ȣ, �̸�, �Ի���, �޿��� ����϶�.
select empno, ename, hiredate, sal
from emp
where deptno =( select deptno from emp where ename='JONES');

-- 3.  ��ü ����� ��ձ޿����� �޿��� ���� ����� �����ȣ, �̸�,�μ���ȣ, �Ի���,�޿��� ����϶�.
select empno, ename, DEPTNO, hiredate,  sal
from emp
where sal >=(select avg(sal) from emp);


-- 4. 10�� �μ��� ���� ��(����)�� �ϴ� ����� �����ȣ, �̸�, �޿��� �˻�..�޿��� ���� ������ ����϶�.
select empno, ename, sal
from emp 
where job in  ( select job from emp where deptno=10)
order by sal desc;

-- ===========================================
select e.empno, e.ename, d.dname, d.loc, sal
from emp e join dept d on e.deptno=d.deptno
where e.job  in (select job from emp where deptno=10)
Order by sal  desc;


-- 5.  10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���ȣ,����, �Ի����� ����϶�.
select empno, ename, hiredate, job
from emp 
where  (deptno=10 and job not in (select job from emp  where deptno=30));


-- ===========================================================
select e.empno, e.ename, d.dname, hiredate, d.loc
from emp e join dept d on e.deptno=d.deptno
where e.deptno=10
and e.job not in (select job from emp where deptno=30);

-- 6.  SCOTT�̳� ADAMS'�� �޿��� ���� ����� �����ȣ, �̸�,�޿��� ����϶�.
select empno, ename, sal
from emp
where sal in (select sal from emp where ename in ('SCOTT','ADAMS'));


-- 7.  �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.
select empno, ename, sal
from emp
where sal >( select max(sal) from emp where deptno=30);


-- 8. SCOTT�� �޿����� ������ �޿��� �޴� ����� �˻�
-- 2���� ����� ��� 1) ��������  2) ���̺� �˸��߽��� ���
-- 1) 
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');
-- 2) 
SELECT * FROM emp a, (SELECT sal FROM emp WHERE ename='SCOTT') b
WHERE a.sal > b.sal;

-- 9. �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּұ޿����� �� ū �ּұ޿��� �˻�
SELECT deptno, min(sal) FROM emp 
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno=20);

-- 10. �޿��� 10���μ��� ���� � ����� �޿����� �� ���� �޿��� �޴� ����� �˻�. 
-- �̶� 10�� �μ��� ���� ����� ���� 
-- ������ �����ȣ������ �Ѵ�. 
SELECT sal FROM emp WHERE deptno=10; # 10�� �μ��� ���� � ����� �޿� (2450, 5000, 1300)
SELECT * FROM emp 
WHERE sal > ANY (SELECT sal FROM emp WHERE deptno=10) AND deptno <> 10 
ORDER BY empno;

-- 11. 30�� �Ҽ� ����� �߿��� �޿��� ���� ���� �޴� ������� �� ���� �޿��� �޴� ����� �̸��� �޿��� �˻� 
-- 2���� ��� ���
-- 1)
SELECT max(sal) FROM emp WHERE deptno = 30; -- (2850) 30�� �Ҽ� ����� �� ���� ���� �޴� ����� �޿�

-- 2) ���� ����� ������ �ٽ� ���÷��� �ؾ��Ѵ�. having���� �ʿ�
SELECT deptno, max(sal) FROM emp GROUP BY deptno; -- 5000 | 3000 | 2850

SELECT deptno, max(sal) FROM emp 
GROUP BY deptno 
HAVING deptno=30;

SELECT ename, sal FROM emp 
WHERE sal > (SELECT max(sal) FROM emp 
GROUP BY deptno 
HAVING deptno=30);

SELECT ename, sal FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE deptno = 30);

-- 12. ���������� �Ŵ��� ����� �˻� . ����̸��� ����� �����ȣ�� �˻��ǵ���(�˸��߽� ����̸�, �������ȣ)
-- 1)
SELECT distinct mgr FROM emp;
SELECT * FROM emp WHERE empno IN (SELECT distinct mgr FROM emp);

-- 2)
SELECT e.ename ����̸�, e.empno ����ǻ����ȣ FROM emp e 
WHERE e.empno IN (SELECT m.mgr FROM emp m);


