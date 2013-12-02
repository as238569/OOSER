import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public abstract class ChineseChess extends Chess implements IMovableChess{

	ChineseChess(String chessType,Player owner) {
		super(chessType, owner);
		// TODO Auto-generated constructor stub
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub		
	    	 	          
	}	
	
	public ChessGrid[] getMovableRange(ChessBoard boardInfor){
		return null;
		
	}


}
