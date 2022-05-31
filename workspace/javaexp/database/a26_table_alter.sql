/*
# 테이블 생성시 기타 옵션
1. default 옵션
    1) 컬럼의 입력 값이 생략될 경우에 null 대신에 입력되는 기본값을 지정하기 위한 기능
    2) 기본값 : 리터럴 값, 표현식, sql함수, sysdate, user 를 사용
    3) 칼럼이나 의사컬럼(nextval, currval)은 사용할 수 없음
    # 기본형식
    컬럼명 varchar2(100) default 'KOREA'
*/
DROP TABLE emp031;
CREATE TABLE emp031(
    NO NUMBER PRIMARY KEY,
    addr varchar2(50) default '대한민국'
);
-- 명시적으로 null을 입력처리하지 않고, 묵시적으로 null이 입력될 때, 처리
INSERT INTO emp031(no) values(seq01.nextval);
SELECT * FROM emp031;
/*
# subquery를 통해 테이블 생성
1. 컬럼 구조 + 데이터 복사
    create table 테이블명
    as select * from 테이블명;
2. 컬럼 구조만 복사
    create table 테이블명
    as select * from 테이블명 where 1=0;
3. 컬럼명 변경
    create table 테이블명
    as select 컬럼1 변경명1, 컬럼2 변경명2
    from 테이블명
4. 유형변경
    create table 테이블명
    as select 함수명(컬럼명) from 테이블명
*/
CREATE TABLE emp1101
AS SELECT * FROM emp;
SELECT * FROM emp1101; -- NOT NULL만 복사 그외 무결설 제약조건은 복사 안됨.
CREATE TABLE emp1111
AS SELECT * FROM emp WHERE 1=0;
-- where 1=0 조건이 false이기에 데이터가 나오지 않지만, 구조는 나오기에 그 구조가 복사된다.
SELECT * FROM emp1111;
CREATE TABLE emp1121
AS SELECT empno NO, ename name, sal salary
FROM emp;
SELECT * FROM emp1121;
CREATE TABLE emp1131
AS SELECT empno NO, to_char(hiredate, 'YYYY/MM/DD') hiredate,
    decode(deptno, 10, '인사', 20, '재무', 30, '회계', 'it사업부') dname
FROM emp;
SELECT * FROM emp1131;
-- ex)
DROP TABLE emp1141;
CREATE TABLE emp1141
AS SELECT empno NO, ename name, to_char(hiredate, 'Q')||'분기' "hiqua(입사분기)", to_char(hiredate, 'YYYY-MM-DD') "입사년-월-일"
FROM emp;
SELECT * FROM emp1141;
/*
# 테이블 구조 변경
1. 개요
    1) alter table 명령문 이용
    2) 컬럼 추가, 삭제, 타입이나 길이의 재정의와 같은 작업
        등록, 삭제, 이름변경
        add(컬럼명 옵션), modify(컬럼명 옵션), drop(컬럼명), rename column 컬럼명 to 컬럼명
2. 컬럼추가
    1) alter table add 명령문 사용
    2) 추가되는 컬럼은 테이블의 마지막 부분에 생성, 위치 지정 불가능
    3) 추가된 컬럼에 기본 값을 지정 가능
    4) 수정할 테이블에 기존 데이터가 존재하면 컬럼 값은 null로 입력
    5) 기본 형식
        alter table 테이블명
        add 컬럼명 데이터유형 default 디폴트 설정 데이터
3. 컬럼삭제
    1) alter table 테이블명 drop column 컬럼명
*/
SELECT * FROM emp1001;
ALTER TABLE emp1001
ADD (empno number);
ALTER TABLE emp1001
ADD (job varchar2(50) DEFAULT '직책없음');
ALTER TABLE emp1001
ADD (hiredate DATE, sal NUMBER, comm NUMBER);
ALTER TABLE emp1001 DROP COLUMN comm;
SELECT * FROM emp1001;
-- ex)
SELECT * FROM emp1101;
ALTER TABLE emp1101
ADD (dname varchar2(50), loc varchar2(50));
ALTER TABLE emp1101 DROP COLUMN deptno;
