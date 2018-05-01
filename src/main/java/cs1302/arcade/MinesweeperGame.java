package cs1302.arcade;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import java.util.Random;




public class MinesweeperGame extends Application {

	public static final int size = 40;
	public static final int rows = 10;
	public static final int cols = 10;
	public int mines = (int)Math.ceil(rows*cols*.10);
	public boolean hasMine = false;
	public int gameScore = 0;

	public Grid[][] grid = new Grid[rows][cols];

	public Pane display() {
		Pane root = new Pane();
		root.setPrefSize(600, 400);
		Random m = new Random ();
		Random s = new Random ();

		for(int y = 0; y < cols; y++) {
			for(int x = 0; x < rows; x++) {
				Grid main = new Grid(x, y, mines, hasMine);
				grid[x][y] = main;
				root.getChildren().add(main);
			}
		}
		for(int y = 0; y < cols; y++) {
			for(int x = 0; x < rows; x++) {
				for(int i = 0; i <mines; i++) {
					Grid main = grid[x][y];
					if (main.hasMine) {
						continue;
					}
								  
				}
			}
		}

		return root;
	}

    
	public class Grid extends StackPane {
		public boolean hasMine;
		public int x;
		public int y;

		public Rectangle border = new Rectangle(size -2, size -2);
		public Text text = new Text();

		public Grid(int x, int y, int mines, boolean hasMine) {
			this.x = x;
			this.y = y;

			border.setStroke(Color.BLUE);
			text.setText("");

			getChildren().addAll(border,text);
			setTranslateX(x*size);
			setTranslateY(y*size);


		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("File");
		MenuItem menuItem1 = new MenuItem("Exit");
		menuItem1.setOnAction(event -> stage.close());
		menu1.getItems().add(menuItem1);
		menuBar.getMenus().add(menu1);
		Label numOfMines = new Label();
		numOfMines.setText("Num of mines " + mines);
		Label score = new Label();
		score.setText("Score " + gameScore);
		Button newGame = new Button("New Game");
		newGame.setOnAction(event ->{
			display();
		});
		HBox bar = new HBox(score, newGame, numOfMines);
		VBox main1 = new VBox(menuBar,bar, display());
		Scene scene = new Scene(main1);
		bar.setSpacing(200);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
