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
# 웹 폼
1. 웹 페이지에서 사용자 입력을 받는 폼
2. 로그인, 등록, 검색, 예약, 쇼핑 등
3. 폼 요소
    - 폼을 만드는 다양한 태그
    - input, textarea, select 등
4. 폼 태그 <form> 태그로 둘러싸는 모양
    <form name="폼이름" method="get/post" action="호출할페이지">
    1) 속성
        name : 폼의 이름 지정
        action 
            폼 데이터를 처리할 웹 서버 응용프로그램의 이름
            submit 버튼이 눌리면 브라우저는 action에 지정된 웹 서버
                응용프로그램 실행 요청 ex) @@@.jsp, servlet, controller 호출
            웹 서버 응용프로그램은 java, jsp, php, c/c++등 다양한 언어로 작성
            생략하면 default로 현재 페이지를 호출한 페이지를 다시 요청한다.(? 현재 페이지를 호출한 controller ..)
        method
            폼 데이터를 웹서버로 전송하는 형식
            대표적인 전송 방식 : get/post
        enctype
            데이터의 인코딩 타입 : 파일 업로드시에 파일을 stream 방식으로 전송하는 multipart로 선언하여야 함.
        taget
            페이지가 특정한 window창을 대상으로 데이터를 전송할 때나 frame을 지정해서 전송할 때, 활용된다.
5. form 하위요소의 종류
    1) <input 형식>
        type의 속성에 따라
        text
        password
        button
        submit/reset
        image
        checkbox
        radio
        =============
        month|week|date|time|datetime-local
        number|range
        color
        email|url|tel|search
    2) <select>
    3) <button>
    4) <textarea>
--%>
<h2>텍스트 입력</h2>
한줄짜리 입력 : <input type="text">
암호입력 : <input type="password"> <%-- 사용자 입력 문자 대신 "*" 등 다른 글자로 출력 --%>
<%-- 
# input의 속성들
<input type="text|password" name="요소이름=key사용" maxlength="문자갯수" : 입력할 수 있는 최대 갯수
    size="" 입력창의 크기, 단위는 문자 갯수
--%>
속성 적용 : <input type="text" name="num01" maxlength="5" size="10"/>

여러줄 입력 : <textarea name="content" cols="10" rows="5" wrap="hard"></textarea>
<%-- 
# textarea의 속성
1. cols="열의 갯수"
2. rows : 행의 갯수
3. name : 요소의 이름
4. wrap : 자동 줄바꿈 처리 지정.(off|hand|soft)
--%>
<%-- 
# 데이터 목록을 가진 텍스트 입력창 datalist
1. 목록 리스트 작성하는 태그
    <option> 태그로 항목 하나 표현
2. <input type="test"에 입력가능한 데이터 목록 제고
--%>
나라 : <input type="text" list="contries">
<datalist id="contries">
    <option value="가나">
    <option value="스위스">
    <option value="브라질">
    <option value="대한민국">
</datalist>
<%-- 
# 택스트/이미지 버튼 만들기
1. <input type="button|reset|submit|image" src="" value="문자열">
    value: 버튼의 출력되는 문자열
    src : type="image"인 경우에 필요한 이미지 url
2. <button type="button|reset|submit">버튼의 문자열</button>

    submit이나 reset은 form 전체 단위로 전송하거나 초기화할 때 사용된다.

--%>
<input type="button" value="버튼"/><br>
<input type="submit" /><br>
<button type="button">이것도 버튼이네요</button><br>
<input type="image" src="img2.png"/><br>
<input type="checkbox" checked>체크(다중)<br>
<input type="radio">라디오버튼(단일)<br>
<%-- 
checked : 초기에 check여부를 지정 처리.

# 선택형 입력 : 콤보 박스
1. select
    1) 드롭다운 리스트에 목록 출력, 목록을 선택하는 입력 방식
        optoin 태그로 항목 하나 표현
        select name="오소 이름"
            size="갯수"
            multiple
        size : 콤보 박스 창의 크기
        multiple : 다수 항목 선택
    2) option
        value : 선택한 select 값을 지정
        selected
--%>
갯수:<select name="choice01" size="5" multiple>
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
</select><br>
</body>
</html>