<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%!
ArrayList<Integer> rlist_t = new ArrayList<Integer>();
ArrayList<Integer> rlist_h = new ArrayList<Integer>();
int cnt=0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
    2022-06-15
[1단계:확인] 1. 구매한 물건의 물건명과 가격 3개를 요청값을 받아서 합산하여 출력하세요.(형변환/전역변수)--%>
<form>
    물건명 : <input type="text" name="pname"/>
    가격 : <input type="text" name="price"/><br>
    물건명 : <input type="text" name="pname"/>
    가격 : <input type="text" name="price"/><br>
    물건명 : <input type="text" name="pname"/>
    가격 : <input type="text" name="price"/><br>
    <input type="submit" value="구매"/>
</form>
<%
String pnames[] = request.getParameterValues("pname");
if(pnames==null) pnames = new String[]{"","",""};
String prices[] = request.getParameterValues("price");
if(prices==null) prices = new String[]{"0","0","0"};
int priceI[] = new int[]{0,0,0};
int sum = 0;
for(int i = 0; i<prices.length; i++){
    if(prices[i] == null) prices[i] = "0";
    priceI[i] = Integer.parseInt(prices[i]);
    sum+=priceI[i];
}
%>
구매한 물건1 : <%=pnames[0]%>, <%=prices[0]%>원<br>
구매한 물건2 : <%=pnames[1]%>, <%=prices[1]%>원<br>
구매한 물건3 : <%=pnames[2]%>, <%=prices[2]%>원<br>
합산 : <%=sum%>원
<%-- 
[1단계:개념] 2. form과 속성 중 action, method의 기능과 이를 생략했을 때, 처리되는 내용을 기술하세요.
기본적으로 action 속성에 지정한 페이지에 form에 포함된 요소 객체들이 name="키" value="값"으로 query string을 만들어 서버에 전송된다.
이를 생략했을 때 action은 현재페이지, method는 get방식을 default 설정된다.

[1단계:확인] 3. 구구단을 외자? 라는 타이틀 화면으로 임의의 값이 [@@] X [@@@] ? [   ] [확인] 라는 화면이 로딩되고,
            답을 입력후, 확인 눌렀을 때, 요청된 페이지에 문제와 입력된 값을 출력, 맞으면 정답, 틀리면 오답을 출력되게 하세요. --%>
<h2>구구단을 외자?</h2>
<% 
int rand_t = (int)(Math.random()*99+1);
int rand_h = (int)(Math.random()*999+1);
rlist_t.add(rand_t);
rlist_h.add(rand_h);
int ansI = 0;
%>
<form>
    <%=rand_t%> X <%=rand_h%> ? <input type="text" name="ans"/>
    <input type="submit" value="확인">
</form>
<%
int rand_tm = rlist_t.get(cnt);
int rand_hm = rlist_h.get(cnt);
cnt++;
int cor = rand_tm * rand_hm;
String ans = request.getParameter("ans");
if(ans!=null) ansI = Integer.parseInt(ans);
%>
문제 : <%=rand_tm%> X <%=rand_hm%> ?<br>
입력된 값 : <%=ansI%><br>
<%if(ansI == cor) {%>
    정답입니다
<%}else {%>
    오답입니다.
<%}%>
<%--
[1단계:확인] 4. [   ][select +/-/*// ][   ] [결과확인] 결과확인을 통해 선택된 연산이 처리되게 하세요--%>
<form>
<input type="text" name="fnum" size="5">
<select name="cal" width="15">
    <option>+</option>
    <option>-</option>
    <option>*</option>
    <option>/</option>
</select>
<input type="text" name="lnum" size="5">
<input type="submit" value="결과확인"><br>
</form>
<%
String fnum = request.getParameter("fnum");
int fnumI = 0;
if(fnum!=null) fnumI = Integer.parseInt(fnum);
String lnum = request.getParameter("lnum");
int lnumI = 0;
if(lnum!=null) lnumI = Integer.parseInt(lnum);
String cal = request.getParameter("cal"); if(cal==null) cal = "+";
%>
연산결과 : <% if(cal.equals("+")) {%>
                <%=fnumI+lnumI%>
            <%}else if(cal.equals("-")) {%>
                <%=fnumI-lnumI%>
            <%}else if(cal.equals("*")) {%>
                <%=fnumI*lnumI%>
            <%}else if(cal.equals("/")) {%>
                <%=fnumI/lnumI%>
            <%}%>

<%--
[1단계:개념] 5. form 하위 요소객체 중, 대표적인 단일/다중 선택을 처리해 주는 요소들의 특징을 구별하여 예제를 통하여 설명하세요. 
단일 : select, radio, text
다중 : select multiple, checkbox
--%>

</body>
</html>