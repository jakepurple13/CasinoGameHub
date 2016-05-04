package calculation;


import java.util.ArrayList;
import java.util.Arrays;

import Cards.Card;




public class Holding {
	
	
	public Holding() {
		
		// TODO Auto-generated constructor stub
		
		byone1 = new ArrayList<Card>();
		bytwo1 = new ArrayList<Card>();
		bythree1 = new ArrayList<Card>();
		byfour1 = new ArrayList<Card>();
		
	}
	
	
	



	ArrayList<Card> byone1;
	ArrayList<Card> bytwo1;
	ArrayList<Card> bythree1;
	ArrayList<Card> byfour1;
	
	
	
	
	
	public void adda(Card c) {
		byone1.add(c);
	}
	
	public void addb(Card c) {
		bytwo1.add(c);
	}
	
	public void addc(Card c) {
		bythree1.add(c);
	}
	
	public void addd(Card c) {
		byfour1.add(c);
	}
	
	public Card get1() {
		return byone1.remove(byone1.size()-1);
	}
	
	public Card get2() {
		return bytwo1.remove(bytwo1.size()-1);
	}
	
	public Card get3() {
		return bythree1.remove(bythree1.size()-1);
	}
	
	public Card get4() {
		return byfour1.remove(byfour1.size()-1);
	}
	
	public ArrayList<Card> getOne() {
		return byone1;
	}
	
	public ArrayList<Card> getTwo() {
		return bytwo1;
	}
	
	public ArrayList<Card> getThree() {
		return bythree1;
	}
	
	public ArrayList<Card> getFour() {
		return byfour1;
	}
	
	public boolean isEmpty() {
		
		boolean won = true;
		
		if(!byone1.isEmpty()) {
			won = false;
		}
		
		if(!bytwo1.isEmpty()) {
			won = false;
		}
		
		if(!bythree1.isEmpty()) {
			won = false;
		}
		
		if(!byfour1.isEmpty()) {
			won = false;
		}
		
		return won;
		
	}
	
	
	@Override
	public String toString() {
		
		String s = "";
		
		
		
		int[] sizes = new int[4];
		
		sizes[0] = byone1.size();
		sizes[1] = bytwo1.size();
		sizes[2] = bythree1.size();
		sizes[3] = byfour1.size();
		Arrays.sort(sizes);
		
		
		
		
		for(int i=0;i<=sizes[3];i++) {
			String one = "";
			String two = "";
			String three = "";
			String four = "";
			
			try {
				one = byone1.get(i).toString();
			} catch(IndexOutOfBoundsException e) {
				one = "\t";
			}
			
			try {
				two = bytwo1.get(i).toString();
			} catch(IndexOutOfBoundsException e) {
				two = "\t";
			}
			
			try {
				three = bythree1.get(i).toString();
			} catch(IndexOutOfBoundsException e) {
				three = "\t";
			}
			
			try {
				four = byfour1.get(i).toString();
			} catch(IndexOutOfBoundsException e) {
				four = "\t";
			}
			

			
			s+=one + "\t\t" + two + "\t\t" + three + "\t\t" + four + "\t\n"/* + "-----------------------------------"
					+ "--------------------------------------------------------------\n"*/;
			
		}
		
		
		
		return s;
	}
	
	

}
