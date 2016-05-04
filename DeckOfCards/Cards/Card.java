package Cards;




import javax.swing.ImageIcon;



// TODO: Auto-generated Javadoc
/**
 * The Class Card.
 */
public class Card implements Comparable<Card> {

		///var
		/** The suits. */
		private Suit suits;
		
		/** The value. */
		private int value;
		
		
		//con
		
		
		/**
		 * Instantiates a new card.
		 *
		 * @param suit the suit
		 * @param values the values
		 */
		public Card(Suit suit, int values) {
			
			value = values;
			suits = suit;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			if(this.value == 1) {
				return "Ace of " + getSuits();
			} else if(this.value == 11) {
				return "Jack of " + getSuits();
			} else if(this.value == 12) {
				return "Queen of " + getSuits();
			} else if(this.value == 13) {
				return "King of " + getSuits();
			}
			return this.value + " of " + getSuits();
		}


		/**
		 * Gets the suits.
		 *
		 * @return the suits
		 */
		public Suit getSuits() {
			
			return suits; //suits;
		}
		
		
		/**
		 * Gets the value ten.
		 *
		 * @return the value ten
		 */
		public int getValueTen() {
			if(value > 10) {
				return 10;
			} else {
				return value;
			}
		}
		
		/**
		 * Gets the value.
		 *
		 * @return the value
		 */
		public int getValue() {
			
				return value;
			
		}
		
		/**
		 * Ace.
		 */
		public void ace() {
			if(value == 1) {
				value = 11;
			}
				
				
				
			 //value;
		}
		
		
			
			
		
		/**
		 * Compares the values of the two cards.
		 *
		 * @param c the c
		 * @return 1 if this is greater than c<p>-1 if c is greater than this<p>0 if this is equal to c
		 */
		@Override
		public int compareTo(Card c) {
			// TODO Auto-generated method stub
			if(value > c.value) {
				return 1;
			} else if(value < c.value) {
				return -1;
			} else if (value == c.value){
				return 0;
			}
			return value;
		}
		
		/**
		 * Compares the Suits of this and c.
		 *
		 * @param c the c
		 * @return true if the two cards have the same suit<p>false if the two cards don't have the same suit
		 */
		public boolean equals(Card c) {
			
			if(suits==c.getSuits()) {
				return true;
			} else {
				return false;
			}
			
		}
		
		
		/**
		 * Gives the card image.
		 *
		 * @return ImageIcon
		 */
		public ImageIcon getImage() {
			ImageIcon q;
			int num = 0;
			if(suits==Suit.CLUBS) {
				num+=1;
			} else if(suits==Suit.SPADES) {
				num+=2;
			} else if(suits==Suit.HEARTS) {
				num+=3;
			} else if(suits==Suit.DIAMONDS) {
				num+=4;
			}
		        
		        switch (value) {
		            case 1:  //q = new ImageIcon("/DeckOfCards/src/images/"+num+".png");
		            		 //q = new ImageIcon("/Users/Jacob/Documents/college/DeckOfCards/src/images/"+num+".png");
		            		 q = new ImageIcon(getClass().getResource(num+".png"));
		            		 break;
		            case 2:  //q = new ImageIcon("/DeckOfCards/src/images/"+(48+num)+".png");
		            		 q = new ImageIcon(getClass().getResource((48+num)+".png"));
		                     break;
		            case 3:  //q = new ImageIcon("/DeckOfCards/src/images/"+(44+num)+".png");
		            		 q = new ImageIcon(getClass().getResource((44+num)+".png"));
		                     break;
		            case 4:  //q = new ImageIcon("/DeckOfCards/src/images/"+(41+num)+".png");
		            		 q = new ImageIcon(getClass().getResource((40+num)+".png"));
		                     break;
		            case 5:  //q = new ImageIcon("/DeckOfCards/src/images/"+(37+num)+".png");
		            		 q = new ImageIcon(getClass().getResource((36+num)+".png"));
		                     break;
		            case 6:  //q = new ImageIcon("/DeckOfCards/src/images/"+(33+num)+".png");
		            		 q = new ImageIcon(getClass().getResource((32+num)+".png"));
		                     break;
		            case 7:  //q = new ImageIcon("/DeckOfCards/src/images/"+(29+num)+".png");
		            	 	 q = new ImageIcon(getClass().getResource((28+num)+".png"));
		                     break;
		            case 8:  //q = new ImageIcon("/DeckOfCards/src/images/"+(24+num)+".png");
		            		 q = new ImageIcon(getClass().getResource((24+num)+".png"));
		                     break;
		            case 9:  //q = new ImageIcon("/DeckOfCards/src/images/"+(20+num)+".png");
		            		 q = new ImageIcon(getClass().getResource((20+num)+".png"));
		                     break;
		            case 10: //q = new ImageIcon("/DeckOfCards/src/images/"+(16+num)+".png");
		            		 q = new ImageIcon(getClass().getResource((16+num)+".png"));
		                     break;
		            case 11: //q = new ImageIcon("/DeckOfCards/src/images/"+(12+num)+".png");
		            		 q = new ImageIcon(getClass().getResource((12+num)+".png"));
		            		 break;
		            case 12: //q = new ImageIcon("/DeckOfCards/src/images/"+(8+num)+".png");
		            		 q = new ImageIcon(getClass().getResource((8+num)+".png"));
		                     break;
		            case 13: //q = new ImageIcon("/DeckOfCards/src/images/"+(4+num)+".png");
		            		 q = new ImageIcon(getClass().getResource((4+num)+".png"));
		            		 break;
		            default: q = new ImageIcon("/DeckOfCards/src/images/b1fv.png");
		                     break;
		        }
			
		        
			
			return q;
		}
		
		
		/**
		 * The color of the suit
		 *
		 *
		 * @return The color of the suit of this card. Black is true, red is false.
		 */
		public String getColor() {
			
			if(suits==Suit.SPADES || suits==Suit.CLUBS) {
				return "Black";
			} else if(suits==Suit.DIAMONDS || suits==Suit.HEARTS) {
				return "Red";
			}
			
			return "Transparent";
		}
			
		
		public boolean compareSuit(Card c) {
			
			if(suits==c.getSuits()) {
				return true;
			} else {
				return false;
			}
			
		}
		
		
		public boolean compareColor(Card c) {
			
			if(getColor().equals(c.getColor())) {
				return true;
			} else {
				return false;
			}
			
		}
		
	
	
}
