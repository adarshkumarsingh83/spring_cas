<%--
  Created by IntelliJ IDEA.
  User: Adarsh
  Date: 6/16/15
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
    <title>Spring Cas PhotoAlbum - Home</title>
</head>
<body>
<h1>
        <span style="font-family: arial, helvetica, sans-serif"><span
                style="font-size: 10px">Username : ${user}&nbsp;|&nbsp;
<a href="../logout">Logout</a></span></span>
</h1>
    <span style="font-size: 10px"><span
            style="font-family: arial, helvetica, sans-serif"> <a
            href="../">Home</a></span></span>
<p>
    <c:forEach items="${photos}" var="photo">
        <img src="${photo}">
    </c:forEach>
</p>
</body>

</html>
