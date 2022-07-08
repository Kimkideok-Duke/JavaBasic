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