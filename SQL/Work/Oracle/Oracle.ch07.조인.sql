
-- ########################
-- ������ 2�� �̻��� ���̺��� ������ ��
-- 
-- 
-- ########################

 
 -- emp ���̺� p ��� ��Ī �ο��Ͻÿ�.
 select * from emp p;
 
 -- emp ���̺� p ��� ��Ī �ο��ϰ� ename�� �̸�����, job �� �������� ����Ͻÿ�.
select ename �̸�, job ���� from emp p;
-- emp ���̺��� �̸�(enam)�� '�̹���'�� ����� ����Ͻÿ�.
select * from emp where ename='�̹���';
-- dept ���̺��� deptno �� 10 �� �μ��� ����Ͻÿ�.
select * from dept where deptno =10;
-- ���������� �̿��ؼ� '�̹���'�� �����Ϳ� �μ����� �Բ� ����Ͻÿ�.
select emp.*
      , (select dname from dept where deptno=emp.deptno) �μ���
from emp where ename='�̹���';

select emp.*, dept.dname from emp join dept on emp.DEPTNO=dept.DEPTNO where emp.ename='�̹���' ;


-- ���������� �̿��ؼ� '�̹���'�� ������ �μ��� �׸��� ��ġ�� ����Ͻÿ�.
select emp.*
      ,(select dname from dept where deptno=emp.deptno) �μ���
      ,(select loc from dept where deptno=emp.deptno) ��ġ
      from emp where ename = '�̹���';
-- ���������� �̿��ؼ� ���� �÷��� ǥ���� �� ���� �߻���.
-- �̷� ��쿡�� ������ �̿��Ͽ� ���� �ذ��� �����Ѵ�.


-- ������ �̿��ؼ� '�̹���'�� ������ �μ��� �׸��� ��ġ�� ����Ͻÿ�.
select p.*, d.dname, d.loc
      from emp p join dept d
      on p.DEPTNO=d.DEPTNO
      where p.ename = '�̹���';


-- @@@@@@@ 
-- inner join 
-- emp �� dept ���̺� inner join �ϱ�
-- @@@@@@@ 

-- ���� ������ �Ҽӵ� �μ����� ����Ͻÿ�.
select emp.*, dept.dname from emp inner join dept on emp.deptno=dept.deptno;
-- ���� SQL�� �����Ͻÿ�. 
-- dept ���̺� d��� ��Ī��, emp ���̺��� e��� ��Ī�� �ο��ϵ��� �����Ͻÿ�.
select e.*, d.dname from emp e inner join dept d on e.deptno=d.deptno;
-- @@@@@@@ 
-- equi join 
-- @@@@@@@ 
  
-- ���� SQL���� ���̺� ��Ī�� �ο��ϵ��� �����Ͻÿ�. 
-- dept --> d , emp-->e .
select e.*, d.dname from emp e, dept d where e.deptno=d.deptno;

-- @@@@@@@ 
-- left join
-- @@@@@@@ 

-- dept ���̺��� �������� emp ���̺��� �����͸� ��ġ�ÿ�.
select * from dept left join emp on dept.DEPTNO=emp.DEPTNO;
-- dept - emp �� �������� ���Ͻÿ�. 3���� ���
select * from dept left join emp on dept.DEPTNO=emp.DEPTNO where emp.empno is null;


-- @@@@@@@ 
-- right join 
-- @@@@@@@    

-- emp ���̺��� �������� dept ���̺��� �����͸� ��ġ�ÿ�.
select * from dept right join emp on dept.deptno=emp.deptno;



-- ----------
-- auth(�θ����̺�), book(�ڽ����̺�) ���̺��� left join ���ϱ�
-- ----------

-- left join �ϱ� : auth ���̺��� �������� book ���̺��� �����͸� ��ġ�ÿ�.
-- auth - book �� ������ 




-- ----------
-- auth(�θ����̺�), book(�ڽ����̺�) ���̺��� right join ���ϱ�
-- ----------

-- right join : book ���̺��� �������� auth ���̺��� �����͸� ��ġ�ÿ�.
-- book - auth �� ������ 


   
-- ----------
-- full join = left join union right join
-- auth(�θ����̺�), book(�ڽ����̺�) ���̺��� full join �ϱ�
-- oracle�� full join�� ������.
-- mysql�� full join�� �������� ����.
-- ----------



-- @@@@@@@ 
-- cross join
--    on ���� ����
-- @@@@@@@ 





-- @@@@@@@ 
-- self join :  �ڽſ��� �ڱ⸦ ������ �ϴ� ���
-- inner join �� �� ����.
-- @@@@@@@ 


-- inner join�� �̿��Ͽ� ��� �Ŵ��� ã��. �Ŵ��� ������ emp.mgr�� ����.
select * from emp my inner join emp mg on my.mgr = mg.empno;
-- equi join�� �̿��Ͽ� ��� �Ŵ��� ã��
select * from emp my, emp mg where my.mgr=mg.empno;

       
       
-- @@@@@@@@@@
-- �̼�. 
-- @@@@@@@@@@
-- 1. �渮�μ��� �ٹ��ϴ� ����� �̸��� �Ի����� ����Ͻÿ�. 3��.
-- 1.1 �������� ���
select ename, hiredate from emp where deptno in(select deptno from dept where dname='�渮��');
-- 1.2 join ���
select emp.ename, emp.hiredate, dept.dname from emp left join dept on emp.deptno=dept.DEPTNO where dept.dname='�渮��';

-- 2. ��õ���� �ٹ��ϴ� ������(ename), �Ի���(hiredate), �޿�(sal) 
--    �׸��� �μ���(dname)�� ����ϴ� SQL���� �ۼ��Ͻÿ�. 6��. 
-- 2.1 �������� ���
select ename, hiredate, sal, (select dname from dept where deptno=emp.deptno) dname from emp where deptno in (select deptno from dept where loc='��õ');
-- 2.2 join ���
select emp.ename, emp.hiredate, emp.sal, dept.dname from emp left join dept on emp.deptno=dept.deptno where dept.loc = '��õ';
-- 3. ��õ���� �ٹ��ϴ� ������ ���� ����Ͻÿ�. 6��
-- 3.1 �������� ���
select count(*) from emp where deptno in (select deptno from dept where loc='��õ');
-- 3.2 join ���
select count(*) from emp left join dept on emp.deptno=dept.deptno where dept.loc='��õ';
-- 4. ����(emp.job)�� ������ ������ �̸�(emp.ename), �μ���(dept.dname)�� ����Ͻÿ�. 3��
-- 4.1 �������� ���
select ename, job, (select dname from dept where deptno=emp.deptno) from emp where job='����';
-- 4.2 join ���
select emp.ename, dept.dname from emp inner join dept on emp.deptno=dept.deptno where emp.job='����';

-- 5. ���� ����� "���켺"�� �������� �̸�(ename),����(job)�� ����Ͻÿ�. 6��
-- 5.1 �������� ���
select ename, job from emp where mgr in (select empno from emp where ename='���켺');
-- 5.2 join ���
select a.ename, a.job from emp a inner join emp b on a.mgr=b.empno where b.ename='���켺';
    
    
-- 7. '�̹���'�� ������ ������ ���� ����� ����Ͻÿ�. 4��
-- 7.1 �������� ���
select * from emp where job in (select job from emp where ename='�̹���');
-- 7.2 join ���
select a.* from emp a inner join emp b on a.job=b.job where b.ename='�̹���';
-- 8. �μ����� ���� �޿��� ���� �޴� ����� 
--    �����ȣ, ����̸�, �޿�, �μ���ȣ, �μ��� ����Ͻÿ�. 8��
-- 8.1 �������� ���
select deptno, ename, sal, (select dname from dept where dept.deptno=emp.deptno) dname 
	from emp
 where (deptno, sal) in (select deptno, max(sal) from emp group by deptno);

-- 8.2 join ���

select emp.deptno, emp.ename, emp.sal, dept.dname 
	from emp  join dept on dept.deptno=emp.deptno
 where (emp.deptno, emp.sal) in (select deptno, max(sal) from emp group by deptno);
-- 9. ����(job) ������ ���� �ִ� �μ��� �μ���ȣ�� �μ���, ��ġ 
--    �׸��� �� �μ��� ���� ������� ������ ����Ͻÿ�. 9��
-- 9.1 �������� ���
select deptno, (select dname from dept where  deptno=emp.deptno) �μ���, (select loc from dept where  deptno=emp.deptno) ����, emp.* from emp where job='����';
-- 9.2 join ���
select e.deptno, d.dname, d.loc, e.* from emp e inner join dept d on e.deptno=d.deptno where e.job='����';

-- 10. ���庸�� ���� �޿�(���� ���� ����)�� �޴� �������� �̸�, �μ���, ����, �޿��� ����ϵ�
--     ������ ������� ���ÿ�. 5�� or 7��
-- 10.1 �������� ���
-- 10.2 join ���

-- 11. �μ����� ���庸�� ���� �޿�(���� ���� ����)�� �޴� ���� �μ��� �ٹ��ϴ� 
--     �������� �̸�, �μ���, ����, �޿��� ����ϵ� ������ ������� ���ÿ�. 1��
-- 11.1 �������� ���
-- 11.2 join ���



-- @@@@@@@@@
-- ����
-- @@@@@@@@@

-- "���켺"�� ���� �ٹ���(dept.loc)���� ���ϴ� ����(job)�� '���'�� ������ ����Ͻÿ�.4��
-- 1 �������� ���
-- 2 join ���