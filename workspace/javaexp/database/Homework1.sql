SELECT * FROM emp;
SELECT * FROM dept;
-- 2022-05-25
-- [1단계:개념] 1. DML이란 무엇인가 종류를 기술하세요..
            -- DML : 테이블에 새로운 데이터를 입력하거나 기존 데이터를 수정 또는 삭제하기 위한 명령어
            -- insert : 새로운 데이터 입력 명령어
            -- update : 기존 데이터 수정 명령어
            -- delete : 기존 데이터 삭제 명령어
            -- merge : 두개의 테이블을 하나의 테이블로 병합하는 명령어

-- [1단계:확인] 2. emp테이블과 dept를 조인한 복사테이블로 emp_cp120만들어 
--       전체 데이터 입력과 특정 컬럼 입력을 처리하세요.
CREATE TABLE emp_cp120
AS SELECT empno, ename, job, mgr, HIREDATE, sal, COMM, e.DEPTNO, dname, loc
FROM emp e, dept d
WHERE e.deptno = d.deptno AND 1=0;
SELECT * FROM emp_cp120;
-- 전체 데이터 입력
INSERT INTO emp_cp120 values(100, '홍길동', '과장', 7800, NULL, 3400, 0, 10, NULL, null); 
-- 특정 컬럼 입력
INSERT INTO emp_cp120(empno, ename, sal) values(1000, '김길동', 1200);

-- [1단계:개념] 3. 명시적 null과 묵시적 null 데이터 입력의 차이점을 예제를 통해서 기술하세요.
            -- 1. 명시적으로 null 데이터 입력
            --     지정한 또는 전체 테이블을 입력할 때, null로 명시적으로 데이터를 입력 처리
            -- 2. 묵시적으로 null데이터 입력
            --     지정한 컬럼만 데이터를 입력하는 경우, 그 외에 컬럼은 null로 입력이 된다.
                SELECT * FROM emp_cp100;
                INSERT INTO emp_cp100 values(7781, '오길동', NULL, NULL, NULL, 3000, NULL, null);
                INSERT INTO emp_cp100(empno, ename) values(9997, '하길동');

-- [1단계:확인] 4. 현재 년도와 월을 기준으로 지정한 날짜와 시간(15일 오전 10:15)오후 12:25을 입력 처리하세요.
                SELECT to_char(sysdate,'YYYY/MM')||'/15 오전 10:15' FROM dual;

-- [1단계:개념] 5. 단일 데이터 입력과 다중 데이터 입력의 차이를 예제를 통해 기술하세요.
            -- 단일 데이터 입력
                CREATE TABLE EMP_CP121
                AS SELECT * FROM emp WHERE 1=0;
                INSERT INTO EMP_CP121(empno, ename, job, sal)
                select empno, ename, job, sal FROM emp WHERE job = 'SALESMAN';
                SELECT empno, ename, job, sal FROM EMP_CP121;
            -- 다중 데이터 입력
                CREATE TABLE EMP_CP122
                AS SELECT * FROM emp WHERE 1=0;
                CREATE TABLE EMP_CP123
                AS SELECT * FROM emp WHERE 1=0;
                CREATE TABLE EMP_CP124
                AS SELECT * FROM emp WHERE 1=0;
                INSERT ALL
                INTO EMP_CP122(empno, ename, job, sal)
                INTO EMP_CP123(empno, ename, job, sal)
                INTO EMP_CP124(empno, ename, job, sal)
                select empno, ename, job, sal FROM emp WHERE job = 'SALESMAN';
                SELECT empno, ename, job, sal FROM EMP_CP122;
                SELECT empno, ename, job, sal FROM EMP_CP123;
                SELECT empno, ename, job, sal FROM EMP_CP124;

-- [1단계:확인] 6. 직책별로 테이블을 만들어 사원정보를 한번에 입력 처리하세요.
                SELECT job FROM emp GROUP BY job;
                CREATE TABLE EMP_CP125 AS SELECT * FROM emp WHERE 1=0;
                CREATE TABLE EMP_CP126 AS SELECT * FROM emp WHERE 1=0;
                CREATE TABLE EMP_CP127 AS SELECT * FROM emp WHERE 1=0;
                CREATE TABLE EMP_CP128 AS SELECT * FROM emp WHERE 1=0;
                CREATE TABLE EMP_CP129 AS SELECT * FROM emp WHERE 1=0;
                INSERT FIRST
                    WHEN job = 'CLERK' THEN
                        INTO EMP_CP125(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
                    WHEN job = 'SALESMAN' THEN
                        INTO EMP_CP126(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
                    WHEN job = 'PRESIDENT' THEN
                        INTO EMP_CP127(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
                    WHEN job = 'MANAGER' THEN
                        INTO EMP_CP128(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
                    WHEN job = 'ANALYST' THEN
                        INTO EMP_CP129(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
                SELECT * FROM emp;
                SELECT * FROM EMP_CP125;
                SELECT * FROM EMP_CP126;
                SELECT * FROM EMP_CP127;
                SELECT * FROM EMP_CP128;
                SELECT * FROM EMP_CP129;

-- [1단계:개념] 7. 데이터의 수정기본형식을 기술하세요..
            -- 기본형식
            --     update 테이블
            --     set 컬럼 = 수정데이터,
            --         컬럼2 = 수정데이터2,
            --         ..
            --     where 조건문

-- [1단계:확인] 8. 1사분기 최고 급여를 ALLEN의 급여로 수정 처리하세요
                CREATE TABLE EMP_CP1211 AS SELECT * FROM emp;
                SELECT * FROM EMP_CP1211;
                UPDATE EMP_CP1211
                    SET sal = (
                        SELECT max(sal)
                        FROM emp
                        WHERE to_char(hiredate, 'Q') = '1'
                    )
                WHERE ename = 'ALLEN';