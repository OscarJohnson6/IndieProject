package api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

/**
 * The type Exercise ninjas.
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
    private Map<Integer, TreeMap<String, String>> jsonMap = new TreeMap<>();

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
    public Map<Integer, TreeMap<String, String>> createApiResponse(String name,
                                                          String type,
                                                          String muscle,
                                                          String difficulty,
                                                          int offset) {
        String url = "https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?";
        if (name.isEmpty()) {
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
    private Map<Integer, TreeMap<String, String>> generateResponse(String url) {
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
    private Map<Integer, TreeMap<String, String>> setJsonFormat(Response response) {
        JSONParser parser = new JSONParser();

        try {
            assert response.body() != null;
            JSONArray jsonArray = (JSONArray) (parser.parse(response.body().string()));
            int loop = 0;

            for (Object entry : jsonArray) {
                JSONObject json = (JSONObject) entry;
                jsonMap.put(loop, loopJsonKeys(json));
                loop++;
            }
        } catch (IOException ioException) {
            logger.error("Problem reading JSON in setJsonFormat() ", ioException);
        } catch (ParseException nullPointerException) {
            logger.error("Json file null ", nullPointerException);
        }

        return jsonMap;
    }

    /**
     * Load a json object formatted like Map<String, String> and puts it in
     * a reverse tree map adding everything from the json to map, to then return it.
     *
     * @param jsonArray a Map<String, String> of the need api results
     * @return a reverse String map of the api json results
     */
    @SuppressWarnings("unchecked")
    private TreeMap<String, String> loopJsonKeys(JSONObject jsonArray) {
        TreeMap<String, String> apiJsonResults = new TreeMap<>(Comparator.reverseOrder());
        Set<String> keys = jsonArray.keySet();

        for (String key : keys) {
            apiJsonResults.put(key, (String) jsonArray.get(key));
        }

        return apiJsonResults;
    }
}
