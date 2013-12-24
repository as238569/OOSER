import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.Observable;

public class ChessGrid extends Observable{

	private Chess whoOn;	
	private int x;
	private int y;
	
	ChessGrid(int x, int y){		
		
		this.x = x;
		this.y = y;
	}
	
	public Chess getChess(){		
		
		return whoOn;		
	}	
	

	public int getX(){		
		
		return x;		
	}	

	public int getY(){		
		
		return y;		
	}	
	public void setChess(Chess c){
		
		whoOn = c;		
		setChanged(); 
        notifyObservers(whoOn); 
	}
	
	public void removeChess(){
		
		if( whoOn != null){
			
	        whoOn = null;
	        setChanged(); 
	        notifyObservers(whoOn); 			
		}
	}
	
	
	public String getChessType(){		
		
		if(whoOn == null)
		{
			return "-";
			
		}else{
			
			return whoOn.getChessType();
		}							
	}	
	
	
}
