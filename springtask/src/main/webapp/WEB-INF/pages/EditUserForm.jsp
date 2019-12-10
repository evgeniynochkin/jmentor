<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 07.07.2019
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
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
                <a href="${pageContext.servletContext.contextPath}/start">Вход </a>
            </c:if>
            <c:if test="${uds != null}">
                <a href="${pageContext.servletContext.contextPath}/hello">Список пользователей</a>
            </c:if>
        </h3>
    </center>
    <div align="center">
        <form:form action="/save" method="post" modelAttribute="user">
            <table border="0" cellpadding="5">
                <caption>
                    <h2>Edit User</h2>
                </caption>
                <tr>
                    <th>ID: </th>
                    <td>
                        <form:hidden path="id"/>
                    </td>
                </tr>
                <tr>
                    <th>Login: </th>
                    <td>
                        <form:input path="login"/>
                    </td>
                </tr>
                <!--<tr>
                    <th>Password: </th>
                    <td>
                        <input path="password"/>
                    </td>
                </tr>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input path="name"/>
                    </td>
                </tr>
                <tr>
                    <th>Role: </th>
                    <td>
                        <input path="role"/>
                    </td>
                </tr> -->
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
