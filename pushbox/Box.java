package pushbox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Box extends ImageView {
    public Box(double tileSize, double x, double y) {
        super(new Image(Box.class.getResourceAsStream("box.png")));
        setFitWidth(tileSize);
        setFitHeight(tileSize);
        setX(x);
        setY(y);
    }
}
