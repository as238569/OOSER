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
	
	public void bindOwner(Player p, String bindChessType) {
		
		for(int y=0;y<super.getMaxY();y++){			
			
			for(int x=0;x<super.getMaxX();x++){		
				
				if(super.getChessGrid(x ,y).getChess().getChessType().equals(bindChessType)){
			
					super.getChessGrid(x ,y).getChess().setOwner(p);
				}
			}
		}	    
	}
	public boolean checkDieAll(Player p){
		
		boolean dieAll = true;
		
		for(int y=0;y<super.getMaxY();y++){
			
			for(int x=0;x<super.getMaxX();x++){	
				
				if(super.getChessGrid(x ,y).getChess() != null && super.getChessGrid(x ,y).getChess().getOwner().equals(p)){			
					 dieAll = false;
				}
			}
		}	    
		
		
		return dieAll;
	}

	@Override
	public void newGameFactory(Player p1, Player p2) {
		
		int maxX = getMaxX();
		int maxY = getMaxY();
		
		int[] list = new int[ maxX * maxY];
		for(int i = 0; i < maxX * maxY; i++){
			list[i] = i;
		}		
		
		/*------------------------set random-------------------------*/
		Random random = new Random();
		for(int i = 0; i < maxX * maxY; i++){			 
		    int p = random.nextInt(maxX * maxY);
		    int tmp = list[i];
		    list[i] =list[p];
		    list[p] = tmp;
        }
		/*------------------------------------------------------------*/


	    super.setChess(list[0]%maxX,list[0]/maxX,new TwDarkChessRook("r")       );
		super.setChess(list[1]%maxX,list[1]/maxX,new TwDarkChessKnight("r")     );	
		super.setChess(list[2]%maxX,list[2]/maxX,new TwDarkChessElephant("r")   );
		super.setChess(list[3]%maxX,list[3]/maxX,new TwDarkChessAdvisor("r")    );
		super.setChess(list[4]%maxX,list[4]/maxX,new TwDarkChessKing("r")       );
		super.setChess(list[5]%maxX,list[5]/maxX,new TwDarkChessAdvisor("r")    );
		super.setChess(list[6]%maxX,list[6]/maxX,new TwDarkChessElephant("r")   );
		super.setChess(list[7]%maxX,list[7]/maxX,new TwDarkChessKnight("r")     );
		super.setChess(list[8]%maxX,list[8]/maxX,new TwDarkChessRook("r")       );		
		super.setChess(list[9]%maxX,list[9]/maxX,new TwDarkChessCannon("r")     );
		super.setChess(list[10]%maxX,list[10]/maxX,new TwDarkChessCannon("r")     );
		super.setChess(list[11]%maxX,list[11]/maxX,new TwDarkChessPawn("r")    );
		super.setChess(list[12]%maxX,list[12]/maxX,new TwDarkChessPawn("r")    );
		super.setChess(list[13]%maxX,list[13]/maxX,new TwDarkChessPawn("r")    );
		super.setChess(list[14]%maxX,list[14]/maxX,new TwDarkChessPawn("r")    );
		super.setChess(list[15]%maxX,list[15]/maxX,new TwDarkChessPawn("r")    );		

		
		super.setChess(list[16]%maxX,list[16]/maxX,new TwDarkChessRook("b")       );
		super.setChess(list[17]%maxX,list[17]/maxX,new TwDarkChessKnight("b")     );
		super.setChess(list[18]%maxX,list[18]/maxX,new TwDarkChessElephant("b")   );
		super.setChess(list[19]%maxX,list[19]/maxX,new TwDarkChessAdvisor("b")    );
		super.setChess(list[20]%maxX,list[20]/maxX,new TwDarkChessKing("b")       );
		super.setChess(list[21]%maxX,list[21]/maxX,new TwDarkChessAdvisor("b")    );
		super.setChess(list[22]%maxX,list[22]/maxX,new TwDarkChessElephant("b")   );
		super.setChess(list[23]%maxX,list[23]/maxX,new TwDarkChessKnight("b")     );
		super.setChess(list[24]%maxX,list[24]/maxX,new TwDarkChessRook("b")       );
		super.setChess(list[25]%maxX,list[25]/maxX,new TwDarkChessCannon("b")     );
		super.setChess(list[26]%maxX,list[26]/maxX,new TwDarkChessCannon("b")     );
		super.setChess(list[27]%maxX,list[27]/maxX,new TwDarkChessPawn("b")    );
		super.setChess(list[28]%maxX,list[28]/maxX,new TwDarkChessPawn("b")    );
		super.setChess(list[29]%maxX,list[29]/maxX,new TwDarkChessPawn("b")    );
		super.setChess(list[30]%maxX,list[30]/maxX,new TwDarkChessPawn("b")    );
		super.setChess(list[31]%maxX,list[31]/maxX,new TwDarkChessPawn("b")    );
		
		
	}
}