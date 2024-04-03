<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2/7/2024
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<div class="pageTop">
    <div id="logoHolder" class="pageTopFlewCol">
        <a href="${pageContext.request.contextPath}/settings">
            <img style="max-height: 120px" src="img/geniefit_logo1.png"  alt="Genie Fit logo with an apple exercising and formulas around it">
        </a>
    </div>
    <div class="reverseRow">
        <div class="pageTopFlewCol">
            <c:choose>
                <c:when test="${userAccount ne null}">
                    <p class="accountMessage"><a href="${pageContext.request.contextPath}/signOut">Sign Out</a>
                        <c:if test="${userAccount.firstName ne null}">
                            | Hello, ${userAccount.firstName}</p>
                        </c:if>
                    <a href="${pageContext.request.contextPath}/settings"><img src="img/profile_picture.png" alt="Blank grey profile picture" class="profilePicture"></a>
                </c:when>
                <c:otherwise>
                    <p class="accountMessage"><a href="${pageContext.request.contextPath}/signUp">Sign Up</a> | <a href="${pageContext.request.contextPath}/logIn">Login</a></p>
                    <a href="${pageContext.request.contextPath}/logIn"><img src="img/profile_picture.png" alt="Blank grey profile picture" class="profilePicture"></a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<div class="navBar">
    <a href="healthNumbers">Health Calculations</a>
    <a href="settings">Settings</a>
    <a href="createExercisesServlet">Exercise Creation</a>
</div>
<div class="page-container">
    <div class="content-wrap">