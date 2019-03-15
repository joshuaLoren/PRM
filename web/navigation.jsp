<%--
    Document   : navigation
    Created on : Feb 17, 2019, 5:14:37 PM
    Author     : small
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul>
        <li class="navRight"><a href="myitems">My Papers</a></li>

        <c:if test = "${(sessionScope.loggedIn == null)}">
            <li class="navRight"><a href="signin">Sign in</a></li>
            </c:if>
            <c:if test = "${sessionScope.loggedIn == true}">
            <li class="navRight"><a href="signin?action=signout">Sign out</a></li>
            </c:if>


        <li class="navLeft"><a href="categories">Categories</a></li>
        <li class="navLeft"><a href="index.jsp">Home</a></li>
        <li class="navLeft"><a href="contact.jsp">Contact</a></li>
        <li class="navLeft"><a href="about.jsp">About</a></li>
    </ul>

    <select>
        <option value="" selected="selected">Menu</option>
        <option value="/index.jsp">Home</option>
        <option value="/myitems">My Papers</option>
        <option value="/contact.jsp">Contact</option>
        <option value="/about.jsp">About Us</option>
    </select>
</nav>