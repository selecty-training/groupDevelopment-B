<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>社員情報更新</title>
</head>
<link rel="stylesheet" href="css/updateInput.css">
<body>
	<h1>社員情報更新　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
	<div class="aaa">
		<form action="update" method="post">
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
						<input type="text" name="idTodo" readonly="readonly" class="readOnly" value="${ idTodo }" required="required"/>
					</td>
				</tr>
				<tr>
					<th class="header">社員ID</th>
					<td>
						<input type="text" name="employeeList_id" placeholder="社員のID" maxlength="50" value="${ employeeList_id }" required="required"/>
					</td>
				</tr>
				<tr>
					<th class="header">TODOの内容</th>
					<td>
						<input type="text" name="todo" placeholder="TODOの内容" maxlength="50" class="readOnly" value="${ todo }" required="required"/>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" class="btnArea">
						<input type="submit" value="更新" />
					</td>
				</tr>
			</table>
		</form>
		<a href="update.jsp" >更新対象の変更</a>　|　<a href="menu.jsp" >メニューに戻る</a>
	</div>
</body>
</html>