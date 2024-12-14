package pushbox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wall extends ImageView {
    public Wall(double tileSize, double x, double y) {
        super(new Image(Wall.class.getResourceAsStream("wall.jpg")));
        setFitWidth(tileSize);
        setFitHeight(tileSize);
        setX(x);
        setY(y);
    }
}
