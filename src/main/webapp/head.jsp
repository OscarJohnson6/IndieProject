<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2/7/2024
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>${title}</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Slabo+27px&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/styles.css?v=1.1">
    <c:if test="${styleSheet ne null}">
        <link rel="stylesheet" href="css/${styleSheet}.css?v=1.1">
    </c:if>
    <c:if test="${styleSheet2 ne null}">
        <link rel="stylesheet" href="css/${styleSheet2}.css?v=1.1">
    </c:if>
    <c:if test="${scriptFile ne null}">
        <script src="js/${scriptFile}.js?v=1.0" charset="UTF-8"></script>
    </c:if>
</head>
