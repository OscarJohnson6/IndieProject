package fit.app.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fit.app.utilities.PropertiesLoader;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * The type Fitness calculator.
 *
 * @author OscarJohnson6
 */
public class FitnessCalculator implements PropertiesLoader {

    /**
     * The Logger.
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Properties.
     */
    private final Properties properties = loadProperties("/api.properties");

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
        String url = properties.getProperty("api.bmi.calculator.url");
        String url2 = properties.getProperty("api.bmr.calculator.url");

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
                .addHeader("X-RapidAPI-Key", properties.getProperty("api.mega.calculator.key"))
                .addHeader("X-RapidAPI-Host", properties.getProperty("api.mega.calculator.host"))
                .build();

        try (Response response = client.newCall(request).execute()) {
        } catch (IOException ioException) {
            logger.error("Problem reading JSON in generateResponse() ", ioException);
        }

        return jsonMap;
    }


}
