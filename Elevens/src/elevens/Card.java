package elevens;
/**
 * Card.java
 *
 * <code>Card</code> represents a playing card.
 */
public class Card {

	/**
	 * String value that holds the suit of the card
	 */
	private String suit;

	/**
	 * String value that holds the rank of the card
	 */
	private String rank;

	/**
	 * int value that holds the point value.
	 */
	private int pointValue;


   /**
	 * Creates a new <code>Card</code> instance.
           containing the point value of the card
    */
	public Card(String cardRank, String cardSuit, int cardPointValue) {
		//initializes a new Card with the given rank, suit, and point value
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPointValue;
	}


	/**
	 * Accesses this suit.
	 * return the suit.
	 */
	public String suit() {
		return suit;
	}

	/**
	 * Accesses this rank.
	 * return this rank.
	 */
	public String rank() {
		return rank;
	}

   /**
	 * Accesses this point value.
	 * return this point value.
	 */
	public int pointValue() {
		return pointValue;
	}

	/** Compare this card with the argument.
	 * otherCard the other card to compare to this
	 * return TRUE if the rank, suit, and point value of this card
	 * are equal to those of the argument;
	 * FALSE otherwise.
	 */
	public boolean matches(Card otherCard) {
		return otherCard.suit().equals(this.suit())
			&& otherCard.rank().equals(this.rank())
			&& otherCard.pointValue() == this.pointValue();
	}

	/**
	 * Converts the rank, suit, and point value into a string in the format
	 *     "[Rank] of [Suit] (point value = [PointValue])".
	 * This provides a useful way of printing the contents
	 * of a Deck in an easily readable format or performing
	 * other similar functions.
	 *
	 * return a String containing the rank, suit,
	 *         and point value of the card.
	 */
	@Override
	public String toString() {
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
}
