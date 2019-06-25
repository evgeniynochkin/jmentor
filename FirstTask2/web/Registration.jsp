<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 25.06.2019
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Регистрация:</h1>
<form action="AddUser" method="post">
    Логин: <input type="text" name="login" size="10"><br>
    Пароль: <input type="password" name="password" size="10"><br>
    Имя: <input type="text" name="name" size="10"><br>
    <p>
    <table>
        <tr>
        <th><small>
            <input type="submit" name="save" value="Сохранить">
        </small>
        <th><small>
            <input type="submit" name="cancel" value="Выйти">
        </small>
    </table>
</form>
</body>
</html>
