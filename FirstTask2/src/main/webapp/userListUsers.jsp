<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 25.06.2019
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
    <center>
        <h1>Пользователи</h1>
    </center>
    <div aling="center">
        <table border="1" cellpadding="5">
            <caption><h2>Список пользователей</h2></caption>
            <tr>
                <th>ID</th>
                <th>Логин</th>
                <th>Имя</th>
            </tr>
            <c:forEach var="users" items="${usersList}">
                <tr>
                    <td><c:out value="${users.id}" /></td>
                    <td><c:out value="${users.login}" /></td>
                    <td><c:out value="${users.name}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
