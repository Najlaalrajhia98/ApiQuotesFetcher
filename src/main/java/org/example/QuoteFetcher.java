package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class QuoteFetcher {
    private static final String API_URL = "https://quotes.rest/qod.json";

    public String fetchQuoteOfTheDayFromApi() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(API_URL)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            JsonElement jsonElement = JsonParser.parseString(responseBody);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            return jsonObject.get("contents").getAsJsonObject().get("quotes").getAsJsonArray().get(0)
                    .getAsJsonObject().get("quote").getAsString();
        }
    }
}
