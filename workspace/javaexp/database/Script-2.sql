SELECT * FROM emp;
-- 조회한 결과와 같은 모양을 ResultSet객체가 가지고 있다.
-- rs.next() : 행단위로 커서를 위치시켜주고, 해당 행에 데이터가 있으면 true, 없으면 false
-- re.next() : 한번 호출하면 첫번째 행, 두번 호출하면 두번째 행에 커서를 위치.
-- 데이터가 12개 있으면 12번째 까지는 true, 13번째 호출하면 false가 나온다.
-- rs.getInt("empno") : sql을 결과로 나온 컬럼명과 데이터 유형에 맞게 가져온다.
-- rs.get데이터유형("컬럼명") : 컬럼명을 대소문자로 구분하지 않는다.
-- rs.getString("job")
-- rs.fetString() : 모든 데이터를 가져올 수는 있다. 문자열형으로
-- ex) 3번째 행의 sal을 가져오려면 rs.next() 3번, rs.getDouble("sal") 호출
-- ex) 2번째 행의 ename를 가져오려면 rs.next() 2번, rs.getString("ename") 호출
-- ex) 5번째 행의 deptno를 가져오려면 rs.next() 5번, rs.getInt("deptno") 호출
SELECT empno NO, ename name
FROM emp;
--      주의) sql의 결과로 나온 컬럼명으로 rs.getString("컬럼명")을 지정해야지
--          테이블의 컬럼명으로 하면 안된다.
--      3번째 행의 WARD 가져오려면
--      rs.next() 3번 호출, rs.getString("name")

