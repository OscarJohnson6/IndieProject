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

    /**
     * This method forwards the request to the "exerciseDbResults.jsp" page, setting attributes
     * for the title and stylesheet as well as results from the ExerciseDb API.
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "ExerciseDB Exercises");
        req.setAttribute("styleSheet", "exerciseDbResults");
        ExerciseDb exercise = new ExerciseDb();

        req.setAttribute("exerciseDbJson", exercise.createApiResponse(
                req.getParameter("limitExerciseDb"),
                req.getParameter("offsetExerciseDb")));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/exerciseDbResults.jsp");
        dispatcher.forward(req, resp);
    }
}