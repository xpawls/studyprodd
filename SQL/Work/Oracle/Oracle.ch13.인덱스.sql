-- @@@@@@@@@@@@@@@@@@@@
-- �ε���
-- 
-- �ε��� ����
--    1. DDL��
--    2. ������
-- 
-- ���̺��� �ε��� Ȯ���ϱ�
-- 	show index from tablename;
-- 
-- ���̺��� �ε��� �����ϱ�
-- 	drop index �ε�����;
-- 
-- ���̺��� �ε��� �߰��ϱ� : �÷��� 2�� �̻� ����
-- 	�ε��� �̸� �۸� ��Ģ: ���̺��_idx_�÷���
-- 	�ε����� ����ؾ� �� �÷��� where ���� ���Ǵ� �÷����� �󵵰� ���� �÷��� ..
-- 	create index �ε����� on ���̺��( Į����1, Į����2, ... );
-- 
-- unique �ε��� �����ϱ�
-- 	���� �ε��� ���� : Unique ����, �⺻Ű(primary key) 
-- 	���� �ε�����  Unique ���ǰ� ���� ���̴�.
-- 	create unique index �ε����� on ���̺��( Į����1, Į����2, ... );
-- 
-- ���̺��� �ε��� �����ϱ�
 
-- �⺻Ű(primary key)�� �����ϸ� �ڵ����� �ε����� �����ȴ�.
-- 
-- �⺻Ű�� unique key(unique index) �� �������� ?
-- 	null ��� ����
--    �⺻Ű: null ����
--    unique key : null �ѹ� ���
-- @@@@@@@@@@@@@@@@@@@@


-- dept01 ���̺��� �����Ͻÿ�.
drop table  dept01; 
-- dept ���̺��� �����ؼ� dept01 ���̺��� �����Ͻÿ�.
create table dept01 as select * from dept where 1=2;

-- dept01 ���̺� pkid �÷��� �߰����� auto_increment�� �����Ͻÿ�. 
alter table dept01 add (pkid number(11));
alter table dept01 add (primary key(pkid));
alter table dept01 add (auto_increment(pkid));
-- dept01 ���̺��� �ε����� ����ϴ� sql���� ����ÿ�.
select * from User_indexes WHERE TABLE_NAME = 'dept01';
select * from User_indexes WHERE TABLE_NAME = '/*dept*/ ';
-- dept01 ���̺��� dname �÷��� �ε���, idx_dname�� �����Ͻÿ�.
alter 


-- dept01�� dname='abc' ���� ���� �����͸� 2�� insert�Ͽ� ����� Ȯ���Ѵ�.
-- ������ �߻��ϸ� �� ������ ã�ƺ��� �ذ�å�� �����Ͻÿ�.


-- dept01 ���̺��� idx_dname �ε����� �����Ѵٸ� �����Ͻÿ�.

-- dept01 ���̺��� deptno �� unique �ε���, idx_deptno  �����Ͻÿ�.


-- dept01�� deptno=1000�� ���� �����͸� 2�� insert�Ͽ� ����� Ȯ���Ѵ�.
-- ������ �߻��ϸ� �� ������ ã�ƺ��� �ذ�å�� �����Ͻÿ�.

-- dept01 ���̺��� idx_deptno �ε����� �����Ѵٸ� �����Ͻÿ�.


-- @@@@@
-- ����. dept01 ���̺��� deptno�� dname�� �����Ͽ� ���� �ε���, idx_deptno_dname�� �����Ͻÿ�.
-- @@@@@



-- @@@@@
-- ����. dept01 ���̺��� idx_empno_ename �ε����� �����Ѵٸ� �����Ͻÿ�.
-- @@@@@



-- @@@@@
-- ����. ��� �ε����� ����ϴ� SQL���� ����ÿ�.
-- list all non-unique indexes
-- @@@@@


-- @@@@@
-- ����. ���̺��� ��� �ε����� �����ϴ� SQL���� ����ÿ�.
-- http://stackoverflow.com/questions/3798524/mysql-dropping-all-indexes-from-table
-- drop all non-unique indexes
-- @@@@@






-- ########################
-- �̼� 13.
-- 1. book ���̺� bookname �� �����(nonunique) �ε��� ����
-- 2. book ���̺��� bookname, year, price �÷� 3���� �����ؼ� ����(unique) �ε��� ����
-- ########################
