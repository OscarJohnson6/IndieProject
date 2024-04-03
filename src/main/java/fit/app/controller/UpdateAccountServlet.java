package fit.app.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * A simple servlet.
 *
 * @author OscarJohnson6
 */
@WebServlet(
        urlPatterns = {"/updateAccount"}
)
public class UpdateAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Modifying Account");
        req.setAttribute("styleSheet", "updateAccount");

        LocalDate currentDate = LocalDate.now();
        req.setAttribute("currentDate", currentDate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("updateAccount.jsp");
        dispatcher.forward(req, resp);
    }
}