-- ######################################2
-- ���̺� CUD
-- ���̺� �߰�           : CREATE TABLE  ���̺��                   ;
-- ���̺� ����           : ALTER  TABLE  ���̺��                   ; 
-- ���̺� ����           : DROP   TABLE  ���̺��                   ;
-- ���̺� �̸� �ٲٱ�    : Mysql : rename table �������̺�� to �����̺��;
--                         Oracle : rename  
-- ���̺� ����           : Mysql : CREATE TABLE �����̺�� AS SELECT * FROM �������̺�;
--                         Oracle : SELECT *  INTO �����̺�� FROM �������̺�;
-- ���̺� �ο� ����     :  MySQL : 
--                      :  Oralce : TRUNCATE TABLE ���̺��                 ; // DELETE ���� �ӵ��� ����.
-- ######################################2


-- ######################################2
-- ���̺� �÷� CUD
-- ���̺� �÷� �߰�      : ALTER  TABLE  ���̺�� ADD          �÷��̸� �÷�Ÿ�� 
-- ���̺� �÷� ����      : ALTER  TABLE  ���̺�� DROP  COLUMN �÷��̸� 
-- ���̺� �÷� ���� Ÿ�� : ALTER  TABLE  ���̺�� ALTER COLUMN �÷��̸� �÷�Ÿ��
-- ���̺� ���� ���� ���� : ALTER  TABLE  ���̺�� ALTER COLUMN �÷��̸� �÷�Ÿ��
-- ���̺� �÷� ���� �̸� : EXEC SP_RENAME '���̺��̸�.�÷��̸�' , '���÷��̸�', 'COLUMN'
-- ######################################2

-- dept01 ���̺��� �����Ͻÿ�.
-- MySQL  : DROP TABLE if exits ���̺�� ;
-- Oracle : BEGIN EXECUTE IMMEDIATE 'DROP TABLE dept01'; 
--          EXCEPTION WHEN OTHERS THEN NULL; 
--          END;
--          /      -- �߿�. ��Ʈ���� ���ÿ�. �ٹٲ��� �ؾ� ���� ��.
begin execute immediate 'drop table dept01';
exception when others then null;
end;
/
-- dept01 ���̺��� DDL�� �̿��Ͽ�  �߰��Ͻÿ�.
-- �÷����� 
-- ename     : ���ڿ�
-- job       : ���ڿ�
-- email     : ���ڿ� 
-- address   : ���ڿ�
-- sex       : F �Ǵ� M  �ΰ��߿� �Ѱ��� ����� �� �ְ�.
-- phone     : ���ڿ�. 11�ڸ�~15�ڸ�
-- birthday  : ����. ��¥�� ����.
-- birthtime : ����. �ð��� ����.
-- age       : ����. 999 ������ ���尡���ϰ�. 
-- height    : �Ǽ�. �����κ��� 3�ڸ�, �Ҽ��κ��� 2�ڸ�����.
create table dept01(
 ename NVARCHAR2(50)
, job NVARCHAR2(50)
, email NVARCHAR2(50)
, address nvarchar2(50)
, sex char(1)  check(sex in('F','M'))
, phone varchar(15)
, birthday date
, birthtime date
, age number(3,0)
, height number(5,2)
);
select * from dept01;

-- dept01 ���̺��� �����Ͻÿ�.
begin execute immediate 'drop table dept01';
exception when others then null;
end;
/
drop table dept01;
-- @@@@@@
-- dept01 ���̺��� ���̺� �����̳ʸ� �̿��Ͽ� �߰��Ͻÿ�.
-- 
-- 
-- �÷����� 
-- ename     : ���ڿ�
-- job       : ���ڿ�
-- email     : ���ڿ� 
-- address   : ���ڿ�
-- sex       : F �Ǵ� M  �ΰ��߿� �Ѱ��� ����� �� �ְ�.
-- phone     : ���ڿ�. 11�ڸ�~15�ڸ�
-- birthday  : ����. ��¥�� ����.
-- birthtime : ����. �ð��� ����.
-- age       : ����. 999 ������ ���尡���ϰ�. 
-- height    : �Ǽ�. �����κ��� 3�ڸ�, �Ҽ��κ��� 2�ڸ�����.
-- @@@@@@

CREATE TABLE "TESTER1"."DEPT01" 
   (	"ENAME" VARCHAR2(20 BYTE), 
	"JOB" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(20 BYTE), 
	"ADDRESS" VARCHAR2(50 BYTE), 
	"SEX" CHAR(1 BYTE), 
	"PHONE" VARCHAR2(20 BYTE), 
	"BIRTHDAY" DATE, 
	"BIRTHTIME" DATE, 
	"AGE" NUMBER(3,0), 
	"HEIGHT" NUMBER(5,2)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
-- @@@@@@
-- dept01 ���̺��� �����Ͻÿ�.
-- email �÷��� not null �� �����Ͻÿ�.
-- @@@@@@
select * from user_tab_columns where table ='dept01';
select column_name, comments from dept01;
alter table dept01 modify email varchar2(20) not null;
-- @@@@@@
-- dept01 ���̺� insert�� �̿��Ͽ� �����͸� �Է��Ͻÿ�. 
-- ename: abc, ������ �÷� ���� null�� �Է�
-- email ������ ���� �߻�
-- @@@@@@
insert into dept01(ename, email)
          values('abc', 'null');
-- @@@@@@
-- ����. dept01 ���̺� salary �÷��� �߰��ϵ�
-- Ÿ���� ���������� �ϰ� ���� 10�ڸ��� �Ҽ��� 3�ڸ�,
-- �׸��� not null ������ �����Ͻÿ�.
-- @@@@@@
alter table dept01 add salary number(13,3) not null;
-- @@@@@@
-- ����. �÷� Ÿ�� ����
-- dept01 ���̺��� addres �÷� Ÿ���� nvarchar(1000)���� �ٲٽÿ�.
-- @@@@@@



-- @@@@@@
-- ����. �÷� ����
-- dept01 ���̺��� birthtime �÷��� �����Ͻÿ�.
-- @@@@@@


-- ���̺� �̸� �ٲٱ�
-- dept01 �� dept_new�� �ٲٽÿ�.

-- ���̺� ������ �����͸� ����
-- dept ���̺��� �����ؼ� dept02 ���̺��� ����ÿ�.
-- ���̺��� ���� ��쿡 ���̺�� �����͸� ���� �ϴ� ���
-- CREATE TABLE ���θ������̺�� AS SELECT * FROM ���������̺��;

-- ���̺� ������ ����
-- dept ���̺� ������ �����ؼ� dept03 ���̺��� ����ÿ�.


-- ����. dept ���̺� auto_increment�� ���� pid �÷� �� �߰��Ͻÿ�.
-- primary key ����
-- pid �÷� �߰�.

-- ����. dept ���̺��� �����ؼ� dept11 ���̺��� ����ÿ�.
-- ���̺� ������ auto_increment ������ pid �÷��� �����Ͻÿ�.

-- ����. dept ���̺��� �����ؼ� dept12 ���̺��� ����ÿ�.
-- ���̺� ������ auto_increment ������ pid �÷��� �����Ͻÿ�.

-- ����. dept11 ���̺��� delete�� ����Ͽ� �����͸� �����Ͻÿ�.
-- delete   ���:  auto_increment �÷� �ʱ�ȭ �ȵ�

-- ����. dept12 ���̺��� truncate�� ����Ͽ� �����͸� �����Ͻÿ�.
-- truncate ���:  auto_increment �÷� �ʱ�ȭ ��



-- ########################
-- Database ��� ��ȸ
-- ########################



-- ########################
-- ���̺� ��� ��ȸ 
-- ########################


-- ########################
-- �÷� ��� ��ȸ
-- ########################

