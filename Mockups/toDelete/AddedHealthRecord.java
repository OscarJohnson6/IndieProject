package fit.app.health.formulas;

import fit.app.database.GenericDao;
import fit.app.entities.*;

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
        urlPatterns = {"/addedHealthRecord"}
)
public class AddedHealthRecord extends HttpServlet {

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
        Date currentDate = new Date();

        if (weight != null && !weight.isEmpty()) {
            WeightRecord weightRecord = new WeightRecord(user, Integer.parseInt(weight), currentDate);
            GenericDao<WeightRecord> weightDao = new GenericDao<>(WeightRecord.class);
            weightDao.insert(weightRecord);
        }

        if (height != null && !height.isEmpty()) {
            HeightRecord heightRecord = new HeightRecord(user, Integer.parseInt(height), currentDate);
            GenericDao<HeightRecord> heightDao = new GenericDao<>(HeightRecord.class);
            heightDao.insert(heightRecord);
        }

        if (hip != null && !hip.isEmpty()) {
            HipRecord hipRecord = new HipRecord(user, Integer.parseInt(hip), currentDate);
            GenericDao<HipRecord> hipDao = new GenericDao<>(HipRecord.class);
            hipDao.insert(hipRecord);
        }

        if (waist != null && !waist.isEmpty()) {
            WaistRecord waistRecord = new WaistRecord(user, Integer.parseInt(waist), currentDate);
            GenericDao<WaistRecord> waistDao = new GenericDao<>(WaistRecord.class);
            waistDao.insert(waistRecord);
        }

        return user.getId();
    }
}