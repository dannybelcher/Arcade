import javafx.scene.shape.*; 
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
public class Piece extends Rectangle{
	
	public int rectColor = 0;
	
	public Piece(int i){
		setWidth(20);
		setHeight(20);
		setArcWidth(5);
		setArcHeight(5);
		
		setStyle("-fx-stroke: black;");
		setRectColor(i);
		
		}//constructor
	public void setRectColor(int i){
		if (i == 0){
			setFill(Color.GRAY);
			rectColor = i;}
		if(i == 1)//I block
			{setFill(Color.MEDIUMTURQUOISE);
			rectColor = i;}
		if(i == 2)//J block
			{setFill(Color.BLUE);
			rectColor = i;}
		if(i == 3)//L block
			{setFill(Color.DARKORANGE);
			rectColor = i;}
		if(i == 4)//O block
			{setFill(Color.GOLD);
			rectColor = i;}
		if(i == 5)//S block
			{setFill(Color.LIMEGREEN);
			rectColor = i;}
		if(i == 6)//T block
			{setFill(Color.DARKVIOLET);
			rectColor = i;}
		if(i == 7)//Z block
			{setFill(Color.RED);
			rectColor = i;}
	}//
	public int getRectColor(){
		return rectColor;
	}//
	public static Piece getPiece(GridPane gPane, int col, int row){
		Piece piece = new Piece(0);
		for(int i = 0; i < 24; i ++ ){
			for(int j = 0; j < 10; j ++){
				if (gPane.getColumnIndex(piece) == col && gPane.getRowIndex(piece) == row){
					return piece;
				}
				}
			}
		return piece;
		}
		
	}
	
