package fit.app.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The superclass for fetching API responses.
 */
public class FetchApiResponse {
    /**
     * Generate API response array list.
     *
     * @param <T>      the type parameter
     * @param request  the request
     * @return the array list
     * @throws IOException the IO exception
     */
    public <T> ArrayList<T> generateApiResponse(Request request) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ArrayList<T> list = null;

        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                String stringResponse = response.body().string();
                ObjectMapper mapper = new ObjectMapper();
                list = mapper.readValue(stringResponse, new TypeReference<>() {});
            }
        }

        return list;
    }
}
