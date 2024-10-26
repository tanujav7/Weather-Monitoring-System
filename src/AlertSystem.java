
public class AlertSystem {
    private double temperatureThreshold;
    private int consecutiveAlertCount = 0;

    public AlertSystem(double temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold;
    }

    public void checkAndTriggerAlert(double currentTemperature, String condition) {
        if (currentTemperature > temperatureThreshold) {
            consecutiveAlertCount++;
            if (consecutiveAlertCount >= 2) {
                triggerAlert(currentTemperature, condition);
            }
        } else {
            consecutiveAlertCount = 0;
        }
    }

    private void triggerAlert(double temperature, String condition) {
        System.out.println("ALERT: Temperature exceeded threshold: " + temperature + "°C, Condition: " + condition);
        // Optionally, send email or other notifications
    }
}

