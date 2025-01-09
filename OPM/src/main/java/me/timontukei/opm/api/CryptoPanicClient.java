package me.timontukei.opm.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import me.timontukei.opm.models.CryptoPanicNews;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Fetches data from the LunarCrush api.
 *
 * @author Timon Tukei
 * @version 1.0
 */
public class CryptoPanicClient {

    private static final String BASE_URL = "https://cryptopanic.com/api/free/v1/";
    private static final String API_ENDPOINT = "posts/";
    private static final String CRYPTOCURRENCIES = "BTC,ETH/";

    private final String apiKey;
    private final HttpClient httpClient;

    /**
     * Constructs a new LunarCrush client with the api key.
     *
     */
    public CryptoPanicClient() {
        this.apiKey = Dotenv.configure().load().get("CRYPTOPANIC_API_KEY");
        this.httpClient = HttpClient.newHttpClient();
    }

    /**
     * Fetches news from LunarCrush.
     *
     * @return the response body as a string
     * @throws IOException if an I/O error occurs
     */
    public String fetchNews() throws IOException, InterruptedException {
        String url = constructUrl();
        HttpRequest request = constructRequest(url);

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return handleResponse(response);
    }

    /**
     * Constructs the url.
     *
     * @return the lunar crush news url
     */
    public String constructUrl() {
        return BASE_URL + API_ENDPOINT + "?auth_token=" + this.apiKey + "&currencies=" + CRYPTOCURRENCIES ;
    }

    /**
     * Constructs the request with the given url.
     *
     * @param url the url to use when constructing the request
     * @return the request
     */
    public HttpRequest constructRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }

    /**
     * Handles the response from lunar crush api call.
     *
     * @param response the lunar crush api call response
     * @return the body of the response
     * @throws IOException if the api key was malformed
     */
    public String handleResponse(HttpResponse<String> response) throws IOException{
        int statusCode = response.statusCode();

        if (statusCode == 200) {
            return response.body();
        } else {
            throw new IOException("Unexpected status code: " + response.statusCode());
        }
    }

    // Quick test
    public static void main(String... args) throws IOException, InterruptedException {
        CryptoPanicClient cryptoPanicClient = new CryptoPanicClient();
        try {
            String jsonResponse = cryptoPanicClient.fetchNews();

            ObjectMapper objectMapper = new ObjectMapper();
            CryptoPanicNews response = objectMapper.readValue(jsonResponse, CryptoPanicNews.class);

            for (CryptoPanicNews.NewsItem newsItem : response.getResults()) {
                System.out.println(newsItem.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}