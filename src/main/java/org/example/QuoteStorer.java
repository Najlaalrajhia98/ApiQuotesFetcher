package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QuoteStorer {
    private static final String FILE_PATH = "quote_of_the_day.json";

    public void storeQuoteOfTheDay(String quote) throws IOException {
        // Create a JSON object with the quote of the day
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("quote", quote);

        // Write the JSON object to a file
        try (FileWriter writer = new FileWriter(new File(FILE_PATH))) {
            Gson gson = new Gson();
            gson.toJson(jsonObject, writer);
        }
    }
}
