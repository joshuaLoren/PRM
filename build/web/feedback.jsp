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

                <p>${essay.itemName}</p>
                <p>${essay.itemCategory}</p>
                <p>${essay.itemDescription}</p>

                <!--                    public String itemDescription = "";
                    public int itemRating = 0;
                    public String imageUrl = "";-->



                <form action="myitems?action=newRating&itemCode=${essay.itemCode}">
                    <input type="hidden" name="action" value="newRating">
                    <input type="hidden" name="itemCode" value="<%= request.getParameter("itemCode")%>">
                    <input type="hidden" name="title" value="${essay.itemName}">
                    <input type="hidden" name="category" value="${essay.itemCategory}">
                    <input type="hidden" name="description" value="${essay.itemDescription}">



                    <br><br>
                    Rating:
                    <select name="rating">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="4">5</option>
                    </select>

                    <input type="submit">
                </form>
                <p class="extra_bottom_padding"></p>
            </main>

        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
