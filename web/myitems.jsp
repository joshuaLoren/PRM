<%--
    Document   : myitems
    Created on : Feb 17, 2019, 1:03:17 PM
    Author     : small
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


                <c:if test = "${sessionScope.userProfile.getItems().size() == 0}">
                    <p>Go to categories to start adding items: <a href="categories">Categories</a> </p>
                </c:if>



                <h3 class="message"></h1>
                    <section>

                        <table>
                            <tr>
                                <th>Title</th>
                                <th>Category</th>
                                <th>Rating</th>
                                <th>Owner</th>
                                <th>&nbsp;</th>
                                <th>&nbsp;</th>
                            </tr>



                            <c:forEach items="${sessionScope.userProfile.getItems()}" var="userItems">
                                <tr>

                                    <td><a href="categories?itemCode=${userItems.item.itemCode}">${userItems.item.itemName}</a></td>
                                    <td>${userItems.item.itemCategory}</td>

                                    <c:if test = "${userItems.rating == 0}">
                                        <td>none</td>
                                    </c:if>
                                    <c:if test = "${userItems.rating != 0}">
                                        <td>${userItems.rating}/5</td>
                                    </c:if>

                                    <td>${userItems.madeIt}</td>

                                    <td><form action="myitems?action=gotofeedback&itemCode=${userItems.item.itemCode}" method="post">
                                            <input type="hidden" name="fakeItemList" value="${userItems.item.itemCode}">
                                            <input type="submit" name="updateButton" value="update" class="update button white mainTableSections">
                                        </form></td>

                                    <td><form action="myitems?action=deleteItem" method="post">
                                            <input type="hidden" name="fakeItemList" value="${userItems.item.itemCode}">
                                            <input type="hidden" name="itemCode" value="${userItems.item.itemCode}">
                                            <input type="submit" name="updateButton" value="destroy" class="destroy button white mainTableSections">
                                        </form></td>

                                    <!--<td><a href="myitems.html" class="destroy button white mainTableSections">Destroy</a></td>-->
                                </tr>


                            </c:forEach>



                        </table>


                    </section>
                
                    <p class="extra_bottom_padding"></p>
            </main>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
