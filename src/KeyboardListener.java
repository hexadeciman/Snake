import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

 public class KeyboardListener extends KeyAdapter{
 	
 		public void keyPressed(KeyEvent e){
 		    switch(e.getKeyCode()){
		    	case 39:	// -> Right 
		    				//if it's not the opposite direction
		    				if(ThreadsController.directionSnake!=2 && ThreadsController.ableToAcceptKeyPress){
								ThreadsController.directionSnake=1;
								ThreadsController.ableToAcceptKeyPress = false;
							}

		    			  	break;
		    	case 38:	// -> Top
							if(ThreadsController.directionSnake!=4 && ThreadsController.ableToAcceptKeyPress){
								ThreadsController.directionSnake=3;
								ThreadsController.ableToAcceptKeyPress = false;
							}

		    				break;
		    				
		    	case 37: 	// -> Left 
							if(ThreadsController.directionSnake!=1 && ThreadsController.ableToAcceptKeyPress){
								ThreadsController.directionSnake=2;
								ThreadsController.ableToAcceptKeyPress = false;
							}

		    				break;
		    				
		    	case 40:	// -> Bottom
							if(ThreadsController.directionSnake!=3 && ThreadsController.ableToAcceptKeyPress){
								ThreadsController.directionSnake=4;
								ThreadsController.ableToAcceptKeyPress = false;
							}

		    				break;
		    	
		    	default: 	break;
 		    }
 		}
 	
 }
