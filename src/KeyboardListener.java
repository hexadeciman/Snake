import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

 public class KeyboardListener(){
 	
 	addKeyListener(new KeyAdapter(){
 		 		@Override
 		public void keyPressed(KeyEvent e){
 		    	switch(event.getKeyCode()){
	    	case 39:	//System.out.println("Right"); 
	    				if(ThreadsController.directionSnake!=2)
	    					ThreadsController.directionSnake=1;
	    			  	break;
	    	case 38:	//System.out.println("Top"); 
						if(ThreadsController.directionSnake!=4)
							ThreadsController.directionSnake=3;
	    				break;
	    				
	    	case 37: 	//System.out.println("Left"); 
						if(ThreadsController.directionSnake!=1)
							ThreadsController.directionSnake=2;
	    				break;
	    				
	    	case 40:	//System.out.println("Bottom"); 
						if(ThreadsController.directionSnake!=3)
							ThreadsController.directionSnake=4;
	    				break;
	    	default: 	break;
 		    	}
 		}
 	});
 }
