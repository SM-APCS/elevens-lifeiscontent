package elevens;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class ElevensGUIRunner {
    
    
    //Plays the GUI version of Elevens.
    public static void main(String[] args) {
		Board board = new ElevensBoard();

                CardGameGUI gui = new CardGameGUI(board);
                
                gui.displayGame();
	}
}
