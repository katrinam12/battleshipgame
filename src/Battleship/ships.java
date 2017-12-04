package Battleship;
import Battleship.Result;
import javafx.scene.paint.Color;
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
public Rectangle rectangle(double w, int h) {
	Rectangle r = new Rectangle(w,h, Color.GREY);
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
}}
