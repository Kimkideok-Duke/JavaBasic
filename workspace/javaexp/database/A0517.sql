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
SELECT ename || '님의 입사일은 ' || hiredate || '이고, 현재 연봉의 1/13인 월급여는 ' || (sal/13) || '만원.' show
FROM emp;
SELECT ename || '님의 이번달 보너스는 연봉(' || sal ||')의 ' || deptno || '%기준으로 ' || sal*(deptno/100) || '만원 지급합니다.' show
FROM emp;
