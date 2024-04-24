package fit.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import fit.app.pojo.ApiNinjaResult;
import fit.app.utilities.PropertiesLoader;
import okhttp3.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

/**
 * The type Exercise ninjas.
 *
 * @author OscarJohnson6
 */
public class ApiNinjas implements PropertiesLoader, FetchApiResponse {

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
     * @param name       the name
     * @param type       the type
     * @param muscle     the muscle
     * @param difficulty the difficulty
     * @param offset     the offset
     * @return the map
     */
    public ArrayList<ApiNinjaResult> createApiResponse(String name,
                                            String type,
                                            String muscle,
                                            String difficulty,
                                            String offset) {
        String url = properties.getProperty("api.ninjas.url");

        if (!name.isEmpty()) {
            url += "name=" + name;
        }
        if (!type.equals("empty")) {
            url += "&type=" + type;
        }
        if (!muscle.equals("empty")) {
            url += "&muscle=" + muscle;
        }
        if (!difficulty.equals("empty")) {
            url += "&difficulty=" + difficulty;
        }
        if (!offset.isEmpty()) {
            url += "&offset=" + Integer.parseInt(offset);
        }

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key", properties.getProperty("api.ninjas.key"))
                .addHeader("X-RapidAPI-Host", properties.getProperty("api.ninjas.host"))
                .build();
        try {
            return generateApiResponse(ApiNinjaResult.class, request);
        } catch (JsonProcessingException e) {
            logger.error("Problem parsing api ninja JSON", e);
        } catch (IOException e) {
            logger.error("Problem reading api ninja JSON", e);
        }

        return null;
    }
}
