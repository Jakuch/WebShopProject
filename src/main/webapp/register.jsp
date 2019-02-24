<%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-24
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register user</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="" value=""/>
</jsp:include>
<h2 style="text-align: center; border: solid green">Sign up</h2>
<div>
    <form method="post" action="${pageContext.request.contextPath}/Register">
        User name:<br>
        <input type="text" name="userName"/><br>
        User email:<br>
        <input type="email" name="userMail"/><br>
        User password:<br>
        <input type="password" name="userPassword"/><br>
        Confirm password:<br>
        <input type="password" name="userPassConfirm"/><br>
        <input style="margin-top: 15px" type="submit" name="submit" value="Sign up!">
    </form>
</div>
<%
    Object error = request.getAttribute("error");
    if (error != null) {
%>
<div style="color: red; text-align: center; font-size: 64px"><b><%=error%></b></div>
<% } %>
<jsp:include page="footer.jsp">
    <jsp:param name="" value=""/>
</jsp:include>
</body>
</html>
