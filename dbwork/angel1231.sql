-- 시퀀스를 생성해보자
CREATE SEQUENCE SEQ1; --1부터 1씩 자동증가하는 시퀀스객체가 생성
CREATE SEQUENCE SEQ2 START WITH 1 INCREMENT BY 1; --위와 같다
CREATE SEQUENCE SEQ3 START WITH 1 INCREMENT BY 1 NOCACHE; --위와 같으나 cache 사이즈를 20에서 0으로 변경
CREATE SEQUENCE SEQ4 START WITH 1 INCREMENT BY 1 MAXVALUE 100 NOCACHE; --max값을 100까지만
CREATE SEQUENCE SEQ5 START WITH 5 INCREMENT BY 5 NOCACHE; 
-- 시퀀스전체정보를 출력
SELECT * FROM SEQ;

--시퀀스값을 발생시켜보자 - 한번 발생한 값들은 두번 다시 안나온다
SELECT SEQ1.NEXTVAL,SEQ2.NEXTVAL,SEQ3.NEXTVAL,SEQ4.NEXTVAL,SEQ5.NEXTVAL FROM DUAL;

--시퀀스 제거
DROP SEQUENCE SEQ1;
DROP SEQUENCE SEQ2;
DROP SEQUENCE SEQ3;
DROP SEQUENCE SEQ4;
DROP SEQUENCE SEQ5;

--table 생성
CREATE TABLE TEST1 (
    NUM NUMBER(3) PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    TODAY DATE);
    
--구조확인
DESC TEST1;

--데이터 추가
INSERT INTO TEST1 VALUES (1,'CANDY',SYSDATE);--컬럼명 생략시 모든 컬럼을 순서대로 값을 넣는다
--PRIMARYY KEY 에 같은 값을 넣었을 경우 어떤 오류가 나오는지 확인하기
INSERT INTO TEST1 VALUES (1,'MIRA',SYSDATE);--오류확인하기 ,무결성 제약조건으로 코드번호가 뜬다
--이번에는 이름을 빼고 넣은 후 오류를 확인해보자
INSERT INTO TEST1 (NUM,TODAY) VALUES (2,SYSDATE);--ORA-01400: NULL을 ("ANGEL"."TEST1"."NAME") 안에 삽입할 수 없습니다

--이번에는 전체 데이터를 넣는데 순서를 바꿔서 넣어보자
INSERT INTO TEST1 (NUM,TODAY,NAME) VALUES (2,'2024-11-20','MIRA');

--INSERT 를 2개 추가한 상태에서 ROLLBACK 을 해보자
ROLLBACK;
--다시 위의 INSERT 문 실행해서 넣어보자. 넣은 후 COMMIT 하기
COMMIT;
--COMMIT 을 한 후 ROLLBACK 해도 취소 안됨
ROLLBACK;
--데이터 확인
SELECT * FROM TEST1;

--TEST2 는 TEST1  과 같은데 제약조건이름을 추가해서 생성해보자
CREATE TABLE TEST2(
    NUM NUMBER(3) CONSTRAINT PK_TEST2_NUM PRIMARY KEY,
    NAME VARCHAR2 (20) CONSTRAINT NN_TEST2_NAME NOT NULL,
    TODAY DATE);
    
--오류 발생을 시켜보자
INSERT INTO TEST2 VALUES (1,'이영자',SYSDATE);--추가됨
INSERT INTO TEST2 VALUES (1,'김말자',SYSDATE);--오류발생,무결성 제약 조건(ANGEL.PK_TEST2_NUM)에 위배됩니다
SELECT * FROM TEST2;

--테이브의 구조변경, ALTER TABLE
--컬럼 추가 : ADD, 컬럼 삭제 : DROP COLUMN, 컬럼 수정 : MODIFY, 컬럼명 변경 : RENAME COLUMN

--TEST1 에 AGE NUMBER(3) 컬럼 추가하기
ALTER TABLE TEST1 ADD AGE NUMBER(3);

--TEST1 에 ADDR VARCHAR2(30) 추가하는데 기본값 SEOUL로 주고싶다
ALTER TABLE TEST1 ADD ADDR VARCHAR2(30) DEFAULT 'SEOUL';

--TEST1 에 GAIODAY DATE 으로 추가하는데 기본값을 현재 날짜로
ALTER TABLE TEST1 ADD GAIPDAY DATE DEFAULT SYSDATE;

--TEST1 의 TODAY 컬럼 삭제하기
ALTER TABLE TEST1 DROP COLUMN TODAY;

--TEST1 의 NAME 의 길이를 20에서 30으로 수정해보자
ALTER TABLE TEST1 MODIFY NAME VARCHAR2(30);
기
--TEST1 의 ADDR 을 ADDRESS 로 컬럼명을 변경해보자
ALTER TABLE TEST1 RENAME COLUMN ADDR TO ADDRESS;

--test1 의 gaipday 를 writeday 로 이름변경
ALTER TABLE TEST1 RENAME COLUMN GAIPDAY TO WRITEDAY;

--test1 의 제약조건 중 sys_c008317 을 제거해보자
ALTER TABLE TEST1 drop constraint sys_c008317;

--test1 에 제약조건을 추가 : age 의 나이범위가 10~30으로, 제약조건명 : ck_test1_age
alter table test1 add CONSTRAINT CK_TEST1_AGE check(age>=10 and age<=30);

--age 에 범위를 벗어나게 추가해서 오류확인하기
INSERT INTO TEST1 (NUM,NAME,AGE) VALUES (3,'SON',34);--체크 제약조건(ANGEL.CK_TEST1_AGE)이 위배되었습니다

--5분 문제
--1. test2 에 blood varchar2(10) 초기값은 a로 추가하기

--2. test2 에서 today 컬럼 제거하기

--3. test2 의 name 을 sawon_name 으로 컬럼이름 변경하













