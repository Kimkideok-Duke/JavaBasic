-- SMITH의 부서이름과 부서위치를 확인하기 위해서 join을 하지 않는 경우
SELECT ename, deptno
FROM emp
WHERE ename = 'SMITH';
-- 20
SELECT *
FROM dept
WHERE deptno = 20;
SELECT e.*, d.*
FROM emp e, dept d
WHERE e.deptno = d.deptno;
-- 두개의 테이블은 deptno(부서번호)를 기준으로 연관관계로 설정하기에
-- e.deptno = d.deptno; 사원테이블의 부서번호와 부서테이블의 부서번호를 조인을 하여 확인한다.
/*
# 조인(join)
1. 조인의 개념
    1) 하나의 sql명령문에 의해 여러 테이블에 저장된 데이터를 한번에 조회할 수 있는 기능을 말한다.
    2) 관계형 데이터베이스 분야의 표준
    3) 두개 이상의 테이블을 결합 한다는 의미
2. 조인의 필요성
    1) 조인을 사용하지 않는 일반적인 예
        학생 주소록을 출력하기 위해 학생들의 학번, 이름, 소속학과 이름을 검색
        학생에 대한 정보 검색하는 단계 필요
        학생 정보에서 소속학과 번호 정보를 추출하여 소속학과 이름을 검색하는 단계 필요
        ex) 사원번호가 7369인 사원의 이름과 부서이름, 부서위치를 출력하라.
            - 사원정보에서 부서번호를 가져온다.
            - 부서정보에서 부서이름과 부서위치를 가져온다.
    2) 조인을 하는 경우
        - 연관관계에 있는 deptno를 조회조건을 검색을 하면 한번에 원하는 데이터를 가져올 수 있다.
*/
SELECT *
FROM emp
WHERE empno = 7369;
SELECT *
FROM dept
WHERE deptno = 20;
SELECT e.*, d.*
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND empno = 7369;
SELECT *
FROM emp;
-- ex)
SELECT *
FROM emp
WHERE ename = 'ALLEN';
SELECT *
FROM dept
WHERE deptno = 30;
SELECT e.*, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND ename = 'ALLEN';

SELECT d.dname, d.loc, e.*
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND sal>=3000;

SELECT e.*, d.*
FROM emp e, dept d;
-- 카티션곱 조인 : 부서번호 10, 사원정보 13개 다 표시, 부서 20 사원정보 13개 다 표시
