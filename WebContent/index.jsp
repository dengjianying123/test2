<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/login.jsp">1_跳转到登录页面</a>
	<br>
	<a href="${pageContext.request.contextPath}/sessionServlet">2_后台获取session回话值</a>
	<br>
	<a href="${pageContext.request.contextPath}/getLoginSession.jsp">3_后台获取session回话值</a>
	<br>
	<a href="${pageContext.request.contextPath}/removeSession">4_清除session回话值</a>
</body>
</html>