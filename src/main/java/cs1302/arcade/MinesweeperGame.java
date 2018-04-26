package cs1302.arcade;

public class MinesweeperGame {
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




public class MinesweeperGame extends Application {

	private static final int size = 40;
	private static final int rows = 10;
	private static final int cols = 10;

	private Grid [][] grid = new Grid [rows][cols];

	private Pane display() {
		Pane root = new Pane();
		root.setPrefSize(600, 400);

		for(int y = 0; y < cols; y++) {
			for(int x = 0; x < rows; x++) {
				Grid main = new Grid(x, y);
				grid[x][y] = main;
				root.getChildren().add(main);
			}
		}

		return root;
	}

	private class Grid extends StackPane {
		private int x;
		private int y;

		private Rectangle border = new Rectangle(size -2, size -2);
		private Text text = new Text();

		public Grid(int x, int y) {
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
		numOfMines.setText("Num of Mines");
		Label score = new Label();
		score.setText("Score");
		Button newGame = new Button("New Game");
		newGame.setOnAction(event ->{
			//new game button code here
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
