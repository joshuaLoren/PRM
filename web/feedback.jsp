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
            <jsp:include page="aside.jsp"/>
            <main id="mainTable" class="myItemsMainTable">
                <h1 class="temp2">New Peer Review</h1>

                <form action="/">

                    <input type="text" name="body" value="" class="textbox">
                    <br><br>
                    <div class="selectbox">
                        <select>
                            <option value="1">1 Star</option>
                            <option value="2">2 Stars</option>
                            <option value="3">3 stars</option>
                            <option value="4">4 Stars</option>
                            <option value="5">5 stars</option>
                        </select>
                    </div>
                    <input type="text" value="Publish" class="update button">
                </form>
            </main>

        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
