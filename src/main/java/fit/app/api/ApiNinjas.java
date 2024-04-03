package fit.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.reflect.TypeToken;
import fit.app.pojo.ApiNinjaResult;
import fit.app.pojo.ExerciseDbJson;
import fit.app.utilities.PropertiesLoader;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * The type Exercise ninjas.
 *
 * @author OscarJohnson6
 */
public class ApiNinjas implements PropertiesLoader {

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
                                            int offset) {
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
        if (offset != 0) {
            url += "&offset=" + offset;
        }

        return generateResponse(url);
    }

    /**
     * Generate response map.
     *
     * @param url the api request url
     * @return the result object to ApiNinjaResult
     */
    private ArrayList<ApiNinjaResult> generateResponse(String url) {
        OkHttpClient client = new OkHttpClient();
        ArrayList<ApiNinjaResult> list = null;

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key", properties.getProperty("api.ninjas.key"))
                .addHeader("X-RapidAPI-Host", properties.getProperty("api.ninjas.host"))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                String stringResponse = response.body().string();
                ObjectMapper mapper = new ObjectMapper();
                list = mapper.readValue(stringResponse, new TypeReference<>() {});
            }
        } catch (JsonProcessingException processingException) {
            logger.error("Problem parsing JSON in generateResponse() ", processingException);
        } catch (IOException ioException) {
            logger.error("Problem reading JSON in generateResponse() ", ioException);
        }

        return list;
    }
}
