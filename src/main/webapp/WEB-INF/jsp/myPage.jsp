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

	<form action="TweetServlet" method="post">
		<div class="tweet-textarea">
			<textarea name="tweet" rows="5" cols="30" ></textarea>
		</div>
		<div class="tweet-button">
			<button type="submit">つぶやく</button>
		</div>
	</form>
	<%-- ↓ツイートが１件以上ある時のみ↓ --%>
	<c:if test="${not empty myTweetList }">
		<table class="tweet-table">
			<c:forEach var="ac" items="${myTweetList}">
			<tr>
				<th><c:out value="${ac.name}" /></th><td><c:out value="${ac.tweet}" /></td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
	
</body>
</html>