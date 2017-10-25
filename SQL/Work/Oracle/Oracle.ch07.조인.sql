
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
-- @@@@@@@ 

-- inner join�� �̿��Ͽ� ��� �Ŵ��� ã��. emp.mgr


-- equi self join�� �̿��Ͽ� ��� �Ŵ��� ã��


       
       
-- @@@@@@@@@@
-- �̼� 06. 
-- @@@@@@@@@@
-- 1. �渮�μ��� �ٹ��ϴ� ����� �̸��� �Ի����� ����Ͻÿ�. 3��. ��������




-- 2. ��õ���� �ٹ��ϴ� ������(ename), �Ի���(hiredate), �޿�(sal) �׸��� �μ���(dname)�� ����ϴ� SQL���� �ۼ��Ͻÿ�. 3��. ����


-- 3. ��õ���� �ٹ��ϴ� ������ ���� ����Ͻÿ�. 6��




-- 4. ����(emp.job)�� ������ ������ �̸�(emp.ename), �μ���(dept.dname)�� ����Ͻÿ�. 3��


-- 5. ���� ����� "���켺"�� �������� �̸�(ename),����(job)�� ����Ͻÿ�. 6��




-- 6. "���켺"�� ���� �ٹ������� ���ϴ� ������ '���'�� ������ ����Ͻÿ�.4��



-- 7. '�̹���'�� ������ ������ ���� ����� ����Ͻÿ�. 4��




-- 8. �μ����� ���� �޿��� ���� �޴� ����� 
--    �����ȣ, ����̸�, �޿�, �μ���ȣ, �μ��� ����Ͻÿ�. 8��

-- 8.1 �������� ���



-- 8.2 join ���




-- 9. ����(job) ������ ���� �ִ� �μ��� �μ���ȣ�� �μ���, ��ġ 
--    �׸��� �� �μ��� ���� ������� ������ ����Ͻÿ�. 9��



-- 10. ���庸�� ���� �޿�(���� ���� ����)�� �޴� �������� �̸�, �μ���, ����, �޿��� ����ϵ�
--     ������ ������� ���ÿ�. 5�� or 7��


-- 11. �μ����� ���庸�� ���� �޿�(���� ���� ����)�� �޴� ���� �μ��� �ٹ��ϴ� 
--     �������� �̸�, �μ���, ����, �޿��� ����ϵ� ������ ������� ���ÿ�. 1��

