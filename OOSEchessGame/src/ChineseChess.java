import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public abstract class ChineseChess extends Chess implements IMovableChess{

	ChineseChess(String chessType,Player owner) {
		
		super(chessType, owner);
	}
	
	public ChessGrid[] getMovableRange(ChessBoard boardInfor){
		return null;
	}

}
