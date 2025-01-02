--emp 테이블로 연습
--job 컬럼의 데이터 중 중복되는 데이터는 한번 만 출력해보자
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT JOB,ENAME FROM EMP; --다른 컬럼하고 같이 쓸 경우 적용이 안되거나 오류가 날 수도 있다
SELECT * FROM EMP; --전체 컬럼 데이터 조회
SELECT ENAME,JOB FROM EMP;--일부 컬럼만 조회
SELECT ENAME,JOB FROM EMP ORDER BY ENAME; -- ename 의 오름차순 조회(asc 인 경우는 생략)
SELECT ENAME,JOB FROM EMP ORDER BY ENAME DESC; -- ename 의 내림차순 조회(desc 인 경우는 생략불가)

-- job의 오름차순, 같은 job일 경우는 ename의 내림차순 조회
SELECT JOB,ENAME FROM EMP ORDER BY JOB,ENAME DESC;
-- job의 오름차순, 같은 job일 경우는 ename의 오름차순 조회
SELECT JOB,ENAME FROM EMP ORDER BY JOB,ENAME;
--순서를 정할때 컬럼명 대신 컬럼번호로 해도 된다(첫번째 컬럼은 1)
SELECT JOB,ENAME FROM EMP ORDER BY 1,2; -- job(1),ename(2)

-- sal 의 오름차순 정렬
SELECT * FROM EMP ORDER BY 6;
SELECT * FROM EMP ORDER BY SAL;

--empno 의 오름차순 조회
SELECT ENAME,SAL,COMM,JOB,EMPNO FROM EMP ORDER BY 5;
SELECT ENAME,SAL,COMM,JOB,EMPNO FROM EMP ORDER BY EMPNO;

--ename 의 내림차순
SELECT ENAME,SAL,COMM,JOB,EMPNO FROM EMP ORDER BY 1 DESC;

--where 조건문
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE SAL>=1500;
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE ENAME='allen'; --데이터는 대소문자 정확히 써야한다
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE ENAME='ALLEN'; 

--ename 이 A로 시작하는 데이터 조회
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE ENAME LIKE 'A%'; --like 연산자를 사용할 때 특정문자를 포함한 데이터를 찾으려면 %을 사용한다
--ename 에 A가 포함되는 데이터 조회
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE ENAME LIKE '%A%';
-- ename 에 A 로 시작하거나 S로 시작하는 데이터 조회
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE ENAME LIKE 'A%' OR ENAME LIKE 'S%';
--ename 에 A와 S를 모두 포함하는 데이터만 출력
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE ENAME LIKE '%A%' AND ENAME LIKE '%S%';

--ename의 두번째 글자가 A인 사람만 조회
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE ENAME LIKE '_A%';
--ename의 두번째 글자가 A이거나 세번째가 A인사람만 조회
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE ENAME LIKE '_A%' OR ENAME LIKE '__A%';

--ename 이 N 이나 K로 끝나는 사람만 조회
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE ENAME LIKE '%N' OR ENAME LIKE '%K';

--job 이 analyst 이면서 sal 이 1500 이상인사람 조회
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE JOB='ANALYST' AND SAL>=1500;

--SAL 1200~2000 사이값 조회
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE SAL>=1200 AND SAL<=2000; --방법 1
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE SAL BETWEEN 1200 AND 2000; --방법 2

--job 이 manager,salesman,analyst 이 3가지 직업의 사람을 조회
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE JOB='MANAGER' OR JOB='SALESMAN' OR JOB='ANALYST';--방법 1
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE JOB IN ('MANAGER','SALESMAN','ANALYST');--방법 2

--empno 가 7654,7788,7844,7902 인 사람만 조회 
SELECT ENAME,JOB,SAL,COMM,EMPNO FROM EMP WHERE EMPNO IN(7654,7788,7844,7902) ORDER BY EMPNO;

--comm 이 null 인 데이터만 조회
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE COMM IS NULL;

--eomm 이 null 이 아닌경우 데이터만 조회
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE COMM IS NOT NULL;

--mgr 이 null 이 아닌경우만 조회
SELECT * FROM EMP WHERE MGR IS NOT NULL;

--comm 이 null 인 경우는 0으로 출력,mgr은 null인경우 100으로 출력 --NVL 사용
SELECT ENAME,JOB,SAL,NVL(MGR,100),NVL(COMM,0) FROM EMP;

SELECT SAL,COMM,SAL+COMM FROM EMP; --comm 이 null일 경우 sal+comm 도 null
--위의 경우 sal+comm 경우 comm이 null이면 0으로 계산
SELECT SAL,COMM,SAL+NVL(COMM,0) FROM EMP;

--컬럼 제목에 별칭 주기(alias)
SELECT ENAME AS "사원명",SAL AS "월급여" FROM EMP; --생략없이 alias 지정하는 방법
SELECT ENAME "사원명",SAL "월급여" FROM EMP; --as 생략하고 alias 지정하는 방법
SELECT ENAME 사원명,SAL 월급여 FROM EMP; --alias 에 공백이 없는 경우 "" 도 생략가능
SELECT ENAME "사원 이름",SAL "월 급여" FROM EMP; --중간에 공백이 있는 경우 반드시 "" 넣어야함

--총 레코드 갯수(데이터 갯수)
SELECT COUNT(*) FROM EMP; --이경우는 컬럼명이 count(*)
SELECT COUNT(*) COUNT FROM EMP;
SELECT COUNT(*) 총갯수 FROM EMP;
SELECT SAL,COMM,SAL+NVL(COMM,0) SUM FROM EMP;--sal+NVL(comm,0) 열의 컬럼명은 sum으로 변경
SELECT SAL 월급여,COMM 커미션,SAL+NVL(COMM,0) 총금액 FROM EMP; --컬럼명을 한글로

--문자열을 컬럼에 추가시 ||연산자 사용
SELECT '내이름은 ' ||ENAME||'입니다' 자기소개 FROM EMP;    

--내 직업은 salesman 이고 내 월 급여는 1600입니다 라고 컬럼명 "자기소개" 에 나오도록 작성
SELECT '내 직업은 '||JOB||'이고 내 월 급여는 '||SAL||'입니다' 자기소개 FROM EMP;

--sal 이 1500~2000 사이가 아닌 경우만 조회
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 2000 ORDER BY SAL;

--not in 을 사용하여 job 이 salesman,clerk 가 아닌경우만 조회
SELECT * FROM EMP WHERE JOB NOT IN ('SALESMAN','CLERK');

--group 함수 (count,sum,avg,max,min)
SELECT COUNT(*) FROM EMP;--전체 데이터 수
SELECT SUM(SAL) FROM EMP;--sal 의 총 합계
SELECT AVG(SAL) FROM EMP;--sal 의 평균
SELECT ROUND(AVG(SAL),2) FROM EMP;--sal 의 평균을 구하는데 소숫점 이하 2자리로 구한다
SELECT MAX(SAL) FROM EMP;--최고 급여액수
SELECT MIN(SAL) FROM EMP;--최소 급여액수

--평균 급여보다 sal 이 더 높은 사람을 조회하시오
SELECT * FROM EMP WHERE SAL>(SELECT AVG(SAL) FROM EMP);

-- scott 의 직업과 같은 직업을 가진 사람을 조회하시오
SELECT * FROM EMP WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='SCOTT');

--scott 의 mgr 과 같은 mgr 을 가진사람
SELECT * FROM EMP WHERE MGR=(SELECT MGR FROM EMP WHERE ENAME='SCOTT');

--group by
SELECT JOB FROM EMP GROUP BY JOB; --job 이 그룹별로 나열

--job 의 group 별로 인원수를 구해보자
SELECT JOB,COUNT(*) FROM EMP GROUP BY JOB;

--제목에 별칭을 부여
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB;

--job 의 group 별로 인원수를 구해보자(인원이 3명 이상인 경우에만 조회)-인원순으로 조회
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB HAVING COUNT(JOB)>=3;

SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB HAVING COUNT(JOB)>=3 ORDER BY COUNT(*);
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB HAVING COUNT(JOB)>=3 ORDER BY 2;
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB HAVING COUNT(JOB)>=3 ORDER BY 인원수;

--직업별 인원수,최저연봉,최고연봉,평균연봉(소숫점이하없이) 을 구하시오
SELECT JOB 직업,COUNT(*) 인원수,MAX(SAL) 최고연봉,MIN(SAL) 최소연봉,ROUND(AVG(SAL),0) 평균연봉 FROM EMP GROUP BY JOB ORDER BY 직업; 

--48페이지 숫자함수
SELECT ABS(-5),ABS(5) FROM DUAL; --5, 5 절대값 출력

--round:반올림 ceil:무조건올림 floor:무조건내림 
SELECT ROUND(3.6,0),CEIL(3.6),FLOOR(3.6) FROM DUAL;--4 4 3
SELECT ROUND(3.4,0),CEIL(3.4),FLOOR(3.4) FROM DUAL;--3 4 3
SELECT ROUND(328947,-2) FROM DUAL; --328900
SELECT ROUND(328467,-2) FROM DUAL; --328500

SELECT ROUND(AVG(SAL),0),CEIL (AVG(SAL)),FLOOR(AVG(SAL)) FROM EMP;

--power(m,n):m의 n승값을 구함 mod(m,n):m을 n으로 나눈 나머지
SELECT POWER(3,3), MOD(10,3) FROM DUAL;--27 1

--문자함수 concat(두문자더하기),lower(소문자),upper(대문자),initcap(첫글자만대문자)
SELECT ENAME,CONCAT(ENAME,'님'),LOWER(ENAME),UPPER(ENAME),INITCAP(ENAME) FROM EMP;

--lpad rpad
SELECT LPAD(SAL,10,'*') FROM EMP;--총 10자리에 남는부분을 *채움(왼쪽부터 채움)
SELECT RPAD(SAL,10,'*') FROM EMP;--총 10자리에 남는부분을 *채움(오른쪽부터 채움)

SELECT SUBSTR('HAPPY DAY',7,3) FROM DUAL;--7번 글자부터 3글자 추출
SELECT SUBSTR('HAPPY DAY',-6,3) FROM DUAL;--뒤에서 부터 6번째 글자부터 3글자 추출

--emp 테이블의 ename에서 왼쪽에서 3글자를 추출 후 나머지 총 7자리 중 우측 빈 공간은 * 로 채워서 출력
SELECT RPAD(SUBSTR(ENAME,1,3),7,'*'),SAL FROM EMP;

--length 길이 구하기
SELECT ENAME 이름,LENGTH(ENAME) 문자길이 FROM EMP;

--replace - happy 를 good 으로 변경
SELECT REPLACE('HAPPY DAY','HAPPY','GOOD') FROM DUAL;

--trim :앞뒤 공백 제거
SELECT  '*'||' LEE SU JI '||'*' FROM DUAL;
SELECT  '*'||TRIM(' LEE SU JI ')||'*' FROM DUAL;

-- 일단 현재 날짜를 나타내는 sysdate
SELECT SYSDATE FROM DUAL;--현재날짜
SELECT SYSDATE+7 FROM DUAL;--오늘로부터 7일 뒤 날짜
SELECT SYSDATE+1 FROM DUAL;--내일날짜

--to_char 함수를 이용해서 원하는 날짜 모양으로 출력해보자
SELECT TO_CHAR(SYSDATE,'yyyy-mm-dd') FROM DUAL;-- 2024-12-30
-- mm월 mi 분 hh 12시간표시 am,pm 오전이나 오후 표시
SELECT TO_CHAR(SYSDATE,'yyyy-mm-dd am hh:mi') FROM DUAL;-- 2024-12-30 오전 07:41

SELECT TO_CHAR(SYSDATE,'yyyy-mm-dd hh24:mi') FROM DUAL;-- 2024-12-30 07:41

SELECT TO_CHAR(SYSDATE,'month') FROM DUAL; --12월(지역화에 따라 다르게 나오므로 잘 사용안함)

--현재년도 4자리만 추출
SELECT TO_CHAR(SYSDATE,'yyyy') FROM DUAL;
--현재 월 추출
SELECT TO_CHAR(TO_DATE('2024-5-10'),'mm') FROM DUAL;

--emp 의 hiredate 는 날짜 타입이다
SELECT TO_CHAR(HIREDATE,'yyyy-mm-dd') 입사일자 FROM EMP;












