--12월 30일 오라클 문제
--1. 어떤 종류의 직업이 있는지 job 을 한 번 씩만 출력하는데 직업의 오름차순으로 출력하시오
select distinct job from emp order by job;
--2. ename 에 대소문자 상관없이 's'를 포함하고 있는 데이터 출력(컬럼:ename,job,sal)
select ename,job,sal from emp where lower(ename) like '%s%';
--3. ename 의 3번째 글자가 L 인 사람을 조회하시오(컬럼:ename,sal,comm)
select ename,sal,comm from emp where ename like '__L%';
--4. comm 이 null 이 아닌 사람 중에 sal이 1500 이상인 사람 출력(컬럼: ename,sal,comm)
select ename,sal,comm from emp where comm is not null and sal>=1500;
--5. hiredate 입사일이 5월인 사람은 모두 출력(컬럼: ename,hiredate,sal)
select ename,hiredate,sal from emp where to_char(hiredate,'mm')='05';
--6. hiredate 입사일이 1985-01-01 이후에 입사한 사람 출력(컬럼:ename,hiredate,sal)
select ename,hiredate,sal from emp where hiredate>='1985-01-01';
--7. sal 이 1500-3000 사이인 사람을 출력하는데 관계연산자와 and를 이용해서 출력
select * from emp where sal>=1500 and sal<=3000;
--8. 7번의 결과를 between을 이용해서 출력(컬럼:ename,sal,mgr)
select * from emp where sal between 1500 and 3000;
--9. in을 이용해서 job 이 clerk,president,manager 인 사람의 전체 컬럼을 모두 출력
select * from emp where job in('CLERK','PRESIDENT','MANAGER');
--10. ename,sal,comm,sal*comm 을 출력하는데 comm 이 null 인경우 1로 변경해서 출력하고 계산하기
select ename,sal,NVL(comm,1),sal*NVL(comm,1) from emp;
--11. ename 이 ADAMS 인 사람의 sal 보다 많이 받는 사람 출력(컬럼:ENAME,JOB,SAl)
select ename,job,sal from emp where sal>(select sal from emp where ename='ADAMS');
--12. 평균 sal 보다 작은 사람의 전체 컬럼 출력
select * from emp where sal<(select avg(sal) from emp);
--13. ename 이 A나 S나 M으로 시작하는 모든 사람 출력(컬럼:ename,job,sal)
select ename,job,sal from emp where ename like 'A%' or ename like 'S%' or ename like 'M%';
--14. mgr 을 group 로 인원수와 평균sal 을 구하시오(평균 sal은 무조건 올림으로) -1원 단위는 반올림
select  mgr,count(*) 인원수,round(avg(sal),-1) 평균급여  from emp where mgr is not null group by mgr;
--15. scott 의 sal 과 같은 sal 을 받는 사람을 조회하시오(컬럼:ename,sal)
select ename,sal from emp where sal=(select sal from emp where ename='SCOTT');
--16. ename 의 글자길이가 4글자인 사람만 조회(컬럼:ename,job)
select ename 이름,job 직업 from emp where length(ename)=4;
--17. ename 의 3번 글자가 R이거나 A인 사람 조회(컬럼:ename,job)
select ename,job from emp where ename like '__R%' or ename like '__A%';
--18. job 직업별로 인원수와 최고연봉을 출력하는데 직업의 오름차순으로 출력
select job 직업,count(*) 인원수,max(sal) 최고연봉 from emp group by job order by 1;
--19. || 연산자를 이용하여 다음과 같이 하나의 컬럼으로 출력하시오(emp테이블로)
---- (예) scott 의 직업은 clerk 이며 입사년도는 1989년 05월 입니다.(컬럼명은 자기소개)
select ename||'의 직업은 '||job||'이며 입사년도는 '||to_char(hiredate,'yyyy')||'년'
||to_char(hiredate,'mm')||'월입니다' 자기소개 from emp;