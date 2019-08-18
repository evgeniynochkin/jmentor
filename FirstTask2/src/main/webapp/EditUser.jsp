<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 07.07.2019
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Manager</title>
</head>
<body>
    <center>
        <h1>User Manager</h1>
        <h2>
            <a herf="${pageContext.servletContext.contextPath}/new">Add New User</a>
            &nbsp;&nbsp;&nbsp;
            <a herf="${pageContext.servletContext.contextPath}/hello">List All Users</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${uds != null}">
            <form action="${pageContext.servletContext.contextPath}/useraction/edit" method="POST">
                <table>
                    <input type="hidden" name="id" value="<c:out value='${uds.id}' />" />
                    <tr>
                        <td align="rigth" >Login : </td>
                        <td>
                            <input type="text" name="login" value="<c:out value='${uds.login}' />" />
                        </td>
                    </tr>
                    <tr>
                        <td aling="rigth" >Password : </td>
                        <td>
                            <input type="text" name="password" value="<c:out value='${uds.password}' />" />
                        </td>
                    </tr>
                    <tr>
                        <td align="rigth" >Name : </td>
                        <td>
                            <input type="text" name="name" value="<c:out value='${uds.name}' />" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" aling="center" value="Save"/>
                        </td>
                    </tr>
                </table>
        </c:if>

    </div>
</body>
</html>
