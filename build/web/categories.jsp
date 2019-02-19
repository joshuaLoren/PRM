<%--
    Document   : categories
    Created on : Feb 17, 2019, 1:02:21 PM
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
                    <li><a href="https://cloud.ibm.com/apidocs">Watson API</a></li>
                </ul>
            </aside>
            <main class="itempage">
                <section class="card">
                    <h3>Narrative Essays</h3>
                    <p>Tell a story</p>
                </section>

                <div>
                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <c:forEach items="${userInfo.langs}" var="lang">
                        <span>${lang}</span><br />
                    </c:forEach> --%>
                </div>

                <section class="card">
                    <h3>Persuasive Essays</h3>
                    <p>Convince the reader</p>
                </section>

                <div>
                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <c:forEach items="${userInfo.langs}" var="lang">
                        <span>${lang}</span><br />
                    </c:forEach> --%>
                </div>

                <section class="card">
                    <h3>Expository Essays</h3>
                    <p>Write a tutorial</p>
                </section>

                <div>
                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <c:forEach items="${userInfo.langs}" var="lang">
                        <span>${lang}</span><br />
                    </c:forEach> --%>
                </div>

            </main>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
