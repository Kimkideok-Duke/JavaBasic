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
<%--
# 쿠키
1. 쿠키는 웹 브라우저가 보관하고 있는 데이터로 웹 서버에 요청을 보낼 때, 함께 전송한다.
2. 동작방식
  1) 쿠키생성 : 브라우저가 서버에 요청하면 서버는 response(반응객체로) 쿠키를 생성해서 브라우저에게 보낸다.
  2) 쿠키의 저장 : 서버에서 온 쿠키는 브라우저에 저장하고 있다가.
  3) 쿠키의 전송 : 브라우저가 서버에 요청하면서 쿠키를 서버에 전송한다.
3. 쿠키의 구성
  1) 구성요소
    - 이름 : 각각의 쿠키를 구별하는데 사용되는 이름
    - 값 : 쿠키의 이름과 관련된 값
    - 유효시간 : 쿠키의 유지시간
    - 도메인 : 쿠키를 전송할 도메인
    - 경로 : 쿠키를 전송할 요청 경로
  2) 쿠키 이름의 제약
    - 쿠키의 이름은 아스키 코드의 알파벳과 숫자만을 포함할 수 있다.
    - 콤마, 세미콜론, 공백등의 문자는 포함할 수 없다.
    - $로 시작할 수 없다.
4. 쿠키의 생성
  1) Cookie 클래스를 이용해서 쿠키를 생성(서버에서 생성)
    Cookie cookie = new Cookie("쿠키이름", "쿠키의값");
  2) 쿠키를 브라우저에게 보내기
    response.addCookie(cookie);
  3) 위 내용에 의해 쿠키는 저장된다.
  4) 다시 쿠키를 서버에 접속하면서 가지고 있는 쿠키 전달.
    request.getCookies()
--%>
<body>
<%
	Cookie cookie = new Cookie("ck01", "cookie01");
  response.addCookie(cookie);
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