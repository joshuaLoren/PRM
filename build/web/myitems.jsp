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
                <h1 class="temp">My Papers</h1>
                <h4 class="temp">All table data will be dynamically generated from MySQL Database</h4>
                <section>
                    <table>
                        <tr>
                            <td>My Essay 1 <a href="item.html" class="green"> View</a></td>
                            <td class="hiddenOnSmall">Narrative</td>
                            <td><a href="item.html" class="update button white mainTableSections">Update</a></td>
                            <td><a href="myitems.html" class="destroy button white mainTableSections">Destroy</a></td>
                            <td class="peerReviewDropdown">
                                <div>
                                    <p>Peer Reviews</p>
                                    <section class="displayDropdown mainTableSections">
                                        <ul>
                                            <li><a href="peerreviewshow.html">John Doe</a></li>
                                            <li><a href="peerreviewshow.html">Christina S.</a></li>
                                            <li><a href="peerreviewshow.html">Bill Nye</a></li>
                                        </ul>
                                    </section>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>My Essay 12 <a href="item.html" class="green"> View</a></td>
                            <td class="hiddenOnSmall">Persuasive</td>
                            <td><a href="item.html" class="update button white mainTableSections">Update</a></td>
                            <td><a href="myitems.html" class="destroy button white mainTableSections">Destroy</a></td>
                            <td class="peerReviewDropdown">
                                <div>
                                    <p>Peer Reviews</p>
                                    <section class="displayDropdown mainTableSections">
                                        <ul>
                                            <li><a href="peerreviewshow.html">John Doe</a></li>
                                            <li><a href="peerreviewshow.html">Christina S.</a></li>
                                            <li><a href="peerreviwshow.html">Bill Nye</a></li>
                                        </ul>
                                    </section>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <div class="shareLinkMyPapers">
                        <p>Click<a href="myitems.html"> here </a>to create a new essay to share</p>
                    </div>
                </section>
                <section>
                    <header>
                        <h1>Papers I've Peer Reviewed</h1>
                    </header>
                    <h4 class="temp">All table data will be dynamically generated from MySQL Database</h4>
                    <table id="mainTableSections">
                        <tr>
                            <td>Paper Filler<a href="item.html" class="green"> View</a></td>
                            <td>Narrative</td>
                        </tr>
                    </table>
                </section>
                <section>
                    <header>
                        <h1>Papers I've Saved</h1>
                    </header>
                    <h4 class="temp">All table data will be dynamically generated from MySQL Database</h4>
                    <table>
                        <tr>
                            <td>Paper Filler<a href="peerreviewcreate.html" class="green disabled"> Write Review</a></td>
                        </tr>
                    </table>
                </section>
            </main>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
