<title>登録内容確認</title>
</head>

<body>
	<h1>登録内容確認　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
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
				<th class="header">社員ID</th>
				<td>
					<input type="text" name="empId" readonly="readonly" class="readOnly" value="自動で設定されます" />
				</td>
			</tr>
			<tr>
				<th class="header">社員名</th>
				<td>
					<input type="text" name="empNm" readonly="readonly" class="readOnly" value="${ param.empNm }" />
				</td>
				<th class="header">パスワード確認</th>
				<td>
					<input type="hidden" name="pass" value="${ param.pass }" />
					<input type="password" name="passConfirm" placeholder="再入力してください" />
				</td>
				<td colspan="2" class="btnArea">
					<input type="submit" value="登録" />
				</td>
			</tr>
		</table>
	</form>
	<a href="insert.jsp" >登録内容の編集</a>　|　<a href="menu.jsp" >メニューに戻る</a>
</body>
</html>