DROP TABLE BOARD011;
create table board011(
		no number primary key,
		refno number,
		subject varchar2(200),
		content varchar2(2000),
		writer varchar2(100),
		readcnt number,
		regdte date,
		uptdte DATE
	);
	create sequence board011_seq
		start with 1
		minvalue 1
		maxvalue 999999
		increment by 1;
	-- # sample 데이터 등록
	insert into board011 values(board011_seq.nextval, 0, '첫번째글', '내용', '홍길동',
		0, sysdate, sysdate);
	SELECT *
	FROM board011
	WHERE 1=1
	AND subject LIKE '%'||''||'%'
	AND writer LIKE '%'||''||'%'
	ORDER BY regdte DESC;
-- 2. sql 작성
	select *
   	from board011
   	order by regdte desc;
   	
SELECT * FROM BOARD011;

UPDATE board011
	SET subject = '제목수정1',
		content = '내용수정2',
		uptdte = sysdate
WHERE NO = 1;

/*
UPDATE board011
	SET subject = #{subject},
		content = #{content},
		uptdte = sysdate
WHERE NO = #{no};

DELETE
from board011
WHERE NO = #{no};
*/
DELETE
from board011
WHERE NO=1;

DROP SEQUENCE board_seq01;
CREATE SEQUENCE board_seq01
	start WITH 1
	MINVALUE 1
	MAXVALUE 999999
	increment BY 1;

INSERT INTO board011 values(
	board_seq01.nextval,0,'첫번째글','내용','홍길동',0,sysdate,sysdate);	

create table boardfile(
	no number,
	path varchar2(100),
	fname varchar2(100),
	regdte date,
	uptdte date,
	etc varchar2(200)
);
SELECT * FROM boardfile;

create table boardfile(
	no number,
	path varchar2(100),
	fname varchar2(100),
	regdte date,
	uptdte date,
	etc varchar2(200)
);
SELECT * FROM boardfile;

INSERT INTO BOARDFILE values(board_seq01.nextval, #{path}, #{fname}, sysdate, sysdate, '');

SELECT b.*, f.fname
FROM board b, boardfile f
WHERE b.NO = f.no(+)
AND b.NO = #{NO};

SELECT level, b.*
FROM board011 b
WHERE 1=1
AND subject LIKE '%'||''||'%'
AND writer LIKE '%'||''||'%'
start with refno = 0
connect by prior no = refno
order siblings by no desc;