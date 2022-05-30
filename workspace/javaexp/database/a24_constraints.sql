/*
# 데이터 무결성 제약조건
1. 개념
    1) 데이터의 정확성과 일관성을 보장
    2) 데이터의 정확성을 유지하여 다양한 종류의 업무규칙 고려한 예
        - student 테이블에서 학년 데이터는 1,2,3,4 중의 하나의 값만 입력
        - 모든 학번은 유일
        - student 테이블의 지도교수 번호는 professor 테이블의 교수 번호중의 하나와 반드시 일치
2. 장점
    1) 테이블 생성시 무결성 제약조건을 정의 가능
    2) 테이블에 대한 정의, 데이터 딕션너리에 저장되므로 응용프로그램에서
        입력된 모든 데이터에 대해 동일하게 적용
    3) 제약조건을 활성화, 비활성화 할 수 있는 융통성
3. 무결성 제약조건의 종류
    # 제약조건의 이름을 붙일 때는 constraint 제약명
        컬럼명 데이터유형 [xonstraint 제약명] 제약조건keyword
        ex) studno number constraint student_no_pk primary key
    1) not null : 열이 null을 포함할 수 없음
    2) 고유키(unique key) : 테이블의 모든 행에서 고유한 값을 갖는 열 또는 열조합을 지정
    3) 기본키(primary key) : 해당 컬럼 값은 반드시 존재해야 하며 유일해야 함.
        unique not null 제약조건을 결합한 형태
    4) 참조키(foreign key) : 한열과 참조된 테이블의 열간에 외래 키 관계를 설정하고 시행합니다.
    5) check : 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건 지정.
        기본형식
        컬럼명 데이터유형 constraint 제약명 check(컬럼명 in(데이터1, 데이터2))
*/
-- 1. 기본키 생성 예제 : 동일한 데이터 입력 불가, null 입력 불가
CREATE TABLE student011(
    studno char(5) PRIMARY key
);
SELECT * FROM student011;
INSERT INTO student011 values('10001');
INSERT INTO student011 values(null);
-- ex)
CREATE TABLE student021(
    studno char(5) PRIMARY key,
    stuname varchar2(50)
);
SELECT * FROM student021;
INSERT INTO student021 values('10001', '홍길동');
INSERT INTO student021 values('10002', null);
INSERT INTO student021 values(null, '김길동');
INSERT INTO student021 values('10003', '신길동');
INSERT INTO student021 values('10004', '이길동');
DROP TABLE student031;
-- not null : 동일한 데이터의 입력은 가능하나 반드시 데이터를 입력 처리하여야 한다.
CREATE table student031(
    studno NUMBER PRIMARY KEY,
    name varchar2(50) NOT NULL -- 이름을 NOT null로 설정..
);
SELECT * FROM student031;
INSERT INTO student031 values(1000, '홍길동');
INSERT INTO student031 values(1001, '김길동');
INSERT INTO student031 values(1002, '홍길동');
INSERT INTO student031 values(1003, null);
-- ex) 
CREATE table student041(
    name varchar2(50) NOT NULL,
    score NUMBER NOT NULL
);
SELECT * FROM student041;
INSERT INTO student041 values ('홍길동', 98);
INSERT INTO student041 values ('김길동', 78);
INSERT INTO student041 values (null, 70); -- x
INSERT INTO student041 values ('홍길동', null); -- x
-- unique : 중복데이터 입력 불가 처리, 단 null은 중복이 가능하다.
CREATE TABLE student051(
    NO NUMBER PRIMARY KEY,
    name varchar2(50) NOT NULL,
    civilnumber char(14) unique
);
INSERT INTO student051 values(1000, '홍길동', '921212-2801727');
INSERT INTO student051 values(1001, '김길동', '931212-2801727');
INSERT INTO student051 values(1002, '신길동', '941212-2801727');
INSERT INTO student051 values(1003, '오길동', null);
INSERT INTO student051 values(1004, '하길동', null);
INSERT INTO student051 values(1005, '신길동', null);
SELECT * FROM student051;
/*
    기본 형식
    컬럼명 데이터유형 constraint 제약명 check(컬럼명 in(데이터1, 데이터2))
    cf) check( 조건문의 구문 )
*/
-- 학생번호 학생명 남녀구분
CREATE TABLE student061(
    NO NUMBER,
    name varchar2(50),
    gender char(1) CONSTRAINT STUDENT061_gender_ck check( gender IN('M','F') )
);
INSERT INTO student061 values(1000, '홍길동', 'M');
INSERT INTO student061 values(1001, '신길동', 'M');
INSERT INTO student061 values(1002, '홍영자', 'F');
INSERT INTO student061 values(1003, '하길동', null); -- O
INSERT INTO student061 values(1004, '마길동', 'K'); -- X null과 지정된 문자열만 입력가능
SELECT * FROM student061;
-- ex)
CREATE TABLE product221(
    NO NUMBER,
    name varchar2(50),
    price number check( price>=1 ),
    grade char(1) CONSTRAINT product221_grade_ck check( grade IN('A','B','C') )
);
INSERT INTO product221 values(1, '연필', 1200, 'C');
INSERT INTO product221 values(2, '샤프', 1500, 'D'); -- 등급도 A~C까지만 입력가능
INSERT INTO product221 values(3, '지우개', 200, 'B');
INSERT INTO product221 values(4, '만년필', 20000, 'A');
INSERT INTO product221 values(4, '만년필', 0, 'A'); -- 가격은 1이상
INSERT INTO product221 values(4, '만년필', null, 'A'); -- null은 입력가능
SELECT * FROM product221;
-- foreign key : 외래키 관계 설정.. - 다른 테이블에 있는 특정 컬럼의 데이터만 입력가능하게 설정할 때, 활용된다.
-- ex) 사원정보의 부서번호는 부서테이블의 부서번호만 입력이 가능하다.
drop table professor;
CREATE TABLE professor(
    NO NUMBER PRIMARY key,
    name varchar2(50)
);
INSERT INTO PROFESSOR VALUES (10, '홍길동');
INSERT INTO PROFESSOR VALUES (20, '김길동');
INSERT INTO PROFESSOR VALUES (30, '신길동');
SELECT * FROM PROFESSOR;
CREATE TABLE STUDENT071(
    NO NUMBER,
    name varchar2(50),
    adno NUMBER REFERENCES professor(no)
);
INSERT INTO STUDENT071 values(1000, '김영수', 10);
INSERT INTO STUDENT071 values(1001, '오영수', 20);
INSERT INTO STUDENT071 values(1002, '한영수', 40);
SELECT * FROM student071;