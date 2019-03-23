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
                <h1 class="temp2">${essay.itemCode}</h1>
                <p><%= request.getParameter("itemCode")%></p>





                <form action="myitems?action=updateRating&itemCode=${essay.itemCode}">
                    <input type="text" name="peerReviewText" class="textbox">
                    <input type="hidden" name="action" value="updateRating">
                    <input type="hidden" name="itemCode" value="<%= request.getParameter("itemCode")%>">
                    <br><br>
                    Rating:
                    <select name="rating">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="4">5</option>
                    </select>
                    Did you write this paper?
                    <select name="madeIt">
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                    <input type="submit">
                </form>
            </main>

        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
