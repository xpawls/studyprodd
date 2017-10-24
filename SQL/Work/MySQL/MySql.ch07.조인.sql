
-- ########################
-- 조인은 2개 이상의 테이블을 연결할 때
-- inner join
-- left join
-- ########################

 
 -- emp 테이블에 p 라는 별칭 부여하시오.
select * from emp; -- select emp.* from emp;
select p.* from emp p; -- select emp.* from emp;

 -- emp 테이블에 p 라는 별칭 부여하고 ename은 이름으로, job 은 직업으로 출력하시오.
select ename 이름 , job 직업 from emp p;
-- emp 테이블에서 이름(ename)이 '이문세'인 사람을 출력하시오.

-- dept 테이블에서 deptno 가 10 인 부서를 출력하시오.

-- 서브쿼리를 이용해서 '이문세'의 데이터와 부서명을 함께 출력하시오.



-- 서브쿼리를 이용해서 '이문세'의 정보와 부서명 그리고 위치를 출력하시오.
select *
		, (select dname from dept where deptno = emp.DEPTNO )
		, (select loc from dept where deptno = emp.deptno )
 from emp
 where ename = '이문세';
-- 서브쿼리를 이용해서 여러 컬럼을 표시할 때 문제 발생됨.
-- 이런 경우에는 조인을 이용하여 쉽게 해결이 가능한다.


-- 조인을 이용해서 '이문세'의 정보와 부서명 그리고 위치를 출력하시오.
select * from emp inner join dept
						on emp.deptno=dept.deptno
 where emp.ename = '이문세';


-- @@@@@@@ 
-- inner join 
-- emp 와 dept 테이블 inner join 하기
-- @@@@@@@ 

-- 직원 정보(emp)와 소속된 부서명(dept.dname)을 출력하시오.
select emp.* , dept.dname from emp join dept on emp.deptno = dept.deptno;


-- 위의 SQL을 수정하시오. 
-- dept 테이블에 d라는 별칭을, emp 테이블에는 e라는 별칭을 부여하도록 수정하시오.
select e.* , d.dname from emp e join dept d on e.deptno = d.deptno;
-- @@@@@@@ 
-- equi join 
-- @@@@@@@ 
-- equi join 을 이용하여 직원의 모든 정보와 소속된 부서명만을 출력하시오.
-- 위의 SQL에서 테이블에 별칭을 부여하도록 수정하시오. 
-- dept --> d , emp-->e .
select e.*, d.DNAME
 from dept d, emp e
 where d.deptno = e.DEPTNO;

-- @@@@@@@ 
-- left join
-- @@@@@@@ 

-- dept 테이블을 기준으로 emp 테이블의 데이터를 합치시오.
select * from dept left join emp
			on dept.DEPTNO=emp.deptno;
-- dept - emp 의 차집합을 구하시오. 3개의 출력
select * from dept left join emp
			on dept.DEPTNO=emp.deptno
			where emp.empno is null;


-- @@@@@@@ 
-- right join 
-- @@@@@@@    

-- emp 테이블을 기준으로 dept 테이블의 데이터를 합치시오.


select * from dept right join emp
			on emp.DEPTNO = dept.DEPTNO;

select * from emp right join dept
			on emp.DEPTNO = dept.DEPTNO;
			
-- emp 테이블에 홍보팀 소속의 사원 송중기를 추가하시오
select @empno := max(empno) from emp;
insert into emp (empno, ename, job, deptno)
				values( @empno+1 , '송중기', '사원', 50);

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
-- @@@@@@@ 

-- inner join을 이용하여 담당 매니저 찾기. emp.mgr


-- equi self join을 이용하여 담당 매니저 찾기


       
       
-- @@@@@@@@@@
-- 미션 06. 
-- @@@@@@@@@@
-- 1. 경리부서에 근무하는 사원의 이름과 입사일을 출력하시오. 3개. 서브쿼리




-- 2. 인천에서 근무하는 직원명(ename), 입사일(hiredate), 급여(sal) 그리고 부서명(dname)을 출력하는 SQL문을 작성하시오. 3개. 조인


-- 3. 인천에서 근무하는 직원의 수를 출력하시오. 6개




-- 4. 직급(emp.job)이 과장인 직원의 이름(emp.ename), 부서명(dept.dname)을 출력하시오. 3개


-- 5. 직속 상관이 "감우성"인 직원들의 이름(ename),직급(job)를 출력하시오. 6개




-- 6. "감우성"과 같은 근무지에서 일하는 직급이 '사원'인 직원만 출력하시오.4개



-- 7. '이문세'와 동일한 직급을 가진 사원을 출력하시오. 4개




-- 8. 부서별로 가장 급여를 많이 받는 사원의 
--    사원번호, 사원이름, 급여, 부서번호, 부서명를 출력하시오. 8개

-- 8.1 서브쿼리 방식



-- 8.2 join 방식




-- 9. 직급(job) 과장이 속해 있는 부서의 부서번호와 부서명, 위치 
--    그리고 그 부서에 속한 사원들의 정보를 출력하시오. 9개



-- 10. 과장보다 많은 급여(같은 것은 제외)를 받는 직원들의 이름, 부서명, 직급, 급여를 출력하되
--     과장은 출력하지 마시오. 5개 or 7개


-- 11. 부서별로 과장보다 많은 급여(같은 것은 제외)를 받는 같은 부서에 근무하는 
--     직원들의 이름, 부서명, 직급, 급여를 출력하되 과장은 출력하지 마시오. 1개

