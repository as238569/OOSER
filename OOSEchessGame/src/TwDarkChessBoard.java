import java.util.Random;


public class TwDarkChessBoard extends ChessBoard implements IBoardForMovChess{


	public TwDarkChessBoard(){
		super(8,4);			
	}	
	
	public void moveChess(ChessGrid oldGrid, ChessGrid newGrid){		
		
        Chess c = oldGrid.getChess();
        oldGrid.removeChess();
        newGrid.removeChess();
		newGrid.setChess(c);
	}
	

	@Override
	public void newGameFactory(Player p1, Player p2) {
		
		int[] x = new int[getMaxX()];
		for(int i = 0; i < getMaxX(); i++){
		    x[i] = i;
		}		
		int[] y = new int[super.getMaxY()];
		for(int i = 0; i < super.getMaxY(); i++){
		    y[i] = i;
		}
		
		/*------------------------set random-------------------------*/
		Random random = new Random();
		for(int i = 0; i < getMaxX(); i++){
			 
		    int p = random.nextInt(getMaxX());
		    int tmp = x[i];
	   	    x[i] =x[p];
		    x[p] = tmp;
        }
		for(int i = 0; i < getMaxY(); i++){
			 
		    int p = random.nextInt(getMaxY());
		    int tmp = y[i];
	   	    y[i] =y[p];
		    y[p] = tmp;
         }
		/*------------------------------------------------------------*/
				
		
	    super.setChess(x[0],y[0],new TwDarkChessRook("r")       );
		super.setChess(x[1],y[0],new TwDarkChessKnight("r")     );	
		super.setChess(x[2],y[0],new TwDarkChessElephant("r")   );
		super.setChess(x[3],y[0],new TwDarkChessAdvisor("r")    );
		super.setChess(x[4],y[0],new TwDarkChessKing("r")       );
		super.setChess(x[5],y[0],new TwDarkChessAdvisor("r")    );
		super.setChess(x[6],y[0],new TwDarkChessElephant("r")   );
		super.setChess(x[7],y[0],new TwDarkChessKnight("r")     );
		super.setChess(x[0],y[1],new TwDarkChessRook("r")       );		
		super.setChess(x[1],y[1],new TwDarkChessCannon("r")     );
		super.setChess(x[2],y[1],new TwDarkChessCannon("r")     );
		super.setChess(x[3],y[1],new TwDarkChessPawn("r")    );
		super.setChess(x[4],y[1],new TwDarkChessPawn("r")    );
		super.setChess(x[5],y[1],new TwDarkChessPawn("r")    );
		super.setChess(x[6],y[1],new TwDarkChessPawn("r")    );
		super.setChess(x[7],y[1],new TwDarkChessPawn("r")    );		

		
		super.setChess(x[0],y[2],new TwDarkChessRook("b")       );
		super.setChess(x[1],y[2],new TwDarkChessKnight("b")     );
		super.setChess(x[2],y[2],new TwDarkChessElephant("b")   );
		super.setChess(x[3],y[2],new TwDarkChessAdvisor("b")    );
		super.setChess(x[4],y[2],new TwDarkChessKing("b")       );
		super.setChess(x[5],y[2],new TwDarkChessAdvisor("b")    );
		super.setChess(x[6],y[2],new TwDarkChessElephant("b")   );
		super.setChess(x[7],y[2],new TwDarkChessKnight("b")     );
		super.setChess(x[0],y[3],new TwDarkChessRook("b")       );
		super.setChess(x[1],y[3],new TwDarkChessCannon("b")     );
		super.setChess(x[2],y[3],new TwDarkChessCannon("b")     );
		super.setChess(x[3],y[3],new TwDarkChessPawn("b")    );
		super.setChess(x[4],y[3],new TwDarkChessPawn("b")    );
		super.setChess(x[5],y[3],new TwDarkChessPawn("b")    );
		super.setChess(x[6],y[3],new TwDarkChessPawn("b")    );
		super.setChess(x[7],y[3],new TwDarkChessPawn("b")    );
		
		
	}
}