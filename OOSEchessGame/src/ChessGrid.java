public class ChessGrid {

	private Chess whoOn;	
	
	
	public String getChessType(){		
		if(whoOn == null)
		{
			return "¤f";
			
		}else{
			
			return whoOn.getChessType();
		}
							
	}	

	public Chess getChess(){		
		
		return whoOn;		
	}	
	
	public void setChess(Chess c){
		
		whoOn = c;		
	}
	
	public void removeChess(){
		
		whoOn = null;		
	}

	
}
