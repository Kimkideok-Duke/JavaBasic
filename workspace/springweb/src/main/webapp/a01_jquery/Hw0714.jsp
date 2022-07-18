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
      2022-07-14
		[1단계:개념] 1. jquery 환경설정 방법 2가지와 $(document).ready()의 의미를 기술하세요.
                  html화면이 전체 로딩되어 태그 등 DOM객체를 인식할 수 있는 상황이 되었을 때, 처리 코드를 익명함수 적용하여 처리한다.
		
    [1단계:개념] 2. jquery의 DOM 객체 선택자를 아이디, 태그, 클래스, form요소객체에 대하여 기술하세요.
                $("h1"), $("#아이디명") : id="btn01"
                $(".클래스명") class="cls01"
                $("[속성=속성값]")

		[1단계:개념] 3. jquery의 text(), html(), val()의 차이점을 예제를 통해 기술하세요
                text() : XML과 HTML 문서에서 둘다 사용될 수 있다. input elements 의 value를 받아오지 못한다(이 경우 val을 사용)
                html() : XML 문서는 사용 불가, HTML만 가능. value가 아니라 html code(contents)자체를 get한다.
                val() : Form Element 의 값을 받아오는데 쓰인다.
                cf) jquery의 대부분 데이터 할당 및 출력 메서드는 호출도 하고, 저장도 한다. val() - 호출, val("데이터") - 저장
		
    [1단계:개념] 4. jquery의 attr(), css()차이점을 예제를 통해 기술하세요
                attr() : 요소의 속성값을 가져오거나 추가
                css() : 요소의 css 속성값을 가져오거나 style 을 추가
		
    [1단계:개념] 5. 익명함수로 이벤트의 처리 방법을 기술하세요.
                $("선택").이벤트명(익명함수) : 해당 이벤트가 수행되었을 때, 처리할 이벤트 핸들러 함수
                var cnt=1;
                $("h2").click(function(){
                  // $(this) : 이벤트가 처리된 해당 객체..
                  $(this).css("color","pink");
                  $('h1').text("카운트:"+(cnt++));
                });

    [1단계:확인] 6. jquery로 물건가격[  ] 구매갯수[  ] 입력 후, enter처리시 총비용 하단에 출력되게 하세요.
		
    [1단계:확인] 7. [rainbow 색상] 클릭시, 하단에 있는 h3 7개의 배경색상이 출력되게 처리하세요
		
    [1단계:확인] 8. json 형식으로 운동선수이름, 팀, 성적을 선언하고, [성적표시] 클릭시, 테이블에 데이터가 출력되게 하세요
      --%>
    // [1단계:확인] 6. jquery로 물건가격[  ] 구매갯수[  ] 입력 후, enter처리시 총비용 하단에 출력되게 하세요.
    $(".prod").keyup(function(){
      if(event.keyCode==13){
        var price = $("[name=price]").val()
        var cnt = $("[name=cnt]").val()
        $("#show").text("총비용 : "+(price*cnt))
      }
    });

    // [1단계:확인] 7. [rainbow 색상] 클릭시, 하단에 있는 h3 7개의 배경색상이 출력되게 처리하세요
    $("#rainbow").click(function(){
      $("h3").eq(0).attr("align","center").text("빨").css({"color":"white", "background":"red"});
      $("h3").eq(1).attr("align","center").text("주").css({"color":"white", "background":"orange"});
      $("h3").eq(2).attr("align","center").text("노").css({"color":"white", "background":"yellow"});
      $("h3").eq(3).attr("align","center").text("초").css({"color":"white", "background":"green"});
      $("h3").eq(4).attr("align","center").text("파").css({"color":"white", "background":"blue"});
      $("h3").eq(5).attr("align","center").text("남").css({"color":"white", "background":"navy"});
      $("h3").eq(6).attr("align","center").text("보").css({"color":"white", "background":"purple"});
    });

    // [1단계:확인] 8. json 형식으로 운동선수이름, 팀, 성적을 선언하고, [성적표시] 클릭시, 테이블에 데이터가 출력되게 하세요
    var player = {name:"김현수", team:"두산", record:"0.356",
                  show: function(){
                  console.log("# 객체의 메서드 호출 #")
                  console.log("이름:"+this.name)
                  console.log("나이:"+this.team)
                  console.log("사는곳:"+this.record)
                }}
    $("#btnP").click(function(){
      $("td").eq(0).text(player.name);
      $("td").eq(1).text(player.team);
      $("td").eq(2).text(player.record);
    })
   });
</script>
</head>

<body>
<div class="jumbotron text-center">
<%-- [1단계:확인] 6. jquery로 물건가격[  ] 구매갯수[  ] 입력 후, enter처리시 총비용 하단에 출력되게 하세요. --%>
  물건가격 : <input name="price" class="prod" size="5" value="0"/>
  구매갯수 : <input name="cnt" class="prod" size="5" value="0"/><br>
  <span id="show"></span><br>

<%-- [1단계:확인] 7. [rainbow 색상] 클릭시, 하단에 있는 h3 7개의 배경색상이 출력되게 처리하세요 --%>
<input type="button" id="rainbow" value="rainbow 색상"/><br>
<h3></h3>
<h3></h3>
<h3></h3>
<h3></h3>
<h3></h3>
<h3></h3>
<h3></h3>

<%-- [1단계:확인] 8. json 형식으로 운동선수이름, 팀, 성적을 선언하고, [성적표시] 클릭시, 테이블에 데이터가 출력되게 하세요 --%>
<input type="button" id="btnP" value="성적표시"/><br>
<table id="tabP" border width="200" height="200" align="center">
  <col width="33%"><col width="33%"><col width="33%">
  <tr height="50%"><th>선수명</th><th>소속팀</th><th>성적</th></tr>
  <tr height="50%"><td></td><td></td><td></td></tr>
</table>

</body>
</html>