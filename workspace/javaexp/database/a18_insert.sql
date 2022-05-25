/*
# 다중 행 입력
1. 기본 형식
    insert 명령문에서 서브쿼리 절을 이용
    insert 명령문에 의해 한번에 여러행을 동시에 입력
    9i 버젼 이후
        insert all
        first insert
2. 단일 테이블에 다중 행 입력 방법
    1) insert 명령문에서 서브쿼리 절을 이용하여 자신이나 다른 테이블에 데이터를 복사하여 여러행을 동시에 입력
    2) insert 명령문의 values 절 대신 서브쿼리에서 검색된 결과 집합을 한꺼번에 입력
    3) 서브쿼리의 결과 집합은 insert 명령문에 지정된 컬럼갯수와 데이터 타입이 일치해야 함.
    4) 서브쿼리를 이용한 다중 행 입력시 테이블에 기본키, 고유키, 제약조건이 중복되지 않도록 주의
    5) 제약 조건을 위반할 경우 입력되지 않고 오류 발생
3. 활용 방법
    INSERT INTO 테이블(컬럼1, 컬럼2..)
    subquery
*/
CREATE TABLE EMP_CP103
AS SELECT * FROM emp WHERE 1=0;
SELECT * FROM EMP_CP103;
INSERT INTO EMP_CP103
select * FROM emp WHERE deptno = 30;

INSERT INTO EMP_CP103(empno,ename)
select empno, ename FROM emp WHERE deptno = 10;
SELECT * FROM EMP_CP103;
-- ex)
CREATE TABLE EMP_CP104
AS SELECT * FROM emp WHERE 1=0;
SELECT * FROM EMP_CP104;
INSERT INTO EMP_CP104
select * FROM emp WHERE sal BETWEEN 1000 AND 3000;
SELECT * FROM EMP_CP104;
INSERT INTO EMP_CP104(empno, ename, job, sal)
select empno, ename, job, sal FROM emp WHERE job = 'SALESMAN';
SELECT * FROM EMP_CP104;

/*
# 다중행 입력 insert all
1. 조회된 내용을 한번에 여러테이블에 입력 처리
2. 내용
    서브쿼리의 결과 집합을 조건없이 여러 테이블에 동시에 입력
    서브 쿼리의 컬럼 이름과 데이터가 입력되는 테이블의 컬럼이 반드시 동일하여야 함
        - 갯수, 유형과 크기가 입력이 가능하여야 함
3. 기본형식
    insert all || first
    into 테이블1 values(컬럼1, 컬럼2...)
    into 테이블2 values(컬럼1, 컬럼2...)
    into 테이블3 values(컬럼1, 컬럼2...)
    into 테이블. values(컬럼1, 컬럼2...)
    subquery
    1) all : 서브쿼리의 결과 집합을 해당하는 insert절에 모두 입력
    2) first : 서브쿼리의 결과 집합을 해당하는 첫번째 insert절에 입력
    3) subquery : 입력 데이터 집합을 정의하기 위한 서브쿼리
*/
CREATE TABLE EMP_CPY201
AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE EMP_CPY202
AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE EMP_CPY203
AS SELECT * FROM emp WHERE 1=0;
SELECT * FROM EMP_CPY201;
SELECT * FROM EMP_CPY202;
SELECT * FROM EMP_CPY203;
INSERT ALL
INTO EMP_CPY201(empno, ename, job) values(empno, ename, job)
INTO EMP_CPY202(empno, ename, job) values(empno, ename, job)
INTO EMP_CPY203(empno, ename, job) values(empno, ename, job)
SELECT empno, ename, job
FROM emp
WHERE deptno = 10;

-- ex)
DELETE FROM EMP_CPY301;
CREATE TABLE EMP_CPY301
AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE EMP_CPY302
AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE EMP_CPY303
AS SELECT * FROM emp WHERE 1=0;
SELECT * FROM EMP_CPY301;
SELECT * FROM EMP_CPY302;
SELECT * FROM EMP_CPY303;
INSERT ALL
INTO EMP_CPY301(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
INTO EMP_CPY302(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
INTO EMP_CPY303(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
SELECT *
FROM emp
WHERE deptno = 20;

/*
INSERT FIRST
조건절1
INTO 테이블 values(데이터...)
조건절2
INTO 테이블 values(데이터...)
조건절3
INTO 테이블 values(데이터...)
subquery 처리

ex) 사원정보중에 급여가 4000이상인 데이터는 테이블1에 입력,
    급여가 2000~4000미만 테이블2에 입력
    그외는 테이블3에 입력
*/
CREATE TABLE EMP_CPY401 AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE EMP_CPY402 AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE EMP_CPY403 AS SELECT * FROM emp WHERE 1=0;
SELECT * FROM EMP_CPY401;
INSERT FIRST
    WHEN sal>=4000 THEN
        INTO EMP_CPY401(empno, ename, sal) values(empno, ename, sal)
    WHEN sal>=2000 THEN
        INTO EMP_CPY402(empno, ename, sal) values(empno, ename, sal)
    ELSE
        INTO EMP_CPY403(empno, ename, sal) values(empno, ename, sal)
SELECT empno, ename, sal
FROM emp;
SELECT * FROM EMP_CPY401;
SELECT * FROM EMP_CPY402;
SELECT * FROM EMP_CPY403;
-- ex)
CREATE TABLE EMP_CPY501 AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE EMP_CPY502 AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE EMP_CPY503 AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE EMP_CPY504 AS SELECT * FROM emp WHERE 1=0;
SELECT * FROM EMP_CPY501;
INSERT FIRST
    WHEN (to_char(hiredate,'Q')) = 1 THEN
        INTO EMP_CPY501(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
    WHEN (to_char(hiredate,'Q')) = 2 THEN
        INTO EMP_CPY502(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
    WHEN (to_char(hiredate,'Q')) = 3 THEN
        INTO EMP_CPY503(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
    WHEN (to_char(hiredate,'Q')) = 4 THEN
        INTO EMP_CPY504(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
SELECT *
FROM emp;
SELECT * FROM EMP_CPY501;
SELECT * FROM EMP_CPY502;
SELECT * FROM EMP_CPY503;
SELECT * FROM EMP_CPY504;