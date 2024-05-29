<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索</title>
</head>

<body>
	<h1>検索条件入力　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
	<form action="select" method="post" >
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
					<input type="text" name="setEmployeeList_id" placeholder="社員ID" maxlength="50"value="${setEmployeeList_id }" />
				</td>
			</tr>
			<tr>
				<th class="header">TODOリストID</th>
				<td>
					<input type="text" name="idTodo" placeholder="TODOのID" maxlength="50"value="${idTodo }" />
				</td>
			</tr>
			<tr>
				<th class="header">TODOの内容</th>
				<td>
					<input type="text" name="todo" placeholder="TODOの内容" maxlength="50"value="${todo }" />
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btnArea">
					<input type="submit" value="検索" />
				</td>
			</tr>
		</table>
	</form>
	<a href="menu.jsp" >メニューに戻る</a>
</body>
</html>