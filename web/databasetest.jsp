<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<h1>The SQL Gateway</h1>


<p><b>SQL result:</b></p>


<c:forEach items="${sqlResult}" var="result">
     <li>${result.firstName}</a></li>
</c:forEach>

</body>
</html>