import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class ChessGrid extends JButton{

	private Chess whoOn;	
	
	ChessGrid(ChessBoard board){		
		
		setLayout(null);//Layout for Chess
		this.setContentAreaFilled(false);//透明按鈕
	    this.setBorderPainted(false); //透明按鈕框		
		addMouseListener(board);
	}
	
	public Chess getChess(){		
		
		return whoOn;		
	}	
	
	public void setChess(Chess c){
		
		whoOn = c;		
		add(c);
		c.setBounds(0 ,0 ,999,999); //在整個ChessGrid以填滿的方式蓋上Chess
	}
	
	public void removeChess(){
		
		if(whoOn != null)
		{
			System.out.println("removeChess");
			remove(whoOn);
			this.repaint(); //remove後並不會馬上反映薪畫面於按鈕上 ,需移到按鈕上方才能刷新,因此這裡直接要求刷新
			whoOn = null;
		}
	}

	public String getChessType(){		
		
		if(whoOn == null)
		{
			return "口";
			
		}else{
			
			return whoOn.getChessType();
		}							
	}	
	
	
}
