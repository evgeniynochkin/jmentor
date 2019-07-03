<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 29.06.2019
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователь</title>
</head>
<body>
    <h1>Успешный вход в систему</h1>
    <jsp:useBean id="uds" class="servlet.ServletUsers" scope="application"/>
    Пользователь: <%=uds.getName()%>
    Логин: <%=uds.getLogin()%>
</body>
</html>
