SELECT*FROM emp;

SELECT empno 사원번호,
        ename 사원명,
        job 직책,
        mgr 관리자,
        hiredate 입사일,
        sal 급여,
        comm 보너스,
        deptno 부서번호
FROM emp;

SELECT sal 기본급여,
        deptno 보너스,
        sal+deptno 총급여
FROM emp;

SELECT ename || '님의  사원번호는 ' || empno || '이고, 올해 연말 보너스는 연봉의 20%인 ' || (sal*0.2) || '입니다.' show
FROM emp;
SELECT ename || '님의 입사일은 ' || hiredate || '이고, 현재 연봉의 1/13인 월급여는 ' || round(sal/13) || '만원.' show
FROM emp;
SELECT ename || '님의 이번달 보너스는 연봉(' || sal ||')의 ' || deptno || '%기준으로 ' || sal*(deptno/100) || '만원 지급합니다.' show
FROM emp;

-- 사원정보에서 급여가 2000~5000인 사원번호, 사원명, 급여를 출력하세요.
SELECT empno 사원번호,
        ename 사원명,
        sal 급여
FROM emp
WHERE sal BETWEEN 2000 AND 5000;

-- 직책이 CLERK와 MANAGER를 검색하여 이에 해당 하는 사원 정보를 출력하세요.
SELECT *
FROM emp
WHERE job = 'CLERK'
OR job = 'MANAGER';

-- 사원번호 7566, 7782가 소속된 부서번호에 해당하는 사원정보를 출력하세요.
SELECT *
FROM emp
WHERE deptno in(
        SELECT deptno
        FROM emp
        WHERE empno = 7566 OR empno = 7782
);

-- 1981에 입사한 사원들의 직책을 기준으로 사원정보를 출력하세요..
SELECT *
FROM emp
WHERE hiredate LIKE '%81%'
ORDER BY job;

-- like 키워드로 1/4분에 입사한 사원들의 부서정보와 동일한 사원들을 출력하세요.
SELECT *
FROM emp
WHERE deptno in(
        SELECT deptno
        FROM emp
        WHERE to_char(hiredate) LIKE '%01%'
        OR to_char(hiredate) LIKE '%02%'
        OR to_char(hiredate) LIKE '%03%'
        OR to_char(hiredate) LIKE '%04%'
);

-- '데이터%' : 해당 데이터로 시작
-- '%데이터' : 해당 데이터로 끝
-- '%데이터%' : 해당 데이터 포함
-- '_데이터' : 첫자이후에 특정데이터 포함 - 자릿수 keyword 검색
-- '데이터_' : 데이터가 마지막 한자 데이터 포함
SELECT *
FROM emp
WHERE job LIKE 'S%';
SELECT *
FROM emp
WHERE job LIKE '%T';
SELECT *
FROM emp
WHERE job LIKE '%ER%';
SELECT *
FROM emp
WHERE job LIKE '_A%';
SELECT *
FROM emp
WHERE job LIKE '%S_';

-- ename의 첫번째에서 3번째 데이터 추출, job과 혼합하여 화면에 출력하되, 
-- substr(), concat()함수를 활용하세요
SELECT concat(substr(ename, 3, 1), job)
FROM emp;

-- ||, substr을 활용하여 1980에 입사한 사람의 입사일정보를 @@@는 @@@@년 @@월 @@일에 입사했습니다.로 
-- 출력하세요(ename, hiredate활용)
SELECT ename || '는 ' 
        || '19' || substr(hiredate, 0, 2) || '년 ' 
        || substr(hiredate, 4, 2) || '월 '
        || substr(hiredate, 7, 2) || '일에 입사했습니다' show
FROM emp;

-- 사원번호, 사원명, 직책 급여을 출력하되, 사원명6, 직책9은 최고 크기를 확인하고, 
-- 사원명과 직책은 각각 최고 크기의 기준으로 왼쪽과 오른쪽에 #을 삽입하여 출력하세요.
SELECT empno, length(ename), length(job),lpad(ename, 6, '#'), rpad(job, 9, '#')
FROM emp;

-- 아래의 형식으로 함수를 적용해서 출력하되 ename이 대소문자 구분없이 a/A인 데이터로 두번째 포함되어 검색 되게 처리하세요.
                --  The salary of Ward is @@@ won!!!
SELECT 'The salary of ' || initcap(ename) || ' is ' || sal || 'won!!!'
FROM emp
WHERE ename LIKE '_A%'
OR ename LIKE '_a%';

-- 근무일수를 2분위로 나누어서(중앙값을 기준)서 보너스를 급여의 150%,200% 차등 지급하기로 했다. 
-- 사원명, 입사일, 분류, 보너스금액
SELECT ename, hiredate, months_between(sysdate, hiredate),
FROM emp
ORDER BY months_between(sysdate, hiredate) desc;

SELECT ename,
        sysdate - hiredate workdate1,
        floor(sysdate - hiredate) workdate2
FROM emp
ORDER BY workdate1;
-- 육안으로 중앙값 식별
SELECT floor(MEDIAN(sysdate - hiredate)) 중앙값,
        floor(avg(sysdate - hiredate)) 평균값
FROM emp;
-- 함수를 이용해서 중앙값 : 14909, 평균값 : 14918
SELECT ename, hiredate,
        floor(sysdate - hiredate) workdate2,
        floor((sysdate - hiredate)/14955) 구분자,
        sal,
        (floor(((sysdate-hiredate)/14955)+3)*0.5)*100 || '%' "보너스 비율",
        sal*(floor((sysdate - hiredate)/14955)+3)*0.5 "보너스 급여"
FROM emp; 

-- 오늘을 1일을 기준으로 1000일 기념일의 날짜와  걸린 기간을 @@년 @@개월 @@일 형식으로 표기하세요. 
-- hint)mod함수 활용
SELECT sysdate+1000 "날짜", trunc(1001/365) || '년 ' 
                        || trunc(mod(1001, 365)/31) || '개월' 
                        || mod(mod(1001, 365), 31) || '일' "걸린기간"
FROM dual;

--  사원 정보 테이블에 입사한 월의 1일을 사원명과 함께 출력하세요
SELECT ename, 
        to_char(hiredate, 'MM') || '월' ||'1일' "입사한 월의 1일"
FROM emp;

-- 2022-05-20
-- [1단계:개념] 1. 형변환 형태의 2가지와 타입에 따른 유형3가지를 기본 예제를 통하여 기술하세요.
--              1. 묵시적 형변환
--                1) 문자열을 묵시적으로 숫자로 변환해서 조건처리
--                2) 명시적 형변환인 to_number()함수를 통해서 처리한다.
--                3) 날짜형의 묵시적 형변환

-- [1단계:확인] 2. 사원 정보 테이블에 입사한 월의 1일을 사원명과 함께 출력하세요
                SELECT ename, 
                        to_char(hiredate, 'MM') || '월' ||'1일' "입사한 월의 1일"
                FROM emp;

-- [1단계:개념] 3. to_char(날짜데이터,'옵션') 에서 날짜처리하는 옵션 매개변수에 대하여 기술하세요.
                -- CC : 세기
                -- YYYY : 연도
                -- Q : 분기
                -- MM : 월
                -- MONTH : 월 영문
                -- WW : 연단위 주표기
                -- W : 월단위 주표기 
                -- DD : 일
                -- DAY : 요일
                -- AM/PM : 오전/오후 A.M/P.M
                -- HH/HH12 : 시간(1~12) 표시
                -- HH24 : 24시간(0~23) 표시
                -- MI : 분
                -- SS : 초

-- [1단계:확인] 4. 사원의 입사분기별로 보너스를 차등 지급하고자 한다. 열단위로 처리하세요.사원명, 급여, 보너스 %, 보너스
--       (급여의 1/4분기 10%, 1/4분기 20%, 1/4분기 30%, 1/4분기 30%)
                SELECT ename 사원명, sal 급여, 
                        to_number(to_char(hiredate, 'Q')) * 10 || '%' "보너스 %",
                        sal * (to_number(to_char(hiredate, 'Q')) * 10) / 100 보너스
                FROM emp;
-- [1단계:확인] 5. 입사월이 4/4분기에 해당하는 사원의 정보를 +9시간 더하여 다음과 같이 출력하세요
--       사원명, @@@년 @@월 @@일 +9 출근
                SELECT ename 사원명, 
                        to_char(hiredate, 'YYYY"년 "MM"월 "DD"일 + 9 출근"') "@@@년 @@월 @@일 + 9 출근" 
                FROM emp
                WHERE to_number(to_char(hiredate, 'Q')) = 4;

-- [1단계:확인] 6. [nvl2활용] comm일 null일때는 sal의 15%로 설정하고, null일 아닐 때는 comm에서 sal의 5%를 더하여 보너스금액을
--               설정하여   사원명 연봉 보너스  를 출력하세요.
                SELECT ename 사원명, sal 연봉, sal * nvl2(comm, 5, 15) / 100 보너스
                FROM emp;

-- [1단계:확인] 7. [중첩함수] 사원번호를 기준으로 짝수이면 홍팀, 홀수이면 청팀으로 처리하여 출력하세요
                SELECT ename 사원명, empno 사원번호,
                        decode(mod(empno, 2), 0, '홍팀',
                                              1, '청팀') 팀
                FROM emp; 

-- 2022-05-23
-- [1단계:개념] 1. case when의 2가지 기본형식을 정리하고 예제를 통해서 비교하세요.
        --     1) 형식1
        --     CASE WHEN 논리/관계식1 THEN 처리할 데이터
        --          WHEN 논리/관계식2 THEN 처리할 데이터
        --          ...
        --          ELSE 위에 선언된 논리/관계식이 아닐 때 처리할 데이터 
        --     END
        --     2) 형식2
        --     CASE 컬럼|데이터
        --         WHEN 컬럼에 데이터1일 때 THEN 처리할 데이터
        --         WHEN 컬럼에 데이터2일 때 THEN 처리할 데이터
        --         ...
        --         ELSE 위에 WHEN에 나열된 데이터가 아닐 때, 처리할 데이터
        --     END

-- [1단계:확인] 2. 입사월을 3가지 분류를 나누어 보너스금액을 10%, 20%, 30%로 정하여 출력하세요.
                SELECT ename, to_number(to_char(hiredate, 'MM')) 입사월,
                        CASE WHEN to_number(to_char(hiredate, 'MM')) >= 8 THEN '10%'
                             WHEN to_number(to_char(hiredate, 'MM')) >= 4 THEN '20%'
                             WHEN to_number(to_char(hiredate, 'MM')) >= 0 THEN '30%'
                        END 보너스
                FROM emp;

-- [1단계:확인] 3. case when 2번째 형식(복합함수)으로 상반기/하반기 입사자로 구분하여 출력하세요.
                SELECT ename, to_number(to_char(hiredate, 'MM')) 입사월,
                        CASE floor(to_number(to_char(hiredate, 'MM'))/7) WHEN 0 THEN '상반기 입사자'
                                                                         WHEN 1 THEN '하반기 입사자'
                        END 입사시기
                FROM emp;

-- [1단계:개념] 4. 그룹함수의 개념과 기본형식을 기본예제를 통해서 설명하세요.
                -- 그룹함수 : 테이블의 전체 행을 하나 이상의 컬럼을 기준으로 그룹화하여 그룹별로 결과를 출력하는 함수이다.
                --          그룹함수는 통계적인 결과를 출력하는데 자주 사용한다
                SELECT deptno, round(avg(sal),1)
                FROM emp
                GROUP BY deptno;

-- [1단계:확인] 5. 분기별, 입사 사원수의 수가 2이상인 분기(1~4분기)와, 해당분기의 최고 급여를 출력하세요.
                SELECT to_number(to_char(hiredate, 'Q'))||'분기' 분기, max(sal) 최고급여
                FROM emp
                GROUP BY to_number(to_char(hiredate,'Q'))
                HAVING count(ename)>=2;

-- [1단계:확인] 6. 급여를 5000이상부터 시작하여 천단위로 등급을 나누고, 등급별 인원수와 평균 급여를 출력하세요.
                SELECT 
                        CASE floor(sal/1000) WHEN 5 THEN '5천이상'
                                            WHEN 4 THEN '4천이상'
                                            WHEN 3 THEN '3천이상'
                                            WHEN 2 THEN '2천이상'
                                            WHEN 1 THEN '1천이상'
                                            WHEN 0 THEN '1천이하'
                                            ELSE '잘못된 금액'
                        END 등급,
                        count(ename) 인원수, round(avg(sal),0) 평균급여
                FROM emp
                GROUP BY floor(sal/1000)
                ORDER BY 등급 desc;
-- [1단계:개념] 7. 조인이란 무엇인가? 기본 예제를 통하여 기술하세요
                -- 하나의 sql명령문에 의해 여러 테이블에 저장된 데이터를 한번에 조회할 수 있는 기능을 말한다.
                
-- [1단계:확인] 8. [조인]연봉이 1000~2000사이의 사원의 부서명을 출력하세요.
                SELECT e.job, d.*
                FROM emp e, dept d
                WHERE e.deptno = d.deptno
                AND sal>=1000 
                AND sal<=2000;

-- [1단계:확인] 9. 부서위치(loc)별 평균 연봉을 출력하세요.
                SELECT d.loc 부서위치, round(avg(e.sal),0) 평균연봉
                FROM emp e, dept d
                WHERE e.deptno = d.deptno
                GROUP BY d.loc;

SELECT * FROM emp;

-- 2022-05-24
-- [1단계:개념] 1. natural join의 기능을 기술하고, 일반 equi 조인과의 차이점을 기술하세요.
                -- EQUI JOIN : (동등조인)조인 대상 테이블의 칼럼 값들이 서로 정확하게 일치하는 경우에 사용하는 
                --             JOIN으로 WHERE 절에 '=' (Equality Condition) 연산자를 사용하여 JOIN 조건을 명시한다.
                -- NATURAL JOIN : EQUI JOIN에서 JOIN 조건이 '='일 때 동일한 속성이 두 번 나타나게 되는데, 이 중 중복을 제거하여 같은 속성을 한번만 표기하는 방식이다.
                --                NATURAL JOIN은 두 테이블의 동일한 이름을 가지는 칼럼이 모두 조인된다.
                --                동일한 칼럼을 내부적으로 찾게 되므로 테이블 별칭(Alias)을 주면 오류가 발생한다.

-- [1단계:개념] 2. not equi join이란 무엇인가 기본예제를 통해서 설명하세요.
                -- <,between a and b와 같이 '=' 조건과 같이 동일하지 않고, 범위를 지정하여 조인하는 경우를 말한다.
                SELECT ename, sal, grade
                FROM emp e, salgrade s
                WHERE sal BETWEEN losal AND hisal;

-- [1단계:확인] 3. 사원번호를 기준으로 4개의 임의 범위를 정하여 복사테이블을 만들어 저장하고(salgrade를 복사한 복사테이블(part)),
--             사원번호를 통한 출장소 지정 1분위 : 서울 2분위 : 부산 3분위 : 제주  4분위 : LA 처리하여 테이블의 데이터를 수정하고, 
--             no equi join 처리하세요.
--             grade hisal rsal ==> loc hiempno rempno
--                                  서울 7001     7500
--                                  부산 7501     7600
--                                  ..
                SELECT * FROM salgrade;
                CREATE TABLE part
                AS SELECT * FROM salgrade;
                SELECT * FROM emp;
                SELECT ''||grade loc, hisal hiempno, losal rempno
                FROM salgrade;

                -- ''||grade loc : 숫자형을 문자열로 바꾸고 이름을 loc변환처리
                CREATE TABLE part1
                AS
                SELECT ''||grade loc, hisal hiempno, losal rempno
                FROM salgrade;

                -- 1분위 : 서울 2분위 : 부산 3분위 : 제주  4분위 : LA
                SELECT min(empno) 최소,
                        round((min(empno)+round(median(empno)))/2) "1분위",
                        round(median(empno)) 중앙,
                        (round(median(empno))+max(empno))/2 "3분위",
                        max(empno) 최대
                FROM emp;
                
                -- 7369~7555 서울
                -- 7556~7740 부산
                -- 7741~7837 제주
                -- 7838~7934 LA
                SELECT ename, empno, loc
                FROM emp e, part1 p
                WHERE e.empno BETWEEN rempno AND hiempno;


-- [1단계:개념] 4. outer join이란 무엇인가? 기본예제를 통하여 개념을 설명하세요.
                -- 조인 조건을 만족하지 않는 데이터를 처리하기 위한 JOIN으로 INNER JOIN이 두 테이블에 있는 일치하는 값만 가져오는 것에 비해 
                -- OUTER JOIN은 어느 한 쪽의 데이터를 모두 가져온다.
                -- JOIN 조건에 일치하지 않은 값을 추가 할 때 사용한다.
                SELECT e.*, dname, loc
                FROM emp e, dept d
                WHERE e.deptno(+) = d.deptno;

-- [1단계:확인] 5. emp_cp100에 부서정보를 할당하지 않고, 신규 사원정보를 추가한 후, emp_cp100기준으로 부서정보와
--             outer조인된 데이터를 출력하세요.
                SELECT * FROM emp_cp100;
                SELECT *
                FROM emp_cp100 e, dept d
                WHERE e.deptno = d.deptno(+);
-- [1단계:개념] 6. self join에 대하여 기본예제로 기술하세요.
                -- 1) 하나의 테이블 내에 있는 컬럼끼리 연결하는 조인이 필요한 경우에 사용된다.
                -- 2) 조인 대상 테이블이 자신 하나라는 것 외에는 equi join과 동일하다.
                CREATE TABLE emp_family
                AS
                SELECT empno NO, mgr refno, ename name, job role01 
                FROM emp;
                SELECT *
                FROM emp_family;

-- [1단계:개념] 7. subquery란 무엇인가 기본예제와 함께 개념을 설명하세요.
                -- 하나의 sql 명령문의 결과를 다른 sql명령문에 전달하기 위해 두개 이상의 sql명령문을 
                -- 하나의 sql 명령문으로 연결하여 처리하는 방법을 말한다.
                SELECT *
                FROM emp
                WHERE sal = (
                        SELECT min(sal)
                        FROM emp
                );

-- [1단계:확인] 8. 관리자가 'MANAGER'인 사원의 최저 급여보다 적은 사원들 출력하세요.
                SELECT *
                FROM emp
                WHERE sal < (
                        SELECT min(sal)
                        FROM emp
                        WHERE mgr IN (
                                SELECT empno
                                FROM emp
                                WHERE job = 'MANAGER'
                        )
                );

-- [1단계:확인] 9. emp, salgrade테이블과 조인하여, 등급이 1~2등급인 사원의 최고 급여보다 많은 사원을 출력하세요.
                SELECT *
                FROM emp
                WHERE sal > (
                        SELECT max(sal)
                        FROM emp e, salgrade s
                        WHERE sal BETWEEN losal AND hisal
                        AND grade in (1,2)
                );