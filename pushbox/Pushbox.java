package pushbox;

import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author LOQ
 */
public class Pushbox extends Application {
    
    private MediaPlayer mediaPlayer;
    @Override
    public void start(Stage stage) {
        // Show the start screen
        StartScreen startScreen = new StartScreen(stage);
        startScreen.show();
        playBackgroundMusic();
    }   
    
    private void playBackgroundMusic() {
        URL musicUrl = getClass().getResource("resource/backsound.mp3");
        if (musicUrl != null) {
            String musicPath = musicUrl.toExternalForm();
            Media media = new Media(musicPath);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(0.5);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setAutoPlay(true);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
