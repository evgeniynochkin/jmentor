<%--
  Created by IntelliJ IDEA.
  User: nochj
  Date: 02.11.2019
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">

<head>
  <title>Authorization</title>
</head>

<body>
<center>
  <h1>Пользователи JSP</h1>
  <h2>
    <a href="/springtask_war/insert">Новый пользователь</a>
  </h2>
    <!--/*@thymesVar id="message" type="java.lang.String"*/-->
    <p th:text="${message}">Mes</p>
</center>
<div aling="center">
  <table border="1" cellpadding="5">
    <caption><h2>Список пользователей</h2></caption>
    <tr>
      <th>ID</th>
      <th>Login</th>
      <th>Name</th>
    </tr>
    <tr th:each = "user : ${usersList}">
        <td th:text="${user.id}">ID</td>
        <td th:text="${user.login}">Login</td>
        <td th:text="${user.name}">Name</td>
        <td>
          <a href="/springtask_war/edit?id=${user.id}">Редактировать</a>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <a href="/springtask_war/delete?id=${user.id}">Удалить</a>
        </td>
    </tr>
  </table>
</div>
</body>
</html>
