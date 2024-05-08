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
<c:import url="navbar.jsp"/>
<div class="formFlexContainer">
    <form action="${pageContext.request.contextPath}/accountInsertUpdate" method="POST" class="signInForm">
        <input type="hidden" name="weightId" value="${userWeightId}">
        <input type="hidden" name="heightId" value="${userHeightId}">
        <input type="hidden" name="hipId" value="${userHipId}">
        <input type="hidden" name="waistId" value="${userWaistId}">

        <div class="groupDiv1">
            <label for="firstName" >Enter First Name:</label><br>
            <input type="text" id="firstName" name="firstName"
                   placeholder="Enter your first name" value=${userAccount.firstName}>
            <br><br>

            <label for="lastName" >Enter Last Name:</label><br>
            <input type="text" id="lastName" name="lastName"
                   placeholder="Enter your last name" value=${userAccount.lastName}>
            <br><br>
        </div>
        <div class="groupDiv2">
            <label for="age" >Enter Birthdate:</label><br>
            <input type="date" id="age" name="age" max="${currentDate}"
                   placeholder="Enter your age" value=${userAccount.age}>
            <br><br>

            <fieldset>
                <legend>Select Your Gender</legend>
                <input type="radio" id="male" name="gender" value="male"
                       <c:if test="${userAccount.gender eq 'male'}">checked</c:if>>
                <label for="male">Male</label><br>

                <input type="radio" id="female" name="gender" value="female"
                       <c:if test="${userAccount.gender eq 'female'}">checked</c:if>>
                <label for="female">Female</label><br>
            </fieldset><br>

            <fieldset>
                <legend>Select How Active You Are</legend>
                <input type="radio" id="high" name="activity_level" value="high"
                       <c:if test="${userAccount.activityLevel eq 'high'}">checked</c:if>>
                <label for="high">High</label><br>

                <input type="radio" id="medium" name="activity_level" value="medium"
                       <c:if test="${userAccount.activityLevel eq 'medium'}">checked</c:if>>
                <label for="medium">Medium</label><br>

                <input type="radio" id="low" name="activity_level" value="low"
                       <c:if test="${userAccount.activityLevel eq 'low'}">checked</c:if>>
                <label for="low">Low</label><br>
            </fieldset><br>
        </div>
        <div class="groupDiv3">
            <label for="weight" >Enter Weight (kg):</label><br>
            <input type="number" id="weight" name="weight" min="1" max="10000000"
                   placeholder="Enter your weight" value=${userWeight}>
            <br><br>
        </div>
        <div class="groupDiv4">
            <label for="height" >Enter Height (cm):</label><br>
            <input type="number" id="height" name="height" min="1" max="10000000"
                   placeholder="Enter your height" value=${userHeight}>
            <br><br>

            <label for="waist" >Enter Waist (cm):</label><br>
            <input type="number" id="waist" name="waist" min="1" max="10000000"
                   placeholder="Enter your waist" value=${userWaist}>
            <br><br>

            <label for="hip" >Enter Hip (cm):</label><br>
            <input type="number" id="hip" name="hip" min="1" max="10000000"
                   placeholder="Enter your hip" value=${userHip}>
            <br><br>

            <button type="submit" name="update_account_submit_button">Update Account</button>
        </div>
    </form>
</div>
<c:import url="footer.jsp"/>