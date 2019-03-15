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
                    <img class="aboutandcontactimages" src="images/aboutus.jpeg" alt="about us image" height="350" width="400">
                    <p class="homeParagraph">Peer review breaks essays into three categories: Narrative, Persuasive and Expository.
                        <a href="signup.html" class="disabled">Sign up</a> to create an account and start publishing your own papers,
                        or providing feedback on other member's papers by writing a peer review. During the process of
                        writing your own paper, you'll have the option to run your paper through the IBM Watson Tone
                        Analyzer, which will allow you to perfect the tone you want your essay to have.
                    </p>
                </section>


            </main>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
