import java.math.BigDecimal;
import org.json.JSONArray;
import org.json.JSONObject;

public class Movie {
    private boolean isAdult;
    private String backdropPath;
    private int[] genreIDs;
    private int movieID;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private double popularity;
    private String posterPath;
    private String releaseDate;
    private String title;
    private boolean isVideo;
    private double voteAverage;
    private int voteCount;

    public Movie(JSONObject movie) {
        if(movie.get("adult") instanceof Boolean) {
            isAdult = (Boolean) movie.get("adult");
        }
        if(movie.get("backdrop_path") instanceof String) {
            backdropPath = (String) movie.get("backdrop_path");
        }
        if(movie.get("id") instanceof Integer) {
            movieID = (Integer) movie.get("id");
        }
        if(movie.get("original_language") instanceof String) {
            originalLanguage = (String) movie.get("original_language");
        }
        if(movie.get("original_title") instanceof String) {
            originalTitle = (String) movie.get("original_title");
        }
        if(movie.get("overview") instanceof String) {
            overview = (String) movie.get("overview");
        }
        if(movie.get("poster_path") instanceof String) {
            posterPath = (String) movie.get("poster_path");
        }
        if(movie.get("release_date") instanceof String) {
            releaseDate = (String) movie.get("release_date");
        }
        if(movie.get("title") instanceof String) {
            title = (String) movie.get("title");
        }
        if(movie.get("video") instanceof Boolean) {
            isVideo = (Boolean) movie.get("video");
        }
        if(movie.get("vote_count") instanceof Integer) {
            voteCount = (Integer) movie.get("vote_count");
        }
        if(movie.get("popularity") instanceof BigDecimal popDecimal) {
            popularity = popDecimal.doubleValue();
        }
        if (movie.get("vote_average") instanceof BigDecimal voteDecimal) {
            voteAverage = voteDecimal.doubleValue();
        }
        else if(movie.get("vote_average") instanceof Integer voteInteger) {
            voteAverage = voteInteger.doubleValue();
        }
        if(movie.get("genre_ids") instanceof JSONArray array) {
            genreIDs = new int[array.length()];
            for (int i = 0; i < array.length(); i++) {
                genreIDs[i] = (Integer) array.get(i);
            }
        }
    }

    public String getPosterPath() {
        return posterPath;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("isAdult: ");
        builder.append(isAdult);
        builder.append("\nbackdropPath: ");
        builder.append(backdropPath);
        builder.append("\ngenreIDs: [");
        for(int i = 0; i < genreIDs.length; i++) {
            builder.append(genreIDs[i]);
            if(i != genreIDs.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        builder.append("\nmovieID: ");
        builder.append(movieID);
        builder.append("\noriginalLanguage: ");
        builder.append(originalLanguage);
        builder.append("\noriginalTitle: ");
        builder.append(originalTitle);
        builder.append("\noverview: ");
        builder.append(overview);
        builder.append("\npopularity: ");
        builder.append(popularity);
        builder.append("\nposterPath: ");
        builder.append(posterPath);
        builder.append("\nreleaseDate: ");
        builder.append(releaseDate);
        builder.append("\ntitle: ");
        builder.append(title);
        builder.append("\nisVideo: ");
        builder.append(isVideo);
        builder.append("\nvoteAverage: ");
        builder.append(voteAverage);
        builder.append("\nvoteCount: ");
        builder.append(voteCount);
        builder.append("\n");
        return builder.toString();
    }
}
