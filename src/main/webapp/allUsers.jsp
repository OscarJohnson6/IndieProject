<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 3/4/2024
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp"/>
<title>All Users</title>
<c:import url="navbar.jsp"/>
<h4><a href="index.jsp" class="goBackLink">&lt; Go Back</a></h4>
<c:choose>
    <c:when test="${UserList ne null and not empty UserList}">
        <div class="tableRe">
            <table>
                <h3>List of All Users</h3>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>User Email</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Gender</th>
                        <th>Age</th>
                        <th>Activity Level</th>
                        <th>entry_date</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="user" varStatus="loop" items="${UserList}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userEmail}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.gender}</td>
                        <td>${user.age}</td>
                        <td>${user.activityLevel}</td>
                        <td>${user.entry_date}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table><br><br>
        </div>
    </c:when>
    <c:otherwise>
        <h3>No User's found</h3>
    </c:otherwise>
</c:choose>
<c:import url="footer.jsp"/>
