package cs1302.arcade;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class TetrisRules {
	
	public static void display() {
		Stage window = new Stage();
		Image image = new Image("https://upload.wikimedia.org/wikipedia/en/8/8d/NES_Tetris_Box_Front.jpg");
		ImageView imageView = new ImageView(image);
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Tetris Rules");
		window.setMinWidth(400);
		window.setMinHeight(400);
		Label label = new Label();
		label.setText("Rules provided via wikipedia.com");
		String words = 
		"Tetriminos are game pieces shaped like tetrominoes. \n" +
		"Tetrominoes are geometric shapes composed of four square blocks. \n" +
		"A random sequence of Tetriminos fall down the playing field. \n" +
		"The objective of the game is to manipulate these Tetriminos. \n" +
		"The player can do this by moving each one sideways or rotating it by 90 degrees. \n" +
		"The aim of creating a horizontal line without gaps. \n" +
		"When such a line is created, it gets destroyed. \n" + 
		"Any block above the deleted line will fall. \n" +
		"When a certain number of lines are cleared, the game enters a new level.";
		
				
				
		Label label3 = new Label(words);
	    label3.setWrapText(true);

		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("File");
		MenuItem menuItem1 = new MenuItem("Exit");
		menuItem1.setOnAction(event -> window.close());
		menu1.getItems().add(menuItem1);
		menuBar.getMenus().add(menu1);
		
		VBox layout = new VBox();
		HBox box = new HBox(label3, imageView);
		layout.getChildren().addAll(menuBar, box,label);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
}

