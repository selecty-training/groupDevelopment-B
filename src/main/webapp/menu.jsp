<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page import = "entity.EmployeeInfo" %>
<%@ page import = "entity.TodoListInfo" %>

<%@ page import="java.util.ArrayList" %>
<%ArrayList<EmployeeInfo> todoList = (ArrayList<EmployeeInfo>)request.getAttribute("empInfoList");%>
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
	
	<h1>TODO一覧表<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
	<table><!-- ここでTODO全件表示を載せて、TODO一覧表としたい -->
		<thead>
			<tr>
				<th style="width: 60px;">社員ID</th>
				<th style="width: 100px;">社員名</th>
				<th style="width: 100px;">TODOリストID</th>
				<th style="width: 100px;">TODOの内容</th>
			</tr>
		</thead>
			<tbody>
			
			<% for(EmployeeInfo emp : todoList){ %>
				<tr>
					<td><%=emp.getId() %></td>
					<td><%=emp.getEmployee() %></td>
					<td><%=emp.getTodo().getIdToDo()  %></td>
					<td><%=emp.getTodo().getTodo() %></td>
				</tr>
			<% } %>
			
			</tbody>
	</table>
		

	<h1>メインメニュー</h1>
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
	<a href="login.jsp">ログイン画面に戻る</a>
</body>

</html>