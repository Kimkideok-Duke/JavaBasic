<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.*"
    import="webprj.z01_vo.*"
    %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
%>	
<%--
# jsp의 기본 객체
1. request : 클라이언트의 요청 정보를 저장하는 객체
2. response : 응답 정보를 저장한다.
3. pageContext : jsp 현재 한페이지에 대한 정보를 저장한다.
4. session : HTTP  세션 정보를 저장한다.
5. application : 웹 어플리케이션에 대한 정보를 저장한다.
6. out : jsp 페이지가 생성하는 결과를 출력할 때, 사용돠는 출력 스트림이다.
7. config : jsp페이지에 대한 설정 정보를 저장한다.
8. page : jsp 페이지를 구현한 자바 출력 인스턴스이다.
9. exception : 예외 객체, 에러 페이지에서만 사용한다.

# out 기본 객체의 주요 메서드
1. 출력 메서드
  1) print() : 데이터를 출력한다.
  2) println() : 데이터를 출력하고, \t\n을 출력한다.
  3) newLine() : 줄바꿈을 포함하여 출력을 한다.
2. 버퍼 관련 메서드
  int getBufferSize() : 버퍼의 크기를 구한다.
  int getRemaining : 현재 버퍼의 남은 크기를 구한다.
  clear() : 버퍼의 내용을 비운다. 만약 버퍼가 이미 플러시 되었다면 IOException 발생한다.
  clearBuffer() : 버퍼의 내용을 비운다.
  flush() : 버퍼를 플러시한다.
  boolean isAutoFlush() : 버퍼가 다 찼을 때, 자동으로 플러시할 경우 true을 리턴한다.
--%>
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
<body>
<%
	String pointS = request.getParameter("point");
  int point = 0;
  if(pointS!=null&&!pointS.trim().equals("")){
    point = Integer.parseInt(pointS);
    if(point>=70){
      out.println("<h2>합격</h2>");
    }else{
      out.println("<h2>불합격</h2>");
    }
  }
  String ageS = request.getParameter("age");
  int age = 0;
  if(ageS!=null&&!ageS.trim().equals("")){
    age = Integer.parseInt(ageS);
    if(age>=18){
      out.println("<h2>성년</h2>");
    }else{
      out.println("<h2>미성년</h2>");
    }
  }
%>
<table>
  <tr><th>버퍼의 크기</th><td><%=out.getBufferSize()%></td></tr>
  <tr><th>남은 크기</th><td><%=out.getRemaining()%></td></tr>
</table>


<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="point">점수</label>
    </div>
    <div class="col-75">
      <input type="text" id="point" name="point" placeholder="점수를 입력" value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="합격 확인">
  </div>
  <div class="row">
    <div class="col-25">
      <label for="age">성년</label>
    </div>
    <div class="col-75">
      <input type="text" id="age" name="age" placeholder="나이를 입력" value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="성인여부 확인">
  </div>
  </form>
</div>
</body>
</html>