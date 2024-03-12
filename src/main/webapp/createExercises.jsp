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
<link rel="stylesheet" href="css/createExercises.css">
<script src="js/script.js" charset="UTF-8"></script>
    <title>Exercise Creation</title>
<c:import url="navbar.jsp"/>
    <div class="container">
        <h3>Exercise Generator Selector</h3>
        <select id="formSelector">
            <option value="ExerciseDB">ExerciseDB</option>
            <option value="API-Ninja">API-Ninja</option>
        </select>
        <form id="ExerciseDB" action="${pageContext.request.contextPath}/ExerciseDB" method="GET">
            <h3>ExerciseDB Exercises</h3>

            <label for="limitExerciseDb">Limit (10 default):</label>
            <input type="number" id="limitExerciseDb" min="0" max="100" name="limitExerciseDb"><br>

            <label for="offsetExerciseDb">Offset:</label>
            <input type="number" id="offsetExerciseDb" min="0" max="100" name="offsetExerciseDb"><br>

            <input type="submit" value="Submit" id="exerciseDbFormSubmit">
        </form><br>

        <form id="API-Ninja" action="${pageContext.request.contextPath}/API-NinjasExercises" method="GET">
            <h3>API-Ninja Exercises</h3>

            <label for="exerciseName">Exercise Name:</label>
            <input type="text" id="exerciseName" name="exerciseName" placeholder="Search by name ex: press">

            <label for="type">Type:</label>
            <select id="type" name="type">
                <option value="empty" selected>N/a</option>
                <option value="cardio">cardio</option>
                <option value="olympic_weightlifting">olympic_weightlifting</option>
                <option value="plyometrics">plyometrics</option>
                <option value="powerlifting">powerlifting</option>
                <option value="strength">strength</option>
                <option value="stretching">stretching</option>
                <option value="strongman">strongman</option>
            </select>

            <label for="muscle">Muscle:</label>
            <select id="muscle" name="muscle">
                <option value="empty" selected>N/a</option>
                <option value="abductors">abductors</option>
                <option value="adductors">adductors</option>
                <option value="biceps">biceps</option>
                <option value="calves">calves</option>
                <option value="chest">chest</option>
                <option value="forearms">forearms</option>
                <option value="glutes">glutes</option>
                <option value="hamstrings">hamstrings</option>
                <option value="lats">lats</option>
                <option value="lower_back">lower_back</option>
                <option value="middle_back">middle_back</option>
                <option value="neck">neck</option>
                <option value="quadriceps">quadriceps</option>
                <option value="traps">traps</option>
                <option value="triceps">triceps</option>
            </select>

            <fieldset>
                <legend>Difficulty</legend>
                <input type="radio" id="empty" name="difficulty" value="empty" checked>
                <label for="empty">N/a</label><br>

                <input type="radio" id="beginner" name="difficulty" value="beginner">
                <label for="beginner">beginner</label><br>

                <input type="radio" id="intermediate" name="difficulty" value="intermediate">
                <label for="intermediate">intermediate</label><br>

                <input type="radio" id="expert" name="difficulty" value="expert">
                <label for="expert">expert</label><br>
            </fieldset><br>

            <label for="offset">Offset: (10 - offset = total sets)</label>
            <input type="number" id="offset" value="0" min="0" max="10" name="offset"><br>

            <input type="submit" value="Submit" id="ninjaApiFormSubmit">
            <input type="reset" value="Clear" id="ninjaApiResetSubmit">
        </form>
    </div>

    <h2>Description</h2>
    <p>Generate random exercises with the click of a button. Through the use of the APIs
        <a href="https://rapidapi.com/justin-WFnsXH_t6/api/exercisedb/">ExerciseDB</a>
        and <a href="https://rapidapi.com/apininjas/api/exercises-by-api-ninjas/">API-Ninjas</a>.</p>
<c:import url="footer.jsp"/>
