
public class ChChessRook extends  ChineseChess{


	ChChessRook(String chessType,Player owner) {
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
		
		
		for(int x=thisX; x == thisX ||(x < maxX) && (board[thisY][x].getChess() == null) ; ) //東方移動判斷
		{ 
			
		     x++;
		     if(x < maxX ){  
				 if( board[thisY][x].getChess() != null ){
					 if( this.getOwner() != board[thisY][x].getChess().getOwner())
					 {
					     canMovTo[l] = board[thisY][x];
			    	     l++;
					 }
				 }
				 else
				 {
					 canMovTo[l] = board[thisY][x];
			    	 l++;
				 }
		     }
		}		
		
		for(int x=thisX; x == thisX || (x >= 0) &&( board[thisY][x].getChess() == null) ;)//西方移動判斷
		{	
			
			 x--;
			 if(x >= 0 ){
				 if( board[thisY][x].getChess() != null ){
					 if( this.getOwner() != board[thisY][x].getChess().getOwner())
					 {
					     canMovTo[l] = board[thisY][x];
			    	     l++;
					 }
				 }
				 else
				 {
					 canMovTo[l] = board[thisY][x];
			    	 l++;
				 }
		     }
		}

		for(int y=thisY; y == thisY ||(y < maxY) &&(board[y][thisX].getChess() == null) ;)//南方移動判斷
		{	
		     y++;
		     if(y < maxY){ 
				 if( board[y][thisX].getChess() != null ){
					 if( this.getOwner() != board[y][thisX].getChess().getOwner())
					 {
					     canMovTo[l] = board[y][thisX];
			    	     l++;
					 }
				 }
				 else
				 {
					 canMovTo[l] = board[y][thisX];
			    	 l++;
				 }
		     }
		}		
		
		for(int y=thisY; y == thisY ||(y >= 0) &&(board[y][thisX].getChess() == null) ;)//北方移動判斷	
		{			
			 y--;
			 if(y >= 0){
				 if( board[y][thisX].getChess() != null ){
					 if( this.getOwner() != board[y][thisX].getChess().getOwner())
					 {
					     canMovTo[l] = board[y][thisX];
			    	     l++;
					 }
				 }
				 else
				 {
					 canMovTo[l] = board[y][thisX];
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
			return "俥";
		}else{
			return "車";
		}
	}
}
