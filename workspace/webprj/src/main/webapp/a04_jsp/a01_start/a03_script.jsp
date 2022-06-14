<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
# 스크립트의 요소 3가지
1. scriptlet : 스크립트조각 <% %>
    자바의 프로그래밍 코드를 넣는 부분
2. expression : 표현 <%=%>
3. declare : 선언 <%! %>
--%>
<%-- 
# 스크립틀릿 연습예제
1. 반복문 처리
2. 조건문 처리
3, 반복문과 조건문 혼합처리
ps) 화면단(html코드)에서 java코드의 로직을 어떻게 처리하고 구분하느냐의 문제
--%>
<%-- 반복문 1단계
1. 코드내용 반복 처리.
    1) 반복될 태그를 기준으로 앞뒤에 for/while 구문이 들어갈
        내용을 <%%>으로 시작과 끝을 처리한다.
    2) 반복할 변수를 중간에 출력 : <%=%>를 활용한다.
--%>
<%for(int cnt=1;cnt<=5;cnt++){ %>
<h2><%=cnt%>)안녕하세요</h2>
<% }%>
<%-- 
반복문 2단계
1. 테이블형에 데이터를 출력하기..
    1) 테이블의 기본형식 만들기
    2) 반복할 범위를 확인 : tr, td
    3) for문을 통해서 처리할 데이터와 함께 expression으로 나타내기
--%>
<%
	String titles[]={"사원번호", "사원명", "직책", "급여", "부서번호"};
    String hogInfo[]={"7780", "홍길동", "사원", "3500", "10"};
    ArrayList list = new ArrayList();
    list.add(7780); // <Object> Integer autoBox(기본 ==> Wrapper)
    list.add("홍길동"); // Object i = new Integer();
    list.add("사원"); // Integer num = 7780; // autobox
    list.add(3500.0);
    list.add(10);
%>
<!-- 
제한된 코드가 많다.
-->
<%-- 어떤 코드도 상관없음. (jsp)
    for(String title:titles){ ==> 자바 scriptlet
        title                 ==> expression
    }                         ==> 자바 scriptlet
--%>
<table border>
    <%-- 
    ex)
    --%>
	<tr>
		<%-- <th>사원번호</th>
		<th>사원명</th>
		<th>직책</th>
		<th>급여</th>
		<th>부서번호</th> --%>
        <%for(String title:titles){ %>
        <th><%=title %></th>
        <%} %>
	</tr>
        <%for(String hog:hogInfo){ %>
        <td><%=hog %></td>
        <%} %>
    <tr>
    </tr>
        <%for(Object o:list){ %> <%-- Wrapper, String은 상위 Object로 할당하더라도 형변환 없이 출력이 가능하다. --%>
        <td><%=o %></td>
        <%} %>
    <tr>
</table>
<%-- 
# 조건문 처리
1. 조건문에 활용할 데이터 선언
2. 조건문 형식 설정.
    if(조건){

    }
    if(조건){

    }else{

    }
3. scriptlet 코드 부분과 expression 구분하기
    <%
    if(조건문){
    %>
        <%=조건에 출력할 내용%>
    <%
    }
    %>
 --%>
 <%-- 
1. 조건문 처리
if(age>=18){

}else{

}
2. 처리에 따라 표시된 화면 구현
3. 변수를 선언하고, 조건문 처리를 scriptlet에 선언하여 처리한다.
--%>
    <%
    int age = 12;
    %>
    <%if(age>=18){%>
    <h2>성인입니다.</h2>
    <%}else{%>
    <h2>미성년입니다.</h2>
    <%}%>
<%-- 
ex) 점수에 따라 평점으로 A~F까지 <h1>선택적으로 출력되게 하세요.
 --%>
    <%
    int score = 65;
    %>
    <h1>점수 : <%=score%> </h1>
    <%if(score>90){%>
        <h2>A</h2>
    <%}else if(score>80){%>
        <h2>B</h2>
    <%}else if(score>70){%>
        <h2>C</h2>
    <%}else if(score>60){%>
        <h2>D</h2>
    <%}else if(score>50){%>
        <h2>E</h2>
    <%}else{%>
        <h2>F</h2>
    <%}%>
<%-- 
# 조건문과 반복문 혼합예제
1. 배열로 점수를 표시하고, 점수에 따라 합격불합격, 배경색상 파랑/빨강 표기
    1) java 기본 코드 선언.
        int[]ptArry = {70,80,90,60,85};

        for(int pt:ptArry){
            if(pt>=80){
                합격 blue
            }else{
                불합격 red
            }
        }

    2) 기본 출력 화면 구현
    3) <%%>, <$=%> 표기
    4) 기본 코드 스크립트릿에 추가하기
 --%>
    <%
    int[]ptArry = {70,80,90,60,85};
    %>
    <%for(int pt:ptArry){ %>
        <%if(pt>=80){ %>
        <h2 style="background-color:blue;color:yellow;"><%=pt%>:합격</h2>
        <%}else{ %>
        <h2 style="background-color:red;color:orange;"><%=pt%>:불합격</h2>
        <%} %>
    <%} %>
<%-- 
    ex) 회원 권한을 문자열로 관리자/일반사용자/방문객으로 나누어
    회원 5명을 권한 배열로 선언하고,
    권한따라 글자색상을 관리자는 파랑색, 일반사용자는 녹생, 방문객은 오렌지색으로 권한과 함께
    표시하세요. 테이블의 tr/td에 넣어서 표시
        권한
        @@@
        @@@
        @@@
        @@
        @@
 --%>
    <%
    String[] memberArr = {"일반사용자", "방문객", "관리자", "방문객", "일반사용자"};
    int mno = 1;
    %>
    <table border>
    <tr>
        <th>회원번호</th>
        <th>권한</th>
    </tr>
    <%for(String m:memberArr){%>
        <tr>
        <td><%=mno%>번 회원</td>
        <td>
        <%if(m.equals("관리자")){%>
            <h2 style="color:blue;">관리자</h2>
        <%}else if(m.equals("일반사용자")){%>
            <h2 style="color:green;">일반사용자</h2>
        <%}else if(m.equals("방문객")){%>
            <h2 style="color:orange;">방문객</h2>
        <%}mno++;%>
        </td>
        </tr>
    <%}%>
    </table>
</body>
</html>