package fit.app.controller;

import fit.app.api.ApiNinjas;
import fit.app.pojo.ApiNinjaResult;

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
        String url = "/errorPage";
        ApiNinjas exercise = new ApiNinjas();

        ArrayList<ApiNinjaResult> exercises = exercise.createApiResponse(
                req.getParameter("exerciseName"),
                req.getParameter("type"),
                req.getParameter("muscle"),
                req.getParameter("difficulty"),
                req.getParameter("offset"));

        if (exercises != null) {
            url = "/apiNinjaResults.jsp";
        }

        req.setAttribute("results", exercises);

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}