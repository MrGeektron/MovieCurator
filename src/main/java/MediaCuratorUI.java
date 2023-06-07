import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MediaCuratorUI {
    JFrame frame;

    public MediaCuratorUI() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1000, 1000);
        frame.setTitle("Media Curator");
        frame.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(400, 66, 200, 200);
        panel.setBackground(Color.blue);
        JButton movieCuratorButton = new JButton("Movie Curator");
        movieCuratorButton.addActionListener(e -> new MovieCuratorUI(""));
        panel.add(movieCuratorButton);
        frame.add(panel);
        JButton animeCuratorButton = new JButton("Anime Curator");
        animeCuratorButton.setBounds(200, 200, 200, 200);
        frame.add(movieCuratorButton);
    }
}
