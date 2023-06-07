import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;


public class TMDbAPI {

    private final String APIKey;
    private final String APIURI = "https://api.themoviedb.org/3";

    public TMDbAPI(String APIKey) {
        this.APIKey = APIKey;
    }

    public ArrayList<Movie> request(MovieRequest request) {
        String uri = APIURI + request.getRequest();
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .header("accept", "application/json")
            .header("Authorization",
                "Bearer " + APIKey)
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
            MovieHTTPResponseParser parser = new MovieHTTPResponseParser(response.body());
            return parser.getMovies();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public TMDbAPIConfiguration config() {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(APIURI + "/configuration"))
            .header("accept", "application/json")
            .header("Authorization", "Bearer " + APIKey)
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return new TMDbAPIConfiguration(response.body());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
