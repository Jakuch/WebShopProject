<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-17
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Footer</title>
</head>
<body>
<div style="display: inline-block; bottom: 0; width: 100%">
    <%DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:MM:SS");%>
    <p style="font-size: 10px; color: darkgrey"><%=dateTimeFormatter.format(LocalDateTime.now())%> Created by Jakuch</p>
</div>
</body>
</html>
