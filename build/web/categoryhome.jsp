<%--
    Document   : categoryhome
    Created on : Feb 17, 2019, 1:02:37 PM
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
            <main id="categoriesTable">
                <h1>Category Name</h1>
                <h3>All table data will be dynamically generated from MySQL Database</h3>
                <h4 class="temp">This page fulfills at least three items per category requirement</h4>
                <!--
                        repeated tr for demo purposes.
                        I'll have a foreach statement in my JSP page
                        to pull this data from the db
                -->
                <table>
                    <tr>
                        <th>Paper Name</th>
                        <th>Genre</th>
                        <th>Author</th>
                        <th class="hiddenOnSmall">Date Uploaded</th>
                        <th class="hiddenOnSmall">Rating</th>
                    </tr>
                    <tr>
                        <td>Paper Filler<a href="item.jsp" class="green"> View</a></td>
                        <td>Category Filler</td>
                        <td>John Doe</td>
                        <td class="hiddenOnSmall">Date Filler</td>
                        <td class="hiddenOnSmall">Overall Tone Filler: Watson API</td>
                    </tr>
                    <tr>
                        <td>Paper Filler<a href="item.jsp" class="green"> View</a></td>
                        <td>Category Filler</td>
                        <td>John Doe</td>
                        <td class="hiddenOnSmall">Date Filler</td>
                        <td class="hiddenOnSmall">Overall Tone Filler: Watson API</td>
                    </tr>
                    <tr>
                        <td>Paper Filler<a href="item.jsp" class="green"> View</a></td>
                        <td>Category Filler</td>
                        <td>John Doe</td>
                        <td class="hiddenOnSmall">Date Filler</td>
                        <td class="hiddenOnSmall">Overall Tone Filler: Watson API</td>
                    </tr>
                    <tr>
                        <td>Paper Filler<a href="item.jsp" class="green"> View</a></td>
                        <td>Category Filler</td>
                        <td>John Doe</td>
                        <td class="hiddenOnSmall">Date Filler</td>
                        <td class="hiddenOnSmall">Overall Tone Filler: Watson API</td>
                    </tr>
                    <tr>
                        <td>Paper Filler<a href="item.jsp" class="green"> View</a></td>
                        <td>Category Filler</td>
                        <td>John Doe</td>
                        <td class="hiddenOnSmall">Date Filler</td>
                        <td class="hiddenOnSmall">Overall Tone Filler: Watson API</td>
                    </tr>
                    <tr>
                        <td>Paper Filler<a href="item.jsp" class="green"> View</a></td>
                        <td>Category Filler</td>
                        <td>John Doe</td>
                        <td class="hiddenOnSmall">Date Filler</td>
                        <td class="hiddenOnSmall">Overall Tone Filler: Watson API</td>
                    </tr>
                    <tr>
                        <td>Paper Filler<a href="item.jsp" class="green"> View</a></td>
                        <td>Category Filler</td>
                        <td>John Doe</td>
                        <td class="hiddenOnSmall">Date Filler</td>
                        <td class="hiddenOnSmall">Overall Tone Filler: Watson API</td>
                    </tr>
                    <tr>
                        <td>Paper Filler<a href="item.jsp" class="green"> View</a></td>
                        <td>Category Filler</td>
                        <td>John Doe</td>
                        <td class="hiddenOnSmall">Date Filler</td>
                        <td class="hiddenOnSmall">Overall Tone Filler: Watson API</td>
                    </tr>
                    <tr>
                        <td>Paper Filler<a href="item.jsp" class="green"> View</a></td>
                        <td>Category Filler</td>
                        <td>John Doe</td>
                        <td class="hiddenOnSmall">Date Filler</td>
                        <td class="hiddenOnSmall">Overall Tone Filler: Watson API</td>
                    </tr>
                </table>
            </main>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
