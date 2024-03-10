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
<link rel="stylesheet" href="css/index.css">
    <title>Index</title>
<c:import url="navbar.jsp"/>
<c:choose>
    <c:when test="${user ne null}">
        <div class="indexAccountInfo">
            <table>
                <tr>
                    <th>Weight</th>
                    <td>${user.weightRecords[0].weight} kg</td>
                </tr>
                <tr>
                    <th>Height</th>
                    <td>${user.heightRecords[0].height} cm</td>
                </tr>
                <tr>
                    <th>Waist</th>
                    <td>${user.waistRecords[0].waist} cm</td>
                </tr>
                <tr>
                    <th>Hip</th>
                    <td>${user.hipRecords[0].hip} cm</td>
                </tr>
                <tr>
                    <th>Gender</th>
                    <td>${user.gender}</td>
                </tr>
                <tr>
                    <th>Age</th>
                    <td>${user.ageNumber}</td>
                </tr>
            </table>
        </div>
    </c:when>
    <c:otherwise>
        <div class="indexAccountInfo">
            <h3>Please create an account.</h3>
        </div>
    </c:otherwise>
</c:choose>
<c:import url="footer.jsp"/>
