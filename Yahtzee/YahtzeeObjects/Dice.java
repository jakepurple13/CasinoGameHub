package YahtzeeObjects;

import java.util.Random;

import javax.swing.ImageIcon;


public class Dice {
	
	private int value;
	private boolean held = false;
	Random gen = new Random();
	
	public Dice(int val) {
		value = val;
	}
	
	public int getValue() {
		return value;
	}
	
	public void hold() {
		held = !held;
	}
	
	public boolean isHold() {
		return held;
	}
	
	public void unHold() {
		held = false;
	}
	
	public void changeDice() {
		if(held==false) {
			value = gen.nextInt(6)+1;
		}
	}
	
	@Override
	public String toString() {
		return value + "";
	}
	
	public ImageIcon getImage() {
		return new ImageIcon(getClass().getResource(value +".png"));
	}
	
	
}
