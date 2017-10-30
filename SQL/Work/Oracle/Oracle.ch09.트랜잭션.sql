-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
-- Ʈ�����(transaction)
-- 
-- ������ ó���� ���� �۾� ���� 
--		���� ���� SQL ��ɹ�(CUD)���� �������� ó��.
-- 
-- �������� �ϰ��� ����. all or nothing.
--		���� ���� SQL���� ������ ���������� ó���Ǹ� ���� ����
--		���� ���� SQL���� �߿��� �ϳ��� SQL���̶� �߸��Ǹ� ��ü ���
-- start transaction :
-- COMMIT    : ���� ���� ���� ����. ctrl+s
-- ROLLBACK  : ���� ���� ���. ctrl+z
-- SAVEPOINT : rollback�� ��ġ ����. breakpoint�� ����
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2


-- @@@@@
-- Ʈ����� ����
-- 
-- �۾� 1. �̺��� �����Ͻÿ�.
--      savepoint tran1 ����
--      delete
-- �۾� 2. �븮�� �������� �ٲٽÿ�.
--      savepoint tran2 ����
--      update
-- �۾� 3.  �߽ż��� �̻�� �ٲٽÿ�.
--      savepoint tran3 ����
--      update
-- �۾� 4. �κ� �ǵ�����. �߽ż��� ��������� ����Ͻÿ�
-- �۾� 5. Ʈ����� �Ϸ�. commit 
-- �۾� 6. ��ü �ǵ�����. rollback
-- @@@@@

-- Ʈ����� ����
transaction start;

-- �۾� 1. �̺��� �����Ͻÿ�.
savepoint tran1;
delete from emp where ename ='�̺���';
-- �۾� 2. �븮�� �������� �ٲٽÿ�.
savepoint tran2;
update emp set job='����' where job='�븮';
-- �۾� 3. �߽ż��� �̻�� �ٲٽÿ�.
savepoint tran3;
update emp set job='�̻�' where ename='�߽ż�';
-- �κ� �ǵ�����. �߽ż��� ��������� ����Ͻÿ�
rollback to tran3;
-- Ʈ����� �Ϸ�. transaction ����
select * from emp;
commit;
-- ��ü �ǵ�����. transaction ����
rollback;


