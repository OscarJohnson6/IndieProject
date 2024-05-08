package fit.app.controller;

import fit.app.entities.*;
import fit.app.utilities.RecentRecordLoader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * A simple servlet.
 *
 * @author OscarJohnson6
 */
@WebServlet(
        urlPatterns = {"/settings"}
)
public class IndexServlet extends HttpServlet implements RecentRecordLoader {

    /**
     * This method forwards the request to the "index.jsp" page, setting
     * attributes for the title and stylesheet as well as dateList,
     * for a combined date list of the records.
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Index");
        req.setAttribute("styleSheet", "index");

        User user = (User) req.getSession().getAttribute("userAccount");

        // If user is logged in, get most recent health records for jsp display
        if (user != null) {
            loadRecentRecords(user, req);
            req.setAttribute("dateList", getCombinedDates(user));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Gets combined dated.
     *
     * @param user the current user account in http session
     * @return the combined 4 record class dates
     */
    private List<Date> getCombinedDates(User user) {
        // Combine all the record dates uniquely and based on entry time
        Set<Date> recordDates = new TreeSet<>();

        loopThroughDates(recordDates, user.getWeightRecords());
        loopThroughDates(recordDates, user.getHeightRecords());
        loopThroughDates(recordDates, user.getHipRecords());
        loopThroughDates(recordDates, user.getWaistRecords());

        List<Date> reversedDates = new ArrayList<>(recordDates);
        Collections.reverse(reversedDates);

        return reversedDates;
    }

    /**
     * Loop through dates.
     *
     * @param <T>         the type parameter
     * @param recordDates the record dates
     * @param recordList  the record list
     */
    private <T extends Identity> void loopThroughDates(Set<Date> recordDates, List<T> recordList) {
        for (T record : recordList) {
            if (record.getEntryDate() != null) {
                recordDates.add(record.getEntryDate());
            }
        }
    }
}
