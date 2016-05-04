package calculation;
import Cards.Card;

import java.util.ArrayList;
import java.util.Arrays;




public class Stockpile {
	
	ArrayList<Card> byone;
	ArrayList<Card> bytwo;
	ArrayList<Card> bythree;
	ArrayList<Card> byfour;
	
	
	public Stockpile(Card one, Card two, Card three, Card four) {
		
		byone = new ArrayList<Card>();
		bytwo = new ArrayList<Card>();
		bythree = new ArrayList<Card>();
		byfour = new ArrayList<Card>();
		
		byone.add(one);
		bytwo.add(two);
		bythree.add(three);
		byfour.add(four);
	}
	
	public Stockpile() {
		
	}
	
	public Card get1() {
		return byone.get(byone.size()-1);
	}
	
	public Card get2() {
		return bytwo.get(bytwo.size()-1);
	}
	
	public Card get3() {
		return bythree.get(bythree.size()-1);
	}
	
	public Card get4() {
		return byfour.get(byfour.size()-1);
	}
	
	public boolean add1(Card c) {
		if(byone.get(byone.size()-1).getValue()==13) {
			return false;
		}
		int before = byone.get(byone.size()-1).getValue();
		int next = c.getValue();
		if(before+1==next) {
			byone.add(c);
			return true;
		}
		return false;
	}
	
	public boolean add2(Card c) {
		if(bytwo.get(bytwo.size()-1).getValue()==13) {
			return false;
		}
		int before = bytwo.get(bytwo.size()-1).getValue();
		int next = c.getValue();
		if(before==12) {
			before = -1;
		}
		if(before+2==next) {
			bytwo.add(c);
			return true;
		}
		return false;
	}
	
	public boolean add3(Card c) {
		if(bythree.get(bythree.size()-1).getValue()==13) {
			return false;
		}
		int before = bythree.get(bythree.size()-1).getValue();
		int next = c.getValue();
		if(before==12) {
			before = -1;
		} else if(before==11) {
			before = -2;
		}
		if(before+3==next) {
			bythree.add(c);
			return true;
		}
		return false;
	}
	
	public boolean add4(Card c) {
		if(byfour.get(byfour.size()-1).getValue()==13) {
			return false;
		}
		int before = byfour.get(byfour.size()-1).getValue();
		int next = c.getValue();
		if(before==12) {
			before = -1;
		} else if(before==11) {
			before = -2;
		} else if(before==10) {
			before = -3;
		}
		if(before+4==next) {
			byfour.add(c);
			return true;
		}
		return false;
	}
	
	
	
	
	private int addPile(ArrayList<Card> p) {
		int q = 0;
		for(int i=0;i<p.size();i++) {
			q+=p.get(i).getValue();
		}
		return q;
	}
	
	public int getSizeOfPile(int num) {
		int q = 0;
		
		if(num==1) {
			q = addPile(byone);
		} else if(num==2) {
			q = addPile(bytwo);
		} else if(num==3) {
			q = addPile(bythree);
		} else if(num==4) {
			q = addPile(byfour);
		}
		
		
		return q;
	}
	
	public void intoOne(ArrayList<Card> hold) {
		Card c = hold.remove(hold.size()-1);
		if(!add1(c)) {
			hold.add(c);
			System.out.println("Card added back to foundation");
		}
	}
	
	public void intoTwo(ArrayList<Card> hold) {
		Card c = hold.remove(hold.size()-1);
		if(!add2(c)) {
			hold.add(c);
			System.out.println("Card added back to foundation");
		}
	}
	
	public void intoThree(ArrayList<Card> hold) {
		Card c = hold.remove(hold.size()-1);
		if(!add3(c)) {
			hold.add(c);
			System.out.println("Card added back to foundation");
		}
	}
	
	public void intoFour(ArrayList<Card> hold) {
		Card c = hold.remove(hold.size()-1);
		if(!add4(c)) {
			hold.add(c);
			System.out.println("Card added back to foundation");
		}
	}
	
	
	public String nextOne() {
		String next = "";
		
		int q = (byone.get(byone.size()-1).getValue() + 1);
		
		if(q==14) {
			next = "Done";
		} else if(q==11) {
			next = "J";
		} else if(q==12) {
			next = "Q";
		} else if(q==13) {
			next = "K";
		} else {
			next = q + "";
		}
		
		return next;
	}
	
	public String nextTwo() {
		String next = "";
		int q = (bytwo.get(bytwo.size()-1).getValue() + 2);
		if(q==14) {
			next = "Ace";
		} else if(q==11) {
			next = "J";
		} else if(q==12) {
			next = "Q";
		} else if(q==13) {
			next = "K";
		} else if(q==15) {
			next = "Done";
		} else {
			next = q + "";
		}
		
		
		
		return next;
	}
	
	public String nextThree() {
		String next = "";
		int q = (bythree.get(bythree.size()-1).getValue() + 3);
		if(q==14) {
			next = "Ace";
		} else if(q==11) {
			next = "J";
		} else if(q==12) {
			next = "Q";
		} else if(q==13) {
			next = "K";
		} else if(q==15) {
			next = "2";
		} else if(q==16) {
			next = "Done";
		} else {
			next = q + "";
		}
		
		
		
		return next;
	}
	
	public String nextFour() {
		String next = "";
		int q = (byfour.get(byfour.size()-1).getValue() + 4);
		if(q==14) {
			next = "Ace";
		} else if(q==11) {
			next = "J";
		} else if(q==12) {
			next = "Q";
		} else if(q==13) {
			next = "K";
		} else if(q==15) {
			next = "2";
		} else if(q==16) {
			next = "3";
		} else if(q==17) {
			next = "Done";
		} else {
			next = q + "";
		}
		
		
		
		return next;
	}
	
	
	
	@Override
	public String toString() {
		
		String s = "";
		
		int[] sizes = new int[4];
		
		sizes[0] = byone.size();
		sizes[1] = bytwo.size();
		sizes[2] = bythree.size();
		sizes[3] = byfour.size();
		Arrays.sort(sizes);
		
		
		
		
		for(int i=0;i<=sizes[3];i++) {
			String one = "";
			String two = "";
			String three = "";
			String four = "";
			
			try {
				one = byone.get(i).toString();
			} catch(IndexOutOfBoundsException e) {
				one = "\t";
			}
			
			try {
				two = bytwo.get(i).toString();
			} catch(IndexOutOfBoundsException e) {
				two = "\t";
			}
			
			try {
				three = bythree.get(i).toString();
			} catch(IndexOutOfBoundsException e) {
				three = "\t";
			}
			
			try {
				four = byfour.get(i).toString();
			} catch(IndexOutOfBoundsException e) {
				four = "\t";
			}
			

			
			s+=one + "\t\t" + two + "\t\t" + three + "\t\t" + four + "\t\n"/* + "-----------------------------------"
					+ "--------------------------------------------------------------\n"*/;
			
		}
		
		
		
		return s;
	}
	
	
}
