package elevens;
import java.util.List;
import java.util.ArrayList;


/**
 * This class represents a Board that can be used in a collection
 * of solitaire games similar to Elevens.  The variants differ in
 * card removal and the board size.
 */
public abstract class Board 
{
    //The cards on this board.
    private Card[] cards;
    
    //the deck of cards being used to play the current game.
    private Deck deck;
    
    	/**
	 * Creates a new Board instance.
	 * size the number of cards in the board
	 * ranks the names of the card ranks needed to create the deck
	 * suits the names of the card suits needed to create the deck
	 * pointValues the integer values of the cards needed to create
	 * the deck
	 */
    public Board(int size, String[] ranks, String[] suits, int[] pointValues)
    {
        cards = new Card[size];
        deck = new Deck(ranks, suits, pointValues);
        dealMyCards();
    }
    
    //Start a new Game by shuffling the deck and dealing some cards to this board
    public void newGame()
    {
        deck.shuffle();
        dealMyCards();
    }
    
    
    //Accesses the size of the board.
    //Note this is not the number of cards it contains,
    //Which will be smaller near the end of a winning game.
    //Return the size of the board
    public int size()
    {
        return cards.length;
    }
    
    //Determines if the board is empty (has no cards).
    //return true if this board is empty; false otherwise.
    public boolean isEmpty()
    {
        for (int k = 0; k < cards.length; k++)
        {
            if (cards[k] != null)
            {
                return false;
            }
        }
        return true;
    }
    
    
    //Deal a card to the kth position in this board.
    //if the deck is empty, the kth card is set to null.
    //k the index of the card to be dealt.
    public void deal(int k)
    {
        cards[k] = deck.deal();
    }
    
    //Accesses the deck's size.
    //return the number of undealt cards left in the deck.
    public int deckSize()
    {
        return deck.size();
    }
    
    //Accesses a card on the board.
    //return the card at position k on the board.
    //k is the board position of the card to return.
    public Card cardAt(int k)
    {
        return cards[k];
    }
    
    //Replaces selected cards on the board by dealing new cards
    //selectedCards is a list of the indices of the cards to be replaced.
    public void replaceSelectedCards(List<Integer> selectedCards)
    {
        for (Integer k : selectedCards) 
        {
            deal(k.intValue());
	}
    }
    
    //Gets the indexes of the actual (non-null) cards on the board.
    public List<Integer> cardIndexes()
    {
        List<Integer> selected = new ArrayList<Integer>();
        for (int k = 0; k < cards.length; k++) 
        {
            if (cards[k] != null) 
            {
		selected.add(new Integer(k));
            }
	}
        return selected;
    }
    
    //Generates and returns a string representation of this board.
    //return the string version of this board.
    public String toString()
    {
        String s = "";
	for (int k = 0; k < cards.length; k++)
        {
            s = s + k + ": " + cards[k] + "\n";
	}
	return s;
    }
    
    /**
	 * Determine whether or not the game has been won,
	 * i.e. neither the board nor the deck has any more cards.
	 * @return true when the current game has been won;
	 *         false otherwise.
	 */
    public boolean gameIsWon() 
    {
	if (deck.isEmpty()) 
        {
            for (Card c : cards) 
            {
		if (c != null) 
                {
                    return false;
		}
            }
		return true;
	}
	return false;
    }
    
    
    /**
    * Method to be completed by the concrete class that determines
    * if the selected cards form a valid group for removal.
    * @param selectedCards the list of the indices of the selected cards.
    * @return true if the selected cards form a valid group for removal;
    *         false otherwise.
    */
	public abstract boolean isLegal(List<Integer> selectedCards);
        
    /**
    * Method to be completed by the concrete class that determines
    * if the selected cards form a valid group for removal.
    * @param selectedCards the list of the indices of the selected cards.
    * @return true if the selected cards form a valid group for removal;
    *         false otherwise.
    */
    public abstract boolean anotherPlayIsPossible();
    
    //Deal cards to this board to start the game.
    private void dealMyCards()
    {
        for (int k = 0; k < cards.length; k++)
        {
            cards[k] = deck.deal();
        }
    }
}
