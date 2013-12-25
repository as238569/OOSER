public class TwDarkChessKing extends  TwDarkChess{

	TwDarkChessKing(String chessType) {
		super(chessType);
		super.setRank(6);
	}
	public ChessGrid[] getMovableRange(ChessBoard boardInfor){
		
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
		if(this.getDark()){
			
		}else{
			//�F�貾�ʧP�_
			int x = thisX+1;
			int y = thisY ;		
			if(x < maxX)
			{
				if(board[y][x].getChess() == null){
					
					canMovTo[l] = board[y][x];
		    	    l++;
				}
				else if(((TwDarkChess)board[y][x].getChess()).getDark() == false){
					if(((TwDarkChess)board[y][x].getChess()).getRank() <= ((TwDarkChess)board[thisY][thisX].getChess()).getRank() && ((TwDarkChess)board[y][x].getChess()).getRank() != 0 
					    && ((TwDarkChess)board[y][x].getChess()).getOwner() != this.getOwner()){
						
						canMovTo[l] = board[y][x];
			    	    l++;
					}
				}
			}
			
			//��貾�ʧP�_
			x = thisX-1;
			y = thisY ;		
			if(x >= 0)
			{
				if(board[y][x].getChess() == null){
					
					canMovTo[l] = board[y][x];
		    	    l++;
				}
				else if(((TwDarkChess)board[y][x].getChess()).getDark() == false){
					if(((TwDarkChess)board[y][x].getChess()).getRank() <= ((TwDarkChess)board[thisY][thisX].getChess()).getRank() && ((TwDarkChess)board[y][x].getChess()).getRank() != 0
						&& ((TwDarkChess)board[y][x].getChess()).getOwner() != this.getOwner()){
						
						canMovTo[l] = board[y][x];
			    	    l++;
					}
				}
			}

			//�n�貾�ʧP�_
			
			x = thisX;
			y = thisY+1;		
			if(y < maxY)
			{
				if(board[y][x].getChess() == null){
					
					canMovTo[l] = board[y][x];
		    	    l++;
				}
				else if(((TwDarkChess)board[y][x].getChess()).getDark() == false){
					if(((TwDarkChess)board[y][x].getChess()).getRank() <= ((TwDarkChess)board[thisY][thisX].getChess()).getRank() && ((TwDarkChess)board[y][x].getChess()).getRank() != 0
						&& ((TwDarkChess)board[y][x].getChess()).getOwner() != this.getOwner()){
						
						canMovTo[l] = board[y][x];
			    	    l++;
					}
				}
			}

			//�_�貾�ʧP�_	
			
			x = thisX;
			y = thisY-1;		
			if(y >= 0)
			{
				if(board[y][x].getChess() == null){
					
					canMovTo[l] = board[y][x];
		    	    l++;
				}
				else if(((TwDarkChess)board[y][x].getChess()).getDark() == false){
					if(((TwDarkChess)board[y][x].getChess()).getRank() <= ((TwDarkChess)board[thisY][thisX].getChess()).getRank() && ((TwDarkChess)board[y][x].getChess()).getRank() != 0
						&& ((TwDarkChess)board[y][x].getChess()).getOwner() != this.getOwner()){
						
						canMovTo[l] = board[y][x];
			    	    l++;
					}
				}
			}
		}
		return canMovTo;
	}
}