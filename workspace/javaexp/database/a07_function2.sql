/*
# 문자열 조작함수들
1. instr
    1) 특정 문자가 출현하는 첫번째 위치를 반환
        instr(데이터, '검색할 문자') : 해당 위치를 return
        instr(데이터, '검색할 문자', 검색할 시작위치, 매칭대상이 나올 횟수) : 
            1부터 시작해서 검색할 시작위치와 검색되어 나온 데이터의 @@번째 횟수를 지정해서 index를 나오게 할 수 있다.
    ps) 특정 컬럼의 데이터가 많을 때, 해당 데이터가 있는지 여부와 위치를 검색해줄 때, 사용된다.
*/
SELECT instr('SQL*Plus', '*') FROM dual;
SELECT instr('Welcome to Oracle 11g', 'o', 3, 2) FROM dual;
-- Welcom to Oracle 11g 데이터의 'o'로 검색할 때, 시작을 3번째부터 하고, 두번째 o가 나오는 index 추출
-- ex)
SELECT job, instr(job, 'A') pos -- 0은 데이터가 나오지 않을때를 의미한다.
From emp;
/*
2. lpad(left padding), rpad(right padding)
    1) 전체 문자의 크기를 지정하고, 그 크기보다 못할 때,
        왼쪽/오른쪽에 특정한 문자를 추가하게 처리하는 기능을 말한다.
    2) 형식
        lpad(데이터, 크기지정, 덧붙일문자열)
        rpad(데이터, 크기지정, 덧붙일문자열)
    ps) 특정한 컬럼을 동일한 자리수를 만들거나, 가변형 데이터를 고정형 데이터로 변경할 때 주로 사용된다.
        varchar2 ===> char
*/
SELECT lpad('sql', 5, '*') sh1,
        rpad('sql', 5, '#') sh2
FROM dual;
-- ex)
SELECT lpad(ename, 6, '#'),
        rpad(job, 8, '@')
FROM emp;
/*
3. ltrim/rtrim
    1) trim은 절삭이라는 말로, 오른쪽 또는 왼쪽에 있는 특정한 문자열을 삭제처리할 때 활용된다.
        - ltrim(데이터, '제거할 문자') : 왼쪽에 제거할 문자를 없애주는데 반복적으로 제거가 된다.
        - rtrim(데이터, '제거할 문자') : 오른쪽에 제거할 문자를 없애주는데 반복적으로 제거가 된다.
        - trim('양쪽 삭제할 문자', from 데이터) : 양쪽에 삭제할 문자를 한번에 제거 처리한다.
        cf) char 고정형 데이터에 입력된 데이터의 크기가 다를 때,
            varchar2 가변형 데이터로 변환할 때, 활용할 수 있다.
*/
SELECT ltrim('****sql****', '*') str1,
        rtrim('****sql****', '*') str2,
        trim('*' FROM '****sql****') str3
FROM dual;
-- ex)
SELECT ltrim(job,'S'),
        rtrim(ename, 'N')
FROM emp;