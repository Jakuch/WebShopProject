<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-17
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="pageHeader" value=""/>
</jsp:include>
<h1 style="text-align: center">Login Page</h1>
<div style="border: solid blue; display: block; position: center; text-align: center; padding: 5px 5px 5px 5px; margin-bottom: 15px">
    <form action="${pageContext.request.contextPath}/Login" method="post">
        <label>
            Login:<br>
            <input type="text" name="login">
        </label><br>
        <label>
            Password:<br>
            <input type="password" name="password">
        </label><br>
        <input style="margin-top: 5px" type="submit" name="submit" value="Login"><br>
    </form>
</div>
<%
    Object error = request.getAttribute("error");
    if (error != null) {
%>
<p style="color: red; text-align: center; font-size: 40px"><b><%=error%></b></p>
<% } %>
<jsp:include page="footer.jsp">
    <jsp:param name="pageFooter" value=""/>
</jsp:include>
</body>
</html>
