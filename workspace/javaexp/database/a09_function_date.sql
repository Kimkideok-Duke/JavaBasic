/*
# 날짜 함수
1. 날짜형 데이터
    1/1000 ==> 1초 ==> (60)1분 ==> (60)1시간 ==> (24)1일 ==> (28,30,31)1월 ==> (12)1년 
2. 기본 연산
    날짜 + 1 : 해당 날짜의 1일 이후 처리
    날짜 - 1 : 해당 날짜의 1일 이전 처리
    날짜 + 1/24 : 해당 날짜의 1시간 이후 처리
    날짜 + 200/24/60 : 해당 시간의 분단위로 처리 200분 후 시간처리.
    ex) 현재 시간이 15:18일때, 9시간이후 날짜는 내일이 된다. 날짜 + 9/24
    월단위가 28,30,31 경우로 나누어 지고 해당 월에 따라서 날짜가 다르기 때문에 
    필요한 함수 add_months(날짜, 추가할월)로 하면 월단위로 처리가 된다.
3. 기본함수
    1) sysdate : 현재 시간과 날짜를 날짜형으로 나태내는 키워드
*/
SELECT sysdate 현재, sysdate + 1 내일, sysdate - 1 전날,
            sysdate + (10/24) "10시간이후" FROM dual;
-- ex)
SELECT empno 사원번호, ename 사원명, hiredate - 8/24 "입사 8시간 전", 
        hiredate 입사일, hiredate || '~' ||  (hiredate + 120) "인턴기간", floor(sysdate - hiredate) "현재근무일수(절삭)"
FROM emp;
/*
    2) months_between(날짜1, 날짜2) : 날짜 사이의 개월 수를 표기한다.
        5/19, 6/19 => 1개월, 15일 ==> 0.5개월
        - 소숫점이하의 데이터를 floor로 절삭하는 경우가 많다.
*/
SELECT ename, hiredate, months_between(sysdate, hiredate) "근무개월수",
    floor(months_between(sysdate, hiredate)) "근무개월수2",
    floor(months_between(sysdate, hiredate)/12) "근무연한"
FROM emp;
-- ex1)
SELECT sysdate, sysdate+100,
        months_between(sysdate+100, sysdate) "소숫점이하 표기",
        floor(months_between(sysdate+100, sysdate)) "소숫점이하 절삭"
FROM dual;
/*
# MONTHS_BETWEEN를 사용할 때, 소숫점 이하가 나오는 이유는?
1. 1이라는 월단위가 월마다 차이가 있고, 날짜는 1단위 처리되지만 월로 1단위로 처리되어 15인 경우에 0.5 처리되고
    여기서 하위시간 즉 12시간인 경우 0.05식으로 세분화된 시간적 차이가 있기때문에 사용된다.
2. 이 때, ~부터 시작하여 정확하게 @@개월, @@개월차의 차이가 생긴다.
    @@개월 @@@일인 경우에 @@일 부분을 절삭할 때는 floor()함수를 이용하고 @@개월째 즉, 해당 개월이 이후 아직
    마지막 날짜가 남아있지만 차수로 계산할 때는 ceil()-올림처리를 활용한다.
*/

/*
    3) add_months(날짜형데이터, 추가할개월수) : 해당 날짜에 개월을 더한 날짜 계산
*/
SELECT sysdate, add_months(sysdate, 4) FROM dual;
-- 사원정보를 통해 부서별로 인턴기간을 다르게 처리한다고 한다. 인턴기간의 만료일
--  10 ==> 1개월, 20 ==> 2개월, .. 30 ==> 3개월
SELECT ename, deptno, hiredate, deptno/10 "인턴기간(개월)",
    add_months(hiredate, deptno/10)
FROM emp;
-- 4) next_day : 해당 일을 기준으로 명시된 요일의 다음 날짜를 반환
--      형식 : next_day(지정한 날짜, '요일') : 지정한 날짜로부터 가장 빠른 요일의 날짜
SELECT next_day(sysdate, '일') "가장 빠른 일요일"
FROM dual;
-- 5) last_day : 해당 날짜가 속한 달의 마지막 날짜
SELECT last_day(sysdate) "이번달 마지막",
    last_day(sysdate) + 1 "다음달 1일"
FROM dual;
-- ex1)
SELECT ename 사원명, hiredate 입사일, next_day(hiredate, '토') "첫번째 토요일"
FROM emp;
-- ex2)
SELECT last_day(hiredate)+1 급여일, last_day(hiredate)-hiredate 근무일수
FROM emp;
/*
# 날짜 데이터의 round, trunc, floor, ceil 함수
1. 함수를 적용해서, 날짜 계산은 소숫점이하 나타날 때가 많다.
    1일 ==> 현재시간이 함께 계산되기에 정확하게 안되는 경우가 있다.
    5/22 0시기준 ==> 현재시간 sysdate로 처리한 시간도 포함되기에 ceil()올림이나, floor()내림 처리하지 않으면
                    소숫점이하의 시간 내용도 포함하게 된다.
    add_months
    months_between : 월이 1이 되기에 15일 0.5 12시간 0.55등으로 기준되는 단위에서 소숫점이하로 처리되는 경우가 많다.
*/