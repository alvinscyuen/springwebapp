<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 15/6/12
  Time: 下午2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p> Thank You For Purchasing </p>

<p> Total Quantity: <%=request.getAttribute("TotalQuantity")%></p>
<p> Total Price: $<%=request.getAttribute("TotalPrice")%></p>

</body>
</html>
