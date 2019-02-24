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
<p>Product name: <%=product.getName()%></p>
<p>Product name: <%=product.getPrice()%></p>
<p>Product name: <%=product.getDescription()%></p>
<p>Product name: <%=product.getCategory()%></p>
<p>Product name: <%=product.getQuantity()%></p>

<jsp:include page="footer.jsp">
    <jsp:param name="pageFooter" value=""/>
</jsp:include>
</body>
</html>
