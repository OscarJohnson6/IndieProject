package fit.app.health.formulas;

import fit.app.database.GenericDao;
import fit.app.entities.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet.
 *
 * @author OscarJohnson6
 */
@WebServlet(
        urlPatterns = {"/editedHealthRecord"}
)
public class EditedHealthRecord extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        int number = checkHealthInputs(req);
        User user = userDao.getById(number);

        userDao.update(user);

        req.getSession().setAttribute("userAccount", user);

        resp.sendRedirect("/GenieFit_war/settings");
    }

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
            WeightRecord weightRecord = new WeightRecord(
                    Integer.parseInt(weightIdString),
                    user,
                    Integer.parseInt(weight));
            GenericDao<WeightRecord> weightDao = new GenericDao<>(WeightRecord.class);
            weightDao.update(weightRecord);
        }

        if (height != null && !height.isEmpty()) {
            HeightRecord heightRecord = new HeightRecord(
                    Integer.parseInt(heightIdString),
                    user,
                    Integer.parseInt(height));
            GenericDao<HeightRecord> heightDao = new GenericDao<>(HeightRecord.class);
            heightDao.update(heightRecord);
        }

        if (hip != null && !hip.isEmpty()) {
            HipRecord hipRecord = new HipRecord(
                    Integer.parseInt(hipIdString),
                    user,
                    Integer.parseInt(hip));
            GenericDao<HipRecord> hipDao = new GenericDao<>(HipRecord.class);
            hipDao.update(hipRecord);
        }

        if (waist != null && !waist.isEmpty()) {
            WaistRecord waistRecord = new WaistRecord(
                    Integer.parseInt(waistIdString),
                    user,
                    Integer.parseInt(waist));
            GenericDao<WaistRecord> waistDao = new GenericDao<>(WaistRecord.class);
            waistDao.update(waistRecord);
        }

        return user.getId();
    }
}