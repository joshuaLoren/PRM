<%--
    Document   : header
    Created on : Feb 17, 2019, 5:14:14 PM
    Author     : small
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="banner">
    <img id="logo" src="images/logo.jpg" alt="banner logo">

    <c:if test = "${(sessionScope.loggedIn == null)}">
        <p id="userStatus">Signed out</p>
    </c:if>
    <c:if test = "${sessionScope.loggedIn == true}">
        <p id="userStatus">Hello, ${user.firstName}</p>
    </c:if>

  

</header>
