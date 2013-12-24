
public class TwDarkChessGameJFrame extends ChessGameJFrame{

    public TwDarkChessGameJFrame(String title, ChessGame ObservableChessGame) {
		super(title, ObservableChessGame);
		// TODO Auto-generated constructor stub
		
		boardJPanel =new ChessBoardJPanel(ObservableChessGame.getChessBoard());
  	    boardJPanel.setBounds(280, 205, 800, 450);
	    getContentPane().add(boardJPanel);		
		
	}
}
