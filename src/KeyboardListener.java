import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

 public class KeyboardListener extends KeyAdapter{
 	
 		public void keyPressed(KeyEvent e){
 		    switch(e.getKeyCode()){
 		    
 		    //Player One Controls
		    	case 39:			// -> Right 
		    						//if it's not the opposite direction
		    						if(ThreadsController.directionSnake!=2) 
		    								ThreadsController.directionSnake=1;
		    							break;
		    	case 38:			// -> Top
									if(ThreadsController.directionSnake!=4) 
											ThreadsController.directionSnake=3;
										break;
		    				
		    	case 37: 			// -> Left 
									if(ThreadsController.directionSnake!=1)
											ThreadsController.directionSnake=2;
										break;
		    				
		    	case 40:			// -> Bottom
									if(ThreadsController.directionSnake!=3)
											ThreadsController.directionSnake=4;
										break;
										
			//Player Two Controls
		    				
		    case KeyEvent.VK_D:		// -> Player 2 Right
									if(ThreadsControllerPlayerTwo.directionSnake != 2)
											ThreadsControllerPlayerTwo.directionSnake = 1;
										break;				
										
			
		    case KeyEvent.VK_W:		// -> Player 2 Top
		    						if(ThreadsControllerPlayerTwo.directionSnake != 4)
		    								ThreadsControllerPlayerTwo.directionSnake = 3;
		    							break;
		    						
		    case KeyEvent.VK_A:		// -> Player 2 Left
									if(ThreadsControllerPlayerTwo.directionSnake != 1)
											ThreadsControllerPlayerTwo.directionSnake = 2;
										break;				
					

		    case KeyEvent.VK_S:		// -> Player 2 Bottom
									if(ThreadsControllerPlayerTwo.directionSnake != 3)
											ThreadsControllerPlayerTwo.directionSnake = 4;
										break;
		    	
		    	default: 	break;
 		    }
 		}
 	
 }
