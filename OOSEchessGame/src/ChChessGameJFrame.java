
public class ChChessGameJFrame extends ChessGameJFrame{

    public ChChessGameJFrame(String title, ChessGame ObservableChessGame) {
		super(title, ObservableChessGame);
		// TODO Auto-generated constructor stub
		
		boardJPanel =new ChessBoardJPanel(ObservableChessGame.getChessBoard());
  	    boardJPanel.setBounds(343, 90, 612, 680);
	    getContentPane().add(boardJPanel);		
		
	}

}
