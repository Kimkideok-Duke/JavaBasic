<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="webprj.dao.*"
    import="webprj.z01_vo.*"
    %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
%>
<%-- 2022-06-22
[1단계:개념] 1. 화면 상세 처리를 위하여 특정 페이지로 이동하는 로직을 기술하세요
            0) a02_empInsert.jsp 페이지 타이틀(사원등록)
            1) 기능함수 선언
                function goInsertPage(){
                    location.href="a02_empInsert.jsp";
                }
            2) 버튼 선언과 이벤트 핸들러 함수 처리
                <input type="button" value="사원등록화면"
                    onclick="goInsertPage()"/>

[1단계:개념] 2. 페이지의 수정/삭제를 구별하여 처리하기 위한 코드를 예제를 통해 기술하세요
            <input type="hidden" name="proc"/>
            var proc = document.querySelector("[name=proc]");
            procObj.value="upt";
            procObj.value="del";
            ?proc=upt
            ?proc=del
            String proc = request.getParameter("proc");
            if(proc.equals("upt")){
                // 수정 처리 dao
            }
            if(proc.equals("del")){
                // 삭제 처리 dao
            }

[1단계:확인] 3. 물품 정보 리스트/상세를 위한 dao를 작성하세요.
  public Product001 getProductDetail(int pno) {
		Product001 pd = null;
		try {
			setConn();
			String sql = "SELECT *\n"
					+ "FROM product001\n"
					+ "WHERE pno = ?";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pd = new Product001(
							rs.getInt("pno"),
							rs.getString("pname"),
							rs.getInt("price"),
							rs.getInt("rcnt")
						);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("DB 에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		} finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return pd;
	}

[1단계:확인] 4. 위 물품 정보 리스트/상세 화면을 만들어 보세요.

--%>
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
	String pnoS = request.getParameter("pno");
  Product001 pd = new Product001();
  pnoS="1";
  if(pnoS!=null&&!pnoS.trim().equals("")){
    int pno = Integer.parseInt(pnoS);
    A05_PreDAO dao = new A05_PreDAO();
    pd = dao.getProductDetail(pno);
  }
%>


<h2>물품상세정보(<%=pnoS%>)</h2>
<div class="container">
  <form>
  <div class="row">
    <div class="col-25">
      <label for="pno">물품번호</label>
    </div>
    <div class="col-75">
      <input type="text" id="pno" name="pno" placeholder="물품번호 입력" value="<%=pd.getPno()%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="pno">물품명</label>
    </div>
    <div class="col-75">
      <input type="text" id="pname" name="pname" placeholder="물품명 입력" value="<%=pd.getPname()%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="price">가격</label>
    </div>
    <div class="col-75">
      <input type="text" id="price" name="price" placeholder="가격 입력" value="<%=pd.getPrice()%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="rcnt">수량</label>
    </div>
    <div class="col-75">
      <input type="text" id="rcnt" name="rcnt" placeholder="수량 입력" value="<%=pd.getRcnt()%>">
    </div>
  </div>
  <div class="row">
    <input type="button" value="수정" onclick="uptProd()" style="background-color:red">
    <input type="button" value="삭제" onclick="delProd()" style="background-color:green">
    <input type="button" value="조회화면" onclick="gomain()" style="background-color:blue">
  </div>
    <input type="hidden" name="proc"/>
  </form>
</div>
<script>
  function uptProd(){
    if(confirm("수정하시겠습니까?")){
      document.querySelector("[name=proc").value="upt";
      document.querySelector("form").submit();
    }
  }
</script>
<%
  String proc = request.getParameter("proc");
  System.out.println("현재 proc:"+proc);
%>
</body>
</html>