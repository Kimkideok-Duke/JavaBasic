<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.*"
    import="webprj.z01_vo.*"
    import="java.util.*"  
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<fmt:requestEncoding value="UTF-8"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/a00_com/a01_common.css" rel="stylesheet">
<style>
    
</style>
<script src="${path}/a00_com/jquery-3.6.0.js" type="text/javascript"></script>
<script>
    /*
    
    */
    $(document).ready(function(){
       $("h1").text("시작!");
    });
</script>
</head>
<%-- 2022-06-28
[1단계:개념] 1. jstl 환경 설정 순서를 기술하세요
            jstl을 관련 lib 설정 Web-inf lib 밑에 
            상단 taglib
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

[1단계:개념] 2. jstl을 통해 객체의 설정 속성과 일반 변수의 설정 속성을 기술하세요
            일반변수 형식
            <c:set var="변수명" value="데이터" scope="세션범위"/>
            ${변수명}

            객체의 설정 속성
            1. 객체 선언
            2. 프로퍼티로 변경
                <c:set target="객체" property="프로퍼티명" value="데이터"/>
            3. 변수 삭제
                <c:remove var="변수명" scope="영역"/>

[1단계:개념] 3. jstl의 조건문과 반복문의 기본형식을 예제를 통해 기술하세요
            조건문
            1. if - 조건이 ture일 경우 몸체 내용 실행
                <c:if test="조건">
                </c:if>
            2. choose when - otherwise
              <c:choose>
                <c:when est="${조건1}">
                    처리구문
                </c:when>
                <c:when test="${조건2}">
                    조건1이외에 조건2일때.. 처리구문
                </c:when>
                <c:when test="${조건2}">
                    처리구문
                </c:when>
                <c:otherwise>
                    처리구문
                </c:otherwise>
              </c:choose>

            반복문
            1. 집합이나 콜렉션 테이터 사용
                <c:forEach var="변수" item="아이템">
                </c:forEach>
            2. 특정 횟수 반복
                <c:forEach var="cnt" begin="시작번호"
                    end="마지막번호" step="증감단위"


[1단계:확인] 4. 임의의 구구단 문제가 나오고 정답을 오답 여부를 jstl에 의해 출력하게 하세요
      [ @@  ] X [ @@  ] = [   ] [확인]--%>
<body>


<%-- <c:if test="${param.ans==(rand1*rand2)}">
    <h2>정답</h2>
</c:if>
<c:if test="${param.ans!=(rand1*rand2)}">
    <h2>오답</h2>
</c:if>
<h2>${rand1} x ${rand2} = </h2> --%>

<div class="container">
  <form >
  <div class="row">
    <div class="col-25">
      <label for="ans">구구단</label>
    </div>
    <c:set var="rand1" value="<%=(int)(Math.random()*9+1)%>" scope="request"/>
    <c:set var="rand2" value="<%=(int)(Math.random()*9+1)%>" scope="request"/>
    <div class="col-75">
      <input type="text" id="rand1" name="rand1" size="1" value="${rand1}">X
      <input type="text" id="rand2" name="rand2" size="1" value="${rand2}">=
      <input type="text" id="ans" name="ans" size="1" value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  </form>
</div>
  <script>
    var rand1 = "${param.rand1}"
    var rand2 = "${param.rand2}"
    var ans = "${param.ans}"
    if(grade!=""){
      var corNum = rand1*rand2;
      if(corNum == innum){
        alert("정답:"+rand1+"X"+rand2+"="+ans);
      }else{
        alert("오답("+rand1+"X"+rand2+"="+ans+")\n 정답은 "+corNum);
      }
    }
  </script>



<%-- [1단계:확인] 5. 회원정보리스트 dao기능 메서드를 추가하고, jstl을 통해서 검색 출력하세요.  --%>
<jsp:useBean id="dao" class="webprj.dao.A05_PreDAO"/>
<jsp:useBean id="sch" class="webprj.z01_vo.Member011" scope="request"/>
<jsp:setProperty property="*" name="sch"/>
<div class="container">
  <form >
  <div class="row">
    <div class="col-25">
      <label for="name">이름</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="이름입력.."
         value="${sch.name}">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="auth">권한</label>
    </div>
    <div class="col-75">
      <select name="auth">
        <option value="">전체</option>
        <option>일반사용자</option>
        <option>관리자</option>
        <option>방문객</option>
      </select>
      <script>
        $("[name=auth]").val("${mem.auth}");
        // $("선택자").val("값할당")
      </script>
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  </form>
</div> 
<table>
    <tr><th>no</th><th>아이디</th><th>비밀번호</th><th>이름</th><th>포인트</th><th>권한</th></tr>
    <c:forEach var="mem" items="${dao.getMemList(sch)}" varStatus="sts">
    <tr><td>${sts.count}</td><td>${mem.id}</td><td>${mem.pass}</td><td>${mem.name}</td><td>${mem.point}</td><td>${mem.auth}</td></tr>
    </c:forEach>
</table>
</body>
</html>