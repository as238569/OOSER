
public class ChChessElephant extends  ChineseChess{

	ChChessElephant(String chessType,Player owner) {
		super(chessType, owner );
		// TODO Auto-generated constructor stub
	}

	@Override
	public ChessGrid[] getMovableRange(ChessBoard boardInfor) {
		
		// TODO Auto-generated method stub
		ChessGrid[] canMovTo;
		int l = 0;
		ChessGrid[][]  board =  boardInfor.getBoard();
		int maxX = boardInfor.getMaxX();
		int maxY = boardInfor.getMaxY();
		int thisX=0;
		int thisY=0;     
		canMovTo = new ChessGrid[maxX*maxY];
		
		/*----------------------*find this chess in which ChessGrid---------------------------*/
		for(int y=0; y< maxY ;y++){
			
			for(int x=0; x< maxX; x++){
				
				if(this == board[y][x].getChess()){
					thisX=x;
					thisY=y;
				}					
			}			
		}
		/*-------------------------------------------------------------------------------------*/
		
		return canMovTo;
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
