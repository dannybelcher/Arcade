import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.*;
import javafx.scene.transform.*;
import javafx.scene.input.*;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.shape.*; 
import javafx.animation.*;
import javafx.scene.transform.Rotate;
import javafx.scene.paint.Color;
public class TetrisApp extends Application{
	
	public int score = 0;
	public int randPiece;
	public int numPiece;
	public int rotate = 0;
	public int time = 100;//used to make piece go faster
	public boolean isBottom;
	public boolean[][] grid = new boolean[10][24];//grid for checking pieces 
	public void start(Stage stage){
		
		Piece pH       = new Piece(0);
		Piece piece1   = new Piece(0);
		Piece piece2   = new Piece(0);
		Piece piece3   = new Piece(0);
		Piece piece4   = new Piece(0);
		
		GridPane gPane = new GridPane();//game board
			gPane.setStyle("-fx-background-color: DODGERBLUE");
		Random random  = new Random();
		pH.setRectColor(0);
		
		
		
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 24; j ++)
				gPane.add(new Piece(0), i, j);
		}
		
randPiece = random.nextInt(7) + 1;
		
		
		if (randPiece == 1){ //I block
			piece1.setRectColor(randPiece);
			piece2.setRectColor(randPiece);
			piece3.setRectColor(randPiece);
			piece4.setRectColor(randPiece);
			gPane.add(piece1, 0, 0);
			gPane.add(piece2, 1, 0);
			gPane.add(piece3, 2, 0);
			gPane.add(piece4, 3, 0);
		}
		if (randPiece == 2){//J block
			piece1.setRectColor(randPiece);
			piece2.setRectColor(randPiece);
			piece3.setRectColor(randPiece);
			piece4.setRectColor(randPiece);
			gPane.add(piece1, 0, 2);
			gPane.add(piece2, 1, 0);
			gPane.add(piece3, 1, 1);
			gPane.add(piece4, 1, 2);
		}
		if (randPiece == 3){//L block
			piece1.setRectColor(randPiece);
			piece2.setRectColor(randPiece);
			piece3.setRectColor(randPiece);
			piece4.setRectColor(randPiece);
			gPane.add(piece1, 0, 0);
			gPane.add(piece2, 1, 0);
			gPane.add(piece3, 1, 1);
			gPane.add(piece4, 1, 2);
		}
		if (randPiece == 4){//O block
			piece1.setRectColor(randPiece);
			piece2.setRectColor(randPiece);
			piece3.setRectColor(randPiece);
			piece4.setRectColor(randPiece);
			gPane.add(piece1, 0, 0);
			gPane.add(piece2, 1, 1);
			gPane.add(piece3, 0, 1);
			gPane.add(piece4, 1, 0);
		}
		if (randPiece == 5){//S block
			piece1.setRectColor(randPiece);
			piece2.setRectColor(randPiece);
			piece3.setRectColor(randPiece);
			piece4.setRectColor(randPiece);
			gPane.add(piece1, 0, 1);
			gPane.add(piece2, 0, 2);
			gPane.add(piece3, 1, 0);
			gPane.add(piece4, 1, 1);
		}
		if (randPiece == 6){//T block
			piece1.setRectColor(randPiece);
			piece2.setRectColor(randPiece);
			piece3.setRectColor(randPiece);
			piece4.setRectColor(randPiece);
			gPane.add(piece1, 0, 1);
			gPane.add(piece2, 1, 0);
			gPane.add(piece3, 1, 1);
			gPane.add(piece4, 1, 2);
		}
		if (randPiece == 7){//Z block
			piece1.setRectColor(randPiece);
			piece2.setRectColor(randPiece);
			piece3.setRectColor(randPiece);
			piece4.setRectColor(randPiece);
			gPane.add(piece1, 0, 0);
			gPane.add(piece2, 0, 1);
			gPane.add(piece3, 1, 1);
			gPane.add(piece4, 1, 2);
		}

		
		 Scene scene = new Scene(gPane);
		 
		 	Timeline timeline = new Timeline(
		 		    new KeyFrame(Duration.millis(time), e -> {
		 		    	
		 		    	 int stop = 23;
		 		    	 int p1Col = GridPane.getColumnIndex(piece1);
						 int p1Row = GridPane.getRowIndex(piece1);
						 int p2Col = GridPane.getColumnIndex(piece2);
						 int p2Row = GridPane.getRowIndex(piece2);
						 int p3Col = GridPane.getColumnIndex(piece3);
						 int p3Row = GridPane.getRowIndex(piece3);
						 int p4Col = GridPane.getColumnIndex(piece4);
						 int p4Row = GridPane.getRowIndex(piece4);
		 				
						randPiece = random.nextInt(7) + 1;
						
						Text scoreText = new Text("Score: "  + score);
							
						gPane.getChildren().removeAll(scoreText);
						gPane.add(scoreText, 17, 2);
		 				gPane.getChildren().removeAll(piece1,piece2,piece3,piece4);
		 				if (piece1.getRectColor() == 2 ||piece1.getRectColor() == 3 ||piece1.getRectColor() == 5 ||piece1.getRectColor() == 6 ||piece1.getRectColor() == 7 )
		 					stop = 22;
		 				if (piece1.getRectColor() == 1)
		 					stop = 24;
		 				while((p1Row + 1 < stop || p2Row + 1 < stop ||p3Row + 1 < stop||p4Row + 1 < stop)){
		 					isBottom= false;
		 				
//code for moving pieces around
		 					
		 					scene.setOnKeyPressed(i -> {
		 					     
		 					    if (i.getCode() == KeyCode.DOWN) {
		 					    	
		 					    }
		 					    if (i.getCode() == KeyCode.UP) {
		 					    	
		 					    	gPane.getChildren().removeAll(piece1,piece2,piece3,piece4);
		 					        System.out.println("A key was pressed");
		 					        if (randPiece == 1 && rotate == 0){
		 					        	rotate = 90;
		 					        	gPane.add(piece1, p1Col, p1Row);
		 					        	gPane.add(piece2, p2Col - 1, p2Row + 1);
		 					        	gPane.add(piece3, p3Col - 2, p3Row + 2);
		 					        	gPane.add(piece4, p4Col - 3, p4Row + 3);
		 					        }
		 					        if (randPiece == 2){
		 					        	gPane.add(piece1, p1Col, p1Row);
		 					        	gPane.add(piece2, p2Col, p2Row);
		 					        	gPane.add(piece3, p3Col, p3Row);
		 					        	gPane.add(piece4, p4Col, p4Row);
		 					        }
		 					        if (randPiece == 3){
		 					        	gPane.add(piece1, p1Col, p1Row);
		 					        	gPane.add(piece2, p2Col, p2Row);
		 					        	gPane.add(piece3, p3Col, p3Row);
		 					        	gPane.add(piece4, p4Col, p4Row);
		 					        }
		 					    	if (randPiece == 4){
		 					    		gPane.add(piece1, p1Col, p1Row);
		 					        	gPane.add(piece2, p2Col, p2Row);
		 					        	gPane.add(piece3, p3Col, p3Row);
		 					        	gPane.add(piece4, p4Col, p4Row);
		 					        }
		 					    	if (randPiece == 5){
		 					    		gPane.add(piece1, p1Col, p1Row);
		 					        	gPane.add(piece2, p2Col, p2Row);
		 					        	gPane.add(piece3, p3Col, p3Row);
		 					        	gPane.add(piece4, p4Col, p4Row);
		 					    	}
		 					    	if (randPiece == 6){
		 					    		gPane.add(piece1, p1Col, p1Row);
		 					        	gPane.add(piece2, p2Col, p2Row);
		 					        	gPane.add(piece3, p3Col, p3Row);
		 					        	gPane.add(piece4, p4Col, p4Row);
		 					    	}
		 					    	if (randPiece == 7){
		 					    		gPane.add(piece1, p1Col, p1Row);
		 					        	gPane.add(piece2, p2Col, p2Row);
		 					        	gPane.add(piece3, p3Col, p3Row);
		 					        	gPane.add(piece4, p4Col, p4Row);
		 					    	}
		 					       
		 					    }
		 					    if (i.getCode() == KeyCode.LEFT) {
		 					    	gPane.getChildren().removeAll(piece1,piece2,piece3,piece4);
		 					        System.out.println("A key was pressed");
		 					       //if out of bounds or touching another piece, player will not be able to move piece
		 					        if ((p1Col - 1 < 0 || p2Col - 1 < 0 ||p3Col - 1 < 0 ||p4Col - 1 < 0) || isBottom || (
		 					        grid[p1Col][p1Row]||
		 							grid[p2Col][p2Row] ||
		 							grid[p3Col][p3Row] ||
		 							grid[p4Col][p4Row])){
		 					        	gPane.add(piece1, p1Col, p1Row);
		 					        	gPane.add(piece2, p2Col, p2Row);
		 					        	gPane.add(piece3, p3Col, p3Row);
		 					        	gPane.add(piece4, p4Col, p4Row);
		 					        }
		 					        else{
		 					        gPane.add(piece1, p1Col - 1, p1Row);
		 							gPane.add(piece2, p2Col - 1, p2Row);
		 							gPane.add(piece3, p3Col - 1, p3Row);
		 							gPane.add(piece4, p4Col - 1, p4Row);
		 					        }
		 				        }
		 					    if (i.getCode() == KeyCode.RIGHT) {
		 					    	gPane.getChildren().removeAll(piece1,piece2,piece3,piece4);
		 					        System.out.println("A key was pressed");
		 					       //if out of bounds or touching another piece, player will not be able to move piece
		 					        if ((p1Col + 1 > 9 || p2Col + 1 > 9 ||p3Col + 1 > 9 ||p4Col + 1 > 9) || isBottom || (
				 					        grid[p1Col][p1Row]||
				 							grid[p2Col][p2Row] ||
				 							grid[p3Col][p3Row] ||
				 							grid[p4Col][p4Row])){
		 						        gPane.add(piece1, p1Col, p1Row);
		 								gPane.add(piece2, p2Col, p2Row);
		 								gPane.add(piece3, p3Col, p3Row);
		 								gPane.add(piece4, p4Col, p4Row);
		 						    }
		 					        else {
		 					        gPane.add(piece1, p1Col + 1, p1Row);
		 							gPane.add(piece2, p2Col + 1, p2Row);
		 							gPane.add(piece3, p3Col + 1, p3Row);
		 							gPane.add(piece4, p4Col + 1, p4Row);
		 					        }
		 				    }
		 					});
		 					if( grid[p1Col][p1Row] ||
				 				grid[p2Col][p2Row] ||
				 				grid[p3Col][p3Row] ||
				 				grid[p4Col][p4Row])
		 					{
		 					break;
		 					}
		 					
		 					gPane.add(piece1, p1Col, p1Row + 1);
		 					gPane.add(piece2, p2Col, p2Row + 1);
		 					gPane.add(piece3, p3Col, p3Row + 1);
		 					gPane.add(piece4, p4Col, p4Row + 1);
		 					
		 					System.out.println(p1Row + " " + p2Row + " " + p3Row + " " + p4Row + " ");
		 				
		 				}

//determines if piece is at bottom and adds it too the grid permanently 

		 				isBottom = true;
		 				grid[p1Col][p1Row] = true;
						grid[p2Col][p2Row] = true;
						grid[p3Col][p3Row] = true;
						grid[p4Col][p4Row] = true;
	 					gPane.add(new Piece(piece1.getRectColor()), p1Col, p1Row);
						gPane.add(new Piece(piece2.getRectColor()), p2Col, p2Row);
						gPane.add(new Piece(piece3.getRectColor()), p3Col, p3Row);
						gPane.add(new Piece(piece4.getRectColor()), p4Col, p4Row);
						gPane.getChildren().remove(scoreText);
						score += 50;
						scoreText.setFont(Font.font("Actor", FontWeight.BOLD, 10));
						scoreText.setFill(Color.LINEN);
						numPiece++;
						
//spawns a new piece
						
						if (randPiece == 1){ //I block
							piece1.setRectColor(randPiece);
							piece2.setRectColor(randPiece);
							piece3.setRectColor(randPiece);
							piece4.setRectColor(randPiece);
							gPane.add(piece1, 0, 0);
							gPane.add(piece2, 1, 0);
							gPane.add(piece3, 2, 0);
							gPane.add(piece4, 3, 0);
						}
						if (randPiece == 2){//J block
							piece1.setRectColor(randPiece);
							piece2.setRectColor(randPiece);
							piece3.setRectColor(randPiece);
							piece4.setRectColor(randPiece);
							gPane.add(piece1, 0, 2);
							gPane.add(piece2, 1, 0);
							gPane.add(piece3, 1, 1);
							gPane.add(piece4, 1, 2);
						}
						if (randPiece == 3){//L block
							piece1.setRectColor(randPiece);
							piece2.setRectColor(randPiece);
							piece3.setRectColor(randPiece);
							piece4.setRectColor(randPiece);
							gPane.add(piece1, 0, 0);
							gPane.add(piece2, 1, 0);
							gPane.add(piece3, 1, 1);
							gPane.add(piece4, 1, 2);
						}
						if (randPiece == 4){//O block
							piece1.setRectColor(randPiece);
							piece2.setRectColor(randPiece);
							piece3.setRectColor(randPiece);
							piece4.setRectColor(randPiece);
							gPane.add(piece1, 0, 0);
							gPane.add(piece2, 1, 1);
							gPane.add(piece3, 0, 1);
							gPane.add(piece4, 1, 0);
						}
						if (randPiece == 5){//S block
							piece1.setRectColor(randPiece);
							piece2.setRectColor(randPiece);
							piece3.setRectColor(randPiece);
							piece4.setRectColor(randPiece);
							gPane.add(piece1, 0, 1);
							gPane.add(piece2, 0, 2);
							gPane.add(piece3, 1, 0);
							gPane.add(piece4, 1, 1);
						}
						if (randPiece == 6){//T block
							piece1.setRectColor(randPiece);
							piece2.setRectColor(randPiece);
							piece3.setRectColor(randPiece);
							piece4.setRectColor(randPiece);
							gPane.add(piece1, 0, 1);
							gPane.add(piece2, 1, 0);
							gPane.add(piece3, 1, 1);
							gPane.add(piece4, 1, 2);
						}
						if (randPiece == 7){//Z block
							piece1.setRectColor(randPiece);
							piece2.setRectColor(randPiece);
							piece3.setRectColor(randPiece);
							piece4.setRectColor(randPiece);
							gPane.add(piece1, 0, 0);
							gPane.add(piece2, 0, 1);
							gPane.add(piece3, 1, 1);
							gPane.add(piece4, 1, 2);
						}
						
						System.out.println("END:" + p1Row + " " + p2Row + " " + p3Row + " " + p4Row + " ");
						time -= 10;
						
//line clear
						for (int i = 0; i < 24; i++){
							if(grid[0][i] && grid[1][i] 
							&& grid[2][i] && grid[3][i] 
							&& grid[4][i] && grid[5][i] 
							&& grid[6][i] && grid[7][i] 
							&& grid[8][i] && grid[9][i]){
								gPane.add(new Piece(0), 0, i);
								gPane.add(new Piece(0), 1, i);
								gPane.add(new Piece(0), 2, i);
								gPane.add(new Piece(0), 3, i);
								gPane.add(new Piece(0), 4, i);
								gPane.add(new Piece(0), 5, i);
								gPane.add(new Piece(0), 6, i);
								gPane.add(new Piece(0), 7, i);
								gPane.add(new Piece(0), 8, i);
								gPane.add(new Piece(0), 9, i);
								grid[0][i]  = false;
								grid[1][i]  = false;
								grid[2][i]  = false;
								grid[3][i]  = false;
								grid[4][i]  = false;
								grid[5][i]  = false;
								grid[6][i]  = false;
								grid[7][i]  = false;
								grid[8][i]  = false;
								grid[9][i]  = false;
						
							}
								
							}
						//changes to new window on loss						
						if(grid[0][0]){
							
							System.exit(0);
							
						}
		 		    })
		 		);
		 	
		 	timeline.setCycleCount(10000000);
		 		timeline.play();

		 		
	        stage.setTitle("TETRIS!");
	        stage.setScene(scene);

	        stage.setHeight(560);
	        stage.setWidth(320);

	        stage.show();

	}
	
	
		
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
	}

}
