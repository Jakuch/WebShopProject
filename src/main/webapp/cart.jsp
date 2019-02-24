<%@ page import="pl.sdacademy.model.Product" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-23
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="pageHeader" value=""/>
</jsp:include>
<h2 style="text-align: center; border: solid midnightblue">Cart</h2>
<%
    Map<Product, Integer> map = ((Map<Product, Integer>) session.getAttribute("cart"));
    long value = 0;
%>

<%
    if (map == null) {
%>
<p>Cart is empty</p>
<%
} else {
    for (Map.Entry entry : map.entrySet()) {
        value = value + ((Product) entry.getKey()).getPrice() * Long.valueOf((Integer)entry.getValue());
%>
<div style="border: solid; margin-bottom: 10px; padding: 5px 5px 5px 5px;">
    <a href="${pageContext.request.contextPath}/Product?id=<%=((Product)entry.getKey()).getId()%>"></a>
    <p>Product name: <%=((Product) entry.getKey()).getName()%>
    </p>
    <p>Product price: <%=((Product) entry.getKey()).getPrice()%>
    </p>
    <p>Quantity: <%=entry.getValue()%>
    </p>
</div>
<%
        }
    }
%>
<p style="border: solid; padding: 2px 2px 2px 2px">Cart value: <%=value%>
</p>
<jsp:include page="footer.jsp">
    <jsp:param name="pageFooter" value=""/>
</jsp:include>
</body>
</html>
