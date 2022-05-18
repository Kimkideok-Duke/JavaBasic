SELECT*FROM emp;

SELECT empno 사원번호,
        ename 사원명,
        job 직책,
        mgr 관리자,
        hiredate 입사일,
        sal 급여,
        comm 보너스,
        deptno 부서번호
FROM emp;

SELECT sal 기본급여,
        deptno 보너스,
        sal+deptno 총급여
FROM emp;

SELECT ename || '님의  사원번호는 ' || empno || '이고, 올해 연말 보너스는 연봉의 20%인 ' || (sal*0.2) || '입니다.' show
FROM emp;
SELECT ename || '님의 입사일은 ' || hiredate || '이고, 현재 연봉의 1/13인 월급여는 ' || round(sal/13) || '만원.' show
FROM emp;
SELECT ename || '님의 이번달 보너스는 연봉(' || sal ||')의 ' || deptno || '%기준으로 ' || sal*(deptno/100) || '만원 지급합니다.' show
FROM emp;

-- 사원정보에서 급여가 2000~5000인 사원번호, 사원명, 급여를 출력하세요.
SELECT empno 사원번호,
        ename 사원명,
        sal 급여
FROM emp
WHERE sal BETWEEN 2000 AND 5000;

-- 직책이 CLERK와 MANAGER를 검색하여 이에 해당 하는 사원 정보를 출력하세요.
SELECT *
FROM emp
WHERE job = 'CLERK'
OR job = 'MANAGER';

-- 사원번호 7566, 7782가 소속된 부서번호에 해당하는 사원정보를 출력하세요.
SELECT *
FROM emp
WHERE deptno in(
        SELECT deptno
        FROM emp
        WHERE empno = 7566 OR empno = 7782
);

-- 1981에 입사한 사원들의 직책을 기준으로 사원정보를 출력하세요..
SELECT *
FROM emp
WHERE hiredate LIKE '%81%'
ORDER BY job;

-- like 키워드로 1/4분에 입사한 사원들의 부서정보와 동일한 사원들을 출력하세요.
SELECT *
FROM emp
WHERE deptno in(
        SELECT deptno
        FROM emp
        WHERE to_char(hiredate) LIKE '%01%'
        OR to_char(hiredate) LIKE '%02%'
        OR to_char(hiredate) LIKE '%03%'
        OR to_char(hiredate) LIKE '%04%'
);

-- '데이터%' : 해당 데이터로 시작
-- '%데이터' : 해당 데이터로 끝
-- '%데이터%' : 해당 데이터 포함
-- '_데이터' : 첫자이후에 특정데이터 포함 - 자릿수 keyword 검색
-- '데이터_' : 데이터가 마지막 한자 데이터 포함
SELECT *
FROM emp
WHERE job LIKE 'S%';
SELECT *
FROM emp
WHERE job LIKE '%T';
SELECT *
FROM emp
WHERE job LIKE '%ER%';
SELECT *
FROM emp
WHERE job LIKE '_A%';
SELECT *
FROM emp
WHERE job LIKE '%S_';