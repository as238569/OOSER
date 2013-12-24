
public class ChChessCannon extends  ChineseChess{

	ChChessCannon(String chessType,Player owner) {
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
		int x;
		int y;
		/*-----------------------------�F�貾�ʧP�_	---------------------------*/
		for(x=thisX+1;(x < maxX) &&(board[thisY][x].getChess() == null) ;x++)
		{						
			canMovTo[l] = board[thisY][x];
			l++;			
		}
		if((x < maxX) &&(board[thisY][x].getChess() !=null))//�F��Y�I�P�_	
		{
			for(x=x+1;(x < maxX) &&(board[thisY][x].getChess() == null) ;x++)
			{
			}
			if((x < maxX) &&(board[thisY][x].getChess() != null)&&(board[thisY][x].getChess().getOwner() != this.getOwner()))
			{
			    canMovTo[l] = board[thisY][x];
			    l++;
			}
		}
		/*-----------------------------��貾�ʧP�_	---------------------------*/
		for(x=thisX-1;(x >= 0) &&(board[thisY][x].getChess() == null) ;x--)	
		{						
			canMovTo[l] = board[thisY][x];
			l++;			
		}			
		if((x >= 0) &&(board[thisY][x].getChess() !=null))//���Y�I�P�_	
		{
			for(x=x-1;(x >= 0) &&(board[thisY][x].getChess() == null) ;x--)
			{

			}
			if((x >= 0) &&(board[thisY][x].getChess() != null)&&(board[thisY][x].getChess().getOwner() != this.getOwner()))
			{
			    canMovTo[l] = board[thisY][x];
			    l++;
			}
		}
		
		/*-----------------------------�n�貾�ʧP�_	---------------------------*/
		for(y=thisY+1;(y < maxY) &&(board[y][thisX].getChess() == null) ;y++)
		{						
			canMovTo[l] = board[y][thisX];
			l++;			
		}
		
		if((y < maxY) &&(board[y][thisX].getChess() !=null))//�n��Y�I�P�_	
		{
			for(y=y+1;(y < maxY) &&(board[y][thisX].getChess() == null) ;y++)
			{
				
			}
			if((y < maxY) &&(board[y][thisX].getChess()!= null)&&(board[y][thisX].getChess().getOwner() != this.getOwner()))
			{
			    canMovTo[l] = board[y][thisX];
			    l++;
			}
		}
		
		/*-----------------------------�_�貾�ʧP�_	---------------------------*/
		for(y=thisY-1;(y >= 0) &&(board[y][thisX].getChess() == null) ;y--)//�_�貾�ʧP�_	
		{						
			canMovTo[l] = board[y][thisX];
			l++;			
		}	
		if((y >= 0) &&(board[y][thisX].getChess() !=null))//�_��Y�I�P�_	
		{
			for(y=y-1;(y >= 0) &&(board[y][thisX].getChess() == null) ;y--)
			{

			}
			if((y >= 0) &&(board[y][thisX].getChess()!= null)&&(board[y][thisX].getChess().getOwner() != this.getOwner()))
			{
			    canMovTo[l] = board[y][thisX];
			    l++;
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
//			return "�]";
//		}
//	}

}
