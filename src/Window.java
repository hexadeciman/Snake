import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class Window extends JFrame{
	private static final long serialVersionUID = -2542001418764869760L;
	public static ArrayList<ArrayList<DataOfSquare>> Grid;
	public static int width = 20;
	public static int height = 20;
	public static int currentSpeedLevel = 1;
	public static ThreadsController controller;
	public static Window instance;
	private JLabel speedLabel;
	public Window(){
		instance = this;
		
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

		this.setLayout(new BorderLayout());

		speedLabel = new JLabel("Speed: " + currentSpeedLevel);
        speedLabel.setFont(new Font("Arial", Font.BOLD, 18));
        speedLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 0));
        this.add(speedLabel, BorderLayout.NORTH);

		JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(20, 20, 0, 0));
		
		// // Setting up the layout of the panel
		// getContentPane().setLayout(new GridLayout(20,20,0,0));
		
		// Start & pauses all threads, then adds every square of each thread to the panel
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				gamePanel.add(Grid.get(i).get(j).square);
			}
		}

		this.add(gamePanel, BorderLayout.CENTER);
		
		// initial position of the snake
		Tuple position = new Tuple(10,10);
		// passing this value to the controller
		controller = new ThreadsController(position);
		//Let's start the game now..
		controller.start();

		// Links the window to the keyboardlistenner.
		this.addKeyListener((KeyListener) new KeyboardListener());

		//To do : handle multiplayers .. The above works, test it and see what happens
		
		//Tuple position2 = new Tuple(13,13);
		//ControlleurThreads c2 = new ControlleurThreads(position2);
		//c2.start();
		
	}
	
	public void updateSpeedLabel() {
        speedLabel.setText("Speed: " + currentSpeedLevel);
    }
	// @Override
    // public void paint(Graphics g) {
    //     super.paint(g);
    //     g.setColor(Color.BLACK);
    //     g.setFont(new Font("Arial", Font.BOLD, 18));
    //     g.drawString("Speed: " + currentSpeedLevel, 10, 25);
    // }
}
