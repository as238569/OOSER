
public class ChChessKnight extends  ChineseChess{

	ChChessKnight(String chessType,Player owner) {
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
				
				movX = 2;
				if( thisX+movX < maxX && board[thisY][thisX+1].getChess() == null ) //東方移動判斷
				{ 
					movY = 1;
					if(thisY+movY < maxY )
					{
				        if( board[thisY+movY][thisX+movX].getChess()!= null )
				        {  
				    	    if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner())
				    	    {
				    	       canMovTo[l] = board[thisY+movY][thisX+movX];
				    	       l++;
				    	    }
				        }
				        else
				        {
				    	    canMovTo[l] = board[thisY+movY][thisX+movX];
				    	    l++;
				        }
					 }
					movY = -1;
					if(thisY+movY >= 0 )
					{
				        if( board[thisY+movY][thisX+movX].getChess()!= null )
				        {  
				    	    if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner())
				    	    {
				    	       canMovTo[l] = board[thisY+movY][thisX+movX];
				    	       l++;
				    	    }
				        }
				        else
				        {
				    	    canMovTo[l] = board[thisY+movY][thisX+movX];
				    	    l++;
				        }
					}

				}		
				
				movX = -2;				
				if( thisX+movX >= 0 && board[thisY][thisX-1].getChess() == null ) //西方移動判斷
				{ 
					movY = 1;
					if(thisY+movY < maxY )
					{
				        if( board[thisY+movY][thisX+movX].getChess()!= null )
				        {  
				    	    if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner())
				    	    {
				    	       canMovTo[l] = board[thisY+movY][thisX+movX];
				    	       l++;
				    	    }
				        }
				        else
				        {
				    	    canMovTo[l] = board[thisY+movY][thisX+movX];
				    	    l++;
				        }
					 }
					movY = -1;
					if(thisY+movY >= 0 )
					{
				        if( board[thisY+movY][thisX+movX].getChess()!= null )
				        {  
				    	    if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner())
				    	    {
				    	       canMovTo[l] = board[thisY+movY][thisX+movX];
				    	       l++;
				    	    }
				        }
				        else
				        {
				    	    canMovTo[l] = board[thisY+movY][thisX+movX];
				    	    l++;
				        }
				    }
				}		
				
				movY = 2;				
				if( thisY+movY < maxY && board[thisY+1][thisX].getChess() == null ) //南方移動判斷
				{ 
					movX = 1;
					if(thisX+movX < maxX )
					{
				        if( board[thisY+movY][thisX+movX].getChess()!= null )
				        {  
				    	    if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner())
				    	    {
				    	       canMovTo[l] = board[thisY+movY][thisX+movX];
				    	       l++;
				    	    }
				        }
				        else
				        {
				    	    canMovTo[l] = board[thisY+movY][thisX+movX];
				    	    l++;
				        }
					 }
					movX = -1;
					if(thisX+movX >= 0 )
					{
				        if( board[thisY+movY][thisX+movX].getChess()!= null )
				        {  
				    	    if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner())
				    	    {
				    	       canMovTo[l] = board[thisY+movY][thisX+movX];
				    	       l++;
				    	    }
				        }
				        else
				        {
				    	    canMovTo[l] = board[thisY+movY][thisX+movX];
				    	    l++;
				        }
				    }
				}		
				
				movY = -2;				
				if( thisY+movY >= 0 && board[thisY-1][thisX].getChess() == null ) //北方移動判斷
				{ 
					movX = 1;
					if(thisX+movX < maxX )
					{
				        if( board[thisY+movY][thisX+movX].getChess()!= null )
				        {  
				    	    if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner())
				    	    {
				    	       canMovTo[l] = board[thisY+movY][thisX+movX];
				    	       l++;
				    	    }
				        }
				        else
				        {
				    	    canMovTo[l] = board[thisY+movY][thisX+movX];
				    	    l++;
				        }
					 }
					movX = -1;
					if(thisX+movX >= 0 )
					{
				        if( board[thisY+movY][thisX+movX].getChess()!= null )
				        {  
				    	    if(board[thisY+movY][thisX+movX].getChess().getOwner() != this.getOwner())
				    	    {
				    	       canMovTo[l] = board[thisY+movY][thisX+movX];
				    	       l++;
				    	    }
				        }
				        else
				        {
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
			return "傌";
		}else{
			return "馬";
		}
	}

}
