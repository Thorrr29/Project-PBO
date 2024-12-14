package pushbox;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class StartScreen {

    private final Stage stage;

    public StartScreen(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Root layout
        AnchorPane root = new AnchorPane();
        root.setPrefSize(550, 550);

        // Add background image
        Image backgroundImage = new Image(getClass().getResource("resource/brick_wall.jpg").toExternalForm());
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(550);
        backgroundView.setFitHeight(550);
        backgroundView.setPreserveRatio(false);
        root.getChildren().add(backgroundView);

        // Button to start the game
        Button startButton = new Button("Start Game");
        startButton.setPrefSize(150, 50);
        startButton.setLayoutX(200); // Center the button horizontally
        startButton.setLayoutY(235); // Center the button vertically
        startButton.setStyle(
                "-fx-background-color: #d35400; " + // Brick-like color
                "-fx-text-fill: white; " +
                "-fx-border-color: #c0392b; " +
                "-fx-border-width: 2px; " +
                "-fx-font-weight: bold;"
        );
        startButton.setFont(new Font("Poppins", 16));
        startButton.setOnAction(event -> startGame());

        // Add button to the layout
        root.getChildren().add(startButton);

        // Create the scene and set it to the stage
        Scene scene = new Scene(root);
        stage.setTitle("Push the Box");
        stage.setScene(scene);
        stage.show();
    }

    private void startGame() {
    try {
        // Load the game screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        AnchorPane gameRoot = loader.load();
        Scene gameScene = new Scene(gameRoot);

        // Set the scene to the stage
        stage.setScene(gameScene);

        // Set the stage to a square size (e.g., 600x600)
        stage.setWidth(565);
        stage.setHeight(585);

        // Ensure proper alignment and size of the content
        gameRoot.setPrefSize(550, 550);
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
