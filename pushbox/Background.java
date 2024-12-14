package pushbox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Background extends ImageView {
    public Background(double tileSize, double x, double y) {
        super(new Image(Background.class.getResourceAsStream("background.jpg")));
        setFitWidth(tileSize);
        setFitHeight(tileSize);
        setX(x);
        setY(y);
    }
}
