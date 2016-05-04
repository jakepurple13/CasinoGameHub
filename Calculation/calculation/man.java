package calculation;


import Cards.Card;
import Cards.Deck;

import java.util.ArrayList;
import java.util.Scanner;



public class man {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		/*Deck q = new Deck(true);
		Card c = q.getCard(Suit.SPADES, 5);
		Card c1 = q.getFirstCardBySuit(Suit.SPADES, 0);
		Card c2 = q.getFirstCardByValue(null, 13);
		System.out.println(c+"\t"+q.deckCount());
		System.out.println(c1+"\t"+q.deckCount());
		System.out.println(c2+"\t"+q.deckCount());
		for(int i=0;i<q.deckCount();i++) {
			System.out.println(q.draw());
		}
		System.out.println();
		System.out.println();
		System.out.println();
		*/
		
		Deck d = new Deck(true);
		
		Card one = d.getFirstCardByValue(1);
		Card two = d.getFirstCardByValue(2);
		Card three = d.getFirstCardByValue(3);
		Card four = d.getFirstCardByValue(4);
		
		Stockpile s = new Stockpile(one, two, three, four);
		Holding h = new Holding();
		
		
		
		Scanner s1 = new Scanner(System.in);
		
		
		
		while(d.deckCount()!=0 || !h.isEmpty()) {
			
			 
					
					
					
			System.out.println("--------------------------------------------------------------------");
			System.out.println(s);
			System.out.println("----------------------------------");
			System.out.println(h);
			
			
			if(d.deckCount()!=0) {
			
				System.out.println("Type 'Draw' or 'd' to draw a card or type 'a to b' where 'a' is a number between 5-8"
						+ " and 'b' is a number between 1-4."
						+ "\nOr type in 'Order' to see the order.\n"
						+ "If you do not think that the deck is shuffled enough, type in 'Shuffle' to shuffle the deck.");
			} else {
				
				System.out.println("Type 'a to b' where 'a' is a number between 5-8"
						+ " and 'b' is a number between 1-4."
						+ "\nOr type in 'Order' to see the order.\n"
						+ "If you do not think that the deck is shuffled enough, type in 'Shuffle' to shuffle the deck.");
				
			}
			
			String qwe = s1.nextLine();
			
			Card z = null;
			int a = 0;// = Integer.parseInt(qwe.substring(0, 1));
			if(qwe.contains("to")) {
				int b = Integer.parseInt(qwe.substring(qwe.length()-1, qwe.length()));
				a = Integer.parseInt(qwe.substring(0, 1));
				
				ArrayList<Card> g = new ArrayList<Card>();
				
				if(a==5) {
					g = h.getOne();
				} else if(a==6) {
					g = h.getTwo();
				} else if(a==7) {
					g = h.getThree();
				} else if(a==8) {
					g = h.getFour();
				}
				
				if(!h.isEmpty()) {
					
				
				if(b==1) {
					s.intoOne(g);
				} else if(b==2) {
					s.intoTwo(g);
				} else if(b==3) {
					s.intoThree(g);
				} else if(b==4) {
					s.intoFour(g);
				}
				
				} else {
					System.out.println("Nothing is in there.");
				}
				
				
				
			} else if(qwe.equalsIgnoreCase("Draw") || qwe.equalsIgnoreCase("d")) {
				z = d.draw();
				while(z!=null) {
					try {
				System.out.println("Enter Pile for " + z + ":");
				
				qwe = s1.nextLine();
				a = Integer.parseInt(qwe.substring(0, 1));
				
				if(a==9) {
					d.addCard(z);	
					z=null;
					System.out.println("Card added back to deck.");
				} else if(a==1) {
					if(s.add1(z)) {
						//d.addCard(z);
						//System.out.println("Card added back to deck");
						z = null;
					}
				} else if(a==2) {
					if(s.add2(z)) {
						//d.addCard(z);
						//System.out.println("Card added back to deck");
						z = null;
					}
				} else if(a==3) {
					if(s.add3(z)) {
						//d.addCard(z);
						//System.out.println("Card added back to deck");
						z = null;
					}
				} else if(a==4) {
					if(s.add4(z)) {
						//d.addCard(z);
						//System.out.println("Card added back to deck");
						z = null;
					}
				} else if(a==5) {
					h.adda(z);
					z = null;
				} else if(a==6) {
					h.addb(z);
					z = null;
				} else if(a==7) {
					h.addc(z);
					z = null;
				} else if(a==8) {
					h.addd(z);
					z = null;
				}
					} catch(Exception e) {
						
					}
				}
			} else if(qwe.equalsIgnoreCase("Order")) {
				System.out.println("A|	2	3	4	5	6	7	8	9	10	J	Q	K\n" +
									"2|	4	6	8	10	Q	A	3	5	7	9	J	K\n" +
									"3|	6	9	Q	2	5	8	J	A	4	7	10	K\n" +
									"4|	8	Q	3	7	J	2	6	10	A	5	9	K\n");
			} else if(qwe.equalsIgnoreCase("Shuffle")) {
				d.shuffle();
				System.out.println("The deck has been shuffled.");
			}
			
			/*System.out.println(s);
			System.out.println("----------------------------------");
			System.out.println(h);*/
		
		}
		
		//Put win condition here!
		if(man.win(s)) {
			System.out.println("YOU WIN!!!!!");
		} else {
			System.out.println("You lose.");
		}
		
		
		System.out.println();
		
		
		
		
		System.out.println(s);
		
		System.out.println(s.getSizeOfPile(1));
		System.out.println(s.getSizeOfPile(2));
		System.out.println(s.getSizeOfPile(3));
		System.out.println(s.getSizeOfPile(4));
		
		s1.close();
		
	}
	
	
	public static boolean win(Stockpile s) {
		
		boolean won = true;
		
		if(s.get1().getValue()!=13) {
			won = false;
		}
		
		if(s.get2().getValue()!=13) {
			won = false;
		}
		
		if(s.get3().getValue()!=13) {
			won = false;
		}
		
		if(s.get4().getValue()!=13) {
			won = false;
		}
		
		
		
		
		return won;
	}
	

}
