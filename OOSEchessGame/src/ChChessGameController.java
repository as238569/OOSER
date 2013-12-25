import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observer;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ChChessGameController implements ActionListener{
	
	private ChessGame gameModel;
	private ChessGameJFrame gameView;

	private int clickStap ;
	private ChessGrid selectGrid;	
	
	ChChessGameController(ChessGame gameModel,ChessGameJFrame gameView){
		
		this.gameModel = gameModel;
		this.gameView = gameView;
		gameView.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

 		Object obj = e.getSource();
 		
 		if(obj instanceof ChessGridJButton){
 			ChessGridJButton  clickGridJButton = (ChessGridJButton)obj;  
 			ChessGrid clickGrid = (ChessGrid)clickGridJButton.getObservable();
 			Chess clickChess = (ChineseChess)clickGrid.getChess();  //®³ºX¤l
 			
 			if( clickStap == 1 )
 			{
 				/*-----------------check the new click whether in range or not---------------*/
 				ChessGrid rangeInfo[] = ((ChineseChess)selectGrid.getChess()).getMovableRange(gameModel.getChessBoard());
 				boolean inTheRange = false; 
 				
 				int i=0;		
 			    while(rangeInfo[i] != null){

 				    	if(clickGrid == rangeInfo[i])
 				      	{
 				    		inTheRange = true;
 				    	}	
 			    	i++;
 				}
 			    /*-----------------check the new click whether in range or not--------------*/
 			    
 				if(inTheRange)//if new click in the MovableRange
 				{
 					/*------------------------------king die---------------------------------------*/
 					if(clickChess instanceof ChChessKing){
 						JFrame gameOverJFrame = new JFrame ("Game is over!"); 			
 						TextField tf = new TextField("Player: "+gameModel.getRoundPlayer().getName()+"  Win!");
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
 					/*-----------------------------------------------------------------------------*/
 					
 					System.out.println("move OR eat");
 					gameView.recordAppend("move OR eat\n");
 					selectGrid.getChess().setSelect(false);
 					((ChChessBoard)(gameModel.getChessBoard())).moveChess(selectGrid , clickGrid);
 					gameModel.turnRound();
 					
 					
 					/*--------------------------check-for check--------------------------------*/
 					rangeInfo = ((ChineseChess)clickGrid.getChess()).getMovableRange(gameModel.getChessBoard());
 					
 	 				i=0;		
 	 			    while(rangeInfo[i] != null){

 	 				    	if(rangeInfo[i].getChess() instanceof ChChessKing )
 	 				      	{
 	 				    		JFrame CheckJFrame = new JFrame ("Check!!"); 						
 	 	 						TextField tf = new TextField("Check!!");

 	 	 						CheckJFrame.setLayout(new BorderLayout());
 	 	 						CheckJFrame.add(tf, BorderLayout.NORTH);
 	 	 						CheckJFrame.setSize(300, 100);
 	 	 						CheckJFrame.setLocationRelativeTo(null);
 	 	 						CheckJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
 	 	 						CheckJFrame.setVisible(true);
 	 				    	}	
 	 			    	i++;
 	 				}
 					
 					
 					/*-------------------------------------------------------------------------*/
					
 				}else{
 					System.out.println("cancel");
 					gameView.recordAppend("cancel\n");
 					selectGrid.getChess().setSelect(false);
 				}
 				
 				//cancel MovableRange
				(gameView.getChessBoardJPanel()).removeRangeInfo();
				selectGrid = null;
				clickStap = 0;
 			}
 			else if(clickStap == 0)
 			{
 				if( clickChess != null ) //ClickChess
 				{				
 					if( clickChess.getOwner().getState() == 1  )
 					{
 						System.out.println("select");
 						gameView.recordAppend("select\n");
 						selectGrid = clickGrid;
 						selectGrid.getChess().setSelect(true);
 						clickStap++;
 						
 						/*-----------------print MovableRange----------------*/
 						ChessGrid rangeInfo[] = ((ChineseChess)selectGrid.getChess()).getMovableRange(gameModel.getChessBoard());
 						(gameView.getChessBoardJPanel()).setRangeInfo(rangeInfo);
 						/*-----------------print MovableRange----------------*/
 					}
 					else
 					{
 						System.out.println("Not your Round !!");
 						gameView.recordAppend("Not your Round !!\n");
 						//cancel MovableRange
 						clickStap = 0;
 					}
 				}				
 			}
 	    } 		 
 		
    }
	
}