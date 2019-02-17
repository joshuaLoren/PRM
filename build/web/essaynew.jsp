<%--
    Document   : essaynew.jsp
    Created on : Feb 17, 2019, 1:02:48 PM
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
            <aside>
                <ul id="left-side">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="categories.jsp">Categories</a></li>
                    <li><a href="myitems.jsp">My Papers</a></li>
                    <!--<li><a href="essaynew.html">New Paper</a></li>-->
                    <li><a href="https://cloud.ibm.com/apidocs">Watson API</a></li>
                </ul>
            </aside>
            <main id="mainTable" class="myItemsMainTable">
                <h1 class="temp2">Create New Paper</h1>

                <form action="/">
                    Title:<br>
                    <input type="text" name="title" value="" class="textboxtitle">
                    <br>
                    Essay Body:<br>
                    <input type="text" name="body" value="" class="textbox">
                    <br><br>
                    <input type="text" value="analyze" class="update button">
                    <input type="text" value="publish" class="update button">
                </form>
                <img src="images/toneAnalyzerExample.png" alt="watsonexample" class="toneAnalyzerExample">
            </main>

        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
