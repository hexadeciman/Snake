import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

 public class KeyboardListener extends KeyAdapter{
 	
 		public void keyPressed(KeyEvent e){
 		    switch(e.getKeyCode()){
		    	case 39:	// -> Right 
		    				//if it's not the opposite direction
		    				if(ThreadsController.snakeDirection!=SnakeDirections.LEFT)
		    					ThreadsController.snakeDirection=SnakeDirections.RIGHT;
		    			  	break;
		    	case 38:	// -> Top
							if(ThreadsController.snakeDirection!=SnakeDirections.DOWN)
								ThreadsController.snakeDirection=SnakeDirections.UP;
		    				break;
		    				
		    	case 37: 	// -> Left 
							if(ThreadsController.snakeDirection!=SnakeDirections.RIGHT)
								ThreadsController.snakeDirection=SnakeDirections.LEFT;
		    				break;
		    				
		    	case 40:	// -> Bottom
							if(ThreadsController.snakeDirection!=SnakeDirections.UP)
								ThreadsController.snakeDirection=SnakeDirections.DOWN;
		    				break;
		    	
		    	default: 	break;
 		    }
 		}
 	
 }
