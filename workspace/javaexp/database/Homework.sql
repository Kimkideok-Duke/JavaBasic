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

-- ename의 첫번째에서 3번째 데이터 추출, job과 혼합하여 화면에 출력하되, 
-- substr(), concat()함수를 활용하세요
SELECT concat(substr(ename, 3, 1), job)
FROM emp;

-- ||, substr을 활용하여 1980에 입사한 사람의 입사일정보를 @@@는 @@@@년 @@월 @@일에 입사했습니다.로 
-- 출력하세요(ename, hiredate활용)
SELECT ename || '는 ' 
        || '19' || substr(hiredate, 0, 2) || '년 ' 
        || substr(hiredate, 4, 2) || '월 '
        || substr(hiredate, 7, 2) || '일에 입사했습니다' show
FROM emp;

-- 사원번호, 사원명, 직책 급여을 출력하되, 사원명6, 직책9은 최고 크기를 확인하고, 
-- 사원명과 직책은 각각 최고 크기의 기준으로 왼쪽과 오른쪽에 #을 삽입하여 출력하세요.
SELECT empno, length(ename), length(job),lpad(ename, 6, '#'), rpad(job, 9, '#')
FROM emp;

-- 아래의 형식으로 함수를 적용해서 출력하되 ename이 대소문자 구분없이 a/A인 데이터로 두번째 포함되어 검색 되게 처리하세요.
                --  The salary of Ward is @@@ won!!!
SELECT 'The salary of ' || initcap(ename) || ' is ' || sal || 'won!!!'
FROM emp
WHERE ename LIKE '_A%'
OR ename LIKE '_a%';

-- 근무일수를 2분위로 나누어서(중앙값을 기준)서 보너스를 급여의 150%,200% 차등 지급하기로 했다. 
-- 사원명, 입사일, 분류, 보너스금액
SELECT ename, hiredate, months_between(sysdate, hiredate),
FROM emp
ORDER BY months_between(sysdate, hiredate) desc;

-- 오늘을 1일을 기준으로 1000일 기념일의 날짜와  걸린 기간을 @@년 @@개월 @@일 형식으로 표기하세요. 
-- hint)mod함수 활용
SELECT sysdate+1000 "날짜", trunc(1000/365) || '년 ' 
                        || trunc(mod(1000, 365)/31) || '개월' 
                        || mod(mod(1000, 365), 31) || '일' "걸린기간"
FROM dual;