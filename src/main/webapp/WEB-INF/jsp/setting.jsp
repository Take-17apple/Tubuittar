<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<title>Tubuittar</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<a href="LogoutServlet" class="a-link">ログアウト</a>
	<a href="AccountDeleteServlet" class="a-link">アカウント削除</a>
	
</body>
</html>