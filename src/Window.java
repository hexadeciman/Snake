import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;


class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2542001418764869760L;
	public static ArrayList<ArrayList<ThreadSquare>> Threads;
	public static int width = 20;
	public static int height = 20;
	public Window(){
		
		
		// Creates the arraylist that'll contain the threads
		Threads = new ArrayList<ArrayList<ThreadSquare>>();
		ArrayList<ThreadSquare> data;
		
		// Creates Threads and its data and adds it to the arrayList
		for(int i=0;i<width;i++){
			data= new ArrayList<ThreadSquare>();
			for(int j=0;j<height;j++){
				DataOfSquare c;
				c= new DataOfSquare(2);
				data.add(new ThreadSquare(c));
			}
			Threads.add(data);
		}
		
		// Setting up the layout of the panel
		getContentPane().setLayout(new GridLayout(20,20,0,0));
		
		// Start & pauses all threads, then adds every square of each thread to the panel
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				Threads.get(i).get(j).start();
				Threads.get(i).get(j).pauseThread();
				getContentPane().add(Threads.get(i).get(j).square.square);
			}
		}
		
		// initial position of the snake
		Tuple position = new Tuple(10,10);
		// passing this value to the controller
		ControlleurThreads c = new ControlleurThreads(position);
		//Let's start the game now..
		c.start();

		// Links the window to the keyboardlistenner.
		this.addKeyListener(new KeyboardListenner());

		//To do : handle multiplayers .. The above works, test it and see what happens
		
		//Tuple position2 = new Tuple(13,13);
		//ControlleurThreads c2 = new ControlleurThreads(position2);
		//c2.start();
		
	}
}
