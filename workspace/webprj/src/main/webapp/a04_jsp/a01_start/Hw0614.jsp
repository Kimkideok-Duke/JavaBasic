<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
2022-06-14
[1단계:개념] 1. 특정한 화면에서 스크립트릿과 익스프레션에 대한 자바 처리의 코드 순서를 기본예제로 기술해보세요. --%>
<%
int a1 = 11;
%>
<h2>a1 = <%=a1%></h2>
<%--
[1단계:확인] 2. 영문으로 배열을 무지개색상을 지정하고, 7가지 h3 코드에 무지개명과 배경색이 출력되게 하세요.--%>
<%
String[] rainbowArr = {"빨", "주", "노", "초", "파", "남", "보"};
%>
<h3 style="background-color:red;"><%=rainbowArr[0]%></h3>
<h3 style="background-color:orange;"><%=rainbowArr[1]%></h3>
<h3 style="background-color:yellow;"><%=rainbowArr[2]%></h3>
<h3 style="background-color:green;"><%=rainbowArr[3]%></h3>
<h3 style="background-color:blue;"><%=rainbowArr[4]%></h3>
<h3 style="background-color:indigo;"><%=rainbowArr[5]%></h3>
<h3 style="background-color:purple;"><%=rainbowArr[6]%></h3>
<%--
[1단계:확인] 3. 아래와 같이 두팀의 주사위게임(1~6임의) 10회의 결과를 테이블로 출력하세요.
      no  홍팀   백팀  결과
      1    5   6   홍팀승
      2    5   6   홍팀승
      3    5   5   무승부
      ...
      10   5   1   청팀승
--%>
<%
int dice_b = 0;
int dice_r = 0;

for(int i = 0;i<10;i++) {
    dice_b = (int)(Math.random()*6+1);
    dice_r = (int)(Math.random()*6+1);%>
    <table border>
        <tr>
            <th>no</th><th>홍팀</th><th>백팀</th><th>결과</th>
        </tr>
        <tr>
            <td><%=i+1%></td><td><%=dice_r%></td><td><%=dice_b%></td>
            <td><%if(dice_r>dice_b){%>
                    홍팀승
                <%}else if(dice_r<dice_b){%>
                    백팀승
                <%}else{%>
                    무승부
                <%}%>
            </td>
        </tr>
    </table>
<%
}
%>

<%--
[1단계:개념] 4. jsp에서 특정페이지에 데이터 전송 형식(요청값)을 기술하세요
                get 방식으로 url통해서 요청값을 넘기는 방식
                요청할 페이지?key=value&key=value

[1단계:확인] 5. 학생명과 국어,영어,수학점수를 전송하고 이름과 점수를 받은 요청값을 처리하세요.
      조건문과 형변환 함수를 이용하여 합산과 평균을 출력하세요.
 --%>
 <%
 String name = request.getParameter("name");
 String kor = request.getParameter("kor");
 String eng = request.getParameter("eng");
 String math = request.getParameter("math");
 int korI, engI, mathI; korI=engI=mathI=0;
 if(name==null) name = "";
 if(kor!=null) korI = Integer.parseInt(kor);
 if(eng!=null) engI = Integer.parseInt(eng);
 if(math!=null) mathI = Integer.parseInt(math);
 int sum = korI+engI+mathI;
 int avg = sum/3;
 /*
 if(kor.equals(null)==false 
    && eng.equals(null)==false
    && math.equals(null)==false){
        sum = Integer.parseInt(kor)+Integer.parseInt(eng)+Integer.parseInt(math);
    }*/
 %>
<form>
<table width="30%" border>

    <tr><th>이름</th><td><input type="text" name="name" size="5" value="<%=name%>"/></td></tr>
    <tr><th>국어</th><td><input type="text" name="kor" size="5" value="<%=korI%>"/></td></tr>
    <tr><th>영어</th><td><input type="text" name="eng" size="5" value="<%=engI%>"/></td></tr>
    <tr><th>수학</th><td><input type="text" name="math" size="5" value="<%=mathI%>"/></td></tr>
    <tr><th colspan="2"><input type="submit" value="합산/평균 확인"/></td></tr>
    <%if(!name.equals("")){%>
    <tr><th>합산</th><td><%=sum%></td></tr>
    <tr><th>평균</th><td><%=avg%></td></tr>
    <%}%>
</table>
</body>
</html>