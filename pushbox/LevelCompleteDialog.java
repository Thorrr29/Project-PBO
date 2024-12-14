package pushbox;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class LevelCompleteDialog {

    private Stage dialog;

    public LevelCompleteDialog(Stage primaryStage, int currentLevel) {
        // Create a new stage for the dialog
        dialog = new Stage();
        dialog.initOwner(primaryStage);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setTitle("Level Complete");

        // Create content for the dialog
        VBox dialogVBox = new VBox();
        dialogVBox.setSpacing(10);
        dialogVBox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Label label = new Label("Congratulations! You completed Level " + currentLevel + "!");
        label.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        Button nextButton = new Button("Next Level");
        nextButton.setOnAction(event -> {
            dialog.close();
        });

        Button exitButton = new Button("Exit Game");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });

        dialogVBox.getChildren().addAll(label, nextButton, exitButton);

        // Create a scene for the dialog
        Scene dialogScene = new Scene(dialogVBox);
        dialog.setScene(dialogScene);
    }

    public void show() {
        dialog.showAndWait();
    }
}
