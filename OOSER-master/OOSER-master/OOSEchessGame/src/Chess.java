import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.util.ArrayList;

abstract public class Chess extends JLabel {
	
	private String chessType;
	private Player owner;
	private int Power;
	
	Chess(String chessType,Player owner){
	
		this.chessType =  chessType;
		this.owner = owner;
	}
	Chess(String chessType,Player owner,int Power){
		
		this.chessType =  chessType;
		this.owner = owner;
		this.Power = Power;
	}
	
	public String getChessType(){
		
		return chessType;		
	}
	
	public Player getOwner(){
		
		return owner;		
	}
	public int getPower(){
		
		return Power;		
	}


	
	public void paintComponent(Graphics g) {	
		
		super.paintComponent(g);
		Image chessImg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("ChChess.png"));	
		g.drawImage( chessImg, 0, 0 ,null);
		g.drawString(getChessType(), 24, 34);
    }
		

	
}