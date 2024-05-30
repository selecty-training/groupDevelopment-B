<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO登録</title>
</head>

<body>
	<h1>TODO登録　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
	<form action="inputCheck" method="post" >
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
				<th class="header">TODOの内容</th>
				<td>
					<input type="text" name="todo" placeholder="TODOの内容" required="required" maxlength="50" value="${ param.todo }" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2" class="btnArea">
					<input type="submit" value="登録確認" />
				</td>
			</tr>
		</table>
	</form>
	<a href="menu.jsp" >メニューに戻る</a>
</body>
</html>