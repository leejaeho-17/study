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
ALTER TABLE TEST1 DROP CONSTRAINT SYS_C008317;

--test1 에 제약조건을 추가 : age 의 나이범위가 10~30으로, 제약조건명 : ck_test1_age
ALTER TABLE TEST1 ADD CONSTRAINT CK_TEST1_AGE CHECK(AGE>=10 AND AGE<=30);

--age 에 범위를 벗어나게 추가해서 오류확인하기
INSERT INTO TEST1 (NUM,NAME,AGE) VALUES (3,'SON',34);--체크 제약조건(ANGEL.CK_TEST1_AGE)이 위배되었습니다

-- 5분 문제
--1 TEST2  에 BLOOD VARCHAR2(10) 초기값은 A 로 추가하기
ALTER TABLE TEST2 ADD BLOOD VARCHAR2(10) DEFAULT 'A';
--2.TEST2 에서 TODAY 컬럼 제거하기
ALTER TABLE TEST2 DROP COLUMN TODAY;
--3. TEST2 의 NAME을 SAWON_NAME 으로 컬럼이름 변경하기
ALTER TABLE TEST2 RENAME COLUMN NAME TO SAWON_NAME;

--4. BLOOD 에 제약조건 추가(A,B,O,AB 만 가능하도록 CHECK) CK_TEST2_BLOOD
ALTER TABLE TEST2 ADD CONSTRAINT CK_TEST2_BLOOD CHECK(BLOOD IN ('A','B','O','AB'));
--5. NN_TEST2_NAME 이라는 제약조건을 제거하기
ALTER TABLE TEST2 DROP CONSTRAINT NN_TEST2_NAME;

--연습용 테이블 제거하기
DROP TABLE TEST1;
DROP TABLE TEST2;
---------------------------------------------------
--시퀀스 생성
CREATE SEQUENCE SEQ1 NOCACHE;--1부터 1씩 증가하는 cache 가 없는 시퀀스 생성
--테이블 생성
CREATE TABLE SAWON (
    NUM NUMBER(3) CONSTRAINT PK_SAWON_NUM PRIMARY KEY,
    NAME VARCHAR2(20),
    BUSEO VARCHAR2(20),
    GENDER VARCHAR2(10) DEFAULT '남자',
    AGE NUMBER(3),
    HEIGHT NUMBER(5,1),
    WRITEDAY DATE);
    
--제약조건 추가: 부서명은 '홍보부','교육부','관리부' 만 가능하다 ck_sawon_buseo
ALTER TABLE SAWON ADD CONSTRAINT CK_SAWON_BUSEO CHECK(BUSEO IN('홍보부','교육부','관리부'));
--제약조건 추가: 성별은 '남자',여자' 만 가능하다 ck_sawon_gender
ALTER TABLE SAWON ADD CONSTRAINT CK_SAWON_GENDER CHECK(GENDER IN('남자','여자'));

--데이터 추가
INSERT INTO SAWON VALUES (SEQ1.NEXTVAL,'이진','홍보부','여자',29,167.9,SYSDATE);
INSERT INTO SAWON (NUM,NAME,BUSEO,AGE) VALUES (SEQ1.NEXTVAL,'강호동','관리부',35);
INSERT INTO SAWON (NUM,NAME,BUSEO,HEIGHT) VALUES (SEQ1.NEXTVAL,'유재석','홍보부',178.5);
INSERT INTO SAWON VALUES (SEQ1.NEXTVAL,'송해나','홍보부','여자',31,159.9,SYSDATE);
INSERT INTO SAWON (NUM,NAME,BUSEO,GENDER,AGE,WRITEDAY) VALUES (SEQ1.NEXTVAL,'이영자','교육부','여자',42,SYSDATE);
COMMIT;
SELECT * FROM SAWON;
DROP TABLE SAWON;

--수정 update
UPDATE SAWON SET HEIGHT정=186.5;--만약 where 조건을 안쓰면 전체 데이터가 수정된다
-- 다시 취소
ROLLBACK;

--num=3 인 경우만 수정
UPDATE SAWON SET HEIGHT=186.5 WHERE NUM=3;

--여러 컬럼을 수정하는 경우
UPDATE SAWON SET BUSEO='홍보부',AGE=39,HEIGHT=148 WHERE NAME='이영자';

--writeday 가 null 일경우 '2024-12-12'로 변경해보자
UPDATE SAWON SET WRITEDAY='2024-12-12' WHERE WRITEDAY IS NULL;

COMMIT;

--삭제 delete
DELETE FROM SAWON;--where 조건을 안쓴 경우 전체 데이터가 삭제됨

--age 가 null 인 데이터는 모두 삭제
DELETE FROM SAWON WHERE AGE IS NULL;

--group by 연습
--부서별 인원수와 평균 나이를 구하시오
SELECT BUSEO,COUNT(*) 인원수,AVG(AGE) 평균나이 FROM SAWON GROUP BY BUSEO;
--성별 인원수와 평균 나이를 구하시오
SELECT GENDER,COUNT(*) 인원수,AVG(AGE) 평균나이 FROM SAWON GROUP BY GENDER;
-----------------------------------------------------------------------
--join 연습용 테이블 생성하기
CREATE TABLE FOOD(
    FOODNUM NUMBER(3) PRIMARY KEY,
    FOODNAME VARCHAR2(20),
    FOODPRICE NUMBER(7),
    FOODSIZE VARCHAR2(20));

CREATE TABLE BOOKING (
    BNUM NUMBER(3) CONSTRAINT PK_BOOKING_BNUM PRIMARY KEY,
    BNAME VARCHAR2(20) CONSTRAINT NN_BOOKING_BNAME NOT NULL,
    BHP VARCHAR2(20) CONSTRAINT UQ_BOOKING_BHP UNIQUE,
    FOODNUM NUMBER(3),
    BOOKINGDAY DATE,
    CONSTRAINT FK_FOODNUM FOREIGN KEY(FOODNUM) REFERENCES FOOD(FOODNUM));
    
--메뉴 등록
insert into food values (100,'짜장면',9000,'보통');
insert into food values (101,'짜장면',11000,'곱배기');
insert into food values (200,'탕수육',15000,'보통');
insert into food values (201,'탕수육',20000,'곱배기');
insert into food values (300,'칠리새우',15000,'소');
insert into food values (301,'칠리새우',30000,'대');
insert into food values (401,'해물짬뽕',11000,'보통');
commit;
select * from food;

--시퀀스 생성
create sequence seq_food start with 10 increment by 10 nocache;

--예약
insert into booking values (seq_food.nextval,'이영자','010-1234-5678',200,'2024-12-24');
--오류발생시켜보기
insert into booking values (seq_food.nextval,'김말자','010-7777-5678',400,'2025-01-10');--400은 메뉴에 없음
--무결성 제약조건(ANGEL.FK_FOODNUM)이 위배되었습니다- 부모 키가 없습니다
insert into booking values (seq_food.nextval,'김말자','010-7777-5678',301,'2025-01-10');
insert into booking values (seq_food.nextval,'이효리','010-7327-5678',401,'2025-02-10');
insert into booking values (seq_food.nextval,'손예진','010-1273-5678',201,'2025-01-10');
commit;

 --inner join 으로 예약손님의 주문정보를 확인하자
 select
    bname,bhp,foodname,foodprice,foodsize,to_char(bookingday,'yyyy-mm-dd') bookingday
 from food f,booking b
 where f.foodnum=b.foodnum;
 
 --outer join 을 이용해서 한번도 주문하지 않은 메뉴들을 알아보자
 select
    f.foodnum,bname,foodname,foodprice,foodsize
 from food f,booking b
 where f.foodnum=b.foodnum(+);--아무도 주문하지 않은 메뉴는 주문자가 null 이 나온다
 
 --위의 sql 문을 이용해서 주문자 이름을 빼고 null 인 경우만 출력하면 아무도 주문하지 않은
 --메뉴만 골라낼 수 있다
 select
    f.foodnum,foodname,foodprice,foodsize
 from food f,booking b
 where f.foodnum=b.foodnum(+) and bname is null;
 
 --booking(자식테이블) 에 추가된 메뉴를 food(부모테이블) 에서 삭제할 수 있을까?
 --자식테이블 생성신 on delete cascade 설정을 안했을 경우는 못지운다
 delete from food where foodnum=200;--200번 메뉴는 이영자가 예약주문함, 그래서 삭제 불가
 --무결성 제약조건(ANGEL.FK_FOODNUM)이 위배되었습니다- 자식 레코드가 발견되었습니다
 
 delete from food where foodnum=300;--아무도 주문하지 않았으므로 삭제 가능
 
 --부모테이블을 삭제해보자
 drop table food;-- 삭제 안됨, 자식테이블을 먼저 삭제해야 부모테이블도 삭제가 가능
 





