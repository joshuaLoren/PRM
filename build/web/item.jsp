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
            <aside>
                <ul id="left-side">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="categories.jsp">Categories</a></li>
                    <li><a href="myitems.jsp">My Papers</a></li>
                    <!--<li><a href="essaynew.html">New Paper</a></li>-->
                    <li><a href="https://cloud.ibm.com/apidocs">Watson API</a></li>
                </ul>
            </aside>
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
                        <img id="articleImage" src="images/default.jpeg" alt="the default image">
                        <h2>Once More To The Lake</h2>
                        <h3>By E.B. White </h3>
                    </header>
                    <p class="paragraph">
                        I looked at the boy, who was silently watching his fly, and it was my hands that held his rod, my eyes watching. I felt dizzy and didn't know which rod I was at the end of.
                        He suddenly realizes how death is so close, because he is now the father and not the son. White references this in the final lines:
                        I watched him, his hard little body, skinny and bare, saw him wince slightly as he pulled up around his vitals the small, soggy, icy garment.
                        As he buckled the swollen belt suddenly my groin felt the chill of death.
                        <br>
                        <br>
                        I looked at the boy, who was silently watching his fly, and it was my hands that held his rod, my eyes watching. I felt dizzy and didn't know which rod I was at the end of.
                        He suddenly realizes how death is so close, because he is now the father and not the son. White references this in the final lines:
                        I watched him, his hard little body, skinny and bare, saw him wince slightly as he pulled up around his vitals the small, soggy, icy garment.
                        As he buckled the swollen belt suddenly my groin felt the chill of death.
                        I looked at the boy, who was silently watching his fly, and it was my hands that held his rod, my eyes watching. I felt dizzy and didn't know which rod I was at the end of.
                        He suddenly realizes how death is so close, because he is now the father and not the son. White references this in the final lines:
                        I watched him, his hard little body, skinny and bare, saw him wince slightly as he pulled up around his vitals the small, soggy, icy garment.
                        As he buckled the swollen belt suddenly my groin felt the chill of death.
                        <br>
                        <br>
                        I looked at the boy, who was silently watching his fly, and it was my hands that held his rod, my eyes watching. I felt dizzy and didn't know which rod I was at the end of.
                        He suddenly realizes how death is so close, because he is now the father and not the son. White references this in the final lines:
                        I watched him, his hard little body, skinny and bare, saw him wince slightly as he pulled up around his vitals the small, soggy, icy garment.
                        As he buckled the swollen belt suddenly my groin felt the chill of death.
                    </p>
                    <footer>
                        <a href="feedback.jsp" class="update button">Peer Review This Essay</a>
                        <a href="myitems.jsp" class="update button">Save It (Peer Review Later)</a>
                        <a href="categoryhome.jsp" class="update button">Return</a>
                    </footer>
                </article>
            </main>
            <div class="push"></div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
