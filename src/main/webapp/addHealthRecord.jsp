<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 4/19/2024
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp"/>
<c:import url="navbar.jsp"/>
<div class="formFlexContainer">
    <form action="${pageContext.request.contextPath}/accountInsertUpdate" method="POST" class="signInForm">
        <input type="hidden" name="weightId" value="">
        <input type="hidden" name="heightId" value="">
        <input type="hidden" name="hipId" value="">
        <input type="hidden" name="waistId" value="">

        <label for="weight" >Enter Weight (kg):</label><br>
        <input type="number" id="weight" name="weight" min="1" max="10000000"
               placeholder="Enter your weight">
        <br><br>

        <label for="height" >Enter Height (cm):</label><br>
        <input type="number" id="height" name="height" min="1" max="10000000"
               placeholder="Enter your height">
        <br><br>

        <label for="waist" >Enter Waist (cm):</label><br>
        <input type="number" id="waist" name="waist" min="1" max="10000000"
               placeholder="Enter your waist">
        <br><br>

        <label for="hip" >Enter Hip (cm):</label><br>
        <input type="number" id="hip" name="hip" min="1" max="10000000"
               placeholder="Enter your hip">
        <br><br>

        <button type="submit" name="add_record_submit_button">Add Record</button>
    </form>
</div>
<c:import url="footer.jsp"/>
