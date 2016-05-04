package Player;

import java.util.ArrayList;

import Cards.Card;

public class Player {
	
	String name;
	int num;
	ArrayList<Card> cards = new ArrayList<Card>();
	boolean ace = false;
	
	public Player(String name) {
		this.name = name;
		num = 0;
	}
	
	
	public boolean isBusted() {
		if(num>21) {
			return true;
		}
		return false;
	}
	
	public int addAmount(Card c) {
		if(c.getValueTen()==1 && num+c.getValueTen()>21) {
			num+=c.getValueTen();
		} else if(c.getValueTen()==1 && num+c.getValueTen()<=21) {
			num+=11;
			ace = true;
		} else {
			hasAce(c.getValueTen());
			num+=c.getValueTen();
		}
		cards.add(c);
		return num;
	}
	
	private void hasAce(int value) {
		if(ace && num+value>21) {
			num = num-11;
			num+=1;
		}
	}
	
	public void reset() {
		num = 0;
		cards.clear();
		ace = false;
	}
	
	public int getValue() {
		return num;
	}
	
	@Override
	public String toString() {
		String list = "";
		for(Card c : cards) {
			list+=c+"|";
		}
		return name + ": " + num + "\n" + list;
	}
	
}
