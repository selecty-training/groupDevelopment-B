<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="css/login.css">
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
    <div class="login_container">
        <h1 class="login">ログイン</h1>
        <form method="post" action="login">
            <c:if test="${errMsg != null}">
                <div class="msgBox error">
                    <c:forEach items="${ errMsg }" var="errList">
                        <c:out value="${errList}" />
                    </c:forEach>
                </div>
            </c:if>
            <table class="teble">
                <tr class="id">
                    <th class="header">ID</th>
                </tr>
                <tr class="id_content">
                    <td style="width: 250px;">
                        <input type="text" placeholder="ID" name="id" required="required"
                            style="width: 100%;" value="${param.id }"/>
                    </td>
                </tr>
                <tr class="pass">
                    <th class="header">PASS</th>
                </tr>
                <tr class="pass_content">
                    <td>
                        <input type="password" placeholder="PASS" name="pass" required="required"
                            style="width: 100%;" value="${param.pass }" />
                    </td>
                </tr>
                <tr class="button">
                    <td colspan="2">
                        <input class="login_button" type="submit" value="ログイン"  /><br>
                        <input class="reset_button" type="reset" value="リセット" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>

</body>
</html>