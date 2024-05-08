package fit.app.controller;

import fit.app.database.GenericDao;
import fit.app.entities.HeightRecord;
import fit.app.entities.HipRecord;
import fit.app.entities.WaistRecord;
import fit.app.entities.WeightRecord;
import fit.app.utilities.RecentRecordLoader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Has a method to get record ids from params to then set attributes
 * for editHealthRecord jsp. Cannot implement recent records because
 * it's going to edit a specific record instead of recent ones.
 *
 * @author OscarJohnson6
 */
@WebServlet(
        urlPatterns = {"/editRecord"}
)
public class EditHealthRecordServlet extends HttpServlet {

    /**
     * This method forwards the request to the "addHealthRecord.jsp" page, setting attributes
     * for the title and stylesheet, also gets different record ids from http params to get
     * each record value, so they can both be attributes.
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while
     *                          handling the request
     * @throws IOException      if an input or output error occurs while
     *                          the servlet is handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Editing Health Record");
        req.setAttribute("styleSheet", "updateAccount");

        String weightIdString = req.getParameter("weightId");
        String heightIdString = req.getParameter("heightId");
        String hipIdString = req.getParameter("hipId");
        String waistIdString = req.getParameter("waistId");

        // Checking if there is a record then getting the weight of it.
        if (weightIdString != null && !weightIdString.isEmpty()) {
            GenericDao<WeightRecord> weightDao = new GenericDao<>(WeightRecord.class);
            int weightId = Integer.parseInt(weightIdString);
            int weight = weightDao.getById(weightId).getWeight();
            req.setAttribute("userWeight", weight);
            req.setAttribute("userWeightId", weightId);
        }
        if (heightIdString != null && !heightIdString.isEmpty()) {
            GenericDao<HeightRecord> heightDao = new GenericDao<>(HeightRecord.class);
            int heightId = Integer.parseInt(heightIdString);
            int height = heightDao.getById(heightId).getHeight();
            req.setAttribute("userHeight", height);
            req.setAttribute("userHeightId", heightId);
        }
        if (hipIdString != null && !hipIdString.isEmpty()) {
            GenericDao<HipRecord> hipDao = new GenericDao<>(HipRecord.class);
            int hipId = Integer.parseInt(hipIdString);
            int hip = hipDao.getById(hipId).getHip();
            req.setAttribute("userHip", hip);
            req.setAttribute("userHipId", hipId);
        }
        if (waistIdString != null && !waistIdString.isEmpty()) {
            GenericDao<WaistRecord> waistDao = new GenericDao<>(WaistRecord.class);
            int waistId = Integer.parseInt(waistIdString);
            int waist = waistDao.getById(waistId).getWaist();
            req.setAttribute("userWaist", waist);
            req.setAttribute("userWaistId", waistIdString);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("editHealthRecord.jsp");
        dispatcher.forward(req, resp);
    }
}