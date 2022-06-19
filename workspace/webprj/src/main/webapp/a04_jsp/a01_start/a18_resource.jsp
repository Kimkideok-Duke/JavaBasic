<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=path%>/a00_com/a01_common.css">
<script type="text/javascript" src="<%=path%>/a00_comm/a02_comFun.js"></script>
</head>
<body>
<%-- 
# 공통 자원의 활용
1. 절대 주소 지정
    1) 프로젝트명으로 절대 경로 설정:
        String path = request.getContextPath();
        webprj\src\main\webapp : 서버 기반으로 기준 경로 설정
2. 공통 css 설정
    1) 물리적으로 webprj\src\main\webapp\a00_com 하위에
        a01_common.css 로 파일을 설정하고.
    2) <link href="<%=path%>/a00_com/a01_common.css">
        선언하고 공통 css가 적용 된다.
3. 공통 js설정
    <script type="text/javascript" src="<%=path%>"/a00_comm/a02_comFun.js"></script>
4. 공통 img 폴더 선언
    webprj\scr\main\webapp\a00_img
    <img src="<%=path>"/a00_img/img01.jpeg/>
 --%>

 <h1 onclick="call()">공통 함수 호출</h1>
 <div>
    <img src="<%=path%>/a00_img/img1.png" width="100" height="100">
    <img src="<%=path%>/a00_img/img2.png" width="100" height="100">
    <form>
        <input type="text" placeholder="아이디입력"/>
    </form>
 </div>
</body>
</html>