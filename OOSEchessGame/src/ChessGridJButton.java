import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonModel;
import javax.swing.JButton;



public class ChessGridJButton extends JButton implements Observer{	
	
    private ChessGrid ObservableChessGrid; 
    private ChessJLabel chessJLabel;
    
	ChessGridJButton(ChessGrid ObservableChessGrid){
        super();
		this.ObservableChessGrid =  ObservableChessGrid;
		ObservableChessGrid.addObserver(this);			
		
		this.setLayout(null);//Layout for Chess
		this.setContentAreaFilled(false);//³z©ú«ö¶s	
	    this.setBorderPainted(false); //³z©ú«ö¶s®Ø
	    
	    if(ObservableChessGrid.getChess() != null){
		    chessJLabel = new ChessJLabel(ObservableChessGrid.getChess());
		    add(chessJLabel);
	    }
	}
	
	public ChessGrid getObservable(){
		
		return ObservableChessGrid;
	}	
	
	 public void setRangeInfo(boolean b){
			
		 this.setBorderPainted(b); //«ö¶s®Ø³z©ú»P§_
		 repaint();
	}
	@Override
	public void setBounds(int x ,int y ,int width, int height){
		
		super.setBounds(x, y, width, height);
		if(chessJLabel != null){
			chessJLabel.setBounds(0 ,0 ,getWidth(),getHeight());	
		}
	}
	
	
	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
		
		if (arg instanceof Chess) { 	//setChess
			
			chessJLabel = new ChessJLabel((Chess)arg);
			chessJLabel.setBounds(0 ,0 ,getWidth(),getHeight());
			add(chessJLabel);
			System.out.println("ChessGridObserver: ChessGrid"+((ChessGrid)obs).getX()+","+((ChessGrid)obs).getY()+" changed to " + ((Chess)arg).getChessType());
			
        }else if(arg == null){        	                //removeChess
			if(chessJLabel != null){	
				remove(chessJLabel);
				chessJLabel = null;
			}
			System.out.println("ChessGridObserver: ChessGrid"+((ChessGrid)obs).getX()+","+((ChessGrid)obs).getY()+" changed to " + "-");
		}
				
		repaint();		
	}				
}
