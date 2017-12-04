package Battleship;

import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class humanPlayer implements Player {
private int hitsLeft = 17;

private int id;
private Board board;
private Scanner scanner;
public humanPlayer(int id) {
	this.id = id;
	this.board= new Board();
}
@Override
public void placeShips() {
SetShips p1b = new SetShips();
}

@Override
public void fireAt(Player opponent) {
	System.out.printf("Player %d chose your spot for the attack", id);
	
}


}
