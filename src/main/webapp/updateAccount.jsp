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
    <form action="" method="POST" class="signInForm">
        <label for="firstName" >Enter First Name:</label><br>
        <input type="text" id="firstName" name="firstName" placeholder="Enter your first name">
        <br><br>

        <label for="lastName" >Enter Last Name:</label><br>
        <input type="text" id="lastName" name="lastName" placeholder="Enter your last name">
        <br><br>

        <label for="gender" >Enter Gender:</label><br>
        <input type="text" id="gender" name="gender" placeholder="Enter your gender">
        <br><br>

        <label for="age" >Enter Age:</label><br>
        <input type="date" id="age" name="age" max="${currentDate}"  placeholder="Enter your age">
        <br><br>


        <fieldset>
            <legend>Pounds or Kilograms</legend>
            <input type="radio" id="empty" name="difficulty" value="empty" checked>
            <label for="empty">Pounds (lbs)</label><br>

            <input type="radio" id="beginner" name="difficulty" value="beginner">
            <label for="beginner">Kilograms (kg)</label><br>
        </fieldset><br>
        <label for="weight" >Enter Weight:</label><br>
        <input type="number" id="weight" name="weight" min="1" placeholder="Enter your weight">
        <br><br>

        <fieldset>
            <legend>Inches or Cm</legend>
            <input type="radio" id="inches" name="inches" value="inches" checked>
            <label for="inches">Inches (in)</label><br>

            <input type="radio" id="centimeters" name="centimeters" value="centimeters">
            <label for="centimeters">Centimeters (cm)</label><br>
        </fieldset><br>
        <label for="height" >Enter Height:</label><br>
        <input type="number" id="height" name="height" min="1" placeholder="Enter your height">
        <br><br>

        <label for="waist" >Enter Waist:</label><br>
        <input type="number" id="waist" name="waist" min="1" placeholder="Enter your waist">
        <br><br>

        <label for="hip" >Enter Hip:</label><br>
        <input type="number" id="hip" name="hip" min="1" placeholder="Enter your hip">
        <br><br>

        <button type="submit" name="signup_submission">Sign Up</button>
    </form>
</div>
<c:import url="footer.jsp"/>