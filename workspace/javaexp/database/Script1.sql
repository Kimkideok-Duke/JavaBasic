/*
1. javaexp 하위에 database 폴더 만들기
/Users/kideokkim/a01_javaexp/workspace/javaexp/database
*/

CREATE TABLE DEPT011
AS
SELECT * FROM dept;
SELECT * FROM DEPT011;

SELECT * FROM EMP011;
SELECT * FROM MEMBER011;
INSERT INTO MEMBER011 values('asd', 'asd', '김길동', 3000, '관리자');

SELECT * FROM PRODUCT001 p;

SELECT *
FROM emp011
WHERE 1=1;

CREATE TABLE member211
AS
SELECT * FROM MEMBER011
WHERE 1=0;

SELECT * FROM MEMBER211;