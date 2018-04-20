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


public class MinesweeperRules {
	
	public static void display() {
		Stage window = new Stage();
		Image image = new Image("https://upload.wikimedia.org/wikipedia/en/3/31/Minesweeper_XP.png");
		ImageView imageView = new ImageView(image);
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Minesweeper Rules");
		window.setMinWidth(400);
		window.setMinHeight(400);
		Label label = new Label();
		label.setText("Rules provided via wikipedia.com");
		String words = 
		"The player is initially presented with a grid of undifferentiated squares. \n" +
		"Some randomly selected squares are designated to contain mines. \n" +
		"The game is played by revealing squares of the grid by clicking on each square. \n" +
		"If a square containing a mine is revealed, the player loses the game. \n" +
		"If no mine is revealed a digit is instead dispalyed in the square. \n" +
		"This digit indicates how many adjacent squares contain mines. \n" +
		"If no mines are adjacent, the square becomes blank, and all adjacent squares will be revealed. \n" + 
		"When all mines have been located the game is won.";
		
				
				
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

