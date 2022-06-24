<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.*"
    import="webprj.z01_vo.*"
    %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=path %>/a00_com/a01_common.css" rel="stylesheet">
<style>

</style>
<script>
	/*
	
	*/
</script>
</head>
<%-- 2022-06-24
[1단계:개념] 1. <jsp:include, <jsp:forward  <%@ include file="" 의 차이점을 예제를 통해 설명하세요.
              1) <jsp:include> 액션태그
                다른 jsp페이지의 실행 결과를 현재 위치에 삽입
              2) <jsp:forward> 액션 태그
                하나의 jsp 페이지에서 다른 jsp 페이지로 요청전달 할 때, 사용
              3) <%@ include file="포함할파일" %>
                모든 jsp 페이지에서 사용되는 변수 지정


[1단계:개념] 2. jsp에서 에러를 처리하는 방식이 두가지이다. 해당 처리방식의 차이점을 기술하세요
              1. 페이지당 에러가 발생했을 때, 에러 페이지를 지정
                1) <%@ page errorPage="로딩할 에러페이지"
                  현재 화면에서 에러가 발생했을 때, 특정한 에러 페이지를 지정해서 처리하는 것을 말한다.
                2) 로딩한 에러 페이지
                  <%@ page  isErrorPage="true"
              2. 서버단위로 에러 페이지 지정 처리
                1) 서버안에 있는 모든 페이지에 대하여 에러가 발생했을 때, 에러 페이지를 각 페이지별로
                    지정하지 않더라도 해당 에러를 처리해주는 것을 말한다.


[1단계:확인] 3. 현재 서버에서 경로나 페이지명을 잘 못 입력했을 때, 나타나는 이미지와 함께 있는 페이지를 설정할려고 한다.
            해당 내용을 처리하는 순서와 함께 처리하세요.
            - 에러 페이지 만들기(이미지 첨부)
            - webapp\WEB-INF\web.xml 서버단위 설정값 처리하기 위한 web.xml 확인
              xml에 속성 지정하기
              <error-page>
                <error-code> 반응 코드로 404 : 페이지가 존재하지 않음
                <location>  에러를 webapp 기준으로 로딩할 페이지 지정 
              <error-page>
                <exception-type> 자바 컴파일 및 런타입 에러로 발생하는 클래스를 지정
                <location> 에러를 webapp 기준으로 로딩할 페이지 지정 


[1단계:개념] 4. 쿠키와 세션의 궁극적인 차이점을 기본 예제를 통해서 기술하세요. 
              쿠키는 서버의 자원을 사용하지 않지만 세션은 서버의 자원을 사용한다.
              보안 면에서 세션이 더 우수하며, 요청 속도는 쿠키가 세션보다 더 빠르다. 그 이유는 세션은 서버의 처리가 필요하기 때문이다.
              쿠키는 만료시간이 있지만 파일로 저장되기 때문에 브라우저를 종료해도 계속해서 정보가 남아 있을 수 있다
              반면에 세션도 만료시간을 정할 수 있지만 브라우저가 종료되면 만료시간에 상관없이 삭제된다.--%>
<body>
<%
	String req = request.getParameter("");
%>



<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="dname">@@@</label>
    </div>
    <div class="col-75">
      <input type="text" id="dname" name="dname" placeholder="부서명 입력" value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  </form>
</div>
<table>
        <tr><th>###</th><th>###</th><th>###</th></tr>
        <tr><td></td><td></td><td></td></td></tr>
</table>
</body>
</html>