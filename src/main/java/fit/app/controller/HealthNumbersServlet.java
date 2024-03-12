package fit.app.controller;

import fit.app.dao.User;
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
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(1);
        HealthCalculations calculations = new HealthCalculations(user);

        req.setAttribute("userCalculations", calculations);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/healthNumbers.jsp");
        dispatcher.forward(req, resp);
    }
}