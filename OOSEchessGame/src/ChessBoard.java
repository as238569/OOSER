import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.Observable;

import javax.swing.GroupLayout.Alignment;

abstract public class ChessBoard extends Observable {
	

	private ChessGrid[][] board;
	private int maxX,maxY;	
	
	ChessBoard(int maxX,int maxY){
		
		this.maxX = maxX;
		this.maxY = maxY;		
		
		board = new ChessGrid[maxY][maxX];		
		
		for(int y=0;y<maxY;y++)
		{
			for(int x=0;x<maxX;x++)
			{	
				board[y][x] = new ChessGrid(x,y);
			}
		}
	}
	
 	public ChessGrid[][] getBoard(){		
		
		return board;
	}
    
 	public ChessGrid getChessGrid(int axisX ,int axisY){		
		
		return board[axisY][axisX];
	}
 	
    public int getMaxX(){		
		
		return maxX;
	}
    
    public int getMaxY(){		
		
		return maxY;
	}
    
	public void setChess(int axisX ,int axisY ,Chess c){
		
		board[axisY][axisX].setChess(c);	
	}
	
	public void removeChess(int axisX ,int axisY){
		
		board[axisY][axisX].removeChess();		
	}
	

	abstract public void newGameFactory(Player p1 ,Player p2);
}
