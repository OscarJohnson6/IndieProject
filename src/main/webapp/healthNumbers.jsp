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
<link rel="stylesheet" href="css/healthNumbers.css">
    <title>Health Numbers</title>
<c:import url="navbar.jsp"/>
    <ul class="cardInfo">
        <li>BMI = Body Mass Index</li>
        <li>WHR = Waist Height Rate</li>
        <li>BFP = Body Fat Percent</li>
        <li>BMR = Body Mass Rate</li>
        <li>TDEE = T D E E</li>
        <li>IBW = I B W</li>
        <li>LBM = L B M</li>
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
                    <p>Missing Inputs for Calculations</p>
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
                    <p>Missing Inputs for Calculations</p>
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
                    <p>Missing Inputs for Calculations</p>
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
                    <p>Missing Inputs for Calculations</p>
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
                    <p>Missing Inputs for Calculations</p>
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
                    <p>Missing Inputs for Calculations</p>
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
                    <p>Missing Inputs for Calculations</p>
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
                    <p>Missing Inputs for Calculations</p>
                </c:otherwise>
            </c:choose>
        </article>
    </div>
<c:import url="footer.jsp"/>
