<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="css/menu.css">
<head>
<meta charset="UTF-8">
<title>メインメニュー</title>
</head>

<body>

	<div class="bg_pattern Paper_v2"></div>
	<div class="section">

	<h1>メインメニュー　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
	<ul class="ul">
		<!-- 検索列 -->
		<li class="icon_s">
			<a href="select.jsp">TODO検索</a>	
		</li>

		<!-- 登録列 -->
		<li class="icon_i">
			<a href="insert.jsp">TODO登録</a>	
		</li>

		<!-- 更新列 -->
		<li class="icon_u">
			<a href="update.jsp">TODO更新</a>	
		</li>

		<!-- 削除列 -->
		<li class="icon_d">
			<a href="delete.jsp">TODO削除</a>	
		</li>
	</ul>
</body>

</html>