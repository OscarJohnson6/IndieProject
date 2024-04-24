package fit.app.controller;

import fit.app.database.GenericDao;
import fit.app.entities.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/**
 * A simple servlet.
 *
 * @author OscarJohnson6
 */
@WebServlet(
        urlPatterns = {"/accountInsertUpdate"}
)
public class AccountInsertUpdate extends HttpServlet {

    /**
     * This method redirects the request to the "/settings" servlet, setting attributes
     * for the title and stylesheet.
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        int id = checkHealthInputs(req);
        User user = userDao.getById(id);

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String activity_level = req.getParameter("activity_level");

        if (firstName != null && !firstName.isEmpty()) {
            user.setFirstName(firstName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            user.setLastName(lastName);
        }
        if (gender != null && !gender.isEmpty()) {
            user.setGender(gender);
        }
        if (age != null && !age.isEmpty()) {
            user.setAge(LocalDate.parse(age));
        }
        if (activity_level != null && !activity_level.isEmpty()) {
            user.setActivityLevel(activity_level);
        }

        userDao.update(user);

        req.getSession().setAttribute("userAccount", user);

        resp.sendRedirect("/GenieFit_war/settings");
    }

    /**
     * Check health inputs int.
     *
     * @param req the req
     * @return the int
     */
    private int checkHealthInputs(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("userAccount");
        String weight = req.getParameter("weight");
        String height = req.getParameter("height");
        String hip = req.getParameter("hip");
        String waist = req.getParameter("waist");
        String weightIdString = req.getParameter("weightId");
        String heightIdString = req.getParameter("heightId");
        String hipIdString = req.getParameter("hipId");
        String waistIdString = req.getParameter("waistId");

        if (weight != null && !weight.isEmpty()) {
            GenericDao<WeightRecord> weightDao = new GenericDao<>(WeightRecord.class);
            WeightRecord weightRecord = new WeightRecord(user, Integer.parseInt(weight));
            insertOrUpdate(weightIdString, weightRecord, weightDao);
        }

        if (height != null && !height.isEmpty()) {
            GenericDao<HeightRecord> heightDao = new GenericDao<>(HeightRecord.class);
            HeightRecord heightRecord = new HeightRecord(user, Integer.parseInt(height));
            insertOrUpdate(heightIdString, heightRecord, heightDao);
        }

        if (hip != null && !hip.isEmpty()) {
            GenericDao<HipRecord> hipDao = new GenericDao<>(HipRecord.class);
            HipRecord hipRecord = new HipRecord(user, Integer.parseInt(hip));
            insertOrUpdate(hipIdString, hipRecord, hipDao);
        }

        if (waist != null && !waist.isEmpty()) {
            GenericDao<WaistRecord> waistDao = new GenericDao<>(WaistRecord.class);
            WaistRecord waistRecord = new WaistRecord(user, Integer.parseInt(waist));
            insertOrUpdate(waistIdString, waistRecord, waistDao);
        }

        return user.getId();
    }

    /**
     * Insert or update.
     *
     * @param <T>      the type parameter
     * @param idString the id string
     * @param record   the record
     * @param dao      the dao
     */
    private <T extends Identity> void insertOrUpdate(String idString, T record, GenericDao<T> dao) {
        if (idString != null && !idString.isEmpty()) {
            int id = Integer.parseInt(idString);
            record.setId(id);
            dao.update(record);
        } else {
            record.setEntryDate(new Date());
            dao.insert(record);
        }
    }
}

