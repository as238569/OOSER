import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

 public class ChessBoardJPanel extends JPanel implements Observer{

	private ChessBoard  ObservableChessBoard; 
	private ChessGridJButton GridJButton[][];	
	private int maxX ;
	private int maxY ;

	ChessBoardJPanel(ChessBoard ObservableChessBoard){
		
		maxX = ObservableChessBoard.getMaxX();
		maxY = ObservableChessBoard.getMaxY();
		
		this.ObservableChessBoard =  ObservableChessBoard;
		ObservableChessBoard.addObserver(this);	
		
		setLayout(new GridLayout(maxY, maxX, 0, 0));				
		GridJButton = new  ChessGridJButton[maxY][maxX];			
		for(int y=0;y<maxY;y++)			
		{
			for(int x=0;x<maxX;x++)
			{	
				GridJButton[y][x] = new ChessGridJButton(ObservableChessBoard.getChessGrid(x, y));
				GridJButton[y][x].setBounds(0 ,0 ,(getWidth()/maxX),(getHeight()/maxY)); 
				add(GridJButton[y][x]);
			}
		}
	}
	
	public void addActionListener(ActionListener l){
				
		for(int y=0;y<maxY;y++)			
		{
			for(int x=0;x<maxX;x++)
			{	
				GridJButton[y][x].addActionListener(l);
			}
		}		
	}
	
    public void setRangeInfo(ChessGrid rangeInfo[]){
    	    	
		int i=0;
    	while(i < rangeInfo.length && rangeInfo[i] != null){    		
    		
    		int x = rangeInfo[i].getX();
    		int y = rangeInfo[i].getY();    		
    		
    		GridJButton[y][x].setRangeInfo(true); 
    		i++;
    	}			
	}
	
    public void removeRangeInfo(){
		
    	for(int y=0;y<maxY;y++)
		{
			for(int x=0;x<maxX;x++)
			{	
				GridJButton[y][x].setRangeInfo(false);
			}
		}		
	}
	
	
	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub		
		
		repaint();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		 super.paintComponent(g);		 
		 Image boardImg = Toolkit.getDefaultToolkit().getImage(ObservableChessBoard.getClass().getName()+".jpg");			 
		 g.drawImage(boardImg, 0, 0 ,getWidth(),getHeight(),null);
		 
		 
		 this.setVisible(false);
		 this.setVisible(true);
	}
	
}