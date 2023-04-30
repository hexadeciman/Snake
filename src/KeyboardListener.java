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
		    	
		    	default: 	break;
 		    }
 		}
 	
 }
