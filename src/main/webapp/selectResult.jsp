<%@ page import = "entity.EmployeeInfo" %>
<%@ page import = "entity.TodoListInfo" %>

<%@ page import="java.util.ArrayList" %>
<%ArrayList<EmployeeInfo> todoList = (ArrayList<EmployeeInfo>)request.getAttribute("empInfoList");%>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<link rel="stylesheet" href="css/selectResult.css">
<title>検索結果表示</title>
</head>

<body>
	<h1>検索結果表示　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
	<div class="aaa">
		<table>
			<thead>
				<tr>
					<th style="width: 180px;">社員ID</th>
					<th style="width: 300px;">社員名</th>
					<th style="width: 300px;">TODOリストID</th>
					<th style="width: 300px;">TODOの内容</th>
				</tr>
			</thead>
			<tbody class="tb">
				
				
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
		<hr>
		<a href="select.jsp">検索条件入力に戻る</a>　|　<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>