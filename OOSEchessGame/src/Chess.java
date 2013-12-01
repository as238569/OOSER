import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

abstract public class Chess extends JLabel {
	private String chessType;
	private Player owner;
	
	Chess(String chessType,Player owner){
		
		this.chessType =  chessType;
		this.owner = owner;
		
	}
	
	public String getChessType(){
		
		return chessType;		
	}
	
	public String getChessOwner(){
		
		return owner.getName();		
	}

	public void paint(Graphics g) {     
		super.paint(g);
		Image chessImg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("ChChess.jpg"));	
		g.drawImage( chessImg, 0, 0, null);
		
		g.drawString(chessType, 0, 0);
		((Graphics2D)g).setStroke(new BasicStroke(2.3f));
		((Graphics2D)g).drawOval(2, 2, 0, 0);

    }
	
	
}
