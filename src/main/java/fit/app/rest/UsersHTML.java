package fit.app.rest;

import fit.app.database.GenericDao;
import fit.app.entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users/html")
public class UsersHTML {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @GET
    @Produces("text/html")
    public Response getMessage() {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        List<User> users = userDao.getAll();
        StringBuilder html = new StringBuilder();

        html.append("<table>");
        html.append("<tr>");
        html.append("<th>User ID</th>");
        html.append("<th>User Email</th>");
        html.append("<th>First Name</th>");
        html.append("<th>Last Name</th>");
        html.append("<th>Gender</th>");
        html.append("<th>Age</th>");
        html.append("<th>Activity Level</th>");
        html.append("<th>Entry Date</th>");
        html.append("<th>Weights</th>");
        html.append("<th>Heights</th>");
        html.append("<th>Hip</th>");
        html.append("<th>Waists</th>");
        html.append("</tr>");

        for (User user : users) {
            html.append("<tr>");
            html.append("<td>").append(user.getId()).append("</td>");
            html.append("<td>").append(user.getUserEmail()).append("</td>");
            html.append("<td>").append(user.getFirstName()).append("</td>");
            html.append("<td>").append(user.getLastName()).append("</td>");
            html.append("<td>").append(user.getGender()).append("</td>");
            html.append("<td>").append(user.getAge()).append("</td>");
            html.append("<td>").append(user.getActivityLevel()).append("</td>");
            html.append("<td>").append(user.getEntry_date()).append("</td>");

            html.append("<td>");
            for (WeightRecord weightRecord : user.getWeightRecords()) {
                html.append(weightRecord.getWeight());
                html.append(" ");
            }
            html.append("</td>");

            html.append("<td>");
            for (HeightRecord heightRecord : user.getHeightRecords()) {
                html.append(heightRecord.getHeight());
                html.append(" ");
            }
            html.append("</td>");

            html.append("<td>");
            for (HipRecord hipRecord : user.getHipRecords()) {
                html.append(hipRecord.getHip());
                html.append(" ");
            }
            html.append("</td>");

            html.append("<td>");
            for (WaistRecord waistRecord : user.getWaistRecords()) {
                html.append(waistRecord.getWaist());
                html.append(" ");
            }
            html.append("</td>");
            html.append("</tr>");
        }
        html.append("</table>");

        return Response.status(200).entity(html.toString()).build();
    }
}
