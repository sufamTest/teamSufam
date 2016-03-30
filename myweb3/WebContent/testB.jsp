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
	request.setAttribute("addr", "서울");
	//redirect방식
	//response.sendRedirect("testC.jsp");
%>
<!-- foward방식 -->
<jsp:forward page="testC.jsp"></jsp:forward>
</body>
</html>