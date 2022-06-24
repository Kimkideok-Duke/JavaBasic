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
2022-06-23
[1단계:확인] 1. jsp의 기본 객체 out를 활용하여, 구매물건과 가격 갯수를 입력 받아      
      총비용(가격X개수)에 따라 MVP VIP 보통고객으로 분류하여 출력되게 하세요.
[1단계:개념] 2. session scope의 범위를 4가지를 기본 예제와 함께 기술하세요.
            jsp의 4가지 영역
            1) page(pageContext) : 하나의 페이지를 처리할 때 사용되는 영역
            2) request : 하나의 HTTP요청을 처리할 때, 사용되는 영역
            3) session : 하나의 웹 브라우저와 관련된 영역
            4) application : 하나의 웹 어플리케이션과 관련된 영역


[1단계:확인] 3. id/pass을 입력해서 himan/7777이면 request범위로 설정하여 main.jsp에서
      @@@ 님 로그인이라고 표시하세요.


[1단계:확인] 4. include 지시자를 이용해서 top main 으로 하나의 페이지에 두개의 페이지가 포함되게하세요.
--%>




<%-- [1단계:확인] 1. jsp의 기본 객체 out를 활용하여, 구매물건과 가격 갯수를 입력 받아      
      총비용(가격X개수)에 따라 MVP VIP 보통고객으로 분류하여 출력되게 하세요. --%>
<body>
<%
  String pname = request.getParameter("pname");
  if(pname==null) pname = "";
  String priceS = request.getParameter("price");
  int price = 0;
  if(priceS!=null&&!priceS.trim().equals("")) price = Integer.parseInt(priceS);
  String cntS = request.getParameter("cnt");
  int cnt = 0;
  if(cntS!=null&&!cntS.trim().equals("")) cnt = Integer.parseInt(cntS);
  int sum = price*cnt;
%>
<div class="container">
  <div class="row">
    <div class="col-25">
      <label for="pname">구매물건</label>
    </div>
    <div class="col-75">
      <input type="text" id="pname" name="pname" placeholder="구매물건 입력" value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="price">가격</label>
    </div>
    <div class="col-75">
      <input type="text" id="price" name="price" placeholder="가격를 입력" value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="cnt">갯수</label>
    </div>
    <div class="col-75">
      <input type="text" id="cnt" name="cnt" placeholder="갯수를 입력" value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="회원등급 확인">
  </div>
</div>
<table>
  <tr><th>구매물건</th><th>가격</th><th>갯수</th><th>총금액</th><th>등급</th></tr>
  <tr><td><%=pname%></td><td><%=price%></td><td><%=cnt%></td><td><%=price*cnt%></td>
  <td><% if(sum>=100000){
    out.println("<p>MVP</p>");
  }else if(sum>=5000){
    out.println("<p>VIP</p>");
  }else{
    out.println("<p>보통고객</p>");
  }%></td></tr>
</table>

<%-- [1단계:확인] 3. id/pass을 입력해서 himan/7777이면 request범위로 설정하여 main.jsp에서
      @@@ 님 로그인이라고 표시하세요. --%>
<%
  String id = request.getParameter("id");
  if(id==null) id = "";
  String pass = request.getParameter("pass");
  if(pass==null) pass = "";
  String loginSuss="Y";
  if(!id.equals("")){
    if(id.equals("himan")&&pass.equals("7777")){
      request.setAttribute("id01", id);
      request.getRequestDispatcher("main.jsp").forward(request, response);
    }else {
      loginSuss = "N";
    }
  }
%>
<script>
  var loginSuss = "<%=loginSuss%>";
  if(loginSuss=="N"){
    alert("로그인 실패!!")
  }
</script>
<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="id">아이디</label>
    </div>
    <div class="col-75">
      <input type="text" id="id" name="id" placeholder="아이디 입력" value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="pass">패스워드</label>
    </div>
    <div class="col-75">
      <input type="password" id="pass" name="pass" placeholder="패스워드 입력" value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="로그인">
  </div>
  </form>
</div>
<%-- [1단계:확인] 4. include 지시자를 이용해서 top main 으로 하나의 페이지에 두개의 페이지가 포함되게하세요. --%>
<jsp:include page="a02_subPage.jsp" flush="true"/>
</body>
</html>