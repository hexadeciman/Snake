import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


class Window extends JFrame{
	private static final long serialVersionUID = -2542001418764869760L;
	public static ArrayList<ArrayList<DataOfSquare>> Grid;
	public static int width = 20;
	public static int height = 20;
	public Window(){
		
		
		// Creates the arraylist that'll contain the threads
		Grid = new ArrayList<ArrayList<DataOfSquare>>();
		ArrayList<DataOfSquare> data;
		
		// Creates Threads and its data and adds it to the arrayList
		for(int i=0;i<width;i++){
			data= new ArrayList<DataOfSquare>();
			for(int j=0;j<height;j++){
				DataOfSquare c = new DataOfSquare(2);
				data.add(c);
			}
			Grid.add(data);
		}
		
		// Setting up the layout of the panel
		getContentPane().setLayout(new GridLayout(20,20,0,0));
		
		// Start & pauses all threads, then adds every square of each thread to the panel
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				getContentPane().add(Grid.get(i).get(j).square);
			}
		}
		
		
		
		/*
		 * The below code makes a JOptionPane ask the user if he/she wants to play with
		 * one player or two player, and sets up the game accordingly.
		 */
		
		String[] options = {"One player" , "Two Players"};
		int playersSelected = JOptionPane.showOptionDialog(null, "Would you like to play single player or multiplayer?",
				"A Silly Question",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[1]);
		
		//If user selects "Two Player"
		if(playersSelected == 1){
			//Set up Player Two Controller
			Tuple position2 = new Tuple(13,13);
			ThreadsControllerPlayerTwo c2 = new ThreadsControllerPlayerTwo(position2);
			c2.start();
		}
		
		//If User selects "One Player" or exits out of JOptionPane, game starts with only one player
		
		
		// initial position of the snake
		Tuple position = new Tuple(10,10);
		// passing this value to the controller
		ThreadsController c = new ThreadsController(position);
		//Let's start the game now..
		c.start();

		// Links the window to the keyboardlistenner.
		this.addKeyListener((KeyListener) new KeyboardListener());
		
		
		/*TODO: 
		 * Problems With Multiplayer: 
		 * -When one player eats food, and then the other player eats food, the food completely disappears.
		 * -The two players can freely go through each other (no collision happens between two players).
		 *       This does not necessarily need to be fixed, but it would be interesting to allow 
		 *       players to make other players collide in order to win (like original snake of light cycle games).
		 *       This feature would also give more motivation to get the food (the more food you get,
		 *       the longer you are, the more of a chance you have of trapping opponent).
		 *       
		 *       If this feature is not implemented, an alternative would be to show a "scoreboard" on the 
		 *       right of the screen, and set a time limit to see which player can get most food 
		 *       (without colliding into itself).
		 */
		
		
	}
}
