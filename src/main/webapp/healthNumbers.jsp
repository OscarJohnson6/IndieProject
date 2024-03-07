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
    <title>Health Numbers</title>
<c:import url="navbar.jsp"/>
    <div id="cardHolder">
        <article class="card">
            <h3>BMI</h3>
            <p>0.0</p>
        </article>

        <article class="card">
            <h3>WHR</h3>
            <c:choose>
                <c:when test="${userCalculations ne null and not empty userCalculations}">
                    <p>${userCalculations.WHR}%</p>
                </c:when>
                <c:otherwise>
                    <p>Missing Inputs for Calculations</p>
                </c:otherwise>
            </c:choose>
        </article>

        <article class="card">
            <h3>Body Fat Percent</h3>
            <c:choose>
                <c:when test="${userCalculations ne null and not empty userCalculations}">
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
                <c:when test="${userCalculations ne null and not empty userCalculations}">
                    <p>${userCalculations.BMR}%</p>
                </c:when>
                <c:otherwise>
                    <p>Missing Inputs for Calculations</p>
                </c:otherwise>
            </c:choose>
        </article>

        <article class="card">
            <h3>TDEE</h3>
            <c:choose>
                <c:when test="${userCalculations ne null and not empty userCalculations}">
                    <p>${userCalculations.TDEE}%</p>
                </c:when>
                <c:otherwise>
                    <p>Missing Inputs for Calculations</p>
                </c:otherwise>
            </c:choose>
        </article>

        <article class="card">
            <h3>IBW</h3>
            <c:choose>
                <c:when test="${userCalculations ne null and not empty userCalculations}">
                    <p>${userCalculations.IBW}%</p>
                </c:when>
                <c:otherwise>
                    <p>Missing Inputs for Calculations</p>
                </c:otherwise>
            </c:choose>
        </article>

        <article class="card">
            <h3>LBM</h3>
            <c:choose>
                <c:when test="${userCalculations ne null and not empty userCalculations}">
                    <p>${userCalculations.LBM}%</p>
                </c:when>
                <c:otherwise>
                    <p>Missing Inputs for Calculations</p>
                </c:otherwise>
            </c:choose>
        </article>

        <article class="card">
            <h3>WHTR</h3>
            <c:choose>
                <c:when test="${userCalculations ne null and not empty userCalculations}">
                    <p>${userCalculations.WHTR}%</p>
                </c:when>
                <c:otherwise>
                    <p>Missing Inputs for Calculations</p>
                </c:otherwise>
            </c:choose>
        </article>
    </div>
<c:import url="footer.jsp"/>
