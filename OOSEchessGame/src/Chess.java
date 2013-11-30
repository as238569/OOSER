
abstract public class Chess {
	private String chessType;
	private Player owner;
	
	public String getChessType(){
		
		return chessType;		
	}
	
	public Player getOwner(){
		
		return new Player(owner.getName());		
	}


}
