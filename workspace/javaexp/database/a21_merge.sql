/*
# merge
1. 개념
    1) 구조가 같은 두 개의 테이블을 비교하여 하나의 테이블로 합치기 위한 데이터 조작어
    2) when 절의 조건절에서 결과 테이블에 해당 행이 존재하면 update 명령문에 의해 새로운 값으로 수정
        그렇지 않으면 insert 명령문으로 새로운 행을 삽입
    3) 대량의 데이터를 분석하기 위한 업무에 유용
    4) 전자 상거래에서 상품정보를 등록하는데, 해당 상품이 등록되어 있으면 update로 상품정보가 수정이 되고, 
        상품이 등록되어 있지 않으면 상품정보를 수정처리되게 하는 경우에 사용된다.

2. 기본형식
    merge into 목적테이블명
    using 비교할 테이블 및 subquery
    on 두 테이블의 비교 조건
    when matched then
        비교조건이 일치할 때, 수정 구문 처리
    when not matched then
        비교조건이 일치하지 않을 때, 등록 구문 처리
*/
CREATE TABLE emp031
AS SELECT * FROM emp;
SELECT * FROM emp031;

CREATE TABLE emp041
AS SELECT * FROM emp WHERE deptno = 10;
SELECT * FROM emp041;

-- 사원번호 기준으로 해당 데이터가 있으면 수정 처리, 데이터가 없으면 등록 처리
--# merge를 쓰지 않을 때
-- 1) 임시테이블을 만든다. - 등록할 정보를 설정..
-- 2) 수정 처리
SELECT * FROM emp031;
UPDATE emp031
    SET ename = '김길동'
WHERE empno=7782;
-- 3) 등록 처리
INSERT INTO emp03 values(8001, '이길동', '사원', 7782, sysdate, 3000, NULL, 20);
--# merge를 사용할 때 ..
-- 1) 임시테이블 만들기
-- 2) merge를 통한 조건 처리
-- 3) 조건이 true일 때, 처리할 내용
-- 4) 조건이 false일 때, 처리할 내용
    SELECT * FROM emp041; -- 입력 또는 수정할 정보가 있는 테이블
    SELECT * FROM emp031 ORDER BY deptno;
merge INTO emp031 t
USING emp041 s
on(t.empno = s.empno)
WHEN MATCHED THEN -- empno가 있을 때
    UPDATE SET t.ename = s.ename
WHEN NOT MATCHED THEN -- empno가 없을 때
    INSERT values(s.empno, s.ename, s.job, s.mgr, s.hiredate, s.sal, s.comm, s.deptno);
-- ex1) emp061(등록/수정할 테이블),
CREATE TABLE emp051
AS SELECT * FROM emp WHERE deptno=20;
CREATE TABLE emp061
AS SELECT * FROM emp;
SELECT * FROM emp061;
SELECT * FROM emp051;
-- ex)
merge INTO emp051 t
USING emp061 s
on(t.empno = s.empno)
WHEN MATCHED THEN
    UPDATE SET t.ename = s.ename
WHEN NOT MATCHED THEN
    INSERT values(s.empno, s.ename, s.job, s.mgr, s.hiredate, s.sal, s.comm, s.deptno);
-- 입력하는 데이터에서 사원번호가 있을 때는 수정이 되고, 사원번호가 없을 때는 등록 처리
-- 1. 목적 테이블 선언
-- 2. 입력할 가상 테이블 dual 활용 입력/수정 내용 설정
-- 3. merge into 처리
CREATE TABLE emp071
AS SELECT * FROM emp;
SELECT * FROM emp071;
-- empno가 있는 경우
SELECT 7369 empno, '홍길동' ename, '사원' job, 7902 mgr, sysdate hiredate, 2000 sal, 100 comm, 10 deptno
FROM dual;
-- empno가 없는 경우
SELECT 8001 empno, '오영심' ename, '대리' job, 7902 mgr, sysdate hiredate, 4000 sal, 100 comm, 10 deptno
FROM dual;
MERGE INTO emp071 t
USING (SELECT 7369 empno, '홍길동' ename, '사원' job, 7902 mgr, sysdate hiredate, 2000 sal, 100 comm, 10 deptno
FROM dual) s
ON (t.empno = s.empno)
WHEN MATCHED THEN
    UPDATE SET t.ename = s.ename,
               t.job = s.job,
               t.mgr = s.mgr,
               t.hiredate = s.hiredate,
               t.sal = s.sal,
               t.comm = s.comm,
               t.deptno = s.deptno
WHEN NOT MATCHED THEN
    INSERT values(s.empno, s.ename, s.job, s.mgr, s.hiredate, s.sal, s.comm, s.deptno);
SELECT * FROM emp071;
MERGE INTO emp071 t
USING (SELECT 8001 empno, '오영심' ename, '대리' job, 7902 mgr, sysdate hiredate, 4000 sal, 100 comm, 10 deptno
FROM dual) s
ON (t.empno = s.empno)
WHEN MATCHED THEN
    UPDATE SET t.ename = s.ename,
               t.job = s.job,
               t.mgr = s.mgr,
               t.hiredate = s.hiredate,
               t.sal = s.sal,
               t.comm = s.comm,
               t.deptno = s.deptno
WHEN NOT MATCHED THEN
    INSERT values(s.empno, s.ename, s.job, s.mgr, s.hiredate, s.sal, s.comm, s.deptno);
SELECT * FROM emp071;