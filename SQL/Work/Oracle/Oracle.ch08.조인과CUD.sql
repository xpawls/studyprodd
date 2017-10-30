
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
-- ������ �����ϱ�.
-- a. INSERT INTO ~ VALUES        �� �̿��� INSERT ��� : �⺻ ������ ���� ���
-- b. INSERT INTO ~ SELECT ~ FROM �� �̿��� INSERT ��� : ���̺��� �������� ����. ������ ����
-- c. INSERT INTO ~ SELECT ~ FROM �� �̿��� INSERT ��� : ���̺��� �������� ����. ������ ����
-- d. CREATE TABLE ���̺�� ~ FROM�� �̿��� INSERT ��� : ���̺��� �������� ����. ���̺� ����
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

-- a. INSERT INTO ~ VALUES
--    emp ���̺� �渮�� �Ҽ��� ��� ���߱⸦ �߰��Ͻÿ�.
select * from dept;

insert into emp (empno, deptno, job, ename)
          values ((select max(empno) from emp)+1, 10, '���', '���߱�');

-- b. INSERT INTO ~ SELCET ~ FROM �� �̿��� INSERT ��� 
--    ���������� �̿��ؼ� emp ���̺� ��� ���߱⸦ �߰�
insert into emp (empno, deptno, job, ename)
          values ((select max(empno) from emp)+1, 10, '���', '���߱�');

-- c. ���̺��� ���� ��쿡 ���̺�� �����͸� ���� �ϴ� ���
--    CREATE TABLE ���θ������̺�� AS SELECT * FROM ���������̺��;
create table empex as select * from emp;

-- d. ���̺��� �̹� �����Ǿ� �ְ� �����͸� ����
--    INSERT INTO ���������̺�� SELECT * FROM ���������̺�� [WHERE ��]
--    new_emp �� ��� ������ ����
insert into empex select * from emp;
delete from empex;
-- e. ���̺��� ������ ���̺� ������ �����ϱ� : 
-- CREATE TABLE new_table LIKE old_table;
create table eee as select * from emp where 1=2;

-- f. emp01 ���̺� �����ϱ�
drop table eee purge;
drop table empex purge;


-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
-- ������ �����ϱ�.
-- a. UPDATE ~ SET ~ WHERE �� �̿��� UPDATE ��� : �⺻ ������ ���� ���
-- b. ����������              �̿��� UPDATE ��� : 
-- c. ������                  �̿��� UPDATE ��� : UPDATE ~ SET ~ FROM ~ WHERE
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

-- a. UPDATE ~ SET ~ WHERE �� �̿��� UPDATE ��� : �⺻ ������ ���� ���
-- HR������ �ٹ��ϴ� ��� ������ �λ�η� �����ϰ� ������ 300 ���� �����Ͻÿ�
select * from dept where dname in ('HR��','�λ��');
update emp set deptno=20, sal=300
        where deptno=21;
select * from emp;
-- b. ���������� �̿��� UPDATE ��� :
-- HR������ �ٹ��ϴ� ����� �λ�η� �����ϰ� ������ 300 ���� �����Ͻÿ�



-- c. ������  �̿��� UPDATE ��� : 
-- UPDATE [���̺��1] A INNER JOIN [���̺��2] B
-- ON A.[������ �÷���] = B.[������ �÷���]
-- SET [������ �÷���] = �����Ұ�
-- ( WHERE �� )
-- HR������ �ٹ��ϴ� ����� �λ�η� �����ϰ� ������ 300 ���� �����Ͻÿ�



-- �̼�. 
-- '�λ��'�� �μ� ��ġ(loc)�� '�����'�� �ִ� ����(loc)���� �Űܶ�.







-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
-- ������ �����ϱ�.
-- a. DELETE FROM ���̺�� WHERE �� �̿��ϴ� ��� : �⺻ ������ ���� ���
-- b. ���������� �̿��� DELETE �� �ϴ� ��� :
-- c. ������ �̿��� DELETE     �� �ϴ� ��� : 
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2 


-- a. DELETE FROM ~ WHERE �� �̿��ϴ� ��� : �⺻ ������ ���� ���
-- �渮�ο��� �ٹ��ϴ� ��� ����� emp���� �����Ͻÿ�.





-- b. ���������� �̿��� DELETE ��� :
-- �渮�ο��� �ٹ��ϴ� ��� ����� emp���� �����Ͻÿ�.




-- c. ������ �̿��� DELETE ��� :
-- �渮�ο��� �ٹ��ϴ� ��� ����� emp���� �����Ͻÿ�.

