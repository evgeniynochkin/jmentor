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
    <jsp:include page="Menu.jsp"></jsp:include>
    <h1>Введите данные</h1>
</center>
<div align="center">
    <form method="POST" action="${pageContext.request.contextPath}/login">
        <input type="hidden" name="redirectId" value="${param.redirectId}" />
            <table border="1" cellpadding="4">
                <tr>
                    <th>Логин: </th>
                    <td>
                        <input type="text" name="userLogin" size="45" value="<c:out value='${uds.login}' />" />
                    </td>
                </tr>
                <tr>
                    <th>Пароль: </th>
                    <td>
                        <input type="text" name="password" size="45" value="<c:out value='${uds.password}' />" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Enter" />
                        <a href="${pageContext.request.contextPath}/" >Отменить</a>
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
