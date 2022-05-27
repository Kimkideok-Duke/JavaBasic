/*
# 그룹함수란?
1. 테이블의 전체 행을 하나 이상의 컬럼을 기준으로 그룹화하여 그룹별로 결과를 출력하는 함수이다.
    그룹함수는 통계적인 결과를 출력하는데 자주 사용한다.
2. 사용법
    select 기준컬럼, 그룹함수(컬럼)
    from 테이블명
    [where]
    group by 그룹컬럼
    having 그룹함수를 적용한 결과를 조건처리.
*/
SELECT deptno, sal
FROM emp
ORDER BY deptno, sal;
SELECT deptno, max(sal) "최대급여"-- 부서번호를 그룸으로 만들어 부서정보별 최대 급여
FROM emp
GROUP BY deptno;
-- 전체 컬럼 기준
SELECT max(sal)
FROM emp
GROUP BY deptno
HAVING max(sal)>=3000;
-- 그룹함수가 적용된 조건을 설정하려면 having조건문
SELECT deptno, sal
FROM emp
WHERE sal>=2000; -- 2000이상인 데이터
SELECT deptno, avg(sal)
FROM emp
GROUP BY deptno;

SELECT deptno, avg(sal)
FROM emp
WHERE sal>=2000
GROUP BY deptno;
HAVING avg(sal)>=3000;
/*
# 그룹 함수의 종류
1. count() : 행의 갯수
2. max() : null을 제외한 모든 행의 최대값
3. min() : null을 제외한 모든 행의 최소값
4. sum() : null을 제외한 모든 행의 합
5. avg() : null을 제외한 모든 행의 평균값
6. stddev() : null을 제외한 모든 행의 표준편차
7. variance() : null을 제외한 모든 행의 분산값
*/
SELECT deptno, count(sal), max(sal), min(sal), sum(sal)
        , avg(sal), stddev(sal), variance(sal)
FROM emp
GROUP BY deptno;
-- ex1)
SELECT job, count(ename), round(avg(sal),1)
FROM emp
GROUP BY job;
-- ex2)
SELECT job, max(hiredate)
FROM emp
GROUP BY job;
-- 월별로 급여가 가장 높은 급여
SELECT to_number(to_char(hiredate, 'MM')) 월, sal
FROM emp
ORDER BY 월;
/*
# alias(별칭) 사용 주의
1. 정렬은 별칭으로 사용이 가능하나,
2. group을 처리한 데이터를 별칭사용하지 않기 때문에 그래도 처리하여야 한다.
    - 결과 건수만 같으면, 중첩함수 적용을 하지 않아도 된다.
*/

SELECT to_number(to_char(hiredate, 'MM')) 월, max(sal) "최대급여", avg(sal)
FROM emp
GROUP BY to_number(to_char(hiredate, 'MM'))
ORDER BY 월;
-- ==> 중첩함수를 적용해서 처리한 내용을 볼 수 있다.
SELECT * FROM emp;
-- ex)
SELECT empno, mod(empno, 2) "짝/홀",
    decode(mod(empno,2),0,'홍','청') "홍/청"
FROM emp;
SELECT decode(mod(empno,2),0,'홍','청') "홍/청",
        count(empno) "인원수", round(avg(sal)) "평균급여"
FROM emp
GROUP BY mod(empno,2);
/*
# having
1. group by 절에 의해 생성된 그룹을 대상으로 조건을 적용
2. having 절의 실행 과정
    1) 테이블에서 where절에 의해 조건을 만족하는 행 집합을 선택
    2) 행 집합을 group by 절에 의해 그룹핑
    3) having 절에 의해 조건을 만족하는 그룹을 선택
# having 절과 where절의 성능 차이
1. having 절
    1) 내부 정렬 과정에 의해 그룹화된 결과 집합에 대해 검색 조건 실행
2. where 절
    1) 그룹화하기 전에 먼저 검색 조건 실행
3. 실무 데이터베이스 관점
    where 절의 검색 조건을 먼저 실행하는 방법이 효율적
    그룹화하는 행 집합을 줄여서 내부 정렬 시간을 단축
    SQL처리 성능 향상
*/
SELECT deptno, avg(sal) 평균
FROM emp
GROUP BY deptno;
-- sal가 2000이상인 것을 대상으로 그룹함수를 처리
SELECT deptno, avg(sal) 평균
FROM emp
GROUP BY deptno
HAVING avg(sal)>=2000;
-- 그룹함수가 처리된 결과에서 avg(sal)을 조건으로 처리
-- 1. 사원정보중에 부서별 평균급여를 처리한다.
SELECT deptno, avg(sal) 평균
FROM emp
GROUP BY deptno;
-- 2. 그룹별로 평균급여를 기준으로 조건을 처리할 때, having을 처리
SELECT deptno, avg(sal) 평균
FROM emp
GROUP BY deptno
HAVING avg(sal)>=2000;