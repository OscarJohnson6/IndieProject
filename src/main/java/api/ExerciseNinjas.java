package api;

import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
        // 1
        Gson gson = new Gson();

        try {
            assert response.body() != null;
            Type jsonType = new TypeToken<List<TreeMap<String, String>>>() {}.getType();
            jsonMap = gson.fromJson(response.body().string(), jsonType);
        } catch (IOException ioException) {
            logger.error("Problem reading JSON in setJsonFormat() ", ioException);
        }


        // 2
//        JSONParser parser = new JSONParser();
//
//        try {
//            assert response.body() != null;
//            JSONArray jsonArray = (JSONArray) (parser.parse(response.body().string()));
//
//            for (Object entry : jsonArray) {
//                JSONObject json = (JSONObject) entry;
//                jsonMap.add(loopJsonKeys(json));
//            }
//        } catch (IOException ioException) {
//            logger.error("Problem reading JSON in setJsonFormat() ", ioException);
//        } catch (ParseException nullPointerException) {
//            logger.error("Json file null ", nullPointerException);
//        }

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
