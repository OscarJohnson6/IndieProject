package fit.app.controller;

import fit.app.entities.User;
import fit.app.database.GenericDao;
import fit.app.health.formulas.HealthCalculations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("userAccount");
        HealthCalculations calculations = null;

        if (user != null) {
            calculations = new HealthCalculations(user);
        }
        session.setAttribute("userCalculations", calculations);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/healthNumbers.jsp");
        dispatcher.forward(req, resp);
    }
}