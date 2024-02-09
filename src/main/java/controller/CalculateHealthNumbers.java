package controller;

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
        urlPatterns = {"/healthNumbers"}
)

public class CalculateHealthNumbers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/healthCalculations.jsp");
        dispatcher.forward(req, resp);
    }
}