package Battleship;
import java.util.Random;

import Battleship.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Board extends Application {
public final int board_size =16;
private BorderPane edge;
private GridPane pane;
private char whoseturn = 1;
private static Cell[][] cell = new Cell [16][16];
private static Label lblStatus = new Label("Player 1 turn");
private static final ships[] ships;
public VBox ship = new VBox(5);
static {
	ships = new ships[] {
		new ships("Carrier", shipSize.Carrier),//makes the kind of ships we want to place
		new ships("Battleship", shipSize.Battleship),
		new ships("Cruiser", shipSize.Cruiser),
		new ships("Submarine", shipSize.Submarine),
		new ships("Destroyer", shipSize.Destroyer)
		};}

public class Cell extends Pane{
public Cell() {
	setStyle("-fx-border-color:black");//makes the border of the boxes black
	this.setPrefSize(2000, 2000);}
}

@Override
public void start(Stage primaryStage) {
pane = new GridPane();
for(int i =0; i<16; i++) {
	for (int j=0; j<16; j++) {
		pane.add(cell[i][j]=new Cell(), j, i);
	}}
	placeShipsOnBoard();
	edge = new BorderPane();
	edge.setCenter(pane);
	edge.setTop(lblStatus);
	
	Scene scene = new Scene(edge,600,600);
	primaryStage.setTitle("battleship");
	primaryStage.setScene(scene);
	primaryStage.show();
}
public void placeShipsOnBoard(){
	Label instruction = new Label("Place ships on Board, to change orientation press Arrow key, when finished press done.");
		int randRow;
		int randCol;
		int length;
		Random rnd = new Random();
		for(int i =0; i<5; i++) {
		length=ships[i].getSize();
		int randDirection = rnd.nextInt(2);
		if(randDirection == 1) {
			randRow = rnd.nextInt(16);
			randCol = rnd.nextInt(16-length);
			for(int j=randCol; j<randCol+length;j++) {
			pane.getChildren().remove(cell[randRow][j]);}
			pane.getChildren().add(ships[i].rectangle(length, 1));
			pane.add(ships[i].rectangle(length, 1), randCol, randRow, length, 1);
			
		}
		else {
			randRow = rnd.nextInt(16-length);
			randCol = rnd.nextInt(16);
			for(int j=randRow; j<randRow+length;j++) {
				pane.getChildren().remove(cell[j][randCol]);}
				pane.getChildren().add(ships[i].rectangle(1, length));
				pane.add(ships[i].rectangle(pane.getMaxWidth()*length, 1), randCol, randRow, 1, length);
		}}
	}

public static void main(String[] args) {
	Application.launch(args);}
	
}


