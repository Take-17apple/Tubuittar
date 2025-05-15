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
<%@ include file="WEB-INF/jsp/header.jsp" %>
<%@ include file="WEB-INF/jsp/headerMsg.jsp" %>
	
	<form action="LoginServlet" method="post">
		<div class="entry-form">
			<label for="userName">ユーザーネーム</label>
				<input type="text" name="name" id="userName" placeholder="名前を入力してください" required /><br>
			<label for="password">パスワード</label>
			<input type="password" name="pass" id="password" placeholder="パスワードを入力してください" required /><br>
		<div class="entry-button">
			<button type="submit">ログイン</button>
		</div>
		</div>
	</form>
	
	<%-- ↓登録が成功した時以外、出力する↓ --%>
	<c:if test="${entryMsg == null}">
		<a href="EntryServlet" class="a-link">新規登録</a>
	</c:if>
	
</body>
</html>