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
<%@ include file="headerMsg.jsp" %>

	<form action="AccountDeleteServlet" method="post">
		<div class="delete-show">
			<c:out value="${user.name }"></c:out>さん、本当にアカウントを削除しますか？
		</div>
		<div class="delete-button">
			<button type="submit" name="delete" value="はい">はい</button>
			<button type="submit" name="delete" value="いいえ">いいえ</button>
		</div>
	</form>
	
</body>
</html>