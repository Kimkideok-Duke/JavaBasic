/*
# 집합 연산자
1. 테이블을 구성하는 행집합에 대해 테이블의 부분 집합을 결과로 변환하는 연산자.
2. 잡합 연산의 대상이 되는 두 테이블의 컬럼 수가 같고, 대응되는 컬럼까지 데이터 타입이 동일할 때 활용된다.
3. 기본 형식
    select 명령문1
    union, union all, intersect, minus
    select 명령문2
4. 집합 연산자 종류
    1) union : 두 집합에 대해 중복되는 행을 제외한 합집합
    2) union all : 두 집합에 대해 중복되는 행을 포함한 합집합
    3) minus : 두 집합간의 차집합
    4) intersect : 두 집합간의 교집합
*/

CREATE TABLE emp_cp100
AS SELECT * FROM emp
WHERE deptno = 10;
SELECT * FROM emp_cp100;
INSERT INTO emp_cp100 values(7999, '홍길동', '사원', 7839, sysdate, 3000, NULL, 40)
-- 중복데이터를 제거한 데이터 : union
SELECT empno, ename FROM emp
UNION
SELECT empno, ename FROM emp_cp100;
-- 중복데이터를 제거한 데이터 : union all
SELECT empno, ename FROM emp
UNION ALL
SELECT empno, ename FROM emp_cp100;
-- 차집합 처리 : minus
SELECT empno, ename FROM emp
MINUS
SELECT empno, ename FROM emp_cp100;
-- 교집합 처리 : intersect
SELECT empno, ename FROM emp
intersect
SELECT empno, ename FROM emp_cp100;