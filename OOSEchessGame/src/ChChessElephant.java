
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
		int movX = 0;
		int movY = 0;
		int smlY = 0,bigY = 0;
		if(super.getChessType() =="r"){
			smlY = 0;
			bigY = 4;
		}else{
			smlY = 5;
			bigY = 9;
		}
		
		movX = 2;
		movY = 2;
		if((thisX + movX <= maxX && thisX + movX >= 0) && (thisY + movY <= bigY && thisY + movY >= smlY)){
			if(board[thisY+movY/2][thisX+movX/2].getChess() == null ){
				if(board[thisY+movY][thisX+movX].getChess() != null ){
					if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner()){
						canMovTo[l] = board[thisY+movY][thisX+movX];
						l++;
		 	       }
				}else{
					canMovTo[l] = board[thisY+movY][thisX+movX];
					l++;
				}
			}
		}
		movX = 2;
		movY = -2;
		if((thisX + movX <= maxX && thisX + movX >= 0) && (thisY + movY <= bigY && thisY + movY >= smlY)){
			if(board[thisY+movY/2][thisX+movX/2].getChess() == null ){
				if(board[thisY+movY][thisX+movX].getChess() != null ){
					if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner()){
						canMovTo[l] = board[thisY+movY][thisX+movX];
						l++;
		 	       }
				}else{
					canMovTo[l] = board[thisY+movY][thisX+movX];
					l++;
				}
			}
		}
		movX = -2;
		movY = 2;
		if((thisX + movX <= maxX && thisX + movX >= 0) && (thisY + movY <= bigY && thisY + movY >= smlY)){
			if(board[thisY+movY/2][thisX+movX/2].getChess() == null ){
				if(board[thisY+movY][thisX+movX].getChess() != null ){
					if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner()){
						canMovTo[l] = board[thisY+movY][thisX+movX];
						l++;
		 	       }
				}else{
					canMovTo[l] = board[thisY+movY][thisX+movX];
					l++;
				}
			}
		}
		movX = -2;
		movY = -2;
		if((thisX + movX <= maxX && thisX + movX >= 0) && (thisY + movY <= bigY && thisY + movY >= smlY)){
			if(board[thisY+movY/2][thisX+movX/2].getChess() == null ){
				if(board[thisY+movY][thisX+movX].getChess() != null ){
					if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner()){
						canMovTo[l] = board[thisY+movY][thisX+movX];
						l++;
		 	       }
				}else{
					canMovTo[l] = board[thisY+movY][thisX+movX];
					l++;
				}
			}
		}
		return canMovTo;
	}

//	@Override
//	public String getChessType(){
//		
//		if(super.getChessType() =="r")
//		{
//			return "��";
//		}else{
//			return "�H";
//		}
//	}
}
