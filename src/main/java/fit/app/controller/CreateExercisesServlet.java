package fit.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

/**
 * A simple servlet.
 *
 * @author OscarJohnson6
 */
@WebServlet(
        urlPatterns = {"/createExercisesServlet"}
)
public class CreateExercisesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Exercise Creation");
        req.setAttribute("styleSheet", "createExercises");
        req.setAttribute("scriptFile", "script");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/createExercises.jsp");
        dispatcher.forward(req, resp);
    }
}