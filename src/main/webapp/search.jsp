<%--
  Created by IntelliJ IDEA.
  User: Kuba
  Date: 2019-02-23
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="pageHeader" value=""/>
</jsp:include>
<h2 style="text-align: center; border: solid yellow">Search</h2>
<p>Search by:<br>
<form method="post" action="${pageContext.request.contextPath}/Search">
    <select name="searchOption">
        <option value="name">Name</option>
        <option value="price">Price</option>
        <option value="category">Category</option>
    </select>
    <input type="text" name="searchPhrase" style="margin-bottom: 15px"><br>
    <input type="submit" name="submit" value="Submit" style="width: 80px; height: 30px">
</form>
</p>
<jsp:include page="footer.jsp">
    <jsp:param name="pageFooter" value=""/>
</jsp:include>
</body>
</html>
