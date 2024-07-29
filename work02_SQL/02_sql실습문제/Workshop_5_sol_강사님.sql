-- ### SubQuery ���� ###
-- 1.  ��SMITH'�� ������ ���� ����� �̸�, �μ���, �޿�, ������  ����϶�.

select e.ename, d.dname, e.sal, e.job
from emp e join dept d on  d.deptno= e.deptno
where e.job = (select job from emp where ename='SMITH');




-- 2. 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, �̸�, �μ���,����, �޿��� �޿��� ���� ������ ����϶�.

select e.empno, e.ename, d.dname, d.loc, e.sal
from emp e, dept d
where e.deptno = d.deptno and job in  ( select job from emp where deptno=10)
order by sal desc;

-- ===========================================
select e.empno, e.ename, d.dname, d.loc, sal
from emp e join dept d on e.deptno=d.deptno
where e.job  in (select job from emp where deptno=10)
Order by sal  desc;


-- ### equi join ###

-- 1.  emp�� dept Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿���  ����϶�.

select  dept.deptno, dname, ename, sal
from emp , dept 
where emp.deptno = dept.deptno 
order by dept.deptno;

-- =====================================
select d.deptno, d.dname, e.ename, e.sal 
from emp e  join dept d on e.deptno=d.deptno
order by d.deptno;
-- =====================================
select deptno, d.dname, e.ename, e.sal 
from emp e  join dept d using (deptno);

-- 2.  �̸��� ��SMITH���� ����� �μ����� ����϶�.

select  dname
from emp, dept
where emp.deptno  = dept.deptno  and emp.ename='SMITH';
-- ========================================
select d.dname, e.ename
from emp e  join  dept d using (deptno)
where  e.ename='SMITH';

select d.dname, e.ename
from emp e  join  dept d on e.deptno=d.deptno
where  e.ename='SMITH';

 
-- ### outer join ###
-- 1.  dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ� 
-- ��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.
SELECT e.ename �̸�, d.deptno �μ���ȣ, d.dname �μ���, e.sal �޿� 
FROM emp e RIGHT OUTER JOIN dept d 
ON e.deptno = d.deptno;



-- ###self join###
-- 2.  emp Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�. ��SMTH�� �Ŵ����� FORD�̴١�
-- 1)
SELECT concat(e.ename, '�� �Ŵ����� ', m.ename, '�̴�.') Info 
FROM (SELECT ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m 
WHERE e.mgr = m.empno;

-- 2)

SELECT concat(e.ename, '�� �Ŵ����� ', m.ename, '�̴�') Info
FROM emp e, emp m
WHERE e.mgr = m.empno;



-- ### join �ǽ� ###

-- 1. �����ڰ� 7698�� ����� �̸�, �����ȣ, �����ڹ�ȣ, �����ڸ��� ����϶�.

select  e.ename, e.empno, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno and m.empno = 7698;

select  e.ename, e.empno, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno and e.mgr = 7698;
-- ========================================
select e1.ename ename, e1.empno empno, e1.mgr, e2.ename
from  emp e1 JOIN  emp e2 ON  e1.mgr= e2.empno
WHERE e1.mgr='7698';

-- 2. ������ MANAGER�̰ų� CLERK�� ����� �����ȣ, �̸�, �޿�, ����, �μ���
select empno, ename, job, dname
from emp, dept
where emp.deptno =  dept.deptno and (  job='MANAGER' or job='CLERK');

select empno, ename, job, dname
from emp, dept
where emp.deptno =  dept.deptno and  job in ('MANAGER' ,'CLERK');

-- ========================================
  select empno, ename, job, deptno, dname
  FROM   emp   JOIN dept   USING (deptno)
  WHERE  job ='MANAGER' or job='CLERK'  ;

-- ### set ������ ### --
-- dept�� ����� ���̺�(dept���̺��� 10, 20�μ������͸� �Է�)�� �ϳ� �����Ѵ�.
create table newdept 
as 
select * from dept where deptno in (10, 20);
-- �߰� �����͸� �Է��Ѵ�.
insert into newdept values(50, 'MARKETING', 'SEOUL');
select * from newdept;
select * from dept;

-- 2. dept���̺�� newdept ���̺��� ��� ���� ����϶�.(��, �ߺ��Ǵ� ���� �ѹ��� ����Ѵ�)
select * from dept
union
select * from newdept;


-- 3. dept���̺�� newdept ���̺��� ��� ���� ����϶�.
select * from dept
union all
select * from newdept;







