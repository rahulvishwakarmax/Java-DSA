import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinkExtractor {

    public void findYoutubeLinks(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line); // Debug output
                int startIndex = 0;
                while ((startIndex = line.indexOf("youtube.com", startIndex)) != -1) {
                    int endIndex = line.indexOf("\"", startIndex);
                    if (endIndex == -1) {
                        endIndex = line.length();
                    }
                    String youtubeLink = line.substring(startIndex, endIndex);
                    System.out.println("YouTube Link: " + youtubeLink); // Debug output
                    startIndex = endIndex;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LinkExtractor linkExtractor = new LinkExtractor();
        // Change to HTTPS if needed
        String url = "https://www.dukelearntoprogram.com/course2/data/manylinks.html";
        linkExtractor.findYoutubeLinks(url);
    }
}
