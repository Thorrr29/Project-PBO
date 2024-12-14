package pushbox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane gamePane;
    @FXML
    private static ImageView player;
    @FXML
    private static List<ImageView> boxes;
    @FXML
    private static List<ImageView> goals;
    
        
    private static final double tileSize = 50;
    private static int currentLevel = 1;
    
    private final int[][] level1Map = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {0, 0, 1, 0, 0, 0, 0, 2, 1, 0, 0},
        {0, 0, 1, 0, 3, 1, 0, 0, 1, 0, 0},
        {0, 0, 1, 0, 4, 0, 3, 0, 1, 0, 0},
        {0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0, 0, 2, 0, 1, 0, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
};

    private final int[][] level2Map = {
        {0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 3, 0, 3, 0, 0, 2, 1},
        {1, 2, 0, 0, 3, 4, 0, 1, 1, 1, 1},
        {1, 1, 1, 1, 0, 3, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0}
    };

    private final int[][] level3Map = {
     
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0},
        {1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0},
        {1, 0, 4, 0, 0, 0, 0, 3, 0, 1, 0},
        {1, 0, 0, 0, 1, 0, 3, 0, 1, 1, 0},
        {1, 1, 2, 2, 1, 0, 0, 0, 1, 0, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        
    };
    
    
    
    private final int[][] level4Map = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1},
        {1, 0, 0, 3, 0, 4, 0, 1, 1, 2, 1},
        {1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1},
        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
        {0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    
    private int[][] map;

    private void drawMap() {
        gamePane.getChildren().clear();
        boxes.clear();
        goals.clear();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                double x = j * tileSize;
                double y = i * tileSize;

                // Add background
                gamePane.getChildren().add(new Background(tileSize, x, y));

                // Add elements based on map values
                switch (map[i][j]) {
                    case 1:
                        gamePane.getChildren().add(new Wall(tileSize, x, y));
                        break;
                    case 2:
                        Goal goal = new Goal(tileSize, x, y);
                        goals.add(goal);
                        gamePane.getChildren().add(goal);
                        break;
                    case 3:
                        Box box = new Box(tileSize, x, y);
                        boxes.add(box);
                        gamePane.getChildren().add(box);
                        break;
                    case 4:
                        player = new Player(tileSize, x, y);
                        gamePane.getChildren().add(player);
                        break;
                }
            }
        }
    }

    private void loadLevel(int level) {
        switch (level) {
            case 1:
                map = level1Map;
                break;
            case 2:
                map = level2Map;
                break;
            case 3:
                map = level3Map;
                break;
            case 4:
                map = level4Map;
                break;
            default:
                showWinMessage();
                return;
        }
        drawMap();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boxes = new ArrayList<>();
        goals = new ArrayList<>();

        loadLevel(currentLevel);

        gamePane.setFocusTraversable(true);
        gamePane.requestFocus();

        gamePane.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                gamePane.requestFocus();
            }
        });
    }

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        try {
            double stepX = 0, stepY = 0;

            switch (event.getCode()) {
                case UP:
                    stepY = -tileSize;
                    break;
                case DOWN:
                    stepY = tileSize;
                    break;
                case LEFT:
                    stepX = -tileSize;
                    break;
                case RIGHT:
                    stepX = tileSize;
                    break;
                default:
                    return;
            }

            double newPlayerX = player.getX() + stepX;
            double newPlayerY = player.getY() + stepY;

            if (canMovePlayer(newPlayerX, newPlayerY)) {
                ImageView collidingBox = null;

                for (ImageView box : boxes) {
                    if (Math.abs(newPlayerX - box.getX()) < 1e-5 && Math.abs(newPlayerY - box.getY()) < 1e-5) {
                        collidingBox = box;
                        break;
                    }
                }

                if (collidingBox != null) {
                    double newBoxX = collidingBox.getX() + stepX;
                    double newBoxY = collidingBox.getY() + stepY;

                    if (canMoveBox(newBoxX, newBoxY)) {
                        collidingBox.setX(newBoxX);
                        collidingBox.setY(newBoxY);
                        collidingBox.toFront();

                        player.setX(newPlayerX);
                        player.setY(newPlayerY);
                        player.toFront();

                        if (isGoalPosition(newBoxX, newBoxY)) {
                            checkWinCondition();
                        }
                    }
                } else {
                    player.setX(newPlayerX);
                    player.setY(newPlayerY);
                    player.toFront();
                }
            }
        } catch (Exception e) {
            showErrorMessage("Error handling key press: " + e.getMessage());
        }
    }

    private void checkWinCondition() {
    boolean allBoxesOnGoals = true;

    for (ImageView box : boxes) {
        if (!isGoalPosition(box.getX(), box.getY())) {
            allBoxesOnGoals = false;
            break;
        }
    }

    if (allBoxesOnGoals) {
        Platform.runLater(() -> {
            LevelCompleteDialog dialog = new LevelCompleteDialog((Stage) gamePane.getScene().getWindow(), currentLevel);
            dialog.show();
            currentLevel++;
            loadLevel(currentLevel);
        });
    }
}


    private boolean canMovePlayer(double x, double y) {
        int gridX = (int) (x / tileSize);
        int gridY = (int) (y / tileSize);

        return isWithinBounds(gridX, gridY) && map[gridY][gridX] != 1;
    }

    private boolean canMoveBox(double x, double y) {
        int gridX = (int) (x / tileSize);
        int gridY = (int) (y / tileSize);

        return isWithinBounds(gridX, gridY) && map[gridY][gridX] != 1 && !isBoxAtPosition(x, y);
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < map[0].length && y < map.length;
    }

    private boolean isBoxAtPosition(double x, double y) {
        for (ImageView box : boxes) {
            if (box.getX() == x && box.getY() == y) {
                return true;
            }
        }
        return false;
    }

    private boolean isGoalPosition(double x, double y) {
        for (ImageView goal : goals) {
            if (goal.getX() == x && goal.getY() == y) {
                return true;
            }
        }
        return false;
    }

    private void showWinMessage() {
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Push The Box Game");
            alert.setHeaderText(null);
            alert.setContentText("You Win!");
            alert.showAndWait();

            Platform.exit();
        });
    }

    @FXML
    private void cobaFokus(MouseEvent event) {
        player.requestFocus();
    }
    
    private void showErrorMessage(String message) {
    Platform.runLater(() -> {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    });
}
}

