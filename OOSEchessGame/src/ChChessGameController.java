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
 			ChessGridJButton  cgb = (ChessGridJButton)obj;  
 			ChessGrid cg = (ChessGrid)cgb.getObservable();
 			ChineseChess cc = (ChineseChess)cg.getChess();  //®³ºX¤l
 			
 			if( clickStap == 1 )
 			{
 				ChessGrid rangeInfo[] = ((ChineseChess)selectGrid.getChess()).getMovableRange(gameModel.getChessBoard());
 				boolean inTheRange = false; 
 				
 				/*-----------------check the new click whether in range or not---------------*/
 				int i=0;		
 			    while(rangeInfo[i] != null){

 				    	if(cg == rangeInfo[i])
 				      	{
 				    		inTheRange = true;
 				    	}	
 			    	i++;
 				}
 			    /*-----------------check the new click whether in range or not--------------*/
 			    
 				if(inTheRange)//if new click in the MovableRange
 				{
 					/*------------------------------king die---------------------------------------*/
 					if(cc instanceof ChChessKing){
 						JFrame gameOverJFrame = new JFrame ("Game is over!"); 			
 						TextField tf = new TextField("Player: "+gameModel.getRound().getName()+"  Win!");
 						if(cc.getChessType() == "b"){
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
 					selectGrid.getChess().setSelect(false);
 					((ChChessBoard)(gameModel.getChessBoard())).moveChess(selectGrid , cg);
 					gameModel.turnRound();
 					
 					
 					/*--------------------------check-for check--------------------------------*/
 					rangeInfo = ((ChineseChess)cg.getChess()).getMovableRange(gameModel.getChessBoard());
 					boolean isCheck = false; 
 					
 	 				i=0;		
 	 			    while(rangeInfo[i] != null){

 	 				    	if(rangeInfo[i].getChess() instanceof ChChessKing )
 	 				      	{
 	 				    		isCheck = true;
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
 					//cancel MovableRange
 					System.out.println("cancel");
 					selectGrid.getChess().setSelect(false);
 				}
 				
				(gameView.getChessBoardJPanel()).removeRangeInfo();
				selectGrid = null;
				clickStap = 0;
 			}
 			else if(clickStap == 0)
 			{
 				if( cc != null ) //ClickChess
 				{				
 					if( cc.getOwner().getState() == 1  )
 					{
 						System.out.println("select");
 						selectGrid = cg;
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
 						//cancel MovableRange
 						clickStap = 0;
 					}
 				}				
 			}
 	    } 		 
 		
    }
	
}