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

--컬럼 제목에 별칭 주기(alias)
select ename as "사원명",sal as "월급여" from emp; --생략없이 alias 지정하는 방법
select ename "사원명",sal "월급여" from emp; --as 생략하고 alias 지정하는 방법
select ename 사원명,sal 월급여 from emp; --alias 에 공백이 없는 경우 "" 도 생략가능
select ename "사원 이름",sal "월 급여" from emp; --중간에 공백이 있는 경우 반드시 "" 넣어야함

--총 레코드 갯수(데이터 갯수)
select count(*) from emp; --이경우는 컬럼명이 count(*)
select count(*) count from emp;
select count(*) 총갯수 from emp;
select sal,comm,sal+NVL(comm,0) sum from emp;--sal+NVL(comm,0) 열의 컬럼명은 sum으로 변경
select sal 월급여,comm 커미션,sal+NVL(comm,0) 총금액 from emp; --컬럼명을 한글로

--문자열을 컬럼에 추가시 ||연산자 사용
select '내이름은 ' ||ename||'입니다' 자기소개 from emp;    

--내 직업은 salesman 이고 내 월 급여는 1600입니다 라고 컬럼명 "자기소개" 에 나오도록 작성
select '내 직업은 '||job||'이고 내 월 급여는 '||sal||'입니다' 자기소개 from emp;

--sal 이 1500~2000 사이가 아닌 경우만 조회
select * from emp where sal not between 1500 and 2000 order by sal;

--not in 을 사용하여 job 이 salesman,clerk 가 아닌경우만 조회
select * from emp where job not in ('SALESMAN','CLERK');

--group 함수 (count,sum,avg,max,min)
select count(*) from emp;--전체 데이터 수
select sum(sal) from emp;--sal 의 총 합계
select avg(sal) from emp;--sal 의 평균
select round(avg(sal),2) from emp;--sal 의 평균을 구하는데 소숫점 이하 2자리로 구한다
select max(sal) from emp;--최고 급여액수
select min(sal) from emp;--최소 급여액수

--평균 급여보다 sal 이 더 높은 사람을 조회하시오
select * from emp where sal>(select avg(sal) from emp);

-- scott 의 직업과 같은 직업을 가진 사람을 조회하시오
select * from emp where job=(select job from emp where ename='SCOTT');

--scott 의 mgr 과 같은 mgr 을 가진사람
select * from emp where mgr=(select mgr from emp where ename='SCOTT');

--group by
select job from emp group by job; --job 이 그룹별로 나열

--job 의 group 별로 인원수를 구해보자
select job,count(*) from emp group by job;

--제목에 별칭을 부여
select job 직업,count(*) 인원수 from emp group by job;

--job 의 group 별로 인원수를 구해보자(인원이 3명 이상인 경우에만 조회)-인원순으로 조회
select job 직업,count(*) 인원수 from emp group by job having count(job)>=3;

select job 직업,count(*) 인원수 from emp group by job having count(job)>=3 order by count(*);
select job 직업,count(*) 인원수 from emp group by job having count(job)>=3 order by 2;
select job 직업,count(*) 인원수 from emp group by job having count(job)>=3 order by 인원수;

--직업별 인원수,최저연봉,최고연봉,평균연봉(소숫점이하없이) 을 구하시오
select job 직업,count(*) 인원수,max(sal) 최고연봉,min(sal) 최소연봉,round(avg(sal),0) 평균연봉 from emp group by job order by 직업; 

--48페이지 숫자함수
select abs(-5),abs(5) from dual; --5, 5 절대값 출력

--round:반올림 ceil:무조건올림 floor:무조건내림 
select round(3.6,0),ceil(3.6),floor(3.6) from dual;--4 4 3
select round(3.4,0),ceil(3.4),floor(3.4) from dual;--3 4 3
select round(328947,-2) from dual; --328900
select round(328467,-2) from dual; --328500

select round(avg(sal),0),ceil (avg(sal)),floor(avg(sal)) from emp;

--power(m,n):m의 n승값을 구함 mod(m,n):m을 n으로 나눈 나머지
select power(3,3), mod(10,3) from dual;--27 1

--문자함수 concat(두문자더하기),lower(소문자),upper(대문자),initcap(첫글자만대문자)
select ename,concat(ename,'님'),lower(ename),upper(ename),initcap(ename) from emp;

--lpad rpad
select lpad(sal,10,'*') from emp;--총 10자리에 남는부분을 *채움(왼쪽부터 채움)
select rpad(sal,10,'*') from emp;--총 10자리에 남는부분을 *채움(오른쪽부터 채움)

select substr('HAPPY DAY',7,3) from dual;--7번 글자부터 3글자 추출
select substr('HAPPY DAY',-6,3) from dual;--뒤에서 부터 6번째 글자부터 3글자 추출

--emp 테이블의 ename에서 왼쪽에서 3글자를 추출 후 나머지 총 7자리 중 우측 빈 공간은 * 로 채워서 출력
select rpad(substr(ename,1,3),7,'*'),sal from emp;

--length 길이 구하기
select ename 이름,length(ename) 문자길이 from emp;

--replace - happy 를 good 으로 변경
select replace('HAPPY DAY','HAPPY','GOOD') from dual;

--trim :앞뒤 공백 제거
select  '*'||' LEE SU JI '||'*' from dual;
select  '*'||trim(' LEE SU JI ')||'*' from dual;

-- 일단 현재 날짜를 나타내는 sysdate
select sysdate from dual;--현재날짜
select sysdate+7 from dual;--오늘로부터 7일 뒤 날짜
select sysdate+1 from dual;--내일날짜

--to_char 함수를 이용해서 원하는 날짜 모양으로 출력해보자
select to_char(sysdate,'yyyy-mm-dd') from dual;-- 2024-12-30
-- mm월 mi 분 hh 12시간표시 am,pm 오전이나 오후 표시
select to_char(sysdate,'yyyy-mm-dd am hh:mi') from dual;-- 2024-12-30 오전 07:41

select to_char(sysdate,'yyyy-mm-dd hh24:mi') from dual;-- 2024-12-30 07:41

select to_char(sysdate,'month') from dual; --12월(지역화에 따라 다르게 나오므로 잘 사용안함)

--현재년도 4자리만 추출
select to_char(sysdate,'yyyy') from dual;
--현재 월 추출
select to_char(to_date('2024-5-10'),'mm') from dual;

--emp 의 hiredate 는 날짜 타입이다
select to_char(hiredate,'yyyy-mm-dd') 입사일자 from emp;












