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
import java.util.Observable;


public class ChessGame extends Observable{
	
	private ChessBoard chessBoard;
	private Player p1;
	private Player p2;	

	public ChessGame(Player p1,Player p2,ChessBoard chessBoard) {
		
		this.chessBoard = chessBoard;
		this.p1 = p1;
		this.p2 = p2;
		chessBoard.newGameFactory(p1,p2);
	}
	
	public void turnRound() {
		
		System.out.println( "Turn Round!!");
		int temp = p1.getState();
		p1.setState(p2.getState());
		p2.setState(temp);
		setChanged();
		notifyObservers();
	}
	    
    public ChessBoard getChessBoard() {
		
	    return chessBoard;
	}
    
    public Player getRoundPlayer() {
    	
    	if(p1.getState() == 1){
    		return p1;
    	}else{
    		return p2;
    	}		
	}
    public Player getNotRoundPlayer() {
    	
    	if(p1.getState() == 0){
    		return p1;
    	}else{
    		return p2;
    	}		
	} 
    
    public Player getPlayer1() {
		
	    return p1;
	}
    public Player getPlayer2() {
		
	    return p2;
	}
    
    
}
