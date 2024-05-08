package fit.app.controller;

import fit.app.entities.*;
import fit.app.formulas.HealthCalculations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
        setNeededAttributes(req);
        
        User user = (User) req.getSession().getAttribute("userAccount");
        HealthCalculations calculations = null;

        if (user != null) {
            calculations = new HealthCalculations(user);
        }
        req.setAttribute("userCalculations", calculations);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/healthNumbers.jsp");
        dispatcher.forward(req, resp);
    }


    /**
     * This method forwards the request to the "healthNumbers.jsp" page, setting attributes
     * for the title and stylesheet.
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setNeededAttributes(req);

        createTestCalculationAttribute(req);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/healthNumbers.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Create test calculation attribute.
     *
     * @param req the req
     */
    private void createTestCalculationAttribute(HttpServletRequest req) {
        User userName = (User) req.getSession().getAttribute("userAccount");
        User user = new User();
        user.setFirstName(userName.getFirstName());
        user.setLastName(userName.getLastName());
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String activityLevel = req.getParameter("activity_level");
        String weight = req.getParameter("weight");
        String height = req.getParameter("height");
        String hip = req.getParameter("hip");
        String waist = req.getParameter("waist");

        if (!age.isEmpty()) {
            user.setAge(LocalDate.parse(age));
        }
        if (gender != null && !gender.isEmpty()) {
            user.setGender(gender);
        }
        if (activityLevel != null && !activityLevel.isEmpty()) {
            user.setActivityLevel(activityLevel);
        }

        if (!weight.isEmpty()) {
            List<WeightRecord> weightRecords = new ArrayList<>();
            weightRecords.add(new WeightRecord(Integer.parseInt(weight)));
            user.setWeightRecords(weightRecords);
        }
        if (!height.isEmpty()) {
            List<HeightRecord> heightRecords = user.getHeightRecords();
            heightRecords.add(new HeightRecord(Integer.parseInt(height)));
            user.setHeightRecords(heightRecords);
        }
        if (!hip.isEmpty()) {
            List<HipRecord> hipRecords = user.getHipRecords();
            hipRecords.add(new HipRecord(Integer.parseInt(hip)));
            user.setHipRecords(hipRecords);
        }
        if (!waist.isEmpty()) {
            List<WaistRecord> waistRecords = user.getWaistRecords();
            waistRecords.add(new WaistRecord(Integer.parseInt(waist)));
            user.setWaistRecords(waistRecords);
        }

        HealthCalculations calculations = new HealthCalculations(user);
        req.setAttribute("userCalculations", calculations);
    }

    /**
     * Sets needed attributes.
     *
     * @param req the req
     */
    private void setNeededAttributes(HttpServletRequest req) {
        req.setAttribute("title", "Health Numbers");
        req.setAttribute("styleSheet", "healthNumbers");
        req.setAttribute("styleSheet2", "updateAccount");

        LocalDate currentDate = LocalDate.now();
        req.setAttribute("currentDate", currentDate);

        String emptyInput = "Missing Input(s)";
        req.setAttribute("emptyInputMessage", emptyInput);
    }
}