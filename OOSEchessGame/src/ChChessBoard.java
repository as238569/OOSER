import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ChChessBoard extends ChessBoard  implements IBoardForMovChess{
	
	
	int clickStap ;
	ChessGrid selectGrid;
	
	public ChChessBoard(){
		super(9,10);			
	}	
	
	public void moveChess(ChessGrid oldGrid, ChessGrid newGrid ){		
		
        Chess c = oldGrid.getChess();
        oldGrid.removeChess();
        newGrid.removeChess();
		newGrid.setChess(c);
	}
	

	@Override
	public void newGameFactory(Player p1, Player p2) {
		
	    super.setChess(0,0,new ChChessRook("r",p1)       );
		super.setChess(1,0,new ChChessKnight("r",p1)     );	
		super.setChess(2,0,new ChChessElephant("r",p1)   );
		super.setChess(3,0,new ChChessAdvisor("r",p1)    );
		super.setChess(4,0,new ChChessKing("r",p1)       );
		super.setChess(5,0,new ChChessAdvisor("r",p1)    );
		super.setChess(6,0,new ChChessElephant("r",p1)   );
		super.setChess(7,0,new ChChessKnight("r",p1)     );
		super.setChess(8,0,new ChChessRook("r",p1)       );
		
		super.setChess(1,2,new ChChessCannon("r",p1)     );
		super.setChess(7,2,new ChChessCannon("r",p1)     );
		super.setChess(0,3,new ChChessPawn("r",p1)    );
		super.setChess(2,3,new ChChessPawn("r",p1)    );
		super.setChess(4,3,new ChChessPawn("r",p1)    );
		super.setChess(6,3,new ChChessPawn("r",p1)    );
		super.setChess(8,3,new ChChessPawn("r",p1)    );
		

		
		super.setChess(0,9,new ChChessRook("b",p2)       );
		super.setChess(1,9,new ChChessKnight("b",p2)     );
		super.setChess(2,9,new ChChessElephant("b",p2)   );
		super.setChess(3,9,new ChChessAdvisor("b",p2)    );
		super.setChess(4,9,new ChChessKing("b",p2)       );
		super.setChess(5,9,new ChChessAdvisor("b",p2)    );
		super.setChess(6,9,new ChChessElephant("b",p2)   );
		super.setChess(7,9,new ChChessKnight("b",p2)     );
		super.setChess(8,9,new ChChessRook("b",p2)       );
		super.setChess(1,7,new ChChessCannon("b",p2)     );
		super.setChess(7,7,new ChChessCannon("b",p2)     );
		super.setChess(0,6,new ChChessPawn("b",p2)    );
		super.setChess(2,6,new ChChessPawn("b",p2)    );
		super.setChess(4,6,new ChChessPawn("b",p2)    );
		super.setChess(6,6,new ChChessPawn("b",p2)    );
		super.setChess(8,6,new ChChessPawn("b",p2)    );
		
		
	}
	public void mouseClicked(MouseEvent e) {//主要事件 程序
		
		Object obj = e.getSource();
		System.out.println("Click");
		
		if(obj instanceof ChessGrid)
		{		
			
			ChineseChess ccg = (ChineseChess) ((ChessGrid) obj).getChess();
			
			if( clickStap == 1 )
			{
				boolean inTheRange = true; // if relly work set true
				
			 /* ChessGrid infor[] = ccg.getMovableRange(this);
				
				for(int i=0;i<infor.length;i++  )
				{
					if((ChessGrid)obj == infor[i])
					{
						inTheRange = true;
					}
					
					i++;
				}	*/			
				if(inTheRange)//if in the MovableRange
				{
					System.out.println("move OR eat");
				    this.moveChess(selectGrid , (ChessGrid) obj);
					clickStap = 0;
				}
				else
				{
					//cancel MovableRange
					System.out.println("cancel");
					clickStap = 0;
				}
			}
			else if(clickStap == 0)
			{
				if( ccg != null ) //ClickChess
				{				
					if( ccg.getOwner().getState() == 1  )
					{
						//print MovableRange
						System.out.println("select");
						selectGrid = (ChessGrid) obj;
						clickStap++;
					}
					else
					{
						System.out.println("noselect");
						//cancel MovableRange
						clickStap = 0;
					}
				}				
			}
		}		
    }

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
