import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Observable;

abstract public class Chess  extends Observable {
	
	private String chessType;
	private Player owner;
	private boolean select;
	
	Chess(String chessType){
		
		this.chessType = chessType;
		select=false;
	}
	
	Chess(String chessType,Player owner){
	
		this.chessType =  chessType;
		this.owner = owner;
		select=false;
	}
	
	public String getChessType(){
		
		return chessType;		
	}	
	public Player getOwner(){
		
		return owner;		
	}
	
    public void setOwner(Player owner){
		
    	this.owner = owner;		
	}
	
    public void setSelect(boolean b){
		
    	select=b;
    	setChanged();
    	notifyObservers(select);    	
	}	
}
