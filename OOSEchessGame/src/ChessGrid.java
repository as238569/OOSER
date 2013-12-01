import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ChessGrid extends JButton{

	private Chess whoOn;	
	
	ChessGrid(){		
		setLayout(null);
		this.setContentAreaFilled(false);//³z©ú«ö¶s
	    this.setBorderPainted(false); //³z©ú«ö¶s®Ø
	}
	
	public Chess getChess(){		
		
		return whoOn;		
	}	
	
	public void setChess(Chess c){
		
		whoOn = c;		
		add(c);
		c.setBounds(0 ,0 ,58,58); 
	}
	
	public void removeChess(){
		
		whoOn = null;		
	}

	public String getChessType(){		
		if(whoOn == null)
		{
			return "¤f";
			
		}else{
			
			return whoOn.getChessType();
		}
							
	}	
	
}
