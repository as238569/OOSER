import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class RoundMarkerJLabel extends JLabel implements Observer{
	
	private Player ObservablePlayer;
	

	RoundMarkerJLabel(Player ObservablePlayer){
		this.ObservablePlayer = ObservablePlayer;
		ObservablePlayer.addObserver(this);		
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
		Image RoundMarkerImg = Toolkit.getDefaultToolkit().getImage(ObservablePlayer.getSide().toUpperCase()+"_RoundMarker.png");
		if(ObservablePlayer.getState()==1){
			
			g.drawImage( RoundMarkerImg, 0,  0, getWidth(), getHeight(),null);
		}
    }
}