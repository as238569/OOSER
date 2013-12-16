import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.GridLayout;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;


public class ChessGame extends JFrame implements MouseListener{
	
	JPanel chessBoard;
	Player p1;
	Player p2;
	JRadioButton rdbtnRedSide;
	JRadioButton rdbtnBlackSide;
	
	int clickStap ;
	ChessGrid selectGrid;	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChessGame frame = new ChessGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChessGame() {
		
		
		setTitle("GUIdemo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 730);
		setLayout(null);

		chessBoard = new ChChessBoard(this);
		chessBoard.setBounds(354, 53, 526, 578);
		add(chessBoard);
		
		rdbtnRedSide = new JRadioButton("red side",true);
		rdbtnRedSide.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnRedSide.setEnabled(false);
		rdbtnRedSide.setBounds(799, 23, 109, 23);
		add(rdbtnRedSide);
		
		rdbtnBlackSide = new JRadioButton("black side",false);	
		rdbtnBlackSide.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnBlackSide.setEnabled(false);
		rdbtnBlackSide.setBounds(354, 640, 109, 23);
		add(rdbtnBlackSide);
		
		p1 = new Player("123",1);
		p2 = new Player("321",0);
		((ChChessBoard) chessBoard).newGameFactory(p1,p2);
		
	}
	public void turnRound() {
		
		System.out.println( "Turn Round!!");
		int temp = p1.getState();
		p1.setState(p2.getState());
		p2.setState(temp);
		
		if(p1.getState()==1){
		   rdbtnRedSide.setSelected(true);
		   rdbtnBlackSide.setSelected(false);
		}else{
		   rdbtnRedSide.setSelected(false);
		   rdbtnBlackSide.setSelected(true);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj instanceof ChessGrid)
		{		
			
			ChessGrid  cg = (ChessGrid)obj;  //§ÎºAÂà´«
			ChineseChess cc = (ChineseChess)cg.getChess();  //®³ºX¤l
			
			if( clickStap == 1 )
			{
				ChessGrid infor[] = ((ChineseChess)selectGrid.getChess()).getMovableRange((ChessBoard) chessBoard);
				boolean inTheRange = false; 
				
				/*-----------------check the new click whether in range or not---------------*/
				int i=0;		
			    while(infor[i] != null){

				    	if(cg == infor[i])
				      	{
				    		inTheRange = true;
				    	}	
			    	i++;
				}
			    /*-----------------check the new click whether in range or not--------------*/
			    
				if(inTheRange)//if new click in the MovableRange
				{
					System.out.println("move OR eat");
					((ChessBoard) chessBoard).removeRangeInfor();
					((ChChessBoard) chessBoard).moveChess(selectGrid , cg);
					this.turnRound();
				    selectGrid = null;
					clickStap = 0;
				}
				else
				{
					//cancel MovableRange
					System.out.println("cancel");
					((ChChessBoard) chessBoard).removeRangeInfor();
					selectGrid = null;
					clickStap = 0;
				}
			}
			else if(clickStap == 0)
			{
				if( cc != null ) //ClickChess
				{				
					if( cc.getOwner().getState() == 1  )
					{
						System.out.println("select");
						selectGrid = cg;
						clickStap++;
						
						/*-----------------print MovableRange----------------*/
						ChessGrid infor[] = ((ChineseChess)selectGrid.getChess()).getMovableRange((ChessBoard) chessBoard);
						int i=0;
						while(infor[i] != null){

					    	infor[i].setRangeInfor(true);
					    	i++;
						}
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
		
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
