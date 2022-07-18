<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
   td{text-align:center;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
   $(document).ready(function(){
      <%-- 
	      // 2022-07-15
		// 오전 정리문제
		// [1단계:개념] 1. jquery에서  한번에 여러가지 css 속성을 설정하는 방법을 기술하세요
					// css() 메서드를 통해 동시에 여러개의 스타일 속성을 변경하고 싶은 경우에는 css(객체) 형태로 메서드 사용이 가능하다.
					// 객체로는 style 속성을 key로 가진 JSON 객체를 넘겨주면 된다.
					
		// [1단계:확인] 2. jquery에서  each 구문을 통한 객체형 배열 처리의 매개변수을 값을 활용하여, 학생들의 이름/국어/영어/수학 점수를 테이블에 출력하세요

		// [1단계:개념] 3. jquery에서 ajax 처리를 위한 속성값을 기술하세요
                  // $.ajax({속성:속성값,....})
                  // 1) url : 요청주소 - url mapping(controller의 기능 메서드)
                  // 2) data : 요청 query string ex) id=@@@&pass=@@@
                  // 3) type : get/post
                  // 4) dataType : 결과를 받은 데이터 유형 [json], xml, text
                  // 5) success : function(data){} : 서버에서 전달해주는 데이터(data)
                  // 6) error : function(xhr, status, error){}
                  //     : 서버와 통신에 에러가 발생시 처리해주는 메서드.

		// [1단계:확인] 4. 아래의 내용을 처리하는 서버단 ajax controller을 메서드를 선언하세요 
		//             1) http://localhost:7080/springweb/ajax11.do?name=홍길동&height=175.5&weight=68.5
		//                화면출력 {"p01",{"name":"홍길동","height":175.5,"weight":68.5}}
		//             2) http://localhost:7080/springweb/ajax12.do?radius=50.2
		//                화면출력 {"circle":{radius:50.2,dimension:7912.92}}

		// [1단계:확인] 5. 아래 내용을 ajax 통해 controller에서 모델 값을 처리를 통해서 입력과 동시에 출력되게 하세요
		//             물건명 :[    ] 가격:[     ] 수량:[     ]
		//             ==> @@을 @@@원에 @@게 구매하여 총비용이 @@@ 원입니다.
                  // 1) 요청값 vo 확인
                  // 2) controller :
                  //  http://localhost:5080/springweb/ajax13.do?name=사과&price=3000&cnt=2
                  // 3) 화면 및 이벤트 처리
                      name = "name" name="price" name="cnt"
                      class="prodCls"
                      $(".prodCls").keyup(function(){

                      });
                  // 4) ajax 처리
                      $.ajax(function(){
                        url:"${path}/ajax13.do",
                        data:$("form").serialze(),
                        dataType:"json",
                        success:function(data){
                          var prod = data.prodect
                          var show=prod.name+"을 "+prod.price+"원에 "+prod.cnt
                            +"개 구매하여 총 비용이 "+prod.tot+"원 입니다."
                          $("#resultTxt").show;
                        }
                      })
      --%>
      // [1단계:확인] 2. jquery에서  each 구문을 통한 객체형 배열 처리의 매개변수을 값을 활용하여, 학생들의 이름/국어/영어/수학 점수를 테이블에 출력하세요
      var std1=["홍길동", 90, 80, 70]
      $("#tab01 td").each(function(idx){
        $(this).text(std1[idx++]);
      })

      var studList=[
          {name: "홍길동", kor:80, eng: 90, math: 100},
          {name: "김길동", kor: 85, eng: 92, math: 80}, 
          {name: "마길동", kor: 87, eng: 80, math: 90}
      ]
      var addHTML = "";
      $(studList).each(function(idx, stud){
          addHTML += "<tr><td>"+stud.name+"</td><td>"+stud.kor+
              "<Itd><td>"+stud.eng+"</td><td>"+stud.math+"</td></tr>";
      });
      $("#showData").htm1(addHTML);
   });
</script>
</head>
  <%-- [1단계:확인] 2. jquery에서  each 구문을 통한 객체형 배열 처리의 매개변수을 값을 활용하여, 학생들의 이름/국어/영어/수학 점수를 테이블에 출력하세요 --%>
  <table id="tab01" border width="200" height="200" align="center">
    <col width="25%"><col width="25%"><col width="25%"><col width="25%">
    <tr><th>이름</th><th>국어</th><th>영어</th><th>수학</th><tr>
    <tr><td></td><td></td><td></td><td></td><tr>
  </table>

  <div class="container">
   <form id="frm01" class="form"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input name="pname" value="" class="form-control mr-sm-2" placeholder="물건명" />
       <input name="price" value="0" class="form-control mr-sm-2" placeholder="가격" />
       <input name="cnt" value="0" class="form-control mr-sm-2" placeholder="갯수" />
       <button class="btn btn-info" type="submit">Search</button>
    </nav>
   </form>
   <h3 id="resultTxt">
  </div>
<body>
</body>
</html>