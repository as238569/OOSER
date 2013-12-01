import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

abstract public class ChessBoard extends JPanel implements MouseListener {
	

	private ChessGrid[][] board;
	private int maxX,maxY;
	protected Image boardImg;

	
	
	ChessBoard(int maxX,int maxY){
		this.maxX = maxX;
		this.maxY = maxY;

		board = new ChessGrid[maxX][maxY];		
		
		for(int x=0;x<maxX;x++)
		{
			for(int y=0;y<maxY;y++)
			{	
				board[x][y] = new ChessGrid();
			}
		}

	}
	
	public Chess getChess(int axisX ,int axisY){		
		
		return board[axisX][axisY].getChess();
	}
	
	public void setChess(int axisX ,int axisY ,Chess c){
		board[axisX][axisY].setChess(c);
	}
	
	public void removeChess(int axisX ,int axisY){
		board[axisX][axisY].removeChess();		
	}
	
	 public void paintComponent(Graphics g) {
		 
		 super.paintComponent(g);		 
		 Image boardImg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("ChChessBroad.jpg"));			 
		 g.drawImage(boardImg, 0, 0, null);
	 }
	 
	public String getTotalInfo(){
		
		String boardInfo = new String();
				
		
		for(int y=0;y<maxY;y++)
		{
			boardInfo = boardInfo+"\n";
			for(int x=0;x<maxX;x++)
			{
				
				boardInfo = boardInfo + board[x][y].getChessType();
			}
		}


		return boardInfo;
	}

	abstract public void newGameFactory(Player p1 ,Player p2);


	
	
}
