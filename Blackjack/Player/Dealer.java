package Player;

import java.util.ArrayList;

import Cards.Card;
import Cards.Deck;

public class Dealer {
	
	Deck d;
	ArrayList<Card> cards = new ArrayList<Card>();
	int num;
	boolean ace = false;
	
	public Dealer(Deck d) {
		this.d = d;
		num = 0;
	}
	
	public boolean isBusted() {
		if(num>21) {
			return true;
		}
		return false;
	}
	
	public int addAmount() {
		Card c;
		while(num<17) {
			c = d.draw();
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
		}
		return num;
	}
	
	public void start() {
		for(int i=0;i<2;i++) {
			Card c = d.draw();
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
		}
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
		return "Dealer: " + num + "\n" + list;
	}
	
	
}
