package springweb.Homework;

public class Hw0721 {
//	[1단계:개념] 1. 파일을 다운로드하기 위한 환경 설정을 기술하세요.
                /*
                1) 다운로드 뷰를 생성
                    model : 파일명 지정
                    한글파일을 encoding 처리
                    목적 : 해당 view를 통해서 서버에 있는 파일을 client에 전달하기 위한 목적
                    client ==(클릭/다운로드요청)==> server
                                파일명(모델명)

                            <==(파일을 전송)	=== viewer
                                stream형식		 받은 모델명을 기준으로 서버내에
                                                해당 경로에 파일이 있는지 확인
                                                한글 encoding
                    파일다운로드뷰
                        전달해온 model명을 기준으로 전송할 파일 객체 File f = new File(@@@)
                        한글파일명인 경우 encoding
                        response(반응객체)에 탑재하여 client에 전송한다.

                2) 다운로드 뷰 컨테이너 등록

                3) 다운로드 controller 처리
                */

//	[1단계:확인] 2. 아래와 같은 경로에 파일을 올려놓고 url을 이용하여 파일을 다운로드 할 수 있게 controller를 처리하세요.
//	            파일 위치 : src\main\webapp\z01_upload
//	            http://localhost:7080/springweb/download10.do?filename=@@@@  viewer fileView01
//	            http://localhost:7080/springweb/download11.do?file01=@@@@
                /*
                @Controller
                public class DownLoadCtroller {
                    // http://localhost:7080/springweb/download10.do?filename=@@@@
                    @RequestMapping("download10.do")
                    public String download(@RequestParam("filename") String filename, Model d) {
                        d.addAttribute("downloadFileName", filename);
                        
                        return "downloadViewer";
                    }
                }
                */

//	[1단계:확인] 3. 위에 설정한 controller상 경로로 src\main\webapp\z01_upload에 있는 파일을 리스트(직접파일명 입력)하고,
//	            클릭시, 다운되게 하세요
                /*
                <script type="text/javascript">
                    $("[name=fname]").click(function(){
                        if(confirm("다운로드 하시겠습니까?")){}
                            location.href="${path}/download10.do?filename="+$(this).val()
                    })
                </script>
                */

//	[1단계:개념] 4. 답글을 달기 위하여 필요하는 요청값 처리 구조와 속성을 기술하세요.
                /*
                상세화면에서 답글버튼클릭시,
                RE:@@@@@ 
                내용 :

                === 이전글 ====
                형태도 답글 형식이 나오고,
                이 글을 등록 처리하면, 이전글에 대한 답글로 처리된다.
                DB  no  refno
                    1    0
                    2    1      : 1번 글에 대한 답글로 데이터가 쌓인다.

                답글 클릭 ==> 등록화면
                    subject ==> RE:${board.subject}
                    no   ===> refno  값할당.
                    content ===>  
                                    
                                === 상위글 ====
                                3333
                */

//	[1단계:개념] 5. 페이지 처리를 위한 핵심 sql이 가지는 의미를 기술하세요.
				/*
				rownum : 데이터가 나온 순서대로 1~... 갯수만큼 numbering, 이 기준으로 특정페이지에서
			        보이는 데이터를 범위로 지정하여 출력
				select * 
			    from(
			        select rownum cnt
			        from...
			    )
			    where cnt between ${start} and #{end}
			    1페이지 1~5
			    2페이지 6~10
			    3페이지 11~15
			    */

//	[1단계:개념] 6. 페이지 처리를 위한 속성을 기술하세요.
                /*
                전체건수 count
                한번에 보여줄 건수 : pageSize
                총 페이지 수 : pageCount
                클릭한 현재 페이지 번호 : curPage
                해당 페이지의 시작번호 : start
                해당 페이지의 마지막 번호 : end
                
                #페이지 블럭 처리..
                하단에 한번에 보여줄 block의 크기 : blockSize
                block의 시작번호 : startBlock
                block의 마지막번호 : endBlock
                */
}
