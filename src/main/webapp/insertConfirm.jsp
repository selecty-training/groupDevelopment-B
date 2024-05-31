
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><title>TODO登録内容確認</title>
</head>
<link rel="stylesheet" href="css/insertConfirm.css">
<body>
	<h1>TODO登録内容確認　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
	<div class="aaa">
		<form action="insert" method="post" >
			<c:if test="${errMsg != null}">
				<div class="msgBox error">
					<c:forEach items="${ errMsg }" var="errList">
						<c:out value="${errList}" />
					</c:forEach>
				</div>
			</c:if>
			<table>
				<tr>
					<th class="header">TODOのID</th>
					<td>
						<input type="text" name="idTodo" readonly="readonly" class="readOnly" value="自動で設定されます" />
					</td>
				</tr>
				<tr>
					<th class="header">社員ID</th>
					<td>
						<input type="text" name="employeeList_id" readonly="readonly" class="readOnly" value="${ param.employeeList_id }" />
					</td>
				</tr>
				<tr>
					<th class="header">TODOの内容</th>
					<td>
						<input type="text" name="todo" readonly="readonly" class="readOnly" value="${ param.todo }" />
					</td>
					
				</tr>
				<tr>
					<td colspan="2" class="btnArea">
						<input type="submit" value="登録" />
					</td>
				</tr>
			</table>
		</form>
		<a class="a" href="insert.jsp" >TODO登録内容の編集</a>　|　<a href="menu.jsp" >メニューに戻る</a>
	</div>
</body>
</html>