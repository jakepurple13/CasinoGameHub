package Actors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Actor implements KeyListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Player(String typed, int x, int y) {
		super(typed, x, y);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void act(String direction) {
		// TODO Auto-generated method stub
		if(direction.equals("Up")) {
			g.move(this, g.board[op.getX()][op.getY()-1]);
		}
		
		if(direction.equals("Down")) {
					
		}
		
		if(direction.equals("Left")) {
			
		}
		
		if(direction.equals("Right")) {
			
		}
		
		g.pick();
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		try {
			
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				act("Up");
				System.out.println(g);
			} else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				
			} else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				
			} else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				
			}
			
			
			
		} catch(IndexOutOfBoundsException r) {
			
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		super.actionPerformed(e);
	}
	
	
	

}
