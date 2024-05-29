<title>検索結果表示</title>
</head>

<body>
	<h1>検索結果表示　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
	<table>
		<thead>
			<tr>
				<th style="width: 60px;">社員ID</th>
				<th style="width: 100px;">社員名</th>
				<th style="width: 100px;">TODOリストID</th>
				<th style="width: 100px;">TODOの内容</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ empInfoList }" var="empInfo">
				<tr>
					<td><c:out value="${ empInfo.employee.idEmployee }" /></td>
					<td><c:out value="${ empInfo.employee.nmEmployee }" /></td>
					<td><c:out value="${ empInfo.employee.nmEmployee }" /></td>
					<td><c:out value="${ empInfo.employee.nmEmployee }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<a href="select.jsp">検索条件入力に戻る</a>　|　<a href="menu.jsp">メニューに戻る</a>
</body>
</html>