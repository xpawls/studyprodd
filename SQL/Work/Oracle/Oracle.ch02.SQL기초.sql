

-- SQL ���� ���ڿ� ������ ����
-- ����: ������ ����
-- ����: ���� ����


-- SQL ���� NULL �̶�?

       


-- ########################
-- select ����
-- 
-- select *
--   from ���̺��;
--
-- select �÷�1, �÷�2, �÷�3
--   from ���̺��;
-- ########################


-- DEPT ���̺��� ��� �÷��� �����͸� ��ȸ�Ͻÿ�.
select * from dept;


-- DEPT ���̺���  deptno, dname �÷��� �����͸� ����Ͻÿ�.
select deptno, dname from dept;

-- EMP ���̺��� JOB, ENAME �÷��� ����Ͻÿ�.
select job, ename from emp;

-- EMP ���̺��� ��� �÷��� �����͸� ����Ͻÿ�.
select * from emp;


-- @@@@@@@@@@@@@@@@@@@@@@@@
-- �÷��� ��Ī(����) �ֱ�
-- @@@@@@@@@@@@@@@@@@@@@@@@

-- AS�� �÷��� ��Ī �ο��ϱ�. job �÷����� ��å�� , enname �÷��� �̸��̶�� ��Ī�� �ٿ� ����Ͻÿ�.
select job as ��å, ename as �̸� from emp;
-- AS���� �÷��� ��Ī �ο��ϱ�. job �÷����� ��å�� , enname �÷��� �̸��̶�� ��Ī�� �ٿ� ����Ͻÿ�.
select job ��å, ename �̸� from emp;
-- '' �� ��Ī �ο��ϱ�. job �÷�����  "aa//aa"�� , enname �÷����� "nick -+name" �̶�� ��Ī�� �ٿ� ����Ͻÿ�.
select job "aa//aa", ename "nick -+name" from emp;


-- @@@@@@@@@@@@@@@@@@@@@@@@
-- null ó���� ���ؼ��� ifnull() �Լ��� ����ؾ� �Ѵ�
-- @@@@@@@@@@@@@@@@@@@@@@@@
  
-- emp ���̺��� �̸��� mgr ���� ����Ͻÿ�. 
-- ��, mgr�� null �̸� 0���� �ٲپ� ����Ͻÿ�.
select ename �̸�, nvl(mgr,0) from emp;

-- @@@@@@@@@@@@@@@@@@@@@@@@
-- �ߺ� ���� - DISTINCT
-- @@@@@@@@@@@@@@@@@@@@@@@@

-- �ߺ��Ǵ� ename �� �����ϰ� ename �� ����Ͻÿ�. 18��
select distinct ename from emp;


-- emp ���̺��� deptno ���� �ߺ��Ǵ� ���� �����Ͽ� ����Ͻÿ�. 17��
select distinct deptno from emp;

-- @@@@@@@@@@@@@@@@@@@@@@@@
-- �÷� ����,  ���ڿ� ����  
--  concat( �÷�1  , �÷�2  ) 
--  concat( �÷�1  , �÷�2 , �÷�3, �÷�4   ) 
-- @@@@@@@@@@@@@@@@@@@@@@@@

-- ���� ��ȸ�ϱ�
select ename, job from emp  where ename='����';

-- '������ ������ �����Դϴ�' ����ϱ�
-- concat(ename, '�� ������ ', job, '�Դϴ�')
select ename || '�� ������ ' || job || '�Դϴ�.' from emp where ename='����';

-- '������ ������ �����Դϴ�' ����ϴ� �÷��̸��� '����'���� ����Ͻÿ�
select ename || '�� ������ ' || job || '�Դϴ�.' as ���� from emp where ename='����';
-- ########################
-- where ����
-- 
-- select �÷�1, �÷�2, �÷�3
--   from ���̺��
--  where ����
-- ########################

-- @@@@@@@@@@@@@@@@@@@@@@@@
-- ��������ڸ� �̿��� ���� �˻�
-- =, > , >=, <, <=, !=
-- @@@@@@@@@@@@@@@@@@@@@@@@

-- emp ���̺��� sal�� 500���� ũ�ų� ���� ��츸 ����Ͻÿ�
select * from emp where sal>=500;  
-- emp ���̺��� deptno �� 10 �ΰ�츸 ����Ͻÿ�.
select * from emp where deptno=10;   
 
-- ��������( != )
-- deptno �� 10 �� �ƴ� ����� ����Ͻÿ�.
select * from emp where DEPTNO!=10;
 
-- ����1.
-- ename �� '�̹���'�� ��츸 ���
select * from emp where ENAME='�̹���';
-- ����2.
-- ename �� '�̹���'�� �ƴ� ��츸 ���
select * from emp where ENAME!='�̹���';

-- @@@@@@@@@@@@@@@@@@@@@@@@
-- �������ڸ� �̿��� ���� �˻� 
-- and, or, not( !=, <> )
-- @@@@@@@@@@@@@@@@@@@@@@@@

-- deptno �� 10 �� ����� ����Ͻÿ�
select * from emp where DEPTNO=10;
-- job�� ������ ����� ����Ͻÿ�
select * from emp where JOB='����';

-- deptno �� 10  �̰�(and) job�� ������ ����� ����Ͻÿ�. ������
select * from emp where DEPTNO=10 and JOB='����';

-- deptno �� 10  �̰ų�(or) job�� ������ ����� ����Ͻÿ�. ������
select * from emp where DEPTNO=10 or JOB='����';



-- ����. ��������ڸ� �̿��ؼ� 
-- sal ���� 400���� ũ�ų� ���� �׸���(and) 
-- sal ���� 500���� �۰ų� ���� ������ ����Ͻÿ�. 5��
select * from emp where SAL>=400 and SAL<=500;

-- ����. ��������ڸ� �̿��ؼ� 
-- sal ���� 400���� �۰ų� ���� �Ǵ�(or) 
-- sal ���� 500���� ũ�ų� ���� ������ ����Ͻÿ�. 16��
select * from emp where SAL<=400 or SAL>=500;


-- @@@@@@@@@@@@@@@@@@@@@@@@
-- between A and B �� �̿��� ���� �˻� 
-- @@@@@@@@@@@@@@@@@@@@@@@@


-- ����. sal ���� 400���� ũ�ų� ���� �׸���(and) 
-- sal ���� 500���� �۰ų� ���� ������ ����Ͻÿ�

-- ���1. ��� �����ڸ� �̿��ϴ� ���5��
select * from emp where SAL>=400 and SAL<=500;
-- ���2. between A and B �� �̿��ϴ� ���
select * from emp where SAL BETWEEN 400 and 500;


-- ����. �Ի���(hiredate)�� 2005/01/01 ������ ����鸸 ����Ͻÿ�
select * from emp where HIREDATE<='2005/01/01';


-- ����. �Ի���(hiredate)�� 2005/01/01 ����  
-- 2012/12/31 ���� �Ի��� ����鸸 ����Ͻÿ�
-- ���1. �� �����ڸ� �̿��ϴ� ���
select * from emp where HIREDATE>='2005/01/01' and HIREDATE<='2012/12/31';
-- ���2. between A and B �� �̿��ؼ� 
select * from emp where HIREDATE BETWEEN '2005/01/01' and '2012/12/31';


-- @@@@@@@@@@@@@@@@@@@@@@@@
-- like�� �̿��� ���� �˻�
-- ���ϵ�ī��: % , _
-- @@@@@@@@@@@@@@@@@@@@@@@@

-- �̸�(ename)�� '��'�� �����ϴ� ������ ����Ͻÿ�. 4��
select * from emp where ename like '��%';
-- �̸�(ename)�� '��'�� ������ ������ ����Ͻÿ�. 0��
select * from emp where ename like '%��';
-- �̸�(ename)�� '��'�� �� �ִ� ������ ����Ͻÿ�. 4��
select * from emp where ename like '%��%';

-- ����. �̸�(ename)�� '��'�ڰ� ���� ������ ����Ͻÿ�. 3��
select * from emp where ename like '%��%';
-- ����. �̸�(ename)�� '��'�ڰ� ���� �ʴ� ������ ����Ͻÿ�. 15��
select * from emp where ename not like '%��%';


-- ���ϵ� ī�� "_"�� ����Ͽ� "�ȼ���" ���
select * from emp where ename like '��__';

-- ���ϵ� ī�� "_"�� ����Ͽ� "���켺", "���μ�" ����Ͻÿ�.
select * from emp where ename like '__��';

-- ����
-- LIKE 'a%'	: 
-- LIKE '%a'	: 
-- LIKE '%or%'	: 
-- LIKE '_r%'	: 1r, 1ra, 2rr
-- LIKE 'a_%_%' : 
-- LIKE 'a%o'	: 


-- @@@@@@@@@@@@@@@@@@@@@@@@
-- in , not in
-- in      ����. or  ������ ���� ǥ��
-- not in  ����.
-- @@@@@@@@@@@@@@@@@@@@@@@@

-- or ��������
-- comm�� 80 �̰ų� 100 �̰ų� 200�� ����� ����Ͻÿ�. 2��
select * from emp where comm=80 or comm=100 or comm=200;
-- in �������� 
-- comm�� 80 �̰ų� 100 �̰ų� 200�� ����� ����Ͻÿ�. 2��
select * from emp where comm in (80,100,200);

-- comm�� 80 �� �ƴϰ� �׸��� 100 �� �ƴϰ� �׸��� 200 �� �ƴ� ����� ����Ͻÿ�. 1��
select * from emp where comm != 80 and comm != 100 and comm != 200;

-- not in �������� 
-- comm�� 80 �� �ƴϰ� �׸��� 100 �� �ƴϰ� �׸��� 200 �� �ƴ� ����� ����Ͻÿ�. 1��
select * from emp where comm not in (80,100,200);



-- @@@@@@@@@@@@@@@@@@@@@@@@
-- is null , is not null
-- =
-- like
-- is null
-- @@@@@@@@@@@@@@@@@@@@@@@@
-- comm ����  null �� ����� ����Ͻÿ�. 14��
select * from emp where comm is null;
-- comm ����  null �� �ƴ� ��츸 ����Ͻÿ�
select * from emp where comm is not null;


-- ########################
-- ����
-- �������� ���� : asc
-- �������� ���� : desc
-- ########################

-- @@@@@@@@@@@@@@@@@@@@@@@@
-- �������� ���� : ASC : ascending 
-- @@@@@@@@@@@@@@@@@@@@@@@@

-- sal �÷��� ������������ �����Ͻÿ�
select * from emp order by sal asc;
-- �̸�(ename)�� ������������ ����Ͻÿ�
select * from emp order by ename asc;

-- @@@@@@@@@@@@@@@@@@@@@@@@
-- �������� ���� : DESC : descending 
-- @@@@@@@@@@@@@@@@@@@@@@@@

-- sal �÷��� ������������ ����Ͻÿ�
select * from emp order by sal desc;

-- �̸�(ename)�� '�̺���'�� ������ ã�Ƽ� 
-- sal ���� �������� �������� �����Ͻÿ�.
select * from emp where ename='�̺���' order by sal asc;


-- @@@@@@@@@@@@@@@@@@@@@@@@
-- �ߺ� ����: ���� ������ 2�� �� ���
-- @@@@@@@@@@@@@@@@@@@@@@@@

-- �̸�(ename)�� ������������ �����ϰ� 
-- �Ի���(hiredate)�� ������������ �����Ͻÿ�     
select * from emp order by ENAME asc,  HIREDATE desc;


-- ����. �޿�(sal)�� ���� �޴� ������ ����ϵ� �޿��� ������
--       �̸�(ename)�� ö�ڰ� ���� ������ ����Ͻÿ�.
select * from emp order by sal desc, ename asc;



-- ########################
-- ���� ������
-- ������: union, union all
-- ������: inner join, equip join
-- ������: left join, right join
-- ########################

-- GROUP_STAR ������ ��ȸ. 14��
select * from GROUP_STAR;
-- SINGLE_STAR ������ ��ȸ.7��
select * from SINGLE_STAR;


-- �ߺ��� ���ŵ� ������(union)�� ���Ͻÿ� : GROUP_STAR , SINGLE_STAR.
select * from GROUP_STAR union select * from SINGLE_STAR;                                                                 
-- �ߺ��� ���Ե� �������� ���Ͻÿ� : GROUP_STAR , SINGLE_STAR.  
select * from GROUP_STAR union all select * from SINGLE_STAR;                                    
-- ������ ���ϱ�. ���� �ι��� ��� : GROUP_STAR , SINGLE_STAR.  
-- inner join �Ǵ� equip join ��� 
select * from GROUP_STAR
INTERSECT
select * from SINGLE_STAR;


-- ������ ���ϱ� : GROUP_STAR - SINGLE_STAR : 10�� ���
-- left join ���
select * from GROUP_STAR
minus
select * from SINGLE_STAR;

-- ������ ���ϱ� : SINGLE_STAR - GROUP_STAR : 3�� ���
-- left join ���
select * from SINGLE_STAR
minus
select * from GROUP_STAR;







-- ########################
-- �̼� 1. READ( SELECT )
-- ########################
-- emp���̺��� ������ �̸��� �޿��� �Ի��ϸ��� ����Ͻÿ�. �÷� 3�� ����ϱ�
select ename, comm, hiredate from emp;

-- �÷� �̸��� ��Ī�� �ٿ� ����Ͻÿ�.
select ename �̸�, comm �޿�, hiredate �Ի��� from emp;
-- ������ �ߺ����� �ʰ� �� ������ ����Ͻÿ�
select distinct job from emp ;

-- ########################
-- �̼�2. SEARCHING( WHERE )
-- ########################
-- �޿��� 300 ������ ������ ������ȣ, ���� �̸�, �޿��� ����ϱ�
select empno, ename, comm from emp where COMM<=300;
-- �̸��� ������ȣ���� ������ ������ȣ, ������, �޿��� ����ϱ�
select empno, ename, sal from emp where ename='����ȣ';
-- �޿��� 250�̰ų� 300�̰ų� 500�� �������� ���� ��ȣ�� ������� �޿��� ����Ͻÿ�
select empno, ename, sal from emp where sal in (250, 300, 500);
select * from emp;
-- �޿��� 250�̰ų� 300�̰ų� 500�� �ƴ� �������� �˻��ϱ�
select * from emp where sal not in (250, 300, 500);

-- ########################
-- �̼�3. SORTING(ORDER BY)
-- ########################
-- LIKE �����ڿ� ���ϵ� ī�带 ����Ͽ� ������ �߿��� �̸��� ���衱���� �����ϴ� ����̳�
-- �̸� �߿� ���⡱�� �����ϴ� ������ ������ȣ�� �����̸��� ����ϵ� �ֱ� �Ի��� ���� ������ 
-- ������ȣ, ������, ����, �Ի��� �÷� �� ����ϱ�
select empno, ename, job, hiredate from emp where ename like '��%' or ename like '%��%' order by hiredate asc;

-- ����� ���� ����(������ �ǰ�����!)�� �˻��ϱ�. mgr �÷��� ����Ͽ� ������ �ۼ��Ͻÿ�.
select * from emp where mgr is null;


-- �μ� ��ȣ�� ���� �������� ����ϵ� ���� �μ����� ������ ����� ��� 
-- �Ի����� ���� ������ �������� ����ϱ�
select * from emp order by deptno asc, hiredate asc;


-- ########################
-- �̼� 4.
-- ########################
-- book ���̺��� ��� �����͸� ����Ͻÿ�
select * from book;

-- book ���̺��� bookname,  publisher,  price,  authid   �÷��� ���ڵ带 ����Ͻÿ�.
select bookname, publisher, price, authid from book;

-- book ���̺��� bookname �÷��� SQL �� �� �ִ� ���ڵ带 ����Ͻÿ�
select * from book where bookname like '%SQL%';

-- bookname �� SQL�� ������ ���ڵ带 ����Ͻÿ�
select * from book where bookname like '%SQL';

-- bookname �� SQL�� �����ϴ� ���ڵ带 ����Ͻÿ�
select * from book where bookname like 'SQL%';

-- price�� 30,700�� �̻�(ũ�ų� ����)�̰�
--         50,000�� �̸�(�۴�)�� ���ڵ带 ����Ͻÿ�
select * from book where price>=30700 and price<50000;
-- price�� 30,700�� �̻��̰� 50,000�� �̸��� ���ڵ带 ����Ͻÿ�.
-- ��, between���� ����Ͻÿ�
select * from book where price between 30700 and 49999;

-- bookname�� ���� 'JAVA' �̰�
-- price �� 30,000 �� �̻��� �����͸� ã���ÿ�
select * from book where bookname='JAVA' and price>=30000;

-- price�� 30,700�� ����(�۰ų� ����) �̰ų� 
--         58,000�� �ʰ�(ũ��)�� ���ڵ带 ����Ͻÿ�
select * from book where price<=30700 or price>58000;

-- ���ڵ带 price ������������ �����Ͻÿ�.
select * from book order by price asc;

-- ���ڵ带 price ������������ �����Ͻÿ�.
select * from book order by price desc;

-- ���ڵ带  �����Ͻÿ�. publisher ��������, price  ��������
select * from book order by PUBLISHER asc, price desc;

-- bookname�� 'SQL' �� ���� ���ڵ� �߿� price �� �� ������������ �����Ͻÿ�
select * from book where BOOKNAME like '%SQL%' order by price desc;

select deptno from emp group by deptno;