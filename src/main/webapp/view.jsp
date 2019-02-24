<%@ page import="pl.sdacademy.database.ProductDatabase" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-23
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Shop View</title>
</head>
<body>
<h2 style="text-align: center; border: solid green">Products</h2><br>
<jsp:include page="productView.jsp">
    <jsp:param name="products" value="products"/>
</jsp:include>
<jsp:include page="lastViewed.jsp">
    <jsp:param name="lastViewed" value="lastViewed"/>
</jsp:include>
</body>
</html>
