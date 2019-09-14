<%--
  Created by IntelliJ IDEA.
  User: nochj
  Date: 02.09.2019
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Error</title>
</head>
<body>
<center>
    <h1>Error</h1>
    <c:if test="${uds != null}">
        <form action="${pageContext.servletContext.contextPath}/useraction/insert" method="POST">

            </c:if>
</center>
</body>
</html>
