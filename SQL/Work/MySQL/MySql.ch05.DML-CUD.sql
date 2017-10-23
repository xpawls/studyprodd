-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
-- INSERT INTO 테이블명(컬럼명1, 컬럼명2,....컬럼명n) 
--               VALUES(값1, 값2, ..., 값n)
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

select * from dept;
-- dept 테이블에 홍보팀을 추가하시오
insert into dept(deptno, dname, loc)
				values(  50, '홍보팀', null);
				
insert into dept(deptno, dname)
				values(51, '홍보팀');

insert into dept
				values(52, '홍보팀', null);
-- emp 테이블에 홍보팀 소속의 사원 송중기를 추가하시오.
select * from emp;

insert into emp(empno, ename, job, deptno)
				values(1019, '송중기', '사원', 50);
-- emp 테이블에 영업부(deptno=30) 소속의 과장 송혜교를 추가하는 SQL문을 작성하시오. 
-- 단, 입사일은 2015-01-01 이고 커미션은 100 이다.
insert into emp(empno, ename, job, deptno, hiredate, comm)
			values(1020, '송혜교', '과장', 30, '2015-01-01', 100);
			
select @empno := max(empno)+1 from emp;

insert into emp(empno, deptno, job, ename, hiredate, comm)
			values(@empno ,30,'과장','송혜교','2015-01-01',100);
			
-- Oracle, MsSQL에서 가능한방법(서브쿼리를 이용한 insert)
-- insert into emp(empno, deptno, job, ename, hiredate, comm)
-- 			values((select max(empno)+1 from emp) ,30,'과장','송혜교','2015-01-01',100);
select @empno;
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
-- UPDATE 의 기본 사용 방법
-- UPDATE : 데이터 변경(수정)
-- UPDATE 테이블명 
--    SET 컬럼명1 = 값1, 컬럼명2=값2, ... 컬럼명n=값n
--  WHERE 조건식
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

-- dept 테이블에서 홍보팀(dname)의 loc를 일산으로 바꾸시오
select * from emp;
select * from dept;
update dept
	set loc = '일산'
	where dname = '홍보팀';
-- 문제 . emp 테이블에서 사원 송중기의 직책(job)을 대리로, 
-- 연봉(sal)을 1000으로, 부서를 영업부로 바꾸는 SQL문을 작성하시오.
update emp
	set job = '대리', sal = 1000, deptno = 30
	where ename = '송중기';

-- 문제. emp 테이블에서 영업부(deptno=30) 소속의 과장 송혜교의 
-- 연봉(sal)을 700으로, 커미션(comm)을 null로 수정하는 SQL문을 작성하시오.
update emp
	set sal = 500, comm = null
	where deptno=30 and job='과장' and ename='송혜교';

select * from emp;

-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
-- DELETE 의 기본 사용 방법
-- DELETE : 데이터 삭제
-- 
-- DELETE FROM 테이블명
--  WHERE 조건식
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

-- dept에서 홍보팀을 삭제하시오.
delete from dept
-- select * from dept
where dname = '홍보팀';

-- emp에서 송중기와 송혜교를 삭제하시오.
delete from emp
where ename = '송중기' or ename = '송혜교';

delete from emp
where ename in('송중기','송혜교');

select @empno := max(empno)+1 from emp;
insert into emp(empno, deptno, job, ename, hiredate, comm)
			values(@empno ,30, null,'송혜교','2015-01-01',100);
			
-- emp 테이블에서 영업팀 소속의 사원 송사랑을 추가하시오.
-- 입사일은 오늘로 한다.
select @empno := max(empno)+1 from emp;
select @deptno := deptno from dept where dname = '영업부';
insert into emp(empno, deptno, ename, hiredate)
			values(@empno, @deptno,  '송사랑', curdate());

delete from emp
where ename = '송사랑';
-- 문제. emp에서 직급(job)이 정해지지 않은 직원을 삭제하시오.
delete from emp
where job = '' or job is null;

-- 문제. emp테이블에서 경리부에 소속된 직원들만 삭제하시오.
-- 1. SQL 변수를 이용하는 방법 : MySQL만 가능

select @deptno := deptno from dept where dname = '경리부';
delete from emp
where deptno = @deptno;


-- 2. 서브쿼리를 이용하는 방법 : MySQL, Oracle 가능, 추천하는 방법
-- dept 테이블에서 경리부(dname)인 부서번호(deptno)를 출력하시오.
-- dept 테이블에서 dpetno = 10인 직원만 출력하시오.
select * from emp where deptno=10;

delete from emp
where deptno in (select deptno from dept where dname = '경리부');

select * from emp;


-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
-- 데이터 MERGE하기.
-- a. MERGE 기본 문법
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2







-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
-- 미션.
-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

-- 미션 1. 사용하여 직급(job)에 따라 급여(sal)을 아래와 같이 수정하시오.
-- 단, case~when~then을 사용하시오.
-- '부장'인 사원은 5% 인상 
-- '과장'인 사원은 10% 인상
-- '대리'인 사원은 15% 인상 
-- '사원'인 사원은 20% 인상
select ename, sal, case when job='부장' then sal*1.05
								when job='과장' then sal*1.1
								when job='대리' then sal*1.15
								when job='사원' then sal*(1+0.2)
								end 인상급여
								from emp;
update emp
	set sal = case when job='부장' then sal*1.05
								when job='과장' then sal*1.1
								when job='대리' then sal*1.15
								when job='사원' then sal*(1+0.2)
								end
								;
								
select * from emp;
-- 미션 2. 급여(sal)가 500이상인 직원만 급여를 10% 인상하도록 수정하시오.
update emp
	set sal = sal*(1+0.1)
-- select *,sal*(1+0.1) from emp 
 where sal>=500;
-- 미션 3. 2005년에 입사한 모든 직원의 입사일을 오늘 날짜로 수정하시오.
-- date를 문자로 변환.
-- MySQL  : convert(컬럼명, 'yyyy')
-- Oracle : to_char(컬럼명, 'yyyy')


update emp
	set hiredate = curdate()
-- select * from emp
where substring(hiredete, 0, 4) = '2005';

select * from emp where convert(hiredete, nchar(4))='2005';
-- 미션 4. 50번 부서의 부서의 위치(loc)를 40번 부서의 위치(loc)로 바꾸시오.
-- 용인에 있는 개발팀을 수원으로 옮긴다.
-- 단, 값 대신에 sql 쿼리를 사용하시오.
select loc from dept where deptno =40;

update dept
	set loc = '수원'
-- select * from dept
where deptno=31;

update dept
	set loc = ( select loc from dept where deptno =40 ) 
-- select * from dept
where deptno=31;

-- 미션 5. emp 테이블에서 급여가 500미만인 사원들의 급여를 50%씩 인상(업데이트)하시오.
update emp
	set sal = sal + sal*0.5
-- select * from emp
	where sal<500;

-- 미션 6. emp 테이블에 아이린 과 강민경, 이해리 를 추가하시오.
-- MySQL   : sql 변수를 사용. insert 내에서 서브쿼리 지원하지 않음.
-- Oracle : 서브쿼리를 사용.
select @maxemp := max(empno) from emp ;
insert into emp( empno, ename) values(@maxemp+1, '아이린');
insert into emp( empno, ename) values(@maxemp+2, '강민경');
insert into emp( empno, ename) values(@maxemp+3, '이해리');

select * from emp;			
			

-- 미션 7. emp 테이블에서 직급(job)이 정해지지 않은 직원을 삭제하시오.


-- 미션 8. emp 테이블에서 경리부에 소속된 사원들만 삭제하시오.


