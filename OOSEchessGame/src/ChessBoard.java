
abstract public class ChessBoard {
	
	private ChessGrid[][] board;
	int maxX;
	int maxY;
	
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
