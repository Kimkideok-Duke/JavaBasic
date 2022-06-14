<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
jsp 주석문
# 웹어플리케이션 구성요소
0. 아래의 순서로 처리를 했다가 다시 최종적으로 웹브라우저에 받는다.
1. 웹브라우저 : url에 주소와 경로로 요청을 하면 최종적으로 웹 서버에서 넘겨온 html 내용을 출력한다.
2. 웹서버
3. 어플리케이션서버
    jsp ==> java ==> class
        class가 어플리케이션 서버에 의해서 객체가 만들어지고, DB가 처리되어 최종 html을 만들어 웹브라우저에 전달한다.
    java를 컴파일 해서 html 파일을 만든다.
4. 데이터베이스
# url
1. uniform resource locator
2. 구성
    프로토콜://호스트:포트/경로명/파일명.확장자?쿼리문자열
    ex) http://naver.com"8080/search?sch=홍길동
    1) 프로토콜 : 통신규약
    2) 호스트 : 특정 서버 ==> ip로 변환 ps) localhost - 현재서버
    3) 포트 : port
    4) 경로 : 특정 절대경로로 부터 하위 경로
    5) 쿼리문자열 : 해당 페이지에 전달하는 데이터
# 서플릿과 jsp
1. 자바를 만든 sun에서 정한 웹 개발 표준
    1) 서블릿(servlet) : 실행 코드 방식의 특징
    2) jsp(JavaServer Pages):스크립트 코드 방식의 특징
2. jsp 특징
    1) 자바 기반 스크립트 언어
        - 자바의 기능을 그대로 사용 가능
    2) html에 대한 클라이언트의 요청 처리/응답
    3) 웹어플리케이션에서 결과 화면을 생성할 때, 주로 사용
# 웹 컨테이너
1. 웹 어플리케이션을 실행할 수 있는 컨테이너
2. jsp와 서블릿을 실행해 줌
    웹 컨테이너
        - jsp
        - 서블릿
# jsp를 사용하는 이유
1. 자바 언어에 기반하기 때문에 플랫폼에 독립적
    - 리눅스, 윈도우등 운영체제에 상관없이 동작
2. 자바 언어에 대한 깊은 이해 없이도 초기 학습 가능
    - 스크립트 언어는 상대적으로 자바언어보다 단순
3. 스프링이나 스트러츠와 같은 프레임워크와 연동
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>