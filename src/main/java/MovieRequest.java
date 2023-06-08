public class MovieRequest {

    int year;
    public MovieRequest(int year) {
        this.year = year;
    }

    public String getPopularRequest() {
        return "/discover/movie?&page=1&sort_by=popularity.desc&primary_release_year=" + year + "&include_adult=false";
    }

    public String getRatingRequest() {
        return "/discover/movie?&page=1&sort_by=vote_average.desc&primary_release_year=" + year + "&vote_count.gte=500&include_adult=false";
    }

}
