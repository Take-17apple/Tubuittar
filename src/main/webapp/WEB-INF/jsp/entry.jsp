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

	<form action="EntryServlet" method="post">
		<div class="entry-form">
			<label for="userName">ユーザーネーム</label>
				<input type="text" name="name" id="userName" placeholder="名前を入力してください" required /><br>
			<label for="password">パスワード</label>
			<input type="password" name="pass" id="password" placeholder="パスワードを入力してください" required /><br>
		<div class="entry-button">
			<button type="submit">登録</button>
		</div>
		</div>
	</form>
	
	<a href="LoginServlet" class="a-link">トップページ</a>
	
</body>
</html>