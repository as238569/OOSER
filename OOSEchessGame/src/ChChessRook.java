
public class ChChessRook extends  ChineseChess{

	ChChessRook(String chessType,Player owner) {
		super(chessType, owner );
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] getMovableRange(ChessBoard boardInfor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getChessType(){
		
		if(super.getChessType() =="r")
		{
			return "俥";
		}else{
			return "車";
		}
	}
}
