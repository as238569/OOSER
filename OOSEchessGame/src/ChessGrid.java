public class ChessGrid {

	private Chess whoOn;	
	

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
