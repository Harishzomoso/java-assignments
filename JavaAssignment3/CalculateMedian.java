import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PingMedianCalculator for Windows
 *
 * Time Complexity: O(n log n) due to sorting
 * Space Complexity: O(n) for storing ping times
 */
public class CalculateMedian {

    public static double getMedianPingTime(String host) {
        List<Double> pingTimes = new ArrayList<>();

        try {
            ProcessBuilder builder = new ProcessBuilder("ping", "-n", "5", host);
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // Example Windows output line:
                // Reply from 8.8.8.8: bytes=32 time=18ms TTL=117
                if (line.contains("Reply from") && line.contains("time=")) {
                    int timeIndex = line.indexOf("time=");
                    int msIndex = line.indexOf("ms", timeIndex);
                    if (timeIndex != -1 && msIndex != -1) {
                        String timeStr = line.substring(timeIndex + 5, msIndex).trim();
                        // Remove "less than" symbols like "<1"
                        if (timeStr.startsWith("<")) timeStr = "1";
                        pingTimes.add(Double.parseDouble(timeStr));
                    }
                }
            }

            process.waitFor();

        } catch (Exception e) {
            System.err.println("Ping failed: " + e.getMessage());
            return -1;
        }

        Collections.sort(pingTimes);
        int size = pingTimes.size();
        if (size % 2 == 1) {
            return pingTimes.get(size / 2);
        } else {
            return (pingTimes.get(size / 2 - 1) + pingTimes.get(size / 2)) / 2.0;
        }
    }

    public static void main(String[] args) {
        String host = "google.com";
        double median = getMedianPingTime(host);
        if (median != -1) {
            System.out.println("Median ping time to " + host + " is " + median + " ms");
        } else {
            System.out.println("Failed to calculate median ping time.");
        }
    }
}
