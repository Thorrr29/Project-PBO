package pushbox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends ImageView {
    public Player(double tileSize, double x, double y) {
        super(new Image(Player.class.getResourceAsStream("player.png")));
        setFitWidth(tileSize);
        setFitHeight(tileSize);
        setX(x);
        setY(y);
    }
}
