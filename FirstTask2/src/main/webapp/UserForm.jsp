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
            <form action="update" method="POST">

        </c:if>
        <c:if test="${uds == null}">
            <form action="${pageContext.servletContext.contextPath}/useraction/insert" method="POST">
                <table>
                    <tr>
                        <td align="rigth" >Login : </td>
                        <td>
                            <input type="text" name="login">
                        </td>
                    </tr>
                    <tr>
                        <td aling="rigth" >Password : </td>
                        <td>
                            <input type="text" name="password">
                        </td>
                    </tr>
                    <tr>
                        <td align="rigth" >Name : </td>
                        <td>
                            <input type="text" name="name">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" aling="center" value="Save"/>
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>

                <%--
        <c:forEach items="${users}" var="user">
            <h3>${user.userName}</h3>
        </c:forEach>

                <%--
        <table border="1" cellpadding="4">
            <caption>
                <h2>
                    <c:if test="${uds != null}">
                        Edit User
                    </c:if>
                    <c:if test="${uds == null}">
                        Add New User
                    </c:if>
                </h2>
            </caption>
                <c:if test="${uds != null}">
                    <input type="hidden" name="id" value="<c:out value='${uds.id}' />" />
                </c:if>
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
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45" value="<c:out value='${uds.name}' />" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
                --%>
            </form>
    </div>
</body>
</html>
