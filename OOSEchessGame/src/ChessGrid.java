import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ChessGrid extends JButton{

	private Chess whoOn;	
	
	ChessGrid(){		
		setLayout(null);
		this.setContentAreaFilled(false);//�z�����s
	    this.setBorderPainted(false); //�z�����s��
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
			return "�f";
			
		}else{
			
			return whoOn.getChessType();
		}
							
	}	
	
}
