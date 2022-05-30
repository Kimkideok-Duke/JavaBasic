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
                AS SELECT e.*, dname, loc
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
                INSERT INTO emp_cp120(ename, hiredate) values('이영수',
                    to_date(to_char(sysdate, 'YYYYMM')||'15 10:15', 'YYYYMMDD HH:MI'));
                -- SELECT to_char(sysdate,'YYYY/MM')||'/15 오전 10:15' FROM dual;
                SELECT * FROM emp_cp120;

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










-- 2022-05-26
-- [1단계:확인] 1. inline view을 활용하여 분기별 최저급여자의 사원 정보를 출력하세요.
                SELECT q.div, q.sal, e.empno, e.ename
                FROM (
                    SELECT to_char(hiredate, 'Q') div, min(sal) sal
                    FROM emp
                    GROUP BY to_char(hiredate, 'Q')
                )q, emp e
                WHERE q.sal = e.sal
                AND q.div = to_char(e.hiredate, 'Q')
                ORDER BY div;

-- [1단계:개념] 2. 삭제 처리 기본 형식과 subquery를 통한 삭제 형식를 예제를 통해서 설명하세요.
            -- 기본 형식
            --     delete
            --     from 테이블명
            --     where 조건
            SELECT * FROM emp01;
            -- 부서별 최고 급여자 삭제
            DELETE FROM emp01
            WHERE (DEPTNO, SAL) IN (
                SELECT DEPTNO, max(sal) sal
                FROM emp01
                GROUP BY DEPTNO 
            );

-- [1단계:확인] 3. emp02로 복사테이블을 만들고, delete subquery를 이용하여, 상/하반기 최고 급여자를 삭제처리하세요.
            CREATE TABLE emp021 AS SELECT * FROM emp;
            SELECT floor(to_number(to_char(hiredate, 'MM'))/7) 반기, max(sal)
            FROM emp021
            GROUP BY floor(to_number(to_char(hiredate, 'MM'))/7);
            SELECT * FROM emp021;
            DELETE FROM emp021
            WHERE (sal) IN (
                SELECT max(sal)
                FROM emp021
                GROUP BY floor(to_number(to_char(hiredate, 'MM'))/7)
            );

-- [1단계:개념] 4. merge의 기본 형식을 선언하고, 2가지 기본예제(2개 테이블 비교 수정/등록, 
--             dual을 통한 데이터 비교 수정/등록)를 통하여 설명하세요.
            -- 기본형식
            --     merge into 목적테이블명
            --     using 비교할 테이블 및 subquery
            --     on 두 테이블의 비교 조건
            --     when matched then
            --         비교조건이 일치할 때, 수정 구문 처리
            --     when not matched then
            --         비교조건이 일치하지 않을 때, 등록 구문 처리

-- [1단계:확인] 5. 물건테이블과 회원테이블을 만들어 기본 데이터 5개를 입력하되, merge를 이용하여
--             등록/수정처리해보세요.
CREATE TABLE product011(
    name varchar2(50),
    price NUMBER,
    cnt number
);
SELECT '사과' name, 3000 price, 2 cnt FROM dual;
MERGE INTO product011 t
USING (SELECT '수박' name, 8000 price, 4 cnt FROM dual) s
ON (t.name = s.name)
WHEN MATCHED THEN
    UPDATE SET t.price = s.price,
               t.cnt = s.cnt
WHEN NOT MATCHED THEN
    INSERT values(s.name, s.price, s.cnt);
SELECT * FROM product011;

CREATE TABLE member011(
    id varchar2(50),
    pass varchar2(50),
    name varchar2(50),
    point NUMBER,
    auth varchar2(50)
);
-- [1단계:개념] 6. 문자열, 숫자형, 날짜형 데이터 유형을 기능별로 설명하세요
            -- 문자형
            --     char(size) : 
            --     - size크기의 고정 길이 문자 데이터 타입
            --     - 최대 크기 : 2000바이트
            --     - 최소 크기 : 1바이트
            --     varchar2(size)
            --     - size크기의 가변 길이 문자 데이터 타입
            --     - 최대 크기 : 4000바이트
            --     - 최소 크기 : 1바이트
            --     nvarchar2(size)
            --     - 국가별 문자 집합에 따른 size크기의 문자 또는 바이트의 가변길이 문자 데이터 타입
            --     - 최대 크기 : 40000바이트
            --     - 최소 크기 : 1바이트
            -- 숫자형
            --     number(p,s)
            --     - 정밀도(p)와 스케일(s)로 표현되는 숫자 데이터 타입
            --     - p : 1~38
            --     - s : -84 ~ 127
            -- 날짜형
            --     Date : 날짜 형식을 저장하기 위한 데이터 타입..

-- [2단계:확인] 7. 어떤 회원이 구매한 물건 정보를 담는 구매테이블을 만들려고 한다. 
--         구매테이블은 어떤 컬럼이 필요할지 기술해보고, 실제 저장한 데이터를 입력해보자.
            CREATE TABLE product0526(
                id char(8), -- 제품번호
                name varchar2(50), -- 제품명
                comp varchar2(50), -- 제조사명
                price NUMBER, -- 가격
                count NUMBER, -- 갯수
                category varchar2(50) -- 제품분류
            );
            INSERT INTO product0526 values('8LPP2809', '27gl850', 'LG', 540000, 20, '모니터');
            SELECT * FROM product0526;





-- 2022-05-27
-- [1단계:개념] 1. 무결성 제약조건을 설정하는 목적을 기술하세요.
            -- 데이터의 정확성과 일관성을 보장
            -- 테이블 생성시 무결성 제약조건을 정의 가능
            -- 테이블에 대한 정의, 데이터 딕션너리에 저장되므로 응용프로그램에서 입력된 모든 데이터에 대해 동일하게 적용
            -- 제약조건을 활성화, 비활성화 할 수 있는 융통성

-- [1단계:개념] 2. not null 무결성 제약조건의 기본예제와 함께 제약조건의 내용을 기술하세요
            -- not null : 열이 null을 포함할 수 없음
                CREATE TABLE example01(
                    num NUMBER PRIMARY key,
                    str varchar2(50) NOT NULL
                );
                INSERT INTO example01 values(1000, '예제2');
                INSERT INTO example01 values(2000, null); --> 오류
                SELECT * FROM example01;

-- [1단계:개념] 3. unique 무결성 제약조건의 기본예제와 함께 제약조건의 내용을 기술하세요
            -- unique : 중복데이터 입력 불가 처리, 단 null은 중복이 가능하다.
                CREATE TABLE example02(
                    num NUMBER unique,
                    str varchar2(50) 
                );
                INSERT INTO example02 values(1000, '예제3-1');
                INSERT INTO example02 values(1000, '예제3-2'); --> 오류
                INSERT INTO example02 values(1001, '예제3-3');
                SELECT * FROM example02;

-- [1단계:확인] 4. 회원테이블에서 id, pass, 이름, 권한, 포인트를 설정하되,
--       제약조건의 이름은 모두가 설정하고,
--       id : not null, unique, pass : not null, 이름: not null
--       권한 : 관리자/일반사용자/슈퍼유저 만등록, 포인트 : 0이상 등록 가능
                CREATE TABLE member021(
                    id varchar2(50) NOT NULL unique,
                    pass char(8) NOT NULL,
                    name varchar2(50) NOT NULL,
                    auth varchar2(50) CONSTRAINT member021_auth_ck check( auth IN('관리자','일반사용자','슈퍼유저') ),
                    point NUMBER check(point >= 0)
                );
                INSERT INTO member021 values('ABC123', 'qwerty1', '홍길동', '관리자', 100);
                INSERT INTO member021 values(null, 'qwerty2', '김길동', '일반사용자', 101); --오류
                INSERT INTO member021 values('ABC123', 'qwerty3', '이길동', '관리자', 200); -- 오류
                INSERT INTO member021 values('DEF456', null, '신길동', '일반사용자', 300); -- 오류
                INSERT INTO member021 values('GHI789', 'qwerty5', '최길동', '슈퍼유저', 3000);
                INSERT INTO member021 values('JKL123', 'qwerty6', '금길동', '유저', 1000); -- 오류
                INSERT INTO member021 values('MNO456', 'qwerty7', '유길동', '관리자', -200); -- 오류
                SELECT * FROM member021;

-- [1단계:개념] 5. 무결성 제약 조건의 null의 관계를 기술하세요.
            -- 기본키(primary key) : null 입력 불가
            -- 고유키(unique key) : null 중복 가능
            -- not null : 열이 null을 포함할 수 없음

-- [1단계:개념] 6. 무결성 제약조건의 이름을 쓰는 경우와 쓰지 않는 경우 형식의 차이를 기술하세요.
            -- 제약조건의 이름을 붙일 때는 constraint 제약명
            --     컬럼명 데이터유형 [xonstraint 제약명] 제약조건keyword

-- [1단계:확인] 7. 물건(물건번호, 이름, 가격, 단위, 분류번호) 제품구분(분류번호, 분류명, 우선순위)
--       1000 사과   3000 개  10     10 과일류 1
--       1001 소고기 10000 g  20     20 육류  2
--         제품구분의 분류번호와 물건의 분류번호는 foreign key 관계로 설정하세요.
                CREATE TABLE product021(
                    num NUMBER NOT NULL check(num >= 0),
                    name varchar2(50) NOT NULL,
                    price NUMBER NOT NULL check(price>=0),
                    unit varchar2(50) NOT NULL,
                    no NUMBER PRIMARY key
                );
                INSERT INTO product021 values(1000, '시과', 3000, '개', 10);
                INSERT INTO product021 values(1001, '소고기', 10000, 'g', 20);
                SELECT * FROM product021;
                CREATE TABLE category(
                    num NUMBER REFERENCES product021(no),
                    name varchar2(50) NOT NULL,
                    priority NUMBER NOT NULL
                );
                INSERT INTO category values(10, '과일류', 1);
                INSERT INTO category values(20, '육류', 2);
                SELECT * FROM category;