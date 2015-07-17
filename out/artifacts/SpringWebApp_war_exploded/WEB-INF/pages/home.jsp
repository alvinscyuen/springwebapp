<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 15/6/17
  Time: 下午3:06
  To change this template use File | Settings | File Templates.
--%>
<%--JSTL TAG LIB--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Spring MVC PERSON EXAMPLE</title>
</head>
<body>
<h1> Welcome to MVC Person Example Homepage</h1>

Retrieving People:
<%= request.getAttribute("peopleArray")%>

<br/>

<c:forEach items="${peopleArray}" var="person">
  <p> Person: <c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></p>
</c:forEach>

</body>
</html>
