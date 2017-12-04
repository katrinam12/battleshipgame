package Battleship;

import javafx.scene.image.ImageView;

public class water implements Fields{
private boolean Hit = false;
@Override
public ImageView Icon() {
	ImageView blank = new ImageView("https://images.victorianplumbing.co.uk/images/BCT-Tiles-White-Wall-Gloss-Tiles-d1.jpg");
	ImageView water = new ImageView("http://www.worldoceansday.org/_assets/images/blog/09252014/wave-1215449_960_720.jpg");
return Hit? blank:water;
}
@Override
public Result shot() {
	return Result.NO_HIT;
}
}
