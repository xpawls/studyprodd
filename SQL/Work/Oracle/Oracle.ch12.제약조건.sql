-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
-- ���̺� ���� ����
-- 
-- �÷��� ���� ���� ���� 
--    * NOT NULL ����
-- 
--    * DEFAULT ����
-- 
-- 
-- ���̺� ���� ���� ����
-- 
--     * �⺻Ű(PRIMARY KEY)��?
--         ���̺��� ���ϼ�(UNIQUE)�� �����ϴ� ��ǥ �÷���..
--         �ֽĺ���.
--         ex) �ֹι�ȣ
--     
--     * �ܷ�Ű(FOREIGN KEY)��?
--         �θ� �ڽ� ���谡 �����Ǵ� ���̺��� �θ� ã�� ���� ���Ǵ� �÷���.
--         �ڽ� ���̺��� ����.
--         �ܷ��ĺ���. �θ� �����ϴ� �÷���.
--     
--     * ����Ű(Unique KEY)��?
--         �����ϰ� �ĺ��� �� �ִ� �ּ� �÷��� ����
--         ����Ű, �ĺ�Ű 
--         ex) �ֹι�ȣ, �ڵ�����ȣ, ���¹�ȣ, ....
--     
-- �⺻Ű, �ܷ�Ű, ����Ű�� ���̺� ����Ǵ� ���̴�.
-- ����Ű���� null�� ���, �⺻Ű���� null�� ��� �ȵ�
-- 
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
-- ������ Ÿ��
-- 
-- -----------------------------------------------------------------
-- |      | MySQL         |  Oracle                   |    SQLite  |
-- -----------------------------------------------------------------
-- | ���� | INT           |  NUMBER( �ڸ���,  0 )     |    INTEGER |
-- |      | BOOLEAN       |                           |            |
-- |      | NUMERIC       |                           |            |
-- -----------------------------------------------------------------
-- |      | DOUBLE        |  NUMBER( �ڸ���, �Ҽ���)  |    REAL    |
-- -----------------------------------------------------------------
-- | ���� | CHAR          |  CHAR                     |    TEXT    |
-- |      | VARCHAR       |                           |            |
-- |      | NCHAR         |                           |            |
-- |      | NVARACHAR     |  VARCHAR2                 |            |
-- |      | TEXT          |                           |            |
-- -----------------------------------------------------------------
-- | ��¥ | DATE          |  DATE                     |    TEXT    |
-- |      | DATETIME      |                           |            |
-- -----------------------------------------------------------------
-- |      | BLOB          |  BLOB                     |    NONE    |
-- -----------------------------------------------------------------
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2



-- ########################
-- index Ȯ��
-- MySQL  : show index from ���̺�� ;
-- Oracle : 
-- ########################

-- emp ���̺� �ɷ� �ִ� index�� ��ȸ�Ͻÿ�.

  
-- #####
-- emp02 ���̺� �����Ͻÿ�. �����̳ʸ� ����Ͽ�.
-- +----------+-------------+------+-----+---------+-------+
-- | Field    | Type        | Null | Key | Default | Extra |
-- +----------+-------------+------+-----+---------+-------+
-- | EMPNO    | int(11)     | YES  |     | NULL    |       |
-- | ENAME    | varchar(10) | YES  |     | NULL    |       |
-- | JOB      | varchar(9)  | YES  |     | NULL    |       |
-- | MGR      | int(11)     | YES  |     | NULL    |       |
-- | HIREDATE | date        | YES  |     | NULL    |       |
-- | SAL      | double(7,2) | YES  |     | NULL    |       |
-- | COMM     | double(7,2) | YES  |     | NULL    |       |
-- | DEPTNO   | int(11)     | YES  |     | NULL    |       |
-- +----------+-------------+------+-----+---------+-------+
-- #####


-- emp02 ���̺��� ��� �÷��� ���� null �� insert �Ͻÿ�.


-- #####
-- emp03 ���̺� �����Ͻÿ�. ���̺� ������ ����Ͽ�
-- empno �� not null ���� ����.
-- ename �� not null ���� ����.
-- +----------+-------------+------+-----+---------+-------+
-- | Field    | Type        | Null | Key | Default | Extra |
-- +----------+-------------+------+-----+---------+-------+
-- | EMPNO    | int(11)     | NO   |     | NULL    |       |
-- | ENAME    | varchar(10) | NO   |     | NULL    |       |
-- | JOB      | varchar(9)  | YES  |     | NULL    |       |
-- | MGR      | int(11)     | YES  |     | NULL    |       |
-- | HIREDATE | date        | YES  |     | NULL    |       |
-- | SAL      | double(7,2) | YES  |     | NULL    |       |
-- | COMM     | double(7,2) | YES  |     | NULL    |       |
-- | DEPTNO   | int(11)     | YES  |     | NULL    |       |
-- +----------+-------------+------+-----+---------+-------+
-- #####

-- emp03 ���̺� ������ insert �׽�Ʈ.
-- ��� ���� null ä���� insert �Ͻÿ�. �Ұ���. not null ���� ������.

-- emp03 ���̺��� empno�� 10, ename�� abcd�� insert �Ͻÿ�.



-- #####
-- emp04 ���̺� �����Ͻÿ�. DDL���� ����Ͽ�.
-- empno �� not null ���� ����.
-- ename �� not null ���� ����.
-- comm  �� default ���� ����. default ������ 100 ���.
-- +----------+-------------+------+-----+---------+-------+
-- | Field    | Type        | Null | Key | Default | Extra |
-- +----------+-------------+------+-----+---------+-------+
-- | EMPNO    | int(11)     | NO   |     | NULL    |       |
-- | ENAME    | varchar(10) | NO   |     | NULL    |       |
-- | JOB      | varchar(9)  | YES  |     | NULL    |       |
-- | MGR      | int(11)     | YES  |     | NULL    |       |
-- | HIREDATE | date        | YES  |     | NULL    |       |
-- | SAL      | double(7,2) | YES  |     | NULL    |       |
-- | COMM     | double(7,2) | YES  |     | 100     |       |
-- | DEPTNO   | int(11)     | YES  |     | NULL    |       |
-- +----------+-------------+------+-----+---------+-------+
-- #####
 CREATE TABLE "EMP05" 
   (	"EMPNO" NUMBER(11,0) NOT NULL ENABLE, 
	"ENAME" VARCHAR2(10 BYTE) NOT NULL ENABLE, 
	"JOB" VARCHAR2(9 BYTE), 
	"MGR" NUMBER(11,0), 
	"HIREDATE" DATE, 
	"SAL" NUMBER(7,2), 
	"COMM" NUMBER(7,2) DEFAULT 100, 
	"DEPTNO" NUMBER(11,0)
   ) ;
select * from emp04;
-- emp04 ���̺� ������ insert �׽�Ʈ.
-- ��� ���� null ä���� insert �Ͻÿ�. �Ұ���. not null ���� ������.

-- emp04 ���̺��� empno�� 10, ename�� abcd�� insert �� �� 
-- comm�� ���� ���� �����ΰ�?





-- #####
-- emp06 ���̺� �����Ͻÿ�. �����̳ʸ� ����Ͽ�.
-- empno �� not null ���� ����.
-- ename �� not null ���� ����.
-- comm  �� default ���� ����. default ������ 100 ���.
-- empno �� primary key ���� ����.
-- +----------+-------------+------+-----+---------+-------+
-- | Field    | Type        | Null | Key | Default | Extra |
-- +----------+-------------+------+-----+---------+-------+
-- | EMPNO    | int(11)     | NO   | PRI | NULL    |       |
-- | ENAME    | varchar(10) | NO   |     | NULL    |       |
-- | JOB      | varchar(9)  | YES  |     | NULL    |       |
-- | MGR      | int(11)     | YES  |     | NULL    |       |
-- | HIREDATE | date        | YES  |     | NULL    |       |
-- | SAL      | double(7,2) | YES  |     | NULL    |       |
-- | COMM     | double(7,2) | YES  |     | 100     |       |
-- | DEPTNO   | int(11)     | YES  |     | NULL    |       |
-- +----------+-------------+------+-----+---------+-------+
-- #####

-- #####
-- emp07 ���̺� �����Ͻÿ�.
-- empno �� not null ���� ����.
-- ename �� not null ���� ����.
-- comm  �� default ���� ����. default ������ 100 ���.
-- empno �� ename  �� primary key ���� ����.
-- +----------+-------------+------+-----+---------+-------+
-- | Field    | Type        | Null | Key | Default | Extra |
-- +----------+-------------+------+-----+---------+-------+
-- | EMPNO    | int(11)     | NO   | PRI | NULL    |       |
-- | ENAME    | varchar(10) | NO   | PRI | NULL    |       |
-- | JOB      | varchar(9)  | YES  |     | NULL    |       |
-- | MGR      | int(11)     | YES  |     | NULL    |       |
-- | HIREDATE | date        | YES  |     | NULL    |       |
-- | SAL      | double(7,2) | YES  |     | NULL    |       |
-- | COMM     | double(7,2) | YES  |     | 100     |       |
-- | DEPTNO   | int(11)     | YES  |     | NULL    |       |
-- +----------+-------------+------+-----+---------+-------+
-- #####

-- #####
-- emp08 ���̺� ���� DDL ���� �ۼ��Ͻÿ�.
-- empno �� not null ���� ����.
-- ename �� not null ���� ����.
-- comm  �� default ���� ����. default ������ 100 ���.
-- empno �� ename  �� primary key ���� ����.
-- phone �� unique  ���� ����.
-- +----------+-------------+------+---------+---------+-------+
-- | Field    | Type        | Null | Key     | Default | Extra |
-- +----------+-------------+------+---------+---------+-------+
-- | EMPNO    | int(11)     | NO   | PRI     | NULL    |       |
-- | ENAME    | varchar(10) | NO   | PRI     | NULL    |       |
-- | JOB      | varchar(9)  | YES  |         | NULL    |       |
-- | MGR      | int(11)     | YES  |         | NULL    |       |
-- | HIREDATE | date        | YES  |         | NULL    |       |
-- | SAL      | double(7,2) | YES  |         | NULL    |       |
-- | COMM     | double(7,2) | YES  |         | 100     |       |
-- | DEPTNO   | int(11)     | YES  |         | NULL    |       |
-- | PHONE    | varchar(13) | YES  | UNI     | NULL    |       |
-- +----------+-------------+------+---------+---------+-------+
-- #####
 CREATE TABLE "EMP08" 
   (	"EMPNO" NUMBER(11,0) NOT NULL ENABLE, 
	"ENAME" VARCHAR2(10 BYTE) NOT NULL ENABLE, 
	"JOB" VARCHAR2(9 BYTE), 
	"MGR" NUMBER(11,0), 
	"HIREDATE" DATE, 
	"SAL" NUMBER(7,2), 
	"COMM" NUMBER(7,2) DEFAULT 100, 
	"DEPTNO" NUMBER(11,0)
   ) ;

-- #####
-- emp09 ���̺� �����Ͻÿ�. �����̳ʸ� �̿��Ͻÿ�.
-- empno �� not null ���� ����.
-- ename �� not null ���� ����.
-- comm  �� default ���� ����. default ������ 100 ���.
-- empno �� ename  �� primary key ���� ����.
-- phone �� unique  ���� ����.
-- emp09.deptno �� dept.deptno �� foreign key ���� ����.
-- +----------+-------------+------+---------+---------+-------+
-- | Field    | Type        | Null | Key     | Default | Extra |
-- +----------+-------------+------+---------+---------+-------+
-- | EMPNO    | int(11)     | NO   | PRI     | NULL    |       |
-- | ENAME    | varchar(10) | NO   | PRI     | NULL    |       |
-- | JOB      | varchar(9)  | YES  |         | NULL    |       |
-- | MGR      | int(11)     | YES  |         | NULL    |       |
-- | HIREDATE | date        | YES  |         | NULL    |       |
-- | SAL      | double(7,2) | YES  |         | NULL    |       |
-- | COMM     | double(7,2) | YES  |         | 100     |       |
-- | DEPTNO   | int(11)     | YES  |         | NULL    |       |
-- | PHONE    | varchar(13) | YES  | UNI     | NULL    |       |
-- +----------+-------------+------+---------+---------+-------+
-- #####


-- ����. emp09 ���̺��� empno=10, ename=abcd��, deptno=100�� insert �Ͻÿ�.
-- insert ���� �߻�. ��?
-- ��� �ϸ� insert �� �����ϰڴ°�?




-- ######################  
-- �̼�. ERD�� �̿��ؼ� DB�� �����Ͻÿ�
-- 
-- �Ʒ��� ���ǿ� �°� ���̺��� ����� ���� ���� PK, FK�� �����Ͻÿ�. 
-- 
-- * employee ���̺�;                            
-- +----------+--------------+------+-----+---------+-------+    
-- | Field    | Type         | Null | Key | Default | Extra |    
-- +----------+--------------+------+-----+---------+-------+    
-- | emp_no   | int(4,0)     | NO   | PRI | 0       |       |    
-- | emp_name | varchar(20)  | YES  |     | NULL    |       |    
-- | salary   | int(6,0)     | YES  |     | NULL    |       |    
-- | birthday | date         | YES  |     | NULL    |       |    
-- +----------+--------------+------+-----+---------+-------+    
--                                                               
-- * project ���̺�;                             
-- +-------------+--------------+------+-----+---------+-------+ 
-- | Field       | Type         | Null | Key | Default | Extra | 
-- +-------------+--------------+------+-----+---------+-------+ 
-- | pro_no      | int(4,0)     | NO   | PRI | 0       |       | 
-- | pro_content | varchar(100) | YES  |     | NULL    |       | 
-- | start_date  | date         | YES  |     | NULL    |       | 
-- | finish_date | date         | YES  |     | NULL    |       | 
-- +-------------+--------------+------+-----+---------+-------+ 
--                                                               
-- * specialty ���̺�;                           
-- +-----------+--------------+------+-----+---------+-------+   
-- | Field     | Type         | Null | Key | Default | Extra |   
-- +-----------+--------------+------+-----+---------+-------+   
-- | emp_no    | int(4,0)     | NO   | PRI | 0       |       |   
-- | specialty | varchar(20)  | NO   | PRI |         |       |   
-- +-----------+--------------+------+-----+---------+-------+   
--                                                               
-- * assign ���̺�;                              
-- +--------+--------------+------+-----+---------+-------+      
-- | Field  | Type         | Null | Key | Default | Extra |      
-- +--------+--------------+------+-----+---------+-------+      
-- | emp_no | int(4,0)     | NO   | PRI | 0       |       |      
-- | pro_no | int(4,0)     | NO   | PRI | 0       |       |      
-- +--------+--------------+------+-----+---------+-------+    


-- ����(employee) ���̺�    �⺻ Ű�� �������� ���Ǹ� �߰��Ͻÿ�. employee_pk_
-- ������Ʈ(project) ���̺� �⺻ Ű�� �߰��Ͻÿ� �������� �̸�: project_pk 
-- ���(assign) ���̺�     �⺻ Ű�� �߰��ϱ� �������� �̸�: assign_pk
-- Ư��(specialty) ���̺�  �⺻ Ű�� �߰��ϱ� �������� �̸�: specialty_fk 

-- table relation 
-- assign ���̺�� project ���̺� ���̿� �ܷ� Ű�� �߰��ϱ�. �������Ǹ�: specialty_fk
-- ���(assign) ���̺�� ���� ���̺� ���̿� �ܷ�Ű�� �߰��ϱ� �������� �̸�: specialty_fk
-- +--------------+---------------+-----------------------+
-- | child table  | parent table  |                       |
-- +--------------+---------------+-----------------------+
-- | specialty    | employee      | specialty_employee_fk |
-- | assign       | employee      | assign_employee_fk    |
-- | assign       | project       | assign_project_fk     |
-- +--------------+---------------+-----------------------+
 CREATE TABLE "TESTER1"."EMPLOYEE" 
   (	"EMP_NO" NUMBER(4,0) DEFAULT 0 NOT NULL ENABLE, 
	"EMP_NAME" VARCHAR2(20 BYTE), 
	"SALARY" NUMBER(6,0), 
	"BIRTHDAY" DATE, 
	 CONSTRAINT "EMPLOYEE_PK" PRIMARY KEY ("EMP_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE
   ) ;
   
  CREATE TABLE "TESTER1"."PROJECT" 
   (	"PRO_NO" NUMBER(4,0) DEFAULT 0 NOT NULL ENABLE, 
	"PRO_CONTENT" VARCHAR2(100 BYTE), 
	"START_DATE" DATE, 
	"FINISH_DATE" DATE, 
	 CONSTRAINT "PROJECT_PK" PRIMARY KEY ("PRO_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE
   );
   
     CREATE TABLE "TESTER1"."SPECIALTY" 
   (	"EMP_NO" NUMBER(4,0) DEFAULT 0, 
	"SPECIALTY" VARCHAR2(20 BYTE), 
	 CONSTRAINT "SPECIALTY_PK" PRIMARY KEY ("EMP_NO", "SPECIALTY")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "SPECIALTY_FK1" FOREIGN KEY ("EMP_NO")
	  REFERENCES "TESTER1"."EMPLOYEE" ("EMP_NO") ENABLE
   );
   
   CREATE TABLE "TESTER1"."ASSIGN" 
   (	"EMP_NO" NUMBER(4,0) DEFAULT 0 NOT NULL ENABLE, 
	"PRO_NO" NUMBER(4,0) DEFAULT 0 NOT NULL ENABLE, 
	 CONSTRAINT "ASSIGN_PK" PRIMARY KEY ("EMP_NO", "PRO_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "ASSIGN_FK1" FOREIGN KEY ("EMP_NO")
	  REFERENCES "TESTER1"."EMPLOYEE" ("EMP_NO") ENABLE, 
	 CONSTRAINT "ASSIGN_FK2" FOREIGN KEY ("PRO_NO")
	  REFERENCES "TESTER1"."PROJECT" ("PRO_NO") ENABLE
   );


























-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
-- ����. ������ ����������...
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@





-- #####
-- . emp10 ���̺� �����Ͻÿ�.
-- empno �� not null ������ ����Ͻÿ�.
-- ename �� not null ������ ����Ͻÿ�.
-- comm  �� default ������ �ɰ� default ������ 100 ���.
-- deptno�� int Ÿ������.
-- empno �� ename  �� primary key ������ �����ϰ� ���Ǹ����� emp10_pk�� ����Ͻÿ�.
-- deptno �� unique  key ������ �����ϰ� ���Ǹ����� emp10_uk�� ����Ͻÿ�.
-- emp09.deptno �� dept.deptno �� foreign key ������ �����ϰ� ���Ǹ����� emp10_fk�� ����Ͻÿ�.
-- #####


-- @@@@@@@@@@@@@@@@
-- alter�� �̿��� ���� ���� �߰�
-- @@@@@@@@@@@@@@@@
-- emp02.empno�� alter�� �̿��ؼ� primary key �߰�
-- st1. emp02�� primary key ����.
-- st2. empno�� primary key �߰�.

-- emp02.deptno�� alter�� �̿��ؼ�  foreign key �߰�
-- �ܷ�Ű �������� emp02.deptno�� dept.deptno�÷� Ÿ���� ���� ������ �Ѵ�.

-- emp02.job�� alter�� �̿��ؼ� unique key �߰�


-- ����. dept ���̺� auto_increment�� ���� pid �÷� �� �߰��Ͻÿ�.
-- auto_increment �� �����Ϸ��� �ݵ�� key �� �Ǿ�� �Ѵ�.
-- pid �÷� �߰�.
-- pid �÷���  key �߰�


-- @@@@@@@@@@@@@@@@
-- alter�� �̿��� ���� ���� ����
-- @@@@@@@@@@@@@@@@


-- emp02.ename�� default ���� abc�� �ٲٽÿ�.


-- emp02.job default ���� '����'�� �ٲٽÿ�.


-- emp02.ename �� not null �� �ٲٽÿ�.


-- emp02.job �� null ������� �ٲٽÿ�.


-- @@@@@@@@@@@@@@@@
-- alter�� �̿��� ���� ���� ����
-- @@@@@@@@@@@@@@@@

-- emp10���� primary key ���� �����ϱ�

-- emp10���� ���Ǹ����� foreign key ���� �����ϱ�

-- emp10���� ���Ǹ����� unique key ���� �����ϱ�


-- ######################  
-- �̼�. �ܷ�Ű�� �����Ͻÿ�
-- 
-- auth�� book ���̺��� �����Ѵ�. �� �� ���̺��� �����̼��� �����Ϸ��� �Ѵ�.
-- auth.authid�� book.authid �� auth_book_fk ��� �̸��� �ܷ�Ű�� �����Ͻÿ�.
-- �ܷ�Ű ������ �ȵȴٸ� �� �ȵǴ� ���ΰ�?
-- ��� �ϸ� �ܷ�Ű ���� ������ �ذ� �� �� ���� ���ΰ�?
-- ######################


-- join�� �̿��ؼ� �θ�.�ڽİ��� ������ ���صǴ� �����͸� ã���ÿ�.
-- left join�� �̿��Ͽ� ������ ���ϱ�. book - auth 

-- join�� �̿��ؼ� �θ�.�ڽİ��� ������ ���صǴ� �����͸� delete�Ͻÿ�.

-- �ܷ�Ű ����

-- �θ� ���̺� ������ insert �ϱ�.

-- �ܷ�Ű ����

-- join�� �̿��ؼ� �θ�.�ڽİ��� ������ ���صǴ� �����͸� ã���ÿ�.
-- left join�� �̿��Ͽ� ������ ���ϱ�. book - auth 
  
  