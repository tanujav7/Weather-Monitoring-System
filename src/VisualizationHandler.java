
public class VisualizationHandler {
	public void displayDailySummary(String city, double avgTemp, double maxTemp, double minTemp, String condition) {
        System.out.printf("City: %s | Avg: %.2f°C | Max: %.2f°C | Min: %.2f°C | Dominant Condition: %s%n",
                city, avgTemp, maxTemp, minTemp, condition);
    }
}
