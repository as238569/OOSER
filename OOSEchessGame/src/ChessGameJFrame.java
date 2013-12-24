import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class ChessGameJFrame extends JFrame  implements  Observer{
	
	private ChessGame ObservableChessGame;
    protected  ChessBoardJPanel boardJPanel;
	private JLabel nameJLabelR;
	private JLabel nameJLabelB;
	private RoundMarkerJLabel MarkerJLabelR;
	private RoundMarkerJLabel MarkerJLabelB;
	
     public ChessGameJFrame(String title,ChessGame ObservableChessGame) {
    	super(title); 
		setBounds(100, 100, 1400, 900);
		getContentPane().setLayout(null);			
		
		this.ObservableChessGame = ObservableChessGame;
    	ObservableChessGame.addObserver(this);  
    	
    	
	    
	    /*--------------------------------------------------*/
	    MarkerJLabelR = new RoundMarkerJLabel(ObservableChessGame.getPlayer1());
	    MarkerJLabelR.setBounds(785, 11, 70, 70);
	    getContentPane().add(MarkerJLabelR);
	    
	    MarkerJLabelB = new RoundMarkerJLabel(ObservableChessGame.getPlayer2());
	    MarkerJLabelB.setBounds(477, 781, 70, 70);
	    getContentPane().add(MarkerJLabelB);
	    
	    nameJLabelR = new JLabel( ObservableChessGame.getPlayer1().getName());
	    nameJLabelR.setBounds(890, 25, 100, 20);
	    nameJLabelR.setBackground(Color.WHITE);
	    nameJLabelR.setOpaque(true);
	    getContentPane().add( nameJLabelR);
	    
	    nameJLabelB = new JLabel(ObservableChessGame.getPlayer2().getName());
	    nameJLabelB.setBounds(343, 791, 100, 20);
	    nameJLabelB.setBackground(Color.WHITE);
	    nameJLabelB.setOpaque(true);
	    getContentPane().add(nameJLabelB);
		/*----------------------------------------------------*/		
	}     
     
    public void addActionListener(ActionListener l){
    	 boardJPanel.addActionListener(l);
 	} 
    
    public ChessBoardJPanel getChessBoardJPanel() {
    	return boardJPanel;
    }
     
 	@Override
 	public void update(Observable obs, Object arg) {
 		// TODO Auto-generated method stub
 		
 		repaint();
 	}
}
