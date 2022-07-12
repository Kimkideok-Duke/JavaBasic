create table board011(
		no number primary key,
		refno number,
		subject varchar2(200),
		content varchar2(2000),
		writer varchar2(100),
		readcnt number,
		regdte date,
		uptdte date
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
   	
SELECT * FROM BOARD;