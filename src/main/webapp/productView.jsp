<%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-24
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product View</title>
</head>
<body>
<p>Product name: ${param.name}
</p>
<p>Product price: ${param.price}
</p>
<p>Product description: ${param.description}
</p>
<p>Product category: ${param.category}
</p>
<p>Product quantity: ${param.quantity}
</p>
<p>
    <img src="${param.imageUrl}" alt="Nope"/>
</p>
<div>
    <jsp:include page="addToCart.jsp">
        <jsp:param name="id" value="${param.id}"/>
    </jsp:include>
</div>
</body>
</html>
