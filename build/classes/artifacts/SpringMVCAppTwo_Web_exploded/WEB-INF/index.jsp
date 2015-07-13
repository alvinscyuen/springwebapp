<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 15/6/16
  Time: 下午1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index page</title>
</head>
<body>
<h1> Test </h1>
<a href ="${pageContext.request.contextPath}/hi">Hello Controller</a> <br/>
<a href ="${pageContext.request.contextPath}/string"> String Comparator</a> <br/>
<a href ="${pageContext.request.contextPath}/api/form">User Input Form </a> <br/>
<a href ="${pageContext.request.contextPath}/api/jspform">User Input Form (JSP)</a> <br/>
<a href ="${pageContext.request.contextPath}/api/getall"> Get List of Person Objects</a> <br/>
<a href ="${pageContext.request.contextPath}/api/display"> Display Request Header </a> <br/>

<hr/>


<h1> return json</h1>
<a href ="${pageContext.request.contextPath}api/person/random"> display random Person Object</a> <br/>

<hr/>

<h1> BookShop </h1>
<a href ="${pageContext.request.contextPath}/shopOrder"> E-BookShop </a> <br/>

<hr/>

<h1> Form Validation </h1>
<a href ="${pageContext.request.contextPath}/subscriberForm"> Subscriber Form Test Validation</a> <br/>

<hr/>

<h1> File Upload </h1>
<a href="${pageContext.request.contextPath}/showUploadForm"> Test Form Upload </a>

<hr/>
<h1> JavaScript Test</h1>
<a href="${pageContext.request.contextPath}/showFormOne">Test Ajax</a>

<hr/>

<h1> Shopping Cart JavaScript</h1>
<a href="${pageContext.request.contextPath}/showShoppingCartJS"> Shopping Cart JS </a>


<hr/>
<h1> Database Test</h1>
<a href="${pageContext.request.contextPath}/jdbcTest"> JDBC Test</a>


</body>
</html>
