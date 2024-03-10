package fit.app.controller;

import fit.app.api.ApiNinjas;
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
        urlPatterns = {"/API-NinjasExercises"}
)
public class ApiNinjasServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApiNinjas exercise = new ApiNinjas();

        req.setAttribute("results", exercise.createApiResponse(
                                                req.getParameter("exerciseName"),
                                                req.getParameter("type"),
                                                req.getParameter("muscle"),
                                                req.getParameter("difficulty"),
                                                Integer.parseInt(req.getParameter("offset"))));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/apiNinjaResults.jsp");
        dispatcher.forward(req, resp);
    }
}