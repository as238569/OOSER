import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class RoundMarkerJLabel extends JLabel implements Observer{
	
	private Player ObservablePlayer;
	private String MarkerSide;

	RoundMarkerJLabel(Player ObservablePlayer, String MarkerSide){
		this.ObservablePlayer = ObservablePlayer;
		ObservablePlayer.addObserver(this);			
		this.MarkerSide = MarkerSide;
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub		
	
        repaint();        
	}
	
	@Override
	public void paintComponent(Graphics g) {			
		// TODO Auto-generated method stub
		
		super.paintComponent(g);
		Image RoundMarkerImg ;
		
		if(ObservablePlayer.getState()==1){
			
			RoundMarkerImg = Toolkit.getDefaultToolkit().getImage(MarkerSide+"_RoundMarker.png");			
			g.drawImage( RoundMarkerImg, 0,  0, getWidth(), getHeight(),null);
		}else{
			
			RoundMarkerImg =  Toolkit.getDefaultToolkit().getImage("Wait_RoundMarker.png");			
			g.drawImage( Toolkit.getDefaultToolkit().getImage("Wait_RoundMarker.png"), 0,  0, getWidth(), getHeight(),null);
		}
    }
}