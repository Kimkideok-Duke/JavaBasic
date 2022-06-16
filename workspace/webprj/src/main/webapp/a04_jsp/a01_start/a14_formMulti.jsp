<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		선택1:<select name="cho01">
			<option>사과</option>
			<option>바나나</option>
			<option>딸기</option>
		</select><br>
		선택2:<select name="cho02">
			<option value="10">인사</option>
			<option value="20">재무</option>
			<option value="30">회계</option>
		</select><br>
        <%-- 
            select는 value를 속성으로 지정하지 않을 때는
            레이블에 있는 내용이 value로 처리되어 전달되지만
            따리 option을 활용하여 value를 지정하면 지정된 값이 전달되어 온다.

            option은 selected, type="radio|checkbox"는 checed로
                초기 선택되어 진 것을 처리한다.
        --%>
        선택3:
        <input type="radio" name="cho03" value="서울"/>서울
        <input type="radio" name="cho03" value="경기" checked/>경기
        <input type="radio" name="cho03" value="강원"/>강원
        <input type="radio" name="cho04" value="경상"/>경상
        <input type="radio" name="cho04" value="전라"/>전라
        <input type="radio" name="cho04" value="제주"/>제주
        <%-- 여러가지 중에 선택된것의 value값을 전송한다.
            radio는 같은 이름(name)의 범위 안에서만 단일 선택되어 진다.
        
        --%><br>
        추천인:
        <input type="text" name="name01" value="홍길동" size="4"/>
        <input type="text" name="name01" value="김길동" size="4"/>
        <input type="text" name="name01" value="신길동" size="4"/><br>
        추천인2:
        <input type="checkbox" name="name02" value="홍길동" size="3"/>홍길동,
        <input type="checkbox" name="name02" value="김길동" size="3"/>김길동,
        <input type="checkbox" name="name02" value="신길동" size="3"/>신길동,
        <input type="checkbox" name="name02" value="마길동" size="3"/>마길동,
        <input type="checkbox" name="name02" value="오길동" size="3"/>오길동<br>

        <input type="submit"/>
	</form>
    넘겨온값5:
        <%
        String names02[]=request.getParameterValues("name02");
        %>
        <%if(names02!=null){%>
            <%for(String name:names02){%>
                <%=name %>
            <%} %>
        <%}%>
        <br>


    넘겨온값1:<%=request.getParameter("cho01")%><br>
    넘겨온값2:<%=request.getParameter("cho02")%><br>
    넘겨온값3:<%=request.getParameter("cho03")%><br>
    넘겨온값4:<%=request.getParameter("cho04")%><br>
    넘겨온값5:
        <%
        String names[]=request.getParameterValues("name01");
        %>
        <%if(names!=null){%>
            <%for(String name:names){%>
                <%=name %>
            <%} %>
        <%}%>
    
</body>
</html>