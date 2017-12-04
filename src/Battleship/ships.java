package Battleship;
import Battleship.Result;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
public class ships {
private final String name;
private final int size;
private static int Lives;
public ships(String name, int size) {
	this.name=name;
	this.size=size;
	this.Lives=size;}

public static void hit() {
	if(Lives > 0) {
		Lives--;
		System.out.printf("You got a hit... Congrats");
	}
	else {
		System.out.println("WOW You destroyed the ship");
	}
}
public Rectangle rectangle(double w, double h) {
	Image ships = new Image("https://www.simpleplanes.com/GameData/aircraft/84/47BBm5-TopView.png");
	Rectangle r = new Rectangle(w,h, Color.GREY);
	//r.setFill(new ImagePattern(ships));
	r.setStroke(Color.BLACK);
	return r;
}

public static Result State() {
	if (Lives ==0) {
		return Result.DESTROYED;
	}
	else {
		
		return Result.PARTIAL_HIT;
	}}
public String getName() {
	return name;
}
public int getSize() {
	return size;
}
public int getLives() {
	return Lives;
}
}
