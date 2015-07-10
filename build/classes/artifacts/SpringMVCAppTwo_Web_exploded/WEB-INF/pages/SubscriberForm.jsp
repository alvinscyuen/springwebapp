<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 15/6/24
  Time: 下午1:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html ; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Sample Form</title>
  </head>
  <body>

	<div id="container">

		<h2>Subscribe to The Newsletter!</h2>


		<form:form action="/subscriberFormSubmit" modelAttribute="subscriber">

          <form:errors path="*" cssClass="errorblock" element="div"/>

			<label for="nameInput">Name: </label>
			<form:input path="name" id="nameInput" />
			<form:errors path="name" cssClass="error" />
			<br/>
			<br/>

			<label for="ageInput">Age: </label>
			<form:input path="age" id="ageInput" />
			<form:errors path="age" cssClass="error" />
			<br/>
			<br/>

			<label for="phoneInput">Phone: </label>
			<form:input path="phone" id="phoneInput" />
			<form:errors path="phone" cssClass="error" />
			<br/>
			<br/>

			<label for="emailInput">Email: </label>
			<form:input path="email" id="emailInput" />
			<form:errors path="email" cssClass="error" />
			<br/>
			<br/>

			<label for="birthdayInput">Birthday: </label>
			<form:input path="birthday" id="birthdayInput" placeholder="MM/DD/YYYY" />
			<form:errors path="birthday" cssClass="error" />
			<br/>
			<br/>

			<label for="genderOptions">Gender: </label>
			<form:select path="gender" id="genderOptions">
				<form:option value="">Select Gender</form:option>
				<form:option value="MALE">Male</form:option>
				<form:option value="FEMALE">Female</form:option>
			</form:select>
			<form:errors path="gender" cssClass="error" />
			<br/>
			<br/>

			<label for="newsletterCheckbox">Newsletter? </label>
			<form:checkbox path="receiveNewsletter" id="newsletterCheckbox" />
			<form:errors path="receiveNewsletter" cssClass="error" />
			<br/>
			<br/>


			<br/>
			<input type="submit" value="Submit" />
		</form:form>
	</div>

  <div>
    <h2> Submitted Information </h2>

    Information Submitted <p>${message}</p>
    <table>
      <tr>
      <td> Name </td><td>${name}</td></tr>
      <tr><td> age </td> <td> ${lastname}</td></tr>
      <tr><td> phone </td> <td> ${email}</td></tr>
      <tr><td> email </td> <td> ${comments}</td></tr>
      <tr><td> birthday</td> <td> ${birthday}</td></tr>
      <tr><td> gender</td> <td> ${gender}</td></tr>
      <tr><td> Newsletter</td> <td> ${receiveNewsletter}</td></tr>
    </table>


  </div>




  </body>
</html>