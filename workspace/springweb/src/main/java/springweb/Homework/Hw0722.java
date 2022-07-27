package springweb.Homework;

public class Hw0722 {
//	07-22
//	[1단계:개념] 1. 페이징 처리의 기본속성을 처리하는 순서를 기술하고, 해당 속성이 처리되는 형식을 표기하세요.
        //      1) sql 작성
        //         select rownum 
        //         from ...
        //         where rownum between 1 and 5
        //         5개씩 1 page인 경우  1~5
        //             2 page인 경우  6~10
        //             3 page인 경우  11~15
        //             ...
        //         SELECT count(*)
        //         FROM board;
                
        //         SELECT * 
        //         FROM (
        //             select rownum cnt, level, b.*  
        //             from board b 
        //             WHERE 1=1
        //             start with refno = 0
        //             connect by prior no = refno
        //             order siblings by no DESC )
        //         WHERE cnt BETWEEN 1 AND 5;
        //         하단의 속성을 처리한 boardsch vo 생성(공통 mybatis부분에 등록)
                    
        //         dao
        //             public List<Board> totCnt(BoardSch sch);
        //         mapper
        //             총건수 sql 처리
        //             <select id="boardList" resultType="board"
        //                     parameterType="boardsch">			
        //             SELECT * 
        //             FROM (			
        //                 select rownum cnt, level, b.*  
        //                 from board b 
        //                 WHERE 1=1
        //                 <if test="subject!=null">
        //                 AND subject LIKE '%'||#{subject}||'%'
        //                 </if>
        //                 <if test="writer!=null">
        //                 AND writer LIKE '%'||#{writer}||'%'
        //                 </if>
        //                 start with refno = 0
        //                 connect by prior no = refno
        //                 order siblings by no desc )	
        //             WHERE cnt BETWEEN 1 AND 5	
        //         <select id="totCnt" parameterType="boardsch">	 
        //             SELECT count(*)
        //                 FROM board
        //             WHERE 1=1		 
        //             <if test="subject!=null">
        //             AND subject LIKE '%'||#{subject}||'%'
        //             </if>
        //             <if test="writer!=null">
        //             AND writer LIKE '%'||#{writer}||'%'
        //             </if>			 	 			 
        //         </select>	 
        //     2) 검색시 필요한 속성을 vo로 설정
        //         전체건수 count
        //         한번에 보여줄 건수 : pageSize
        //         총 페이지 수 : pageCount
        //         클릭한 현재 페이지 번호 : curPage
        //         해당 페이지의 시작번호 : start
        //         해당 페이지의 마지막 번호 : end
                
        //         #페이지 블럭 처리..
        //         하단에 한번에 보여줄 block의 크기 : blockSize
        //         block의 시작번호 : startBlock
        //         block의 마지막번호 : endBlock
        //     3) service단 로직 처리
            
            
        //     4) 뷰단 화면 구성..

//	[1단계:개념] 2. 페이지 처리시 default 설정이 필요한 속성과 이유를 기술하세요
                // 현재 페이지, 현재 페이지 범위
                // 처음 접속 할때는 현재 페이지의 번호나 페이지 범위 등이 없기 때문에 디폴트 값으로 받을 수 있도록 합니다. 

//	[1단계:개념] 3. 페이지 처리에 있어 예외적인 데이터로 인해 조건 처리하는 내용을 기술하세요.

//	[1단계:개념] 4. 페이지 처리에 화면단 요청값에 대한 처리 내용과 방법을 기술하세요.

//	[1단계:개념] 5. fullcalendar api의 환경 설정 순서를 기술하세요.
                // 0) 초기화면 로딩
                //         controller ==> jsp
                //         lib
                //     1) DB
                //         - DB 설계
                //             id : 일정key
                //             title : 제목
                //             start : 시작일
                //             end : 종료일
                //             content : 내용(fullcalendar에서 지원하지 않지만 추가적으로 필요한 속성)
                //             color : 배경색상
                //             textColor : 글자 색상
                //             allDay : 종일여부

                //             create table calendar(
                //                 id number primary key,
                //                 title varchar2(100),
                //                 start1 varchar2(50),
                //                 end1 varchar2(50),
                //                 content varchar2(500),
                //                 bordercolor varchar2(20),
                //                 backgroundcolor varchar2(20),
                //                 textcolor varchar2(20),
                //                 allday number(1)
                //             );
                //             create sequence cal_seq
                //                 start with 1
                //                 minvalue 1;
                //             insert into calendar values(cal_seq.nextval, '첫일정등록', '2022-07-21',
                //                 '2022-07-21','내용','navy','pink','yellow',1);
                //         - sql 작성 VO 작성
                //         - 공통 mybatis/mapper
                //         - dao 처리
                //     2) 초기화면 구성
                //         - 리스트 화면
                //     3) 등록 처리
                //     4) 수정 처리
                //     5) 삭제 처리
//	[1단계:확인] 6. emp 테이블의 list를 ajax 데이터로 가져오는 추가 controller를 선언하고 출력하세요.
}
