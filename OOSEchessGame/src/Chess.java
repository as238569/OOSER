
abstract public class Chess {
	private String chessType;
	private Player owner;
	
	Chess(String chessType,Player owner){
		
		this.chessType =  chessType;
		this.owner = owner;
		
	}
	
	public String getChessType(){
		
		return chessType;		
	}
	
	public Player getOwner(){
		
		return new Player(owner.getName());		
	}


}
