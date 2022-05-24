/*
# subquery
1. 개요
    하나의 sql 명령문의 결과를 다른 sql명령문에 전달하기 위해 두개 이상의 sql명령문을 
    하나의 sql 명령문으로 연결하여 처리하는 방법을 말한다.
2. sub쿼리의 필요성
    1) 사원정보에서 급여의 최고인 정보를 가져올 때 ,
        - 급여가 최고인 정보를 sql 처리
        - 그 결과를 조회 조건으로사원 정보를 검색 처리
3. 처리 과정
    1) 서브 쿼리는 메인 쿼리가 실행되기 전에 한번씩 실행되고,
    2) 서브 쿼리에서 실행된 결과가 메인 쿼리에 전달되어 최종적인 결과를 출력 처리
*/
-- ex1)
SELECT *
FROM emp
WHERE sal = (
    SELECT min(sal)
    FROM emp
);
-- ex2)
SELECT *
FROM emp
WHERE hiredate = (
    SELECT max(hiredate)
    FROM emp
);

-- 급여가 최고인 사원의 정보(사원 모든 컬럼)를 출력하세요
-- 1) 최고 급여
-- 2) 그 급여와 동일한 급여 조회
SELECT * FROM emp;
SELECT max(sal)
FROM emp;
SELECT *
FROM EMP e
WHERE sal = (
    SELECT max(sal)
    FROM emp
);
/*
# subquery의 종류 : subquery를 통해 결과가 행이 1개인 경우와 여러 개인 경우로 나누어서 사용할 수 있다.
1. 단일행 서브쿼리
    1) 서브쿼리에서 단 하나의 행만을 검색하여 메인쿼리에 반환하는 질의문
    2) 메인쿼리의 where절에서 서브쿼리의 결과와 비교할 경우에는 반드시 단일행 비교 연산자중 하나만 사용해야 함.
        - 단일행 비교 연산자 : =. >, >=, <, <>, <=
    3) 서브쿼리의 결과로 하나의 행만이 출력되어야 함
        - 방법1 : 서브쿼리의 조건절에서 기본 키나 고유 키를 '=' 비교하는 방식
        - 방법2 : 서브쿼리의 select절에서 전체 집합을 대상으로 그룹함수 사용
2. 복합행 서버쿼리
*/
-- 방법1
SELECT * FROM emp;
SELECT * FROM dept;
-- 부서명이 SALES인 부서번호를 검색
-- 그 부서정보와 동일한 사원들 검색
SELECT *
FROM emp
WHERE deptno = (
    SELECT deptno
    FROM dept
    WHERE dname = 'SALES'
);
-- 방법2
SELECT *
FROM EMP e
WHERE deptno = (
    SELECT min(deptno)
    FROM dept
);
-- 평균급여가 높은 사원정보를 출력
-- 1) 평균급여
SELECT avg(sal)
FROM emp;
-- 2) 급여 초과 정보 검색
SELECT *
FROM emp
WHERE sal > (
    SELECT avg(sal)
    FROM emp
);
-- 평균 급여 이하의 사원 정보
SELECT *
FROM emp
WHERE sal <= (
    SELECT avg(sal)
    FROM emp
);
-- ex1) 
SELECT *
FROM emp
WHERE sal > (
    SELECT max(sal)
    FROM emp
    WHERE deptno = 30
);
-- ex2)
SELECT *
FROM emp
WHERE sal < (
    SELECT avg(sal)
    FROM emp
    WHERE job = 'CLERK'
);
/*
# 다중행 서브쿼리(복합행 서브쿼리)
1. 서브쿼리에서 반환되는 결과 행이 하나 이상일때 사용하는 서브쿼리
2. 메인쿼리의 WHERE 절에서 서브쿼리의 결과와 비교할 경우에는 다중 행 비교 연산자를 사용하고 비교
3. 다중행 비교 연산자
    IN() : 메인 쿼리의 비교 조건이 서브쿼리의 결과중에서 하나라도 일치하면 참, '=' 비교만 가능
    ANY(), SOME() : 메인 쿼리의 비교 조건이 서브 쿼리의 결과 중에서 하나라도 일치하면 참, '=' 비교만 가능
    ALL() : 메인 쿼리의 비교조건이 서브쿼리의 결과 중에서 모든 값이 일치하면 참
    EXIST() : 메인 쿼리의 비교 조건이 서브쿼리의 결과 중에서 만족하는 값이 하나라도 존재하면 참.
*/
-- ANY, SOME()
SELECT sal
FROM emp
WHERE deptno = 20;
SELECT *
FROM EMP
WHERE sal > any(
    SELECT sal
    FROM emp
    WHERE deptno = 20
);
SELECT *
FROM emp
WHERE sal > all(
    SELECT sal
    FROM emp
    WHERE deptno = 20
);
SELECT *
FROM EMP
WHERE sal > (
    SELECT max(sal)
    FROM emp
    WHERE deptno=20
);
/*
# exists 연산자를 이용한 다중행 서브 쿼리
1. 서브쿼리에서 검색된 결과가 하나라도 존재하면 메인쿼리 조건절이 참이 되는 연산자
2. 서브쿼리에서 검색된 결과가 존재하지 않으면 메인쿼리의 조건절은 거짓
    - 선책된 레코드가 없습니다라는 메시지 존재
3. not exists
    1) exists와 상반되는 연산자
    2) 서브쿼리에서 검색된 결과가 하나도 존재하지 않으면 메인쿼리의 조건절이 참이 되는 연산자.
*/
-- 관리자 번호가 null인것이 존재할 때, 사원 정보를 조회하라
SELECT * FROM emp;