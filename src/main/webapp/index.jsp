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
<div class="flexBox">
    <div class="flexBoxImportExport">
        <div class="boxImportExport">
            <form id="userImportForm" action="#" method="POST" enctype="multipart/form-data">
                <h4>Import Health Info</h4>

                <label for="importFile">Choose a File:</label>
                <input type="file" id="importFile" name="importFile"><br>

                <input type="submit" value="Import" id="importUserFormSubmit">
            </form>
        </div>
        <div id="divExportForm" class="boxImportExport">
            <form id="userExportForm" action="${pageContext.request.contextPath}/infoExport" method="GET">
                <h4>Export Health Info</h4>

                <input type="submit" value="Export" id="exportUserFormSubmit">
            </form>
        </div>
    </div>
    <c:choose>
        <c:when test="${userAccount ne null}">
            <div class="indexAccountInfo">
                <table>
                    <tr>
                        <th>Weight</th>
                        <td>${userAccount.weightRecords[0].weight} kg</td>
                    </tr>
                    <tr>
                        <th>Height</th>
                        <td>${userAccount.heightRecords[0].height} cm</td>
                    </tr>
                    <tr>
                        <th>Waist</th>
                        <td>${userAccount.waistRecords[0].waist} cm</td>
                    </tr>
                    <tr>
                        <th>Hip</th>
                        <td>${userAccount.hipRecords[0].hip} cm</td>
                    </tr>
                    <tr>
                        <th>Gender</th>
                        <td>${userAccount.gender}</td>
                    </tr>
                    <tr>
                        <th>Age</th>
                        <td>${userAccount.ageNumber}</td>
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
</div>
<c:import url="footer.jsp"/>
