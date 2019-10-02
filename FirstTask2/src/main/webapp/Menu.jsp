<%--
  Created by IntelliJ IDEA.
  User: nochj
  Date: 25.09.2019
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="${pageContext.request.contextPath}/userInfo">
    Информация о пользователе
</a>
||
<a href="${pageContext.request.contextPath}/start">
    Вход
</a>
||
<a href="${pageContext.request.contextPath}/userListUsers">
    Список пользователей (Пользователь)
</a>
||
<a href="${pageContext.request.contextPath}/adminListUsers">
    Список пользователей (Админ)
</a>
||
<a href="${pageContext.request.contextPath}/logout">
    Выход
</a>
