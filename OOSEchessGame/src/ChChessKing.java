
public class ChChessKing extends  ChineseChess {


	ChChessKing(String chessType,Player owner) {
		super(chessType, owner );

	}

	@Override
	public ChessGrid[] getMovableRange(ChessBoard boardInfor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getChessType(){
		
		if(super.getChessType() =="r")
		{
			return "«Ó";
		}else{
			return "±N";
		}
	}
	
}
