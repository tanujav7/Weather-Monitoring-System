import java.sql.*;

public class DatabaseHandler {
    private Connection connect() {
        String url = "jdbc:sqlite:weather.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void saveDailySummary(String city, double avgTemp, double maxTemp, double minTemp, String dominantCondition) {
        String sql = "INSERT INTO daily_summary(city, avg_temp, max_temp, min_temp, dominant_condition) VALUES(?,?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, city);
            pstmt.setDouble(2, avgTemp);
            pstmt.setDouble(3, maxTemp);
            pstmt.setDouble(4, minTemp);
            pstmt.setString(5, dominantCondition);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
