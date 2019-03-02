<%@ page import="pl.sdacademy.model.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="pl.sdacademy.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-03-02
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<h2 style="text-align: center">Product ordered!</h2>
<%
    Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
    Long value = 0L;
    for (Map.Entry entry : cart.entrySet()) {
        value += ((Product)entry.getKey()).getPrice();
    }
%>
<p>Order value: <%=value%>
</p>
<% User user = (User)session.getAttribute("user");
    if (user != null) {
%>
<p>Order ID: <%=request.getParameter("id")%></p>
<p>User: <%=user.getUserName()%></p>
<p>Address: <%=session.getAttribute("address")%></p>
<%} else {%>
<p>Order ID: <%=request.getAttribute("orderID")%></p>
<p>Email: <%=request.getAttribute("userMail")%></p>
<p>Address: <%=request.getAttribute("address")%></p>
<%}%>
<jsp:include page="footer.jsp">
    <jsp:param name="" value=""/>
</jsp:include>
</body>
</html>
