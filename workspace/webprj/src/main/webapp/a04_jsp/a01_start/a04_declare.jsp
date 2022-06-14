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
// # 선언을 한 내용을 scriptlet이나 expression 사용
// 1. 변수 선언
String name = "홍길동";
// 2. 기능 메서드 선언.
int plus(int num01, int num02){
    return num01+num02;
}
// 3.클래스 선언
class Person{
    private String name;
    private int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }
}
%>
<h2>이름 출력:<%=name%></h2>
<h2>메서드 호출:<%=plus(10,30)%></h2>
<%
    Person p1 = new Person("홍길동", 25);
%>
<h3><%=p1.getName() %></h3>
<h3><%=p1.getAge() %></h3>
</body>
</html>
