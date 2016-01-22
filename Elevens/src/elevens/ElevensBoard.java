/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevens;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class ElevensBoard extends Board {
    //the size of the board
    private static final int BOARD_SIZE = 9;
    
    //The ranks of the cards for this game to be sent to the deck.
    private static final String[] RANKS = {"ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "jack", "queen", "king"};
    
    //the suits of the cards for this game to be sent to the deck.
    private static final String[] SUITS = {"spades", "hearts", "diamonds",
        "clubs"};
    
    //The values of the cards for this game to be sent to the deck.
    private static final int[] POINT_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0,
        0, 0};
    
    //Creates a new ElevensBoard instance.
    public ElevensBoard()
    {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }
    
    /**
    * Determines if the selected cards form a valid group for removal.
    * In Elevens, the legal groups are (1) a pair of non-face cards
    * whose values add to 11, and (2) a group of three cards consisting of
    * a jack, a queen, and a king in some order.
    * @param selectedCards the list of the indices of the selected cards.
    * @return true if the selected cards form a valid group for removal;
    *         false otherwise.
    */

    public boolean isLegal(List<Integer> selectedCards)
    {
        if (selectedCards.size() == 2)
        {
            return containsPairSum11(selectedCards);
        } else if (selectedCards.size() == 3)
        {
            return containsJQK(selectedCards);
        } else {
            return false;
        }
    }
    
    /**
    * Determine if there are any legal plays left on the board.
    * In Elevens, there is a legal play if the board contains
    * (1) a pair of non-face cards whose values add to 11, or (2) a group
    * of three cards consisting of a jack, a queen, and a king in some order.
    * @return true if there is a legal play left on the board;
    *         false otherwise.
    */
    public boolean anotherPlayIsPossible()
    {
        List<Integer> cIndexes = cardIndexes();
        return containsPairSum11(cIndexes) || containsJQK(cIndexes);
    }
    
    /**
    * Look for an 11-pair in the selected cards.
    * @param selectedCards selects a subset of this board.  It is list
    *                      of indexes into this board that are searched
    *                      to find an 11-pair.
    * @return a list of the indexes of an 11-pair, if an 11-pair was found;
    *         an empty list, if an 11-pair was not found.
    */
    private boolean containsPairSum11(List<Integer> selectedCards)
    {
        for(int sk1 = 0; sk1 < selectedCards.size(); sk1++)
        {
            int k1 = selectedCards.get(sk1).intValue();
            for (int sk2 = sk1 + 1; sk2 < selectedCards.size(); sk2++)
            {
                int k2 = selectedCards.get(sk2).intValue();
                if (cardAt(k1).pointValue() + cardAt(k2).pointValue() == 11)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    //Look for a JQK in the selected cards.
    private boolean containsJQK(List<Integer> selectedCards)
    {
        boolean foundJack = false;
        boolean foundQueen = false;
        boolean foundKing = false;
        for (Integer kObj : selectedCards)
        {
            int k = kObj.intValue();
            if(cardAt(k).rank().equals("jack"))
            {
                foundJack = true;
            } 
            if (cardAt(k).rank().equals("queen"))
            {
                foundQueen = true;
            }
            if (cardAt(k).rank().equals("king"))
            {
                foundKing = true;
            }
        }
        return  foundJack && foundQueen && foundKing;
    }
}
