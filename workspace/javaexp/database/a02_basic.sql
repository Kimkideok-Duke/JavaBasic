SELECT*FROM emp;
/*
# 중복제어 distinct
1. 특정한 데이터를 출력하는 것은 연관관계 없이 컬럼으로 출력이 된다.
2. 특정 컬럼의 데이터 중에 중복된 것을 제외 시키고 출력할 때는 distinct 컬럼명 형식으로 처리한다.
3. 2개 이상의 컬럼에서도 중복된 데이터를 제외 시킬 수 있다.
    해당 컬럼을 체크해도 동일할 때는 제외를 한다.
==> 행단위로 동일한 데이터를 나타나지 않게 처리..
*/
SELECT * FROM emp;
SELECT deptno FROM emp;
SELECT DISTINCT deptno FROM emp;
SELECT mgr, deptno FROM emp;
SELECT DISTINCT mgr, deptno FROM emp;

-- ex1) job(직책)이 같은 데이터를 제외하세요.
SELECT DISTINCT job FROM emp;
-- ex2) job, mgr(관리자 번호) 둘 다 같은 데이터를 제외하세요.
SELECT DISTINCT job, mgr FROM emp;
/*
# 기본적인 sql 질의어 구조
1. 기본형식
    select : 열단위 컬럼을 선택
    from 테이블명
    where 조건 : 행단위 filtering을 처리
    group by 그룹별로 데이터 처리할 때..  함수파트에 그룹함수 진행시
        ex) 부서별 평균 급여, 직책별 최고 급여
    order by 컬럼 : 정렬할 컬럼의 우선순위

# where 조건
1. 행단위로 조건/논리식을 통해서 행단위 데이터를 선택처리한다.
2. 기본 형식
    select * from 테이블
    where 컬럼명 비교/논리연산자 데이터값
*/
SELECT *
FROM emp
WHERE sal>=3000; -- sal가 3000이상인 데이터를 row단위로 필터링 처리

-- ex)
SELECT *
FROM emp
WHERE sal<=2000;
/*
# where 조건절
1. 테이블에 저장된 데이터 중에서 원하는 데이터만 선택적으로 검색하는 기능을 처리할 때 활용된다.
2. where절의 조건문은 컬럼이름, 연산자, 상수, 산술 표현식을 결합하여 다양한 형태로 표현한다.
    ex) empno = 7900, ename = 'SMITH', sal >= 3000 and sal <= 5000
3. where 절에서 사용하는 데이터 타입은 문자, 숫자, 날짜 타입을 사용할 수 있다.
    문자나 문자열은 '문자열'로 활용하고 숫자는 데이터 그대로, 날짜는 형변환 함수(to_char(), to_date())를 이용해서 검색한다.
    ex) job = 'SALEMAN', deptno = 10, hiredate = to_date('YYYYMM','198012')
4. 데이터는 대소문자를 구분한다.
    job = 'saleman'로는 emp의 SALEMAN 데이터를 검색하지 못한다.
5. 논리 연산자를 활용한다.
    and, or, not
    ex) job = 'SALEMAN' AND sal>=2000,
        deptno = 10 or deptno = 30
*/
-- 부서번호 10인 사원테이블의 사원명, 부서번호, 사원번호 출력
SELECT ename, deptno, empno
FROM emp
WHERE deptno = 10;
-- empno(사원번호), ename(사원명), job(직책명), mgr(관리자번호), hiredate(입사일), comm(보너스), deptno(부서번호)
-- ex)
SELECT ename, job, sal
FROM emp
WHERE job = 'SALESMAN';
-- 비교문1 AND 비교문2, 비교문1 OR 비교문2
-- ex)
SELECT empno, ename, job, sal
FROM emp
WHERE sal>=2000 AND sal <= 3000 
OR job = 'MANAGER';
-- ex)
SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno!=10
AND sal>=3000;

SELECT empno, ename, sal, deptno
FROM emp
WHERE (deptno=10 OR sal <3000);
/*
# 키워드 연산식
1. not(조건식) : 해당 조건식의 반대조건
2. 컬럼명 between A and B : 특정컬럼이 A와 B 사이의 데이터
    다음의 논리식과 동일  컬럼명 >= A and 컬럼명 <= B
3. 컬럼명 in (데이터1, 데이터2, ...)
    해당 컬럼의 데이터를 나열된 조건으로 or 처리되는 결과값을 가져올 때 사용된다.
    ex) 컬럼명 = 데이터1 or 컬럼명 = 데이터2...
        컬럼명 in (select @@@ from @@@)
4. 컬럼명 like '키워드 검색'
    1) 키워드 검색 유형
        '데이터%' : 해당 데이터로 시작
        '%데이터' : 해당 데이터로 끝
        '%데이터%' : 해당 데이터 포함
        '_데이터' : 첫자이후에 특정데이터 포함 - 자릿수 keyword 검색
        '데이터_' : 데이터가 마지막 한자 데이터 포함
        ex) '_A_' : 3자리이고 중간에 A가 포함된 데이터
            '__B%' : 세번째 자리에 B포함한 데이터
            '%C_' : 뒤에서 두번째 데이터 C로 끝나는 데이터
*/
SELECT *
FROM emp
WHERE sal BETWEEN 1000 AND 2000;
-- ex)
SELECT *
FROM emp
WHERE empno BETWEEN 7500 AND 7800;
-- ex)
SELECT deptno
FROM emp;
WHERE sal BETWEEN 1000 AND 2000;

SELECT * 
FROM emp
WHERE deptno in(
    SELECT deptno
    FROM emp
    WHERE sal BETWEEN 1000 AND 2000
);
SELECT * FROM emp
-- ex)
WHERE job in(
    SELECT job
    FROM emp
    WHERE deptno in(10,30)
);
-- 키워드 검색1 : 포함되어 있으면 모두 다 검색 : 컬럼명 like '%검색키워드%'
-- 직책에 'ER'이 있으면 모두 검색
SELECT *
FROM emp
WHERE job LIKE '%ER%';
-- ex)
SELECT *
FROM emp
WHERE ename LIKE '%A%'
AND sal BETWEEN 1000 AND 3000;
-- hiredate 날짜형 데이터를 문자열로 형변환해서 특정연도의 데이터를 검색처리
SELECT to_char(hiredate), e.*
FROM emp e
WHERE to_char(hiredate) LIKE '%81%';
SELECT to_char(hiredate), e.*
FROM emp e
WHERE to_char(hiredate) LIKE '81/04%'; -- 1981년 4월에 입사한 사람
SELECT hiredate, to_char(hiredate),
        to_char(hiredate,'YYYY/MM/DD'),
        to_char(hiredate,'YYYY"년"MM"월"DD"일"')
FROM emp;
-- 날짜형식을 원하는 형식으로 보거나/검색할 때는 to_char(날짜, '형식')
--  활용을 하고, 특히 형식도 oracle에서 지원하는 형식 format 코드가(YYYY,-,/)되어있다.
--  이외에 출력형식으로 추가가 필요하면 ' "추가형식" '로 하여야 한다.

-- # like 문자열% : 해당문자열로 시작, like %문자열 : 해당문자열로 끝,
--   like __A__ : 총 5자리이고 3번째 자리에 A가 들어가는 경우..
--           __ : 자리수의 갯수까지 검색할 때 처리..
-- 직책이 MAN으로 끝나는 사원의 정보
SELECT*
FROM emp
WHERE job LIKE '%MAN';
SELECT *
FROM emp;
-- 직잭의 3번째 자리가 E가 포함된 사원 정보
SELECT *
FROM emp
WHERE job LIKE '__E%';
-- ex)
SELECT *
FROM emp
WHERE job LIKE '_A%'
AND job LIKE '%ER%'