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
        <title>Register</title>
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
                <h1 class="temp2">Register</h1>
                <form action="register">
                    <input type="hidden" name="actionRegister" value="actionRegister">
                    Email
                    <input type="text" name="username">
                    <br><br>
                    Password
                    <input type="text" name="password">
                    <br><br>
                    First Name
                    <input type="text" name="firstname">
                    <br><br>
                    Last Name
                    <input type="text" name="lastname">
                    <br><br>
                    <input type="submit" value="Sign Up!">
                </form>

                <p class="extra_bottom_padding"></p>

            </main>

        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
