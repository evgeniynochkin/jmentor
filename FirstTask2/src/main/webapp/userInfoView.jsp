<%--
  Created by IntelliJ IDEA.
  User: nochj
  Date: 25.09.2019
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
    <jsp:include page="Menu.jsp"></jsp:include>

    <h3>Привет: ${loginedUser.login}</h3>

    Имя пользователя: <b>${loginedUser.name}</b>
    <br />
    Права: ${loginedUser.role} <br />
</body>
</html>
