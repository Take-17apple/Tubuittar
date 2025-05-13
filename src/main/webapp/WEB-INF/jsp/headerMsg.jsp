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

	<%-- ↓登録に成功or失敗した時のみ↓ --%>
	<c:if test="${entryMsg != null}">
		<h3><c:out value="${entryMsg}" escapeXml="false" /></h3>
	</c:if>
	<%-- ↓ログインに成功or失敗した時のみ↓ --%>
	<c:if test="${loginMsg != null}">
		<h3><c:out value="${loginMsg}" escapeXml="false" /></h3>
	</c:if>
	<%-- ↓ツイートが入力されていない時のみ↓ --%>
	<c:if test="${nullEntryMsg != null}">
		<h3><c:out value="${nullEntryMsg}" escapeXml="false" /></h3>
	</c:if>
	<%-- ↓ツイートが１件もない時のみ↓ --%>
	<c:if test="${nullMsg != null}">
		<h3><c:out value="${nullMsg}" escapeXml="false" /></h3>
	</c:if>
	<%-- ↓ログアウトした時のみ↓ --%>
	<c:if test="${logoutMsg != null}">
		<h3><c:out value="${logoutMsg}" escapeXml="false" /></h3>
	</c:if>
	<%-- ↓アカウント削除しようとしたけど削除しなかった時のみ↓ --%>
	<c:if test="${accountDelCanselMsg != null}">
		<h3 class="del-cansel"><c:out value="${accountDelCanselMsg}" escapeXml="false" /></h3>
	</c:if>
	<%-- ↓アカウント削除した時のみ↓ --%>
	<c:if test="${accountDelMsg != null}">
		<h3><c:out value="${accountDelMsg}" escapeXml="false" /></h3>
	</c:if>
	<p clear:left></p>
	
</body>
</html>