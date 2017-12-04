package Battleship;
import java.util.Random;
import Battleship.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SetShips extends Application {
private Stage stage;
public final int board_size =16;
Cell[][] cell = new Cell [16][16];
final static ships[] ships;
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
	stage = primaryStage;
	Scene scene = StartGame1();
	primaryStage.setResizable(false);
	primaryStage.setTitle("battleship");
	primaryStage.setScene(scene);
	primaryStage.show();
}
public Scene StartGame1() {
	Pane root = new Pane();
	Button start = new Button("Start Player 1");
	start.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent t) {
			stage.setScene(placeShipsOnBoard());
		}});
	root.getChildren().add(start);
	return new Scene(root);
}

public Scene placeShipsOnBoard(){
	Random rnd = new Random();
	GridPane pane = new GridPane(), temp = new GridPane();
	Label instruction = new Label("Place ships:");
	Button b1 = new Button("Click for randomized ships");
	Button b2 = new Button("Done");
	HBox t = new HBox(instruction, b1, b2);
	for(int i =0; i<16; i++) {
		for (int j=0; j<16; j++) {
			pane.add(cell[i][j]=new Cell(), j, i);
		}}
	temp = pane;
	EventHandler<ActionEvent> again2 = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent z) {
			stage.setScene(placeShipsOnBoard());}};
	BorderPane edge = new BorderPane();
	edge.setCenter(pane);
	edge.setTop(t);
	Scene scene = new Scene(edge,640,640);
	b1.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent a) {
		int randRow, randCol, length;
		for(int i =0; i<5; i++) {
			length=ships[i].getSize();
			int randDirection = rnd.nextInt(2);
			if(randDirection == 1) {
				randRow = rnd.nextInt(16);
				randCol = rnd.nextInt(16-length);
				for(int j=randCol; j<randCol+length;j++) {
					pane.getChildren().remove(cell[randRow][j]);}
					pane.add(ships[i].rectangle(length*40, 40), randCol, randRow, length, 1);}
			else {
				randRow = rnd.nextInt(16-length);
				randCol = rnd.nextInt(16);
				for(int j=randRow; j<randRow+length;j++) {
				pane.getChildren().remove(cell[j][randCol]);}
				pane.add(ships[i].rectangle(40, length*40), randCol, randRow, 1, length);}}
		
				Button again = new Button("tryagain?");
				again.setOnAction(again2);
				t.getChildren().remove(b1);
				t.getChildren().add(1, again);
		}
	});
	b2.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent t) {
			stage.setScene(scene);
			stage.hide();}});


		return scene;
	}


public static void main(String[] args) {
	Application.launch(args);}
	
}


