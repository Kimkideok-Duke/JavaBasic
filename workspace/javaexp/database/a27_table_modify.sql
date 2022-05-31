/*
# 테이블의 컬럼 변경
1. 기능
    1) 테이블에서 컬럼의 타입, 크기, 기본 값 변경 가능
    2) 기본형식
        alter table 테이블명 modify
    3) 기존 컬럼에 데이터가 없는 경우
        컬럼의 타입이나 크기 변경이 자유로움
    4) 기존 컬럼에 데이터가 존재하는 경우
        - 타입 변경은 char와 varchar2만 허용
            다른 유형까지 변경 문자열 ==> 숫자, 숫자 ==> 문자,
                날짜형 ==> 문자열은 불가능하다.
        - 문자열일 경우 변경한 컬럼의 크기가 저장된 데이터의 크기보다 같거나 클 경우 변경 가능
            실제 저장된 데이터 기준
            varchar2(최대크기) : 저장할 수 있는 최대 크기를 지정하는 것이기에
                varchar2(50) ==> varchar2(10)으로도 변경이 가능한데, 해당하는 컬럼에
                저장된 데이터의 최고 크기가 10byte이하일 때 가능하다.
        - 숫자 타입에서는 정밀도 증가 가능
    5) 기본 값의 변경은 변경 후에 입력되는 데이터부터 적용
*/
-- 데이터가 없는 경우
SELECT * FROM emp1101;
-- 1) 다른 유형으로 변경이 가능
ALTER TABLE emp1101
MODIFY loc NUMBER;
UPDATE emp1101
    SET dname = '부서(초기)';
-- 데이터가 있는 경우
-- ALTER TABLE emp1101
-- MODIFY loc number; (X)
--  1) 숫자형 ==> 문자열 변경 안됨..
--  2) 문자형 ==> 숫자형 변경 안됨
--      ps)
ALTER TABLE emp1101
MODIFY loc varchar2(10);
-- 1) 숫자형 ==> 문자열 변경 안됨
ALTER TABLE emp1101
MODIFY dname varchar2(60);
-- 2) 문자열 ==> 문자열 : 더 크게 데이터 유형 변경 가능
SELECT * FROM emp1101;
SELECT max(LENGTHB(dname))
FROM emp1101;
ALTER TABLE emp1101
MODIFY dname varchar2(40);
-- 3) 문자열 ==> 문자열 : 작게도 변경이 가능한데, 저장된 문자열의 최대 byte 크기까지 가능하다.

SELECT * FROM EMP021;
-- ex)
SELECT max(LENGTHB(ename)) FROM emp021;
-- 저장된 데이터의 최대 byte수로 변경 처리
ALTER TABLE EMP021
MODIFY (ename varchar(6), job varchar2(8));
/*
# 컬럼명의 변경
1. 기본형식
    alter table 테이블명 rename column 원컬럼명 to 변경할 컬럼명
*/
SELECT * FROM emp021;
ALTER TABLE emp021
RENAME COLUMN empno TO NO;
/*
# 테이블(오라클 내장 객체)의 이름 변경
1. 기본 형식
    rname 명령문 사용
    ex) rename 이전 객체명 to 새로운 객체명
    1) 객체의 이름을 변경하는 DDL 명령문
    2) 뷰, 시퀀스, 동의어 등과 같은 데이터베이스 객체의 이름을 변경할 때도 동일하게 사용 가능
*/
RENAME emp021 TO emp000021;
SELECT * FROM emp000021;
/*
# 테이블 삭제
1. 기본 형식
    drop table 테이블명;
2. 제한 사항
    1) 삭제된 테이블과 관련된 뷰와 동의어는 invalid 상태.
    2) 삭제된 테이블의 기본 키나 고유키를 다른 테이블에서 참조하는 경우 삭제 불가능
        - 참조하는 테이블(자식 테이블)을 먼저 삭제
        - drop table 명령문 마지막에 cacade constraints 옵션을 사용하여 무결성 제약조건을 동시에 삭제
*/
DROP TABLE emo000021;
-- ex)
CREATE TABLE emp88881 FROM emp;
ALTER TABLE emp88881 rename column empno to no;
ALTER TABLE emp88881 drop column ename;
RENAME emp88881 to emp99991;
DROP TABLE emp99991;