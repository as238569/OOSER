public abstract class TwDarkChess extends Chess implements IMovableChess{

	private int rank;
	private boolean dark;
	
	TwDarkChess(String chessType) {
		
		super(chessType);
		dark = true;
	}
	
	public void setRank(int rank){
		this.rank=rank;
	}
			
	public boolean getDark(){
		return dark;
	}
	
	public int getRank(){
		return rank;
	}
	
	public void setOpen(){
		dark = false;
		setChanged();
		notifyObservers();		
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
		
		//東方移動判斷
		int x = thisX+1;
		int y = thisY ;		
		if(x < maxX)
		{
			if(board[y][x].getChess() == null){
				
				canMovTo[l] = board[y][x];
	    	    l++;
			}
			else if(((TwDarkChess)board[y][x].getChess()).getDark() == false && ((TwDarkChess)board[y][x].getChess()).getOwner() != this.getOwner()){
				if(((TwDarkChess)board[y][x].getChess()).getRank() <= ((TwDarkChess)board[thisY][thisX].getChess()).getRank()){
					
					canMovTo[l] = board[y][x];
		    	    l++;
				}
			}
		}
		
		//西方移動判斷
		x = thisX-1;
		y = thisY ;		
		if(x >= 0)
		{
			if(board[y][x].getChess() == null){
				
				canMovTo[l] = board[y][x];
	    	    l++;
			}
			else if(((TwDarkChess)board[y][x].getChess()).getDark() == false && ((TwDarkChess)board[y][x].getChess()).getOwner() != this.getOwner()){
				if(((TwDarkChess)board[y][x].getChess()).getRank() <= ((TwDarkChess)board[thisY][thisX].getChess()).getRank()){
					
					canMovTo[l] = board[y][x];
		    	    l++;
				}
			}
		}

		//南方移動判斷
		
		x = thisX;
		y = thisY+1;		
		if(y < maxY)
		{
			if(board[y][x].getChess() == null){
				
				canMovTo[l] = board[y][x];
	    	    l++;
			}
			else if(((TwDarkChess)board[y][x].getChess()).getDark() == false && ((TwDarkChess)board[y][x].getChess()).getOwner() != this.getOwner()){
				if(((TwDarkChess)board[y][x].getChess()).getRank() <= ((TwDarkChess)board[thisY][thisX].getChess()).getRank()){
					
					canMovTo[l] = board[y][x];
		    	    l++;
				}
			}
		}

		//北方移動判斷	
		
		x = thisX;
		y = thisY-1;		
		if(y >= 0)
		{
			if(board[y][x].getChess() == null){
				
				canMovTo[l] = board[y][x];
	    	    l++;
			}
			else if(((TwDarkChess)board[y][x].getChess()).getDark() == false && ((TwDarkChess)board[y][x].getChess()).getOwner() != this.getOwner()){
				if(((TwDarkChess)board[y][x].getChess()).getRank() <= ((TwDarkChess)board[thisY][thisX].getChess()).getRank()){
					
					canMovTo[l] = board[y][x];
		    	    l++;
				}
			}
		}

		
		return canMovTo;
	}

}
