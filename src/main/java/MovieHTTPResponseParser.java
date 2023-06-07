import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class MovieHTTPResponseParser {

    private final ArrayList<Movie> movies;

    public MovieHTTPResponseParser(String httpResponse) {
        JSONObject jsonObject = new JSONObject(httpResponse);
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");
        movies = new ArrayList<>();
        for(Object obj : jsonArray) {
            JSONObject movie = (JSONObject) obj;
            movies.add(new Movie(movie));
        }
        for(Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

}
