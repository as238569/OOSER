
public class Player {
	
	private String Pname;
	private int state;
		
	
	Player(String name){
		this.Pname = name;
		state = 1 ;
	}
	
	public void setName(String Pname){
		this.Pname = Pname;
	}

	
	public String getName(){
		return Pname;
	}
	
	
	public void setState(int state){
		this.state = state;
	}
	
	public int getState(){
		return state;
	}
	


}
