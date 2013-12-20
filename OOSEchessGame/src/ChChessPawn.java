
public class ChChessPawn extends  ChineseChess{

	ChChessPawn(String chessType,Player owner) {
		super(chessType, owner);
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
		
		if(super.getChessType() =="r"){
			movY = 1;
		}else{
			movY = -1;
		}
		if(Crossriver(thisY)){
			System.out.println("YES");
			movY = setSide();
			if((thisX + movX <= maxX && thisX + movX >= 0) && (thisY + movY <= maxY && thisY + movY >= 0)){
				if(board[thisY+movY][thisX].getChess() != null ){
					if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner()){
						canMovTo[l] = board[thisY+movY][thisX+movX];
						l++;
		 	       }
				}else{
					canMovTo[l] = board[thisY+movY][thisX+movX];
					l++;	
				}
				
			}
		
			movY = 0;
			movX = 1;
			if((thisX + movX <= maxX && thisX + movX >= 0) && (thisY + movY <= maxY && thisY + movY >= 0)){
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
			movX = -1;
			if((thisX + movX <= maxX && thisX + movX >= 0) && (thisY + movY <= maxY && thisY + movY >= 0)){
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
		}else{
			if((thisX + movX <= maxX && thisX + movX >= 0) && (thisY + movY <= maxY && thisY + movY >= 0)){
				if(board[thisY+movY][thisX].getChess() != null ){
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
	
	@Override
	public String getChessType(){
		
		if(super.getChessType() =="r")
		{
			return "§L";
		}else{
			return "¨ò";
		}
	}
	public boolean Crossriver(int y){
		
		if(super.getChessType() =="r")
		{
			if (y > 4) return true;
			else return false;
		}else{
			if (y <= 4) return true;
			else return false;
		}	
	}
	public int setSide(){
		if(super.getChessType() =="r"){
			return 1;
		}else{
			return -1;
		}
	}

}
