package org.example;

public class Main {
    private static final String API_URL = "https://quotes.rest/qod.json";
    private static final String FILE_PATH = "quote_of_the_day.json";

    public static void main(String[] args) {
        try {
            QuoteFetcher quoteFetcher = new QuoteFetcher();
            QuoteReader quoteReader = new QuoteReader();
            QuoteStorer quoteStorer = new QuoteStorer();

            QuoteOfTheDayManager quoteOfTheDayManager = new QuoteOfTheDayManager(quoteFetcher, quoteReader, quoteStorer);

            String quote = quoteOfTheDayManager.getQuoteOfTheDay();
            System.out.println("Quote of the day :" + quote);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
