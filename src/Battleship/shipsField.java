package Battleship;
import Battleship.ships;
import javafx.scene.image.ImageView;

public class shipsField implements Fields{
private boolean Hit = true;
@Override
public ImageView Icon() {
	ImageView blank = new ImageView("https://images.victorianplumbing.co.uk/images/BCT-Tiles-White-Wall-Gloss-Tiles-d1.jpg");
	ImageView hit = new ImageView("https://previews.123rf.com/images/tribalium123/tribalium1231208/tribalium123120800278/14973322-cartoon-bang-Comic-book-explosion-Stock-Vector.jpg");
return Hit? hit:blank;
}
@Override
public Result shot() {
	ships.hit();
	return ships.State();
}
}
