package pushbox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Goal extends ImageView {
    public Goal(double tileSize, double x, double y) {
        super(new Image(Goal.class.getResourceAsStream("goal.png")));
        setFitWidth(tileSize);
        setFitHeight(tileSize);
        setX(x);
        setY(y);
    }
}
