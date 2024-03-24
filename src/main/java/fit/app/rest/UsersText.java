package fit.app.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import fit.app.database.GenericDao;
import fit.app.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usersText")
public class UsersText {
    private final Logger logger = LogManager.getLogger(this.getClass());

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getMessage() {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        List<User> users = userDao.getAll();
        StringBuilder text = new StringBuilder();

        for (User user : users) {
            text.append(user.toString());
        }

        return Response.status(200).entity(text.toString()).build();
    }
}
