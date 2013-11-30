
public class ChChessBoard extends ChessBoard  implements IBoardForMovChess{
	
	
	public ChChessBoard(){
		super(9,10);
	}
	
	public void moveChess(int oldAxisX , int oldAxisY , int newAxisX , int newAxisY ){		
       
		Chess c = super.getChess(oldAxisX,oldAxisY);        
		super.setChess(newAxisX,newAxisY,c);
		super.removeChess(oldAxisX,oldAxisY);	
		
	}
	
	public ChessBoard getTotalInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void newGameFactory() {
		// TODO Auto-generated method stub
		
	}





}
