package fit.app.controller;

import fit.app.api.HealthCalculations;
import fit.app.dao.User;
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
        urlPatterns = {"/healthNumbers"}
)
public class HealthNumbersServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO get the current user, not a new one
        HealthCalculations calculations = new HealthCalculations(new User());
        req.setAttribute("userCalculations", calculations);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/healthNumbers.jsp");
        dispatcher.forward(req, resp);
    }
}