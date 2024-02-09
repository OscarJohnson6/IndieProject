package api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class FitnessCalculator {

    public void createResponse() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://fitness-calculator.p.rapidapi.com/dailycalorie?age=25&gender=male&height=180&weight=70&activitylevel=level_1")
                .get()
                .addHeader("X-RapidAPI-Key", "dd8d7eca29mshd8c424bdc365491p176675jsne646d4c979eb")
                .addHeader("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        setJsonFormat(response);
    }

    private void setJsonFormat(Response response) {

    }
}
