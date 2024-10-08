public class Tuple { 
	  protected  int x;
	  protected  int y;
	  
	  protected Tuple(int x, int y) {
	    this.x = x; 
	    this.y = y; 
	  } 
	  protected void ChangeData(int x, int y){
		    this.x = x; 
		    this.y = y; 
	  }
	  protected int getX(){
		  return x;
	  }
	  protected int getY(){
		  return y;
	  }
} 