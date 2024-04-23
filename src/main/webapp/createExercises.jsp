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
<div class="flexBoxCenter">
    <div class="exerciseForms">
        <div class="exerciseSelector">
            <label for="formSelector">Exercise Generator Selector</label>
            <select id="formSelector">
                <option value="ExerciseDB">ExerciseDB</option>
                <option value="API-Ninja">API-Ninja</option>
            </select>
        </div>
        <div class="exerciseDBForms">
            <form action="${pageContext.request.contextPath}/ExerciseDB"
                  method="GET" id="exerciseDBForm">
                <h3>ExerciseDB Exercises</h3>

                <label for="limitExerciseDb">Limit (10 default)</label>
                <input type="number" id="limitExerciseDb" min="0" max="100"
                       name="limitExerciseDb" placeholder="Enter limit"><br>

                <label for="offsetExerciseDb">Offset</label>
                <input type="number" id="offsetExerciseDb" min="0" max="100"
                       name="offsetExerciseDb" placeholder="Enter offset amount"><br>

                <input type="submit" value="Submit" id="exerciseDbFormSubmit">
            </form><br>
        </div>

        <div class="ninjaForms">
            <form action="${pageContext.request.contextPath}/API-NinjasExercises"
                  method="GET" id="ninjaForm">
                <h3>API-Ninja Exercises</h3>

                <div class="flexDisplayForm">
                    <div>
                        <label for="exerciseName">Exercise Name:</label>
                        <input type="text" id="exerciseName" name="exerciseName"
                               placeholder="Search by name (ex: press)"><br>

                        <label for="offset">Offset: (10 - offset = total sets)</label>
                        <input type="number" id="offset" min="0" max="10" name="offset"
                               placeholder="Enter offset amount"><br>

                        <label for="type">Select Exercise Type:</label>
                        <select id="type" name="type">
                            <option value="empty" selected>N/a</option>
                            <option value="cardio">cardio</option>
                            <option value="olympic_weightlifting">olympic weight lifting</option>
                            <option value="plyometrics">plyometrics</option>
                            <option value="powerlifting">power lifting</option>
                            <option value="strength">strength</option>
                            <option value="stretching">stretching</option>
                            <option value="strongman">strongman</option>
                        </select><br>

                        <label for="muscle">Select Muscle Type:</label>
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
                            <option value="lower_back">lower back</option>
                            <option value="middle_back">middle back</option>
                            <option value="neck">neck</option>
                            <option value="quadriceps">quadriceps</option>
                            <option value="traps">traps</option>
                            <option value="triceps">triceps</option>
                        </select><br>

                        <input type="submit" value="Submit" id="ninjaApiFormSubmit">
                        <input type="reset" value="Clear" id="ninjaApiResetSubmit">
                    </div>
                    <div>
                        <fieldset>
                            <legend>Choose a Difficulty</legend>
                            <input type="radio" id="empty" name="difficulty" value="empty" checked>
                            <label for="empty">N/a</label><br>

                            <input type="radio" id="beginner" name="difficulty" value="beginner">
                            <label for="beginner">beginner</label><br>

                            <input type="radio" id="intermediate" name="difficulty" value="intermediate">
                            <label for="intermediate">intermediate</label><br>

                            <input type="radio" id="expert" name="difficulty" value="expert">
                            <label for="expert">expert</label><br>
                        </fieldset><br>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="descriptionBox">
        <h2>Generator Description</h2>
        <p>Welcome to GenieFit's Exercise Generator! With just a click, you can access a wealth of
            workout options tailored to your preferences. Harnessing the power of APIs from
            <a href="https://rapidapi.com/justin-WFnsXH_t6/api/exercisedb/">ExerciseDB</a> and
            <a href="https://rapidapi.com/apininjas/api/exercises-by-api-ninjas/">API-Ninjas</a>,
            our platform provides a seamless experience for generating random exercises.</p>
        <p>Whether you're looking to diversify your workout routine, target specific muscle groups,
            or simply try something new, our exercise generator offers endless possibilities.
            Simply input your preferences and let GenieFit do the rest, delivering a curated selection
            of exercises to keep your workouts fresh and exciting.</p>
        <p>Join GenieFit today and discover the convenience and versatility of our exercise generator.
            Say goodbye to work out boredom and hello to endless fitness inspiration!</p>
    </div>
</div>
<c:import url="footer.jsp"/>
