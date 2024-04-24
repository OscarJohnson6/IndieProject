package fit.app.controller;

import fit.app.database.GenericDao;
import fit.app.entities.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * A simple servlet.
 *
 * @author OscarJohnson6
 */
@WebServlet(
        urlPatterns = {"/deleteRecord"}
)
public class DeleteRecord extends HttpServlet {

    /**
     * This method forwards the request to the "addHealthRecord.jsp" page, setting attributes
     * for the title and stylesheet.
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        deleteRecordById(WeightRecord.class, req.getParameter("weightId"));
        deleteRecordById(HeightRecord.class, req.getParameter("heightId"));
        deleteRecordById(HipRecord.class, req.getParameter("hipId"));
        deleteRecordById(WaistRecord.class, req.getParameter("waistId"));

        // Refreshes user account session
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User updatedUser = userDao.getById(((User) req.getSession().getAttribute("userAccount")).getId());
        req.getSession().setAttribute("userAccount", updatedUser);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/settings");
        dispatcher.forward(req, resp);
    }

    /**
     * Deletes record based on param id.
     *
     * @param <T>         the type parameter
     * @param classRecord the class record
     * @param idString    the id string
     */
    private <T extends Identity> void deleteRecordById(Class<T> classRecord, String idString) {
        if (idString != null && !idString.isEmpty()) {
            GenericDao<T> dao = new GenericDao<>(classRecord);
            dao.delete(dao.getById(Integer.parseInt(idString)));
        }
    }
}