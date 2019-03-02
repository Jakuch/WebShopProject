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
    <jsp:param name="pageHeader" value=""/>
</jsp:include>
<%
    Product product = (Product) request.getAttribute("Product");
%>
<c:choose>
    <c:when test="product != null">
        <p>Product name: <%=product.getName()%>
        </p>
        <p>Product price: <%=product.getPrice()%>
        </p>
        <p>Product description: <%=product.getDescription()%>
        </p>
        <p>Product category: <%=product.getCategory()%>
        </p>
        <p>Product quantity: <%=product.getQuantity()%>
        </p>
        <img src="<%=product.getImageUrl()%>"/>
        <div>
            <jsp:include page="addToCart.jsp">
                <jsp:param name="id" value="${product.id}"/>
            </jsp:include>
        </div>
    </c:when>
    <c:otherwise>
        <p>Product name: ${product.name}
        </p>
        <p>Product price: ${product.price}
        </p>
        <p>Product description: ${product.description}
        </p>
        <p>Product category: ${product.category}
        </p>
        <p>Product quantity: ${product.quantity}
        </p>
        <div>
            <jsp:include page="addToCart.jsp">
                <jsp:param name="id" value="${product.id}"/>
            </jsp:include>
        </div>
    </c:otherwise>
</c:choose>

<jsp:include page="footer.jsp">
    <jsp:param name="pageFooter" value=""/>
</jsp:include>
</body>
</html>
