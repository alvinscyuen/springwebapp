
<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 15/6/11
  Time: 下午5:08
  To change this template use File | Settings | File Templates.
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.springapp.mvc.Shop.Model.BooksDB" %>
<%@ page import="java.util.List" %>
<%@ page import="com.springapp.mvc.Shop.Model.ShoppingCart" %>

<%@ page contentType="text/html ; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order JSP</title>
</head>


<h2> E-BookShop</h2>

<p><strong> choose a book and enter the quantity:</strong></p>

<form name="AddForm" action="/shoppingCart/add" method="post">
    <input type="hidden" name="myCookie" value="<%=ShoppingCart.getOrderNumber()%>"/>
    <input type="hidden" name="todo" value="Add"/>

    Select Book:<select name="bookID" style="margin: 5px;">

    <br/>

    <%--using JSTL core--%>
    <c:forEach var="i" begin="0" end="${BooksDB.size()-1}" step="1" >
     <option value="${i}"> ${BooksDB.getTitle(i)} | ${BooksDB.getAuthor(i)} | ${BooksDB.getPrice(i)} </option>
        </c:forEach>

    <%--traditional way--%>
    <%--<% for (int i = 0; i < BooksDB.size(); i++) {--%>
        <%--out.println("<option value= " + i + ">");--%>
        <%--out.println(BooksDB.getTitle(i) + " | " + BooksDB.getAuthor(i) + " | $" + BooksDB.getPrice(i));--%>
        <%--out.println("</option>");--%>
    <%--} %>--%>
</select>
    <br/>

    Enter Quantity: <input type="text" name="orderQuantity" size="10" value="1" style="margin: 5px;">
    <br/>

    <input type="submit" value="Add to Shopping Cart" style="margin: 5px;">

</form>
<br/>
    <a href ="${pageContext.request.contextPath}/shoppingCart/showcart"> Display Session Cart (Json format) </a><br/>
<hr/>
<br/>

    <%--get session cart--%>
    <%List<ShoppingCart> sessionCart = (List<ShoppingCart>) session.getAttribute("cart");%>

    <%--//scriptlet 2: only process table when session cart is not empty--%>
    <%if (sessionCart != null && sessionCart.size() > 0) {
%>
<p><strong> Your shopping cart contains: </strong></p>

    <c:out value="Before for Loop"/>
        <c:forEach var="cart" items="${sessionCart}">
            <c:out value="Inside For Loop"/>
            <c:set var="title" value="${cart.getTitle}"/>
            <c:out value="${title}"/>
        </c:forEach>

<table border="1" cellspacing="0" cellpadding="5">
    <tr>

        <th>Book Title</th>
        <th>Author</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total Price</th>
        <th>Remove</th>
        <th>&nbsp;</th>
    </tr>


    <%
        for (ShoppingCart cart : sessionCart) {
            String title = cart.getTitle();
            String author = cart.getAuthor();
            float price = cart.getPrice();
            int quantity = cart.getOrderQuantity();
            float totalPrice = cart.getTotalPrice();
            int bookID = cart.getBookID();
    %>
    <tr>
        <form action="/shoppingCart/remove" method="post">
            <input type="hidden" name="cartIndex" value="<%=bookID%>">
            <input type="hidden" name="todo" value="Remove">

            <%--<td height="200" width="200"><% switch(bookID) {--%>
                    <%--case(0):  {%> <img src="java.jpeg" width="160" height="160">--%>
                <%--<%break;} case(1):  {%>  <img src="java.jpeg" width="160" height="160">--%>
                <%--<%break;} case(2):  {%>  <img src="java.jpeg" width="160" height="160">--%>
                <%--<%break;} case(3):  {%>  <img src="java.jpeg" width="160" height="160">--%>
                <%--<%break;} case(4):  {%>  <img src="android.png" width="82" height="76">--%>
                <%--<%break;} case(5):  {%>  <img src="android.png" width="82" height="76">--%>

               <%--<%break;}} %>--%>
            <%--</td>--%>

            <td><%=title%>
            </td>
            <td><%=author%>
            </td>
            <td align="right">$<%=price%>
            </td>
            <td align="right"><%=quantity%>
            </td>
            <td align="right">$<%=totalPrice%>
            </td>
            <td><select name="quantityRemove">


                <% for (int i = 0; i <= quantity; i++) {
                    out.println("<option value=" + i + ">" + i + "</option>");
                } %>
            </select></td>
            <td>
                <input type="submit" value="Remove from CART">
            </td>
        </form>
    </tr>
    <% } %>

</table>
<form name="checkout" action="/shoppingCart/checkout" method="post">
    <input type="hidden" name="todo" value="Checkout">
    <input type="submit" value="CheckOut" style="margin: 5px;">
</form>
<%}%>



</body>
</html>
