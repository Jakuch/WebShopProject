<%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-23
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Last Viewed</title>
</head>
<body>
<h4 style="text-align: center; border: solid green">Last seen products:</h4>
<div style="position: relative; right: 0; border: solid; padding: 5px 5px 5px 5px">
    <p>Name: ${lastViewed.name}</p>
    <p>Price: ${lastViewed.price}</p>
    <p>Category: ${lastViewed.category}</p>
    <p>Quantity: ${lastViewed.quantity}</p>
</div>
</body>
</html>
