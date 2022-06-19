<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
    String path = request.getContextPath();
    int[][] numArr = new int[10][2];
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
/*
2022-06-17


[1단계:개념] 3. json 객체의 속성과 메서드에 대하여 기술하세요.
 # 자바스크립트 객체 구성
    1. 여러개의 프로퍼티와 메소드로 구성
        1) 프로퍼티 : 객체의 고유한 속성(변수)
        2) 메소드 : 함수
    var obj01 = {name:"홍길동", agee:25,
                    show:function(){
                        console.log(this.name);
                        console.log(this.age);
                        console.log(this.show);
                    },
                    showDom:function(){
                        var divObj = document.querySelector("div");
                        divObj.innerHtml += "<h2>이름:"+this.name+",나이는:"+this.age+"</h2>"
                    }
                }
*/
</script>
</head>
<body>
<%-- [1단계:개념] 1. css, js, img의 절대 경로와 상대 경로를 설정하는 방법을 기본 예제를 통해 설명하세요. --%>
<%-- <css>
<link href="../a00_com/a01_common.css">
<link href="<%=path%>/a00_com/a01_common.css">
<js>
<script type="text/javascript" src="../a00_comm/a02_comFun.js"></script>
<script type="text/javascript" src="<%=path%>/a00_comm/a02_comFun.js"></script>
<img>
<img src="../a00_img/img1.png" width="100" height="100">
<img src="<%=path%>/a00_img/img1.png" width="100" height="100"> --%>

<%-- [1단계:개념] 2. a link 태그의 속성에 대하여, 설명하되 iframe과 연동처리를 위한 처리를 기본예제로 기술하세요. --%>
<%--
      <iframe src="demo_iframe.htm" name="iframe_a" height="300px" width="100%" title="Iframe"></iframe>
      <p><a href="https://www.daum.net" target="iframe_a">daum.net</a></p>
--%>

<%-- [1단계:확인] 4. [jsp] 4개 중 단일 선택하는 객관식 퀴즈 문제를 form요소 객체와 함께 만들어, 
      정답여부를 다음 페이지에서 출력하세요. --%>
      <form action="Hw0617_receive.jsp">
            1+1=?<br>
            <input type="radio" id="zero" name="answer" value="0"> 0<br>
            <input type="radio" id="one" name="answer" value="1"> 1<br>
            <input type="radio" id="two" name="answer" value="2"> 2<br>
            <input type="radio" id="three" name="answer" value="3"> 3<br>
            <input type="submit" value="제출">
      </form>

<%-- [1단계:확인] 5. [jsp] 1~99임의의 수를 생성하는 덧셈문제 10문제를 출력하고 각 문제당 답을
      입력시, 정답인 수와 점수(0~100)을 출력하세요.
      1  [@@] + [@@] = [   ]
      2  [@@] + [@@] = [   ]
      3  [@@] + [@@] = [   ]
         ..
      10 [@@] + [@@] = [   ]
              [확인] --%>
      <script>
            function scoreCk(){
                  var resp = document.querySelectorAll("[name=resp]");
                  var ans = 0;
                  var score = 0;
                  var corcnt = 0;
                  for(int i=0;i<numArr.length;i++){
                        ans = numArr[i][0]+numArr[i][1];
                        if(ans==resp[i]) corcnt++;
                  }
            }
      </script>
      <%
      for(int i=0;i<numArr.length;i++){%>
            <%=i%>  
            <%for(int j=0;j<numArr[].length;j++){
                  int numR = (int)(Math.random()*99+1);
                  numArr[i][j]=numR;
            }%>
            <%=numArr[i][0]%>+<%=numArr[i][1]%> = <input type="text" name="resp" value="0"><br>
      <%}%>
      <input type="button" value="확인" onclick="scoreCk()">

</body>
</html>