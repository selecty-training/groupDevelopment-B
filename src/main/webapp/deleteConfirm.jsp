<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>削除内容確認</title>
</head>
<link rel="stylesheet" href="css/deleteConfirm.css">
<body>
	<h1>削除内容確認　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
	<div class="aaa">
		<form action="delete" method="post" >
			<table>
				<tr>
					<th class="header">社員ID</th>
					<td>
						<input type="text" name="employeeList_id" readonly="readonly" class="readOnly" value="${ employeeList_id }" />
					</td>
				</tr>
				<tr>
					<th class="header">社員名</th>
					<td>
						<input type="text" name="empNm" readonly="readonly" class="readOnly" value="${ empNm }"/>
					</td>
				</tr>
				<tr>
					<th class="header">idTodo</th>
					<td>
						<input type="text" name="idTodo" readonly="readonly" class="readOnly" value="${ idTodo }" />
					</td>
				</tr>
				<tr>
					<th class="header">TODOの内容</th>
					<td>
						<input type="text" name="todo" readonly="readonly" class="readOnly" value="${ todo }" />
					</td>
				</tr>
				
				<tr>
					<td colspan="2" class="btnArea">
						<input type="submit" value="削除" />
					</td>
				</tr>
			</table>
		</form>
		<a class="a" href="delete.jsp" >削除対象の変更</a>　|　<a href="menu.jsp" >メニューに戻る</a>
	</div>
</body>
</html>