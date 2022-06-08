select * from emp;
-- ResultSet으로 아래 내용이 할당이 된다.
-- .next() : 행단위로 이동처리함. - 그 행에 데이터가 있으면 true/없으면 false
-- .getString("컬럼명") : 해당 row에 상단에 선언된 column명을 기준으로 데이터를 가져온다.
--      주의 select @@ 최종 컬럼명에게 alias가 있으면 alias명으로 호출하여야 한다.
--      .get데이터유형()
--          ex) rs.getInt("empno"), rs.getDate("hiredate"), sal의 경우 number(4,2)로 실수형이기에
--              rs.getDouble("sal")
-- String sql = "select count(*) cnt from emp where deptno="+deptno;
select count(*) cnt from emp where deptno = 10;
SELECT * FROM emp WHERE deptno = 10;
-- String sql = "select count(*) cnt from emp where job= '"+job+"' ";
-- job = '"+job+"' " : 변동되는 문자열 job에 다른 sql 결과를 얻기 위해서 이런형식이 필요하다.
select count(*) cnt from emp where job = 'CLERK';
select * from emp where job = 'CLERK';

SELECT to_char(hiredate,'Q') qua, e.*
FROM emp e
WHERE ( to_char(hiredate,'Q'), sal) IN (
    SELECT to_char(hiredate, 'Q') qua, max(sal) msal
    FROM emp
    GROUP BY to_char(hiredate,'Q')
)
ORDER BY qua;


SELECT *
FROM emp
WHERE ename LIKE '%A%';

SELECT *
FROM emp
WHERE sal>=1000 AND sal<=3000
AND deptno = '10';

SELECT e.*, dname, loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND dname LIKE '%A%'
AND ename LIKE '%A%'
ORDER BY dname;

CREATE TABLE EMPDEPTJOIN
AS
SELECT e.*, dname, loc
FROM emp e, dept d
WHERE e.deptno = d.deptno; 

select * 
from dept 
where dname like '%'||''||'%' 
and loc like '%'||''||'%';