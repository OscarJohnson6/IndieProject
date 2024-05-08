package fit.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import fit.app.pojo.ExerciseDbJson;
import fit.app.utilities.PropertiesLoader;
import okhttp3.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class ExerciseDb extends FetchApiResponse implements PropertiesLoader {
    /**
     * The Logger.
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Properties.
     */
    private final Properties properties = loadProperties("/api.properties");

    /**
     * Create api response map.
     *
     * @param limit       the limit
     * @param offset     the offset
     */
    public ArrayList<ExerciseDbJson> createApiResponse(String limit, String offset) {
        String url = properties.getProperty("exercise.db.url");

        if (!limit.isEmpty()) {
            url += "&limit=" + limit;
        }
        if (!offset.isEmpty()) {
            url += "&offset=" + offset;
        }

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key", properties.getProperty("exercise.db.key"))
                .addHeader("X-RapidAPI-Host", properties.getProperty("exercise.db.host"))
                .build();
        try {
            return generateApiResponse(request);
        } catch (JsonProcessingException e) {
            logger.error("Problem parsing exerciseDb JSON", e);
        } catch (IOException e) {
            logger.error("Problem reading exerciseDb JSON", e);
        }

        return null;
    }
}
