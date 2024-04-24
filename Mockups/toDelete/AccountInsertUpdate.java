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
 * https://stackoverflow.com/questions/75175/create-instance-of-generic-type-in-java
 *
 * @author OscarJohnson6
 */
@WebServlet(
        urlPatterns = {"/accountInsertUpdate"}
)
public class AccountInsertUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        int id = checkHealthInputs(req);
        User user = userDao.getById(id);

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");

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

        insertOrUpdate(user, WeightRecord.class, weight, weightIdString);
        insertOrUpdate(user, HeightRecord.class, height, heightIdString);
        insertOrUpdate(user, HipRecord.class, hip, hipIdString);
        insertOrUpdate(user, WaistRecord.class, waist, waistIdString);

        return user.getId();
    }

    private <T extends Identity> void insertOrUpdate(User user, Class<T> recordClass, String newRecordValue, String idString) {
        if (newRecordValue != null && !newRecordValue.isEmpty()) {
            GenericDao<T> dao = new GenericDao<>(recordClass);

            // Wont work to create a new object
            T record = new T(user, Integer.parseInt(newRecordValue));

            // newInstance needs empty params for new object, first line won't work
            T record = recordClass.newInstance(user, Integer.parseInt(newRecordValue));
            T record = recordClass.newInstance();

            // create is a method in the Identity interface,
            // classes that implement will create & return an object with their constuctor
            T record = recordClass.create(user, Integer.parseInt(newRecordValue));

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
}