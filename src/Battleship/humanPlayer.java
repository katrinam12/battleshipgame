package Battleship;

import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class humanPlayer implements Player, EventHandler<ActionEvent> {
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
	board.placeShipsOnBoard();
	
}
@Override
public void fireAt(Player opponent) {
	System.out.printf("Player %d chose your spot for the attack", id);
	
}
@Override
public void handle(ActionEvent event) {
	// TODO Auto-generated method stub
	
}
}
