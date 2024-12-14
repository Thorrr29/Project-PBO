
package pushbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author LOQ
 */
public class Pushbox extends Application {
    
    @Override
    public void start(Stage stage) {
        // Show the start screen
        StartScreen startScreen = new StartScreen(stage);
        startScreen.show();
    }   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
