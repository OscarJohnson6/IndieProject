package fit.app.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The interface Fetch api response.
 */
public interface FetchApiResponse {
    /**
     * Generate api response array list.
     *
     * @param <T>      the type parameter
     * @param apiClass the api class
     * @param request  the request
     * @return the array list
     * @throws IOException the io exception
     */
    default <T> ArrayList<T> generateApiResponse(Class<T> apiClass, Request request) throws IOException {
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
