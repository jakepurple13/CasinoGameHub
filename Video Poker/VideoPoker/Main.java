package VideoPoker;

import Cards.Card;
import Cards.Deck;
import Cards.Hand;
import Cards.Suit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deck d = new Deck(true);
		Scores s = new Scores();
		Hand h = new Hand("Jacob");
		d.dealHand(h, 5);
		
		System.out.println(h);
		//System.out.println(s.pair(h));
		//System.out.println(s.threeOfAKind(h));
		//System.out.println(s.fourOfAKind(h));
		
		Card c = new Card(Suit.SPADES, 1);
		Card c1 = new Card(Suit.SPADES, 12);
		Card c2 = new Card(Suit.SPADES, 13);
		Card c3 = new Card(Suit.SPADES, 11);
		Card c4 = new Card(Suit.SPADES, 10);
		
		h.add(c);
		h.add(c1);
		h.add(c2);
		h.add(c3);
		h.add(c4);
		System.out.println(h);
		System.out.println(s.royalFlush(h));
		
		/*for(int i=1;i<14;i++) {
			h.clearHand();
			h.add(c);
			h.add(c1);
			h.add(c2);
			h.add(c3);
			Card c4 = new Card(Suit.SPADES, i);
			h.add(c4);
			System.out.println(h);
			System.out.println(s.twoPair(h));
		}*/
		int asdf = 0;
		for(int i=0;i<10000;i++) {
			
			//System.out.println(i + ".");
			h.clearHand();
			d.dealHand(h, 5);
			
			//System.out.println(h);
			/*if(s.flush(h)) {
				break;
			}*/
		/*	System.out.println(s.pair(h) + " :Pair");
			System.out.println(s.threeOfAKind(h) + " :Three of a Kind");
			System.out.println(s.fourOfAKind(h) + " :Four of a Kind");
			System.out.println(s.fullHouse(h) + " :Full House");
			System.out.println(s.flush(h) + " :Flush");
			System.out.println(s.straight(h) + " :Straight");
			System.out.println(s.twoPair(h) + " :Two Pair");
			System.out.println(s.straightFlush(h) + " :Straight Flush");
			System.out.println(s.royalFlush(h) + " :Royal Flush");
			System.out.println("-------------------");*/
			
			
			
			if(s.fourOfAKind(h)) {
				System.out.println(h);
				System.out.println(s.pair(h) + " :Pair");
				System.out.println(s.threeOfAKind(h) + " :Three of a Kind");
				System.out.println(s.fourOfAKind(h) + " :Four of a Kind");
				System.out.println(s.fullHouse(h) + " :Full House");
				System.out.println(s.flush(h) + " :Flush");
				System.out.println(s.straight(h) + " :Straight");
				System.out.println(s.twoPair(h) + " :Two Pair");
				System.out.println(s.straightFlush(h) + " :Straight Flush");
				System.out.println(s.royalFlush(h) + " :Royal Flush");
				System.out.println("-------------------");
				asdf = i;
				break;
			}
			
			if(d.deckCount()<5) {
				d = new Deck();
				d.shuffle(i);
				//System.out.println(i+"-------------------NEXT");
			}
			
		}
		
		System.out.println(s.getValues() + "\n" + asdf);
		
		
		
		
	}

}
