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
                <h1 class="temp2">Update Paper IC: <%= request.getParameter("itemCode")%></h1>


                <form action="myitems?action=updatepaper">
                    <input type="hidden" name="action" value="updatepaper">
                    <input type="hidden" name="itemCode" value="<%= request.getParameter("itemCode")%>">
                    Title:<br>
                    <input type="text" name="title" value="" class="textboxtitle">
                    <br>
                    Essay Body:<br>
                    <input type="text" name="body" value="" class="textbox">
                    <br><br>
                    Category:
                    <select name="category">
                        <option value="narrative">narrative</option>
                        <option value="persuasive">persuasive</option>
                        <option value="expository">expository</option>
                    </select>
                    <br><br>

                    <input type="submit">
                </form>
            </main>

        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
