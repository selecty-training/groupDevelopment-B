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
				<th class="header">社員ID</th>
				<td>
					<input type="text" name="empId" readonly="readonly" class="readOnly" value="${ empId }" required="required"/>
				</td>
			</tr>
			<tr>
				<th class="header">社員名</th>
				<td>
					<input type="text" name="empNm" placeholder="社員名" maxlength="50" value="${ empNm }" required="required"/>
				</td>
			</tr>
			
				<th class="header">パスワード</th>
				<td>
					<input type="password" name="pass" maxlength="10" placeholder="※更新する場合は入力"/>
					<input type="hidden" name="passOld"   value="${ passOld }" />
				</td>
			</tr>
			<tr>
				<th class="header">パスワード確認</th>
				<td>
					<input type="password" name="passConf" maxlength="10" placeholder="※更新する場合は再入力"/>
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