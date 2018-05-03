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


public class CheckersRules {
	
	public static void display() {
		Stage window = new Stage();
		Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Draughts.svg/220px-Draughts.svg.png");
		ImageView imageView = new ImageView(image);
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Checkers Rules");
		window.setMinWidth(400);
		window.setMinHeight(400);
		Label label = new Label();
		label.setText("Rules provided via wikipedia.com");
		String words = 
		"Each player stars with pieces on their side of the board \n" +
		"A simple move consists of moving a piece one square diagonally. \n" +
		"You can move pieces forward only. \n" +
		"A jump consists of moving a piece over the oposing players piece. \n" +
		"After you jump a piece you remove the jumped piece from the board. \n" +
		"The player who loses all their pieces first loses the game.";
		
				
				
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

