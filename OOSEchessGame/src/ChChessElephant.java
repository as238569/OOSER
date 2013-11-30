
public class ChChessElephant extends  ChineseChess{

	ChChessElephant(String chessType, Player owner) {
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
			return "¬Û";
		}else{
			return "¶H";
		}
	}
}
