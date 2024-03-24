package fit.app.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import fit.app.database.GenericDao;
import fit.app.entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usersHTML")
public class UsersHTML {
    private final Logger logger = LogManager.getLogger(this.getClass());

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
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
            html.append("</tr>");

            html.append("<table>");
            html.append("<tr>");
            html.append("<th>Weights</th>");
            html.append("</tr>");
            for (WeightRecord weightRecord : user.getWeightRecords()) {
                html.append("<tr>");
                html.append("<td>").append(weightRecord.getWeight()).append("</td>");
                html.append("</tr>");
            }
            html.append("</table>");

            html.append("<table>");
            html.append("<tr>");
            html.append("<th>Heights</th>");
            html.append("</tr>");
            for (HeightRecord weightRecord : user.getHeightRecords()) {
                html.append("<tr>");
                html.append("<td>").append(weightRecord.getHeight()).append("</td>");
                html.append("</tr>");
            }
            html.append("</table>");

            html.append("<table>");
            html.append("<tr>");
            html.append("<th>Weights</th>");
            html.append("</tr>");
            for (HipRecord weightRecord : user.getHipRecords()) {
                html.append("<tr>");
                html.append("<td>").append(weightRecord.getHip()).append("</td>");
                html.append("</tr>");
            }
            html.append("</table>");

            html.append("<table>");
            html.append("<tr>");
            html.append("<th>Weights</th>");
            html.append("</tr>");
            for (WaistRecord weightRecord : user.getWaistRecords()) {
                html.append("<tr>");
                html.append("<td>").append(weightRecord.getWaist()).append("</td>");
                html.append("</tr>");
            }
            html.append("</table>");
        }

        html.append("</table>");

        return Response.status(200).entity(html.toString()).build();
    }
}
