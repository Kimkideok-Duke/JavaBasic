SELECT job, round(avg(sal) sal
FROM emp
WHERE job = 'CLERK'
GROUP BY job;
/*
SELECT job, round(avg(sal) sal
FROM emp
WHERE job = #{job}
GROUP BY job 
*/

SELECT *
FROM emp
WHERE sal BETWEEN 1000 AND 3000;

/*
SELECT *
FROM emp
WHERE sal BETWEEN #{start} AND #{end}
*/

SELECT *
FROM salgrade;
CREATE TABLE salgrade011
AS SELECT * FROM SALGRADE;
SELECT *
FROM salgrade011;
INSERT INTO salgrade011 values(6,4001,5000);
/*
INSERT INTO salgrade011 values(#{grade},#{losal},#{hisal})
*/