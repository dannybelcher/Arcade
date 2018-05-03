import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class CheckersApp extends Application {
	public Tile[][] checkerBoard = new Tile[width][height];
	public static final int size = 40;
	public static final int width = 8;
	public static final int height = 8;
	public int sqr = 0;
	public Group tGroup = new Group();
	public Group pGroup = new Group();
	public enum mType {
		none, pieceM, jump
	}//mType
	public enum PieceType {
		player1(-1), player2(1);
		int direction;
		PieceType(int direction) {
			this.direction = direction;
		}
	}//PieceType

	public Pane display() {
		Pane root = new Pane();
		root.setPrefSize(320, 320);
		root.getChildren().addAll(tGroup, pGroup);

		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				Tile tile = new Tile((y + x) % 2 == 0, y, x);
				checkerBoard[y][x] = tile;

				tGroup.getChildren().add(tile);

				Piece piece = null;
				//puts player2 pieces on cjeckerboard
				if (x <= 2 && (y + x) % 2 != 0) {
					piece = makePiece(PieceType.player2, y, x);
				}
				//puts player1 pieces on checkerboard
				if (x >= 5 && (x + y) % 2 != 0) {
					piece = makePiece(PieceType.player1, y, x);
				}

				if (piece != null) {
					tile.setPiece(piece);
					pGroup.getChildren().add(piece);
				}
			}
		}

		return root;
	}//display
	
	public int checkerBoardPos(int sqr) {
		sqr = (sqr + size / 2) / size;
		return sqr;
	}

	public class Piece extends StackPane {

		double moveX;
		double moveY;
		double prevX;
		double prevY;
		PieceType type;

		public PieceType getType() {
			return type;
		}//getType

		public double getPrevX() {
			return prevX;
		}//getPrevX

		public double getPrevY() {
			return prevY;
		}//getPrevY

		public Piece(PieceType type, int y, int x) {
			this.type = type;

			move(y, x);

			Circle Circle = new Circle(13);

			if(type == PieceType.player1) {
				Circle.setFill(javafx.scene.paint.Color.RED);
			}//if
			else {
				Circle.setFill(javafx.scene.paint.Color.GREY);
			}//else

			Circle.setTranslateX(10);
			Circle.setTranslateY(5);

			getChildren().addAll(Circle);

			setOnMousePressed(e -> {
				moveX = e.getSceneX();
				moveY = e.getSceneY();
			});

			setOnMouseDragged(e -> {
				relocate(e.getSceneX() - moveX + prevX, e.getSceneY() - moveY + prevY);
			});
		}

		public void move(int y, int x) {
			prevX = y * 40;
			prevY = x * 40;
			relocate(prevX, prevY);
		}//move

		public void noM() {
			relocate(prevX, prevY);
		}//noM
	}//piece

	public class Tile extends Rectangle {

		Piece piece;

		public boolean hasPiece() {
			return piece != null;
		}//hasPiece

		public Piece getPiece() {
			return piece;
		}//getPiece

		public void setPiece(Piece piece) {
			this.piece = piece;
		}//setPiece

		public Tile(boolean whiteTiles, int y, int x) {
			setWidth(40);
			setHeight(40);
			relocate(y * 40, x *40);
			setFill(whiteTiles ? javafx.scene.paint.Color.WHITE : javafx.scene.paint.Color.BLACK);
		}
	}//tile
	public class mResult {
		Piece piece;
		mType type;

		public mType getType() {
			return type;
		}
		public Piece getPiece() {
			return piece;
		}
		public mResult(mType type) {
			this(type, null);
		}
		public mResult(mType type, Piece piece) {
			this.type = type;
			this.piece = piece;
		}
	}//mResult
	public mResult tMove(Piece piece, int posX, int posY) {
		int m = checkerBoardPos((int) piece.getPrevX());
		int s = checkerBoardPos((int) piece.getPrevY());

		if (checkerBoard[posX][posY].hasPiece() || (posX + posY) % 2 == 0) {
			return new mResult(mType.none);
		}
		if (Math.abs(posX - m) == 1 && posY - s == piece.getType().direction) {
			return new mResult(mType.pieceM);
		} 
		else if (Math.abs(posX - m) == 2 && posY - s == piece.getType().direction * 2) {
			int newM = m + (posX - m) / 2;
			int newS = s + (posY - s) / 2;
			if (checkerBoard[newM][newS].hasPiece() && checkerBoard[newM][newS].getPiece().getType() != piece.getType()) {
				return new mResult(mType.jump, checkerBoard[newM][newS].getPiece());
			}
		}
		return new mResult(mType.none);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("File");
		MenuItem menuItem1 = new MenuItem("Exit");
		menuItem1.setOnAction(event -> primaryStage.close());
		menu1.getItems().add(menuItem1);
		menuBar.getMenus().add(menu1);
		Button newGame = new Button("New Game");
		newGame.setOnAction(event ->{

		});
		HBox bar = new HBox(newGame);
		VBox main1 = new VBox(menuBar,bar, display());
		Scene scene = new Scene(main1);
		primaryStage.setTitle("American Checkers");
		primaryStage.setScene(scene);
		primaryStage.show();
	}//start

	public Piece makePiece(PieceType type, int y, int x) {
		Piece piece = new Piece(type, y, x);
		//moves pieces around after mouse release
		piece.setOnMouseReleased(e -> {
			int m = checkerBoardPos((int) piece.getPrevX());
			int s = checkerBoardPos((int) piece.getPrevY());
			int posX = checkerBoardPos((int) piece.getLayoutX());
			int posY = checkerBoardPos((int) piece.getLayoutY());
			mResult result;

			if (posX < 0 || posX >= width || posY < 0 || posY >= height) {
				result = new mResult(mType.none);
			} 
			else {
				result = tMove(piece, posX, posY);
			}
			if(result.getType()== mType.none) {
				piece.noM();
			}
			if(result.getType()== mType.pieceM) {
				piece.move(posX, posY);
				checkerBoard[m][s].setPiece(null);
				checkerBoard[posX][posY].setPiece(piece);
			}
			//removes piece on jump
			if(result.getType()== mType.jump) {
				piece.move(posX, posY);
				Piece oPiece = result.getPiece();
				checkerBoard[m][s].setPiece(null);
				checkerBoard[posX][posY].setPiece(piece);
				checkerBoard[checkerBoardPos((int) oPiece.getPrevX())][checkerBoardPos((int) oPiece.getPrevY())].setPiece(null);
				pGroup.getChildren().remove(oPiece);
			}
		});
		return piece;
	}//makePiece

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Application.launch(args);
		} catch (UnsupportedOperationException e) {
			System.out.println(e);
			System.err.println("If this is a DISPLAY problem, then your X server connection");
			System.err.println("has likely timed out. This can generally be fixed by logging");
			System.err.println("out and logging back in.");
			System.exit(1);
		} // try
	}//main
}//checkersapp
