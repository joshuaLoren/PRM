<%--
    Document   : myitems
    Created on : Feb 17, 2019, 1:03:17 PM
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
                <h1 class="temp">My Papers</h1>
                <h4 class="temp">All table data will be dynamically generated from MySQL Database</h4>
                <section>

                    <table>
                        <tr>
                            <th>Title</th>
                            <th>Category</th>
                            <th>Rating</th>
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>
                        </tr>


                        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                        <c:forEach items="${sessionScope.userProfile.userItems}" var="essay">
                            <tr>
                                <td>${essay.item.itemName}</td>
                                <td>${essay.rating}</td>
                                <td>${essay.madeIt}</td>
                                <td><a href="item.html" class="update button white mainTableSections">Update</a></td>
                                <td><a href="myitems.html" class="destroy button white mainTableSections">Destroy</a></td>
                            </tr>

                        </c:forEach>



                    </table>


                </section>
            </main>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
