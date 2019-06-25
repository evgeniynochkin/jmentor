<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 25.06.2019
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<br>
    <h1>Авторизируйтесь:</h1>
    <form action="Users" method="post">
        Логин: <input type="text" name="login" size="10"><br>
        Пароль: <input type="password" name="password" size="10"><br>
        <p>
        <table>
            <tr>
                <th><small>
                    <input type="submite" name="login" value="Войти">
                </small>
                <th><small>
                    <input type="submite" name="registration" value="Зарегистрироваться">
                </small>
        </table>
    </form>
</br>
</body>
</html>
