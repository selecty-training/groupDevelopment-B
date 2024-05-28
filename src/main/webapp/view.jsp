<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>閲覧画面</title>
</head>

<body>
	<h1>閲覧画面　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
	<table>
		<!-- TODO一覧 -->
		<tr>
			<td>TODO一覧</td>
		</tr>

		<!-- メニュー表示 -->
		<tr>
			<td><a href="menu.jsp">メニュー</a></td>
		</tr>
	</table>
</body>

</html>