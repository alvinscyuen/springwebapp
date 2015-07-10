<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 15/6/23
  Time: 下午4:05
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html ; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>User Input Form (JSP Format)</title>
</head>
<body>

<h1>User Input - Using JSP Form </h1>

<form:form action="/api/jspformsubmit" method="POST" modelAttribute="person">

  <label for="firstNameInput">First Name:</label>
  <form:input path="firstName" id="firstNameInput"/>
  <form:errors path="firstName" cssclass="error"></form:errors><br/>

  <label for="lastNameInput">Last Name:</label>
  <form:input path="lastName"/>
  <form:errors path="lastName" cssclass="error"></form:errors><br/>

  <label for="emailInput"> Email:</label>
  <form:input path="email"/>
  <form:errors path="email" cssclass="error"></form:errors><br/>

  <label for="commentsInput"> Comments: </label>
  <form:input path="comments"/>
  <form:errors path="comments" cssclass="error"></form:errors><br/>

  <input type="submit" value="Submit"/>
</form:form>

  <hr/>

  <h2> Submitted Information</h2>
  <table>
    <tr>
    <td> Name </td>
    <td>${firstname}</td>
    </tr>
    <tr><td> Last Name </td> <td> ${lastname}</td></tr>
    <tr><td> Email </td> <td> ${email}</td></tr>
    <tr><td> Comments </td> <td> ${comments}</td></tr>
  </table>

</body>
</html>
