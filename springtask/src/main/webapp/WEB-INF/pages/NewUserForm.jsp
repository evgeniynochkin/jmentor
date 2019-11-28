<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 07.07.2019
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Manager</title>
</head>
<body>
    <center>
        <h1>User Manager</h1>
        <h3>
            <c:if test="${uds == null}">
                <a href="/springtask_war/">Вход </a>
            </c:if>
            <c:if test="${uds != null}">
                <a/springtask_war href="/springtask_war/">Список пользователей</a>
            </c:if>
        </h3>
    </center>
    <div align="center">
        <form:form action="save" method="post" modelAttribute="user">
            <table border="1" cellpadding="4">
                <caption>
                    <h2>Add New User</h2>
                </caption>
                <tr>
                    <th>Login: </th>
                    <td>
                        <input type="text" name="login" size="45" value="" />
                    </td>
                </tr>
                <tr>
                    <th>Password: </th>
                    <td>
                        <input type="text" name="password" size="45" value="" />
                    </td>
                </tr>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45" value="" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>