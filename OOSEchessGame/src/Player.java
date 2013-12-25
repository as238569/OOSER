import java.util.Observable;

public class Player extends Observable{
	
	private String name;
	private int state;
		
	
	Player(String name,int state){
		this.name = name;
		this.state = state ;
	}
	Player(String name ,String side){
		this.name = name;
		
		if(side == "r"){
			this.state = 1;
		}else{
			this.state = 0;
		}
	}
	
	public void setName(String pname){
		this.name = pname;
	}

	
	public String getName(){
		return name;
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
