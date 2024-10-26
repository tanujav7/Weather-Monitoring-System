import java.util.*;

public class DataProcessor {
    private List<Double> temperatures = new ArrayList<>();
    private List<String> weatherConditions = new ArrayList<>();

    public double convertKelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public void addTemperature(double tempKelvin) {
        temperatures.add(convertKelvinToCelsius(tempKelvin));
    }

    public void addWeatherCondition(String condition) {
        weatherConditions.add(condition);
    }

    public double calculateAverageTemperature() {
        return temperatures.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double getMaxTemperature() {
        return temperatures.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
    }

    public double getMinTemperature() {
        return temperatures.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
    }

    public String getDominantWeatherCondition() {
        return weatherConditions.stream()
                .reduce((a, b) -> Collections.frequency(weatherConditions, a) > Collections.frequency(weatherConditions, b) ? a : b)
                .orElse("Clear");
    }

    public void resetDailyData() {
        temperatures.clear();
        weatherConditions.clear();
    }
}
