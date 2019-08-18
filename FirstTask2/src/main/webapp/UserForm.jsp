<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 07.07.2019
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Manager</title>
</head>
<body>
    <center>
        <h1>User Manager</h1>
        <h2>
            <a href="${pageContext.servletContext.contextPath}/hello">Список пользователей</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${uds != null}">
            <form action="${pageContext.servletContext.contextPath}/useraction/edit" method="POST">
        </c:if>
        <c:if test="${uds == null}">
            <form action="${pageContext.servletContext.contextPath}/useraction/insert" method="POST">
        </c:if>

        <table border="1" cellpadding="4">
            <caption>
                <h2>
                    <c:if test="${uds != null}">
                        Edit User
                    </c:if>
                    <c:if test="${uds == null}">
                        Add New User
                    </c:if>
                </h2>
            </caption>
                <c:if test="${uds != null}">
                    <input type="hidden" name="id" value="<c:out value='${uds.id}' />" />
                </c:if>
            <tr>
                <th>Login: </th>
                <td>
                    <input type="text" name="login" size="45" value="<c:out value='${uds.login}' />" />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45" value="<c:out value='${uds.password}' />" />
                </td>
            </tr>
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45" value="<c:out value='${uds.name}' />" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
            </form>
    </div>
</body>
</html>
