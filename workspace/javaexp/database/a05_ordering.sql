/*
# 정렬처리
1. sql명령문에서 검색된 결과는 테이블에 데이터가 입력된 순서대로 출력한다.
2. 데이터의 출력순서를 특정 컬럼을 기준으로 오름차순/내림차순으로 정렬하는 경우에 활용된다.
3. 여러개의 컬럼에 대해 정렬 순서를 지정해서 정렬할 경우는 다음과 같이 처리한다.
    - 입사일은 오름차순, 급여는 내림차순
    order by hiredate asc, sal desc
4. 기본적인 정렬 방법
    - 문자값은 알파벳순으로 출력되고, 한글은 가나라다 순으로 출력된다.
    - 숫자값은 가장 적은 값으로 먼저 출력
    - 날짜는 가장 과거의 날짜로부터 최근 날짜로 출력된다.
5. 기본형식
    select *
    from 테이블
    where..
    order by 컬럼 [asc/desc]
    asc : default 로 오름차순 정렬
    desc : 내림차순 정렬
*/
SELECT empno, ename, sal
FROM emp
ORDER BY empno desc;

-- ex1)
SELECT *
FROM emp
ORDER BY hiredate desc;
-- ex2)
SELECT *
FROM emp
ORDER BY job, sal;
-- ex3)
SELECT *
FROM emp
ORDER BY deptno, sal desc;