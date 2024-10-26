import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherApiClient {
    private static final String API_KEY = "b960ac5e2d7655753b5aea07d11034af";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q="; // Ensure "https://"

    public JsonObject getWeatherData(String city) throws Exception {
        // Construct the full URL with city and API key
        String url = BASE_URL + city + "&appid=" + API_KEY;
        
        // Debug: Print URL for confirmation
        System.out.println("Request URL: " + url);

        // Build the HTTP request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(new URI(url))
                                         .build();
                                         
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        // Parse JSON response into JsonObject
        return JsonParser.parseString(response.body()).getAsJsonObject();
    }
}
