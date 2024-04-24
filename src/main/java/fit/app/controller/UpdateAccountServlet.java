package fit.app.controller;

import fit.app.entities.User;
import fit.app.utilities.RecentRecordLoader;

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
public class UpdateAccountServlet extends HttpServlet implements RecentRecordLoader {

    /**
     * This method forwards the request to the "updateAccount.jsp" page, setting attributes
     * for the title and stylesheet as well as currentDate and idList.
     * currentDate: will help prevent calendar inputs that in the future
     * idList: a list of the ids to the most recent record in each record class
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Updating Account");
        req.setAttribute("styleSheet", "updateAccount");

        LocalDate currentDate = LocalDate.now();
        req.setAttribute("currentDate", currentDate);

        loadRecentRecords((User) req.getSession().getAttribute("userAccount"), req);

        RequestDispatcher dispatcher = req.getRequestDispatcher("updateAccount.jsp");
        dispatcher.forward(req, resp);
    }
}