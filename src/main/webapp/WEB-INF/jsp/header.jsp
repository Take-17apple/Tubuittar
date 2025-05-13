<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tubuittar</title>
</head>
<body>

	<c:if test="${user == null }">
		<a href="index.jsp">
		<img alt="rogo" class="logo-img" src="${pageContext.request.contextPath}/picture/ChatGPT Image 2025年5月5日 17_29_07.png">
		</a>
		<p clear:left></p>
	</c:if>
	<c:if test="${user != null }">
		<a href="HomeServlet">
		<img alt="rogo" class="logo-img" src="${pageContext.request.contextPath}/picture/ChatGPT Image 2025年5月5日 17_29_07.png">
		</a><br>
		<a href="TweetServlet" class="a-link"><c:out value="${user.name}"/>のマイページ</a>
		<a href="SettingServlet" class="a-link">設定</a>
		<p clear:left></p>
	</c:if>
	
</body>
</html>