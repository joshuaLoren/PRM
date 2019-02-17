<%--
    Document   : index.jsp
    Created on : Feb 17, 2019, 12:55:19 PM
    Author     : small
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/styles.css">
        <link rel="stylesheet" type="text/css" href="styles/mobile.css">
        <title>Home</title>
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
            <main>
                <section class="home">
                    <h1>PeerReviewMe is a place to get feedback from your peers on your writing.</h1>
                    <p class="homeParagraph">Peer review breaks essays into three categories: Narrative, Persuasive and Expository.
                        <a href="signup.html" class="disabled">Sign up</a> to create an account and start publishing your own papers,
                        or providing feedback on other member's papers by writing a peer review. During the process of
                        writing your own paper, you'll have the option to run your paper through the IBM Watson Tone
                        Analyzer, which will allow you to perfect the tone you want your essay to have.
                    </p>
                    <section class="homeIcons">
                        <hr>
                        <div class="circle">
                            <p>Write</p>
                        </div>
                        <div class="circle">
                            <p>Share</p>
                        </div>
                        <div class="circle">
                            <p>Review</p>
                        </div>
                        <hr>
                    </section>
                </section>
            </main>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
