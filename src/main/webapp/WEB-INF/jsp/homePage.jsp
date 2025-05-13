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

	<%-- ↓ツイートが１件以上ある時のみ↓ --%>
	<c:if test="${not empty allTweetList }">
		<table class="tweet-table">
			<c:forEach var="user" items="${allTweetList}">
			<tr>
				<th><c:out value="${user.name}" /></th><td><c:out value="${user.tweet}" /></td>
			</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>