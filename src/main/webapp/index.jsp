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
<div class="flexBox">
    <c:choose>
        <c:when test="${userAccount ne null}">
            <div class="flexBoxColumn">
                <div class="boxColor">
                    <div class="accountInfo">
                        <table>
                            <c:if test="${not empty userAccount.firstName and not empty userAccount.lastName}">
                                <h3 class="whiteUserName">${userAccount.firstName} ${userAccount.lastName}</h3>
                            </c:if>
                            <tr>
                                <th>Weight</th>
                                <td><c:if test="${not empty userWeight}">${userWeight} kg</c:if></td>
                            </tr>
                            <tr>
                                <th>Height</th>
                                <td><c:if test="${not empty userHeight}">${userHeight} cm</c:if></td>
                            </tr>
                            <tr>
                                <th>Waist</th>
                                <td><c:if test="${not empty userWaist}">${userWaist} cm</c:if></td>
                            </tr>
                            <tr>
                                <th>Hip</th>
                                <td><c:if test="${not empty userHip}">${userHip} cm</c:if></td>
                            </tr>
                            <tr>
                                <th>Age</th>
                                <td>${userAccount.ageNumber}</td>
                            </tr>
                            <tr>
                                <th>Gender</th>
                                <td>${userAccount.gender}</td>
                            </tr>
                            <tr>
                                <th>Activity</th>
                                <td>${userAccount.activityLevel}</td>
                            </tr>
                        </table>
                    </div>
                    <div class="boxEditAndExport">
                        <h4 class="indexBoxHeader">Edit Your Account</h4>
                        <a href="${pageContext.request.contextPath}/updateAccount" class="editAccountButton" id="updateAccountButton">Edit Account</a>
                    </div>
                    <div class="boxEditAndExport">
                        <h4 class="indexBoxHeader">Export Health Info</h4>
                        <a href="${pageContext.request.contextPath}/infoExport" class="editAccountButton">Export Records</a>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="noAccountError">
                <h3>Please create an account.</h3>
            </div>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${userAccount ne null}">
            <div class="marginLeft">
                <a href="${pageContext.request.contextPath}/addHealthRecord" class="addHealthRecordButton">Add a Health Record</a>
                <table class="recordsTable">
                    <tr>
                        <th>Date</th>
                        <th>Weight</th>
                        <th>Height</th>
                        <th>Waist</th>
                        <th>Hip</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach var="date" items="${dateList}">
                        <tr>
                            <td>${date}</td>
                            <c:set var="weightIdUrl" value="" />
                            <c:set var="heightIdUrl" value="" />
                            <c:set var="hipIdUrl" value="" />
                            <c:set var="waistIdUrl" value="" />
                            <td>
                                <c:forEach var="weightRecord" items="${userAccount.weightRecords}">
                                    <c:if test="${weightRecord.entryDate eq date}">
                                        ${weightRecord.weight} kg
                                        <c:set var="weightIdUrl" value="${weightRecord.id}" />
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach var="heightRecord" items="${userAccount.heightRecords}">
                                    <c:if test="${heightRecord.entryDate eq date}">
                                        ${heightRecord.height} cm
                                        <c:set var="heightIdUrl" value="${heightRecord.id}" />
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach var="waistRecord" items="${userAccount.waistRecords}">
                                    <c:if test="${waistRecord.entryDate eq date}">
                                        ${waistRecord.waist} cm
                                        <c:set var="waistIdUrl" value="${waistRecord.id}" />
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach var="hipRecord" items="${userAccount.hipRecords}">
                                    <c:if test="${hipRecord.entryDate eq date}">
                                        ${hipRecord.hip} cm
                                        <c:set var="hipIdUrl" value="${hipRecord.id}" />
                                    </c:if>
                                </c:forEach>
                            </td>

                            <c:url var="editRecordUrl" value="/editRecord">
                                <c:param name="weightId" value="${weightIdUrl}" />
                                <c:param name="heightId" value="${heightIdUrl}" />
                                <c:param name="hipId" value="${hipIdUrl}" />
                                <c:param name="waistId" value="${waistIdUrl}" />
                            </c:url>
                            <td><a href="${editRecordUrl}"><img class="editIcon" src="img/editIcon.png" alt="Pencil icon"></a></td>

                            <c:url var="deleteRecordUrl" value="/deleteRecord">
                                <c:param name="weightId" value="${weightIdUrl}" />
                                <c:param name="heightId" value="${heightIdUrl}" />
                                <c:param name="hipId" value="${hipIdUrl}" />
                                <c:param name="waistId" value="${waistIdUrl}" />
                            </c:url>
                            <td><a href="${deleteRecordUrl}" class="deleteX">X</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:when>
        <c:otherwise>
            <div class="noAccountRecords">
                <h4>Create an account to keep health records.</h4>
            </div>
        </c:otherwise>
    </c:choose>
</div>
<c:import url="footer.jsp"/>
