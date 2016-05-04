package Cards;




// TODO: Auto-generated Javadoc
/**
 * The Enum Suit.
 */
public enum Suit {
	
	/** The hearts. */
	HEARTS("Hearts", "H"), 
	
	/** The diamonds. */
	DIAMONDS("Diamonds", "D"),
	
	/** The clubs. */
	CLUBS("Clubs", "C"),
	
	/** The spades. */
	SPADES("Spades", "S");
	
	/** The printablename. */
	private String printablename;
	
	/** The symbol. */
	private String symbol;
	
	
	/**
	 * Instantiates a new suit.
	 *
	 * @param printablename the printablename
	 * @param symbol the symbol
	 */
	private Suit(String printablename, String symbol) {
		this.printablename = printablename;
		this.symbol = symbol;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return printablename;
	}
	
	/**
	 * Gets the symbol.
	 *
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	
}
