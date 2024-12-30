--emp 테이블로 연습
--job 컬럼의 데이터 중 중복되는 데이터는 한번 만 출력해보자
select distinct job from emp;
select DISTINCT job,ename from emp; --다른 컬럼하고 같이 쓸 경우 적용이 안되거나 오류가 날 수도 있다
select * FROM emp; --전체 컬럼 데이터 조회
select ename,job from emp;--일부 컬럼만 조회
select ename,job from emp order by ename; -- ename 의 오름차순 조회(asc 인 경우는 생략)
select ename,job from emp order by ename desc; -- ename 의 내림차순 조회(desc 인 경우는 생략불가)

-- job의 오름차순, 같은 job일 경우는 ename의 내림차순 조회
select job,ename from emp order by job,ename desc;
-- job의 오름차순, 같은 job일 경우는 ename의 오름차순 조회
select job,ename from emp order by job,ename;
--순서를 정할때 컬럼명 대신 컬럼번호로 해도 된다(첫번째 컬럼은 1)
select job,ename from emp order by 1,2; -- job(1),ename(2)

-- sal 의 오름차순 정렬
select * from emp order by 6;
select * from emp order by sal;

--empno 의 오름차순 조회
select ename,sal,comm,job,empno from emp order by 5;
select ename,sal,comm,job,empno from emp order by empno;

--ename 의 내림차순
select ename,sal,comm,job,empno from emp order by 1 desc;

--where 조건문
select ename,job,sal,comm from emp where sal>=1500;
select ename,job,sal,comm from emp where ename='allen'; --데이터는 대소문자 정확히 써야한다
select ename,job,sal,comm from emp where ename='ALLEN'; 

--ename 이 A로 시작하는 데이터 조회
select ename,job,sal,comm from emp where ename like 'A%'; --like 연산자를 사용할 때 특정문자를 포함한 데이터를 찾으려면 %을 사용한다
--ename 에 A가 포함되는 데이터 조회
select ename,job,sal,comm from emp where ename like '%A%';
-- ename 에 A 로 시작하거나 S로 시작하는 데이터 조회
select ename,job,sal,comm from emp where ename like 'A%' or ename like 'S%';
--ename 에 A와 S를 모두 포함하는 데이터만 출력
select ename,job,sal,comm from emp where ename like '%A%' and ename like '%S%';

--ename의 두번째 글자가 A인 사람만 조회
select ename,job,sal,comm from emp where ename like '_A%';
--ename의 두번째 글자가 A이거나 세번째가 A인사람만 조회
select ename,job,sal,comm from emp where ename like '_A%' or ename like '__A%';

--ename 이 N 이나 K로 끝나는 사람만 조회
select ename,job,sal,comm from emp where ename like '%N' or ename like '%K';

--job 이 analyst 이면서 sal 이 1500 이상인사람 조회
select ename,job,sal,comm from emp where job='ANALYST' and sal>=1500;

--SAL 1200~2000 사이값 조회
select ename,job,sal,comm from emp where sal>=1200 and sal<=2000; --방법 1
select ename,job,sal,comm from emp where sal between 1200 and 2000; --방법 2

--job 이 manager,salesman,analyst 이 3가지 직업의 사람을 조회
select ename,job,sal,comm from emp where job='MANAGER' OR JOB='SALESMAN' OR JOB='ANALYST';--방법 1
select ename,job,sal,comm from emp where JOB IN ('MANAGER','SALESMAN','ANALYST');--방법 2

--empno 가 7654,7788,7844,7902 인 사람만 조회 
select ename,job,sal,comm,empno from emp where empno in(7654,7788,7844,7902) order by empno;

--comm 이 null 인 데이터만 조회
select ename,job,sal,comm from emp where comm is null;

--eomm 이 null 이 아닌경우 데이터만 조회
select ename,job,sal,comm from emp where comm is not null;

--mgr 이 null 이 아닌경우만 조회
select * from emp where mgr is not null;

--comm 이 null 인 경우는 0으로 출력,mgr은 null인경우 100으로 출력 --NVL 사용
select ename,job,sal,NVL(mgr,100),NVL(comm,0) from emp;

select sal,comm,sal+comm from emp; --comm 이 null일 경우 sal+comm 도 null
--위의 경우 sal+comm 경우 comm이 null이면 0으로 계산
select sal,comm,sal+NVL(comm,0) from emp;

