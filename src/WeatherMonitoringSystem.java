import java.util.Timer;
import java.util.TimerTask;
import com.google.gson.JsonObject;

public class WeatherMonitoringSystem {
    private static final int INTERVAL = 300000; // 5 minutes in milliseconds
    private WeatherApiClient apiClient = new WeatherApiClient();

    public void startMonitoring() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    String[] cities = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"};
                    for (String city : cities) {
                        JsonObject data = apiClient.getWeatherData(city);

                        // Print JSON response for debugging
                        System.out.println("JSON response for " + city + ": " + data.toString());

                        // Check if the "main" object and other fields are present
                        if (data.has("main") && data.get("main").isJsonObject()) {
                            JsonObject mainData = data.getAsJsonObject("main");
                            double temp = mainData.has("temp") ? mainData.get("temp").getAsDouble() : Double.NaN;
                            String condition = data.has("weather") && data.getAsJsonArray("weather").size() > 0 
                                               ? data.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString() 
                                               : "Unknown";

                            System.out.printf("City: %s | Temperature: %.2f K | Condition: %s%n", city, temp, condition);
                        } else {
                            System.out.println("Warning: 'main' data missing for city: " + city);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, INTERVAL);
    }

    public static void main(String[] args) {
        new WeatherMonitoringSystem().startMonitoring();
    }
}
