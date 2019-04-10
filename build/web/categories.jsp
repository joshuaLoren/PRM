<%--
    Document   : categories
    Created on : Feb 17, 2019, 1:02:21 PM
    Author     : small
--%>

<%@page import="Models.Item"%>
<%@page import="Data.ItemDB"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" import="java.util.*"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/styles.css">
        <link rel="stylesheet" type="text/css" href="styles/mobile.css">
        <title>Categories</title>
        <!--[if lt IE 9]>
                <script>
                        document.createElement("article");
                        document.createElement("aside");
                        document.createElement("footer");
                        document.createElement("header");
                        document.createElement("main");
                        document.createElement("nav");
                        document.createElement("section");
                </script>
                <![endif] -->
        <!-- Source: https://www.youtube.com/watch?time_continue=1&v=NR4arpSA2jI -->
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <jsp:include page="navigation.jsp"/>
        <div class="container">
            <jsp:include page="aside.jsp"/>
            <main class="itempage">
                <section class="card">
                    <h3>Narrative Essays</h3>
                </section>

                <div class="card-white">
                    <ul>
                        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                        <!--
                            Note to self the hidden field should appear here. With a form that
                            has a hidden field with name="itemList" that way you can check to see
                            if an item exists in the catalog before saving it
                        -->
                        <c:forEach items="${database.getNarrative()}" var="essay">
                            <li><a href="categories?itemCode=${essay.itemCode}"><c:out value="${essay.itemName}"/></a></li>
                        </c:forEach>
                    </ul>
                </div>

                <section class="card">
                    <h3>Persuasive Essays</h3>
                </section>

                <div class="card-white">
                    <ul>
                        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                        <c:forEach items="${database.getPersuasive()}" var="essay">
                            <li><a href="categories?itemCode=${essay.itemCode}"><c:out value="${essay.itemName}"/></a></li>
                            </c:forEach>
                    </ul>
                </div>

                <section class="card">
                    <h3>Expository Essays</h3>
                </section>

                <div class="card-white">
                    <ul>
                        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                        <c:forEach items="${database.getExpository()}" var="essay">
                            <li><a href="categories?itemCode=${essay.itemCode}"><c:out value="${essay.itemName}"/></a>
                            </c:forEach>
                    </ul>
                </div>
            </main>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
