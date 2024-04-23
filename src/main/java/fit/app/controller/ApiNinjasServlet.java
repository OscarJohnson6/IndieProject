package fit.app.controller;

import fit.app.api.ApiNinjas;

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

    /**
     * This method forwards the request to the "apiNinjaResults.jsp" page, setting attributes
     * for the title and stylesheet as well as results from the ApiNinjas.
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "API-Ninja Exercises");
        req.setAttribute("styleSheet", "apiNinjasResults");
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