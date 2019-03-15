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
                <section>
                    <h3>Contact Us</h3>
                    <img class="aboutandcontactimages" src="images/contact.jpg" alt="contact image" height="400" width="500">
                    <p class="homeParagraph">Joshua Small: jsmall17@uncc.edu</p>
                </section>


            </main>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
