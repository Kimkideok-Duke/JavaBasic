/*
# 숫자형 처리함수
 1. 숫자 데이터를 처리하기 위한 함수
 2. 종류
    1) round : 지정한 소숫점 자리로 반올림 처리를 해주는 함수
       round(데이터, 자릿수)
       자릿수 : + 값은 소숫점 이하 자릿수를 말한다.
                ex) round(45.2532,2) ==> 45.25
                - 값은 소숫점을 기준으로 2,3,4이면 100자리, 1000자리, 10000자리로 반올림 처리하는 것을 말한다.
                ex) round(2436435, -3) ==> 2436000
    2) trunc : 지정한 소숫점 자리까지 남기고 절삭처리
        trunc(데이터, 자리수)
*/
SELECT round(24232.2535, 3),
    round(24232.2535, 1),
    round(24232.2535, -1),
    round(24232.2535, -2),
    trunc(2423.23, -1),
    trunc(2423.23, 1),
    trunc(2423.23, -2)
FROM dual;
-- ex)
SELECT ename, trunc(sal+(sal*(deptno/100)),-2)
FROM emp;
/*
    3) mod : 데이터베이스에서 산술연산자 %대신 쓰이는 나머지 처리함수를 말한다.
        mod(데이터, m) : 데이터를 m으로 나눈 나머지값
        ex) mod(10,3) ==> 1
*/
SELECT mod(10,3) s1, mod(10,2) s2, mod(10,3) FROM dual;
SELECT * FROM emp;
-- ex)
SELECT empno, mod(empno,2) div, ename
FROM emp
WHERE mod(empno, 2) = 0;
/*
    4) ceil : 지정한 값보다 큰 수 중에서 가장 작은 정수
        소숫점이하의 내용에 대하여 올림 정수
    5) floor : 지정한 값보다 작은 수 중에서 가장 큰 정수
        소숫점이하의 내용에 대하여 내림 정수
*/
SELECT ceil(253.243) num01, floor(253.243) num02 FROM dual;
SELECT *
FROM emp;
-- ex)
SELECT ename, sal, floor(sal/12) "월급여(내림)", ceil(sal/12) "월급여(올림)"
FROM emp;