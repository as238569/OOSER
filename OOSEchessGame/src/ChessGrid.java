import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class ChessGrid extends JButton{

	private Chess whoOn;	
	
	ChessGrid(ChessBoard board){		
		
		setLayout(null);//Layout for Chess
		this.setContentAreaFilled(false);//�z�����s
	    this.setBorderPainted(false); //�z�����s��		
		addMouseListener(board);
	}
	
	public Chess getChess(){		
		
		return whoOn;		
	}	
	
	public void setChess(Chess c){
		
		whoOn = c;		
		add(c);
		c.setBounds(0 ,0 ,999,999); //�b���ChessGrid�H�񺡪��覡�\�WChess
	}
	
	public void removeChess(){
		
		if(whoOn != null)
		{
			System.out.println("removeChess");
			remove(whoOn);
			this.repaint(); //remove��ä��|���W�ϬM�~�e������s�W ,�ݲ�����s�W��~���s,�]���o�̪����n�D��s
			whoOn = null;
		}
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
