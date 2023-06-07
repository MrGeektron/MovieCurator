public class MovieRequest {

    int year;
    public MovieRequest(int year) {
        this.year = year;
    }

    public String getRequest() {
        StringBuilder builder = new StringBuilder();
        builder.append("/discover/movie?");
        builder.append("&page=1");
        builder.append("&sort_by=popularity.desc");
        builder.append("&primary_release_year=");
        builder.append(year);
        return builder.toString();
    }

}
