import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class ChChessGameJFrame extends ChessGameJFrame{

    public ChChessGameJFrame(String title, ChessGame ObservableChessGame) {
		super(title, ObservableChessGame);
		// TODO Auto-generated constructor stub
		
		boardJPanel =new ChessBoardJPanel(ObservableChessGame.getChessBoard());
  	    boardJPanel.setBounds(343, 90, 612, 680);
	    getContentPane().add(boardJPanel);	
	    
	    //¤å¦r®Ø
	    JTextArea record = new JTextArea();
    	JScrollPane scroll = new JScrollPane(record);
    	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	getContentPane().add(scroll);
    	scroll.setBounds(1000, 90, 200, 680);
	}

}
