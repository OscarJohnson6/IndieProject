package fit.app.controller;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("userAccount");
        session.invalidate();

        String previousPageUrl = req.getHeader("referer");
        if (previousPageUrl != null && !previousPageUrl.isEmpty()) {
            resp.sendRedirect(previousPageUrl);
        } else {
            resp.sendRedirect("/settings");
        }
    }
}