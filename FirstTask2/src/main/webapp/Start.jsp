<%--
  Created by IntelliJ IDEA.
  User: nochj
  Date: 20.09.2019
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>
</head>
<body>
<center>
    <h1>Введите данные</h1>
</center>
<div align="center">
    <form>
            <table border="1" cellpadding="4">
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
                    <td colspan="2" align="center">
                        <input type="submit" value="Enter" />
                    </td>
                </tr>
            </table>
        </form>
</div>
<center>
    <h3>
        <a href="${pageContext.servletContext.contextPath}/useraction/insert">Регистрация</a>
    </h3>
    <h3>
        <a href="${pageContext.servletContext.contextPath}/hello">Тестовая</a>
    </h3>
</center>
</body>
</html>
