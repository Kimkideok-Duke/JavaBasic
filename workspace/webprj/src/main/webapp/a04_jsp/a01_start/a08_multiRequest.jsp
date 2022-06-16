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
# 동일한 key로 여러개의 데이터를 받기
1. request.getParameterValues("키")
    를 활용하면, 같은 키로 여러개의 데이터를 받을 수 있다.
2. 그래서, 위 데이터를 배열로 리턴값을 처리하여야 한다.
    String arry[] = request.getParameterValues("키");
3. 실습예제
    1) 동일한 키로 다중의 데이터 받기
        ?name=홍길동&name=김길동&name=신길동
ex) form 하위 요소객체 가운데 여러개의 데이터를 넘길 때, 주로 활용된다.
    주문메뉴, 다중의 선택(checkbox)
    a09_multiExp.jsp    ?favorFood=사과&favorFood=바나나&favorFood=딸기
        좋아하는 과일 리스트 출력
 --%>
<%
    String []names = request.getParameterValues("name");
    if(names!=null && names.length>0){ // 초기화면을 로딩했을 때, 요청값이 없더라도 에러를 방지
        for(String name:names){
%>
            <h2>이름:<%=name%></h2>
        <%}%>
<%  }%>

</body>
</html>