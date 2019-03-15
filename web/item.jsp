<%--
    Document   : item
    Created on : Feb 17, 2019, 1:03:04 PM
    Author     : small
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/styles.css">
        <link rel="stylesheet" type="text/css" href="styles/mobile.css">
        <title>Item Details</title>
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
            <main class="paper">
                <!--
                        item will be dynamically generated

                        db columns:

                        - Picture
                        - Title
                        - Article
                        - Peer Reviews
                -->
                <article>
                    <!-- image courtesy of https://www.pexels.com/collections/stationery-qsocrh9/ -->
                    <header>
                        <!--<img id="articleImage" src="images/default.jpeg" alt="the default image">-->
                        <img id="articleImage" src="images/${essay.getUrl()}" alt=" image">
                        <h2>${essay.itemName}</h2>
                    </header>
                    <p class="paragraph">
                        ${essay.itemDescription}
                    </p>
                    <footer>
                        <a href="feedback.jsp" class="update button">Peer Review This Essay</a>
                        <a href="myitems.jsp" class="update button">Save It (Peer Review Later)</a>
                        <a href="categories" class="update button">Return</a>
                    </footer>
                </article>
            </main>
            <div class="push"></div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
