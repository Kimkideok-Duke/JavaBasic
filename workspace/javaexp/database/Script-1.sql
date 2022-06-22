CREATE TABLE EMP011
AS
SELECT *
FROM emp;
SELECT * FROM EMP011;
SELECT MAX(empno) FROM EMP011;

INSERT INTO EMP01 values(1001,'마길동','대리',7780,
    to_date('2010-10-10','YYYY-MM-DD'),3500,100,10);
/*
'2010-10-10' : 날짜 데이터를 입력할 때, 문자열이 필요해서
private String hiredate_s;
로 추가선언 필요
*/
/*
UPDATE EMP011
    SET ename = ?,
        job = ?,
        mgr = ?,
        hiredate = to_date(?, 'YYYY-MM-DD'),
        sal = ?,
        comm = ?,
        deptno = ?
WHERE empno = ?

DELETE FROM EMP011
WHERE empno = ?;
*/
SELECT * FROM emp011;


DELETE FROM EMP011
WHERE empno = 7369;

CREATE TABLE dept011
AS SELECT * FROM dept;

SELECT * FROM dept011;

INSERT INTO dept011 values(50, 'Develop', 'seoul');
UPDATE dept011
    SET dname = '인사',
        loc = '부산'
WHERE deptno = 50;

/*
UPDATE dept011
    SET dname = ?,
        loc = ?
WHERE deptno = ?


DELETE FROM dept011
WHERE deptno = ?
*/
    