package rpgtester;

import Actors.Actor;
import Actors.Player;

public class Grid {
	
	public Actor[][] board;
	public int SIZE;
	public boolean picked = false;
	
	public Grid(int size) {
		// TODO Auto-generated constructor stub
		board = new Actor[size][size];
		SIZE = size;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				board[i][j] = new Actor("N", i, j);
				board[i][j].setGrid(this);
			}
		}
		
		board[5][5] = new Player("P", 5, 5);
		board[5][5].setGrid(this);
	}
	
	public void pick() {
		picked = !picked;
	}
	
	public boolean getPick() {
		return picked;
	}
	
	public void move(Actor from, Actor to) {
		if(to.isEmpty() && picked) {
			Actor a = new Actor("N", from.op.getX(), from.op.getY());
			board[to.op.getX()][to.op.getY()] = from;
			board[from.op.getX()][from.op.getY()] = a;
			from.newLocation(to.op);
			from.setText(from.toString());
			picked = false;
		}
	}
	
	@Override
	public String toString() {
		String list = "";
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				list+=board[i][j] + "|";
			}
			list+="\n";
		}
		
		return list;
	}
	
	
	
	

}
