<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2/6/2024
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp"/>
<c:import url="navbar.jsp"/>
<ul class="cardInfo">
    <li>BMI = Body Mass Index</li>
    <li>WHR = Waist Height Rate</li>
    <li>BFP = Body Fat Percent</li>
    <li>BMR = Body Mass Rate</li>
    <li>TDEE = Total Daily Energy Expenditure</li>
    <li>IBW = Ideal Body Weight</li>
    <li>LBM = Lean Body Mass</li>
    <li>WHTR = Waist Height To Rate</li>
</ul>
<div id="cardHolder">
    <article class="card">
        <h3>BMI</h3>
        <c:choose>
            <c:when test="${userCalculations.BMI ne null}">
                <p>${userCalculations.BMI}</p>
            </c:when>
            <c:otherwise>
                <p>${emptyInputMessage}</p>
            </c:otherwise>
        </c:choose>
    </article>

    <article class="card">
        <h3>WHR</h3>
        <c:choose>
            <c:when test="${userCalculations.WHR ne null}">
                <p>${userCalculations.WHR}</p>
            </c:when>
            <c:otherwise>
                <p>${emptyInputMessage}</p>
            </c:otherwise>
        </c:choose>
    </article>

    <article class="card">
        <h3>BFP</h3>
        <c:choose>
            <c:when test="${userCalculations.BFP ne null}">
                <p>${userCalculations.BFP}%</p>
            </c:when>
            <c:otherwise>
                <p>${emptyInputMessage}</p>
            </c:otherwise>
        </c:choose>
    </article>

    <article class="card">
        <h3>BMR</h3>
        <c:choose>
            <c:when test="${userCalculations.BMR ne null}">
                <p>${userCalculations.BMR}</p>
            </c:when>
            <c:otherwise>
                <p>${emptyInputMessage}</p>
            </c:otherwise>
        </c:choose>
    </article>

    <article class="card">
        <h3>TDEE</h3>
        <c:choose>
            <c:when test="${userCalculations.TDEE ne null}">
                <p>${userCalculations.TDEE}</p>
            </c:when>
            <c:otherwise>
                <p>${emptyInputMessage}</p>
            </c:otherwise>
        </c:choose>
    </article>

    <article class="card">
        <h3>IBW</h3>
        <c:choose>
            <c:when test="${userCalculations.IBW ne null}">
                <p>${userCalculations.IBW}</p>
            </c:when>
            <c:otherwise>
                <p>${emptyInputMessage}</p>
            </c:otherwise>
        </c:choose>
    </article>

    <article class="card">
        <h3>LBM</h3>
        <c:choose>
            <c:when test="${userCalculations.LBM ne null}">
                <p>${userCalculations.LBM}</p>
            </c:when>
            <c:otherwise>
                <p>${emptyInputMessage}</p>
            </c:otherwise>
        </c:choose>
    </article>

    <article class="card">
        <h3>WHTR</h3>
        <c:choose>
            <c:when test="${userCalculations.WHTR ne null}">
                <p>${userCalculations.WHTR}</p>
            </c:when>
            <c:otherwise>
                <p>${emptyInputMessage}</p>
            </c:otherwise>
        </c:choose>
    </article>
</div>
<br>
<div class="formFlexContainer">
    <form action="${pageContext.request.contextPath}/healthNumbers" method="POST" class="signInForm">
        <h2>Test Health Inputs</h2>
        <div class="groupDiv2">
            <label for="age">Enter Birthdate:</label><br>
            <input type="date" id="age" name="age" max="${currentDate}"
                   placeholder="Enter your age">
            <br><br>

            <fieldset>
                <legend>Select Your Gender</legend>
                <input type="radio" id="male" name="gender" value="male">
                <label for="male">Male</label><br>

                <input type="radio" id="female" name="gender" value="female">
                <label for="female">Female</label><br>
            </fieldset><br>

            <fieldset>
                <legend>Select How Active You Are</legend>
                <input type="radio" id="high" name="activity_level" value="high">
                <label for="high">High</label><br>

                <input type="radio" id="medium" name="activity_level" value="medium">
                <label for="medium">Medium</label><br>

                <input type="radio" id="low" name="activity_level" value="low">
                <label for="low">Low</label><br>
            </fieldset><br>
        </div>
        <div class="groupDiv3">
            <label for="weight">Enter Weight (kg):</label><br>
            <input type="number" id="weight" name="weight" min="1" max="10000000"
                   placeholder="Enter your weight">
            <br><br>
        </div>
        <div class="groupDiv4">
            <label for="height">Enter Height (cm):</label><br>
            <input type="number" id="height" name="height" min="1" max="10000000"
                   placeholder="Enter your height">
            <br><br>

            <label for="waist">Enter Waist (cm):</label><br>
            <input type="number" id="waist" name="waist" min="1" max="10000000"
                   placeholder="Enter your waist">
            <br><br>

            <label for="hip">Enter Hip (cm):</label><br>
            <input type="number" id="hip" name="hip" min="1" max="10000000"
                   placeholder="Enter your hip">
            <br><br>

            <button type="submit" name="test_account_submit_button">Test Values</button>
        </div>
    </form>
</div>
<c:import url="footer.jsp"/>
