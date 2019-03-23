<%--
    Document   : aside.jsp
    Created on : Feb 20, 2019, 8:46:54 PM
    Author     : small
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside>
    <ul id="left-side">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="categories">Categories</a></li>

        <c:if test = "${(sessionScope.loggedIn == null)}">
            <li class="navRight"><a href="myitems.jsp">My Papers</a></li>
            </c:if>
            <c:if test = "${sessionScope.loggedIn == true}">
            <li class="navRight"><a href="myitems">My Papers</a></li>
            </c:if>

        <li><a href="contact.jsp">Contact</a></li>
        <li><a href="about.jsp">About</a></li>
    </ul>
</aside>
