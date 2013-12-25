import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TwDarkChessGameController implements ActionListener {

	private ChessGame gameModel;
	private ChessGameJFrame gameView;

	private int clickStap;
	private ChessGrid selectGrid;
	private boolean isChessBind;

	TwDarkChessGameController(ChessGame gameModel, ChessGameJFrame gameView) {

		this.gameModel = gameModel;
		this.gameView = gameView;
		gameView.addActionListener(this);
		isChessBind = false;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object obj = e.getSource();

		if (obj instanceof ChessGridJButton) {

			ChessGridJButton clickGridJButton = (ChessGridJButton) obj;
			ChessGrid clickGrid = (ChessGrid) clickGridJButton.getObservable();
			Chess clickChess = (TwDarkChess) clickGrid.getChess(); // ®³ºX¤l

			if (clickStap == 1) {

				if(clickGrid == selectGrid && ((TwDarkChess)selectGrid.getChess()).getDark() == true){

					if(isChessBind == false){
						
						if(selectGrid.getChess().getChessType().equals("r")){
							((TwDarkChessBoard)gameModel.getChessBoard()).bindOwner(gameModel.getRoundPlayer(),"r");
							((TwDarkChessBoard)gameModel.getChessBoard()).bindOwner(gameModel.getNotRoundPlayer(),"b");
							
						}else{
						    ((TwDarkChessBoard)gameModel.getChessBoard()).bindOwner(gameModel.getRoundPlayer(), "b");
						    ((TwDarkChessBoard)gameModel.getChessBoard()).bindOwner(gameModel.getNotRoundPlayer(),"r");
						}
						 isChessBind = true;						
					}
					
					((TwDarkChess)selectGrid.getChess()).setOpen();
					System.out.println("Trun Open");
					selectGrid.getChess().setSelect(false);	
					gameModel.turnRound();
					
				}else{		
					/*-----------------check the new click whether in range or not---------------*/
					ChessGrid rangeInfo[] = ((TwDarkChess) selectGrid.getChess()).getMovableRange(gameModel.getChessBoard());
					boolean inTheRange = false;
	
					int i = 0;
					while (rangeInfo[i] != null) {
	
						if (clickGrid == rangeInfo[i]) {
							inTheRange = true;
						}
						i++;
					}
					/*-----------------check the new click whether in range or not--------------*/
	
					if (inTheRange)// if new click in the MovableRange
					{


						System.out.println("move OR eat");
						gameView.recordAppend("move OR eat\n");
						selectGrid.getChess().setSelect(false);	
						((TwDarkChessBoard) (gameModel.getChessBoard())).moveChess(selectGrid, clickGrid);
						gameModel.turnRound();
						
						/*--------------------------check  for win--------------------------------*/
						if(((TwDarkChessBoard)gameModel.getChessBoard()).checkDieAll(gameModel.getRoundPlayer()) == true){
						    JFrame gameOverJFrame = new JFrame ("Game is over!"); 			
							TextField tf = new TextField("Player: "+gameModel.getNotRoundPlayer().getName()+"  Win!");
							if(clickChess.getChessType() == "b"){
							    tf.setForeground(Color.red);
							}
							JButton bt = new JButton("OK");
							bt.addActionListener(new ActionListener() { 
						          public void actionPerformed(ActionEvent e) {
						        	  gameView.dispose(); 					        	 
						          } 
						     } ); 
							
							gameOverJFrame.setLayout(new BorderLayout());
							gameOverJFrame.add(tf, BorderLayout.NORTH);
							gameOverJFrame.add(bt, BorderLayout.SOUTH);	
							gameOverJFrame.setSize(300, 100);
							gameOverJFrame.setLocationRelativeTo(null);
							gameOverJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
							gameOverJFrame.setVisible(true); 	
						}

						/*-------------------------------------------------------------------------*/
					} else {
							// cancel MovableRange
							System.out.println("cancel");
							gameView.recordAppend("cancel\n");
							selectGrid.getChess().setSelect(false);	
					}		
					(gameView.getChessBoardJPanel()).removeRangeInfo();
			    } 
				
				selectGrid = null;
				clickStap = 0;
				
			} else if (clickStap == 0) {
				if (clickChess != null) // ClickChess
				{
					if (((TwDarkChess) clickChess).getDark() == true || clickChess.getOwner().getState() == 1) {
						System.out.println("select");
						gameView.recordAppend("select\n");
						selectGrid = clickGrid;
						selectGrid.getChess().setSelect(true);
						clickStap++;

						/*-----------------print MovableRange----------------*/
						if (((TwDarkChess) clickChess).getDark() == false) {
							ChessGrid rangeInfo[] = ((TwDarkChess) selectGrid.getChess()).getMovableRange(gameModel.getChessBoard());
							(gameView.getChessBoardJPanel()).setRangeInfo(rangeInfo);
						}
						/*-----------------print MovableRange----------------*/
						
					} else {
						System.out.println("Not your Round !!");
						gameView.recordAppend("Not your Round !!\n");
						// cancel MovableRange
						clickStap = 0;
					}
				}
			}
		}		
	}
	

}
