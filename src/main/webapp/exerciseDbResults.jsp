<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 3/9/2024
  Time: 1:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp"/>
<c:import url="navbar.jsp"/>
<h4><a href="${pageContext.request.contextPath}/createExercisesServlet" class="goBackLink">&lt; Go Back</a></h4>
<c:choose>
    <c:when test="${exerciseDbJson ne null and not empty exerciseDbJson}">
        <div class="exerciseResults">
            <c:forEach var="exerciseDbItem" varStatus="loop" items="${exerciseDbJson}">
                <div class="exerciseColumn">
                    <div class="leftExerciseInstructions">
                        <h2>Exercise ${loop.index + 1}</h2>
                        <h4>Instruction</h4>
                        <ul>
                            <c:forEach var="instruction" items="${exerciseDbItem.instructions}">
                                <li>${instruction}</li>
                            </c:forEach>
                        </ul>

                        <table>
                            <tr>
                                <th>Name</th>
                                <td>${exerciseDbItem.name}</td>
                            </tr>
                            <tr>
                                <th>Body Part</th>
                                <td>${exerciseDbItem.bodyPart}</td>
                            </tr>
                            <tr>
                                <th>Target Muscle</th>
                                <td>${exerciseDbItem.target}</td>
                            </tr>
                            <tr>
                                <th>Other Muscles</th>
                                <td>
                                    <c:forEach var="secondaryMuscles" items="${exerciseDbItem.secondaryMuscles}">
                                        ${secondaryMuscles}
                                    </c:forEach>
                                </td>
                            </tr>
                            <tr>
                                <th>Equipment</th>
                                <td>${exerciseDbItem.equipment}</td>
                            </tr>
                        </table><br><br>
                    </div>
                    <div class="rightExerciseImage">
                        <img src="${exerciseDbItem.gifUrl}" alt="gif image of the exercise">
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:when>
    <c:otherwise>
        <h3>No exercises created :(</h3>
    </c:otherwise>
</c:choose>
<c:import url="footer.jsp"/>