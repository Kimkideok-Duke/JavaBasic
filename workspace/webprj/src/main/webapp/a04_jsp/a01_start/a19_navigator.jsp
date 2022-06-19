<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
  margin: 0;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 25%;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

li a.active {
  background-color: #04AA6D;
  color: white;
}

li a:hover:not(.active) {
  background-color: #555;
  color: white;
}
</style>



</head>
<body>
	<ul>
		<%-- 절대적 경로로 link --%>
	  	<li><a href="<%=path%>/a04_jsp/a01_start/a20_menu01.jsp"
	  				target="frame01">Home</a></li>
		<%-- 상대적 경로로 link --%>
		<li><a href="a20_menu02.jsp" target="frame01">News</a></li>
		<li><a class="active" href="a20_menu03.jsp" target="frame01">Contact</a></li>
		<li><a href="a20_menu04.jsp" target="frame01">About</a></li>
	</ul>

	<div style="margin-left:25%;padding:1px 16px;height:1000px;">
		<h2>Fixed Full-height Side Nav</h2>
		<h3>Try to scroll this area, and see how the sidenav sticks to the page</h3>
		<p>Notice that this div element has a left margin of 25%. This is because the side navigation is set to 25% width. If you remove the margin, the sidenav will overlay/sit on top of this div.</p>
		<p>Also notice that we have set overflow:auto to sidenav. This will add a scrollbar when the sidenav is too long (for example if it has over 50 links inside of it).</p>
		<p>Some text..</p>
		<p>Some text..</p>
		<p>Some text..</p>
		<p>Some text..</p>
		<p>Some text..</p>
		<p>Some text..</p>
		<p>Some text..</p>
	</div>
</body>
</html>