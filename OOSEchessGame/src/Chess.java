import java.awt.*;

import javax.swing.*;

import java.util.ArrayList;

abstract public class Chess extends JButton {
	
	private String chessType;
	private Player owner;
	private int myX;
	private int myY;
	
	Chess(String chessType,Player owner){
	
		this.chessType =  chessType;
		this.owner = owner;
		this.setContentAreaFilled(false);//³z©ú«ö¶s
	   // this.setBorderPainted(false); //³z©ú«ö¶s®Ø
	}
	
	public String getChessType(){
		
		return chessType;		
	}
	
	public String getChessOwner(){
		
		return owner.getName();		
	}

	
	public void paintComponent(Graphics g) {	
		
		super.paintComponent(g);
		Image chessImg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("ChChess.png"));	
		g.drawImage( chessImg, 0, 0 ,null);
		g.drawString(getChessType(), 24, 34);
    }
	
}
