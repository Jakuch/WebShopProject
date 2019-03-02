<%@ page import="pl.sdacademy.model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-23
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage View</title>
</head>
<body>
<h2 style="text-align: center; border: solid green">Products</h2><br>
<c:forEach items="${products}" var="product">
    <a style="color: black" href="${pageContext.request.contextPath}/Product?id=${product.id}">
        <div style="border: solid; margin-bottom: 10px; padding: 5px 5px 5px 5px;">
                <jsp:include page="productView.jsp">
                    <jsp:param name="id" value="${product.id}"/>
                    <jsp:param name="name" value="${product.name}"/>
                    <jsp:param name="price" value="${product.price}"/>
                    <jsp:param name="description" value="${product.description}"/>
                    <jsp:param name="category" value="${product.category}"/>
                    <jsp:param name="quantity" value="${product.quantity}"/>
                </jsp:include>
        </div>
    </a>
</c:forEach>
<jsp:include page="lastViewed.jsp">
    <jsp:param name="lastViewed" value="lastViewed"/>
</jsp:include>
</body>
</html>
