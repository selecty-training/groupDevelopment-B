<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="css/update.css">
<head>
<meta charset="UTF-8">
<title>TODO情報更新</title>
</head>

<body>
	<h1>TODO情報更新　　　<span class="loginInfo">ログイン者名：${ sessionScope.LOGIN_EMP.nmEmployee }</span></h1>
	<form action="targetSearch" method="post">
	    <c:if test="${errMsg != null}">
            <div class="msgBox error">
                <c:forEach items="${ errMsg }" var="errList">
                    <c:out value="${errList}" />
                </c:forEach>
            </div>
        </c:if>
        <div class="aaa">
            <table>
                <tr>
                    <th class="header">TODOのID</th>
                    <td style="width: 250px;">
                        <input type="text" placeholder="ID" name="idTodo" required="required"
                            style="width: 100%;" value="${param.idTodo }"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="btnArea">
                        <input type="hidden" name="page" value="update" />
                        <input type="submit" value="更新内容入力"  />
                    </td>
                </tr>
            </table>
        </form>
        <a href="menu.jsp" >メニューに戻る</a>
        </div>
</body>
</html>