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
    <title>Product View</title>
</head>
<body>
<c:forEach items="${products}" var="product">
    <div style="border: solid; margin-bottom: 10px; padding: 5px 5px 5px 5px;">
        <p>Product name: ${product.name}</p>
        <p>Product Price: ${product.price}</p>
        <p>Product Description: ${product.description}</p>
        <p>Product Category: ${product.category}</p>
        <p>Product Quantity: ${product.quantity}</p>
        <div>
            <jsp:include page="addToCart.jsp">
                <jsp:param name="id" value="${product.id}"/>
            </jsp:include>
        </div>
    </div>
</c:forEach>
</body>
</html>
