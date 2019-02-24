<%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-17
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Add Products</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="pageHeader" value=""/>
</jsp:include>
<h2 style="text-align: center; border: solid blue">Add product</h2>
<form action="${pageContext.request.contextPath}/AddProduct" method="post">
    Product name:<br>
    <label>
        <input type="text" name="name">
    </label><br>
    Product description:<br>
    <label>
        <textarea name="description"></textarea>
    </label><br>
    Product price:<br>
    <label>
        <input type="text" name="price">
    </label><br>
    Product category:<br>
    <label>
        <input type="text" name="category">
    </label><br>
    Quantity:<br>
    <label>
        <input type="text" name="quantity">
    </label><br>
    <label style="margin-top: 5px">
            <input type="submit" name="submit" value="Add product">
            <input type="reset" name="reset" value="Reset">
    </label>
</form>
<jsp:include page="footer.jsp">
    <jsp:param name="pageFooter" value=""/>
</jsp:include>
</body>
</html>
