<%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-23
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add To Cart</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AddToCart" method="post">
    <p>
        <input type="hidden" name="id" value="${param.id}"/>
    </p>
    <p>
        <input type="hidden" name="quantity" value="1"/>
    </p>
    <p>
        <input type="submit" name="submit" value="Add to Cart"/>
    </p>
</form>
</body>
</html>
