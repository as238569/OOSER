import java.util.Observable;

public class Player extends Observable{
	
	private String Pname;
	private String side;
	private int state;
		
	
	Player(String name,int state){
		this.Pname = name;
		this.state = state ;
	}
	Player(String name ,String side){
		this.Pname = name;
		this.side = side;
		
		if(side == "r"){
			this.state = 1;
		}else{
			this.state = 0;
		}
	}
	
	public void setName(String Pname){
		this.Pname = Pname;
	}

	
	public String getName(){
		return Pname;
	}
	public String getSide(){
		return side;
	}	
	public void setSide(String side){
		
		this.side = side;
	}	 
	
	public void setState(int state){
		this.state = state;
		setChanged();
		notifyObservers();
	}
	
	public int getState(){
		return state;
	}
	


}
