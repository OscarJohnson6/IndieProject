package api;

import com.google.gson.reflect.TypeToken;
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
public class ExerciseNinjas {
    /**
     * The Logger.
     */
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Properties.
     */
    private Properties properties;
    /**
     * The Json map.
     */
    private List<TreeMap<String, String>> jsonMap = new ArrayList<>();

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
    public List<TreeMap<String, String>> createApiResponse(String name,
                                                          String type,
                                                          String muscle,
                                                          String difficulty,
                                                          int offset) {
        String url = "https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?";
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
     * @param url the url
     * @return the map
     */
    private List<TreeMap<String, String>> generateResponse(String url) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key", "dd8d7eca29mshd8c424bdc365491p176675jsne646d4c979eb")
                .addHeader("X-RapidAPI-Host", "exercises-by-api-ninjas.p.rapidapi.com")
                .build();

        try (Response response = client.newCall(request).execute()) {
            jsonMap = setJsonFormat(response);
        } catch (IOException ioException) {
            logger.error("Problem reading JSON in generateResponse() ", ioException);
        }

        logger.info("done?" + url);
        return jsonMap;
    }


    /**
     * Sets json format.
     *
     * @param response the response
     * @return the json format
     */
    private List<TreeMap<String, String>> setJsonFormat(Response response) {
        Gson gson = new Gson();

        try {
            assert response.body() != null;
            Type jsonType = new TypeToken<List<TreeMap<String, String>>>() {}.getType();
            jsonMap = gson.fromJson(response.body().string(), jsonType);
        } catch (IOException ioException) {
            logger.error("Problem reading JSON in setJsonFormat() ", ioException);
        }

        return jsonMap;
    }
}
