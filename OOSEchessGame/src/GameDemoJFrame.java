import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameDemoJFrame extends JFrame{
	
	private JButton gameJButton[];
	final static int numGame = 2;
	
	/**
	 * Launch the application.
	 */
	 GameDemoJFrame(){
		 setLayout(new GridLayout(1,2, 0, 0));
		 
		 gameJButton = new JButton[numGame];
		 setBounds(200, 200, 600, 300);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 gameJButton[0] = new JButton("­x´Ñ¹CÀ¸");
		 gameJButton[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChessGame Game = new ChessGame(new Player("Red  Test1","r"),new Player("Black  Test2","b"),new ChChessBoard());
				ChessGameJFrame frame = new ChChessGameJFrame("ChessGameGUI",Game);
				
				ChChessGameController GC = new ChChessGameController(Game,frame);					
				frame.setVisible(true);				
			}
		 } );
		 
		 gameJButton[1] = new JButton("·t´Ñ¹CÀ¸");
		 gameJButton[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChessGame Game = new ChessGame(new Player("Red  Test1","r"),new Player("Black  Test2","b"),new TwDarkChessBoard());
				ChessGameJFrame frame = new TwDarkChessGameJFrame("ChessGameGUI",Game);
				
				TwDarkChessGameController TGC = new TwDarkChessGameController(Game,frame);					
				frame.setVisible(true);						
			}
		 } );
		 
		 
		 for(int i=0 ; i< numGame; i++){
			 add(gameJButton[i]);
		 }
	 }	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*main*/								
					GameDemoJFrame frame = new GameDemoJFrame();				
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}