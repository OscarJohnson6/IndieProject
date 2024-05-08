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
    <h4><a href="${pageContext.request.contextPath}/createExercisesServlet" class="goBackLink">&lt; Go Back</a></h4>
<c:choose>
    <c:when test="${results ne null and not empty results}">
        <div class="boxedResults">
            <c:forEach var="apiNinjaResult" varStatus="loop" items="${results}">
                <div class="coloredBox">
                    <h3>Exercise ${loop.index + 1}</h3>
                    <div class="flexBoxStart">
                        <div class="instructionsLeft">
                            <h4>Instructions</h4>
                            <p>${apiNinjaResult.instructions}</p>
                        </div>
                        <div class="exerciseInfoRight">
                            <table class="ninjaResults">
                                <tr>
                                    <th class="leftFloat">Difficulty</th>
                                    <td>${apiNinjaResult.difficulty}</td>
                                </tr>
                                <tr>
                                    <th class="leftFloat">Muscle</th>
                                    <td>${apiNinjaResult.muscle}</td>
                                </tr>
                                <tr>
                                    <th class="leftFloat">Name</th>
                                    <td>${apiNinjaResult.name}</td>
                                </tr>
                                <tr>
                                    <th class="leftFloat">Equipment</th>
                                    <td>${apiNinjaResult.equipment}</td>
                                </tr>
                                <tr>
                                    <th class="leftFloat">Type</th>
                                    <td>${apiNinjaResult.type}</td>
                                </tr>
                            </table>
                        </div>
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
