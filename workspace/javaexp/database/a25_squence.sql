/*
# 시퀀스
1. 개요
    1) 유일한 식별자
    2) 기본 키 값을 자동으로 생성하기 위하여 일련번호 생성 객체
    ex) 웹 게시판에서 글이 등록되는 순서대로 번호를 하나씩 할당하여 기본키로 지정하고자 할 때, 시퀀스를 편리하게 이용
    3) 여러 테이블에서 공유 가능
2. 기본 형식
    create squence 시퀀스명
    increment by n
    start with n
    maxvalue n | nomaxvalue
    minvalue n | nominvalue
    cycle | nocycle
    cache N | nocache
    1) increment by n : 시퀀스 번호의 증가치로 기본은 1,
    2) start with n : 시퀀스 시작번호, 기본값은 1
    3) maxvalue n : 생성 가능한 시퀀스의 최대값
    4) minvalue n : 시퀀스 번호를 순환적으로 사용하는 cycle로 지정한 경우,
        maxvalue애 도달한 후 새로 시작하는 시퀀스 값
    5) cycle|nocycle : maxvalue 또는 minvalue에 도달한 후 시퀀스의 순환적인 시퀀스 번호의 생성 여부 지정
    6) cache | nocache : 시퀀스 생성 속도 개선을 위해 메모리에 캐쉬하는 시퀀스 갯수, 기본값은 20
*/
CREATE SEQUENCE seq01
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 10
    CYCLE
    cache 2;
SELECT seq01.nextval FROM dual;
-- ex1)
CREATE SEQUENCE seq021
    INCREMENT BY 1
    START WITH 1000
    MAXVALUE 9999
    MINVALUE 1000
    NOCYCLE;
SELECT seq021.nextval FROM dual;
-- ex2)
CREATE SEQUENCE seq022
    INCREMENT BY -2
    START WITH 8888
    MAXVALUE 8888
    MINVALUE 8880
    CYCLE
    cache 2;
SELECT seq022.nextval FROM dual;

CREATE TABLE student101(
    NO NUMBER PRIMARY KEY,
    kor number
)
CREATE SEQUENCE seq041
    INCREMENT BY 1
    START WITH 1000
    MINVALUE 1000
    MAXVALUE 9999;
INSERT INTO student101 values(seq041.nextval, 80);
SELECT * FROM student101;
-- ex) 
CREATE TABLE employee1001(
    empno NUMBER PRIMARY KEY,
    ename varchar2(50),
    dname varchar2(50)
);
CREATE SEQUENCE seq051
    INCREMENT BY 1
    START WITH 5000
    MAXVALUE 9999;
INSERT INTO employee1001 values(seq051.nextval, NULL, null);
SELECT * FROM employee1001;

CREATE TABLE employee1011(
    empno char(7) PRIMARY KEY,
    ename varchar2(50),
    dname varchar2(50)
);
-- empno를 문자와 조합하여 6자리로 만들 떄, 문자+sequence와 조합해서 primary key
-- 를 만들어 사용가능하다.
INSERT INTO employee1011 values('AK'||seq051.nextval,'채길동', '재무팀');
SELECT * FROM employee1011;
/*
# 시퀀스의 함수들
1. currval : 시퀀스에서 생성된 현재 번호를 확인
    현재 번호를 가져온다
    ex) 데이터를 두개 테이블을 입력시, 부서정보를 등록하고, 이 등록된 부서 정보의 deptno를 바로
     사원정보로 등록할 때, 활용될 수 있다.
2. nextval : 시퀀스에서 다음번호 생성
    증가 처리가 됨
*/
SELECT seq051.nextval, seq051.currval FROM dual;
CREATE TABLE dept1001(
    deptno NUMBER PRIMARY KEY,
    dname varchar2(50),
    loc varchar2(50)
);
CREATE TABLE emp1001(
    ename varchar2(50),
    deptno number
);
INSERT INTO dept1001 values(10, '인사', '서울강남');
INSERT INTO emp1001 values('홍길동', seq051.currval);
SELECT * FROM dept1001;
SELECT * FROM emp1001;
/**
# 시퀀스 정의 변경
1. 변경
    1) 시퀀스 생성 후 증가치, 최소값, 최대 값등의 정의를 수정
    2) 변경된 시퀀스 정의는 새로 생성되는 시퀀스 값부터 적용
    3) alter sequence 명령문을 사용하여 변경
    4) start with 절은 생성 직후의 시작값을 의미, 변경 불가
        ==> 시작값을 변경하기 위해서는 
            drop sequence 시퀀스명; (삭제명령어)
            다시 생성처리
2. 사용법
    alter sequence 시퀀스명
    increment by
    maxvlaue n | nomaxvalue
    minvlaue n | nominvalue
    cycle | nocycle
    cache n | nocache 
# 시퀀스의 삭제
drop sequence 시퀀스명
*/
SELECT seq051.nextval, seq051.currval FROM dual;
ALTER SEQUENCE seq051
    INCREMENT BY 2
    MINVALUE 4000;
DROP SEQUENCE seq051;
CREATE SEQUENCE seq051
    START WITH 4000
    INCREMENT BY 1
    MINVALUE 3000;
-- ex)
CREATE SEQUENCE seq061
    START WITH 1000
    MAXVALUE 9999
    MINVALUE 1000;
ALTER SEQUENCE seq061
    MAXVALUE 5555
    MINVALUE 600;
DROP SEQUENCE seq061;
CREATE SEQUENCE seq061
    START WITH 500
    MAXVALUE 8888
    MINVALUE 500;