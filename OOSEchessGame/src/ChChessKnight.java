
public class ChChessKnight extends  ChineseChess{

	ChChessKnight(String chessType, Player owner) {
		super(chessType, owner);
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
			return "ØX";
		}else{
			return "°¨";
		}
	}

}
