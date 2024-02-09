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
    <title>Exercise Creation</title>
<c:import url="navbar.jsp"/>
    <div class="container">
        <form action="#" method="post">
            <fieldset>
                <legend>Intensity</legend>
                <input type="radio" id="low" name="low" value="1">
                <label for="low">Low</label><br>

                <input type="radio" id="medium" name="medium" value="2">
                <label for="medium">Medium</label><br>

                <input type="radio" id="high" name="high" value="3">
                <label for="high">High</label><br>
            </fieldset><br>

            <label for="exerciseType">What Type of Exercise:</label>
            <select id="exerciseType" name="exerciseType">
                <option value="UpperBody">UpperBody</option>
                <option value="LowerBody">LowerBody</option>
                <option value="green">green</option>
                <option value="yellow">yellow</option>
                <option value="orange">orange</option>
                <option value="purple">purple</option>
            </select>

            <input type="submit" value="Submit" id="exerciseFormSubmit">
        </form>
    </div>

    <h2>Description</h2>
    <p>Generate random exercises with the click of a button. Through the use of the APIs <a href=""></a> and <a href=""></a>.</p>
<c:import url="footer.jsp"/>
