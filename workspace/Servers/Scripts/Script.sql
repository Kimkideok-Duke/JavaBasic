SELECT dname, ename, sal, loc
FROM emp e, dept d
WHERE e.deptno = d.DEPTNO 
AND empno = 7369;
// ==> dname, ename, sal, loc vo 조회되는 단일 vo 생성
/*
class DeptEmp01
	private String dname;
	private String ename;
	private double sal;
	private String loc;
*/

SELECT *
FROM SALGRADE
WHERE grade = 4
;
SELECT ENAME 
FROM emp;
SELECT EMPNO 
FROM emp
WHERE DEPTNO = 10;
SELECT sal
FROM emp
WHERE job='SALESMAN';

SELECT job
FROM EMP
WHERE DEPTNO=10;

SELECT * FROM emp;

SELECT max(hiredate)
FROM emp;

SELECT *
FROM EMP
WHERE SAL IN(
	SELECT max(sal)
	FROM emp
	WHERE DEPTNO=30
);

SELECT ename
FROM emp
WHERE sal>=1000 AND sal<=3000;

SELECT empno, ename, TO_CHAR(hiredate,'Q'), hiredate
FROM emp
WHERE TO_CHAR(HIREDATE, 'Q')='1';

SELECT job, ROUND(AVG(sal)) 
FROM EMP
GROUP BY JOB;
