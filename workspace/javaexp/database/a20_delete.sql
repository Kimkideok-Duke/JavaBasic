/*
# 데이터의 삭제
1. delete 명령문은 테이블에 저장된 삭제를 위한 조작어이다.
2. where 절을 생략하면 테이블의 모든 행이 삭제 된다.
3. 기본 형식
    delete
    from 테이블명
    where 조건

*/
SELECT * FROM EMP_CP100;
DELETE FROM EMP_CP100 ec
WHERE empno = 7782;
-- ex)
SELECT * FROM emp01;
CREATE TABLE EMP01
AS SELECT * FROM EMP;
-- ex)
DELETE FROM EMP01
WHERE sal >= 2000 AND deptno = 30;
/*
# 서브쿼리를 이용한 데이터 삭제
1. where절에서 서브쿼리 이용
2. 다른 테이블에 저장된 데이터를 검색하여 한꺼번에 여러 행의 내용을 삭제 함
3. where절의 컬럼 이름은 서브쿼리의 컬럼이름과 달라도 됨.
4. 데이터 타입과 컬럼수는 일치
5. 기본 형식
    1) 1 row인 경우
        delete from 테이블
        where (컬럼명1, 컬럼명2...) = (select .... from 테이블 where...)
    2) 다중의 row인 경우
        delete from 테이블
        where (컬럼명1, 컬럼명2...) in (select .... from 테이블 ..)
*/
SELECT * FROM emp01;
-- 부서별 최고 급여자 삭제
DELETE FROM emp01
WHERE (DEPTNO, SAL) IN (
	SELECT DEPTNO, max(sal) sal
	FROM emp01
	GROUP BY DEPTNO 
);
SELECT * FROM emp01;
-- ex)
DELETE FROM emp01
WHERE(to_char(hiredate, 'Q'), sal) IN (
    SELECT to_char(hiredate, 'Q') div, min(sal) sal
    FROM emp01
    GROUP BY to_char(hiredate, 'Q')
);