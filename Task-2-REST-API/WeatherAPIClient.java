import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPIClient {

    public static void main(String[] args) {
        try {
            // Open-Meteo public API URL (Chennai coordinates)
            String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=13.08&longitude=80.27&current_weather=true";

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                System.out.println("Raw JSON Response:");
                System.out.println(response.toString());

                // Simple parsing using String methods
                String json = response.toString();

                String temperature = json.split("\"temperature\":")[1].split(",")[0];
                String windSpeed = json.split("\"windspeed\":")[1].split(",")[0];

                System.out.println("\n--- Weather Information ---");
                System.out.println("Temperature: " + temperature + " °C");
                System.out.println("Wind Speed : " + windSpeed + " km/h");

            } else {
                System.out.println("HTTP Error Code: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Error occurred while fetching data.");
            e.printStackTrace();
        }
    }
}
