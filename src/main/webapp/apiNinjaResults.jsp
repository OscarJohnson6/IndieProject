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
<link rel="stylesheet" href="css/apiNinjasResults.css">
<title>API-Ninja Exercises</title>
<c:import url="navbar.jsp"/>
    <h4><a href="${pageContext.request.contextPath}/createExercisesServlet" class="goBackLink">&lt; Go Back</a></h4>
    <form action="${pageContext.request.contextPath}/API-NinjasExercises" method="GET">
        <input type="submit" value="Generate Again" id="ninjaApiFormSubmit">
    </form>
<c:choose>
    <c:when test="${results ne null and not empty results}">
        <div class="tableResults">
            <c:forEach var="result" varStatus="loop" items="${results}">
                <h3>Exercise ${loop.index + 1}</h3>
                <table class="ninjaResults">
                <c:forEach var="mapEntry" items="${result}">
                    <tr>
                        <th class="leftFloat">${mapEntry.key}</th>
                        <td>${mapEntry.value}</td>
                    </tr>
                </c:forEach>
                </table><br><br>
            </c:forEach>
        </div>
    </c:when>
    <c:otherwise>
        <h3>No exercises created :(</h3>
    </c:otherwise>
</c:choose>
<c:import url="footer.jsp"/>
