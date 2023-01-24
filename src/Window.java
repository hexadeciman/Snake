package snakegame;

import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;


class Window extends JFrame{
	private static final long serialVersionUID = -2542001418764869760L;
	public static ArrayList<ArrayList<DataOfSquare>> Grid;
	int width=settingsMenu.blockWidthI;
	int height = settingsMenu.blockHeightI;
	public Window(){
		
		
		// Creates the arraylist that'll contain the threads
		Grid = new ArrayList<ArrayList<DataOfSquare>>();
		ArrayList<DataOfSquare> data;
		
		// Creates Threads and its data and adds it to the arrayList
		for(int i=0;i<width;i++){
			data= new ArrayList<DataOfSquare>();
			for(int j=0;j<height;j++){
                            if (settingsMenu.wallsOn && (i == 0 || i == width -1 || j ==0 || j == height -1)){ //this line selected the location of the walls
                                   DataOfSquare c = new DataOfSquare(0); //this changed the color of those areas to black
				   data.add(c);// set input those colors into "data", an array containing the color of all squares.
                                 }
                            else {
				   DataOfSquare c = new DataOfSquare(2);
				   data.add(c);
                            }
			}
                        Grid.add(data);
		}
		
		// Setting up the layout of the panel
		getContentPane().setLayout(new GridLayout(height,width,0,0));
		
		// Start & pauses all threads, then adds every square of each thread to the panel
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				getContentPane().add(Grid.get(i).get(j).square);
			}
		}
		
		// initial position of the snake
		Tuple position = new Tuple(10,10);
		// passing this value to the controller
		ThreadsController c = new ThreadsController(position);
		//Let's start the game now..
		c.start();
                
		// Links the window to the keyboardlistenner.
		this.addKeyListener((KeyListener) new KeyboardListener());

		//To do : handle multiplayers .. The above works, test it and see what happens
		
		//Tuple position2 = new Tuple(13,13);
		//ControlleurThreads c2 = new ControlleurThreads(position2);
		//c2.start();
		
	}
}
