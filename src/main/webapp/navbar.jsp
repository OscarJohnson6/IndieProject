<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2/7/2024
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="pageTop">

    <div id="logoHolder" class="pageTopFlewCol">
        <h1>GenieFit</h1>
    </div>

    <div id="accountHolder" class="pageTopFlewCol">
        <c:choose>
            <c:when test="${user ne null}">
                <p class="accountMessage"><a href="#">Sign Out</a> | Hello, ${user.firstName}</p>
            </c:when>
            <c:otherwise>
                <p class="accountMessage"><a href="signup.jsp">signup</a> | <a href="login.jsp">login</a></p>
            </c:otherwise>
        </c:choose>
        <a href="login.jsp"><img src="img/profile_picture.png" alt="Blank grey profile picture" class="profilePicture"></a>
    </div>
</div>
<div class="navBar">
    <a href="healthNumbers">Health Calculations</a>
    <a href="settings">Settings</a>
    <a href="createExercisesServlet">Exercise Creation</a>
</div>
<div class="page-container">
    <div class="content-wrap">