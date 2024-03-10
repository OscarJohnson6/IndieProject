<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2/9/2024
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp"/>
<link rel="stylesheet" href="css/login.css">
<title>Sign Up</title>
<c:import url="navbar.jsp"/>
<div class="formFlexContainer">
    <form action="" method="POST" class="signInForm">
        <label for="user_email" >Enter Email:</label><br>
        <input type="email" id="user_email" name="user_email" placeholder="Enter your email" required>
        <br><br><br>
        <label for="password">Enter Password:</label><br>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>
        <br><br>
        <button type="submit" name="signup_submission">Sign Up</button>
    </form>
</div>
<c:import url="footer.jsp"/>