package fit.app.controller;

import fit.app.api.ExerciseDb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * A simple servlet.
 *
 * @author OscarJohnson6
 */
@WebServlet(
        urlPatterns = {"/ExerciseDB"}
)
public class ExerciseDbServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExerciseDb exercise = new ExerciseDb();

        req.setAttribute("exerciseDbJson", exercise.createApiResponse(
                req.getParameter("limitExerciseDb"),
                req.getParameter("offsetExerciseDb")));

        req.setAttribute("title", "ExerciseDB Exercises");
        req.setAttribute("styleSheet", "exerciseDbResults");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/exerciseDbResults.jsp");
        dispatcher.forward(req, resp);
    }
}