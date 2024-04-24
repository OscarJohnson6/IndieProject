package fit.app.controller;

import fit.app.api.ExerciseDb;
import fit.app.pojo.ApiNinjaResult;
import fit.app.pojo.ExerciseDbJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


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
        String url = "/errorPage";
        ExerciseDb exercise = new ExerciseDb();
        ArrayList<ExerciseDbJson> exercises = exercise.createApiResponse(
                req.getParameter("limitExerciseDb"),
                req.getParameter("offsetExerciseDb"));

        if (exercises != null) {
            url = "/exerciseDbResults.jsp";
        }

        req.setAttribute("exerciseDbJson", exercises);

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}