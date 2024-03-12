package fit.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fit.app.pojo.ExerciseDbJson;
import fit.app.utilities.PropertiesLoader;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class ExerciseDb implements PropertiesLoader {
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

        return generateResponse(url);
    }

    /**
     * Generate response object with ExerciseDbJson.
     *
     * @param url the url
     */
    private ArrayList<ExerciseDbJson> generateResponse(String url) {
        OkHttpClient client = new OkHttpClient();
        ArrayList<ExerciseDbJson> list = null;

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key", properties.getProperty("exercise.db.key"))
                .addHeader("X-RapidAPI-Host", properties.getProperty("exercise.db.host"))
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
