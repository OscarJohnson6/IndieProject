package fit.app.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
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

@Path("/users/json")
public class UsersJSON {
    private final Logger logger = LogManager.getLogger(this.getClass());

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/json")
    public Response getMessage() {
        ObjectMapper objectMapper = new ObjectMapper();
        GenericDao<User> userDao = new GenericDao<>(User.class);
        List<User> users = userDao.getAll();
        String userJsonString = "Error making json file";

        try {
            userJsonString = objectMapper.writeValueAsString(users);
            return Response.status(200).entity(userJsonString).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(userJsonString).build();
    }
}
