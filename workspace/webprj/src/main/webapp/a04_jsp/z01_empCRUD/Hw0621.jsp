<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.*"
    import="webprj.z01_vo.*"
    %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
%>	
<%-- 2022-06-21
[1단계:개념] 1. 조회리스트 화면에서 사용되는 요청값 처리와 dao단 매개변수 처리 방식에 대하여 핵심 코드를 기술하세요
            <form method="post">
              사원명:<input type="text" name="ename" value="<%=ename%>"/><br>
              직책명:<input type="text" name="job" value="<%=job%>"/><br>
              <input type="button" id=regBtn value="등록" onclick="goInsertPage()"/>
              <input type="submit" value="검색"/>
            </form>
            <%
            A05_PreDAO dao = new A05_PreDAO();
            %>
            <table id="customers">
              <tr><th>사원번호</th><th>사원명</th><th>직책</th><th>급여</th><th>부서번호</th></tr>
              <% for(Emp e:dao.getEmpList2("","")){%>
              <tr><td><%=e.getEmpno()%></td><td><%=e.getEname()%></td><td><%=e.getJob()%></td><td><%=e.getSal()%></td><td><%=e.getDeptno()%></td></tr>
              <%}%>
            </table>

[1단계:개념] 2. 등록 처리를 위해서 처리하는 순서를 기술하세요.
            html/css 처리 : 테이블에 들어갈 항목
            필수 입력 항목 설정 js로 처리
            요청값 확인 (등록데이터)
            등록 DAO구성 및 기능 메서드 호출
            등록 완료 후, 기능 process

[1단계:확인] 3. 회원 테이블 member(회원아이디, 패스워드, 회원명, 포인트, 권한)을 만들고, 
              회원등록 화면에서 등록 처리(dao 메서드 추가)하세요.(본인 단계 맞게 진행)
     1단계) 회원등록 화면구성 2단계) 회원등록 유효CHECK, 요청값 전달 3단계) DAO 만들기 4단계) 처리하기 

    public ArrayList<Member011> getMemList(String id, String pass) {
		ArrayList<Member011> memList = new ArrayList<Member011>();
		try {
			setConn();
			String sql = "select * \n"
						+ "from member011 \n"
						+ "where id like '%'|| ? ||'%' \n"
						+ "and pass like '%'|| ? ||'%'";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			rs.next();
			while(rs.next()) {
				memList.add(new Member011(
								rs.getString("id"),
								rs.getString("pass"),
								rs.getString("name"), 
								rs.getInt("point"),
								rs.getString("auth") )
								);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return memList;
	}--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=path %>/a00_com/a01_common.css" rel="stylesheet">
<style>

</style>
<script>
	/*
	
	*/
</script>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
  if(id==null) id = "";
  if(pass==null) pass = "";
%>


<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="id">아이디</label>
    </div>
    <div class="col-75">
      <input type="text" id="id" name="id" placeholder="id 입력" value="">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="pass">비밀번호</label>
    </div>
    <div class="col-75">
      <input type="password" id="pass" name="id" placeholder="pass 입력" value="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="검색">
  </div>
  </form>
</div>

<%
A05_PreDAO dao = new A05_PreDAO();
%>

<table>
        <tr><th>아이디</th><th>비밀번호</th><th>이름</th><th>포인트</th><th>권한</th></tr>
        <% for(Member011 m:dao.getMemList("", "")){%>
        <tr><td><%=m.getId()%></td><td><%=m.getPass()%></td><td><%=m.getName()%></td><td><%=m.getPoint()%></td><td><%=m.getAuth()%></td></tr>
        <%}%>
</table>
</body>
</html>