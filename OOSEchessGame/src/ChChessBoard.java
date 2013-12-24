import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ChChessBoard extends ChessBoard implements IBoardForMovChess{

	public ChChessBoard(){
		super(9,10);			
	}	
	
	public void moveChess(ChessGrid oldGrid, ChessGrid newGrid){		
		
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
}
