<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String msg="";
    if(id!=null){
        if(id.equals("himan")){
            msg = "등록된 아이디입니다.";
        }else{
            msg = "등록가능합니다.";
        }
    }
%>
<script>
    var msg = "<%=msg%>";
    var sendid = "";
    alert("<%=msg%>");
    if(msg!="등록된 아이디입니다."){
        sendid = "<%=id%>";
    }
    location.href="a16_requestExp.jsp?id="+sendid;
</script>
</body>
</html>