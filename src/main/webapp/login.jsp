<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
    <h1>ログイン</h1>
    <form method="post" action="login">
        <c:if test="${errMsg != null}">
            <div class="msgBox error">
                <c:forEach items="${ errMsg }" var="errList">
                    <c:out value="${errList}" />
                </c:forEach>
            </div>
        </c:if>
        <table>
            <tr>
                <th class="header">ID</th>
                <td style="width: 250px;">
                    <input type="text" placeholder="ID" name="id" required="required"
                        style="width: 100%;" value="${param.id }"/>
                </td>
            </tr>
            <tr>
                <th style="text-align: right;">PASS</th>
                <td>
                    <input type="password" placeholder="PASS" name="pass" required="required"
                        style="width: 100%;" value="${param.pass }" />
                </td>
            </tr>
            <tr>
                <td colspan="2" class="btnArea">
                    <input type="reset" value="リセット" />
                    <input type="submit" value="ログイン"  />
                </td>
            </tr>
        </table>
    </form>
</body>

</html>

</body>
</html>