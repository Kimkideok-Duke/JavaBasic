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












-- 2022-05-30
-- [1단계:개념] 1. sequence를 사용하는 이유와 기본형식을 예제를 통해서 기술하세요.
            -- 1) 유일한 식별자
            -- 2) 기본 키 값을 자동으로 생성하기 위하여 일련번호 생성 객체
            -- 3) 여러 테이블에서 공유 가능
            CREATE SEQUENCE seq_hw01
                INCREMENT BY 1
                START WITH 1
                MAXVALUE 10
                CYCLE
                cache 2;
            SELECT seq_hw01.nextval FROM dual;

-- [1단계:확인] 2. 회원테이블은 만들고, 회원번호가 'N'(일반), 'S'(수퍼고객), 'A'(관리자)
--       가 붙어서 N1000, S1001, A1002 형식으로 시퀀스와 조합해서 만들어 진다고 한다.
--       회원번호, 회원아이디, 회원명, 회원패스워드로 구성된 테이블과 각각
--       권한에 따를 번호를 입력하세요.
            DROP TABLE member031;
            CREATE TABLE member031(
                no varchar2(50),
                id varchar2(50),
                name varchar2(50),
                passwd varchar2(50)
            );
            DROP SEQUENCE seq_hw02;
            CREATE SEQUENCE seq_hw02
                INCREMENT BY 1
                START WITH 1000;
            INSERT INTO member031 values('N'||seq_hw02.nextval, 'qwerty1', '홍길동', 'qwerty');
            INSERT INTO member031 values('S'||seq_hw02.nextval, 'qwerty2', '김길동', 'qwerty');
            INSERT INTO member031 values('A'||seq_hw02.nextval, 'qwerty3', '이길동', 'qwerty');
            SELECT * FROM member031;

-- [1단계:개념] 3. sequence 수정의 한계를 기술하고, 이를 보완하는 방법을 예제를 통해서 기술하세요
            -- start with 절은 생성 직후의 시작값을 의미, 변경 불가
            --     ==> 시작값을 변경하기 위해서는 
            --         drop sequence 시퀀스명; (삭제명령어)
            --         다시 생성처리
            DROP SEQUENCE seq_hw01;
            CREATE SEQUENCE seq_hw01
                INCREMENT BY 1
                START WITH 100
                MAXVALUE 1000
                CYCLE
                cache 2;
            SELECT seq_hw01.nextval FROM dual;

-- [1단계:개념] 4. 복사테이블의 유형을 예제를 통해서 기술하세요.
            -- 1. 컬럼 구조 + 데이터 복사
            --     create table 테이블명
            --     as select * from 테이블명;
            CREATE TABLE emp_cp0530_1
            AS SELECT * FROM emp;
            SELECT * FROM emp_cp0530_1;
            -- 2. 컬럼 구조만 복사
            --     create table 테이블명
            --     as select * from 테이블명 where 1=0;
            CREATE TABLE emp_cp0530_2
            AS SELECT * FROM emp WHERE 1=0;
            SELECT * FROM emp_cp0530_2;
            -- 3. 컬럼명 변경
            --     create table 테이블명
            --     as select 컬럼1 변경명1, 컬럼2 변경명2
            --     from 테이블명
            CREATE TABLE emp_cp0530_3
            AS SELECT empno no, ename name
            FROM emp;
            SELECT * FROM emp_cp0530_3;
            -- 4. 유형변경
            --     create table 테이블명
            --     as select 함수명(컬럼명) from 테이블명
            CREATE TABLE emp_cp0530_4
            AS SELECT to_char(hiredate, 'YYYY/MM/DD') 입사년월 FROM emp;
            SELECT * FROM emp_cp0530_4;

-- [1단계:확인] 5. 부서별 최고급여자의 사원정보컬럼전체가 들어가는 복사테이블 emp200을 만드세요.
            DROP TABLE emp200;
            CREATE TABLE emp200 
            AS SELECT * 
            FROM emp
            WHERE (sal) in (
                SELECT max(sal) sal
                FROM emp
                GROUP by deptno
            );
            SELECT * FROM emp200;

-- [1단계:개념] 6. 테이블의 구조 변경의 원칙을 예제를 통해서 기술하세요.
            -- alter table add 명령문 사용
            -- 추가되는 컬럼은 테이블의 마지막 부분에 생성, 위치 지정 불가능
            -- 추가된 컬럼에 기본 값을 지정 가능
            -- 수정할 테이블에 기존 데이터가 존재하면 컬럼 값은 null로 입력

-- [1단계:확인] 7. 부서테이블과 사원테이블을 결합한 복사테이블을 만들고, 부서번호 컬럼 삭제
--               문자열 컬럼은  최대크기로 컬럼을 변경하고, 컬럼명도 empno ==> no,
--          ename ==> name, sal ==> salary로 변경 하세요.
DROP TABLE emp2021;
CREATE TABLE emp2021
AS SELECT e.*, dname, loc
FROM emp e, dept d
WHERE e.deptno = d.deptno;
SELECT * FROM emp2021;
ALTER TABLE emp2021
DROP COLUMN deptno;
SELECT max(LENGTHB(ename)), max(LENGTHB(job)), max(LENGTHB(DNAME)), MAX(LENGTHB(LOC))  FROM emp2021;
ALTER TABLE emp2021
MODIFY (ename varchar(6), job varchar2(9), dname varchar2(10), loc varchar2(8));
ALTER TABLE emp2021 RENAME COLUMN empno TO NO;
ALTER TABLE emp2021 RENAME COLUMN ename TO name;
ALTER TABLE emp2021 RENAME COLUMN sal TO salary;


-- 2022-05-31
-- [1단계:개념] 1. 데이터베이스의 생명주기를 예시와 함께 설명하세요.
-- 1. 요구사항 수집 및 분석
--     사용자들의 요구사항을 듣고 분석하여 데이터베이스 구축의 범위를 정하는 단계
--     1) 현실세계의 대상 및 사용자의 요구등을 정리 및 분석
--         - 사용자 식별
--         - 데이터베이스 용도 식별
--         -사용자 요구사항 수집 및 명세
-- 2. 설계
--     분석된 요구사항을 기초로 주요 개념과 업무 프로세스등을 식별하고 (개념적 설계),
--     사용하는 DBMS의 종류에 맞게 변환(논리적 설계)한 후, 데이터베이스 스키마를 도출(물리적 설계)함
--     1) 개념적 모델링
--         중요 개념을 구분
--         핵심 엔티티(독립개체) 도출
--         ERD 작성
--     2) 논리적 모델링
--         각 개념을 구체화
--             ERD-RDB 모델 사상
--             상세 속성 정의s
--             정규화 등
--     3) 물리적 모델링
--         데이터베이스 생성 계획에 따라 객체, 인덱스 등을 생성
--             DB 객체 정의
--             테이블 및 인덱스 등 설계
-- 3. 구현
--     설계 단계에서 생성된 스키마를 실제 DBMS에 적용하여 테이블 및 관련 개체(뷰, 인덱스 등)를 만듬.
-- 4. 운영
--     구현된 데이터베이스를 기반으로 소프트웨어를 구축하여 서비스를 제공함.
-- 5. 감시 및 개선
--     데이터베이스 운영애 따른 시스템이 문제를 관찰하고 데이터베이스 자체의 문제점을 파악하고 개선함.

-- [1단계:개념] 2. 개념적모델링/논리적모델링/물리적 모델링의 차이점을 기술하세요

-- [1단계:확인] 3. 아래와 같은 요구사항에 합당한 개념/논리/물리 모델링을 처리하세요.
--                회사는 네개의 부서를 운영한다. 부서는(부서번호, 부서이름)을 저장한다.
--                부서는 1명 이상의 직원(직원번호,직원이름,직책)을 있다. 각 직원은 하나의 부서에 소속된다.
--                직원은 부양가족(이름, 나이)이 있을 수 있다

-- [1단계:확인] 3. 사원테이블 내에 사원번호와 관리자번호와 1:1관계로 설정한 엔티티타입을 erd로 만드세요.

-- [1단계:확인] 4. 커플사이트에 회원들 간에 남녀 매칭하는 테이블을 구현할려고 한다. erd를 만들고, 카디넬러티를 
--             만든후, 실제 테이블을 만들고 데이터를 입력처리하여 조인결과를 확인하세요.

-- [1단계:개념] 5. DB권한과 역할을 종류를 기술하세요

-- [1단계:확인] 6. 관리자 권한에서 scott3계정을 만들고, 해당 계정으로 접근하게 처리하세요















-- 2022-06-02
-- [1단계:개념] 1. 잘못된 설계에 의한 이상현상을 종류 기술하세요
            -- 1) 삭제 이상
            --     - 튜플(데이터 row단위) 삭제 시 같이 저장된 다른 정보까지 연쇄적으로 삭제되는 현상
            --     - 연쇄 삭제문제 발생
            --     ex) 장미란 학생을 삭제하면 장미란이 듣고있는 스포츠 경영학이 삭제된다.
            -- 2) 삽입 이상
            --     - 튜플 삽입 시 특정 속성에 해당하는 값이 없어 null 값을 입력해야 하는 현상
            --         ==> null 값 문제 발생
            --     - 박세리 학생을 삽입하면 강좌이름, 강의실이 null이되어 메모리의 비효율성 문제가 발생한다.
            -- 3) 수정 이상
            --     - 튜플 수정 시 중복된 데이터의 일부만 수정되어 데이터의 불일치 문제가 일어나는 현상
            --     - 불일치 문제 발생

-- [1단계:확인] 2. 오늘 만든 수강테이블의 삭제이상의 경우를 처리하고 문제점을 기술하세요
            SELECT * FROM studclass1;
            DELETE FROM studclass1
            WHERE name = '장미란';
            -- 특정한 학생의 수강정보를 취소했는데, 강좌 정보도 다 삭제처리됨. 현재 어떤 강좌가 개설되었는지 알수가 없음

-- [1단계:확인] 3. 수강테이블의 등록이상의 경우를 처리하고 문제점을 기술하세요
            INSERT INTO studclass1 values (null, null, null, null, '컴퓨터구조론', '공학관201');
            SELECT * FROM studclass1;
            -- 학생 정보에 해당하는 값이 없어 null 값을 입력해야 하는 현상
            -- ==> null 값 문제 발생

-- [1단계:확인] 4. 수강테이블의 수정이상의 경우를 처리하고 문제점을 기술하세요
            UPDATE studclass1
                SET lcroom = '공학관 103'
                WHERE name = '박지성';
            SELECT * FROM studclass1;
            -- 박지성이 수강하는 모든 강의의 강의실이 공학관 103호로 변경됨.
            -- 원치않는 강의도 변경이 됨.

-- [1단계:확인] 5. 수강테이블의 이상현상을 없애기 위한 테이블 구조를 erd를 통해 분리시키고, 테이블을 작성하고 데이터를 입력하세요
            DROP TABLE studInfo1;
            CREATE TABLE studInfo1
            AS
            SELECT DISTINCT stuno, name, department, address, lecture
            FROM studclass1;
            SELECT * FROM studInfo1;
            DROP TABLE classInfo1;
            CREATE TABLE classInfo1
            AS
            SELECT DISTINCT lecture, lcroom
            FROM studclass1;
            SELECT * FROM classInfo1;

            SELECT stuno, name, department, address, s.lecture, lcroom
            FROM studInfo1 s, classInfo1 c
            WHERE s.lecture = c.lecture;

-- [1단계:확인] 5. 분리된 테이블에서 이상 현상이 더 이상 발생하지 않음을 sql을 통해 처리결과를 출력해보세요.
			-- 삭제
			DELETE FROM studInfo1
			WHERE name = '장미란';
            SELECT * FROM classInfo1;
            -- 삽입
            INSERT INTO classInfo1 values('컴퓨터구조론', '공학관201');
            SELECT stuno, name, department, address, s.lecture, lcroom
            FROM studInfo1 s, classInfo1 c
            WHERE s.lecture = c.lecture;
            SELECT * FROM classInfo1;
            -- 수정
            UPDATE classInfo1
                SET lcroom = '공학관 103'
                WHERE lecture = '데이터베이스';
            SELECT stuno, name, department, address, s.lecture, lcroom
            FROM studInfo1 s, classInfo1 c
            WHERE s.lecture = c.lecture;
            SELECT * FROM classInfo1;
           
          	SELECT * FROM DEPT;



-- 2022-06-03
-- [1단계:개념] 1. database 서버 연동에 필요한 기본 정보를 java에서 설정하는 방법을 기술하세요.
            -- 필요 접속 정보 : ip, port, sid, 계정, 비밀번호
            -- Class.forName("oracle.jdbc.driver.OracleDriver");
            -- String info = "jdbc:oracle:thin:@106.10.23.227:1521:xe";
            -- con = DriverManager.getConnection(info, "scott", "tiger");

-- [1단계:확인] 2. A01_Connection 객체로 연동처리하여, 연동된 내용을 출력하세요.
            /*
            package javaexp.z01_homework;

            import java.beans.Statement;
            import java.sql.*;
            public class A01_Connection {
                private Connection con;
                private Statement stmt;
                private ResultSet rs;

                public void setConn() {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        String info = "jdbc:oracle:thin:@106.10.23.227:1521:xe";
                        con = DriverManager.getConnection(info, "scott", "tiger");
                        System.out.println("접속성공!!");
                    } catch (ClassNotFoundException e) {
                        System.out.println("클래스 에러 : " + e.getMessage());
                    } catch (SQLException e) {
                        System.out.println("DB 처리 에러 : " + e.getMessage());
                    }
                }
                
                public static void main(String[] args) {
                    A01_Connection con = new A01_Connection();
                    con.setConn();
                }

            }
            */
            -- 출력 : 접속성공!!

-- [1단계:개념] 3. DAO 처리에서 사용하는 필드 Connection, Statement, ResultSet 객체의
--       역할과, 각 객체의 상호 생성 메서드를 기본예제를 통해서 설명하세요.
            -- 연결객체 Connection : 접속 정보 + jdbc 드라이버
            --     대확객체 Statement(sql) : sql - db서버에 이용하는 명령어
            --                 select * from emp; (서버로부터 결과를 가져오는 명령어)
            --                 insert into 테이블 values(서버에 명령으로 등록)
            --                 update 수정, delete 삭제
            --     결과객체 ResultSet(data) : 필요로 하는 정보(data)
            --                 select 문을 수행하는 경우만 이 객체를 사용
            --                 1차적으로 ResultSet로 가져오고, 2차적으로 선언한 기본유형 데이터 타입이나,
            --                     문자열 데이터, VO 객체로 입력처리하여 활용한다.
            --     자원해제 위에 나열된 DB서버 접속과 대화 및 결과를 받는 객체들의 자원들 해제
            --             try{}catch, 각 객체의 메모리 자원을 해제

-- [1단계:개념] 4. ResultSet 객체의 기능 메서드 next(), getXXX() 메서드에 대하여 기본예제와 함께 설명하세요.
            -- next() 메소드를 통해 선택되는 행을 바꿀 수 있다. 그리고, 다음행이 내려갈 다음행이 있을 경우 TRUE를 반환하고, 없을 경우 FALSE를 반환한다.
            -- get타입() 메소드를 통해 데이터를 불러올 수 있다.
            -- while(rs.next()) {
            --     System.out.print(cnt + "행" + rs.getInt("empno"));
            --     System.out.print(rs.getString("ename") + "\t");
            --     System.out.print(rs.getString("job") + "\t");
            --     System.out.print(rs.getInt("mgr") + "\t");
            --     System.out.print(rs.getDate("hiredate") + "\t");
            --     System.out.print(rs.getDouble("sal") + "\t");
            --     System.out.print(rs.getDouble("comm") + "\t");
            --     System.out.print(rs.getInt("deptno") + "\n");
            --     cnt++;
            -- }

-- [1단계:확인] 5. 아래의 여러형태의 sql을 처리하는 기능 메서드를 만드세요.
--       1) select * from salgrade (출력만)
            -- public void getsalgrade() {
            --     String sql = "select * from salgrade";
            --     try {
            --         setConn();
            --         stmt = con.createStatement();
            --         rs = stmt.executeQuery(sql);
            --         int cnt = 1;
            --         while(rs.next()) {
            --             System.out.print(cnt + "행" + rs.getInt("grade") + "\t");
            --             System.out.print(rs.getString("losal") + "\t");
            --             System.out.print(rs.getInt("hisal") + "\n");
            --             cnt++;
            --         }
            --         rs.close();
            --         stmt.close();
            --         con.close();
            --     } catch (SQLException e) {
            --         e.printStackTrace();
            --     } catch (Exception e) {
            --         System.out.println("일반 예외 : " + e.getMessage());
            --     } finally {
            --         if(con!=null) {
            --             try {
            --                 con.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --         if(stmt!=null) {
            --             try {
            --                 stmt.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --         if(rs!=null) {
            --             try {
            --                 rs.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --     }
            -- }

--       2) 부서별 최고급여자 (출력만)
            -- public void getMaxsalDept() {
            --     String sql = "SELECT ename, max(sal), deptno FROM emp GROUP BY DEPTNO";
            --     try {
            --         setConn();
            --         stmt = con.createStatement();
            --         rs = stmt.executeQuery(sql);
            --         while(rs.next()) {
            --             System.out.print(rs.getDouble("ename") + "\t");
            --             System.out.print(rs.getDouble("max(sal)") + "\t");
            --             System.out.print(rs.getDouble("deptno") + "\n");
            --         }
            --         rs.close();
            --         stmt.close();
            --         con.close();
            --     } catch (SQLException e) {
            --         e.printStackTrace();
            --     } catch (Exception e) {
            --         System.out.println("일반 예외 : " + e.getMessage());
            --     } finally {
            --         if(con!=null) {
            --             try {
            --                 con.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --         if(stmt!=null) {
            --             try {
            --                 stmt.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --         if(rs!=null) {
            --             try {
            --                 rs.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --     }
            -- }
SELECT max(sal)
FROM emp
where DEPTNO = 20;
--       3) 부서번호가 20인 최고연봉 (리턴유형 double)
            -- public double getMaxsalDept20() {
            --     double max_sal = 0;
            --     String sql = "SELECT max(sal) FROM emp where DEPTNO = 20";
            --     try {
            --         setConn();
            --         stmt = con.createStatement();
            --         rs = stmt.executeQuery(sql);
            --         rs.next();
            --         max_sal = rs.getDouble("max(sal)");
            --         rs.close();
            --         stmt.close();
            --         con.close();
            --     } catch (SQLException e) {
            --         e.printStackTrace();
            --     } catch (Exception e) {
            --         System.out.println("일반 예외 : " + e.getMessage());
            --     } finally {
            --         if(con!=null) {
            --             try {
            --                 con.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --         if(stmt!=null) {
            --             try {
            --                 stmt.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --         if(rs!=null) {
            --             try {
            --                 rs.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --     }
            --     return max_sal;
            -- }

--       4) 사원명이 JONES인 사원정보(출력만)
            -- public void getJONES() {
            --     String sql = "SELECT * FROM emp where ename = 'JONES'";
            --     try {
            --         setConn();
            --         stmt = con.createStatement();
            --         rs = stmt.executeQuery(sql);
            --         while(rs.next()) {
            --             System.out.print(rs.getInt("empno"));
            --             System.out.print(rs.getString("ename") + "\t");
            --             System.out.print(rs.getString("job") + "\t");
            --             System.out.print(rs.getInt("mgr") + "\t");
            --             System.out.print(rs.getDate("hiredate") + "\t");
            --             System.out.print(rs.getDouble("sal") + "\t");
            --             System.out.print(rs.getDouble("comm") + "\t");
            --             System.out.print(rs.getInt("deptno") + "\n");
            --         }
            --         rs.close();
            --         stmt.close();
            --         con.close();
            --     } catch (SQLException e) {
            --         e.printStackTrace();
            --     } catch (Exception e) {
            --         System.out.println("일반 예외 : " + e.getMessage());
            --     } finally {
            --         if(con!=null) {
            --             try {
            --                 con.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --         if(stmt!=null) {
            --             try {
            --                 stmt.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --         if(rs!=null) {
            --             try {
            --                 rs.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --     }
            -- }

--       5) 분기별 최고 급여자(출력만)
            -- public void getMaxsalQ() {
            --     String sql = "SELECT max(sal) FROM emp GROUP BY to_char(hiredate, 'Q')";
            --     try {
            --         setConn();
            --         stmt = con.createStatement();
            --         rs = stmt.executeQuery(sql);
            --         while(rs.next()) {
            -- 				System.out.println(rs.getDouble("max(sal)"));
            --         }
            --         rs.close();
            --         stmt.close();
            --         con.close();
            --     } catch (SQLException e) {
            --         e.printStackTrace();
            --     } catch (Exception e) {
            --         System.out.println("일반 예외 : " + e.getMessage());
            --     } finally {
            --         if(con!=null) {
            --             try {
            --                 con.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --         if(stmt!=null) {
            --             try {
            --                 stmt.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --         if(rs!=null) {
            --             try {
            --                 rs.close();
            --             } catch (SQLException e) {
            --                 e.printStackTrace();
            --             }
            --         }
            --     }
            --     return max_sal;
            -- }