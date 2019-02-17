<%--
    Document   : peerreviewshow
    Created on : Feb 17, 2019, 1:03:33 PM
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
        <title>Item Details</title>
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
        <div>
            <aside>
                <ul id="left-side">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="categories.jsp">Categories</a></li>
                    <li><a href="myitems.jsp">My Papers</a></li>
                    <!--<li><a href="essaynew.html">New Paper</a></li>-->
                    <li><a href="https://cloud.ibm.com/apidocs">Watson API</a></li>
                </ul>
            </aside>
            <main>
                <article>
                    <header>
                        <h2>Peer Review</h2>
                        <h3>John Doe 1/25/2018</h3>
                    </header>
                    <p class="paragraph">
                        "The paper by Chevalier et al. analyzed whether late sodium current (INaL) can be assessed using an automated
                        patch-clamp device. To this end, the INaL effects of ranolazine (a well known INaL inhibitor) and veratridine (an INaL activator)
                        were described. The authors tested the CytoPatch automated patch-clamp equipment and performed whole-cell recordings in HEK293 cells stably
                        transfected with human Nav1.5. Furthermore, they also tested the electrophysiological properties of human induced pluripotent stem cell-derived
                        cardiomyocytes (hiPS) provided by Cellular Dynamics International. The title and abstract are appropriate for the content of the text. Furthermore,
                        the article is well constructed, the experiments were well conducted, and analysis was well performed."
                        https://f1000research.com/for-referees/peer-reviewing-tips/examples

                    </p>
                </article>
            </main>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
