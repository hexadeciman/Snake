import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

 public class KeyboardListenner implements KeyListener{//1:right 2:left 3:top 4:bottom 0:nothing
	 
    public void keyPressed(KeyEvent event) {
    	
    	switch(event.getKeyCode()){
	    	case 39:	//System.out.println("Right"); 
	    				if(ControlleurThreads.directionSnake!=2)
	    					ControlleurThreads.directionSnake=1;
	    			  	break;
	    	case 38:	//System.out.println("Top"); 
						if(ControlleurThreads.directionSnake!=4)
							ControlleurThreads.directionSnake=3;
	    				break;
	    				
	    	case 37: 	//System.out.println("Left"); 
						if(ControlleurThreads.directionSnake!=1)
							ControlleurThreads.directionSnake=2;
	    				break;
	    				
	    	case 40:	//System.out.println("Bottom"); 
						if(ControlleurThreads.directionSnake!=3)
							ControlleurThreads.directionSnake=4;
	    				break;
	    	default: 	break;
	    				
    	}
    }
    
    //methods that needs to be here because I implemented KeyListenner
    public void keyReleased(KeyEvent event) {}
    public void keyTyped(KeyEvent event) {}
}   