
--@@@@@@@@@@@@
-- ������ ���� ���� : =
--@@@@@@@@@@@@

-- '�̹���'�� �μ��� �˾Ƴ���
select * from emp where ename='�̹���';
select dname from dept where DEPTNO=10;
-- ���������� �̿��Ͽ� '�̹���'�� �μ��� �˾Ƴ���
select dname from dept where DEPTNO=(select deptno from emp where ename='�̹���');
-- ��� �޿����� �� ���� �޿��� �޴� ��� ����ϱ�. 9��
select avg(sal) from emp;
select * from emp where sal >457.77;
-- ���������� �̿��Ͽ� ��� �޿����� �� ���� �޿��� �޴� ��� ����ϱ�
select * from emp where sal >(select avg(sal) from emp);

-- ����. �޿��� 500�� �ʰ��ϴ� ����� ���� �μ��� �ٹ��ϴ� ��� ���ϱ�
select * from emp where sal>500;
select * from emp where deptno in(select deptno from emp where sal>500);
-- @@@@@@@@@@@@
-- ������ ���� ����
-- @@@@@@@@@@@@


-- -------------------- 
-- ���� �� subquery in ��� ����
-- --------------------
-- ��õ���� �ٹ��ϴ� ������ ����Ͻÿ�. 6��
select * from dept where loc='��õ';
select * from emp where deptno in(20,21);
-- ���������� �̿��Ͽ� ��õ���� �ٹ��ϴ� ������ ����Ͻÿ�.
select * from emp where deptno in(select deptno from dept where loc='��õ');

-- �޿��� 500�� �ʰ��ϴ� ����� ���� �μ�(deptno) �� �ٹ��ϴ� ������ ����Ͻÿ�.
select * from emp where sal > 500;
select * from emp where deptno in(10,20,21);
-- ���������� �̿��Ͽ� �޿��� 500�� �ʰ��ϴ� ����� ���� �μ�(deptno) �� �ٹ��ϴ� ������ ����Ͻÿ�.
select * from emp where deptno in(select deptno from emp where sal > 500);

---------------------- 
-- ���� �� subquery not in ��� ����
----------------------
-- ��õ�� �ٹ����� �ʴ� ������ ����Ͻÿ�.
select deptno from dept where loc='��õ';
select * from emp where deptno not in(20,21);
-- ���������� �̿��Ͽ�  ��õ�� �ٹ����� �ʴ� ������ ����Ͻÿ�.
select * from emp where deptno not in(select deptno from dept where loc='��õ');

-- -------------------- 
-- ���� �� subquery ALL ��� ����
-- --------------------
-- deptno=30�� �μ��� �ִ� �޿����� ���� �޿��� �޴� ������ ����Ͻÿ�.
-- ù��° ���. MAX ���
select max(sal) from emp where deptno =30;
select * from emp where sal>(select max(sal) from emp where deptno =30);

-- �ι�° ���. ALL  ��� == ���� AND �� ���� �ǹ�
select * from emp where sal>ALL(select sal from emp where deptno =30);
-- -------------------- 
-- ���� �� subquery ANY ��� ����
-- --------------------
-- deptno=30�� �μ��� �ּ� �޿����� ���� �޿��� �޴� ������ ����Ͻÿ�.
-- ù��° ���. MIN ���
select min(sal) from emp where deptno=30;
select * from emp where sal>(select min(sal) from emp where deptno=30);

-- �ι�° ���. ANY ��� == ���� OR �� ���� �ǹ�
select * from emp where sal > ANY(select sal from emp where deptno=30);

-- -------------------- 
-- ���� �� subquery exist ��� ����
-- --------------------

-- ���� ������ �ִ� �μ��� ����Ͻÿ�. 5���� ��µǸ� ����.
-- in�� ����ϴ� ���
select distinct deptno from emp;
select * from dept where deptno in (select distinct deptno from emp);
-- exists �� ����ϴ� ���
select * from dept 
 where exists (select distinct deptno from emp where emp.deptno = dept.deptno);
 
 
 
-- @@@@@@@@@@@@
-- table ���� ���� : from ������ ���Ǵ� ��������
-- join �� ���յ� ����
-- @@@@@@@@@@@@
-- ��õ���� �ٹ��ϴ� ������ ����Ͻÿ�. 6��
-- where�� ���� ������ ����ϴ� ���
 select * from emp where deptno in (select deptno from dept where loc='��õ');
-- from�� ���� ������ ����ϴ� ��� 
select * from emp, (select deptno from dept where loc='��õ') p 
where emp.deptno=p.deptno;

-- @@@@@@@@@@@@
-- scalar ���� ���� : select ������ ���Ǵ� ��������
-- join �� ���յ� ����
-- @@@@@@@@@@@@
-- emp ��½� deptno ��ſ� dept���̺��� dname ���� ��µǵ��� �Ͻÿ�.
select ename, deptno ,(select dname from dept where dept.deptno=emp.deptno) as dname from emp;


-- @@@@@@@@@@@@@@
-- �̼� 05. 
-- @@@@@@@@@@@@@@

-- 1. ���������� �̿��ؼ� �����ο� �ٹ��ϴ� ����� �̸��� �Ի����� ����Ͻÿ�.
select ename, hiredate, deptno from emp where deptno in(select deptno from dept where dname='������');



-- 2. ������ �ּ� �޿����� ���� �޿��� �޴� �������� 
--    �̸�, �޿� �׸��� ������ ����ϵ�, ������ ������� �ʴ´�.
select * from emp where sal>(select min(sal) from emp where job='����') and job!='����';



-- 3. ��õ�� ��ġ�� �μ��� �Ҽӵ� �������� �޿��� 100�� �λ��� ����� ����Ͻÿ�.
select * from emp where deptno in(select deptno from dept where loc='��õ');

select emp.*, sal+100 from emp where deptno in(select deptno from dept where loc='��õ');



-- 4. �μ����� ���� �޿��� ���� �޴� ������ ������ ����Ͻÿ�.
select max(sal) from emp group by deptno ;
select * from emp where sal in(select max(sal) from emp group by deptno);
 

-- 5. ����(job)�� ������ �������� ���� �μ� ������ ����Ͻÿ�.
select deptno from emp where job='����';
select * from emp where deptno in(select deptno from emp where job='����');

-- 6. ��� �޿����� �� ���� �޿��� �޴� ��� ����ϱ�
select * from emp where sal > (select avg(sal) from emp);
-- 7. �̹����� ���� �μ��� �ٹ��ϴ� ����� �̸��� �μ���ȣ�� ����ϴ� SQL�� �ۼ��Ͻÿ�.
select ename, deptno from emp where deptno in (select deptno from emp where ename='�̹���');
-- 8. �̹����� ������ ������ ���� ����� ����Ͻÿ�.
select * from emp where job in (select job from emp where ename='�̹���');
-- 9. �̹����� �޿��� �����ϰų� �� ���� �޴� ��� ��� �޿��� ����Ͻÿ�.
select ename, sal from emp where sal>=(select sal from emp where ename='�̹���');
-- 10. ���� ����� ���켺�� ����� �̸��� �޿��� ����Ͻÿ�.
select ename, sal from emp where mgr in (select empno from emp where ename='���켺');