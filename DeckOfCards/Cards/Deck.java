package Cards;




import java.util.ArrayList;
import java.util.Random;



// TODO: Auto-generated Javadoc
/**
 * The Class Deck.
 */
public class Deck {

	//var
	/** The mydeck. */
	private ArrayList<Card> mydeck;
	
	//con
	
	
	/**
	 * A Deck of Cards, unshuffled.
	 */
	public Deck() {
		mydeck = new ArrayList<Card>();
			for(int Q=0;Q<13;Q++) {
				mydeck.add(new Card(Suit.SPADES, Q+1));
				mydeck.add(new Card(Suit.CLUBS, Q+1));
				mydeck.add(new Card(Suit.DIAMONDS, Q+1));
				mydeck.add(new Card(Suit.HEARTS, Q+1));

		}
		
	}
	
	/**
	 * A Deck of Cards, unshuffled.
	 *
	 * @param number number of decks in one deck
	 */
	public Deck(int number) {
		mydeck = new ArrayList<Card>();
		for(int i=0;i<number;i++) {
			initialize();
		}
		
	}
	
	
	/**
	 * A Deck of Cards, shuffled.
	 *
	 * @param number number of decks in one deck
	 * @param shuffler the shuffler
	 */
	public Deck(int number, boolean shuffler) {
		mydeck = new ArrayList<Card>();
		for(int i=0;i<number;i++) {
			initialize();
			shuffle();
		}
		shuffle();
	}
	
	
	
	/**
	 * A Deck of Cards, shuffled.
	 *
	 * @param shuffler the shuffler
	 */
	public Deck(boolean shuffler) {
			mydeck = new ArrayList<Card>();
			initialize();
			shuffle();
	}
	
	private void initialize() {
		//mydeck = new ArrayList<Card>();
		for(int Q=0;Q<13;Q++) {
			mydeck.add(new Card(Suit.SPADES, Q+1));
			mydeck.add(new Card(Suit.CLUBS, Q+1));
			mydeck.add(new Card(Suit.DIAMONDS, Q+1));
			mydeck.add(new Card(Suit.HEARTS, Q+1));

		}
	}
	
	
	/**
	 * A Deck of Cards, shuffled.
	 *
	 * @param shuffler true if you want to shuffle, false if you do not
	 * @param seed the seed for shuffling
	 */
	public Deck(boolean shuffler, long seed) {
		mydeck = new ArrayList<Card>();
			initialize();
			if(shuffler) {
				shuffle(seed);
			}
		
	}

	//meth
	
	/**
	 * Draws a card.
	 *
	 * @return Card
	 */
	
	public Card draw() {
		return mydeck.remove(0);
	}
	
	
	/**
	 * Draws a random card from the deck.
	 *
	 * @return Card
	 */
	public Card getRandomCard() {
		Random gen = new Random();
		return mydeck.remove(gen.nextInt(deckCount()-1));
	}
	
	
	/**
	 * Draws a random card from the deck.
	 *
	 * @param n The place where the card is drawn
	 * @return Card
	 */
	public Card getRandomCard(int n) {
		return mydeck.remove(n);
	}
	
	
	
	/**
	 * Adds a card to the deck.
	 *
	 * @param c Card
	 */
	public void addCard(Card c) {
		mydeck.add(c);
	}
	
	
	/**
	 * Gets the card you want.
	 *
	 * @param s Suit
	 * @param v Value
	 * @return Your Card
	 */
	public Card getCard(Suit s, int v) {
		
		Card c = null;
		int i=0;
		Card check = new Card(s,v);
		//int q = deckCount();
		while(c==null || i>=deckCount()) {
			Card z = null;
			try {
				z = mydeck.get(i);
			} catch(IndexOutOfBoundsException e) {
				
				try {
					throw new CardNotFoundException("Could not find your card.");
				} catch (CardNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			//System.out.println(z);
			if(z.compareTo(check)==0 && z.getSuits().equals(check.getSuits())) {
				c = z;
				mydeck.remove(i);
			}
			
			i++;
			
		}
		
		
		
		
		return c;
	}
	
	
	/**
	 * Gets the first card by Value.
	 *
	 * @param v Value of Card
	 * @return the first card by Value
	 */
	public Card getFirstCardByValue(int v) {
		
		Card c = null;
		int i=0;
		Card check = new Card(Suit.SPADES,v);
		
		while(c==null || i>=52) {
			
			Card z = mydeck.get(i);
			//System.out.println(z);
			if(z.compareTo(check)==0) {
				c = z;
				mydeck.remove(i);
			}
			
			i++;
		}
		
		
		return c;
	}
	
	

    /**
     * Gets the first card by suit.
     *
     * @param s Suit
     * @return the first card by suit
     */
	public Card getFirstCardBySuit(Suit s) {
		
		Card c = null;
		int i=0;
		Card check = new Card(s,13);
		
		while(c==null || i>=52) {
			
			Card z = mydeck.get(i);
			//System.out.println(z);
			if(z.equals(check)) {
				c = z;
				mydeck.remove(i);
			}
			
			i++;
		}
		
		
		return c;
	}
	
	/**
	 * Shuffles the deck.
	 */
	public void shuffle() {
		
		Random gen = new Random();
		
		for(int i=0;i<200;i++) {
			mydeck.add(mydeck.remove(gen.nextInt(mydeck.size())));
		}

	}
	
	/**
	 * Shuffles the deck.
	 *
	 * @param seed for generation
	 */
	public void shuffle(long seed) {
		
		Random gen = new Random(seed);
		
		for(int i=0;i<200;i++) {
			mydeck.add(mydeck.remove(gen.nextInt(mydeck.size())));
		}

	}
	
	
	
	/**
	 * The Deck.
	 *
	 * @return The remaining contents of the deck
	 */
	@Override
	public String toString() {
		String temp = "";
		for(int i=0;i<mydeck.size();i++) {
			temp += mydeck.get(i);
		}
		
		return temp;
	}
	
	
	/**
	 * The size of the deck.
	 *
	 * @return The size of the deck (int)
	 */
	public int deckCount() {
		return mydeck.size();
	}
	
	
	/**
	 * Deals n number of cards to hand
	 *
	 * @param h the hand
	 * @param n the number of cards to add to the hand
	 * 
	 * 
	 */
	public void dealHand(Hand h, int n) {
		for(int i=0;i<n;i++) {
			h.add(draw());
		}
	}
	
	/**
	 * Compares two suits
	 *
	 * @param c Card
	 * @param c2 Card
	 * 
	 * 
	 */
	public static boolean compareSuit(Card c, Card c2) {
		return c.compareSuit(c2);
	}
	
	
	
	
	
}