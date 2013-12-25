public class TwDarkChessCannon extends  TwDarkChess{

	TwDarkChessCannon(String chessType) {
		super(chessType);
		super.setRank(1);
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
				int x;
				int y;
				//東方移動判斷
				x = thisX+1;
				y = thisY;	
				if(x < maxX){										//移動
					if(board[y][x].getChess() == null){
						canMovTo[l] = board[y][x];
						l++;
					}
				}			
				if((x < maxX) &&(board[thisY][x].getChess() !=null))//東方吃點判斷	
				{
					for(x=x+1;(x < maxX) &&(board[thisY][x].getChess() == null) ;x++)
					{
					}
					if((x < maxX) &&(board[y][x].getChess() != null)&&(board[y][x].getChess().getOwner() != this.getOwner())&&(((TwDarkChess)board[y][x].getChess()).getDark() == false))
					{
					    canMovTo[l] = board[thisY][x];
					    l++;
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
				}
				if((x >= 0) &&(board[thisY][x].getChess() !=null))//西方吃點判斷	
				{
					for(x=x-1;(x >= 0) &&(board[thisY][x].getChess() == null) ;x--)
					{
		
					}
					if((x >= 0) &&(board[thisY][x].getChess() != null)&&(board[thisY][x].getChess().getOwner() != this.getOwner())&&(((TwDarkChess)board[y][x].getChess()).getDark() == false))
					{
					    canMovTo[l] = board[thisY][x];
					    l++;
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
				}
				if((y < maxY) &&(board[y][thisX].getChess() !=null))//南方吃點判斷	
				{
					for(y=y+1;(y < maxY) &&(board[y][thisX].getChess() == null) ;y++)
					{
						
					}
					if((y < maxY) &&(board[y][thisX].getChess()!= null)&&(board[y][thisX].getChess().getOwner() != this.getOwner())&&(((TwDarkChess)board[y][x].getChess()).getDark() == false))
					{
					    canMovTo[l] = board[y][thisX];
					    l++;
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
				}
				if((y >= 0) &&(board[y][thisX].getChess() !=null))//北方吃點判斷	
				{
					for(y=y-1;(y >= 0) &&(board[y][thisX].getChess() == null) ;y--)
					{
		
					}
					if((y >= 0) &&(board[y][thisX].getChess()!= null)&&(board[y][thisX].getChess().getOwner() != this.getOwner())&&(((TwDarkChess)board[y][x].getChess()).getDark() == false))
					{
					    canMovTo[l] = board[y][thisX];
					    l++;
					}
				}
			}
			return canMovTo;
		}
}