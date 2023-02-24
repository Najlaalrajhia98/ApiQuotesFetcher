package org.example;

import java.io.File;
import java.io.IOException;

public class QuoteOfTheDayManager {
    private static final String FILE_PATH = "quote_of_the_day.json";
    private static QuoteFetcher quoteFetcher;
    private static QuoteReader quoteReader;
    private static QuoteStorer quoteStorer;

    public QuoteOfTheDayManager(QuoteFetcher quoteFetcher, QuoteReader quoteReader, QuoteStorer quoteStorer) {
        this.quoteFetcher = quoteFetcher;
        this.quoteReader = quoteReader;
        this.quoteStorer = quoteStorer;
    }

    public static String getQuoteOfTheDay() throws IOException {
        File file = new File(FILE_PATH);
        if (file.exists() && file.length() > 0) {
            System.out.println("Reading quote of the day from file...");
            return quoteReader.readQuoteOfTheDayFromFile(file);
        } else {
            System.out.println("Fetching quote of the day from API...");
            String quote = quoteFetcher.fetchQuoteOfTheDayFromApi();
            System.out.println("Storing quote of the day in file...");
            quoteStorer.storeQuoteOfTheDay(quote);
            return quote;
        }
    }
}
