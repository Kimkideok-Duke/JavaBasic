/*
# 이상현상의 개념
1. 종류
    1) 삭제 이상
        - 튜플(데이터 row단위) 삭제 시 같이 저장된 다른 정보까지 연쇄적으로 삭제되는 현상
        - 연쇄 삭제문제 발생
        ex) 장미란 학생을 삭제하면 장미란이 듣고있는 스포츠 경영학이 삭제된다.
    2) 삽입 이상
        - 튜플 삽입 시 특정 속성에 해당하는 값이 없어 null 값을 입력해야 하는 현상
            ==> null 값 문제 발생
        - 박세리 학생을 삽입하면 강좌이름, 강의실이 null이되어 메모리의 비효율성 문제가 발생한다.
    3) 수정 이상
        - 튜플 수정 시 중복된 데이터의 일부만 수정되어 데이터의 불일치 문제가 일어나는 현상
        - 불일치 문제 발생
        ex) 자료구조를 듣는 박지성의 주소를 변경하면 동일하지만 컴퓨터 공학을 듣는 박지성도
            같은 학생이지만 주소가 변경되지 않는다. 일관성을 확보할 수 없다.

    캡쳐된 학생 수강 erd를 만들고, 테이블과 함께 데이터를 입력까지 하세요
*/
DROP TABLE studclass1;
CREATE TABLE studclass1(
    stuno NUMBER,
    name varchar2(50),
    department varchar2(50),
    address varchar2(100),
    lecture varchar2(50),
    lcroom varchar2(50)
);
INSERT INTO studclass1 values(501, '박지성', '컴퓨터과', '영국 맨체스터', '데이터베이스', '공학관 110');
INSERT INTO studclass1 values(401, '김연아', '체육학과', '대한민국 서울', '데이터베이스', '공학관 110');
INSERT INTO studclass1 values(402, '장미란', '체육학과', '대한민국 강원도', '스포츠경영학', '체육관 103');
INSERT INTO studclass1 values(502, '추신수', '컴퓨터과', '미국 클리블랜드', '자료구조', '공학관 111');
INSERT INTO studclass1 values(501, '박지성', '컴퓨터과', '영국 맨체스터', '자료구조', '공학관 111');
SELECT * FROM studclass1;

/*
# 잘못된 설계의 예제 함께 하고, 수정해 보기(계절학기 수강 테이블)
1. 테이블 만들기
    여름(식별자, 클래스, 가격)
*/
CREATE TABLE summer011(
    sid NUMBER,
    class varchar2(50),
    price number
);
INSERT INTO summer011 values(100, 'fortran', 20000);
INSERT INTO summer011 values(150, 'pascal', 15000);
INSERT INTO summer011 values(200, 'c', 10000);
INSERT INTO summer011 values(250, 'fortran', 20000);
SELECT * FROM SUMMER011;
-- ex1)
SELECT sid, price
FROM summer011;
-- ex2)
SELECT price
FROM summer011
WHERE class = 'c';
-- ex3)
SELECT DISTINCT class
FROM summer011
WHERE price = (
    SELECT max(price)
    FROM summer011
);
-- ex4)
SELECT count(sid), sum(price)
FROM summer011;
-- # 삭제 이상
DELETE FROM summer011
WHERE sid = 200;
-- 그리고 문제점이 무엇인가?
--      특정한 학생의 수강정보를 취소했는데, 강좌 정보도 다 삭제처리됨.
--      현재 어떤 강좌가 개설되었는지 알수가 없음
--      이와 같이 특정한 컬럼에 의해 정보가 삭제되었을때, 원치않는 정보도 같이 삭제되어 버리는 현상을 삭제 이상이라고 한다.
end;
-- # 삽입 이상
INSERT INTO summer011 values (null, 'JAVA', null);
-- # 수정 이상
UPDATE summer011
    SET price = 15000
    WHERE sid >= 100 AND class = 'fortran';
-- 1) 어떤 문제가 발생하는가?
--      특정한 sid의 fortran만 수강료를 20000으로 변경하고, 그 외에는 15000 그대로 있다.
--      특정한 정보를 수정할 때, 등록된 모든 데이터를 수정처리해야 되는 문제가 발생한다.
--      데이터가 등록이 잘 못 되어 있거나 오기가 있을 때 에 문제가 발생한다.
--          fortran, 'fortran', '포트란'등 입력된 데이터가 여러가지 경우일 경우 정상적인 수정이 불가능하다.
UPDATE summer011
    SET price = 20000
    WHERE class = 'fortran';
DELETE
FROM summer011
WHERE sid IS NULL;
SELECT * FROM summer011;
/*
# 이상현상이 발생하지 않는 테이블 생성
*/
-- summer01 ==> summerPrice01(class, price), summerEnroll(sid, class)
SELECT * FROM summer011;
-- 1) 계절학기 과목별 수강료
CREATE TABLE summerPrice011
AS
SELECT DISTINCT class, price
FROM summer011;
SELECT * FROM summerPrice011;
-- 2) 학생별 수강신청과목
CREATE TABLE summerEnroll011
AS
SELECT sid, class
FROM summer011;
SELECT * FROM summerEnroll011;
-- 학생별 수강과목과 가격
SELECT sid, p.class, price
FROM summerPrice011 p,summerEnroll011 e
WHERE p.class = e.class;
-- summerPrice011, summerEnroll011를 이용해서 아래의 초기 sql을 작성해보세요.
-- 1)
SELECT sid, p.class
FROM summerPrice011 p,summerEnroll011 e
WHERE p.class = e.class;
-- 2)
SELECT price
FROM summerPrice011 p,summerEnroll011 e
WHERE p.class = e.class;
-- 3)
SELECT DISTINCT p.class
FROM summerPrice011 p,summerEnroll011 e
WHERE p.class = e.class
AND price = (
    SELECT max(price)
    FROM summerPrice011
);
-- 4)
SELECT count(sid), sum(p.price)
FROM summerPrice011 p,summerEnroll011 e
WHERE p.class = e.class;