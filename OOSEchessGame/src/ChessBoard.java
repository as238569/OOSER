import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;

abstract public class ChessBoard extends JPanel {
	

	private ChessGrid[][] board;
	private int maxX,maxY;
	protected Image boardImg;

	
	
	ChessBoard(int maxX,int maxY,ChessGame game){
		
		this.maxX = maxX;
		this.maxY = maxY;
		
		setLayout(new GridLayout(maxY, maxX, 0, 0));
		
		
		board = new ChessGrid[maxY][maxX];		
		
		for(int y=0;y<maxY;y++)
		{
			for(int x=0;x<maxX;x++)
			{	
				board[y][x] = new ChessGrid(game,x,y);
				add(board[y][x]);
			}
		}
		addMouseListener(game);	
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
	
    public void removeRangeInfor(){
		
    	for(int y=0;y<maxY;y++)
		{
			for(int x=0;x<maxX;x++)
			{	
				board[y][x].setRangeInfor(false);
			}
		}		
	}
    
	public void paintComponent(Graphics g) {
		 
		 super.paintComponent(g);		 
		 Image boardImg = Toolkit.getDefaultToolkit().getImage("ChChessBroad.jpg");			 
		 g.drawImage(boardImg, 0, 0, null);
	}

	public String getTotalInfo(){
		
		String boardInfo = new String();
				
		
		for(int y=0;y<maxY;y++)
		{
			boardInfo = boardInfo+"\n";
			for(int x=0;x<maxX;x++)
			{
				
				boardInfo = boardInfo + board[y][x].getChessType();
			}
		}


		return boardInfo;
	}	


	abstract public void newGameFactory(Player p1 ,Player p2);
}
