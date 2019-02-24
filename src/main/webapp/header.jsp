<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-17
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<p style="display: inline-block; top: 0; width: 100%; margin-bottom: 5px">
    <a style="border-style: outset; padding: 2px 2px 2px 2px" href="${pageContext.request.contextPath}/HomePage">Home Page</a>
    <a style="border-style: outset; padding: 2px 2px 2px 2px" href="${pageContext.request.contextPath}/AddProduct">Add product</a>
    <a style="border-style: outset; padding: 2px 2px 2px 2px" href="${pageContext.request.contextPath}/Search">Search product</a>
    <a style="border-style: outset; padding: 2px 2px 2px 2px" href="${pageContext.request.contextPath}/Cart">Cart</a>
    <a style="border-style: outset; padding: 2px 2px 2px 2px" href="${pageContext.request.contextPath}/Register">Sign up</a>
</p>
<p style="margin-top: 10px">
<c:choose>
    <c:when test="${user != null}">
        <p>
            <a style="border-style: outset; padding: 2px 2px 2px 2px; margin-right: 5px"
               href="${pageContext.request.contextPath}/Logout">Logout</a> Logged as: ${user.userName}
        </p>
    </c:when>
    <c:otherwise>
        <a style="border-style: outset; padding: 2px 2px 2px 2px"
           href="${pageContext.request.contextPath}/Login">Login</a>
    </c:otherwise>
</c:choose>
<h1 style="text-align: center; border: solid crimson">Web Shop</h1>
</p>
</body>
</html>
