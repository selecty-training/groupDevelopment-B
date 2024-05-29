<title>社員情報更新</title>
</head>

<body>
	<h1>社員情報更新　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
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
					<input type="text" name="employeeList_id" placeholder="TODOのID" maxlength="50" value="${ param.employeeList_id }" required="required"/>
				</td>
			</tr>
			<tr>
				<th class="header">TODOの内容</th>
				<td>
					<input type="text" name="todo" placeholder="TODOの内容" maxlength="50" value="${ param.todo }" required="required"/>
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
</body>
</html>