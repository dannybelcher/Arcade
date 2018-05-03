import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

public class ArcadeApp extends Application {


    @Override
    public void start(Stage stage) {

	Button tbutton = new Button("Tetris");
	tbutton.setOnAction( e -> 
		{
			 Platform.runLater(new Runnable() {
			       public void run()
			       {
			           new TetrisApp().start(new Stage());
			       }       
			      								});
		});
	Button cbutton = new Button("Checkers");
	cbutton.setOnAction( e -> 
		{
			 Platform.runLater(new Runnable() {
			       public void run()
			       {
			           new CheckersApp().start(new Stage());
			       }       
			      								});
		});
	
	BorderPane borderPane = new BorderPane();
	
	borderPane.setRight(tbutton);
	borderPane.setLeft(cbutton);

        Scene scene = new Scene(borderPane);

        stage.setTitle("Arcade");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    } // start

    public static void main(String[] args) {
	
	    Application.launch(args);
    }
}