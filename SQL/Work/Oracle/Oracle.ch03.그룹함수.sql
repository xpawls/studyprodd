-- @@@@@@@@@@@@@@
-- �׷� �Լ�
-- sum : �հ�
-- avg : ���
-- count : ����
-- min : �ּҰ�
-- max : �ִ밪
-- @@@@@@@@@@@@@@

-- ��ü �������� ����Ͻÿ�
select count(*) from emp;
-- emp ���̺��� �μ����� �׷�ȭ �Ͻÿ�
select deptno from emp group by DEPTNO;

-- ������ �޿�(sal)�� ����ϵ� �� �������� �ݿø��ϱ�
select round(sal,-3) from emp  ;
-- ��� ������ �޿��Ѿ�(sum), �޿����(avg), �ִ�޿�(max), �ּұ޿�(min) ���ϱ�
select sum(sal) �޿��Ѿ�, avg(sal) �޿����, max(sal) �ִ�޿�, min(sal) �ּұ޿� from emp;

-- emp ���̺��� �� ������ ������?
select count(*) from emp;

-- ename �ߺ� ������ count. 17��
select count(distinct ename) from emp;

-- �������� Ŀ�̼�(comm) �Ѿ� ���ϱ�
select sum(comm) Ŀ�̼� from emp;

-- Ŀ�̼�(comm)�� �޴� ������ ���� ���ϱ�. 3��
select count(comm) from emp ;

-- ��ü ������ ���� Ŀ�̼�(comm)�� �޴� ������ ���� ���ϱ�. �����.
select count(*), count(comm) from emp;


-- @@@@@@@@@@@@@@
-- group by ��
-- ������ �κ� �հ� ���ϱ�� ����.
-- 1. �����͸� �׷����� �� ��� 
-- 2. �׷� �Լ��� ����� �� ���
-- 3. GROUP BY ���� ��õ� �÷��� SELECT ���� ����� �� �ִ�.
-- @@@@@@@@@@@@@@

-- deptno ������������ deptno, sal, ename�� ����Ͻÿ�.
select deptno, sal, ename from emp order by DEPTNO asc;

-- -----------------------------------
-- a. ��ü �����߿��� �ִ�޿��� �ּұ޿��� ����Ͻÿ�
-- -----------------------------------
select max(sal), min(sal) from emp;
-- -----------------------------------
-- b. deptno�� 10�� �μ��� �ִ�, �ּұ޿� ����Ͻ�
-- -----------------------------------
select deptno, max(sal), min(sal) from emp where DEPTNO=10 group by DEPTNO;

-- -----------------------------------
-- c. �μ��� �ִ�, �ּ� �޿� ���ϱ�
-- -----------------------------------

-- c.1 union�� �̿��ϴ� ���
-- deptn0 = 10 �� �����߿��� �޿�(sal)�� �ִ�, �ּҸ� ���Ͻÿ�
-- deptn0 = 20 �� �����߿��� �޿�(sal)�� �ִ�, �ּҸ� ���Ͻÿ�
-- deptn0 = 21 �� �����߿��� �޿�(sal)�� �ִ�, �ּҸ� ���Ͻÿ�
-- deptn0 = 30 �� �����߿��� �޿�(sal)�� �ִ�, �ּҸ� ���Ͻÿ�
-- deptn0 = 31 �� �����߿��� �޿�(sal)�� �ִ�, �ּҸ� ���Ͻÿ�
select  max(sal), min(sal) from emp where deptno=10
union
select max(sal), min(sal) from emp where deptno=20
union
select max(sal), min(sal) from emp where deptno=21 
union
select max(sal), min(sal) from emp where deptno=30 
union
select max(sal), min(sal) from emp where deptno=31;
-- c.2 group by�� �̿��ϴ� ���
select deptno, max(sal), min(sal) from emp group by deptno order by DEPTNO asc;



-- -----------------------------------
-- �ߺ����� �ʴ� ��å(job)�� �������� ����Ͻÿ�
-- 1. ��� �����͸� ����ϵ� ��å(job)�� �������� ������������ ���� �Ͻÿ�.
-- 2. ��å(job)�� �������� ����Ͻÿ�
-- -----------------------------------
select * from emp order by JOB asc;
select job, count(job) from emp group by job;



-- -----------------------------------
-- �μ���(deptno)�� �������� Ŀ�̼�(comm)�� �޴� �������� 
-- �����ȣ(deptno) ������������ ����Ͻÿ�
-- -----------------------------------
select count(deptno), count(comm)
from emp 
group by deptno
order by DEPTNO asc;




-- @@@@@@@@@@@@@@
-- having ��
-- @@@@@@@@@@@@@@


-- -----------------------------------
-- �μ��� ��� �޿�(sal)�� �μ���ȣ(deptno) ����Ͻÿ�.
-- -----------------------------------
select deptno, avg(sal) from emp group by DEPTNO;

-- -----------------------------------
-- �μ��� �޿� ����� 500�̻��� �μ� ��ȣ�� �޿� ��� ���ϱ�
-- 1. �μ����� �μ���ȣ�� �޿���� ���ϱ�
-- 2. �׷��ε� �����Ϳ��� �޿� ����� 500�̻��� �����͸� ��˻�
-- -----------------------------------
select deptno, avg(sal) from emp group by DEPTNO having avg(sal)>=500;


-- -----------------------------------
-- �μ���ȣ(deptno)�� 10, 20, 30�� �μ��߿��� 
-- �μ��� �μ���ȣ�� �޿�(sal)��� ����Ͻÿ�
-- �μ��� �޿������ 500�̻��� �μ���ȣ�� �޿���� ���ϱ�
-- ���� �����͸� �μ���ȣ ������������ �����Ͻÿ�. 
-- 
-- �μ���ȣ(deptno)�� 10, 20, 30�� --> where
-- �μ���                          --> group by
-- �μ���ȣ�� �޿�(sal)��� ���   --> select
-- �μ��� �޿������ 500�̻�       --> having
-- 
-- deptno=20 �� ��µǸ� ����. 1��
-- -----------------------------------
select deptno, avg(sal) from emp
where DEPTNO in(10,20,30)
group by DEPTNO
having avg(sal)>=500;


-- -----------------------------------
-- ���� 1: ���޺� �޿� �Ѿ� ���ϱ�
-- '���'�� �����ϰ� 
-- ����(job)�� 
-- �޿��Ѿ��� 1000 �̻��� ���� �߿���
-- �޿��Ѿװ� ������ ����Ͻÿ�.
-- ��, ��½� �޿��Ѿ� ������ �������� �����Ѵ�.
-- 
-- '���'�� ����              --> where
-- ����(job)��                --> group by
-- �޿� �Ѿ��� 1000 �̻�      --> having
-- �޿��Ѿ� ������ �����Ͻÿ� --> order by
-- -----------------------------------
select job, sum(sal) from emp where job!='���' group by job having sum(sal)>=1000 order by sum(sal) asc;

-- -----------------------------------
-- ���� 2:  
-- ���� �ֱٿ� �Ի��� ������ �Ի��ϰ� �̸��� ���Ͻÿ�. "�߽ż� ���"
-- 2.1 oracle�� rowid�� rownum�� �䳻���� ���
-- 2.2 limit �� �̿��ϴ� ���
-- -----------------------------------


-- -----------------------------------
-- ���� 3:  
-- �ֱٿ� �Ի��� ���� 10���� �Ի��ϰ� �̸��� ���Ͻÿ�
-- 3.1 oracle�� rowid�� rownum�� �䳻���� ���
-- 3.2 top�̳� limit�� �̿��ϴ� ���
-- -----------------------------------
select rownum, hiredate, ename from (select HIREDATE, ename from emp  order by HIREDATE desc) where rownum <=10 ;


select * from ���̺��;
-- ��������
select * from ( select * from emp );

-- @@@@@@@@@@@@@@
-- �̼�
-- @@@@@@@@@@@@@@

-- �̼� 1. �޿� �ְ��, ������, �Ѿ� �� ����� ����Ͻÿ�
select max(sal), min(sal), sum(sal), avg(sal) from emp;
-- �̼� 2. ��� ����(job)���� �޿� �ְ��, ������, �Ѿ� �� ��� �޿� ����Ͻÿ�.
select job, max(sal), min(sal), sum(sal), avg(sal) from emp group by job;
-- �̼� 3. ��� ����(job)�� �������� ����ϱ�.
select job, count(job) from emp group by job;
-- �̼� 4. ������ ���� ����Ͻÿ�.
select job, count(job) from emp where job='����' group by job;
-- �̼� 5. ���޺� �޿� �Ѿ��� ���Ͻÿ�.
--         a. ������ �����ϴ� ������ �ۼ�
--         b. ������ �����ϰ� ���޺� �޿� �Ѿ�(sum) ���ϱ�
--         c. ������ �����ϰ� ���޺� �޿� �Ѿ��� 1000 �̻���  �����͸� ���.
select job, sum(sal) from emp where job!='���' group by job having sum(sal)>=1000;
-- �̼� 6. �޿� �ְ��, �޿� �������� ���� ����Ͻÿ�.
select max(sal)-min(sal) from emp;

-- �̼� 7. ���޺� ������ ���� �޿� ����Ͻÿ�.
select job, min(sal) from emp group by job;
-- �̼� 8. �μ����� �μ���ȣ, ������, ��� �޿� ����Ͻÿ�.
select deptno, count(deptno), avg(sal) from emp group by deptno ;
