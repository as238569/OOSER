import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ChessJLabel extends JLabel implements Observer{
	
	 private Chess  ObservableChess; 
	 private boolean select;
	 
	ChessJLabel(Chess ObservableChess){
	
		this. ObservableChess =  ObservableChess;
		ObservableChess.addObserver(this);			
	}
	


	@Override
	public void update(Observable obs, Object arg) {		
		// TODO Auto-generated method stub		
		
		if( arg != null && (boolean)arg == true ){			
			select = true;
		}else{
			select = false;
		}
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {			
		// TODO Auto-generated method stub
		
		super.paintComponent(g);

		Image selectImg = Toolkit.getDefaultToolkit().getImage("Select.png"); 
		Image chessImg;
		
		if(ObservableChess instanceof TwDarkChess){
			if(((TwDarkChess) ObservableChess).getDark() == true){
				
				chessImg = Toolkit.getDefaultToolkit().getImage("ChessDark.png");
			}else{
				
				chessImg = Toolkit.getDefaultToolkit().getImage(ObservableChess.getChessType().toUpperCase()+"_"+ObservableChess.getClass().getName()+".png");
			}			
			
		}else if(ObservableChess instanceof ChineseChess){
		
			chessImg = Toolkit.getDefaultToolkit().getImage(ObservableChess.getChessType().toUpperCase()+"_"+ObservableChess.getClass().getName()+".png");
			
		}else{
			chessImg = Toolkit.getDefaultToolkit().getImage("Erroe.png");
		}
		
		g.drawImage( chessImg, 0,  0, getWidth(), getHeight(),null);
		
		if(select == true){
			g.drawImage( selectImg, 0, 0 ,getWidth(),getHeight(),null);
		}
		
		
    }
			
}
