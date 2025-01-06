-- 전체 table 확인하기
show tables;
-- 현재 날짜와 시간 구하기(모두 같은 결과)
select now() from dual;
select sysdate() from dual;
select current_timestamp() from dual;

-- 날짜 함수들
select year(now()) from dual; -- year(날짜) : 2025 숫자로 반환
select month(now()) from dual; -- month(날짜) : 월을 숫자로 반환
select day(now()) from dual; -- 일을 구함
select dayofmonth(now()) from dual; -- 일을 구함
select monthname(now()) from dual; -- 월을 영어로
select dayname(now()) from dual; -- 요일을 영어로

-- date_format(날짜,'형식') -> 오라클의 to_char 와 같다
-- %Y(년도 4자리),%y(년도2자리),%M(월을 영어로),m%(월을 숫자로),%D:날짜
select date_format(now(),'%Y-%M-%d') from dual; -- 2025-January-02
select date_format(now(),'%y-%m-%d') from dual; -- 25-01-02
-- %H :24시간, %h:12시간표시
select date_format(now(),'%y-%m-%d %H:%i') from dual; -- 25-01-02 15:02
select date_format(now(),'%Y년%M월%d일 %H시:%i분') from dual; -- 2025년January월02일 15시:05분

-- 문자함수들
-- concat(a,b): 문자열 결합,여러개도 가능하다(오라클은 2개만 가능)
select concat('happy','day') from dual;
select concat('Happy','Day','!!') from dual;
-- replace('문자열','기존문자열','새로운문자열'):문자열 변경
select replace('bitcamp','bit','비트') from dual;
-- instr('문자열','찾는문자열'):위치 반환
select instr('김영희','영희') from dual; -- 2(2번쨰에 있다는뜻)
select instr('김영희','철수') from dual; -- 0(0은 없다는 의미)
-- left('문자열',갯수):왼쪽에서 추출
-- right('문자열',갯수):오른쪽에서 추출
-- mid('문자열',시작위치,갯수):시작위치부터 갯수만큼 추출
-- substring('문자열',시작위치,갯수):시작위치부터 갯수만큼 추출
select left('Have a nice day',4) from dual; -- Have
select right('Have a nice day',4) from dual; -- day
select mid('Have a nice day',8,4) from dual; -- nice
select substring('Have a nice day',8,4) from dual; -- nice

-- ltrim,rtrim,trim :공백제거
select concat('*',ltrim('  Happy  '),'*') from dual;
select concat('*',rtrim('  Happy  '),'*') from dual;
select concat('*',trim('  Happy  '),'*') from dual;

-- lower,lcase:소문자변환, upper,ucase:대문자변환,reverse:거꾸로
select lower('HAPPY day HAha') from dual;
select lcase('HAPPY day HAha') from dual;
select upper('HAPPY day HAha') from dual;
select ucase('HAPPY day HAha') from dual;
select reverse('HAPPY day HAha') from dual;

-- 조건함수
-- if(조건식,참일때값,거짓일때값)
select if(100>200,'맞음','틀림') from dual;
select if(100>200,'맞음','틀림') result from dual; -- 컬럼제목변경

-- ifnull(컬럼값,널일때의 대치값)
select ifnull(null,1) from dual; -- 1
select ifnull('mija',1) from dual; -- mija

-- 숫자함수
-- abs :절대값
select abs(6),abs(-6) from dual;
-- ceiling :무조건 올림,floor :무조건 내림
select ceiling(3.1),floor(3.1) from dual; -- 4 3
select ceiling(3.9),floor(3.9) from dual; -- 4 3
-- 반올림
select round(3.16,1) from dual;-- 소숫점 1째자리까지 반올림
select round(567892,-2) from dual; -- 567900

-- pow
select pow(2,3), mod(10,3) from dual; -- 8 1

-- greatest(숫자1,숫자2...):가장 큰 숫자 구하기
-- least(숫자1,숫자2...):가장 작은 숫자 구하기
select greatest(100,21,12,51) from dual;
select least(100,21,12,51,5130,123021) from dual;

-- 연습용 테이블 생성
create table shop(
	idx smallint auto_increment primary key,
    sangpum varchar(30),
    su smallint default 1,
    danga int,
    ipgoday datetime);
