
abstract public class ChessBoard {
	
	private ChessGrid[][] board;
	
	ChessBoard(int maxX,int maxY){
		
		board = new ChessGrid[maxX][maxY];
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
	
	abstract public ChessBoard getTotalInfo();

	abstract public void newGameFactory();
	
	
}
