/*
# 데이터 조작어
1. DML(Data Manipulation Language)
    테이블에 새로운 데이터를 입력하거나 기존 데이터를 수정 또는 삭제하기 위한 명령어
2. 종류
    1) insert : 새로운 데이터 입력 명령어
    2) update : 기존 데이터 수정 명령어
    3) delete : 기존 데이터 삭제 명령어
    4) merge : 두개의 테이블을 하나의 테이블로 병합하는 명령어
3. 트랜잭션
    여러개의 명령문을 하나의 논리적인 작업단위로 처리하는 기능
    트랜잭션 관리 명령어
        - commit : 트랜잭션의 정상적인 종료를 위한 명령어
        - rollback : 트랜잭션의 비정상적인 중단을 위한 명령어
# 데이터 입력
1. 테이블에 데이터를 입력하기 위한 명령인 insert 명령문 사용
2. 데이터 입력 방법
    1) 단일 행 입력 : 한번에 하나의 행을 테이블에 입력하는 방법
    2) 다중 행 입력 : 서브쿼리를 이용하면 한번에 여러행을 동시에 입력하는 방법
3. 단일 행 입력방법
    1) 기본 명령문
        - 컬럼명 명시없이 : 전체 테이블에 데이터 입력
            insert into 테이블명 values(데이터1, ... 데이터n)
        
        - 컬럼명 명시하여 : 해당 컬럼에만 데이터 입력
            insert into 테이블명(컬럼명1, 컬럼명2)
                        values(데이터1, 데이터2);
    2) 사용 방법
*/
SELECT * FROM EMP_CP100;
-- 컬럼명 지정하지 않고 전체데이터 입력
--  초기에 테이블이 만들어진 순서와 데이터 유형대로 데이터를 입력 처리한다.
--  입력시 에러 check
-- 1. 전체 컬럼의 데이터를 입력 : 추후에 입력할 내용이면 null
-- 2. 순서와 type이 맞는지?
-- 3. 데이터가 크기가 맞는지?
INSERT INTO EMP_CP100 values(9999,'신길동','사원',7878,sysdate,3000,100,10);
-- 컬럼명 지정하여 해당 컬럼에 데이터 입력
INSERT INTO emp_cp100(empno, sal) values(9998,'오길동',3500);
SELECT * FROM EMP_CP100;
-- # 입력시 에러 CHECK
-- 1. 명시된 컬럼명에 순서와 type, 크기에 맞게 values값을 할당하여야 한다.
CREATE TABLE emp_cp102
AS SELECT empno, ename, sal
FROM emp
WHERE 1=0; -- 테이블의 구조만 복사하여 테이블이 만들어진다.
SELECT * FROM emp_cp102;
-- ex1)
INSERT INTO emp_cp102 values(null,null,null);
-- ex2)
INSERT INTO emp_cp102(empno, sal) values(null,null);
/*
# null 데이터 입력
1. 명시적으로 null 데이터 입력
    지정한 또는 전체 테이블을 입력할 때, null로 명시적으로 데이터를 입력 처리
2. 묵시적으로 null데이터 입력
    지정한 컬럼만 데이터를 입력하는 경우, 그 외에 컬럼은 null로 입력이 된다.
*/
SELECT * FROM emp_cp100;
INSERT INTO emp_cp100 values(7781, '오길동', NULL, NULL, NULL, 3000, NULL, null);
INSERT INTO emp_cp100(empno, ename) values(9997, '하길동');
/*
# 날짜 데이터 입력 방법
1. 날짜는 고유의 날짜 타입이 있기에 이를 기본적으로 문자나 숫자로 바로 입력을 할 수 없다.
2. to_date() 함수를 이용해서 지정한 형식으로 문자열을 통해 입력이 가능하다.
3. 기본형식
    to_date('문자열데이터', '지정한형식')
*/
INSERT INTO emp_cp100(empno, hiredate) 
    values(1002, to_date('2022-05-25','YYYY-MM-DD'));
SELECT *
FROM emp_cp100
WHERE empno = 1003;
INSERT INTO emp_cp100(empno, hiredate)
    value(1003, sysdate);
SELECT * FROM emp_cp100;
-- ex1)
INSERT INTO emp_cp100 VALUES(
    1004, '마길동', '사원', 7839, sysdate, 3000, 100, 10
);
-- 현재년도와 월을 sysdate를 통해서 가져오고 날짜는 지정된 날짜로 처리할 때, 아래 형식을 활용한다.
SELECT to_char(sysdate,'YYYY/MM')||'/10' FROM dual;
INSERT INTO emp_cp100 values(
    1005, '오길동','사원',7839,
    to_date(to_char(sysdate,'YYYY/MM')||'/10', 'YYYY/MM/DD'),
        3000, 100, 10
)

-- ex2)
INSERT INTO emp_cp100(empno, ename, hiredate, sal)
    VALUES(1000, '홍길동', sysdate, 800);