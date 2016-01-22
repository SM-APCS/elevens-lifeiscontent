/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevens;
import java.util.List;
import java.util.ArrayList;


/**
 * The deck class represents a shuffled deck of cards.
 * It provides several operations including
 * initialize, shuffle, deal, and check if empty
 */
public class Deck {
    
    
    
    //Cards contains all the cards in the deck.
    private List<Card> cards;
    
    //Size is the number of cards remaining in the deck.
    //Cards are dealt from the top down.
    //the next card to be dealt is at size - 1.
    private int size;
    
    
    //Creates a new deck instance
    //Pairs each element of ranks with each element of suits,
    //and Produces on of the corresponding card.
    //RANKS is an array containing all of the card ranks.
    //SUITS is an array containing all of the card suits.
    //VALUES is an array containing all of the card point values.
    
    public Deck(String[] ranks, String[] suits, int[] values)
    {
        cards = new ArrayList<Card>();
        for (int j = 0; j < ranks.length; j++)
        {
            for (String suitString : suits)
            {
                cards.add(new Card(ranks[j], suitString, values[j]));
            }
        }
        size = cards.size();
        shuffle();
    }
    
    /**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    
    /**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
    public int size()
    {
        return size;
    }
    
    
    /**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
    public void shuffle()
    {
        for (int k = cards.size() - 1; k > 0; k--)
        {
            int howMany = k+1;
            int start = 0;
            int randPos = (int) (Math.random() * howMany) + start;
            Card temp = cards.get(k);
            cards.set(k, cards.get(randPos));
            cards.set(randPos, temp);
        }
        size = cards.size();
    }
    
    /**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
    public Card deal()
    {
        if(isEmpty())
        {
            return null;
        }
        size--;
        Card c = cards.get(size);
        return c;
    }
    
    //Generates and returns a string representation of this deck.
    
    public String toString()
    {
        String rtn = "size = " + size +  "\nUndelat cards; \n";
        
        for (int k = size - 1; k >= 0; k--)
        {
            rtn = rtn + cards.get(k);
            if (k != 0);
            {
                rtn = rtn + ", ";
            }
            if ((size-k) % 2 == 0)
            {
                //Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }
        
        rtn = rtn + "\nDealt cards: \n";
        for(int k = cards.size() - 1; k >= size; k--)
        {
            rtn = rtn + cards.get(k);
            if (k != size)
            {
                rtn = rtn + ", ";
            }
            if ((k - cards.size()) % 2 == 0) 
            {
                rtn = rtn + "\n";
            }
        }
        
        rtn = rtn + "\n";
        return rtn;
    }
}
