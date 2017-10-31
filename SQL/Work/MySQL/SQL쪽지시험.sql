1. emp 테이블에서 직원의 이름(enam), 급여(sal)와 입사일(hiredate)만을 출력하는 select  문을 작성하시오. 
select ename, sal, hiredate from emp;
2. emp 테이블에서 이름(ename)에 "기"를 포함하는 직원이나 급여(sal)가 250이거나 또는 300이거나 또는 500인 직원들을 출력하는 select문을 작성하시오.
select * from emp where ename like '%기%' or sal in(250,300,500);
3. emp 테이블에서 직급(job)이 '사원'이 아닌 직원만 출력하는 select 문을 작성하시오.
select * from emp where job!='사원';
4. emp 테이블에 영업부(deptno=30) 소속의 과장 송혜교를 추가하는 insert문을 작성하시오. 
insert into emp (empno, ename, job, deptno)
values((select max(empno) from emp)+1, '송혜교', '과장', 30);
5. emp 테이블에서 영업부(deptno=30) 소속의 과장 송혜교의 연봉(sal)을 700으로, 커미션(comm)을 null로 수정하는  update문을 작성하시오.
update emp set sal=700, comm = null
where deptno=30 and ename='송혜교' and job='과장';
6. emp 테이블에서 영업부(deptno=30) 소속의 과장 송혜교를 삭제하는 delete문을 작성하시오.
delete from emp where  deptno=30 and ename='송혜교' and job='과장';
7. inner join을 사용하여 교집합을 구하시오. GROUP_STAR와 SINGLE_STAR 테이블에서 양쪽 모두 들어 있는 데이터를 출력하시오. 조인시 사용되는 컬럼: GROUP_STAR.name, SINGLE_STAR.nickname
select * from group_star g inner join single_star s on g.name = s.nickname; 
8. left join을 사용하여 차집합 구하기. GROUP_STAR와 SINGLE_STAR 테이블에서 GROUP_STAR 테이블에만 존재하는 데이터를 출력하시오. 조인시 사용되는 컬럼: GROUP_STAR.name, SINGLE_STAR.nickname
select * from group_star g left join single_star s on g.name = s.nickname where s.nickname is null; 
9. 부서번호(deptno)가 10, 20, 30인 부서중에서 부서별 급여평균이 500이상인 부서번호(deptno), 평균급여, 급여합계, 최대급여, 최소급여 , 부서별사원수를 부서번호 오름차순으로 정렬하여 출력하시오. 
select deptno, avg(sal),sum(sal), max(sal), min(sal), count(*) from emp where deptno in (10,20,30) group by deptno having avg(sal)>=500 order by deptno asc;
10. 서브쿼리를 이용하여 emp 테이블에서 가장 최근에 입사한 직원의 입사일(hiredate)과 이름(ename)을 구하시오.
select hiredate, ename from emp where hiredate in (select max(hiredate) from emp);
11. 서브 쿼리를 사용하여 dept 테이블에서 31번 부서의 부서의 위치(loc)를 40번 부서의 위치(loc)로 바꾸시오. MySQL에서 서브쿼리를 이용한 update는 불가. Oracle은 가능
update dept set loc = (select loc from dept where deptno=40)
where deptno=31;
12. emp 테이블에 아이린를 추가하시오. 추가할 empno를 구할 때는 서브쿼리를 사용하도록 한다. MySQL에서 서브쿼리를 이용한 insert는 불가. Oracle은 가능
insert into emp (empno, ename)
values ((select max(empno) from emp)+1,'아이린');
13. emp 테이블에 강민경을 추가하시오. 추가할 empno를 구할 때는 sql 변수를 사용하도록 한다. MySQL에서만 SQL 변수를 이용한 insert 가능. Oracle은 pl-sql을 사용해야 가능.
select @empno := max(empno) from emp;
insert into emp (empno, ename)
values (@empno+1,'강민경');
14. 인천에서 근무하는 직원을 출력하시오.
select e.*, d.loc from emp e left join dept d on e.deptno = d.deptno where d.loc ='인천';
15. 급여(sal)가 500이상인 직원만 급여를 10% 인상하도록 수정하시오.
update emp set sal=sal*1.1 where sal>=500;
