<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
# 웹 요청값 처리 및 js 연습 예제
1. 회원 id 등록된 여부 check
    회원 id [   ] [유효 check]
    유효 check 버튼을 클릭시,
    js단 유효 처리 - 공백인지 여부 check해서 alert()표기
    jsp단 유효 처리 - 공백이 아니면 다음 페이지(a17_ckId.jsp)에 넘겨
        himan이면 등록된 아이디입니다. 그외는 등록가능합니다. 표시처리.
 --%>
<script>
    function validCk(){
        var id = document.querySelector("[name=id]");
        if(id.value.trim()==""){
            alert("id가 공백입니다");
            id.focus();
            return;
        }
        if(id.value.length<5||id.value.length>16){
            alert("id는 5~16글자 사이로 입력가능합니다.")
            id.focus();
            return;
        }
        document.querySelector("form").submit();
    }
</script>
<form action="a17_ckId.jsp" onsubmit="return false">
    회원 id:<input type="text" name="id">
    <input type="button" value="유효 check" onclick="validCk()">
</form>
</body>
</html>