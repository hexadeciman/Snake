import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

 public class KeyboardListener extends KeyAdapter{
 	
 		public void keyPressed(KeyEvent e){
 		    switch(e.getKeyCode()){
		    	case 39:	// -> Right 
		    				//if it's not the opposite direction
		    				if(ThreadsController.directionSnake!=Directions.LEFT)
		    					ThreadsController.directionSnake= Directions.RIGHT;
		    			  	break;
		    	case 38:	// -> Top
							if(ThreadsController.directionSnake!= Directions.UP)
								ThreadsController.directionSnake= Directions.DOWN;
		    				break;
		    				
		    	case 37: 	// -> Left 
							if(ThreadsController.directionSnake!= Directions.RIGHT)
								ThreadsController.directionSnake= Directions.LEFT;
		    				break;
		    				
		    	case 40:	// -> Bottom
							if(ThreadsController.directionSnake!= Directions.DOWN)
								ThreadsController.directionSnake= Directions.UP;
		    				break;
				case 82:
					Main.getWindow().dispose();
					Window f1= new Window();

					//Setting up the window settings
					f1.setTitle("Snake");
					f1.setSize(300,300);
					f1.setVisible(true);
					f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Main.setWindow(f1);
				default:
							System.out.println(e.getKeyCode());
					break;
 		    }
 		}
 	
 }
