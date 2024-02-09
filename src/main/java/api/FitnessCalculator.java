package api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.*;
import org.json.simple.parser.*;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.*;

public class FitnessCalculator {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;

    public Map<Integer, ArrayList<String>> createResponse(int age,
                                                          String gender,
                                                          int height,
                                                          int weight,
                                                          String activity) {
        OkHttpClient client = new OkHttpClient();
        Map<Integer, ArrayList<String>> jsonResult = new TreeMap<>();

        // Sample test request parameters
        age = 25;
        gender = "male";
        height = 180;
        weight = 70;
        activity = "level_1";

        String url = "https://fitness-calculator.p.rapidapi.com/dailycalorie?age="
                + age
                + "&gender=" + gender
                + "&height=" + height
                + "&weight=" + weight
                + "&activitylevel=" + activity;

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key", "dd8d7eca29mshd8c424bdc365491p176675jsne646d4c979eb")
                .addHeader("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
                .build();

        try (Response response = client.newCall(request).execute()) {
            jsonResult = setJsonFormat(response);
        } catch (IOException ioException) {
            logger.error("Problem reading JSON in setJsonFormat() ", ioException);
        }

        return jsonResult;
    }

    // TODO this is for the wrong API, add the proper one
    private Map<Integer, ArrayList<String>> setJsonFormat(Response response) {
        JSONParser parser = new JSONParser();
        Map<Integer, ArrayList<String>> jsonMapped = new TreeMap<>();

        try {
            assert response.body() != null;
            JSONArray json = (JSONArray) (parser.parse(response.body().string()));
            int loop = 0;

            for (Object entry : json) {
                JSONObject jsonRow = (JSONObject) entry;
                ArrayList<String> array = new ArrayList<>();

                array.add((String) jsonRow.get("name"));
                array.add((String) jsonRow.get("type"));
                array.add((String) jsonRow.get("muscle"));
                array.add((String) jsonRow.get("equipment"));
                array.add((String) jsonRow.get("difficulty"));
                array.add((String) jsonRow.get("instructions"));
                jsonMapped.put(loop, array);
                loop++;
            }
        } catch (IOException ioException) {
            logger.error("Problem reading JSON in setJsonFormat() ", ioException);
        } catch (ParseException nullPointerException) {
            logger.error("Json file null ", nullPointerException);
        }

        return jsonMapped;
    }
}
