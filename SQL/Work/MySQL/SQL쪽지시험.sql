1. emp ���̺��� ������ �̸�(enam), �޿�(sal)�� �Ի���(hiredate)���� ����ϴ� select  ���� �ۼ��Ͻÿ�. 
select ename, sal, hiredate from emp;
2. emp ���̺��� �̸�(ename)�� "��"�� �����ϴ� �����̳� �޿�(sal)�� 250�̰ų� �Ǵ� 300�̰ų� �Ǵ� 500�� �������� ����ϴ� select���� �ۼ��Ͻÿ�.
select * from emp where ename like '%��%' or sal in(250,300,500);
3. emp ���̺��� ����(job)�� '���'�� �ƴ� ������ ����ϴ� select ���� �ۼ��Ͻÿ�.
select * from emp where job!='���';
4. emp ���̺� ������(deptno=30) �Ҽ��� ���� �������� �߰��ϴ� insert���� �ۼ��Ͻÿ�. 
insert into emp (empno, ename, job, deptno)
values((select max(empno) from emp)+1, '������', '����', 30);
5. emp ���̺��� ������(deptno=30) �Ҽ��� ���� �������� ����(sal)�� 700����, Ŀ�̼�(comm)�� null�� �����ϴ�  update���� �ۼ��Ͻÿ�.
update emp set sal=700, comm = null
where deptno=30 and ename='������' and job='����';
6. emp ���̺��� ������(deptno=30) �Ҽ��� ���� �������� �����ϴ� delete���� �ۼ��Ͻÿ�.
delete from emp where  deptno=30 and ename='������' and job='����';
7. inner join�� ����Ͽ� �������� ���Ͻÿ�. GROUP_STAR�� SINGLE_STAR ���̺��� ���� ��� ��� �ִ� �����͸� ����Ͻÿ�. ���ν� ���Ǵ� �÷�: GROUP_STAR.name, SINGLE_STAR.nickname
select * from group_star g inner join single_star s on g.name = s.nickname; 
8. left join�� ����Ͽ� ������ ���ϱ�. GROUP_STAR�� SINGLE_STAR ���̺��� GROUP_STAR ���̺��� �����ϴ� �����͸� ����Ͻÿ�. ���ν� ���Ǵ� �÷�: GROUP_STAR.name, SINGLE_STAR.nickname
select * from group_star g left join single_star s on g.name = s.nickname where s.nickname is null; 
9. �μ���ȣ(deptno)�� 10, 20, 30�� �μ��߿��� �μ��� �޿������ 500�̻��� �μ���ȣ(deptno), ��ձ޿�, �޿��հ�, �ִ�޿�, �ּұ޿� , �μ���������� �μ���ȣ ������������ �����Ͽ� ����Ͻÿ�. 
select deptno, avg(sal),sum(sal), max(sal), min(sal), count(*) from emp where deptno in (10,20,30) group by deptno having avg(sal)>=500 order by deptno asc;
10. ���������� �̿��Ͽ� emp ���̺��� ���� �ֱٿ� �Ի��� ������ �Ի���(hiredate)�� �̸�(ename)�� ���Ͻÿ�.
select hiredate, ename from emp where hiredate in (select max(hiredate) from emp);
11. ���� ������ ����Ͽ� dept ���̺��� 31�� �μ��� �μ��� ��ġ(loc)�� 40�� �μ��� ��ġ(loc)�� �ٲٽÿ�. MySQL���� ���������� �̿��� update�� �Ұ�. Oracle�� ����
update dept set loc = (select loc from dept where deptno=40)
where deptno=31;
12. emp ���̺� ���̸��� �߰��Ͻÿ�. �߰��� empno�� ���� ���� ���������� ����ϵ��� �Ѵ�. MySQL���� ���������� �̿��� insert�� �Ұ�. Oracle�� ����
insert into emp (empno, ename)
values ((select max(empno) from emp)+1,'���̸�');
13. emp ���̺� ���ΰ��� �߰��Ͻÿ�. �߰��� empno�� ���� ���� sql ������ ����ϵ��� �Ѵ�. MySQL������ SQL ������ �̿��� insert ����. Oracle�� pl-sql�� ����ؾ� ����.
select @empno := max(empno) from emp;
insert into emp (empno, ename)
values (@empno+1,'���ΰ�');
14. ��õ���� �ٹ��ϴ� ������ ����Ͻÿ�.
select e.*, d.loc from emp e left join dept d on e.deptno = d.deptno where d.loc ='��õ';
15. �޿�(sal)�� 500�̻��� ������ �޿��� 10% �λ��ϵ��� �����Ͻÿ�.
update emp set sal=sal*1.1 where sal>=500;
