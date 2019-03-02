<%@ page import="pl.sdacademy.model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-17
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="" value=""/>
</jsp:include>
<jsp:include page="productView.jsp">
    <jsp:param name="name" value="${name}"/>
    <jsp:param name="price" value="${price}"/>
    <jsp:param name="description" value="${description}"/>
    <jsp:param name="category" value="${category}"/>
    <jsp:param name="quantity" value="${quantity}"/>
</jsp:include>
<jsp:include page="footer.jsp">
    <jsp:param name="" value=""/>
</jsp:include>
</body>
</html>
