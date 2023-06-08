import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class MovieCuratorUI extends JFrame implements ActionListener {

    TMDbAPI api;
    TMDbAPIConfiguration config;
    ArrayList<Movie> movies;
    JComboBox <String> movieReleaseYearDropdown;
    JRadioButton popularityRadioButton;
    JRadioButton ratingRadioButton;
    int currentYear;
    JLabel moviePosterLabel1;
    JLabel moviePosterLabel2;
    JLabel moviePosterLabel3;
    JLabel moviePosterLabel4;
    JLabel moviePosterLabel5;
    JLabel moviePosterLabel6;
    JLabel moviePosterLabel7;
    JLabel moviePosterLabel8;
    JLabel moviePosterLabel9;
    JLabel moviePosterLabel10;

    public MovieCuratorUI(String APIKey) {
        api = new TMDbAPI(APIKey);
        config = api.config();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Movie Curator");
        this.setLayout(new FlowLayout());
        this.setSize(1000, 750);
        currentYear = Year.now().getValue();
        String[] years = initializeYears(currentYear);
        movieReleaseYearDropdown = new JComboBox<> (years);
        movieReleaseYearDropdown.setSelectedIndex(movieReleaseYearDropdown.getItemCount() - 1);
        movieReleaseYearDropdown.addActionListener(this);
        popularityRadioButton = new JRadioButton("Popularity", true);
        popularityRadioButton.addActionListener(this);
        ratingRadioButton = new JRadioButton("Rating");
        ratingRadioButton.addActionListener(this);
        initializeMoviePosters();
        this.add(movieReleaseYearDropdown);
        this.add(popularityRadioButton);
        this.add(ratingRadioButton);
        ButtonGroup movieSortGroup = new ButtonGroup();
        movieSortGroup.add(popularityRadioButton);
        movieSortGroup.add(ratingRadioButton);
        this.setVisible(true);
    }

    private String[] initializeYears(int endYear) {
        String[] years = new String[endYear - 1899];
        for(int i = 0; i <= years.length - 1; i++) {
            years[i] = "" + (i + 1900);
        }
        return years;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == movieReleaseYearDropdown) {
            if(popularityRadioButton.isSelected()) {
                handlePopularRequest();
            }
            else if(ratingRadioButton.isSelected()) {
                handleRatingRequest();
            }
        }
        else if(e.getSource() == ratingRadioButton) {
            handleRatingRequest();
        }
        else if(e.getSource() == popularityRadioButton) {
            handlePopularRequest();
        }
    }

    private void handlePopularRequest() {
        String s = (String) movieReleaseYearDropdown.getSelectedItem();
        MovieRequest request = new MovieRequest(Integer.parseInt(s));
        movies = api.request(request.getPopularRequest());
        updateMoviePosters();
    }

    private void handleRatingRequest() {
        String s = (String) movieReleaseYearDropdown.getSelectedItem();
        MovieRequest request = new MovieRequest(Integer.parseInt(s));
        movies = api.request(request.getRatingRequest());
        updateMoviePosters();
    }

    private void updateMoviePosters() {
        moviePosterLabel1.setIcon(new ImageIcon(
            Objects.requireNonNull(getPosterURL(movies.get(0).getPosterPath()))));
        moviePosterLabel2.setIcon(new ImageIcon(
            Objects.requireNonNull(getPosterURL(movies.get(1).getPosterPath()))));
        moviePosterLabel3.setIcon(new ImageIcon(
            Objects.requireNonNull(getPosterURL(movies.get(2).getPosterPath()))));
        moviePosterLabel4.setIcon(new ImageIcon(
            Objects.requireNonNull(getPosterURL(movies.get(3).getPosterPath()))));
        moviePosterLabel5.setIcon(new ImageIcon(
            Objects.requireNonNull(getPosterURL(movies.get(4).getPosterPath()))));
        moviePosterLabel6.setIcon(new ImageIcon(
            Objects.requireNonNull(getPosterURL(movies.get(5).getPosterPath()))));
        moviePosterLabel7.setIcon(new ImageIcon(
            Objects.requireNonNull(getPosterURL(movies.get(6).getPosterPath()))));
        moviePosterLabel8.setIcon(new ImageIcon(
            Objects.requireNonNull(getPosterURL(movies.get(7).getPosterPath()))));
        moviePosterLabel9.setIcon(new ImageIcon(
            Objects.requireNonNull(getPosterURL(movies.get(8).getPosterPath()))));
        moviePosterLabel10.setIcon(new ImageIcon(
            Objects.requireNonNull(getPosterURL(movies.get(9).getPosterPath()))));

    }

    private void initializeMoviePosters() {
        MovieRequest request = new MovieRequest(currentYear);
        movies = api.request(request.getPopularRequest());
        moviePosterLabel1 = new JLabel();
        moviePosterLabel2 = new JLabel();
        moviePosterLabel3 = new JLabel();
        moviePosterLabel4 = new JLabel();
        moviePosterLabel5 = new JLabel();
        moviePosterLabel6 = new JLabel();
        moviePosterLabel7 = new JLabel();
        moviePosterLabel8 = new JLabel();
        moviePosterLabel9 = new JLabel();
        moviePosterLabel10 = new JLabel();
        this.add(moviePosterLabel1);
        this.add(moviePosterLabel2);
        this.add(moviePosterLabel3);
        this.add(moviePosterLabel4);
        this.add(moviePosterLabel5);
        this.add(moviePosterLabel6);
        this.add(moviePosterLabel7);
        this.add(moviePosterLabel8);
        this.add(moviePosterLabel9);
        this.add(moviePosterLabel10);
        updateMoviePosters();
    }

    private URL getPosterURL(String posterPath) {
        URL movieURL;
        try {
            movieURL = new URL(
                config.baseURL + config.posterSizes[2] + posterPath);
            return movieURL;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
