import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class ChChessGameJFrame extends ChessGameJFrame{

    public ChChessGameJFrame(String title, ChessGame ObservableChessGame) {
    	
		super(title, ObservableChessGame);		
		boardJPanel =new ChessBoardJPanel(ObservableChessGame.getChessBoard());
  	    boardJPanel.setBounds(343, 90, 612, 680);
	    getContentPane().add(boardJPanel);	
	    
	    
	}

}
