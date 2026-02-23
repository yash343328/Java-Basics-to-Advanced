import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogFileAnalyzer {

    public static void main(String[] args) {

        String filePath = "app.log"; // sample log file
        Map<String, Integer> errorCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {

                if (line.contains("ERROR")) {
                    errorCount.put(
                        line,
                        errorCount.getOrDefault(line, 0) + 1
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading log file");
        }

        System.out.println("Error Summary:");
        for (Map.Entry<String, Integer> entry : errorCount.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}
