
-- ########################
-- 조인은 2개 이상의 테이블을 연결할 때
-- 
-- 
-- ########################

 
 -- emp 테이블에 p 라는 별칭 부여하시오.
 select * from emp p;
 
 -- emp 테이블에 p 라는 별칭 부여하고 ename은 이름으로, job 은 직업으로 출력하시오.
select ename 이름, job 직업 from emp p;
-- emp 테이블에서 이름(enam)이 '이문세'인 사람을 출력하시오.
select * from emp where ename='이문세';
-- dept 테이블에서 deptno 가 10 인 부서를 출력하시오.
select * from dept where deptno =10;
-- 서브쿼리를 이용해서 '이문세'의 데이터와 부서명을 함께 출력하시오.
select emp.*
      , (select dname from dept where deptno=emp.deptno) 부서명
from emp where ename='이문세';

select emp.*, dept.dname from emp join dept on emp.DEPTNO=dept.DEPTNO where emp.ename='이문세' ;


-- 서브쿼리를 이용해서 '이문세'의 정보와 부서명 그리고 위치를 출력하시오.
select emp.*
      ,(select dname from dept where deptno=emp.deptno) 부서명
      ,(select loc from dept where deptno=emp.deptno) 위치
      from emp where ename = '이문세';
-- 서브쿼리를 이용해서 여러 컬럼을 표시할 때 문제 발생됨.
-- 이런 경우에는 조인을 이용하여 쉽게 해결이 가능한다.


-- 조인을 이용해서 '이문세'의 정보와 부서명 그리고 위치를 출력하시오.
select p.*, d.dname, d.loc
      from emp p join dept d
      on p.DEPTNO=d.DEPTNO
      where p.ename = '이문세';


-- @@@@@@@ 
-- inner join 
-- emp 와 dept 테이블 inner join 하기
-- @@@@@@@ 

-- 직원 정보외 소속된 부서명을 출력하시오.
select emp.*, dept.dname from emp inner join dept on emp.deptno=dept.deptno;
-- 위의 SQL을 수정하시오. 
-- dept 테이블에 d라는 별칭을, emp 테이블에는 e라는 별칭을 부여하도록 수정하시오.
select e.*, d.dname from emp e inner join dept d on e.deptno=d.deptno;
-- @@@@@@@ 
-- equi join 
-- @@@@@@@ 
  
-- 위의 SQL에서 테이블에 별칭을 부여하도록 수정하시오. 
-- dept --> d , emp-->e .
select e.*, d.dname from emp e, dept d where e.deptno=d.deptno;

-- @@@@@@@ 
-- left join
-- @@@@@@@ 

-- dept 테이블을 기준으로 emp 테이블의 데이터를 합치시오.
select * from dept left join emp on dept.DEPTNO=emp.DEPTNO;
-- dept - emp 의 차집합을 구하시오. 3개의 출력
select * from dept left join emp on dept.DEPTNO=emp.DEPTNO where emp.empno is null;


-- @@@@@@@ 
-- right join 
-- @@@@@@@    

-- emp 테이블을 기준으로 dept 테이블의 데이터를 합치시오.
select * from dept right join emp on dept.deptno=emp.deptno;



-- ----------
-- auth(부모테이블), book(자식테이블) 테이블에서 left join 구하기
-- ----------

-- left join 하기 : auth 테이블을 기준으로 book 테이블의 데이터를 합치시오.
-- auth - book 의 차집합 




-- ----------
-- auth(부모테이블), book(자식테이블) 테이블에서 right join 구하기
-- ----------

-- right join : book 테이블을 기준으로 auth 테이블의 데이터를 합치시오.
-- book - auth 의 차집합 


   
-- ----------
-- full join = left join union right join
-- auth(부모테이블), book(자식테이블) 테이블에서 full join 하기
-- oracle은 full join을 지원함.
-- mysql은 full join을 지원하지 않음.
-- ----------



-- @@@@@@@ 
-- cross join
--    on 절을 생략
-- @@@@@@@ 





-- @@@@@@@ 
-- self join :  자신에게 자기를 조인을 하는 방법
-- inner join 의 한 종류.
-- @@@@@@@ 


-- inner join을 이용하여 담당 매니저 찾기. 매니저 정보는 emp.mgr에 있음.
select * from emp my inner join emp mg on my.mgr = mg.empno;
-- equi join을 이용하여 담당 매니저 찾기
select * from emp my, emp mg where my.mgr=mg.empno;

       
       
-- @@@@@@@@@@
-- 미션. 
-- @@@@@@@@@@
-- 1. 경리부서에 근무하는 사원의 이름과 입사일을 출력하시오. 3개.
-- 1.1 서브쿼리 방식
select ename, hiredate from emp where deptno in(select deptno from dept where dname='경리부');
-- 1.2 join 방식
select emp.ename, emp.hiredate, dept.dname from emp left join dept on emp.deptno=dept.DEPTNO where dept.dname='경리부';

-- 2. 인천에서 근무하는 직원명(ename), 입사일(hiredate), 급여(sal) 
--    그리고 부서명(dname)을 출력하는 SQL문을 작성하시오. 6개. 
-- 2.1 서브쿼리 방식
select ename, hiredate, sal, (select dname from dept where deptno=emp.deptno) dname from emp where deptno in (select deptno from dept where loc='인천');
-- 2.2 join 방식
select emp.ename, emp.hiredate, emp.sal, dept.dname from emp left join dept on emp.deptno=dept.deptno where dept.loc = '인천';
-- 3. 인천에서 근무하는 직원의 수를 출력하시오. 6개
-- 3.1 서브쿼리 방식
select count(*) from emp where deptno in (select deptno from dept where loc='인천');
-- 3.2 join 방식
select count(*) from emp left join dept on emp.deptno=dept.deptno where dept.loc='인천';
-- 4. 직급(emp.job)이 과장인 직원의 이름(emp.ename), 부서명(dept.dname)을 출력하시오. 3개
-- 4.1 서브쿼리 방식
select ename, job, (select dname from dept where deptno=emp.deptno) from emp where job='과장';
-- 4.2 join 방식
select emp.ename, dept.dname from emp inner join dept on emp.deptno=dept.deptno where emp.job='과장';

-- 5. 직속 상관이 "감우성"인 직원들의 이름(ename),직급(job)를 출력하시오. 6개
-- 5.1 서브쿼리 방식
select ename, job from emp where mgr in (select empno from emp where ename='감우성');
-- 5.2 join 방식
select a.ename, a.job from emp a inner join emp b on a.mgr=b.empno where b.ename='감우성';
    
    
-- 7. '이문세'와 동일한 직급을 가진 사원을 출력하시오. 4개
-- 7.1 서브쿼리 방식
select * from emp where job in (select job from emp where ename='이문세');
-- 7.2 join 방식
select a.* from emp a inner join emp b on a.job=b.job where b.ename='이문세';
-- 8. 부서별로 가장 급여를 많이 받는 사원의 
--    사원번호, 사원이름, 급여, 부서번호, 부서명를 출력하시오. 8개
-- 8.1 서브쿼리 방식
select deptno, ename, sal, (select dname from dept where dept.deptno=emp.deptno) dname 
	from emp
 where (deptno, sal) in (select deptno, max(sal) from emp group by deptno);

-- 8.2 join 방식

select emp.deptno, emp.ename, emp.sal, dept.dname 
	from emp  join dept on dept.deptno=emp.deptno
 where (emp.deptno, emp.sal) in (select deptno, max(sal) from emp group by deptno);
-- 9. 직급(job) 과장이 속해 있는 부서의 부서번호와 부서명, 위치 
--    그리고 그 부서에 속한 사원들의 정보를 출력하시오. 9개
-- 9.1 서브쿼리 방식
select deptno, (select dname from dept where  deptno=emp.deptno) 부서명, (select loc from dept where  deptno=emp.deptno) 지역, emp.* from emp where job='과장';
-- 9.2 join 방식
select e.deptno, d.dname, d.loc, e.* from emp e inner join dept d on e.deptno=d.deptno where e.job='과장';

-- 10. 과장보다 많은 급여(같은 것은 제외)를 받는 직원들의 이름, 부서명, 직급, 급여를 출력하되
--     과장은 출력하지 마시오. 5개 or 7개
-- 10.1 서브쿼리 방식
-- 10.2 join 방식

-- 11. 부서별로 과장보다 많은 급여(같은 것은 제외)를 받는 같은 부서에 근무하는 
--     직원들의 이름, 부서명, 직급, 급여를 출력하되 과장은 출력하지 마시오. 1개
-- 11.1 서브쿼리 방식
-- 11.2 join 방식



-- @@@@@@@@@
-- 도전
-- @@@@@@@@@

-- "감우성"과 같은 근무지(dept.loc)에서 일하는 직급(job)이 '사원'인 직원만 출력하시오.4개
-- 1 서브쿼리 방식
-- 2 join 방식