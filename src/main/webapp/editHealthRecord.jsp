<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 4/20/2024
  Time: 3:08 AM
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

        <label for="weight" >Enter Weight (kg):</label><br>
        <input type="number" id="weight" name="weight" min="1" max="10000000" placeholder="Enter your weight"
            <c:if test="${userWeight ne null}"> value=${userWeight}</c:if>>
        <br><br>

        <label for="height" >Enter Height (cm):</label><br>
        <input type="number" id="height" name="height" min="1" max="10000000" placeholder="Enter your height"
               <c:if test="${userHeight ne null}"> value=${userHeight}</c:if>>
        <br><br>

        <label for="waist" >Enter Waist (cm):</label><br>
        <input type="number" id="waist" name="waist" min="1" max="10000000" placeholder="Enter your waist"
                <c:if test="${userWaist ne null}">value=${userWaist}</c:if>>
        <br><br>

        <label for="hip" >Enter Hip (cm):</label><br>
        <input type="number" id="hip" name="hip" min="1" max="10000000" placeholder="Enter your hip"
            <c:if test="${userHip ne null}">value=${userHip}</c:if>>
        <br><br>

        <button type="submit" name="edit_record_submit_button">Submit Edit</button>
    </form>
</div>
<c:import url="footer.jsp"/>