package Battleship;
import Battleship.Result;
public class ships {
private final String name;
private final int size;
private static int Lives;
private class shipSize {
	final int Carrier = 5;
	final int Battleship = 4;
	final int Cruiser = 3;
	final int Submarine = 3;
	final int Destroyer = 2;
}
public ships(String ann) {
	this.name=ann;
	this.Lives=shipSize.ann;}
public static void hit() {
	if(Lives > 0) {
		System.out.printf("You got a hit... Congrats");
	}
	else {
		System.out.println("WOW You destroyed the ship");
	}
}
public static Result State() {
	if (Lives ==0) {
		return Result.DESTROYED;
	}
	else {
		return Result.PARTIAL_HIT;
	}}}
