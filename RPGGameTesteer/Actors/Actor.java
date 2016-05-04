package Actors;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import rpgtester.Grid;

public class Actor extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String type = "N";
	int width;
	int height;
	int xPosition;
	int yPosition;
	public OrderedPair op;
	Grid g;
	
	public Actor(String typed, int x, int y) {
		type = typed;
		xPosition = x;
		yPosition = y;
		op = new OrderedPair(x, y);
		addActionListener(this);
		//setImageIcon(type);
	}
	
	public void setGrid(Grid board) {
		g = board;
	}
	
	public void act() {
		
	}
	
	public void act(String direction) {
		g.pick();
	}
	
	public void newLocation(OrderedPair po) {
		op = po;
	}
	
	public boolean isEmpty() {
		if(this instanceof Actor) {
			return true;
		}
		return false;
	}
	
	public boolean isAtEdge(Actor a) {
		
		if(op.getX()>=g.SIZE || op.getY()>=g.SIZE) {
			return true;
		} else if(op.getX()<0 || op.getY()<=0) {
			return true;
		}
		
		return false;
	}
	
	private void setImageIcon(String typed) {
		width = getWidth();
		height = getHeight();
		Image img = new ImageIcon(getClass().getResource(typed + ".png")).getImage() ;
		Image newimg = img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH ) ;  
		Icon icon = new ImageIcon( newimg );
		setIcon(icon);
	}
	
	@Override
	public String toString() {
		return type;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println(g + "\n" + g.getPick());
	}
	

}
