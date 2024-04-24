package fit.app.controller;

import fit.app.entities.User;
import fit.app.formulas.HealthCalculations;

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

    /**
     * This method forwards the request to the "healthNumbers.jsp" page, setting attributes
     * for the title and stylesheet as well as userCalculations and emptyInputMessage,
     * to display account calculations or error messages.
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Health Numbers");
        req.setAttribute("styleSheet", "healthNumbers");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("userAccount");
        HealthCalculations calculations = null;

        if (user != null) {
            calculations = new HealthCalculations(user);
        }
        req.setAttribute("userCalculations", calculations);

        String emptyInput = "Missing Input(s)";
        req.setAttribute("emptyInputMessage", emptyInput);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/healthNumbers.jsp");
        dispatcher.forward(req, resp);
    }
}