package fit.app.controller;

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
        urlPatterns = {"/signOut"}
)
public class SignOutServlet extends HttpServlet {

    /**
     * This method forwards the request to the previous page or "/setting" servlet,
     * removing the userAccount attribute from the http session.
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("userAccount");
        session.invalidate();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/settings");
        dispatcher.forward(req, resp);
    }
}