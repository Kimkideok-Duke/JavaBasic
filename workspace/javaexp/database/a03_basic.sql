/*
# NULL 데이터
1. database에서는 테이블 내에 특정 컬럼에 데이터가 없는 것을 NULL이라고 한다.
2. 미확인 값이나 아직 값이 적용되지 않는 것을 의미
3. 0이나 ''(공백)과 구분되어 정의되지 않는 값을 의미한다.
*/
SELECT * FROM EMP_CP100;
INSERT INTO EMP_CP100(ename) value(null);
INSERT INTO EMP_CP100(ename) value(''); -- DB에서는 null로 처리한다.
INSERT INTO EMP_CP100(ename) value(' ');
/*
4. NULL값은 다른 데이터와 연산 결과같은 NULL로 된다.
    select sal + NULL ==> NULL
5. 위와 같이 특정한 숫자형 데이터와 연산시, NULL이 되므로, NULL값이 나올 때는 defalut 값을 0으로 설정하여야 정상적인 연산을 할 수 있다.
    cf) 이 떄, null처리 관련 함수들이 필요로 한다.nvl, nullif
    대표적인 nvl(데이터, null일때 처리할 default값) ==> 함수에서 다시 진행
6. 조건절에 null 검색하려면 컬럼명 = null는 처리가 안된다.
    반드시 컬럼명 is null 형태로 처리해야 한다.
    cd) null 아닌 경우를 검색할 때는 컬러명 is not null
*/
-- null값의 연산 결과는 null된다
SELECT sal, comm, sal+comm 합산, sal+nvl(comm,o) nvl처리합산
FROM emp;
SELECT *
FROM emp;
-- comm가 null인 데이터를 검색
SELECT empno, comm
FROM emp
WHERE comm IS NULL;
-- comm = NULL; 안됨
SELECT empno, comm
FROM emp
WHERE comm IS NOT NULL; -- NULL 아닌 데이터 검색
-- ex1)
SELECT *
FROM emp
WHERE deptno in(
    SELECT deptno
    FROM emp
    WHERE mgr IS NULL
);
-- ex2)
SELECT *
FROM emp
WHERE nvl(comm,0) > 0;

SELECT ename, sal, comm, sal + comm "합산"
FROM emp
WHERE nvl(comm, 0) > 0; -- null과 0을 함께 제외